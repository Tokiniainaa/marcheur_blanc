package com.marcheurblanc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rue {

    private final String nom;
    private final Lieu lieu1;
    private final Lieu lieu2;

    public Lieu getDestination(Lieu origine) {
        if (origine.equals(lieu1)) {
            return lieu2;
        } else {
            return lieu1;
        }
    }


}
