package com.marcheurblanc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class Marcheur {

    private final   String nom;
    private  Lieu positionInitial;

    public List<Lieu> marcher(Lieu depart, Lieu arrive) {
        List<Lieu> chemin = new ArrayList<>();
        chemin.add(depart);
        Lieu positionActuelle = depart;
        Random random = new Random();

        while (!positionActuelle.equals(arrive)) {
            List<Rue> ruesPossibles = new ArrayList<>();
            for (Rue rue : positionActuelle.getRues()) {
                if (rue.getLieu1().equals(positionActuelle) || rue.getLieu2().equals(positionActuelle)) {
                    ruesPossibles.add(rue);
                }
            }
            Rue rueChoisie = ruesPossibles.get(random.nextInt(ruesPossibles.size()));
            Lieu prochainLieu = rueChoisie.getDestination(positionActuelle);
            chemin.add(prochainLieu);
            positionActuelle = prochainLieu;
        }

        return chemin;
    }



}
