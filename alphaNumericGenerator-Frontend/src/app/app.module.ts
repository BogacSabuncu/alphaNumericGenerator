  
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {DataService} from '../services/data.service';
import { AppComponent } from './app.component';
import {JwPaginationComponent} from "jw-angular-pagination";

@NgModule({
  declarations: [
    AppComponent,
    JwPaginationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }