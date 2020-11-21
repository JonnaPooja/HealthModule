package com.onlineterminsurance.App.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineterminsurance.App.entity.HealthModule;
import com.onlineterminsurance.App.repository.UserDetailsDaoImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserDetailsDaoImplTest {

	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */
	
	@Autowired
	private UserDetailsDaoImpl userdetails;
	@Autowired
	private TestEntityManager testEntityManager;
	@Test
	public void testNewUserDetails() throws Exception{
		HealthModule health=getUserDetails();
		HealthModule saveInDb=testEntityManager.persist(health);
		HealthModule getFromInDb=userdetails.findById(saveInDb.getMedicalId()).get();
				assertThat(getFromInDb).isEqualTo(saveInDb);
}
	private HealthModule getUserDetails() {
		HealthModule health=new HealthModule();
	    //health.setMedicalId(100);
	    health.setAadharNo("312345678910");
	    health.setName("priya");
	    health.setAddress("Tirupati");
        health.setPhoneNo("7123456789");
        health.setAge(28);
	    return health;
	}
	
	
	
	@Test
	public void testGetUserDetailsById() throws Exception{
		HealthModule health=new HealthModule();
	    //health.setMedicalId(102);
	    health.setAadharNo("312345678910");
	    health.setName("kumar");
	    health.setAddress("Chennai");
        health.setPhoneNo("7123456789");
        health.setAge(29);
        HealthModule saveInDb=testEntityManager.persist(health);
        HealthModule getInDb=userdetails.findById(health.getMedicalId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	@Test
	public void testGetAllUserDetails() throws Exception{
		
		HealthModule health1=new HealthModule();
	   // health1.setMedicalId(103);
	    health1.setAadharNo("312345678910");
	    health1.setName("pooja");
	    health1.setAddress("Tirupati");
        health1.setPhoneNo("7123456789");
        health1.setAge(28);
        
        HealthModule health2=new HealthModule();
       // health2.setMedicalId(103);
	    health2.setAadharNo("312345678910");
	    health2.setName("kaveri");
	    health2.setAddress("Tirupati");
        health2.setPhoneNo("7123456789");
        health2.setAge(28);
        testEntityManager.persist(health1);
        testEntityManager.persist(health2);
        List<HealthModule> userList=(List<HealthModule>) userdetails.findAll();
        Assert.assertEquals(2, userList.size());
        }
	@Test
	public void testDeleteUserDetailsById() throws Exception{
		HealthModule health=new HealthModule();
	   // health.setMedicalId(102);
	    health.setAadharNo("312345678910");
	    health.setName("kalyan");
	    health.setAddress("Chennai");
        health.setPhoneNo("7123456789");
        health.setAge(29);
       
        
        HealthModule health1=new HealthModule();
	    //health1.setMedicalId(105);
	    health1.setAadharNo("312345678910");
	    health1.setName("kavya");
	    health1.setAddress("Chennai");
        health1.setPhoneNo("7123456789");
        health1.setAge(29);
        HealthModule health2=testEntityManager.persist(health);
        testEntityManager.persist(health1);
        testEntityManager.remove(health2);
        List<HealthModule> userList=(List<HealthModule>) userdetails.findAll();
        Assert.assertEquals(userList.size(),1);
        
	}
	@Test
	public void testUpdateUserDetails()
	{
		HealthModule health1=new HealthModule();
	    //health1.setMedicalId(105);
	    health1.setAadharNo("312345678910");
	    health1.setName("kavya");
	    health1.setAddress("Chennai");
        health1.setPhoneNo("7123456789");
        health1.setAge(29);
        testEntityManager.persist(health1);
        HealthModule getFromDb=userdetails.findById(health1.getMedicalId()).get();
        getFromDb.setAge(40);
        testEntityManager.persist(getFromDb);
        assertThat(getFromDb.getAge()).isEqualTo(40);
	}


}
