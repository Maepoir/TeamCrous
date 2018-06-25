package arcanor.modele;

import java.io.Serializable;

/**
 * Role : Cette classe permet de modéliser une pièce du jeu Arcanor
 *
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 * Case d'utilisation :
 * int TAILLE = 3
 * Pion p = new Pion ( TAILLE );
 */
public class Pion implements Serializable {

    /**
     * C'est la  valeur du pion
     */
    private final int TAILLE;

    /**
     * C'est le Pion  mangé par le pion
     */
    private Pion aManger;

    /**
     * Booléen qui permet de déterminer si le pion est mangé
     */
    private boolean estManger;

    /**
     * Booléen qui permet de déterminer si on peut afficher le pion manger
     */
    private boolean afficherManger;

    /**
     * permet de savoir à qui appartient le pion
     */
    private Joueur leJoueur;

    /**
     * coordonnées sur le plateau en x (abcisse)
     */
    private int x;

    /**
     * coordonnées du pion sur le plateau en y (ordonnée)
     */
    private int y;

    //le numéro du pion
    private int num;

    /**
     * Role :Construit un objet Pion
     *
     * @param taille la taille du pion
     *               Cas d'utilisation :
     *               int taille = 3;
     *               Pion p = new Pion(taille);
     */
    public Pion(int taille, boolean estManger, Pion aManger, int x, int y, Joueur leJoueur, int num) {
        this.TAILLE = taille;
        this.estManger = estManger;
        this.aManger = aManger;
        this.x = x;
        this.y = y;
        this.leJoueur = leJoueur;
        this.num = num;
    }

    /**
     * Role :Récupère le pion qui a été mangé
     * Cas d'utilisation :
     * Pion p = new Pion(3);
     * Pion q = p.getAMange();
     *
     * @return La  méthode retourne le pion qui a été mangé , si il n'y a pas de
     * pion qui a été mangé la fonction retourne null
     */
    public Pion getAMange() {
        return this.aManger;
    }

    /**
     * Role : Ajoute le pion qui a été mangé
     *
     * @param aManger le pion qui a été mangé
     *                Cas d'utilisation :
     *                Pion p = new Pion(3);
     *                Pion aManger = new Pion(2);
     *                p.setAMange(aManger);
     */
    public void setAMange(Pion aManger) {
        this.aManger = aManger;
    }

    /**
     * Role : Vérifie si ce pion a été mangé par un autre Pion
     * Cas d'utilisation :
     * Pion p = new Pion(42);
     * boolean estmange = p.getEstMange(estManger);
     *
     * @return true : le pion a été mangé
     * false : le pion n'as as été mangé
     */
    public boolean getEstMange() {
        return this.estManger;
    }

    /**
     * Role : Met a jour l'état du pion (mangé ou pas)
     *
     * @param estManger true : le pion a été mangé
     *                  false : le pion n'a pas été mangé
     *                  Cas d'utilisation :
     *                  Pion p = new Pion(42);
     *                  p.setEstMange(true)
     */
    public void setEstMange(boolean estManger) {
        this.estManger = estManger;
    }

    /**
     * Role : Vérifie le pion peut être affiché
     * Cas d'utilisation :
     * boolean afficherManger ;
     * Pion p = new Pion(42);
     * afficherManger = p.getAfficherManger();
     *
     * @return true : le pion peut être affiché
     * false : le pion ne peut pas être afficher
     */
    public boolean getAfficherManger() {
        return this.afficherManger;
    }

    /**
     * Role : Met a jour l'état de l'affichage du pion
     *
     * @param afficherManger valeur de l'affichage du pion
     *                       Cas d'utilisation :
     *                       Pion p = new Pion(42);
     *                       afficherManger = p.setAfficherManger(true);
     */
    void setAfficherManger(boolean afficherManger) {
        this.afficherManger = afficherManger;
    }

    /**
     * permet de savoir à qui appartient le pion en dehors de la classe Pion
     *
     * @return le joueur à qui appartient le pion
     */
    public Joueur getLeJoueur() {
        return this.leJoueur;
    }

    /**
     * permet de déterminer à qui appartient le pion.
     *
     * @param leJoueur le joueur à qui appartient le pion
     */
    public void setLeJoueur(Joueur leJoueur) {
        this.leJoueur = leJoueur;
    }

    /**
     * permet de connaitre les coordonnées du pion sur le plateau de jeu
     *
     * @return l'abcisse du pion
     */
    public int getX() {
        return this.x;
    }

    /**
     * permet de connaitre les coordonnées du pion sur le plateau de jeu
     *
     * @return l'ordonnée du pion
     */
    public int getY() {
        return this.y;
    }

    /**
     * permet de modifier l'emplacement du pion sur le plateau
     *
     * @param x l'abcisse du pion
     * @param y l'ordonnée du pion
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * permet de connaitre la taille du pion
     *
     * @return taille du pion
     */
    public int getTAILLE() {
        return this.TAILLE;
    }

    /**
     * permet d'accéder au numéro du pion
     *
     * @return le numéro du pion
     */
    public int getNum() {
        return this.num;
    }
}
