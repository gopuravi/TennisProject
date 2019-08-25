import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { viewReportComponenet } from './CompViewReport/viewReport.component';
import { createReportComponenet } from './CompCreateReport/createReport.component';
import { AppComponent } from './app.component';


const routes: Routes = [
 // { path: '', component: AppComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
