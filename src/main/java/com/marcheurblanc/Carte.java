package com.marcheurblanc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Data
@AllArgsConstructor
public class Carte {
    private final List<Rue> rues;
    private List<Lieu> lieux;
    public Carte() {
        this.rues = new ArrayList<>();
    }

    public void ajouterRue(Rue rue) {
        this.rues.add(rue);
    }

}

