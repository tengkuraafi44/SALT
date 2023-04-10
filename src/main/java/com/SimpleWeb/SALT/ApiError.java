package com.SimpleWeb.SALT;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
//import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private void addSubError(ApiSubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    private void addValidationError(String object, String message) {
        addSubError(new ApiValidationError(object, message));
    }

    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getObjectName(),
                objectError.getDefaultMessage());
    }

    void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }

//    /**
//     * Utility method for adding error of ConstraintViolation. Usually when a @Validated validation fails.
//     *
//     * @param cv the ConstraintViolation
//     */
//    private void addValidationError(ConstraintViolation<?> cv) {
//        this.addValidationError(
//                cv.getRootBeanClass().getSimpleName(),
//                ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
//                cv.getInvalidValue(),
//                cv.getMessage());
//    }

//    void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
//        constraintViolations.forEach(this::addValidationError);
//    }


    interface ApiSubError {
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    class ApiValidationError implements ApiSubError {
        private String object;
        private String field;
        private Object rejectedValue;
        private String message;

        ApiValidationError(String object, String message) {
            this.object = object;
            this.message = message;
        }
    }
}