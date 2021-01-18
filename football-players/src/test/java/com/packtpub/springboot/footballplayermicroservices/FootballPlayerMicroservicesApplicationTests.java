package com.packtpub.springboot.footballplayermicroservices;

import com.jayway.jsonpath.JsonPath;
import com.packtpub.springboot.footballplayermicroservices.model.FootballPlayer;
import org.json.JSONArray;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = FootballPlayerMicroservicesApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // TODO not working!
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
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("footballplayer"),
				HttpMethod.GET, entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// the JSONArray used here is from net.minidev.json. It has .size instead of .length
		net.minidev.json.JSONArray jsonArray = JsonPath.read(response.getBody(), "$.[*]");
		assertThat(23).isEqualTo(jsonArray.size());
	}

	// can't find createURlWithPort in a lib, so here's my own version
	private String createURLWithPort(String s) throws MalformedURLException {
		URL url = new URL("http","localhost", port, "/");
		System.out.println(url.toString() + s); // TODO http://localhost:53797/footballplayer/save
		return url.toString() + s;
	}

	@Ignore("Never passing yet. (Not getting Ignored either though!)") // TODO remove once passing
	@Test
	public void test_2_Create() throws IOException {
			System.out.println("create"); // TODO create
		FootballPlayer player = new FootballPlayer("Mauro", "Vocale", 38, "Juventus", "central midfielder", new BigInteger("100"));
			System.out.println(player.getName()); // TODO Mauro
		HttpEntity<FootballPlayer> entity = new HttpEntity<>(player, headers);
			//System.out.println(EntityUtils.toString((org.apache.http.HttpEntity) entity));
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("footballplayer/save"),
				HttpMethod.POST, entity, String.class); // TODO http://localhost:53797/footballplayer/save

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); // TODO: instead getting 500 INTERNAL_SERVER_ERROR !
		assertThat(response.getBody()).isEqualTo("{\"id\":24,\"name\":\"Mauro\",\"surname\":\"Vocale\",\"age\":38,\"team\":\"Juventus\",\"position\":\"central midfielder\",\"price\":100}");
	};

}
