package com.acme.jbp.commons;

import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class JbpBaseSystemException extends RuntimeException {

    /**
     * 错误编码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 补充内容
     */
    private String complementary;


    public JbpBaseSystemException(String errorCode, String errorMsg, String complementary) {
        super("(っ•̀ω•́)っ errorCode： 【" + errorMsg + "】 (っ•̀ω•́)っ errorMsg： 【" + errorMsg + "】 (っ•̀ω•́)っ complementary： 【" + complementary + "】");
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.complementary = complementary;
    }

    public JbpBaseSystemException(String message, Throwable cause, String errorCode, String errorMsg, String complementary) {
        super("(っ•̀ω•́)っ errorCode： 【" + errorMsg + "】 (っ•̀ω•́)っ errorMsg： 【" + errorMsg + "】 (っ•̀ω•́)っ complementary： 【" + complementary + "】", cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.complementary = complementary;
    }
}
