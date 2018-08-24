package models;

import org.codehaus.jackson.annotate.JsonProperty;
import org.javalite.activejdbc.Model;

public class RecipeMedicine extends Model {

    @JsonProperty("package_id")
    public Integer getPackageId(){
        return getInteger("package_id");
    }

    @JsonProperty("package_id")
    public void setPackageId(Integer packageId){
        setInteger("package_id", packageId);
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


