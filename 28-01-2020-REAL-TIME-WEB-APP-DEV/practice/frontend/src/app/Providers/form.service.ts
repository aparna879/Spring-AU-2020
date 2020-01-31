import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(public http: HttpClient) {}

  addStudent(id,name,branch){
    let StudentObj = {
      id:id,
      name:name,
      branch:branch
    };
    return this.http.post("student/form",StudentObj);
  }

  getStudent(){
    return this.http.get("student/view");
  }
}
