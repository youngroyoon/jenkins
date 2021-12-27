package com.dktechin.demo.common.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value("${application.message.corp}")
    private String welcome;
	
	@ExceptionHandler({ NullPointerException.class, SampleException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView nullPointerException(HttpServletRequest request, Exception ex) {
        return handleExceptionInternal(request, ex);
    }

    private ModelAndView handleExceptionInternal(HttpServletRequest request, Exception ex) {
        ModelAndView mav = new ModelAndView();

        if ((ex instanceof NullPointerException)) {
            mav.addObject("errorTitle", "Null 포인트 에러는 발생시키지 맙시다.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(baos);
        ex.printStackTrace(pw);
        pw.flush();
        
        if ((ex instanceof SampleException)) {
        	mav.addObject("corp", this.welcome);
        	mav.setViewName("/index");
        }else {
        	mav.addObject("errorMag", baos.toString());
        	mav.setViewName("/errors/error");
        }
       
        return mav;
    }

}
