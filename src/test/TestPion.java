package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestPion {
  @Test
  public final void testEstMange(){
    fail("Not yet implemented");
    Pion pionArcanor = new Pion(3);
    pionArcanor.setEstMange(false);
    this.assertFalse( pionArcanor.getEstMange());
    pionArcanor.setAMange(true);
    this.assertTrue( pionArcanor.getEstMange());

  }
  @Test
  public final void testAMange(){
    fail("Not yet implemented");
    Pion pionArcanor = new Pion(3);
    Pion pionMange = new Pion(2);
    pionArcanor.setAMange(pionMange);
    this.assertEquals(pionMange,pionArcanor.getAMange());
  }


}
