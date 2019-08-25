import { Injectable } from '@angular/core';

@Injectable()  
export  class Constant{

    public  APPLICATION_TITLE:string="Reports";
    public  VIEW_REPORT:string="viewReport";
    public  CREATE_REPORT:string="createReport";
    public  DYNAMIC_REPORT:string="DynamicReport";
    public  URL_ADD_REPORT:string="https://ng-complete-guide-c56d3.firebaseio.com/posts.json";
    public  URL_BASE:string="http://localhost:9090/reports/"
    public  URL_GET_MESSAGE:string= this.URL_BASE +"message";
    public  URL_GET_REPROT_LIST:string=this.URL_BASE +"reportList";
    public  URL_GET_DYNAMIC_REPORT:string=this.URL_BASE+"dynamicReport";
    public  URL_GET_STATIC_REPORT:string=this.URL_BASE+"staticReport";
    public  URL_GET_CONNECTION_LIST:string=this.URL_BASE+"connectionList";

    private static constant: Constant;
    private constructor(){        
    }

    public static get Instance()
    {               
        return this.constant || (this.constant = new this());        
    }

}