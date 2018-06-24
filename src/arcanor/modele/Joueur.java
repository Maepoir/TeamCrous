package arcanor.modele;

/**
 * Rôle : Cette classe permet de modéliser un joueur du jeu Arcanor
 *
 * @author S.Bay, M.Racine, M.Poiré, G.Renault
 */
public abstract class Joueur {
    // Le nom du joueur
    private String nom;

    // La couleur associé au joueur
    private Couleur couleur;

    /**
     * Role : Cette méthode permet de créer un objet Joueur
     * Cas d'utilisation :
     * String nom = "GURVAN";
     * Couleur col = Couleur.BLANC;
     * Joueur p = new Joueur (nom,col );
     *
     * @param nom     nom/pseudo  du joueur
     * @param couleur couleur des pions
     */
    public Joueur(String nom, Couleur couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Role : Cette méthode permet de récupérer le nom/pseudo du Joueur
     * Cas d'utilisation :
     * String nom = "GURVAN";
     * Couleur col = Couleur.BLANC;
     * Joueur p = new Joueur (nom,col );
     * nom = p.getNom();
     *
     * @return la valeur du nom du Joueur
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Role : Cette méthode modifier le nom/pseudo du Joueur
     * Cas d'utilisation :
     * String nom = "GURVAN";
     * Couleur col = Couleur.BLANC;
     * Joueur p = new Joueur (nom,col );
     * p.setNom("SIMON");
     *
     * @param nom le nom ou pseudo du Joueur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Role : Cette méthode permet de récupérer la couleur des pions
     * Cas d'utilisation :
     * String nom = "GURVAN";
     * Couleur col = Couleur.BLANC;
     * Joueur p = new Joueur (nom,col );
     * col = p.getColor();
     *
     * @return la valeur du nom du Joueur
     */
    public Couleur getColor() {
        return this.couleur;
    }

    /**
     * Role : Cette méthode permet de modifier la couleur des pions
     * Cas d'utilisation :
     * String nom = "GURVAN";
     * Couleur col = Couleur.BLANC;
     * Joueur p = new Joueur (nom,col );
     * p.setColor(  Couleur.NOIR );
     *
     * @param couleur la couleur des pions
     */
    public void setColor(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * permet de faire le choix de déplacement du pion
     *
     * @return int le numéro correspondant au déplacement
     */
    public abstract int jouer();


}
