package com.onlineterminsurance.App.service;
import java.util.List;

import com.onlineterminsurance.App.entity.HealthModule;
import com.onlineterminsurance.App.exception.ResourceNotFoundException;


public interface UserDetailsService {
	public List<HealthModule> getAllUserDetails();
	 public HealthModule saveUserDetails(HealthModule health);
	 public HealthModule updateUserDetailsById(Integer medicalId,HealthModule healths) throws ResourceNotFoundException;
	 public boolean deleteUserDetails(Integer medicalId) throws ResourceNotFoundException;
	 public HealthModule getUserDetailsById(Integer medicalId) throws ResourceNotFoundException;

}
