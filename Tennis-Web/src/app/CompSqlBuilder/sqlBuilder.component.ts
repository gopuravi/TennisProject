import { Component, OnInit, Input } from '@angular/core';
import { QueryBuilderConfig,QueryBuilderClassNames } from 'angular2-query-builder';


@Component({

    selector: 'sqlBuilderSel',
    templateUrl:'./sqlBuilder.component.html' ,
    styleUrls: ['./sqlBuilder.component.css'] 

})

export class sqlBuilderComponenet implements OnInit{ 

  @Input() public config: QueryBuilderConfig; 
  
    ngOnInit(){                
        console.log("Inside Query Builder Init Component Init4 ");
    }

    query = {
        condition: 'and',
       rules: [
         /*  {field: 'age', operator: '<=', value: 'Bob'},
          {field: 'gender', operator: '>=', value: 'm'} */
        ]
      };

      getQuery(){
        return this.query;
      }
      
      /*config: QueryBuilderConfig = { 
        fields: {
          "NO_OF_ACCOUNTS_SCREENED": {
              "operators": [
                  "Not Equals",
                  "Greater Than",
                  "Equals",
                  "Is Null",
                  "Is Not Null",
                  "Less Than",
                  "Greater Than or Equal To",
                  "Less Than or Equal to"
              ],
              "name": "No of accounts screened",
              "type": "number"
          },
          "DISPLAY_BU_NAME": {
              "operators": [
                  "Equals",
                  "Like",
                  "Is Not Null",
                  "Not Equals",
                  "Is Null"
              ],
              "name": "Display Bu Id",
              "type": "string"
          },
          "PROCESSING_START_DATE": {
              "operators": [
                  "Is Null",
                  "Not Equals",
                  "Equals",
                  "Greater Than",
                  "Less Than",
                  "Is Not Null",
                  "Less Than or Equal to",
                  "Greater Than or Equal To"
              ],
              "name": "Processing start date",
              "type": "date"
          }
        } 
        
      } */
  


      classNames: QueryBuilderClassNames = {
        removeIcon: 'fa fa-minus', 
        addIcon: 'fa fa-plus',
        arrowIcon: 'fa fa-chevron-right px-2',
        button: 'btn',
        buttonGroup: 'btn-group',
        rightAlign: 'order-12 ml-auto',
        switchRow: 'd-flex px-2',
        switchGroup: 'd-flex align-items-center',
        switchRadio: 'custom-control-input',
        switchLabel: 'custom-control-label',
        switchControl: 'custom-control custom-radio custom-control-inline',
        row: 'row p-2 m-1',
        rule: 'border',
        ruleSet: 'border',
        invalidRuleSet: 'alert alert-danger',
        emptyWarning: 'text-danger mx-auto',
        operatorControl: 'form-control',
        operatorControlSize: 'col-auto pr-0',
        fieldControl: 'form-control',
        fieldControlSize: 'col-auto pr-0',
        entityControl: 'form-control',
        entityControlSize: 'col-auto pr-0',
        inputControl: 'form-control',
        inputControlSize: 'col-auto'
      }
} 