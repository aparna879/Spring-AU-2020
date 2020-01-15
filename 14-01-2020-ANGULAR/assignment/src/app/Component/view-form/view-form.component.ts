import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormServiceService } from 'src/app/Providers/form-service.service';
let data3 = {
  email2 : '',
  name2: '',
  phone2: '',
};
@Component({
  selector: 'app-view-form',
  templateUrl: './view-form.component.html',
  styleUrls: ['./view-form.component.scss']
})
export class ViewFormComponent implements OnInit {

  constructor(public formservice: FormServiceService) { }

  email3;
  name3;
  phone3;

  ngOnInit() {
    data3 = this.formservice.getdata();
    console.log(data3);
    this.email3 = data3.email2;
    this.name3 = data3.name2;
    this.phone3 = data3.phone2;
    console.log(this.email3);
    console.log(this.name3);
    console.log(this.phone3);
  }
  
  ngOnDestroy(){
  }

}
