import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import {CsvparserComponent} from './components/csvparser/csvparser.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {KeysPipe} from './custompipes/customkeyfilterpipe';
import {FilterPipe} from './custompipes/customfilterpipe';
describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,CsvparserComponent,KeysPipe,FilterPipe
      ],imports: [
        FormsModule
      ],
    }).compileComponents();
  }));
  
});
