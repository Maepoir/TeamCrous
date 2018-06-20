package arcanor.iu.console;
import java.util.*;
import arcanor.modele.*;
import arcanor.*;

/** permet d'afficher le menu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuTxt {

  /**permet d'afficher le menu sur la console */
  public void afficherMenu(){
      System.out.println(" <3 Arcanor <3 ");
      System.out.println("\t(1.) Nouvelle partie");
      System.out.println("\t(2.) Charger");
      System.out.println("\t(3.) Quitter");
      Scanner sc = new Scanner (System.in);
      System.out.println("Saisissez votre choix :");
      int choix = sc.nextInt();
      while(choix !=1 && choix !=2 && choix !=3){
          choix = sc.nextInt();
      }
      if(choix == 1){
        System.out.println("Saisir nom du joueur 1 :");
        Scanner in = new Scanner (System.in);
        String nom1 = in.nextLine();
        JoueurHumain j1 = new JoueurHumain(nom1,Couleur.BLANC);
        System.out.println("Jouer contre un IA ?(o/n)");
        Joueur j2;
        String ia = in.nextLine();
        if(ia.equals("o")){
          System.out.println("Saisir nom de l'IA : ");
          String nom2 = in.nextLine();
          j2 = new IA(nom2, Couleur.NOIR,1);
        }
        else{
          //si la saisie est incorrecte, il s'agira d'une partie entre 2 joueurs
          System.out.println("Saisir nom du joueur 2 : ");
          String nom2 = in.nextLine();
          j2 = new JoueurHumain(nom2,Couleur.NOIR);
        }
        boolean modeGraphique = false;
        System.out.println("Jouer en mode triche (voir quel pion à déjà mangé un autre) ou en mode normal ? (t/n)");
        String tricheNormal = in.nextLine();
        if(tricheNormal.equals("t")){
          Jeu jeu = new Jeu(j1,j2, ModeJeu.TRICHE,modeGraphique);
        }
        else{
          Jeu jeu = new Jeu(j1,j2, ModeJeu.NORMAL,modeGraphique);
        }
      }
      //cet condition non codée, uniquement pour la compilation
      else if(choix == 2){int i = 0;}
      //en cas de saisie incorrecte ou de choix 3
      else{
        System.out.println("Merci d'avoir lancé Arcanor, à bientôt ! <3");
        System.exit(0);
      }
  }

}
