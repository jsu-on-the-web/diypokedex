package io.uruguayconsultancy.diypokedex.pokemon;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class UpdatePokemonDTO {
    @Getter
    @Setter
    @Pattern(regexp = "^(?=.*[a-zA-Z0-9])[a-zA-Z0-9-]+$", message = "Only letters and numbers are allowed")
    String name;

    @Getter
    @Setter
    @Pattern(regexp = "(?i)^(Normal|Fire|Water|Electric|Grass|Ice|Fighting|Poison|Ground|Flying|Psychic|Bug|Rock|Ghost|Dragon|Dark|Steel|Fairy)$")
    String type;

    @Getter
    @Setter
    @Pattern(regexp = "^[-+]?\\d*\\.?\\d+$", message = "Only decimal numbers are allowed")
    float height;

    @Getter
    @Setter
    @Pattern(regexp = "^[-+]?\\d*\\.?\\d+$", message = "Only decimal numbers are allowed")
    float weight;

    @Getter
    @Setter
    @Pattern(regexp = "^\\d+$", message = "Only whole numbers are allowed")
    int baseHp;

    @Getter
    @Setter
    @Pattern(regexp = "^\\d+$", message = "Only whole numbers are allowed")
    int baseAttack;

    @Getter
    @Setter
    @Pattern(regexp = "^\\d+$", message = "Only whole numbers are allowed")
    int baseDefense;

    @Getter
    @Setter
    @Pattern(regexp = "^\\d+$", message = "Only whole numbers are allowed")
    int baseSpAtk;

    @Getter
    @Setter
    @Pattern(regexp = "^\\d+$", message = "Only whole numbers are allowed")
    int baseSpDef;

    @Getter
    @Setter
    @Pattern(regexp = "^\\d+$", message = "Only whole numbers are allowed")
    int baseSpeed;

    @Getter
    @Setter
    Long preEvolutionId;
}
