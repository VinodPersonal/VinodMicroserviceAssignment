package com.vinodtiru.assignment.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VersionValidator implements
        ConstraintValidator<VersionConstraint, String> {

    @Override
    public void initialize(VersionConstraint version) {
    }

    @Override
    public boolean isValid(String versionField,
                           ConstraintValidatorContext cxt) {
        return versionField != null
                && (!versionField.equals(""))
                && (!versionField.startsWith("."))
                && (!versionField.endsWith("."))
                && (!versionField.contains(".."));
    }

}
