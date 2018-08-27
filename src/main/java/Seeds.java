
import models.Medicine;
import models.MedicineForm;
import org.javalite.activejdbc.Base;

public class Seeds {

    public static void main(String[] args) {
        Base.open("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/topicus_assignment", "martijn", "123456");

        // Paracetamol
        Medicine medicine1 = new Medicine().createIt("name", "Paracetamol 500mg");
        medicine1.add(new MedicineForm().createIt("name", "Tabletten", "package_amount", 3, "package_unit", "strip", "content_amount", 10, "content_unit", "tablets"));
        medicine1.add(new MedicineForm().createIt("name", "Poeder", "package_amount", 1, "package_unit", "bottle", "content_amount", 100, "content_unit", "ml"));

        Medicine medicine2 = new Medicine().createIt("name", "Broomhexine");
        medicine2.add(new MedicineForm().createIt("name", "Drank 0,8mg/ml", "package_amount", 1, "package_unit", "bottle", "content_amount", 200, "content_unit", "ml"));

        Medicine medicine3 = new Medicine().createIt("name", "Chlooramfenicol");
        medicine3.add(new MedicineForm().createIt("name", "oogdruppels 5mg/ml", "package_amount", 1, "package_unit", "bottle", "content_amount", 200, "content_unit", "ml"));

        Base.close();
    }
}
