import { Component, OnInit } from '@angular/core';
import { FormService } from 'src/app/Providers/form.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  details: Object;

  constructor(public formservice : FormService) { }

  ngOnInit() {
    this.formservice.getStudent().subscribe((details)=>{console.log(details);this.details=details})
  }

}
