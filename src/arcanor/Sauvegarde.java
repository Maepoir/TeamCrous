package arcanor;

import arcanor.modele.Joueur;
import arcanor.modele.Plateau;

import java.io.*;
import java.util.ArrayList;

/**
 * Rôle :  Cette classe permet de modéliser une sauvegarde au cours de partie
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class Sauvegarde implements java.io.Serializable {

    private Plateau lePlateau;
    private Joueur[] arrayJoueur;
    private int modeJeu;
    private long tempsJeu;
    private boolean modeGraphique;


    /**
     * Rôle : crée l'objet Sauvegarde
     */
    public Sauvegarde(Plateau lePlateau, Joueur[] arrayJoueur, int modeJeu, long tempsJeu, boolean modeGraphique) {
        this.lePlateau = lePlateau;
        this.arrayJoueur = arrayJoueur;
        this.modeJeu = modeJeu;
        this.tempsJeu = tempsJeu;
        this.modeGraphique = modeGraphique;
    }

    /**
     * Rôle : créer un fichier de sauvegarde en format binaire
     *
     * @param chemin le nom du fichier qui va contenir la sauvegarde
     */
    public void sauvegarder(String chemin) {
        try {
            ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream(chemin));
            fichier.writeObject(this.lePlateau);
            fichier.writeObject(this.arrayJoueur);
            fichier.writeObject(this.modeJeu);
            fichier.writeObject(this.tempsJeu);
            fichier.writeObject(this.modeGraphique);
            fichier.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Rôle : permet d'importer un fichier de sauvegarde en format de binaire
     * pour permettre à l'utilisateur de charger une partie sauvegardée et de
     * reprendre le jeu.
     *
     * @param chemin le nom du fichier à charger
     */
    public ArrayList charger(String chemin) {
        ArrayList liste = new ArrayList();
        try {
            ObjectInputStream fichier = new ObjectInputStream(new FileInputStream(chemin));
            Object o = fichier.readObject();
            while (o != null) {
                liste.add(o);
                o = fichier.readObject();
            }
            fichier.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }
        return liste;
    }
}
