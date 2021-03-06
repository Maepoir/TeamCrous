package arcanor;

import arcanor.modele.Jeu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Cette classe permet de créer une sauvegarde au cours de partie
 *
 * @author M.Poiré, S.Bay
 */
public class Sauvegarde {

    /**
     * Crée un fichier de sauvegarde en format binaire
     *
     * @param chemin le nom du fichier qui va contenir la sauvegarde
     * @param jeu le jeu qui doit être sauvegarder
     */
    public static void sauvegarder(String chemin, Jeu jeu) {
        try {
            ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream("../sauvegarde/" + chemin));
            if (jeu != null) {
                fichier.writeObject(jeu);
            } else {
                System.out.println("Pb de sauvegarde");
            }
            fichier.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Permet d'importer un fichier de sauvegarde en format de binaire
     * pour permettre à l'utilisateur de charger une partie sauvegardée et de
     * reprendre le jeu.
     *
     * @param chemin le nom du fichier à charger
     */
    public static Jeu charger(String chemin) {
        Jeu jeu = null;
        try {
            ObjectInputStream fichier = new ObjectInputStream(new FileInputStream("../sauvegarde/" + chemin));
            jeu = (Jeu) fichier.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jeu;
    }
}
