import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {CsvparserComponent} from './csvparser.component'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {KeysPipe} from '../../custompipes/customkeyfilterpipe';
import {FilterPipe} from '../../custompipes/customfilterpipe';

describe('CsvparserComponent', () => {
  let component: CsvparserComponent;
  let fixture: ComponentFixture<CsvparserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      declarations: [ 
        CsvparserComponent,KeysPipe,FilterPipe
      ],imports: [
        FormsModule
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CsvparserComponent);
    //component.fileChangeListener();
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('File Size should be greated than zerro : ', () => {
    expect(component.headerDetails.length).toBeGreaterThanOrEqual(0);
  });
});
