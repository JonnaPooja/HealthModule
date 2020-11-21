package com.onlineterminsurance.App.control;

import java.util.List;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineterminsurance.App.entity.HealthModule;
import com.onlineterminsurance.App.exception.ResourceNotFoundException;
import com.onlineterminsurance.App.service.UserDetailsService;



@RestController
@RequestMapping("/api/v2")
public class HealthModuleController {
	@Autowired
	private UserDetailsService userService;

	@GetMapping("/getAllUserDetails")
	public List<HealthModule> getAllUserDetails() {
		return userService.getAllUserDetails();
	}
	@PostMapping("/saveUser")
	public HealthModule createUser( @RequestBody HealthModule health) {
		return userService.saveUserDetails(health);
	} 
	@GetMapping("/getUserDetails/{id}")
	public ResponseEntity<HealthModule> getUserById(@PathVariable(value = "id") Integer medicalId) throws ResourceNotFoundException {
		HealthModule health = userService.getUserDetailsById(medicalId);
		return  ResponseEntity.ok(health);
	}
	@PutMapping("/updateUserDetails/{id}")
	public ResponseEntity<HealthModule> updateUserDetails(@PathVariable(value = "id") Integer medicalId,
			 @RequestBody HealthModule healths) throws ResourceNotFoundException {
		HealthModule health = userService.updateUserDetailsById(medicalId, healths);
		return  ResponseEntity.ok(health);
	}

	@DeleteMapping("/deleteUserDetails/{id}")	
	public ResponseEntity<Boolean> deleteUserDetails(@PathVariable(value = "id") Integer medicalId,@RequestBody HealthModule health) throws ResourceNotFoundException	{
		Boolean health1 = userService.deleteUserDetails(medicalId);
		return  ResponseEntity.ok(health1);
	}
	
   
}
