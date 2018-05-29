package arcanor.iu.console;

/** permet d'afficher le menu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuTxt {

  /**permet d'afficher le menu sur la console */
  public static int afficher(){
      System.out.println(" <3 Arcanor <3 ");
      System.out.println("\t(1.) Nouvelle partie");
      System.out.println("\t(2.) Charger");
      System.out.println("\t(3.) Quitter");
      return arcanor.controleur.console.ConsoleEcout.menuTxtEcout();
  }

}
