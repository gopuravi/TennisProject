import { Component, OnInit , ViewChild} from '@angular/core';
import { AppDataService } from '../service/AppData.service';
import { LoggingService } from '../service/Logging.service'
import { AppData } from '../model/AppData.model';

import {Observable, of,merge,Subject} from 'rxjs';
import {catchError, debounceTime, distinctUntilChanged, map, tap, switchMap,filter} from 'rxjs/operators';




import {NgbTypeahead, NgbTypeaheadModule} from '@ng-bootstrap/ng-bootstrap';


 
@Component({

    selector: 'viewReportSel',
    templateUrl:'./viewReport.component.html' ,
    styleUrls: ['./viewReport.component.css']

})

export class viewReportComponenet implements OnInit{ 


   appData:AppData=AppData.Instance;


   selectedReport : any;
  searching = false;
  searchFailed = false;
  columnDefs=[];
  rowData=[]; 
    
  

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

    onExecuteReport() {    
        console.log("selectedConnection..."  + this.selectedReport.reportIdentifier   );           
        this.appDataService.runStaticReport(this.selectedReport.reportIdentifier).subscribe(responseData=>{
          this.columnDefs=responseData[0];
          this.rowData=responseData[1];
      },error =>{
          this.logService.error("check " + error.message); 
      });

      
      } 

      onCancelReport() {    
       console.log("To be Implemented");        
      }

}