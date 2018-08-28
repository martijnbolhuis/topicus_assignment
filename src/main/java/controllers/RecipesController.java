package controllers;

import models.Recipe;
import org.codehaus.jackson.map.ObjectMapper;
import org.javalite.activejdbc.Base;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class RecipesController {
    @RequestMapping(
        value = "/recipes",
        method = RequestMethod.POST
    )
    public String createRecipe(@RequestBody String payload){

        try {
            //NOTE: Configuring DB setting in database.properties does not work.
            if (!Base.hasConnection()) {
                Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "123456");
            }
            ObjectMapper mapper = new ObjectMapper();
            Recipe recipe = mapper.readValue(payload, Recipe.class);
            boolean success = recipe.saveIncludingRecipeMedicines();
            if (success){
                return "";
            } else {
                Map<String, String> errors = recipe.errors();
                return new ObjectMapper().writeValueAsString(errors);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Base.hasConnection()) {
                Base.close();
            }
        }

    }
}
