package com.acme.jbp.commons;

/**
 * 自定义系统级别异常
 */
public class JbpSystemErrorException extends JbpBaseSystemException {

    public JbpSystemErrorException(String errorCode, String errorMsg, String complementary) {
        super(errorCode, errorMsg, complementary);
    }

    public JbpSystemErrorException(String message, Throwable cause, String errorCode, String errorMsg, String complementary) {
        super(message, cause, errorCode, errorMsg, complementary);
    }
}
