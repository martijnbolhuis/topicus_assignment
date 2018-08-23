package hello;

import org.javalite.activejdbc.Base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.java.medicines.Medicine;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "bol1986");

        (new Medicine()).createIt("name", "Paracetamol");
        (new Medicine()).createIt("name", "Aspirine");


        SpringApplication.run(Application.class, args);
        Base.close();
    }
}
