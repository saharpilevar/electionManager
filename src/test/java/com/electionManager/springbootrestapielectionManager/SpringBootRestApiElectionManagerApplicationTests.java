package com.electionManager.springbootrestapielectionManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import com.electionManager.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestApiElectionManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootRestApiElectionManagerApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetAllElections() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/GetAllElections",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}
	
	
	@Test
	public void testCreateElection() {
		Election elect = new Election();
		elect.setTitle("testTitle");
		elect.setEndTime("testEndTime");
		elect.setStartTime("testStartTime");
		elect.setNumberOfVotes(2);
		//elect.setListOfChoices(new ArrayList<String>());

		

		ResponseEntity<Election> postResponse = restTemplate.postForEntity(getRootUrl() + "/CreateElection", elect, Election.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	
	
	@Test
	public void testEditElection() {
		int id = 1;
		Election elect = restTemplate.getForObject(getRootUrl() + "/EditElection/" + id, Election.class);
		elect.setEndTime("editedEndTime");
		elect.setNumberOfVotes(5);

		restTemplate.put(getRootUrl() + "/EditElection/" + id, elect);

		Election editedElection = restTemplate.getForObject(getRootUrl() + "/EditElection/" + id, Election.class);
		Assert.assertNotNull(editedElection);
	}

	@Test
	public void testRemoveElection() {
		int id = 2;
		Election elect = restTemplate.getForObject(getRootUrl() + "/RemoveElection/" + id, Election.class);
		Assert.assertNotNull(elect);

		restTemplate.delete(getRootUrl() + "/RemoveElection/" + id);

		try {
			elect = restTemplate.getForObject(getRootUrl() + "/RemoveElection/" + id, Election.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
	

	@Test
	public void testGetElectionDetails() {
		Election elect = restTemplate.getForObject(getRootUrl() + "/GetElectionDetails/1", Election.class);
		System.out.println(elect.toString());
		Assert.assertNotNull(elect);
	}

}







