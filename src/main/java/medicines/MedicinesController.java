package medicines;


import hello.Greeting;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import main.java.medicines.Medicine;

import java.util.List;

@RestController
public class MedicinesController {

    @RequestMapping("/medicines")
    public String medicines() {
        Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "bol1986");

        LazyList<Medicine> personList = Medicine.findAll().orderBy("id");
        String json = personList.toJson(false);

        return json;
    }
}
