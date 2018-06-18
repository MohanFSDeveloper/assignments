import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-csvparser',
  templateUrl: './csvparser.component.html',
  styleUrls: ['./csvparser.component.css']
})
export class CsvparserComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  headerDetails =[];
  fileDetails = [];
  filePath = "";
  issueCount = "";
  public fileChangeListener(avialbaleFiles: FileList){
    if(avialbaleFiles && avialbaleFiles.length > 0) {
       let file : File = avialbaleFiles.item(0); 
         let reader: FileReader = new FileReader();
         reader.readAsText(file);
         reader.onload = (e) => {
          let csv: string = reader.result.split('"').join('');
           let availableRows = csv.split(/\r|\n|\r/);
          this.headerDetails = availableRows[0].split(',');
          for (let i = 1; i < availableRows.length; i++) {
             let data = availableRows[i].split(',');
             if (data.length === this.headerDetails.length) {
               var eachRow = {};
               for (let j = 0; j < this.headerDetails.length; j++) {
                eachRow[this.headerDetails[j]] =  data[j].split('"').join('');
               }
              this.fileDetails.push(eachRow);
           }
          }
         }
      }
  }
  reset(){
   this.fileDetails =[],this.headerDetails = [],this.filePath = "";;
  }

}
