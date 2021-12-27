package com.dktechin.demo.common.exception;

import javax.servlet.ServletException;

public class SampleException extends ServletException {
    public SampleException(){}

    public SampleException(String msg){
        super(msg);
    }
}