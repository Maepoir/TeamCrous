package test;

import arcanor.modele.Pion;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPion {
    @Test
    public final void testEstMange() {
        Pion pionArcanor = new Pion(2, false, null, 0, 0, null, 1);
        pionArcanor.setEstMange(false);
        assertFalse(pionArcanor.getEstMange());
        pionArcanor.setEstMange(true);
        assertTrue(pionArcanor.getEstMange());

    }

    @Test
    public final void testAMange() {
        Pion pionArcanor = new Pion(2, false, null, 0, 0, null, 1);
        Pion pionMange = new Pion(1, true, null, 0, 0, null, 1);
        pionArcanor.setAMange(pionMange);
        assertEquals(pionMange, pionArcanor.getAMange());
    }

    @Test
    public final void testPosition() {
        Pion pionArcanor = new Pion(2, false, null, 0, 0, null, 1);
        assertEquals(0, pionArcanor.getX());
        assertEquals(0, pionArcanor.getY());
        pionArcanor.setXY(1, 2);
        assertEquals(1, pionArcanor.getX());
        assertEquals(2, pionArcanor.getY());
    }


}
