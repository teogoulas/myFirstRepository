package com.syllogos.validator;

import com.syllogos.model.GlobalVariables;
import com.syllogos.model.RodoClassView;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("rodoClassValidator")
public class RodoClassValidatorImpl implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RodoClassView.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		final String noClassNameError = "en".equals(GlobalVariables.getLocale()) ? "It is mandatory to choose a class." : "Πρέπει να επιλέξεις ένα από τα τμήματα";

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"className", "required.className",  noClassNameError);
	}
}