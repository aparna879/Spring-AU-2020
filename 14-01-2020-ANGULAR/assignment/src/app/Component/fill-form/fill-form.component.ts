import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FormServiceService } from 'src/app/Providers/form-service.service';

let data = {
  email1 : '',
  name1: '',
  phone1: '',
};

@Component({
  selector: 'app-fill-form',
  templateUrl: './fill-form.component.html',
  styleUrls: ['./fill-form.component.scss']
})

export class FillFormComponent implements OnInit {
  
constructor(public formservice: FormServiceService) { }



  profileForm = new FormGroup({
    email: new FormControl('ENTER EMAIL', Validators.email),
    name: new FormControl('ENTER NAME'),
    phone: new FormControl('ENTER PHONE NO.',Validators.required),
  });

  pass(){
    data.email1 = this.profileForm.value.email;
    data.name1 = this.profileForm.value.name;
    data.phone1 = this.profileForm.value.phone;
    //console.log(data);
  }
  
  ngOnInit() {
  }

  ngOnDestroy(){
    this.formservice.setdata(data);
    console.log(data);
  }


}