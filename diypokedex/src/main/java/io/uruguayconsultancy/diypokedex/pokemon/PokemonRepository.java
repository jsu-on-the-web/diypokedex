package io.uruguayconsultancy.diypokedex.pokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    @Query("SELECT p FROM Pokemon p WHERE p.baseHp = (SELECT MIN(p2.baseHp) FROM Pokemon p2)")
    Optional<Pokemon> selectMinHp();

    @Query("SELECT p FROM Pokemon p WHERE p.type = :type")
    List<Pokemon> findByType(@Param("type") String type);
}