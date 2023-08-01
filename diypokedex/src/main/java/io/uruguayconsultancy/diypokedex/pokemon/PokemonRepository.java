package io.uruguayconsultancy.diypokedex.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    
}