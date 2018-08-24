package models;

import org.codehaus.jackson.annotate.JsonProperty;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

import java.util.ArrayList;
import java.util.Date;

public class Recipe extends Model {

    private RecipeMedicine[] recipeMedicinesToSave;

    @JsonProperty("end_date")
    public Date getEndDate() {
        return getDate("end_date");
    }

    @JsonProperty("end_date")
    public void setEndDate(Date endDate) {
        setDate("end_date", endDate);
    }

    @JsonProperty("bsn_number")
    public String getBsnNumber() {
        return getString("bsn_number");
    }

    @JsonProperty("bsn_number")
    public void setBsnNumber(String bsnNumber) {
        setString("bsn_number", bsnNumber);
    }

    @JsonProperty("prescription_date")
    public Date getPrescriptionDate() {
        return getDate("prescription_date");
    }

    @JsonProperty("prescription_date")
    public void setPrescriptionDate(Date prescriptionDate) {
        setDate("prescription_date", prescriptionDate);
    }

    @JsonProperty("delivery_method")
    public String getDeliveryMethod() {
        return getString("delivery_method");
    }

    @JsonProperty("delivery_method")
    public void setDeliveryMethod(String deliveryMethod) {
        setString("delivery_method", deliveryMethod);
    }

    @JsonProperty("medicines")
    public void setRecipeMedicines(RecipeMedicine[] recipesMedicines){
       this.recipeMedicinesToSave = recipesMedicines;
    }

    public void saveIncludingRecipeMedicines(){
        try {
            Base.openTransaction();
            saveIt();

            if (this.recipeMedicinesToSave != null) {
                for (RecipeMedicine rm : this.recipeMedicinesToSave) {
                    rm.saveIt();
                    add(rm);
                }
            }

            Base.commitTransaction();
        } catch(Exception e){
            Base.rollbackTransaction();
        }finally{
            Base.close();
        }
    }

}
