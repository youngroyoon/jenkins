package com.dktechin.demo.lotto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dktechin.demo.common.annotation.SampleCheck;
import com.dktechin.demo.lotto.service.LottoServiceImpl;

/**
 * Web Controller
 */
@Controller
public class LottoController {
	
	@Autowired
	LottoServiceImpl lottoService;
	
	@SampleCheck
    @GetMapping("/lotto")
    public String lotto(Model model) {
        model.addAttribute("lottoData", lottoService.getLottoService());
        return "lotto";
    }
}
