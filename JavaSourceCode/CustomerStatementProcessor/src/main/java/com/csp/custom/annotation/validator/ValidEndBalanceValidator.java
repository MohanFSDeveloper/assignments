package com.csp.custom.annotation.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.csp.custom.annotation.DefaultRegister;
import com.csp.custom.annotation.IsMutation;
import com.csp.custom.annotation.IsReferenceNum;
import com.csp.custom.annotation.IsStartBalance;
import com.csp.custom.annotation.IsValidEndBalance;
import com.csp.custom.annotation.model.ValidationResult;
import com.csp.custom.annotation.model.ValidatorConstants;

public class ValidEndBalanceValidator extends AbstractValidator {

	@Override
	protected <T> void initialize(T t) {
		
	}

	@Override
	protected List<ValidationResult> validateAnnotationForField(Object object) throws IllegalArgumentException, IllegalAccessException {
		List<ValidationResult> invalidObjects = new ArrayList<ValidationResult>(0);
		Class<?> clazz = object.getClass();
		//Process for Annotation at Field Level
		Object startBalance = null;
		Object mutation = null;
		Object transactionRefnum = null;
		for(Field f: clazz.getDeclaredFields()) {

			if(f.isAnnotationPresent(IsReferenceNum.class)) {
				f.setAccessible(true);
				transactionRefnum = f.get(object);
				f.setAccessible(false);
			}
			if(f.isAnnotationPresent(IsStartBalance.class)) {
				f.setAccessible(true);
				startBalance = f.get(object);
				f.setAccessible(false);
			}
			if(f.isAnnotationPresent(IsMutation.class)) {
				f.setAccessible(true);
				mutation = f.get(object);
				f.setAccessible(false);
			}
			if(f.isAnnotationPresent(IsValidEndBalance.class)) {
				f.setAccessible(true);
				IsValidEndBalance annotation = f.getAnnotation(IsValidEndBalance.class);
				DefaultRegister defaultAnnotation = f.getAnnotation(DefaultRegister.class);
				Object endBalance = f.get(object);
				if(!meetsValidation(startBalance,endBalance,mutation)) { 
					invalidObjects.add(new ValidationResult(transactionRefnum,getBusinessName(defaultAnnotation), endBalance, 
							annotation.message()));
				}
				f.setAccessible(false);
			}
		} 

		return invalidObjects;
	}

	private boolean meetsValidation(Object startBalance, Object endBalance,
			Object mutation) {
		double result = 0;
		if((Double.parseDouble(mutation.toString())) >= 0){
			result = Double.parseDouble(startBalance.toString()) + Double.parseDouble(mutation.toString());
		}else{
			result = Double.parseDouble(startBalance.toString()) - Double.parseDouble(mutation.toString().replace("-", ""));
		}
		if(Math.round(result) == Math.round(Double.parseDouble(endBalance.toString())))
			return true;
		return false;
	}

	@Override
	protected <V, A extends Annotation> boolean meetsValidation(V value, A a) throws IllegalArgumentException, IllegalAccessException  {
		return false;
	}

	@Override
	protected String getValidatorName() {
		return ValidatorConstants.VALID_END_BALANCE_VALIDATOR;
	}


}
