import { Injectable } from '@angular/core';

@Injectable()  
export  class Constant{

    public  APPLICATION_TITLE:string="Reports";
    public  VIEW_REPORT:string="viewReport";
    public  CREATE_REPORT:string="createReport";
    public  DYNAMIC_REPORT:string="DynamicReport";

    public EMPTY:string="";

    public SERVER_IP:string="localhost";
    public SERVER_PORT:string="9090";
    public SERVER_PROTOCOL:string="http";
    public APP_CONTEXT:string="tennis";
    public DEFAULT_DATABASEs:string="DBTENNIS";

    public  URL_ADD_REPORT:string="https://ng-complete-guide-c56d3.firebaseio.com/posts.json";
    public  URL_BASE:string= this.SERVER_PROTOCOL+"://"+this.SERVER_IP+":"+this.SERVER_PORT+"/"+  this.APP_CONTEXT+"/";
    public  URL_GET_MESSAGE:string= this.URL_BASE +"message"; 
    public  URL_GET_REPROT_LIST:string=this.URL_BASE +"reportList";
    public  URL_GET_DYNAMIC_REPORT:string=this.URL_BASE+"dynamicReport";
    public  URL_GET_STATIC_REPORT:string=this.URL_BASE+"staticReport";
    public  URL_GET_CONNECTION_LIST:string=this.URL_BASE+"connectionList";
    public  URL_GET_FILTER_CONFIG:string=this.URL_BASE+"filterConfig"; 

    public  ERR_MESSAGE_NOT_AVAILABLE:string="Error message not availble";
    public  ERR_SERVER_NOT_AVAILABLE:string="The Serive may not be available"; 
    public  ERR_REPORT_NOT_SELECTED:string="Please select on of the availble report from the list"; 
    

    private static constant: Constant;
    private constructor(){        
    }

    public static get Instance()
    {               
        return this.constant || (this.constant = new this());        
    }

}