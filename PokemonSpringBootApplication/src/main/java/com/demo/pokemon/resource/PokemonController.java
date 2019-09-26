package com.demo.pokemon.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pokemon.model.Pokemon;
import com.demo.pokemon.model.Stats;
import com.demo.pokemon.model.User;
import com.demo.pokemon.repository.StaticRepository;

@RestController
@RequestMapping(value = "/api")
public class PokemonController {

	@Autowired
	StaticRepository repository;

	@GetMapping("/pokemons")
	public List<String> listPokemons() {
		return repository.findAll();
	}

	@PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity login(@RequestBody User user) {
		if (user == null)
			throw new RuntimeException(String.format("Invalid User"));

		else if (StringUtils.isEmpty(user.getEmail()))
			throw new RuntimeException(String.format("Invalid Email"));

		else if (StringUtils.isEmpty(user.getPassword()))
			throw new RuntimeException(String.format("Invalid Password"));

		else if (StaticRepository.usersPokemons.containsKey(user))
			throw new RuntimeException(String.format("User already added"));
		repository.registerUser(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	// listPokemonsOfUsers
	@GetMapping("/pokemons/{userid}")
	public List<String> listPokemonsOfUsers(@PathVariable(value = "userid") long userid) {
		return repository.findAllPokemonsOfUser(userid);
	}

	// addPokemonToUser
	@PostMapping("/pokemons/{userid}/{pokemonid}/add")
	public List<Pokemon> addPokemonToUser(@PathVariable(value = "userid") long userid,
			@PathVariable(value = "pokemonid") String pokemonid) {
		return repository.addPokemon(pokemonid, userid);
	}

	// countPokemonsOfUsers
	@GetMapping("/pokemons/{userid}/count")
	public long countPokemonsOfUsers(@PathVariable(value = "userid") long userid) {
		return repository.countAllPokemonsOfUser(userid);
	}

	// deletePokemon
	@DeleteMapping("/pokemons/{userid}/{pokemonid}/delete")
	public List<Pokemon> deletePokemon(@PathVariable(value = "pokemonid") String id,
			@PathVariable(value = "userid") long userid) {
		return repository.remove(id, userid);
	}

	// updatePokemon
	@PutMapping(value = "/pokemons/{userid}/{pokemonid}/put", consumes = "application/json")
	public void updatePokemonPut(@RequestBody Stats newStats, @PathVariable(value = "pokemonid") String id,
			@PathVariable(value = "userid") long userid) {
		repository.updateStats(userid, id, newStats);
	}

	// updatePokemon
	@PatchMapping(value = "/pokemons/{userid}/{pokemonid}/patch", consumes = "application/json")
	public void updatePokemonPatch(@RequestBody Stats newStats, @PathVariable(value = "pokemonid") String id,
			@PathVariable(value = "userid") long userid) {
		repository.updateStats(userid, id, newStats);
	}

}
