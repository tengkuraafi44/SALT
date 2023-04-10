package com.SimpleWeb.SALT;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exception extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errorCode = "999";
    private String reason;
    private int statusCode = 400;
    private ArrayList<ApiError.ApiSubError> subErrors;

    public Exception(String errorCode, String message, String reason) {
        super(message);
        this.errorCode = errorCode;
        this.reason = reason;
    }

    public Exception(String reason) {
        super(reason);
    }

    public Exception(String reason, java.lang.Exception exception) {
        super(reason, exception);
    }

    public Exception(String errorCode, String reason) {
        super(reason);
        this.errorCode = errorCode;
        this.reason = reason;
        this.statusCode = 400;
    }

    public Exception(int statusCode, String message) {
        super(message);
        this.reason = message;
        this.statusCode = statusCode;
        this.errorCode = "999";
    }

    public Exception(String errorCode, String reason, String causeMessage, List<ApiError.ApiValidationError> subErrors) {
        super(reason);
        this.errorCode = errorCode;
        this.reason = causeMessage;

        if (this.subErrors == null) {
            this.subErrors = new ArrayList<ApiError.ApiSubError>();
        }

        if (subErrors != null)
            this.subErrors.addAll(subErrors);
    }
}
