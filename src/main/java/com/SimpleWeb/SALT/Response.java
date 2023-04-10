package com.SimpleWeb.SALT;

import lombok.*;
//import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private ResponseStatus responseStatus;
    private ResponseData data;
    private List<DetailErrors> detailErrors;

    public void addResponseStatus(String responseCode, String responseMessage) {
        this.responseStatus = ResponseStatus.builder()
                .responseCode(responseCode)
                .responseMessage(responseMessage)
                .build();
    }

    private void addSubError(DetailErrors detailError) {
        if (detailErrors == null) {
            detailErrors = new ArrayList<>();
        }

        detailErrors.add(detailError);
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

//    public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
//        constraintViolations.forEach(this::addValidationError);
//    }

    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getDefaultMessage());
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
//                cv.getMessage());
//    }

    private void addValidationError(String object, String field, String message) {
        addSubError(new ApiValidationError(object, field, message));
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseStatus {

        private String responseCode;
        private String responseMessage;
        private String traceNumber;

    }

    interface DetailErrors {
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @AllArgsConstructor
    static class ApiValidationError implements DetailErrors {

        private String object;
        private String field;
        private String message;

    }

}
