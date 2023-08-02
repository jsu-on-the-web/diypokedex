package io.uruguayconsultancy.diypokedex.pokemon;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PokemonService {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Creating a Pokemon
    public Pokemon createPokemon(CreatePokemonDTO data) {
        Pokemon pokemon = modelMapper.map(data, Pokemon.class);
        Pokemon savedPokemon = this.pokemonRepository.save(pokemon);
        return savedPokemon;
    }

    // Getting Pokemon
    public List<Pokemon> getAllPokemon() {
        return this.pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemon(Long id) {
        return this.pokemonRepository.findById(id);
    }


    // Deleting a Pokemon 
    public boolean deletePokemon(Long id) {
        Optional<Pokemon> p = this.pokemonRepository.findById(id);
        if (p.isEmpty()) {
            return false;
        }
        this.pokemonRepository.deleteById(id);
        return true;
    }

    // Updating a Pokemon
    public Optional<Pokemon> updatePokemon(Long id, UpdatePokemonDTO data) {
        Optional<Pokemon> p = this.pokemonRepository.findById(id);
        if (p.isEmpty()) {
            return null;
        }


        Pokemon pokemon = p.get();
        modelMapper.map(data, pokemon);
        this.pokemonRepository.save(pokemon);
        return p;
    }

    public Optional<Pokemon> getMinStat(String stat) {
        if (stat.equals("hp")) {
            return this.pokemonRepository.selectMinHp();
        }

        return null;
    }

    public List<Pokemon> getPokemonOfType(String type) {
        return pokemonRepository.findByType(type);
    }

    public List<Pokemon> findPokemonWithHPHigherThan(int n) {
        return pokemonRepository.findPokemonWithHpHigherThan(n);
    }
}