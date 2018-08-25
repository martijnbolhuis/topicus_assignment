package models;

import org.codehaus.jackson.annotate.JsonProperty;
import org.javalite.activejdbc.Model;

public class RecipeMedicine extends Model {

    @JsonProperty("medicine_form_id")
    public Integer getMedicineFormId(){
        return getInteger("medicine_form_id");
    }

    @JsonProperty("medicine_form_id")
    public void setMedicineFormId(Integer medicineFormIdId){
        setInteger("medicine_form_id", medicineFormIdId);
    }

    @JsonProperty("usage")
    public String getUsage(){
        return getString("usage");
    }

    @JsonProperty("usage")
    public void setUsage(String usage){
        setString("usage", usage);
    }

}


