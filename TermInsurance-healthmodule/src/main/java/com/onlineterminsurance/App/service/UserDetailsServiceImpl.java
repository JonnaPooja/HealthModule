package com.onlineterminsurance.App.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineterminsurance.App.entity.HealthModule;
import com.onlineterminsurance.App.exception.ResourceNotFoundException;
import com.onlineterminsurance.App.repository.UserDetailsDaoImpl;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDaoImpl userdetails;
	

	public HealthModule getUserDetailsById(Integer medicalId)
			throws ResourceNotFoundException {
		HealthModule  health =userdetails.findByMedicalId(medicalId);
		if(health==null)
		{
			 new ResourceNotFoundException("User not found for this id :: " + medicalId);
		}
		return health;
	}

	public boolean deleteUserDetails(Integer medicalId)
			throws ResourceNotFoundException {
	 HealthModule health = userdetails.findById(medicalId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + medicalId));

	 userdetails.delete(health);
	 if(null == health){
            return true;
        }
        return false;
}
 
	public HealthModule updateUserDetailsById(Integer medicalId,HealthModule healths) throws ResourceNotFoundException {
		 HealthModule health = userdetails.findById(medicalId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + medicalId));
		 health.setAadharNo(healths.getAadharNo());
			health.setName(healths.getName());
			health.setAddress(healths.getAddress());
			health.setPhoneNo(healths.getPhoneNo());
			health.setAge(healths.getAge());
		 
		final HealthModule updatedUser = userdetails.save(health);
		return updatedUser; 
		
	}
	public HealthModule saveUserDetails(HealthModule health) {
		
		return userdetails.save(health);
	}
	 public List<HealthModule> getAllUserDetails() {
			return userdetails.findAll();
			}
		 



	
	

	
}


