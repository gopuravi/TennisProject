import { Injectable } from '@angular/core';



@Injectable() // Does it REquired 
export class AppData{
    public name:String;
    public description:String;
    public dynamicReportResult:any;
    public dynamicReportHeader:any;
    public connectionList:any;
    public reportlist =new Array<string>("Report1","Report2","Report3");
 

    private static appData: AppData;
    private constructor(){        
    }

    public static get Instance()
    {               
        return this.appData || (this.appData = new this());        
    }

    public getReportList(){
        return this.reportlist; 
    }

    

}