package com.marcheurblanc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Marcheur {
    private Lieu lieuActuel;
    private List<Lieu> lieuxConnus;
    private Random random;

    private Lieu destination;

    private boolean enRetour;
    private Lieu dernierLieu;

    public Marcheur(Lieu lieuInitial) {
        this.lieuActuel = lieuInitial;
        this.lieuxConnus = new ArrayList<>();
        this.lieuxConnus.add(lieuInitial);
        this.random = new Random();
        this.destination = null;
        this.enRetour = false;
        this.dernierLieu = null;
    }

    public void setDestination(Lieu destination) {
        this.destination = destination;
    }

    public void seDeplacer() {
        while (true) {
            List<Rue> ruesDisponibles = lieuActuel.getRues();

            if (ruesDisponibles.isEmpty()) {
                System.out.println("Je suis bloqué !");
                if (enRetour) {
                    System.out.println("Je fais demi-tour !");
                    if (!faireDemiTour()) {
                        System.out.println("Tous les lieux accessibles sont déjà connus !");
                        return;
                    }
                    enRetour = false;
                } else {
                    enRetour = true;
                }
            } else {
                enRetour = false;
                List<Rue> ruesNonVisitees = new ArrayList<>();
                for (Rue rue : ruesDisponibles) {
                    Lieu prochainLieu = rue.getLieu2();
                    if (!lieuxConnus.contains(prochainLieu) || (enRetour && prochainLieu.equals(dernierLieu))) {
                        ruesNonVisitees.add(rue);
                    }
                }

                if (ruesNonVisitees.isEmpty()) {
                    System.out.println("Tous les lieux accessibles sont déjà connus !");
                    if (enRetour) {
                        System.out.println("Je fais demi-tour !");
                        if (!faireDemiTour()) {
                            return;
                        }
                        enRetour = false;
                    } else {
                        enRetour = true;
                    }
                } else {
                    Rue rueChoisie = ruesNonVisitees.get(random.nextInt(ruesNonVisitees.size()));
                    Lieu prochainLieu = rueChoisie.getLieu2();
                    lieuxConnus.add(prochainLieu);

                    dernierLieu = lieuActuel;
                    lieuActuel = prochainLieu;
                    System.out.println("Je vais à " + lieuActuel.getNom());

                    if (destination != null && lieuActuel.equals(destination)) {
                        System.out.println("J'ai atteint ma destination !");
                        return;
                    }
                }
            }
        }
    }

    private boolean faireDemiTour() {
        if (lieuxConnus.size() > 1) {
            lieuxConnus.remove(lieuActuel);
            lieuActuel = dernierLieu;
            System.out.println("Je reviens à " + lieuActuel.getNom());
            return true;
        } else {
            System.out.println("Tous les lieux accessibles sont déjà connus !");
            return false;
        }
    }
}
