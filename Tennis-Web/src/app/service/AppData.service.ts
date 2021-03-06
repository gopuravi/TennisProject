import { AppData } from '../model/AppData.model'
import { EventEmitter } from 'events';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LoggingService } from './Logging.service';
import { Injectable } from '@angular/core';
import { Constant } from '../model/Constant.model';
import {catchError, debounceTime, distinctUntilChanged, map, tap, switchMap} from 'rxjs/operators';
import {Observable, of} from 'rxjs';



@Injectable()
export class AppDataService {

    //appDataChanged = new EventEmitter<AppData>();
    private appData:AppData = AppData.Instance;
    private constant:Constant=Constant.Instance;
    constructor(private http:HttpClient,
                private logService:LoggingService
                ){

    }
    addReportName( name:string ){
        console.log("inside DataService" + this.appData.reportlist);
        this.appData.reportlist.push(name);
      //  this.appDataChanged.emit(this.appData);
         console.log("inside DataService" + this.appData.reportlist);
    }

    getReportName(){
        return this.appData.reportlist;
    }
  

    getReportList(){
        return this.http.get(this.constant.URL_GET_REPROT_LIST)
        .subscribe(responseData=>{
            this.logService.log(responseData);
        },error =>{
            this.logService.error("check " + error.message);
        })
    }

    getConnectionList(){        
        return this.http.get(this.constant.URL_GET_CONNECTION_LIST)
    }

    getmessage(){        
        return this.http.get(this.constant.URL_GET_MESSAGE)
    }

    runDynamicReport(dynamicReportSQL:string,selectedConnection:string){
        let data = {"dynamicReportSQL": dynamicReportSQL,"selectedConnection": selectedConnection};
        return this.http.get(this.constant.URL_GET_DYNAMIC_REPORT,{params: data})       
    }

    runStaticReport(reportIdentifier:string , filter:any){
        let data = {"reportIdentifier": reportIdentifier  , "filter":filter};
        console.log( "the data sent to the server is ",data);
         return this.http.post(this.constant.URL_GET_STATIC_REPORT,data,{params: data});
        //return this.http.get(this.constant.URL_GET_STATIC_REPORT,{params: data})
       
    }

    getFilterConfig(reportIdentifier:string){ 
        let data = {"reportIdentifier": reportIdentifier }; 
        return this.http.get(this.constant.URL_GET_FILTER_CONFIG, {params: data})    
       
    }

    searchReports(searchTerm: string) {
        let data = {"searchTerm": searchTerm};
        if (searchTerm === '') {
          return of([]);
        }
    
        return this.http
          .get(this.constant.URL_GET_REPROT_LIST, {params: data}); 
      }
    
}