package by.beatdev.userservice.validation;


import by.beatdev.userservice.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Described class serves to validate fields which have unique constraint.
 * Using {@link UniqueEntity} class for marking the field.
 */
public class EntityExistValidator implements ConstraintValidator<UniqueEntity, String> {

    private final UserService userService;

    public EntityExistValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UniqueEntity contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return !userService.exists(contactField);
    }
}
