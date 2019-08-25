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
    selectedConnection:any;
    
    

    @ViewChild('dynamicSQLInput', { static: false }) dynamicSQLInputRef: ElementRef;    
    constructor(private appDataService:AppDataService , private  logService:LoggingService){
       console.log("inside dynamic report Constructor");      
     }
   
    ngOnInit(){ 
        console.log(this.appData.reportlist);
        this.reportList=this.appData.reportlist;       
        console.log("Inside Dynamic Component Init4 " + this.reportList );
      //  this.getConnectionList();

    } 
    getConnectionList(){
/*        this.appDataService.getConnectionList().subscribe( responseData=>{

            var data = JSON.stringify(responseData);
            let option;
            for (let i = 0; i < data.length; i++) {
            option = document.createElement('option');
            option.text = data[i]['connectionId'];
            option.value = data[i]['connectionName'];            
            this.logService.log(option);
            }

           // this.appData.connectionList=responseData; 
        },error =>{
            this.logService.error("check " + error.message); 
        });
        this.logService.log("inside createReport" + this.appData.reportlist); 
        */
    }

    onExecuteReport() {    
        console.log("selectedConnection..."  + this.selectedConnection);          
       var dynamicSQLInput = this.dynamicSQLInputRef.nativeElement.value;
        this.appDataService.runDynamicReport(dynamicSQLInput,this.selectedConnection).subscribe(responseData=>{
            this.columnDefs=responseData[0];
            this.rowData=responseData[1];
        },error =>{
            this.logService.error("check " + error.message); 
        });
        this.logService.log("inside createReport" + this.appData.reportlist);     
       // columnDefs = this.appData.dynamicReportHeader; */
      } 

      onCancelReport() {    
       console.log("To be Implemented");        
      }

      getOrders() {
        return [
          { connectionId: '1', connectionName: 'ANALYZER' },
          { connectionId: '2', connectionName: 'CITISEARCH' },

        ];
      }
 
}