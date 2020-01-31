import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormComponent } from './Component/form/form.component';
import { ViewComponent } from './Component/view/view.component';


const routes: Routes = [
  {path:"form",component: FormComponent},
  {path:"view",component: ViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
