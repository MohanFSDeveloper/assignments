package com.csp.custom.annotation.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.csp.custom.annotation.DefaultRegister;
import com.csp.custom.annotation.IsUnique;
import com.csp.custom.annotation.model.ValidationResult;
import com.csp.custom.annotation.model.ValidatorConstants;

public class UniqueValidator extends AbstractValidator {

	@Override
	protected <T> void initialize(T t) {
	}
	private List<Object> referenceNumbers = null;
	
	public UniqueValidator(){
		referenceNumbers = new ArrayList<Object>();
	}

	@Override
	protected List<ValidationResult> validateAnnotationForField(Object object) throws IllegalArgumentException, IllegalAccessException {
		List<ValidationResult> invalidObjects = new ArrayList<ValidationResult>(0);
		Class<?> clazz = object.getClass();
		for(Field f: clazz.getDeclaredFields()) {
			if(f.isAnnotationPresent(IsUnique.class)) {
				f.setAccessible(true);
				IsUnique annotation = f.getAnnotation(IsUnique.class);
				DefaultRegister defaultAnnotation = f.getAnnotation(DefaultRegister.class);
				Object id = f.get(object);
				if(!meetsValidation(id, annotation)) { 
					invalidObjects.add(new ValidationResult(id,getBusinessName(defaultAnnotation), id,annotation.message()));
				}
				f.setAccessible(false);
			}
		}
		return invalidObjects;
	}

	@Override
	protected <V, A extends Annotation> boolean meetsValidation(V value, A a) throws IllegalArgumentException, IllegalAccessException  {
		if(referenceNumbers.size() == 0 && value != null){
			referenceNumbers.add(value);
			return true;
		}
		if(referenceNumbers.contains(value)){
			return false;
		}
		referenceNumbers.add(value);
		return true;
	}

	@Override
	protected String getValidatorName() {
		return ValidatorConstants.UNIQUE_VALIDATOR;
	}


}
