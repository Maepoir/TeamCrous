package arcanor;
import arcanor.modele.*;

import java.util.Scanner;

/**
 * Rôle :  Cette classe permet de lancer une partie d'Arcanor
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
 public class Partie{

   //l'instance de jeu permettant de lancer une partie
   private Jeu leJeu;

   /** Rôle : lance Arcanor
   * @param args tableau de chaine de caractères
   */
   public static void main(String[] args){
       System.out.println("Lancement d'une fantastique partie d'Arcanor !");

       System.out.println("Voulez vous jouez avec l'interface graphique active ? (oui/non)");
       Scanner sc = new Scanner(System.in);
       String rep ="";
       boolean mode = false;

       while(!rep.trim().equals("oui") && !rep.trim().equals("non")){
           rep = sc.nextLine();
       }

       if(rep.trim().equals("oui")){
           mode = true;
       }

       new Jeu (mode);
   }
 }
