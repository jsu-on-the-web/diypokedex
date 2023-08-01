package io.uruguayconsultancy.diypokedex.pokemon;

import java.util.stream.Stream;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class CreatePokemonDTO {
    @NotBlank
    @Getter
    @Setter
    String name;

    @NotBlank
    @Getter
    @Setter
    String type;

    @NotBlank
    @Getter
    @Setter
    float height;

    @NotBlank
    @Getter
    @Setter
    float weight;

    @Getter
    @Setter
    long preEvolutionId;

    @NotBlank
    @Getter
    @Setter
    int[] baseStats;

    public CreatePokemonDTO(String name, String type, float height, float weight, int[] baseStats) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.baseStats = baseStats;
    }
}