
import models.Medicine;
import models.Package;
import org.javalite.activejdbc.Base;

public class Seeds {

    public static void main(String[] args) {
        Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "bol1986");

        // Paracetamol
        Medicine medicine1 = new Medicine().createIt("name", "Paracetamol 500mg");
        medicine1.add(new Package().createIt("name", "Tabletten", "package_amount", 3, "package_unit", "strip", "content_amount", 10, "content_unit", "tablets"));
        medicine1.add(new Package().createIt("name", "Poeder", "package_amount", 1, "package_unit", "bottle", "content_amount", 100, "content_unit", "ml"));

        Base.close();
    }
}