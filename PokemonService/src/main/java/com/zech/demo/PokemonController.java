package com.zech.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

	private Pokedex dex;
	
	public PokemonController() {
		dex = new Pokedex();
	}
	
	@GetMapping()
	public String getPokemon() {
		String pokemonName = dex.getPokemon();
		System.out.println(pokemonName);
		return pokemonName;
	}
}
