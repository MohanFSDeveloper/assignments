package com.csp.custom.annotation.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import com.csp.custom.annotation.DefaultRegister;
import com.csp.custom.annotation.model.ValidationResult;
import com.csp.util.CSPUtils;

public abstract class AbstractValidator {
	
	protected abstract String getValidatorName();
	protected abstract <T> void initialize(T t) throws Exception;
	protected abstract List<ValidationResult> validateAnnotationForField(Object object) throws IllegalArgumentException, IllegalAccessException;
	protected abstract <V, A extends Annotation> boolean meetsValidation(V value, A a) throws IllegalArgumentException, IllegalAccessException;

	public <T> List<ValidationResult> evaluateValidations(Object c) throws IllegalArgumentException, IllegalAccessException {
		List<ValidationResult> result = new ArrayList<ValidationResult>();
		result.addAll(validateAnnotationForField(c));
		return result;
	}
	
	protected String getBusinessName(DefaultRegister annotation) throws IllegalArgumentException, IllegalAccessException {
		return annotation.businessName();
	}

	protected Object getDefaultValue(DefaultRegister annotation) throws IllegalArgumentException, IllegalAccessException {
		return annotation.defaultValue();
	}

	protected Object getFieldValue(Object value, DefaultRegister a) throws IllegalArgumentException, IllegalAccessException {
		if(CSPUtils.isNullOrEmptyOrDefault(value)) {
			return getDefaultValue(a);
		}
		return value;
	}

}
