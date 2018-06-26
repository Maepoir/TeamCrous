package arcanor.modele;

import java.io.Serializable;

/**
 * Permet de modéliser un joueur du jeu Arcanor
 *
 * @author S.Bay, M.Poiré
 */
public abstract class Joueur implements Serializable {
    // Le nom du joueur
    private String nom;

    // La couleur associé au joueur
    private Couleur couleur;

    /**
     * Constructeur
     *
     * @param nom     nom  du joueur
     * @param couleur couleur des pions
     */
    public Joueur(String nom, Couleur couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Permet de récupérer le nom du Joueur
     *
     * @return le nom du joueur
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Permet de modifier le nom du Joueur
     *
     * @param nom le nom ou pseudo du Joueur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de récupérer la couleur des pions
     *
     * @return la valeur du nom du Joueur
     */
    public Couleur getColor() {
        return this.couleur;
    }

    /**
     * Permet de modifier la couleur des pions
     *
     * @param couleur la nouvelle couleur des pions
     */
    public void setColor(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Permet de faire le choix de déplacement du pion
     *
     * @return int le numéro correspondant au déplacement
     */
    public abstract int jouer();


}
