package com.revature.controllertest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controllers.DAOController;
import com.revature.models.Friend;
import com.revature.models.Location;
import com.revature.models.MUser;
import com.revature.models.Preference;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DAOControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	DAOController dc;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void returnAUser() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users/1", MUser.class).getFirstName()).isNotNull();
	}
	@Test
	public void returnsNotAUser() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users/0", MUser.class).getEmail()).isNull();
	}
	@Test
	public void returnAPreference() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/preferences/pref/1/1", Preference.class).getGenre()).isNotNull();
	}
	@Test
	public void returnAFriend() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/friends/1", Friend.class).getIsFriendsWith()).isNotNull();
	}
	@Test
	public void returnALocation() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/locations/1", Location.class).getCity()).isNotNull();
	}
	@Test
	public void returnsAList() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/preferences/", List.class)).isInstanceOf(List.class);
	}
}
