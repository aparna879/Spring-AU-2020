import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FormServiceService {
  data1 ={
    email2 : '',
    name2: '',
    phone2: '',
  }
  constructor() { }

  getdata(){
    return this.data1;
  }

  setdata(data){
    this.data1.email2 = data.email1;
    this.data1.name2 = data.name1;
    this.data1.phone2 = data.phone1;
  }
}
