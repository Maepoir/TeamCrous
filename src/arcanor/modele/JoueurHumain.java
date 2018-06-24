package arcanor.modele;

import java.util.Scanner;

/**
 * Rôle :  Cette classe permet de modéliser un joueur humain
 *
 * @author M.Poiré, S.Bay
 */
public class JoueurHumain extends Joueur {

    /**
     * construit la classe IA
     *
     * @param nom     nom/pseudo  du joueur
     * @param couleur couleur des pions
     */
    public JoueurHumain(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    /**
     * permet de faire le choix de déplacement du pion
     *
     * @return int le numéro correspondant au déplacement
     */
    public int jouer() {
        int ret;
        Scanner sc = new Scanner(System.in);
        System.out.println("|\t0|\t1|\t2| \n |\t7|\tPion|\t3| \n |\t6|\t5|\t4");
        System.out.println("Saisir le numero correspondant au déplacement choisi : ");
        ret = sc.nextInt();
        while (ret < 0 || ret > 7) {
            ret = sc.nextInt();
            System.out.println("Veuillez saisir une valeur correcte");
        }
        return ret;
    }

}
