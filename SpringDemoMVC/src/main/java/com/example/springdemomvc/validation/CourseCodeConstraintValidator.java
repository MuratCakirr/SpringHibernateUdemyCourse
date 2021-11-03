package com.example.springdemomvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result = false;

        if(theCode != null){
            for (String tempPrefix:coursePrefix) {
                result = theCode.startsWith(tempPrefix);

                if (result) {
                    break;
                }
            }

        }else {
            return true;
        }

        return result;
    }

}
