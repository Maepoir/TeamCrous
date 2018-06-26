package test;

import static org.junit.Assert.*;

import arcanor.modele.*;
import org.junit.Test;

import java.awt.*;

public class TestJoueurHumain {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Joueur joueur = new JoueurHumain("Sim",Couleur.BLANC);
    joueur.setNom("Maë");
    String nom = "Maë";
    assertEquals(nom,joueur.getNom());

    // Cas Limite : le nom entré est une chaine vide
    joueur = new JoueurHumain("",Couleur.AUCUN);
    joueur.setNom("Maë");
    assertEquals(nom,joueur.getNom());
  }

  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    Joueur joueur = new JoueurHumain("Maë",Couleur.NOIR);
    Couleur couleur = Couleur.BLANC;
    joueur.setColor(couleur);
    assertEquals(Couleur.BLANC,joueur.getColor());
  }

}
