import { Input, Output, Component ,EventEmitter, OnInit} from '@angular/core';
import { Constant } from 'src/app/model/Constant.model';
import { LoggingService } from 'src/app/service/Logging.service';



@Component({
    selector: 'alertSel',
    templateUrl: './alert.component.html',
    styleUrls: ['./alert.component.css']
  })
   
export class AlertCompoenent implements OnInit{
  private constant:Constant=Constant.Instance;
    @Input() errorObj: any;
    message: string;
    statusCode: Number;
    statusText: string;
    serviceUrl: string;
    @Output() close = new EventEmitter<void>();
  
    onClose() {
      this.close.emit();
    }

    constructor(private  loggingService:LoggingService){

    }
    ngOnInit(){  
        if(this.errorObj){
            this.message=this.constant.ERR_MESSAGE_NOT_AVAILABLE;

            
            if( this.errorObj.error && this.errorObj.error.message){ // for server failure
              this.message=  this.errorObj.error.message;
            } 
            else if(this.errorObj.message){ // for client validation failure
              this.message=  this.errorObj.message;
            }

            this.statusCode=  this.errorObj.status;
            this.statusText=  this.errorObj.statusText;
            this.serviceUrl= this.errorObj.url;       

            if(this.statusCode===0 && !this.message){
              this.message=this.constant.ERR_SERVER_NOT_AVAILABLE; 
            }
            this.loggingService.log(this.message, this.statusCode , this.statusText, this.serviceUrl) 
        } 
       // loggingService.log("Inside the alertcomponent "); 
    }  
}     
