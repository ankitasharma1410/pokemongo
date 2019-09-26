package com.demo.pokemon.resource;

import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/healthcheck")
public class HealthCheckResource {

	@RequestMapping(path = "alive", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN)
	public ResponseEntity<String> alive() {
		return ResponseEntity.ok("alive");

	}

}
