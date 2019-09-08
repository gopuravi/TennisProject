import { Component, OnInit , ViewChild, ElementRef} from '@angular/core';
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service'
import { AppData } from '../model/AppData.model';

import {Observable, of,merge,Subject} from 'rxjs';
import {catchError, debounceTime, distinctUntilChanged, map, tap, switchMap,filter} from 'rxjs/operators';





import {NgbTypeahead, NgbTypeaheadModule} from '@ng-bootstrap/ng-bootstrap';
import { sqlBuilderComponenet } from '../CompSqlBuilder/sqlBuilder.component';
import {  AlertCompoenent } from '../CompShared/CompAlert/alert.componenet';
import { Constant } from '../model/Constant.model';

const METHOD_ON_EXECUTE_REPORT:string="onExecuteReport";

 
@Component({

    selector: 'viewReportSel',
    templateUrl:'./viewReport.component.html' ,
    styleUrls: ['./viewReport.component.css']

})



export class viewReportComponenet implements OnInit{ 
  @ViewChild(sqlBuilderComponenet, {static: false}) sqlBuilderRef; 

  
  

   appData:AppData=AppData.Instance;


   selectedReport : any;
  searching = false;
  searchFailed = false;
  columnDefs=[];
  rowData=[]; 
  ifFilterConfigLoaded=false;
  filterConfig:any;
  
  errorObj: any = null;
  private constant:Constant=Constant.Instance;

   constructor(private appDataService:AppDataService , private  logService:LoggingService){
       console.log("inside view report Constructor  ");
     
   }
   
    ngOnInit(){                
        console.log("Inside View Component Init4 " + this.selectedReport );
    }

    search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => this.searching = true),
      switchMap(term =>
        this.appDataService.searchReports(term).pipe(
          tap(() => this.searchFailed = false),
          catchError(() => {
            this.searchFailed = true;
            return of([]);
          }))
      ),
      tap(() => this.searching = false)
    )

    formatter = (x: {displayName: string}) => x.displayName;

    ValidateInput(methodName:String){
      let errormsg:string;
      if(methodName==METHOD_ON_EXECUTE_REPORT){
 
         if(!this.selectedReport ||  !this.selectedReport.reportIdentifier){ 
           errormsg=this.constant.ERR_REPORT_NOT_SELECTED; 
         }          
      }

      if(errormsg)
        this.errorObj={"message": errormsg } 

    }
 
    onExecuteReport() {       
      this.ValidateInput(METHOD_ON_EXECUTE_REPORT);
      
       let filter:any

       if(this.sqlBuilderRef)
          filter=this.sqlBuilderRef.query;

       console.log("The filter is ", filter);     
        this.appDataService.runStaticReport(this.selectedReport.reportIdentifier , filter).subscribe(responseData=>{
          console.log("The report data is",responseData);


          this.columnDefs=responseData[0];
          this.rowData=responseData[1];
      },error =>{
          this.errorObj=error;
          this.logService.error("check " + error.message);  
      });      
      } 

      onReportSelection(selectedItem){ 
        this.ifFilterConfigLoaded=false;   
        console.log(selectedItem.item.reportIdentifier);
       // console.log("config" , this.sqlBuilderRef.config )    
        this.appDataService.getFilterConfig(selectedItem.item.reportIdentifier).subscribe(responseData=>{
 
          let pusheditems = {};
          for (let keys of Object.keys(responseData)) {
            //console.log("object:", responseData[keys]);   
           
           
         pusheditems[keys] = responseData[keys];
          
          }
 
          this.filterConfig ={fields:  pusheditems };  
          this.ifFilterConfigLoaded=true;  
         // Object.assign(this.sqlBuilderRef.config, filterConfig)
          
          //this.sqlBuilderRef.cofig.fields =      pusheditems;  
             
        //console.log("config" , this.sqlBuilderRef.config )
         //console.log ( JSON.stringify(responseData[0]) )  
          console.log(this.filterConfig  );
          
      },error =>{
          this.logService.error("check " + error.message); 
      });
    
      } 

      onCancelReport() {    
        this.selectedReport="";
        this.ifFilterConfigLoaded=false;
        this.columnDefs=[];
        this.rowData=[]; 
       console.log("To be Implemented");        
      }

      onHandleError() {
        this.errorObj = null;
      }
    
} 