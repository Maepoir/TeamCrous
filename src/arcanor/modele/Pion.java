package arcanor.modele;
/**
 * Role : Cette classe permet de modéliser une pièce du jeu Arcanor
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 * Case d'utilisation :
 *      int TAILLE = 3
        Pion p = new Pion ( TAILLE );
*/
 public class Pion {

    /** C'est la  valeur du pion */
    private final int TAILLE;

    /** C'est le Pion  mangé par le pion */
    private Pion aMange;

    /** Booléen qui permet de déterminer si le pion est mangé  */
    private boolean estManger;

    /** Booléen qui permet de déterminer si on peut afficher le pion manger */
    private boolean afficherManger;

    /**
    * Role :Construit un objet Pion
    * @param taille la taille du pion
    * Cas d'utilisation :
              int taille = 3;
              Pion p = new Pion(taille);
    */
    public Pion (int taille){
      this.TAILLE = taille ;
    }
   /**
    * Role :Récupère le pion qui a été mangé
    * Cas d'utilisation :
    *          Pion p = new Pion(3);
    *          Pion q = p.getAMange();
    * @return  La  méthode retourne le pion qui a été mangé , si il n'y a pas de
    *         pion qui a été mangé la fonction retourne null
    */
    public Pion getAMange(){
      Pion ret =new Pion(2);
      return ret;
    }
    /**
     * Role : Ajoute le pion qui a été mangé
     * @param aMange le pion qui a été mangé
     * Cas d'utilisation :
     *        Pion p = new Pion(3);
     *        Pion aMange = new Pion(2);
     *        p.setAMange(aMange);
     */
    public void setAMange(Pion aMange){

    }
    /**
     * Role : Vérifie si ce pion a été mangé par un autre Pion
     * Cas d'utilisation :
     *        Pion p = new Pion(42);
     *        boolean estmange = p.getEstMange(estMange);
     * @return true : le pion a été mangé
     *         false : le pion n'as as été mangé
    */
    public boolean getEstMange(){
      boolean ret = false;
      return ret;
    }
    /**
     * Role : Met a jour l'état du pion (mangé ou pas)
     * @param estMange true : le pion a été mangé
     *                 false : le pion n'a pas été mangé
     * Cas d'utilisation :
     *      Pion p = new Pion(42);
     *      p.setEstMange(true)
    */
    public void setEstMange(boolean estMange){

    }
    /**
     * Role : Vérifie le pion peut être affiché
     * Case d'utilisation :
     *      boolean afficherManger ;
     *      Pion p = new Pion(42);
     *      afficherManger = p.getAfficherManger();
     * @return true : le pion peut être affiché
     *         false : le pion ne peut pas être afficher
     */
     public boolean getAfficherManger(){
       boolean ret = false;
       return ret;
     }

     /**
      * Role : Met a jour l'état de l'affichage du pion
      * @param afficheManger valeur de l'affichage du pion
      * Case d'utilisation :
      *      Pion p = new Pion(42);
      *      afficherManger = p.setAfficherManger(true);
     */
     public void setAfficherManger( boolean afficheManger){

     }

}
