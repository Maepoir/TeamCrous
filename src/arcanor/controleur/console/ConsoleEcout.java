package arcanor.controleur.console;
import java.awt.event.*;
import java.util.Scanner;

/** permet de mettre à l'écoute la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class ConsoleEcout{


    public static int menuTxtEcout (){
        Scanner sc = new Scanner (System.in);
        System.out.println("Saisissez votre choix :");
        int ret = 0;
        while(ret !=1 && ret !=2 && ret !=3){
            ret = sc.nextInt();
        }
        return ret;
    }

}
