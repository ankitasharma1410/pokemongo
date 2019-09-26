package com.demo.pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.demo.pokemon.model.Pokemon;
import com.demo.pokemon.model.PokemonGroup;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableAutoConfiguration
public class PokemonSpringBootApplication extends SpringBootServletInitializer {

	public static Map<String, Pokemon> pokemons = new HashMap<>();

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PokemonSpringBootApplication.class, args);
		String relativePathToJson = ".\\src\\main\\resources\\pokemon.json";
		byte[] jsonData = Files.readAllBytes(Paths.get(relativePathToJson));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		PokemonGroup group = objectMapper.readValue(jsonData, PokemonGroup.class);

		for (Pokemon pokemon : group.getPokemons()) {
			pokemons.put(pokemon.getId(), pokemon);
		}
	}
}
