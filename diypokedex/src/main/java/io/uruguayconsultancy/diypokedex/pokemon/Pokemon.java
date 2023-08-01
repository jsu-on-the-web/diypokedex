package io.uruguayconsultancy.diypokedex.pokemon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    /* -------------------------------------------------------------------------- */
    /*                              Variables/Fields                              */
    /* -------------------------------------------------------------------------- */

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "type")
    private String type;

    @Getter
    @Setter
    @Column(name = "height")
    private float height;

    @Getter
    @Setter
    @Column(name = "weight")
    private float weight;

    @Getter
    @Setter
    @Column(name = "base_hp")
    private int baseHp;

    @Getter
    @Setter
    @Column(name = "base_attack")
    private int baseAttack;

    @Getter
    @Setter
    @Column(name = "base_defense")
    private int baseDefense;

    @Getter
    @Setter
    @Column(name = "base_spatk")
    private int baseSpAtk;

    @Getter
    @Setter
    @Column(name = "base_spdef")
    private int baseSpDef;

    @Getter
    @Setter
    @Column(name = "base_speed")
    private int baseSpeed;

    /* -------------------------------------------------------------------------- */
    /*                                Constructors                                */
    /* -------------------------------------------------------------------------- */

    public Pokemon() {

    }
    
    public Pokemon(String name, String type, float height, float weight, int baseHp, int baseAttack, int baseDefense,
            int baseSpAtk, int baseSpDef, int baseSpeed) {
        super();
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