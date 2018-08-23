import org.javalite.activejdbc.Base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import medicines.MedicinesController;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses=MedicinesController.class)
public class Application {

    public static void main(String[] args) {
        Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "bol1986");

//        (new Medicine()).createIt("name", "Paracetamol");
//        (new Medicine()).createIt("name", "Aspirine");


        SpringApplication.run(Application.class, args);
        Base.close();
    }
}
