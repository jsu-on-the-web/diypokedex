package io.uruguayconsultancy.diypokedex.pokemon;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
public class PokemonService {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Pokemon createPokemon(CreatePokemonDTO data) {
        Pokemon pokemon = modelMapper.map(data, Pokemon.class);
        Pokemon savedPokemon = this.pokemonRepository.save(pokemon);
        return savedPokemon;
    }
}