package arcanor.modele;
/**
 * Rôle : Cette classe permet de modéliser un joueur du jeu Arcanor
 * @author S.Bay, M.Racine, M.Poiré, G.Renault
*/
import java.awt.Color;
public class Joueur {
  // Le nom du joueur
  private String nom;

  // La couleur associé au joueur
  private Color couleur ;

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
  public Joueur ( String nom , Color couleur ,boolean aLaMain ){
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
    String ret = "";
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
  public Color getColor(){
    Color ret = new Color(255,255,255);
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
  public void  setColor (Color couleur){

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
    boolean ret =true;
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
  public void setAlaMain(boolean aLaMain){

  }

  /** Rôle : permet d'acceder à l'attribut mesPions en dehors de la classe Joueur
  * @return la liste des pions du joueur */


}
