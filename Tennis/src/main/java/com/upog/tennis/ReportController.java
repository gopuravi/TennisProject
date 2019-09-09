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

import com.upog.tennis.service.ReportInitService;
import com.upog.tennis.service.ReportService;
import com.upog.tennis.util.Constant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upog.tennis.exception.CustomResponseEntityExceptionHandler;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.Connection;
import com.upog.tennis.model.ReportDataFields;
import com.upog.tennis.model.ReportDataSource;
import com.upog.tennis.model.ReportFilterOperators;
import com.upog.tennis.model.ReportFilterType;

/**
 * Acts as a controller to handle actions related to Login of a user and getting
 * all the User Preferences.
 */
@Controller
public class ReportController  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired  
	private ReportInitService reportInitService;
	
	@RequestMapping(method=RequestMethod.GET, path="/reportFilterType")
	@ResponseBody
	public List<ReportFilterType> getReportFilterType() {		
		return reportInitService.getReportFilterType();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/reportFilterByType")
	@ResponseBody
	public ReportFilterType getReportFilterByType() {		
		return reportInitService.getReportFilterByType();
	} 
	
	@RequestMapping(method=RequestMethod.GET, path="/filterOperatorByTypeId/{filterTypeId}")
	@ResponseBody
	public List<ReportFilterOperators> getFilterOperatorrsByFilterTypeId(@PathVariable int filterTypeId) {
		System.out.println("inside Report List");			
		return reportInitService.retrieveFilterOperatorrsByFilterTypeId(filterTypeId);
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, path="/message")
	@ResponseBody
	public String getMessage() throws ResponeException {
		System.out.println("inside dashboard 1");
		
		return "csalayout123";   
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/reportList")
	@ResponseBody
	public List<ReportDataSource> getReportList() {
		System.out.println("inside Report List");				
		return reportService.getReportList();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/reportFieldsById/{reportInternalId}")
	@ResponseBody
	public List<ReportDataFields> getReportFields(@PathVariable int reportInternalId) {
		System.out.println("inside Report List");			
		return reportService.getReportFields(reportInternalId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/reportFieldsByName/{reportName}")
	@ResponseBody
	public List<ReportDataFields> getReportFields(@PathVariable String reportName) {
		System.out.println("inside Report List");			
		return reportService.getReportFields(reportName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/dynamicReport")
	@ResponseBody
	public List<List<Map<String,Object>>> getDynamicReport(@RequestParam Map<String,String> requestParams) throws ResponeException {
		String SQL=requestParams.get("dynamicReportSQL");
		String connectionName=requestParams.get("selectedConnection");		
		return reportService.getDynamicReport(connectionName,SQL);		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/connectionList")
	@ResponseBody
	public List<Connection> getConnectionList() {
		 return reportInitService.getConnectionList();
	 
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/initConnections")
	@ResponseBody
	public boolean initConnections() {		   
		 return reportInitService.initConnections();
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/staticReport")  
	@ResponseBody
	public List<List<Map<String,Object>>> getStaticReport(@RequestBody String data, @RequestParam Map<String,Object> requestParams)
			throws ResponeException{ 
		List<List<Map<String,Object>>> result;
		String reportIdentifier;
	try {

		 reportIdentifier= requestParams.get("reportIdentifier").toString();
		
		//HashMap<String,Object> filter = 		        new ObjectMapper().readValue(data, HashMap.class);
		
		
		System.out.println("The request Body is " + data);
		
		
		
		result= reportService.getStaticReport(reportIdentifier,data); 
		
	}catch(Exception e) {
		System.out.println("Inside Exception" +e.getMessage()); 
		throw new ResponeException(e); 
	}
	return result; 
	} 
	
	@RequestMapping(method=RequestMethod.GET, path="/filterConfig")
	@ResponseBody
	public Map<String, Map<String, Object>> getFilterConfig(@RequestParam Map<String,String> requestParams) {
		System.out.println("inside Report List"); 
		
		ArrayList filterConfigList = new ArrayList<Map<String, Map<String, Object>>>(1);
		//Connection based static filter config need to be enhanced
		String connectionName=requestParams.get("selectedConnection");
		String reportIdentifier=requestParams.get("reportIdentifier");
		
		System.out.println("The Filter config is " + reportIdentifier);
		Map<String, Map<String, Object>> filterConfigMap=reportService.getFilterConfig(reportIdentifier);
		
		filterConfigList.add(filterConfigMap); 
		return filterConfigMap;  
	}
}  
