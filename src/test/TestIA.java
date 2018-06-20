package test;

import static org.junit.Assert.*;
import arcanor.modele.*;
import org.junit.Test;

import java.awt.*;

public class TestIA {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Color color = new Color(255,255,255);
    IA ia = new IA("BAY",Couleur_BLANC,1);
    String nom = "Pomme";
    ia.setNom("Pomme");
    assertEquals(nom,ia.getNom());

    // Cas Limite : le nom entré est une chaine vide
    ia = new IA("",Couleur_NOIR,1);
    nom = "Pomme";
    ia.setNom("Pomme");
    assertEquals(nom,ia.getNom());
  }

  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    IA ia = new IA("Poiré",Couleur_BLANC,1);
    Couleur color = Couleur_NOIR;
    ia.setColor(color);
    assertEquals(color,ia.getColor());
  }

  @Test
  public void testDifficulte(){
    IA ia = new IA("RENAULT",Couleur_BLANC,0);
    ia.setDifficulte(1);
    assertEquals(1,ia.getDifficulte());
    ia.setDifficulte(-1);
    assertFalse( 0 != ia.getDifficulte() );
  }
}
