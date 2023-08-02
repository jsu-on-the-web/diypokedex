package io.uruguayconsultancy.diypokedex.pokemon;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.uruguayconsultancy.diypokedex.exceptions.NotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    // * CREATE

    /**
     * Creates a new Pokemon.
     *
     * @param data the data used to create the Pokemon
     * @return the created Pokemon and a HTTP status code
     */
    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@Valid @RequestBody CreatePokemonDTO data) {
        Pokemon pokemon = pokemonService.createPokemon(data);
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    // * READ

    /**
     * Retrieves all the Pokemon.
     *
     * @return A ResponseEntity containing a list of Pokemon objects
     */
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> pokemons = pokemonService.getAllPokemon();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    /**
     * Retrieves a Pokemon by its ID.
     *
     * @param id the ID of the Pokemon to retrieve
     * @return the ResponseEntity containing the retrieved Pokemon and the HTTP
     *         status code
     */
    @GetMapping("/query/id")
    @ResponseBody
    public ResponseEntity<Pokemon> getPokemon(@RequestParam(name = "id", required = true) Long id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemon(id);
        if (pokemon.isEmpty()) {
            throw new NotFoundException(String.format("Pokemon with id %d not found", id));
        }
        return new ResponseEntity<>(pokemon.get(), HttpStatus.OK);
    }

    @GetMapping("/query/type")
    @ResponseBody
    public ResponseEntity<List<Pokemon>> getPokemonOfType(@RequestParam(name = "type", required = true) String type) {
        List<Pokemon> pokemonOfType = pokemonService.getPokemonOfType(type);
        if (pokemonOfType.isEmpty()) {
            throw new NotFoundException(String.format("Pokemon with type %s not found", type));
        }
        return new ResponseEntity<>(pokemonOfType, HttpStatus.OK);
    }

    @GetMapping("/min/{stat}")
    @ResponseBody
    public ResponseEntity<Pokemon> getMinStat(@PathVariable String stat) {

        Optional<Pokemon> pokemon = pokemonService.getMinStat(stat);

        return new ResponseEntity<>(pokemon.get(), HttpStatus.OK);

    }

    // * UPDATE

    /**
     * Updates a Pokemon with the given ID.
     *
     * @param id   the ID of the Pokemon to update
     * @param data the data to update the Pokemon with
     * @return the updated Pokemon if present
     */
    @PatchMapping("/query")
    public ResponseEntity<Pokemon> updatePokemon(@RequestParam(name = "id", required = true) Long id,
            @RequestBody UpdatePokemonDTO data) {
        Optional<Pokemon> pokemon = pokemonService.updatePokemon(id, data);
        if (pokemon.isEmpty()) {
            throw new NotFoundException(String.format("Pokemon with id %d not found, cannot update", id));
        }
        return new ResponseEntity<Pokemon>(pokemon.get(), HttpStatus.OK);
    }

    // * DELETE

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePokemon(@RequestParam(name = "id", required = true) Long id) {
        boolean deleted = pokemonService.deletePokemon(id);
        if (!deleted) {
            throw new NotFoundException(String.format("Pokemon with id %d not found, cannot delete", id));
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}