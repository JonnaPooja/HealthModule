package com.onlineterminsurance.App.control;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineterminsurance.App.control.HealthModuleController;
import com.onlineterminsurance.App.entity.HealthModule;
import com.onlineterminsurance.App.service.UserDetailsService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = HealthModuleController.class)
public class HealthModuleControllerTest {

	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private UserDetailsService userService;
	@Test
	public void testCreateUser() throws Exception{
	        String URI = "/api/v2/saveUser";;
	        HealthModule health = new HealthModule();
	        health.setMedicalId(101);
	        health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);
	        String jsonInput = this.converttoJson(health);

	        Mockito.when(userService.saveUserDetails(Mockito.any(HealthModule.class))).thenReturn(health);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	@Test
	public void testGetUserDetailsById() throws Exception {
		String URI= "/api/v2/getUserDetails/{id}";
         HealthModule health = new HealthModule();
         health.setMedicalId(102);
	        health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);
        
        String jsonInput = this.converttoJson(health);

        Mockito.when(userService.getUserDetailsById(Mockito.any())).thenReturn(health);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	public void testUpdateProduct() throws Exception {
		String URI = "/api/v2/updateUserDetails/{id}";
		HealthModule health = new HealthModule();
        health.setMedicalId(8);
	        health.setAadharNo("379");
		    health.setName("pooja");
		    health.setAddress("111");
	        health.setPhoneNo("999");
	        health.setAge(78);
       
        String jsonInput = this.converttoJson(health);

        Mockito.when(userService.updateUserDetailsById(Mockito.any(),Mockito.any())).thenReturn(health);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,8).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	public void testDeleteProduct() throws Exception {
		String URI = "/api/v2/deleteUserDetails/{id}";
		HealthModule health = new HealthModule();
        health.setMedicalId(105);
	        health.setAadharNo("312345678910");
		    health.setName("priya");
		    health.setAddress("Tirupati");
	        health.setPhoneNo("7123456789");
	        health.setAge(28);

        Mockito.when(userService.getUserDetailsById(Mockito.any())).thenReturn(health);
        Mockito.when(userService.deleteUserDetails(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	@Test
	public void testGetAllUserDetails() throws Exception {
		String URI = "/api/v2/getAllUserDetails";
		HealthModule health = new HealthModule();
        health.setMedicalId(105);
		health.setAadharNo("312345678910");
	    health.setName("priya");
	    health.setAddress("Tirupati");
        health.setPhoneNo("7123456789");
        health.setAge(28);

        HealthModule health1 = new HealthModule();
        health1.setMedicalId(108);   
        health1.setAadharNo("312345678910");
	    health1.setName("priya");
	    health1.setAddress("Tirupati");
        health1.setPhoneNo("7123456789");
        health1.setAge(28);

	    	 List<HealthModule> healthList=new ArrayList<>();
	    healthList.add(health);
	   healthList.add(health1);
	    	 
	    	String jsonInput = this.converttoJson(healthList);

	         Mockito.when(userService.getAllUserDetails()).thenReturn(healthList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	private String converttoJson(Object health) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(health);
}
}