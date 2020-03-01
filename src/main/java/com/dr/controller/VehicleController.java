package com.dr.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dr.entity.Vehicle;
import com.dr.error.ResourceNotFoundException;
import com.dr.repository.VehicleRepository;

/**
 * rest controller to handle request related to vehicle creation
 * @author rathod
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/v1")
public class VehicleController {
	
	/**
	 * repository providing crud apis
	 */
	@Autowired
	private VehicleRepository repository;
	
	/**
	 * lists all vehicles
	 * @return
	 */
	@GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

	/**
	 * finds vehicle
	 * @param vehicleId
	 * @return
	 * @throws ResourceNotFoundException
	 */
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") final Long vehicleId)
        throws ResourceNotFoundException {
        final Vehicle vehicle = repository.findById(vehicleId)
          .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));
        return ResponseEntity.ok().body(vehicle);
    }
    
    /**
     * adds vehicle
     * @param vehicle
     * @return
     */
    @PostMapping("/vehicles")
    public Vehicle createVehicle(@Valid @RequestBody final Vehicle vehicle) {
        return repository.save(vehicle);
    }

    /**
     * updates vehicle
     * @param vehicleId
     * @param vehicleDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") final Long vehicleId,
         @Valid @RequestBody Vehicle vehicleDetails) throws ResourceNotFoundException {
    	final Vehicle vehicle = repository.findById(vehicleId)
        .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));

    	vehicle.setManufacturer(vehicleDetails.getManufacturer());
    	vehicle.setModel(vehicleDetails.getModel());
    	vehicle.setType(vehicleDetails.getType());
    	vehicle.setYear(vehicleDetails.getYear());
        final Vehicle updatedVehicle = repository.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    /**
     * deletes vehicle
     * @param vehicleId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/vehicles/{id}")
    public Map<String, Boolean> deleteVehicle(@PathVariable("id") final Long vehicleId)
         throws ResourceNotFoundException {
    	final Vehicle vehicle = repository.findById(vehicleId)
       .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));

        repository.delete(vehicle);
        final ConcurrentHashMap<String, Boolean> response = new ConcurrentHashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
