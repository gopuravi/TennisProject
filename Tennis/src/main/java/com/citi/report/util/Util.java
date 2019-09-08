package com.citi.report.util;

import java.util.ArrayList;
import java.util.List;

import com.citi.report.model.ReportDataFields;
import com.citi.report.model.ReportFilterOperators;
import com.citi.report.model.ReportFilterType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.jdbc.Const;

public abstract class Util {

   public static String toCamelCase(String input) {
	 if(input==null || input.length()==0)
		 return input;
	   
	   StringBuffer sb = new StringBuffer();
	    for (String s : input.split("_")) {
	        sb.append(Character.toUpperCase(s.charAt(0)));	        
	        sb.append(s.substring(1, s.length()).toLowerCase());
	        sb.append(Constant.SPACE);
	    }
	   return sb.toString().trim();
   }
   
   public static List<String> getOperatorListByName( List<ReportFilterType> filterTypeList, String filterName){	  
	   List<String> operatorList= new ArrayList<String>(20);	   
	   filterTypeList.forEach( filterType -> {		   
			if(filterType.getFilterName().equalsIgnoreCase(filterName)) {
				filterType.reportFilterOperators.forEach(filterOperator ->{
					operatorList.add(filterOperator.getFilterOprdisplayName());
				});
			}					 			
		});
	   return operatorList;
   }
   public static String  getFilterConditionFromJsonString( String filterCondition , List<ReportDataFields> dataFieldList , List<ReportFilterType> filterTypeList) throws Exception {
	   StringBuilder condition = new StringBuilder();
	   ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(filterCondition);
		JsonNode filter=null;
		if(rootNode.get("filter")!=null) {
			filter = rootNode.get("filter");
			if (filter.get("rules").size()==0) return Constant.EMPTY;
			
		}
		String mainClause=rootNode.get("filter").get("condition").asText();
		
		
	condition.append(extractNodeCondition(filter,mainClause,"", dataFieldList ,  filterTypeList));		 
	
	 return condition
			 .substring(condition.indexOf("("))
			 .replaceAll("\"","'"); 
		
	   
   } 
   
   private static String extractNodeCondition(JsonNode jsonNode , String clause,String result, List<ReportDataFields> dataFieldList , List<ReportFilterType> filterTypeList ) {

	   if(jsonNode!=null) {
		   
		   String condition=(jsonNode.get("condition")!=null)?jsonNode.get("condition").textValue():Constant.EMPTY;
							
			String field=(jsonNode.get("field")!=null)?jsonNode.get("field").textValue():Constant.EMPTY; 
			String operator=(jsonNode.get("operator")!=null)?jsonNode.get("operator").textValue():Constant.EMPTY; 
			String value=(jsonNode.get("value")!=null)?jsonNode.get("value").toString():Constant.EMPTY;
			String type=Constant.EMPTY;
			
			if(isNotNullorEmpty(operator)) {
				ArrayList<String> resultList = getOperatorAndTypeforOprDisplayName( field, operator, dataFieldList , filterTypeList );
				type = resultList.get(0);
				operator = resultList.get(1);				
			} 
			
			if(Constant.DATE.equalsIgnoreCase(type)) {
				value= "TO_DATE("+value+",\'"+ Constant.DATE_FORMAT_YYYY_MM_DD+"\')";
			}
			
			if(condition!=null && !Constant.EMPTY.equals(condition) ) {
				result=result +" " + condition+  " (";
				int i=0;
				for (JsonNode jsonchildNode: jsonNode.get("rules")) {
					if(i==0){
						result= result+extractNodeCondition (jsonchildNode, "" , "" , dataFieldList ,  filterTypeList);
						i++;
				}
					else 
					result= result+extractNodeCondition (jsonchildNode, condition , "" , dataFieldList ,  filterTypeList);
				}
				result=result + ")";
			}else {
				result= result + " " + clause + " " + field + " " + operator +  " " + value ;
			}

			
		}
	  // System.out.println("The node value is " + result);
	   return result;
   }
   
   public static boolean isNotNullorEmpty(String input) {
	
	   return (input==null || Constant.EMPTY.equals(input)) ?false:true;
   }
   
   private static ArrayList<String> getOperatorAndTypeforOprDisplayName(String filedName,String oprDisplayName, List<ReportDataFields> dataFieldList , List<ReportFilterType> filterTypeList ) {
	   ArrayList <String> result= new ArrayList<String>(2);
	   String operator=oprDisplayName;
	   String type="";
	   for(ReportDataFields dataField: dataFieldList) {
		   if(dataField.getFieldName().equals(filedName)) {
			   type=dataField.getFieldType();
			   break;
		   }
	   }
	   
	   for(ReportFilterType filterType: filterTypeList) {
		   if(type.equalsIgnoreCase(filterType.getFilterType())) {
			   for(ReportFilterOperators filterOpr: filterType.getReportFilterOperators() ) {
				   if(filterOpr.getFilterOprdisplayName().equals(oprDisplayName)) {					   
					   operator= filterOpr.getFilterOprValue();						
					}	
			   }
			   
			 
			   
		   }
		   
	   } 
	   
	   result.add(type);
	   result.add(operator);
	   
	   return result;
	   
   }
   
}
