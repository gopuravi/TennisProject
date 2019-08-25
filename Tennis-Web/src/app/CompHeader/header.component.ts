import { Component, EventEmitter, Output } from '@angular/core';
import { Constant } from '../model/Constant.model';

@Component({
    selector: 'headerSel',
    templateUrl:'./header.component.html'

})
export class headerComponenet{

    constant:Constant=Constant.Instance;
    
    @Output() featureSelected=new EventEmitter<string>();

    onSelect(feature:string){
        console.log("The Emitted Event is " + feature)
        this.featureSelected.emit(feature);

    }


}