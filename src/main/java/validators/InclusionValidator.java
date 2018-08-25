package validators;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.ValidatorAdapter;

public class InclusionValidator extends ValidatorAdapter {

    private Object[] allowedValues;
    private String attributeName;

    public InclusionValidator(Object[] allowedValues, String attributeName){
        this.allowedValues = allowedValues;
        this.attributeName = attributeName;
    }

    public void validate(Model model) {
        boolean valid = false;
        Object value = model.get(attributeName);

        for(Object allowedValue : allowedValues){
            if (allowedValue.equals(value)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            model.addValidator(this, "inclusion_validator");
        }
    }
}
