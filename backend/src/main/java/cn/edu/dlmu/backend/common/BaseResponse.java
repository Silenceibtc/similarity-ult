package cn.edu.dlmu.backend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用结果返回对象
 *
 * @param <T> 返回数据的泛型
 * @author silenceibtc
 */
@Data
public class BaseResponse<T> implements Serializable {
    /**
     * 错误码
     */
    private final int code;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 具体描述
     */
    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
    }

    public BaseResponse(ErrorCode errorCode, String message, String description) {
        this(errorCode.getCode(), null, message, description);
    }

    public BaseResponse(ErrorCode errorCode, String description) {
        this(errorCode.getCode(), null, errorCode.getMessage(), description);
    }
}
