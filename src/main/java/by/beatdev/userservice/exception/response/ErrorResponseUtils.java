package by.beatdev.userservice.exception.response;

import jakarta.validation.ConstraintViolation;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Collection;
import java.util.List;

public final class ErrorResponseUtils {

    private ErrorResponseUtils() {
    }

    public static StructuredErrorResponse buildStructuredObjectErrorResponse(List<ObjectError> errors) {
        List<ErrorResponseField> errorResponseFields = errors.stream()
                .map(ErrorResponseUtils::buildErrorResponseFiled)
                .toList();
        return new StructuredErrorResponse(errorResponseFields);
    }

    public static StructuredErrorResponse buildStructuredConstraintViolationResponse(Collection<ConstraintViolation<?>> errors) {
        List<ErrorResponseField> errorResponseFields = errors.stream()
                .map(ErrorResponseUtils::buildErrorResponseFiled)
                .toList();
        return new StructuredErrorResponse(errorResponseFields);
    }

    private static ErrorResponseField buildErrorResponseFiled(ObjectError objectError) {
        String message = objectError.getDefaultMessage();
        String field = objectError instanceof FieldError fieldError
                ? fieldError.getField()
                : "";
        return new ErrorResponseField(field, message);
    }

    private static ErrorResponseField buildErrorResponseFiled(ConstraintViolation<?> constraintViolation) {
        String message = constraintViolation.getMessage();
        String field = constraintViolation.getPropertyPath().toString();
        return new ErrorResponseField(field, message);
    }
}
