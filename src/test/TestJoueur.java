package test;

import static org.junit.Assert.*;

import arcanor.modele.Joueur;
import org.junit.Test;

import java.awt.*;

public class TestJoueur {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("RENAULT",color,true);
    joueur.setNom("Pomme");
    String nom = "Pomme";
    assertEquals(nom,joueur.getNom());

    // Cas Limite : le nom entré est une chaine remplie
    color = new Color(255,255,255);
    joueur = new Joueur("",color,true);
    joueur.setNom("Pomme");
    assertEquals(nom,joueur.getNom());

  }
  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("RENAULT",color,true);
    color = new Color(0,0,0);
    joueur.setColor(color);
    assertEquals(color,joueur.getColor());


  }
  @Test
  public void testALaMain(){
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("RENAULT",color,true);
    joueur.setALaMain(true);
    assertTrue( joueur.getALaMain() );
    joueur.setALaMain(false);
    assertFalse( joueur.getALaMain() );
  }

}
