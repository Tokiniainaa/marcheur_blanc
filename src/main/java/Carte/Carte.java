package Carte;

import com.marcheurblanc.Lieu;
import com.marcheurblanc.Rue;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
class Carte {

    private List<Lieu> lieux;
    private List<Rue> rues;

}

