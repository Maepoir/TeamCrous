package test;

import static org.junit.Assert.*;

import arcanor.modele.Couleur;
import arcanor.modele.IA;
import org.junit.Test;

import java.awt.*;

public class TestIA {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Couleur color = Couleur.BLANC;
    IA ia = new IA("RENAULT",color,1);
    String nom = "Pomme";
    ia.setNom("Pomme");
    assertEquals(nom,ia.getNom());

    // Cas Limite : le nom entré est une chaine remplie
    ia = new IA("",color,1);
    nom = "Pomme";
    ia.setNom("Pomme");
    assertEquals(nom,ia.getNom());

  }
  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    Couleur color = Couleur.BLANC;
    IA ia = new IA("RENAULT",color,1);
    color = Couleur.NOIR;
    ia.setColor(color);
    assertEquals(color,ia.getColor());


  }
  @Test
  public void testDifficulte(){
    Couleur color = Couleur.BLANC;
    IA ia = new IA("RENAULT",color,0);
    ia.setDifficulte(0);
    assertEquals(0,ia.getDifficulte());
    ia.setDifficulte(-1);
    assertFalse( 0 != ia.getDifficulte() );
  }
}
