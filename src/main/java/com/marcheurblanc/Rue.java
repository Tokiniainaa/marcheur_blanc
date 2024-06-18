package com.marcheurblanc;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Rue {

    private final String nom;

    private final Lieu lieu1;

    private final Lieu lieu2;

    public Lieu destination(Lieu origine){

        if (lieu1.equals(origine)){
            return lieu2;
        }
        else {
            return lieu1;
        }
    }

}
