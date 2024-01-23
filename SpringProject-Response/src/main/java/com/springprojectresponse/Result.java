package com.springprojectresponse;

public class Result<T> {
    private boolean success;
    private String message;
    private T data;

    // 静态方法创建成功结果，不包含数据
    public static <T> Result<T> success() {
        return new Result<>(true, "Request successful");
    }

    // 静态方法创建成功结果，包含数据
    public static <T> Result<T> success(T data) {
        return new Result<>(true, "Request successful", data);
    }

    // 静态方法创建失败结果，包含错误信息
    public static <T> Result<T> error(String message) {
        return new Result<>(false, message);
    }

    // 静态方法创建失败结果，包含错误信息和数据
    public static <T> Result<T> error(String message, T data) {
        return new Result<>(false, message, data);
    }

    // Constructors, getters, and setters

    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(T data) {
        this.success = true;
        this.data = data;
    }

    // Getters and setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

