package com.wj2411.lottery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.model.JSONValue;
import com.wj2411.lottery.controller.support.SsqForm;
import com.wj2411.lottery.core.Lottery;

@Controller
@RequestMapping("/")
public class SsqController {

	private final static Log log = LogFactory.getLog(SsqController.class);
	@Autowired
	private Lottery ssqService;
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model){
		log.debug("ssq page");
		
		return "lottery/ssq";
	}
	
	@RequestMapping(value = "/calculate.html", method = RequestMethod.POST)
	@ResponseBody
	public String calculate(SsqForm ssqForm){
		log.debug("calculate ssq number");
		JSONValue jsonValue;
		String jsonStr = "";
		
		Map<String, Object> modelMap = new HashMap<String, Object>(); 
		try {
			if(StringUtils.isNotEmpty(ssqForm.getRange())){
				String[] rangeArray = ssqForm.getRange().split(":");
				ssqForm.setRange1(Integer.valueOf(rangeArray[0]));
				ssqForm.setRange2(Integer.valueOf(rangeArray[1]));
				ssqForm.setRange3(Integer.valueOf(rangeArray[2]));
			}
			List<int[]> data = ssqService.calculate(ssqForm);
			modelMap.put("result", 1);
			modelMap.put("data", data);
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
