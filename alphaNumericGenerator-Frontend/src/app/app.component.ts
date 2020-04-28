import { Component, OnInit} from '@angular/core';
import { DataService } from '../services/data.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'AlphaNumeric Generator';

  form: FormGroup;
  
  combination : [];

  count: number;

  pageOfItems: Array<any>;

  constructor(private dataService:DataService){
    this.form = this.createFormGroup();
  }

  ngOnInit(){
  }

  createFormGroup() {
    return new FormGroup({
      phonenumber: new FormControl('', [Validators.required, Validators.minLength(7), Validators.maxLength(10), Validators.pattern("^[0-9]*$")]),
    });
  }

  get phonenumber() {
    return this.form.get('phonenumber');
  }

  onSubmit(){
    this.dataService.getComb(this.phonenumber.value).subscribe(data => {this.combination = data;
      this.count = data.length;
      console.log(this.combination);
    })

  }

  onChangePage(pageOfItems: Array<any>) {
    // update current page of items
    this.pageOfItems = pageOfItems;
}
}
