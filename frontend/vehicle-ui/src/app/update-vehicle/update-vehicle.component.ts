import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../vehicle';
import { ActivatedRoute, Router } from '@angular/router';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-update-vehicle',
  templateUrl: './update-vehicle.component.html',
  styleUrls: ['./update-vehicle.component.scss']
})
export class UpdateVehicleComponent implements OnInit {

  id: number;
  vehicle: Vehicle;

  constructor(private route: ActivatedRoute,private router: Router,
    private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.vehicle = new Vehicle();

    this.id = this.route.snapshot.params['id'];
    
    this.vehicleService.getVehicle(this.id)
      .subscribe(data => {
        console.log(data)
        this.vehicle = data;
      }, error => console.log(error));
  }

  updateVehicle() {
    this.vehicleService.updateVehicle(this.id, this.vehicle)
      .subscribe(data => console.log(data), error => console.log(error));
    this.vehicle = new Vehicle();
    this.gotoList();
  }

  onSubmit() {
    this.updateVehicle();    
  }

  gotoList() {
    this.router.navigate(['/vehicles']);
  }

}
