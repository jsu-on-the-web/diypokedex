package io.uruguayconsultancy.diypokedex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import io.uruguayconsultancy.diypokedex.pokemon.Pokemon;
import io.uruguayconsultancy.diypokedex.pokemon.PokemonRepository;

@DataJpaTest
public class PokemonRepositoryTest {
    @Autowired
    private PokemonRepository testRepo;

    @AfterEach
    public void tearDown() {
        testRepo.deleteAll();
    }

    @Test
    public void testFindAll() {
        assertThat(testRepo.findAll()).hasSize(0);

        Pokemon p1 = new Pokemon("Blorbus", "Normal", 1.0, 1.0, 10, 10, 10, 10, 10, 10);

        testRepo.save(p1);

        assertThat(testRepo.findAll()).hasSize(1);
    }

    @Test 
    void testFindById() {
        Pokemon p1 = new Pokemon("Blorbus", "Normal", 1.0, 1.0, 10, 10, 10, 10, 10, 10);
        testRepo.save(p1);
        Pokemon p2 = new Pokemon("Null", "Ghost", 0, 0, 0, 0, 0, 0, 0, 0);
        testRepo.save(p2);

        assertThat(testRepo.findById(1L)).get().isEqualTo(p1);
    }
}
