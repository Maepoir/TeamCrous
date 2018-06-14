package arcanor.iu.console;
import java.util.Scanner;
import arcanor.modele.*;
import arcanor.*;
import arcanor.iu.console.*;
/** permet d'afficher les informations de jeu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class JeuTxt {

  /**permet d'afficher les éléments de jeu sur la console */
  public void afficher(){
    MenuTxt menu = new MenuTxt();
    PlateauTxt plateau = new PlateauTxt();
    int ret = menu.afficherMenu();
    if(ret == 1){
      Partie partie = new Partie();
    }
    else if(ret == 2){
      Scanner in = new Scanner(System.in);
      System.out.println(" pour charger la partie : donnez le nom de la sauvegarde :");
      String str = in.nextLine();
      boolean defaut = false;
      Jeu jeu = new Jeu(defaut);
      jeu.chargerJeu(str);
    }
    else if(ret == 3){
      System.out.println("Merci d'avoir lancé Arcanor, à bientôt !");
      System.exit(0);
    }
    else{
      while(ret != 1 || ret != 2 || ret != 3){
        System.out.println("Saisie incorrecte !");
        ret = menu.afficherMenu();
      }
    }
  }
}
