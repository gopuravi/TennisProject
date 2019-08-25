import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AgGridModule } from 'ag-grid-angular';

import { viewReportComponenet } from './CompViewReport/viewReport.component';
import { createReportComponenet } from './CompCreateReport/createReport.component';
import { headerComponenet } from './CompHeader/header.component';
import { AppDataService } from './service/AppData.service';
import { AppData } from './model/AppData.model';
import { LoggingService } from './service/Logging.service';
import { dynamicReportComponenet } from './CompDynamicReport/dynamicReport.component';
import { ReportNameFilter } from './pipe/reportNameFilter.pipe';
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    AppComponent,
    headerComponenet,
    viewReportComponenet,
    createReportComponenet,
    dynamicReportComponenet,
    ReportNameFilter

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbTypeaheadModule,
    AgGridModule.withComponents([])
    
  ],
  providers: [AppDataService,LoggingService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
