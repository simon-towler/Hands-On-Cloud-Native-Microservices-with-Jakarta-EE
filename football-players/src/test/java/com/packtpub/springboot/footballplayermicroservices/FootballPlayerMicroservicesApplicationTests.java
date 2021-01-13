package com.packtpub.springboot.footballplayermicroservices;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = FootballPlayerMicroservicesApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FootballPlayerMicroservicesApplicationTests {

	private final HttpHeaders headers = new HttpHeaders();

	private final TestRestTemplate restTemplate = new TestRestTemplate();

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	public void test_1_FindAll() throws IOException {
		System.out.println("findAll");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/footballplayer"),
				HttpMethod.GET, entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// the JSONArray used here is from net.minidev.json. It has .size instead of .length
		net.minidev.json.JSONArray jsonArray = JsonPath.read(response.getBody(), "$.[*]");
		assertThat(23).isEqualTo(jsonArray.size());
	}

	// can't find createURlWithPort in a lib, so here's my own version
	private String createURLWithPort(String s) throws MalformedURLException {
		URL url = new URL("http","localhost", port, "/");
		System.out.println(url.toString() + s);
		return url.toString() + s;
	}

}
