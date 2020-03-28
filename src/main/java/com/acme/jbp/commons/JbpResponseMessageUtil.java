package com.acme.jbp.commons;

/**
 * 统一返回数据帮助类
 */
public class JbpResponseMessageUtil {

    /**
     * 带实体的统一返回
     *
     * @param data 实体
     * @param <T>  实体类型
     * @return
     */
    public static <T> JbpResponseMessage buildSuccess(T data) {
        return new JbpResponseMessage<T>(ResultEnums.SUCCESS, data);
    }

    public static JbpResponseMessage buildSuccess() {
        return new JbpResponseMessage(ResultEnums.SUCCESS);
    }

    public static JbpResponseMessage buildSuccess(String msg) {
        return new JbpResponseMessage(ResultEnums.SUCCESS.getCode(), msg);
    }

    public static JbpResponseMessage buildSuccess(String code, String msg) {
        return new JbpResponseMessage(code, msg);
    }

    public static <T> JbpResponseMessage buildSuccess(String code, String msg, T data) {
        return new JbpResponseMessage<T>(code, msg, data);
    }

    public static JbpResponseMessage buildSuccess(ResultEnums resultEnums) {
        return new JbpResponseMessage(resultEnums);
    }

    public static <T> JbpResponseMessage buildError(T data) {
        return new JbpResponseMessage<T>(ResultEnums.ERROR, data);
    }

    public static JbpResponseMessage buildError() {
        return new JbpResponseMessage(ResultEnums.ERROR);
    }
}
