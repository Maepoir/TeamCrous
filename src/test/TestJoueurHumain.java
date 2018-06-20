package test;

import static org.junit.Assert.*;

import arcanor.modele.*;
import org.junit.Test;

import java.awt.*;

public class TestJoueurHumain {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Joueur joueur = new Joueur("Sim",Couleur_BLANC);
    joueur.setNom("Maë");
    String nom = "Maë";
    assertEquals(nom,joueur.getNom());

    // Cas Limite : le nom entré est une chaine vide
    joueur = new Joueur("",color,true);
    joueur.setNom("Maë");
    assertEquals(nom,joueur.getNom());
  }

  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    Joueur joueur = new Joueur("Maë",Couleur_NOIR);
    Couleur couleur = COULEUR_BLANC;
    joueur.setColor(couleur);
    assertEquals(color,joueur.getColor());
  }

}
