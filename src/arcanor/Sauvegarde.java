package arcanor;
;
/**
 * Rôle :  Cette classe permet de modéliser une sauvegarde au cours de partie
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class Sauvegarde {

  private Plateau lePlateau;
  private Joueur[] arrayJoueur;
  private int modeJeu;
  private long tempsJeu;
  private boolean modeGraphique;


    /** Rôle : crée l'objet Sauvegarde*/
    public Sauvegarde (Plateau lePlateau, Joueur[] arrayJoueur, int modeJeu, long tempsJeu, boolean modeGraphique){
      this.lePlateau = lePlateau;
      this.arrayJoueur = arrayJoueur;
      this.modeJeu = modeJeu;
      this.tempsJeu = tempsJeu;
      this.modeGraphique = modeGraphique;
    }

    /** Rôle : créer un fichier de sauvegarde en format binaire
    * @param path le nom du fichier qui va contenir la sauvegarde */
    public void sauvegarder(String path){
      ObjectOutPutStream writer = new ObjectOutputStream(new FileOutputStream(path));
      writer.writeObject(this.lePlateau);
      writer.writeObject(this.arrayJoueur);
      writer.writeObject(this.modeJeu);
      writer.writeObject(this.tempsJeu);
      writer.writeObject(this.modeGraphique);
    }

    /** Rôle : permet d'importer un fichier de sauvegarde en format de binaire
    * pour permettre à l'utilisateur de charger une partie sauvegardée et de
    * reprendre le jeu.
    * @param path le nom du fichier à charger */
    public void charger(String path){
      try{
        for(int i = 0; i < )
      }
    }
}
