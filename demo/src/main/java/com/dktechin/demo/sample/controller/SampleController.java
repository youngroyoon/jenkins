package com.dktechin.demo.sample.controller;

import com.dktechin.demo.common.annotation.SampleCheck;
import com.dktechin.demo.common.exception.SampleException;
import com.dktechin.demo.common.util.TreeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        //System.out.println("asd");
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
    	int target = -5;
    	int num = 3;

    	target =- num;  // Noncompliant; target = -3. Is that really what's meant?
    	target =+ num; // Noncompliant; target = 3
        throw new SampleException("의도적으로 서버 에러 발생");
    }

}
