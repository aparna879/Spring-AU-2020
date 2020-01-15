import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewFormComponent } from './Component/view-form/view-form.component';
import { FillFormComponent } from "./Component/fill-form/fill-form.component";
import { NotFoundComponent } from './Component/not-found/not-found.component';


const routes: Routes = [
  {path: 'fill-form', component: FillFormComponent},
  {path: 'view-form', component: ViewFormComponent},
  {path: '', component: FillFormComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
