package com.dktechin.demo.common.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorPageController implements ErrorController {

    private String VIEW_PATH = "/errors/";
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, HttpServletResponse response) {
        Object ststus = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

//        if ( ststus != null ) {
//            int statusCode = Integer.valueOf(ststus.toString());
//            if(statusCode == HttpStatus.NOT_FOUND.value()){
//                return VIEW_PATH + "404";
//            } if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
//                return VIEW_PATH + "500";
//            } else {
//
//            }
//        }

        return VIEW_PATH + "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}


