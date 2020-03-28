package com.acme.jbp.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义ResponseMessage返回对象
 */
@Data
public class JbpResponseMessage<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public JbpResponseMessage(){}

    public JbpResponseMessage(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JbpResponseMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JbpResponseMessage(ResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
    }

    public JbpResponseMessage(ResultEnums resultEnums, T data) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.data = data;
    }
}
