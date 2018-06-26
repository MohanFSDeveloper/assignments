import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {KeysPipe} from './custompipes/customkeyfilterpipe';
import {FilterPipe} from './custompipes/customfilterpipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CsvparserComponent } from './components/csvparser/csvparser.component';
@NgModule({
  declarations: [
    AppComponent,KeysPipe,FilterPipe, CsvparserComponent
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
