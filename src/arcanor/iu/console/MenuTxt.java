package arcanor.iu.console;

import java.util.Scanner;

/** permet d'afficher le menu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuTxt {

  /**permet d'afficher le menu sur la console */
  public static int afficher(){
      System.out.println(" <3 Arcanor <3 ");
      System.out.println("\t(1.) Nouvelle partie");
      System.out.println("\t(2.) Charger");
      System.out.println("\t(3.) Quitter");
      return selection();
  }

  public static int selection (){
      Scanner sc = new Scanner (System.in);
      System.out.println("Saisissez votre choix :");
      int ret = 0;
      while(ret !=1 && ret !=2 && ret !=3){
          ret = sc.nextInt();
      }
      return ret;
  }

}
