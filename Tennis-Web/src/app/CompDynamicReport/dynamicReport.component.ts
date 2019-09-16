import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

import {AppData } from '../model/AppData.model';
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service';



 
@Component({

    selector: 'dynamicReportSel',
    templateUrl:'./dynamicReport.component.html' ,
    styleUrls: ['./dynamicReport.Componenet.css']
})

export class dynamicReportComponenet implements OnInit{ 
   appData:AppData=AppData.Instance;
   reportList:Array<string>;
   columnDefs=[];
   rowData=[]; 
    selectedConnection:any="DBTENNIS";
    errorObj: any = null;
    connectionList={};
    

    @ViewChild('dynamicSQLInput', { static: false }) dynamicSQLInputRef: ElementRef;    
    constructor(private appDataService:AppDataService , private  logService:LoggingService){
       console.log("inside dynamic report Constructor");      
     }
   
    ngOnInit(){ 
        console.log(this.appData.reportlist);
        this.reportList=this.appData.reportlist;       
        console.log("Inside Dynamic Component Init4 " + this.reportList );
        this.getConnectionList();

    } 
    getConnectionList(){
        this.appDataService.getConnectionList().subscribe( responseData=>{

          console.log("The connection list is " , responseData);
          this.connectionList=responseData;
         /* this.connectionList.forEach((item) => {
            console.log(item['connectionName']); 
          
          });  */ 

         
        },error =>{
            this.logService.error("check " + error.message); 
        });
        this.logService.log("inside getConnectionList" ); 
        
    }

    onExecuteReport() {    
        console.log("selectedConnection..."  + this.selectedConnection);          
       var dynamicSQLInput = this.dynamicSQLInputRef.nativeElement.value;
        this.appDataService.runDynamicReport(dynamicSQLInput,this.selectedConnection).subscribe(responseData=>{
          console.log("The response data is", responseData);
            this.columnDefs=responseData[0];
            this.rowData=responseData[1];
        },error =>{
          this.errorObj=error;
            this.logService.error("inside onExecuteReport " + error.message); 
        }); 
         
       // columnDefs = this.appData.dynamicReportHeader; */
      } 

      onCancelReport() {    
       console.log("To be Implemented");        
      }

     

      onHandleError() {
        this.errorObj = null;
      }
 
} 