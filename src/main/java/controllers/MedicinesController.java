package controllers;

import models.MedicineForm;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import models.Medicine;

@RestController
public class MedicinesController {

    @RequestMapping("/medicines")
    public String medicines() {
        //NOTE: Configuring DB setting in database.properties does not work.
        if (!Base.hasConnection()){
            Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "123456");
        }
        LazyList<Medicine> medicineList = Medicine.findAll().include(MedicineForm.class).orderBy("id");
        String json = medicineList.toJson(false);

        return json;
    }
}
