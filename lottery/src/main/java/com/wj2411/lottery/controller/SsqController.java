package com.wj2411.lottery.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.model.JSONValue;
import com.wj2411.lottery.model.SsqParam;

@Controller
@RequestMapping("/")
public class SsqController {

	private final static Log log = LogFactory.getLog(SsqController.class);
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model){
		log.debug("ssq page");
		
		return "lottery/ssq";
	}
	
	@RequestMapping(value = "/calculate.html", method = RequestMethod.POST)
	@ResponseBody
	public String calculate(SsqParam ssqParam){
		log.debug("calculate ssq number");
		JSONValue jsonValue;
		String jsonStr = "";
		
		Map<String, Object> modelMap = new HashMap<String, Object>(); 
		try {
			System.out.println(ssqParam.getRange());
			modelMap.put("result", 1);
			modelMap.put("data", null);
		} catch (Exception e) {
			log.error("calculate ssq number error",e);
			modelMap.put("result", 0);
		}
		
		try {
			jsonValue = JSONMapper.toJSON(modelMap);
			jsonStr = jsonValue.render(true); // 是否格式化
		} catch (MapperException e) {
			log.error("mapping jsonValue error",e);
		}
		return jsonStr; 
	}
}
