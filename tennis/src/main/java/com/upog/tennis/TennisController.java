package com.upog.tennis;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upog.tennis.service.TennisInitService;
import com.upog.tennis.service.TennisService;
import com.upog.tennis.util.Constant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upog.tennis.exception.CustomResponseEntityExceptionHandler;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.Connection;


/**
 * Acts as a controller to handle actions related to Login of a user and getting
 * all the User Preferences.
 */
@Controller
public class TennisController  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TennisService tennisService;
	
	@Autowired  
	private TennisInitService tennisInitService;
	
	
	
	@RequestMapping(method=RequestMethod.GET, path="/message")
	@ResponseBody
	public String getMessage() throws ResponeException {
		System.out.println("inside dashboard 1");
		
		return "csalayout123";   
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, path="/dynamicReport")
	@ResponseBody
	public List<List<Map<String,Object>>> getDynamicReport(@RequestParam Map<String,String> requestParams) throws ResponeException {
		String SQL=requestParams.get("dynamicReportSQL");
		String connectionName=requestParams.get("selectedConnection");		
		return tennisService.getDynamicReport(connectionName,SQL);		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/connectionList") 
	@ResponseBody
	public List<Connection> getConnectionList() {
		 return tennisInitService.getConnectionList();
	 
	}
	

	
	
	
}  
