package com.hemsw.asasaapi.veenal.dto;

import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hemsw.asasaapi.veenal.service.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Arpit Khandelwal
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto<T> {

    private Status status;
    private T payload;
    private Object errors;
    private Object metadata;

    public static <T> ResponseDto<T> badRequest() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    public static <T> ResponseDto<T> ok() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> ResponseDto<T> unauthorized() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static <T> ResponseDto<T> validationException() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.VALIDATION_EXCEPTION);
        return response;
    }

    public static <T> ResponseDto<T> wrongCredentials() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.WRONG_CREDENTIALS);
        return response;
    }

    public static <T> ResponseDto<T> accessDenied() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.ACCESS_DENIED);
        return response;
    }

    public static <T> ResponseDto<T> exception() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    public static <T> ResponseDto<T> notFound() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    public static <T> ResponseDto<T> duplicateEntity() {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(Status.DUPLICATE_ENTITY);
        return response;
    }

    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
        ErrorResDto error = new ErrorResDto()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimestamp(DateUtils.today());
        setErrors(error);
    }

    public enum Status {
        OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND, DUPLICATE_ENTITY
    }

    @Getter
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageMetadata {
        private final int size;
        private final long totalElements;
        private final int totalPages;
        private final int number;

        public PageMetadata(int size, long totalElements, int totalPages, int number) {
            this.size = size;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
            this.number = number;
        }
    }

}

