import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { CreateVehicleComponent } from './create-vehicle/create-vehicle.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { UpdateVehicleComponent } from './update-vehicle/update-vehicle.component';

const routes: Routes = [
  { path: '', redirectTo: 'vehicle', pathMatch: 'full' },
  { path: 'vehicles', component: VehicleListComponent },
  { path: 'add', component: CreateVehicleComponent },
  { path: 'update/:id', component: UpdateVehicleComponent },
  { path: 'details/:id', component: VehicleDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }