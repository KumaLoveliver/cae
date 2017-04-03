package org.cae.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.cae.common.Condition;
import org.cae.common.ServiceResult;
import org.cae.controller.ICallController;
import org.cae.entity.CallRecord;
import org.cae.service.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/call")
public class CallControllerImpl implements ICallController {

	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ICallService callService;

	@Override
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryCallForHomepage() {
		ServiceResult result=callService.queryCallForHomepageService();
		Map<String, Object> theResult;
		if(result.isSuccessed()){
			theResult=(Map<String, Object>) result.getResult();
			theResult.put("successed", result.isSuccessed());
		}
		else{
			theResult=new HashMap<String,Object>();
			theResult.put("successed", result.isSuccessed());
			theResult.put("errInfo", result.getErrInfo());
		}
		return theResult;
	}

	@Override
	@RequestMapping(value="/search",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAllCallController(Condition condition,
			CallRecord callRecord) {
		ServiceResult result=callService.queryAllCallService(condition, callRecord);
		return result.toMap();
	}

	@Override
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryCallController(CallRecord callRecord) {
		ServiceResult result=callService.queryCallService(callRecord);
		return result.toMap();
	}

	@Override
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCallController(CallRecord callRecord) {
		ServiceResult result=callService.addCallService(callRecord);
		return result.toMap();
	}

	@Override
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> removeCallController(CallRecord callRecord) {
		ServiceResult result=callService.removeCallService(callRecord);
		return result.toMap();
	}

	@Override
	@RequestMapping(value="/removes",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> removeCallController(List<CallRecord> callRecords) {
		ServiceResult result=callService.removeCallService(callRecords);
		return result.toMap();
	}
}
