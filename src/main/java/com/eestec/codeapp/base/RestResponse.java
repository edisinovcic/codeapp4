package com.eestec.codeapp.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse implements Serializable {

    private static final long serialVersionUID = 2384707091841123L;

    @Getter
    private Boolean success;

    @Getter
    private RestError error;

    @Getter
    private transient Object data;

    public RestResponse(Boolean success) {
        this.success = success;
    }

    public RestResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public RestResponse setError(RestError error) {
        this.error = error;
        return this;
    }
}
