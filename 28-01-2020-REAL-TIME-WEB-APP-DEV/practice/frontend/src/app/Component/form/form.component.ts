import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FormService } from 'src/app/Providers/form.service';

let data = {
  id : '',
  name: '',
  branch: '',
};

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  constructor(public formservice : FormService) {}

  profileForm = new FormGroup({
    id : new FormControl(),
    name: new FormControl(),
    branch: new FormControl()
  });

  ngOnInit() {
  }

  addData(){
    data.id = this.profileForm.value.id;
    data.name = this.profileForm.value.name;
    data.branch = this.profileForm.value.branch;
    this.formservice.addStudent(data.id,data.name,data.branch).subscribe((details)=> console.log(details));
  }
}
