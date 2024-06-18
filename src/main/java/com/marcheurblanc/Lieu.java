package com.marcheurblanc;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Lieu {

    private final String nom;

    private List<Rue> rues;

    public Lieu(String nom) {
        this.nom = nom;
        this.rues = new ArrayList<>();
    }
    public void ajouterRue(Rue rue) {
        rues.add(rue);
    }


}
