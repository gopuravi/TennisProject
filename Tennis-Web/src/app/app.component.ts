import { Component } from '@angular/core';
import { AppData } from './model/AppData.model';
import { Constant } from './model/Constant.model';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  appData:AppData=AppData.Instance;
  constant:Constant=Constant.Instance;

  title = this.constant.APPLICATION_TITLE;

  loadedFeature=this.constant.VIEW_REPORT;

  onNavigate(feature:string){
    console.log(this.loadedFeature);
    this.loadedFeature=feature; 
  }

  private _opened: boolean = false;
 
  private _toggleSidebar() {
    this._opened = !this._opened;
  }
}
