package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestIA {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Color color = new Color(255,255,255);
    IA ia = new IA("RENAULT",color,true);
    String nom = ia.setNom("Pomme");
    this.assertEquals(nom,ia.getNom());

    // Cas Limite : le nom entré est une chaine remplie
    Color color = new Color(255,255,255);
    IA ia = new IA("",color,true);
    String nom = ia.setNom("Pomme");
    this.assertEquals(nom,ia.getNom());

  }
  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    Color color = new Color(255,255,255);
    IA ia = new IA("RENAULT",color,true);
    color = new Color(0,0,0);
    ia.setColor(color);
    this.assertEquals(color,ia.getColor());


  }
  @Test
  public void testALaMain(){
    Color color = new Color(255,255,255);
    IA ia = new IA("RENAULT",color,true);
    ia.setAlaMain(true);
    this.assertTrue( ia.getALaMain() );
    ia.setAlaMain(false);
    this.assertFalse( ia.getALaMain() );
  }
  @Test
  public void testDifficulte(){
    Color color = new Color(255,255,255);
    IA ia = new IA("RENAULT",color,true,0);
    ia.setDifficulte(0);
    this.assertEquals(0,ia.getDifficulte());
    ia.setDifficulte(-1);
    this.assertFalse( 0,ia.getDifficulte() );
  }
}
