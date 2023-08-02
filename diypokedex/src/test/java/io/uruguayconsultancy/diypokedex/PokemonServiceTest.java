package io.uruguayconsultancy.diypokedex;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.uruguayconsultancy.diypokedex.pokemon.Pokemon;
import io.uruguayconsultancy.diypokedex.pokemon.PokemonRepository;
import io.uruguayconsultancy.diypokedex.pokemon.PokemonService;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @Mock
    private PokemonRepository testRepo;

    private PokemonService testService;

    @BeforeEach
    public void setUp() {
        this.testService = new PokemonService();
        testService.setPokemonRepository(testRepo);
    }

    @Test
    public void testFindAll() {
        testService.getAllPokemon();

        Mockito.verify(testRepo).findAll();
    }

    @Test
    public void testFindById() {
        Pokemon p1 = new Pokemon("Blorbus", "Normal", 1.0, 1.0, 10, 10, 10, 10, 10, 10);
        testService.getPokemonRepository().findById(1L);

        Mockito.verify(testRepo).findById(1L);
    }
}
