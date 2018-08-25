package controllers;

import models.Recipe;
import org.codehaus.jackson.map.ObjectMapper;
import org.javalite.activejdbc.Base;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RecipesController {
    @RequestMapping(
        value = "/recipes",
        method = RequestMethod.POST
    )
    public void createRecipe(@RequestBody String payload){
        //NOTE: Configuring DB setting in database.properties does not work.
        Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "bol1986");
        ObjectMapper mapper = new ObjectMapper();

        try {
            Recipe recipe = mapper.readValue(payload, Recipe.class);
            recipe.saveIncludingRecipeMedicines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
