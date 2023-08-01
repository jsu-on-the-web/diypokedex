import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Getter
    @Setter
    private float height;

    @NotBlank
    @Getter
    @Setter
    private float weight;

    @NotBlank
    @Getter
    @Setter
    private long preEvolutionId;

    @NotBlank
    @Getter
    @Setter
    private int baseHp;

    @NotBlank
    @Getter
    @Setter
    private int baseAttack;

    @NotBlank
    @Getter
    @Setter
    private int baseDefense;

    @NotBlank
    @Getter
    @Setter
    private int baseSpAtk;

    @NotBlank
    @Getter
    @Setter
    private int baseSpDef;

    @NotBlank
    @Getter
    @Setter
    private int baseSpeed;

    public CreatePokemonDTO(String name, String type, float height, float weight, int baseHp, int baseAttack, int baseDefense, int baseSpAtk, int baseSpDef, int baseSpeed) {
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