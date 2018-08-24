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
    public void createRecipe(@RequestBody String payload){

        ObjectMapper mapper = new ObjectMapper();

        try {
            Recipe recipe = new Recipe();
            recipe.fromMap(mapper.readValue(payload, Map.class));

        } catch (IOException e) { throw new RuntimeException(e); }



        System.out.println(payload);

    }
}
