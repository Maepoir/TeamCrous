package arcanor.modele;
/**
 * Rôle : Cette classe permet de modéliser un joueur du jeu Arcanor
 * @author S.Bay, M.Racine, M.Poiré, G.Renault
*/
public class Joueur {
  // Le nom du joueur
  private String nom;

  // La couleur associé au joueur
  private Couleur couleur ;

  // L'ensemble des pions du joueur
  private Pion[] mesPions ;

  // Le joueur qui à la main
  private boolean aLaMain ;

  /**
   * Role : Cette méthode permet de créer un objet Joueur
   * @param nom nom/pseudo  du joueur
   * @param couleur couleur des pions
   * @param aLaMain true si le joueur  a la main
   *               false si  Le joueur  n'a  pas la main
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      Joueur p = new Joueur (nom,col );
  */
  public Joueur (String nom, Couleur couleur, boolean aLaMain){
    this.nom = nom ;
    this.couleur = couleur;
    this.aLaMain = aLaMain;
  }
  /**
   * Role : Cette méthode permet de récupérer le nom/pseudo du Joueur
   * @return la valeur du nom du Joueur
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      Joueur p = new Joueur (nom,col );
   *      nom = p.getNom();
  */
  public String getNom(){
    String ret = this.nom;
    return ret;
  }
  /**
   * Role : Cette méthode modifier le nom/pseudo du Joueur
   * @param nom le nom ou pseudo du Joueur
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      Joueur p = new Joueur (nom,col );
   *      p.setNom("SIMON");
  */
  public void setNom(String nom){
    this.nom = nom;
  }
  /**
   * Role : Cette méthode permet de récupérer la couleur des pions
   * @return la valeur du nom du Joueur
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      Joueur p = new Joueur (nom,col );
   *      col = p.getColor();
  */
  public Couleur getColor(){
    Couleur ret = this.couleur;
    return ret;
  }
  /**
   * Role : Cette méthode permet de modifier la couleur des pions
   * @param couleur la couleur des pions
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      Joueur p = new Joueur (nom,col );
   *      p.setColor(  new Color( 0,0,0) );
  */
  public void  setColor (Couleur couleur){
    this.couleur = couleur;
  }

  /**
   * Role : Cette méthode permet de récupérer savoir si le joueur qui a la main
   * @return true si le joueur  a la main
  *          false si Le joueur  n'a  pas la main
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      boolean aLaMain = true;
   *      Joueur p = new Joueur (nom,col );
   *      col = p.getALaMain();
  */
  public boolean getALaMain(){
    boolean ret = this.aLaMain;
    return ret;
  }

  /**
   * Role : Cette méthode permet de récupérer savoir si le joueur qui a la main
   * @param aLaMain  true si le joueur  a la main
   *                 false si  Le joueur  n'a  pas la main
   * Case d'utilisation :
   *      String nom = "GURVAN";
   *      Color col = new Color( 255,255,255);
   *      boolean aLaMain = true;
   *      Joueur p = new Joueur (nom,col );
   *      col = p.getALaMain();
  */
  public void setALaMain(boolean aLaMain){
    this.aLaMain = aLaMain;
  }

  /** Rôle : permet d'acceder à l'attribut mesPions en dehors de la classe Joueur
  * @return la liste des pions du joueur */
  public Pion[] getMesPions (){
    return this.mesPions;
  }

}
