package arcanor.controleur.graphique;

import arcanor.modele.*;
import arcanor.*;
import arcanor.iu.graphique.*;
import arcanor.controleur.graphique.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PlateauEcout implements MouseListener {

  private MenuFen menu;

  public PlateauEcout(MenuFen menu){
    this.menu = menu;
  }

  public void mouseClicked (MouseEvent e){
    System.out.println("mouse clicked");
    
  }

  public void mouseEntered(MouseEvent e){
    System.out.println("mouse entered");
  }

  public void mouseExited(MouseEvent e){
    System.out.println("mouse exited");
  }

  public void mousePressed(MouseEvent e){
    System.out.println("mouse pressed");
  }

  public void mouseReleased(MouseEvent e){
    System.out.println("mouseReleased");
  }
}
