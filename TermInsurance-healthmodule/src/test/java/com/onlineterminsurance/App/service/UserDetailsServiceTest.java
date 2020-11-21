package com.onlineterminsurance.App.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineterminsurance.App.entity.HealthModule;
import com.onlineterminsurance.App.repository.UserDetailsDaoImpl;
import com.onlineterminsurance.App.service.UserDetailsService;



@RunWith(SpringRunner.class)
@SpringBootTest
 class UserDetailsServiceTest {
	 @MockBean
	 private UserDetailsDaoImpl userDetailsDaoImpl;
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	
	 @Test
	public void testGetUserById() throws Exception{
		 HealthModule health=new HealthModule();
		 health.setMedicalId(100);
		 health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);
	        Mockito.when(userDetailsDaoImpl.findByMedicalId(100)).thenReturn(health);
	        assertThat(userDetailsService.getUserDetailsById(100)).isEqualTo(health);
		    }


	@Test
	void testDeleteUser() throws Exception {
		 HealthModule health=new HealthModule();
		 health.setMedicalId(12);
		 health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);
	        userDetailsDaoImpl.deleteById(health.getMedicalId());
        System.out.println(userDetailsDaoImpl.findById(12));
        Assert.assertTrue(userDetailsDaoImpl.findById(12).isEmpty());
	}

	@Test
	void testUpdateUserById() throws Exception {
		 HealthModule health=new HealthModule();
		 health.setMedicalId(50);
		 health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);

	        Mockito.when(userDetailsDaoImpl.findByMedicalId(50)).thenReturn(health);
		       health.setAge(40);
		        Mockito.when(userDetailsDaoImpl.save(health)).thenReturn(health);
		        System.out.println(health.getAge());
		        //assertThat(userDetailsService.updateUserDetailsById(50,health)).isEqualTo(health);
	}

	@Test
	void testGetAllUsers() {
		HealthModule health=new HealthModule();
		 health.setMedicalId(50);
		 health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);
	        HealthModule health1=new HealthModule();
			 health1.setMedicalId(50);
			 health1.setAadharNo("312345678910");
			    health1.setName("priya");
			    health1.setAddress("Tirupati");
		        health1.setPhoneNo("7123456789");
		        health1.setAge(28);

        List<HealthModule> healthList = new ArrayList<>();
       healthList.add(health);
        healthList.add(health1);

        Mockito.when(userDetailsDaoImpl.findAll()).thenReturn(healthList);
        assertThat(userDetailsService.getAllUserDetails()).isEqualTo(healthList);
	}

	@Test
	void testSaveUser() {
		HealthModule health=new HealthModule();
		 health.setMedicalId(50);
		 health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);
	}
}

