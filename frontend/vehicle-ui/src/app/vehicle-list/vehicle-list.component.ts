import { VehicleDetailsComponent } from '../vehicle-details/vehicle-details.component';
import { Observable } from "rxjs";
import { VehicleService } from "../vehicle.service";
import { Vehicle } from "../vehicle";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit {

  vehicles: Observable<Vehicle[]>;

  constructor(private vehicleService: VehicleService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.vehicles = this.vehicleService.getVehiclesList();
  }

  deleteVehicle(id: number) {
    this.vehicleService.deleteVehicle(id)
        .subscribe(
          data => {
            console.log(data);
            this.reloadData();
          });
  }

  vehicleDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
