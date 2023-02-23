package com.xiao.common.resp;


import com.xiao.common.enums.HttpCodeEnum;

@SuppressWarnings("ALL")
public class ApiUtil {

    public static ApiResult success() {
        return success(null);
    }

    public static ApiResult successMsg(String msg) {
        return success(msg, null);
    }

    public static <T> ApiResult<T> success(T data) {
        return success(HttpCodeEnum.OK.getMsg(), data);
    }

    public static <T> ApiResult<T> success(String message, T data) {
        return build(HttpCodeEnum.OK.getCode(), message, data);
    }

    public static ApiResult<String> fail() {
        return build(HttpCodeEnum.FAIL);
    }

    public static ApiResult<String> fail(String msg) {
        return build(HttpCodeEnum.FAIL.getCode(), msg, null);
    }

    public static ApiResult<String> businessFail(String msg) {
        return build(HttpCodeEnum.BUSINESS.getCode(), msg, null);
    }

    public static ApiResult error() {
        return build(HttpCodeEnum.INTERNAL_SERVER_ERROR);
    }

    public static ApiResult paramError() {
        return build(HttpCodeEnum.UNPROCESABLE_ENTITY);
    }

    public static ApiResult unAuthorized() {
        return build(HttpCodeEnum.UNAUTHORIZED);
    }

    public static ApiResult noLicence() {
        return build(HttpCodeEnum.NOLICENCE);
    }

    public static ApiResult forbidden() {
        return build(HttpCodeEnum.FORBIDDEN);
    }

    public static ApiResult notFound() {
        return notFound(null);
    }

    public static <T> ApiResult<T> notFound(T data) {
        return build(HttpCodeEnum.NOT_FOUND, data);
    }

    public static ApiResult notAcceptable() {
        return build(HttpCodeEnum.NOT_ACCEPTABLE);
    }

    public static ApiResult gone() {
        return gone(null);
    }

    public static <T> ApiResult<T> gone(T data) {
        return build(HttpCodeEnum.GONE, data);
    }

    public static ApiResult unprocesableEntity() {
        return build(HttpCodeEnum.UNPROCESABLE_ENTITY);
    }

    public static ApiResult unKnowError() {
        return unKnowError(null);
    }

    public static <T> ApiResult<T> unKnowError(T data) {
        return build(HttpCodeEnum.INTERNAL_SERVER_ERROR, data);
    }

    public static ApiResult custom(HttpCodeEnum httpCodeEnum) {
        return build(httpCodeEnum, null);
    }

    public static ApiResult custom(int code, String msg) {
        return build(code, msg, null);
    }

    public static <T> ApiResult<T> custom(HttpCodeEnum httpCodeEnum, T data) {
        return build(httpCodeEnum, data);
    }

    public static <T> ApiResult<T> custom(int code, String msg, T data) {
        return build(code, msg, data);
    }

    private static <T> ApiResult<T> build(HttpCodeEnum httpCodeEnum) {
        return build(httpCodeEnum.getCode(), httpCodeEnum.getMsg(), null);
    }

    private static <T> ApiResult<T> build(HttpCodeEnum httpCodeEnum, T data) {
        return build(httpCodeEnum.getCode(), httpCodeEnum.getMsg(), data);
    }

    private static <T> ApiResult<T> build(int code, String msg, T data) {
        return new ApiResult<>(code, msg, data);
    }
}
