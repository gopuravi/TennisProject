package com.upog.tennis;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.upog.tennis.service.ReportService;
import com.upog.tennis.model.Connection;
import com.upog.tennis.model.ReportDataFields;
import com.upog.tennis.model.ReportDataSource;

/**
 * Acts as a controller to handle actions related to Login of a user and getting
 * all the User Preferences.
 */
@RestController
public class ReportController  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReportService reportService;
	
	/**
	 * Method is the driver method for the Class. Method is called on Login to
	 * Application
	 * 
	 * @return
	 * @throws CadentException
	 */
	//@GetMapping("/message"  )
	@RequestMapping(method=RequestMethod.GET, path="/message")
	@ResponseBody
	public String getMessage() {
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
	public List<List<Map<String,Object>>> getDynamicReport(@RequestParam Map<String,String> requestParams) {
		String SQL=requestParams.get("dynamicReportSQL");
		String connectionName=requestParams.get("selectedConnection");
		
		return reportService.getDynamicReport(connectionName,SQL);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/connectionList")
	@ResponseBody
	public List<Connection> getConnectionList() {
	 List<Connection> connectionList= new ArrayList<Connection>();
	 connectionList.add(new Connection(1,"ANALYZER"));
	 connectionList.add(new Connection(2,"CITISEARCH"));
		System.out.println("inside get connection List");			
		return connectionList;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/staticReport")
	@ResponseBody
	public List<List<Map<String,Object>>> getStaticReport(@RequestParam Map<String,String> requestParams) {
		System.out.println("inside Report List");
		String connectionName=requestParams.get("selectedConnection");
		String reportIdentifier=requestParams.get("reportIdentifier");
		return reportService.getStaticReport(reportIdentifier);
	}
}
