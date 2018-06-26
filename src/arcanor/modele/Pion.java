package arcanor.modele;

import java.io.Serializable;

/**
 * Permet de modéliser une pièce du jeu Arcanor
 *
 * @author S.Bay, M.Poiré
 */
public class Pion implements Serializable {


    //C'est la  valeur du pion
    private final int TAILLE;


     //C'est le Pion  mangé par le pion
    private Pion aManger;

    //Booléen qui permet de déterminer si le pion est mangé
    private boolean estManger;

    //Booléen qui permet de déterminer si on peut afficher le pion manger
    private boolean afficherManger;

    //permet de savoir à qui appartient le pion
    private Joueur leJoueur;

    //coordonnées sur le plateau en x (abcisse)
    private int x;

    //coordonnées du pion sur le plateau en y (ordonnée)
    private int y;

    //le numéro du pion
    private int num;

    /**
     * Constructeur
     *
     * @param taille la taille du pion
     * @param estManger permet de savoir si le pion est mangé par un autre
     * @param aManger le pion manger par ce pion
     * @param x coordonnées en abcisse
     * @param y coordonnées en ordonnée
     * @param leJoueur le joueur a qui appartient le pion
     * @param num le numéro du pion
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
     * Récupère le pion qui a été mangé
     *
     * @return le pion mangé par le pion
     */
    public Pion getAMange() {
        return this.aManger;
    }

    /**
     * Ajoute le pion qui a été mangé
     *
     * @param aManger le pion qui a été mangé
     */
    public void setAMange(Pion aManger) {
        this.aManger = aManger;
    }

    /**
     * Vérifie si ce pion a été mangé par un autre Pion
     *
     * @return true si le pion est mangé par un autre
     */
    public boolean getEstMange() {
        return this.estManger;
    }

    /**
     * Role : Met a jour l'état du pion (mangé ou pas)
     *
     * @param estManger true : le pion a été mangé
     *                  false : le pion n'a pas été mangé
     */
    public void setEstMange(boolean estManger) {
        this.estManger = estManger;
    }

    /**
     * Vérifie le pion peut être affiché
     *
     * @return true : le pion peut être affiché
     *         false : le pion ne peut pas être afficher
     */
    public boolean getAfficherManger() {
        return this.afficherManger;
    }

    /**
     * Met a jour l'état de l'affichage du pion
     *
     * @param afficherManger vrai si le pion peut être soulevé
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
