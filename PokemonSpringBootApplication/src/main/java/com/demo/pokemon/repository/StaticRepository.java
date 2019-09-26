package com.demo.pokemon.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.demo.pokemon.PokemonSpringBootApplication;
import com.demo.pokemon.model.Pokemon;
import com.demo.pokemon.model.Stats;
import com.demo.pokemon.model.User;

@Service
public class StaticRepository {

	public static Map<User, List<Pokemon>> usersPokemons = new HashMap<>();

	public Pokemon get(String pokemonId) {
		if (PokemonSpringBootApplication.pokemons.containsKey(pokemonId))
			return PokemonSpringBootApplication.pokemons.get(pokemonId);
		throw new RuntimeException(String.format("Pokemon id %s not found.", pokemonId));
	}

	public void updateStats(long userId, String pokemonId, Stats newStats) {
		if (!PokemonSpringBootApplication.pokemons.containsKey(pokemonId))
			throw new RuntimeException(String.format("Pokemon id %s not found.", pokemonId));
		User user = getUser(userId);
		if (user == null)
			throw new RuntimeException(String.format("User does not exist."));
		List<Pokemon> pokemon = usersPokemons.get(user);
		System.out.println(getPokemon(pokemonId, pokemon).getStats().getBaseAttack() +"------"+getPokemon(pokemonId, pokemon).getStats().getBaseDefense());
		getPokemon(pokemonId, pokemon).setStats(newStats);
	}

	public List<Pokemon> addPokemon(String pokemonId, long userid) {
		User user = getUser(userid);
		List<Pokemon> listOfUsersPokemons = new ArrayList<>();
		if (user == null) {
			throw new RuntimeException(String.format("User does not exist."));
		} else {
			listOfUsersPokemons = usersPokemons.get(user);
			if (listOfUsersPokemons.stream().anyMatch(p -> p.getId().equals(pokemonId))) {
				throw new RuntimeException(String.format("Pokemon id %s already added", pokemonId));
			}
			if (!PokemonSpringBootApplication.pokemons.containsKey(pokemonId)) {
				throw new RuntimeException(String.format("Pokemon id %s not found", pokemonId));
			}
			if (PokemonSpringBootApplication.pokemons.containsKey(pokemonId)) {
				listOfUsersPokemons.add(PokemonSpringBootApplication.pokemons.get(pokemonId));
			}
		}
		return listOfUsersPokemons;
	}

	public void registerUser(User user) {
		usersPokemons.put(user, new ArrayList<>());
	}

	public List<Pokemon> remove(String pokemonId, long userid) {
		if (!PokemonSpringBootApplication.pokemons.containsKey(pokemonId))
			throw new RuntimeException(String.format("Pokemon id %s not found.", pokemonId));
		User user = getUser(userid);
		if (user == null) {
			throw new RuntimeException(String.format("User does not exist."));
		}
		List<Pokemon> pokemonList = usersPokemons.get(user);
		if (pokemonList.isEmpty())
			throw new RuntimeException(String.format("No pokemons yet"));
		if (!pokemonList.stream().anyMatch(p -> p.getId().equals(pokemonId))) {
			throw new RuntimeException(String.format("Pokemon id %s not added hence cannot be removed", pokemonId));
		}
		pokemonList.remove(PokemonSpringBootApplication.pokemons.get(pokemonId));
		return pokemonList;
	}

	public List<String> findAll() {
		List<String> pokemons = new ArrayList<>();
		for (Entry<String, Pokemon> s : PokemonSpringBootApplication.pokemons.entrySet()) {
			pokemons.add(s.getValue().getName());
		}
		return pokemons;
	}

	public List<String> findAllPokemonsOfUser(long userid) {
		User user = getUser(userid);
		if (user == null) {
			throw new RuntimeException(String.format("User does not exist."));
		}
		if (usersPokemons.get(user).isEmpty())
			throw new RuntimeException(String.format("No pokemons yet"));
		List<String> pokemons = new ArrayList<>();
		for (Pokemon s : usersPokemons.get(user)) {
			pokemons.add(s.getName());
		}
		return pokemons;
	}

	public long countAllPokemonsOfUser(long userid) {
		User user = getUser(userid);
		if (user == null) {
			throw new RuntimeException(String.format("User does not exist."));
		}
		List<Pokemon> pokemonList = usersPokemons.get(user);
		if (pokemonList.isEmpty())
			throw new RuntimeException(String.format("No pokemons yet"));
		return pokemonList.stream().count();
	}

	private User getUser(long userId) {
		for (Entry<User, List<Pokemon>> s : usersPokemons.entrySet()) {
			if (userId == s.getKey().getUserid()) {
				return s.getKey();
			}
		}
		return null;
	}

	private Pokemon getPokemon(String pokemonId, List<Pokemon> pokemons) {
		for (Pokemon pokemon : pokemons) {
			if (pokemonId.equals(pokemon.getId()))
				return pokemon;
		}
		return null;
	}
}
