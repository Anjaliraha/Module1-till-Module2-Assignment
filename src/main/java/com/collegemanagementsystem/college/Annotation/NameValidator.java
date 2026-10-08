package com.collegemanagementsystem.college.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValidation, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value.isBlank() && value.length() <= 0) return false;
    return true;
  }
}
