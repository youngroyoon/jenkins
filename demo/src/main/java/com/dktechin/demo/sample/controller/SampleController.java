package com.dktechin.demo.sample.controller;

import com.dktechin.demo.common.annotation.SampleCheck;
import com.dktechin.demo.common.exception.SampleException;
import com.dktechin.demo.common.util.TreeUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Web Controller
 */
@Controller
public class SampleController {

    @Value("${application.message.corp}")
    private String welcome;

    @SampleCheck
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("corp", this.welcome);
        return "index";
    }

    @SampleCheck
    @GetMapping("/tree")
    public String tree(Model model) throws Exception {
        model.addAttribute("treeData", TreeUtil.getDataList());
        return "tree";
    }

    @GetMapping("/e500")
    public void error(Model model) throws Exception {
        throw new SampleException("의도적으로 서버 에러 발생");
    }
    
    @GetMapping("/a")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException
	{
    	System.out.println("aaaa");
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials","true");
        response.addHeader("Location","http://210.217.178.128:9000/sessions/new");
        response.addHeader("Access-Control-Allow-Methods","GET, POST");
        response.addHeader("Access-Control-Allow-Headers","*");
        response.addHeader("X-Frame-Options","allow-from http://localhost:7782/a");
        response.addCookie(new Cookie("XSRF-TOKEN", "s3bgm2bijmf7g8nvh5ghn6nvet")); 
        response.addCookie(new Cookie("JWT-SESSION", "eyJhbGciOiJIUzI1NiJ9.eyJsYXN0UmVmcmVzaFRpbWUiOjE2NDQyMTA4MjAwNjAsInhzcmZUb2tlbiI6InMzYmdtMmJpam1mN2c4bnZoNWdobjZudmV0IiwianRpIjoiQVg3U21oUFppVTl5NkNwd2FNTTEiLCJzdWIiOiJBWDZVNmM4bDJiWmlXbC1RbEI2dyIsImlhdCI6MTY0NDIxMDgyMCwiZXhwIjoxNjQ0NDcwMDIwfQ.L3ERxsYsqAA9tkWujncqZtXA3vrYc8bASdxxNWZYJP4")); 
        response.addCookie(new Cookie("country", "asfwetr22223")); 
        response.setContentType("application/json;charset=UTF-8");
        response.sendRedirect("http://210.217.178.128:9000/projects");
       
	}
    
    @GetMapping("/a2")
    public void doPost2(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException
	{

    	  
         response.addCookie(new Cookie("country", "asd")); 
        
        String value = "admin:Sptek12#$";
        String encodedValue = new String(Base64.encodeBase64(value.getBytes()));
         System.out.println("Basic "+encodedValue);
    	response.setHeader("Authorization", "Basic "+encodedValue);
    	response.setHeader("Location", "http://localhost:9000/api/users/search");
    	response.sendRedirect("http://localhost:9000/api/users/search");

	}
}
