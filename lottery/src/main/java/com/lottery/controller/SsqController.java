package com.lottery.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SsqController {

	private final static Log log = LogFactory.getLog(SsqController.class);
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model){
		log.debug("ssq page");
		
		return "lottery/ssq";
	}
}
