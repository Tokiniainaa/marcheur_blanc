package com.marcheurblanc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MarcheurBlancApplication {

	public static void main(String[] args) {
		Lieu HEI = new Lieu("HEI");
		Lieu Pullman = new Lieu("Pullman");
		Lieu Balancoire = new Lieu("Balancoire");
		Lieu Marais = new Lieu("Marais");
		Lieu Sekolintsika = new Lieu("Sekolintsika");
		Lieu ESTI = new Lieu("ESTI");
		Lieu Boulevard = new Lieu("Boulevard");


		// Création des rues comme précédemment
		Rue rue1 = new Rue("Rue1",HEI, Pullman);
		Rue rue2 = new Rue("Rue2",Pullman, Balancoire);
		Rue rue3 = new Rue("Rue3",Balancoire, ESTI);
		Rue rue4 = new Rue("Rue4",HEI,Sekolintsika);
		Rue rue5 = new Rue("Rue5",Sekolintsika,Marais);
		Rue rue6 = new Rue("Rue6",ESTI,Boulevard);
		Rue rue7 = new Rue("Rue7",Boulevard,Balancoire);




		// Ajout des rues aux lieux comme précédemment
		HEI.ajouterRue(rue1);
		Pullman.ajouterRue(rue2);
		Balancoire.ajouterRue(rue3);
		HEI.ajouterRue(rue4);
		Sekolintsika.ajouterRue(rue5);
		ESTI.ajouterRue(rue6);
		Boulevard.ajouterRue(rue7);
		// Ajout de la nouvelle rue

		// Création du marcheur Bjarni au lieu HEI
		Marcheur bjarni = new Marcheur(HEI);

		// Définir une nouvelle destination
		bjarni.setDestination(ESTI);

		// Faire marcher le marcheur aléatoirement jusqu'à atteindre AutreLieu
		bjarni.seDeplacer();
	}



}
