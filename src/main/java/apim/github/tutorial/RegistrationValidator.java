package apim.github.tutorial;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegistrationData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistrationData data = (RegistrationData) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "registrationData.address.empty");
		if (data.getClassChoices().length == 0) {
			errors.rejectValue("classChoices", "registrationData.classChoices.empty");
		}
	}

}
