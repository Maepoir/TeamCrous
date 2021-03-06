package arcanor.modele;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Permet de modéliser un joueur humain
 *
 * @author M.Poiré, S.Bay
 */
public class JoueurHumain extends Joueur implements Serializable {

    /**
     * Constructeur
     *
     * @param nom     nom  du joueur
     * @param couleur couleur des pions
     */
    public JoueurHumain(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    /**
     * permet de faire le choix de déplacement du pion
     *
     * @return le numéro correspondant au déplacement
     */
    public int jouer() {
        int ret;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n|\t0|\t1|\t2| \n |\t7|\tPion|\t3| \n |\t6|\t5|\t4");
        System.out.println("Saisir le numero correspondant au déplacement choisi : ");
        ret = sc.nextInt();
        while (ret < 0 || ret > 7) {
            ret = sc.nextInt();
            System.out.println("Veuillez saisir une valeur correcte");
        }
        return ret;
    }

}
