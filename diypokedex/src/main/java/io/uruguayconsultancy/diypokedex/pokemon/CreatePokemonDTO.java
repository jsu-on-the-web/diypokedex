package io.uruguayconsultancy.diypokedex.pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CreatePokemonDTO {
    @NotBlank
    @Getter
    @Setter
    private String name;

    @NotBlank
    @Getter
    @Setter
    private String type;

    @NotNull
    @Getter
    @Setter
    private double height = 0.0;

    @NotNull
    @Getter
    @Setter
    private double weight = 0;

    @NotNull
    @Getter
    @Setter
    private long preEvolutionId;

    @NotNull
    @Getter
    @Setter
    private int baseHp = 0;

    @NotNull
    @Getter
    @Setter
    private int baseAttack = 0;

    @NotNull
    @Getter
    @Setter
    private int baseDefense;

    @NotNull
    @Getter
    @Setter
    private int baseSpAtk = 0;

    @NotNull
    @Getter
    @Setter
    private int baseSpDef = 0;

    @NotNull
    @Getter
    @Setter
    private int baseSpeed = 0;

    public CreatePokemonDTO(String name, String type, double height, double weight, int baseHp, int baseAttack,
            int baseDefense, int baseSpAtk, int baseSpDef, int baseSpeed) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.baseHp = baseHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpAtk = baseSpAtk;
        this.baseSpDef = baseSpDef;
        this.baseSpeed = baseSpeed;
    }
}