package com.acme.jbp.commons;

/**
 * 自定义系统错误类
 * 系统错误发生时，需要使用外部条件通知系统管理人员
 */
public class JbpSystemWarnException extends JbpBaseSystemException {

    public JbpSystemWarnException(String errorCode, String errorMsg, String complementary) {
        super(errorCode, errorMsg, complementary);
    }

    public JbpSystemWarnException(String message, Throwable cause, String errorCode, String errorMsg, String complementary) {
        super(message, cause, errorCode, errorMsg, complementary);
    }
}
