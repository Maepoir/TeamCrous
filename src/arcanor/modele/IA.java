package arcanor.modele;

import java.io.Serializable;
import java.util.Random;

/**
 * Cette classe permet de modéliser l'intelligence artificielle
 * contre laquelle le joueur peu jouer lorsqu'il est seul.
 *
 * @author M.Poiré, S.Bay
 */
public class IA extends Joueur implements Serializable {

    //représente la difficulté de l'ordinateur
    private int difficulte;

    /**
     * Constructeur
     *
     * @param nom     nom/pseudo  du joueur
     * @param couleur couleur des pions
     * @param niveau  difficulté choisie par le joueur
     */
    public IA(String nom, Couleur couleur, int niveau) {
        super(nom, couleur);
        this.difficulte = niveau;
    }

    /**
     * Permet à l'intelligence artificielle de choisir un déplacement
     *
     * @return le déplacement choisi
     */
    public int jouer() {
        Random r = new Random();
        return r.nextInt(8);
    }

    /**
     * Permet d'accéder au niveau de difficulté de l'intelligenc artificielle en dehors de la classe IA
     *
     * @return le niveau de difficulté de l'intelligence artificielle
     */
    public int getDifficulte() {
        return this.difficulte;
    }

    /**
     * Permet de modifier le niveau de l'IA
     *
     * @param difficulte le nouveau niveau de difficulte
     */
    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }


}
