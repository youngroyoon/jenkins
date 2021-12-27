package com.dktechin.demo.common.interceptor;

import com.dktechin.demo.common.annotation.SampleCheck;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SampleInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        HandlerMethod method = (HandlerMethod)handler;
        SampleCheck sampleCheck = method.getMethodAnnotation(SampleCheck.class);
        if (sampleCheck == null || sampleCheck.sampleCheck()==false) {
            System.out.println("----------------");
            System.out.println("SampleCheck를 않하셨군요. 의미는 없습니다.");
            System.out.println("----------------");
        } else {
            System.out.println("----------------");
            System.out.println("SampleCheck를 잘해주셨습니다. 의미는 없지만 커스텀 어노테이션 정의를 위해 알아 놓으면 좋습니다.");
            System.out.println("----------------");
        }

        return super.preHandle(request, response, handler);
    }

}