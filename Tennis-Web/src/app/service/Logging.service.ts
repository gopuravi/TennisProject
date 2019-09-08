import { Message } from '@angular/compiler/src/i18n/i18n_ast';

export class LoggingService{
    log(...messageList:any[]){
        console.log(messageList);
  
    }
    error(message:any){
        console.error(message);
    }    
}  