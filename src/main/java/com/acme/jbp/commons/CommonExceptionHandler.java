package com.acme.jbp.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统一异常处理
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JbpResponseMessage httpMessageNotReadableExceptionHandle(HttpMessageNotReadableException exception){
        return JbpResponseMessageUtil.buildError(exception.getLocalizedMessage());
    }

    /**
     * 统一处理Bind校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public JbpResponseMessage bindExceptionHandler(BindException e){
        String errorStr = e.getBindingResult().getAllErrors().stream().map(objectError ->
                ((FieldError)objectError).getField() + ((FieldError)objectError).getDefaultMessage()).collect(Collectors.joining(","));
        log.error("校验异常！"+errorStr);
        return JbpResponseMessageUtil.buildError(errorStr);
    }

    /**
     * 统一处理校验异常
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JbpResponseMessage MethodArgumentNotValidExceptionHandle(MethodArgumentNotValidException exception){
        Map<String,String> resultmsg = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(item->{
            resultmsg.put(item.getField(),item.getDefaultMessage());
            if(null != item){
                resultmsg.put(item.getField(),item.getDefaultMessage());
            }
        });
        //resultmsg = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
        return JbpResponseMessageUtil.buildError(resultmsg);
    }

    @ExceptionHandler(Exception.class)
    public JbpResponseMessage exceptionHandle(Exception e){
        if (e instanceof JbpSystemErrorException) {
            //高级生产异常
            JbpSystemErrorException systemErrorException = (JbpSystemErrorException) e;
            log.error("系统严重异常！ 发生异常类: 【" + systemErrorException.getClass() + "】, 异常信息： " + e.getCause());
            //创建异步线程，交由异常处理类处理
            //ThreadPoolUtils.getSimpleThreadPool().execute(() -> MsgUtls.push2MSG4SystemError(systemErrorException));
        } else if (e instanceof JbpSystemWarnException) {
            JbpSystemWarnException systemWarnException = (JbpSystemWarnException) e;
            log.error("系统异常！ 发生异常类: 【" + systemWarnException.getCause() + "】, 异常信息： " + e.getCause());
        }
        else {
            log.error("一般异常！ 发生异常类: 【" + e.getCause() + "】, 异常信息： " + e.getLocalizedMessage());
            return JbpResponseMessageUtil.buildError(e.getLocalizedMessage());
        }
        return JbpResponseMessageUtil.buildError(ResultEnums.ERROR);
    }
}
