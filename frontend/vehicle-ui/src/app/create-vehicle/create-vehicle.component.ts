import { VehicleService } from '../vehicle.service';
import { Vehicle } from '../vehicle';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-vehicle',
  templateUrl: './create-vehicle.component.html',
  styleUrls: ['./create-vehicle.component.scss']
})
export class CreateVehicleComponent implements OnInit {

  vehicle: Vehicle = new Vehicle();
  submitted = false;

  constructor(private vehicleService: VehicleService, private router: Router) { }

  ngOnInit(): void {
  }

  newVehicle(): void {
    this.submitted = false;
    this.vehicle = new Vehicle();
  }

  save() {
    this.vehicleService.createVehicle(this.vehicle)
        .subscribe(data => console.log(data), error => console.log(error));
    this.vehicle = new Vehicle();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/vehicles']);
  }
}
