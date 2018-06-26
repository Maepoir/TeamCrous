package arcanor.modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Role : Cette classe modélise le Plateau de jeu de Arcanor
 *
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 * *
 */
public class Plateau implements Serializable {

    //la grille de jeu
    private Joueur j1;
    private Joueur j2;
    private ArrayList<Pion> lesPions;

    /**
     * Role : Cette méthode permet de créer un objet Plateau
     */
    public Plateau(Joueur j1, Joueur j2) {
        this.j1 = j1;
        this.j2 = j2;
        initPions();
    }

    private void initPions() {

        this.lesPions = new ArrayList<>();

//        Joueur 1
        this.lesPions.add(new Pion(1, true, null, 0, 0, this.j1, 1));
        this.lesPions.add(new Pion(2, false, this.lesPions.get(0), 0, 0, this.j1, 2));
        this.lesPions.add(new Pion(3, true, null, 1, 0, this.j1, 3));
        this.lesPions.add(new Pion(4, false, this.lesPions.get(2), 1, 0, this.j1, 4));
        this.lesPions.add(new Pion(1, true, null, 3, 0, this.j1, 5));
        this.lesPions.add(new Pion(2, false, this.lesPions.get(4), 3, 0, this.j1, 6));
        this.lesPions.add(new Pion(3, true, null, 4, 0, this.j1, 7));
        this.lesPions.add(new Pion(4, false, this.lesPions.get(6), 4, 0, this.j1, 8));
        this.lesPions.add(new Pion(1, true, null, 6, 0, this.j1, 9));
        this.lesPions.add(new Pion(2, false, this.lesPions.get(8), 6, 0, this.j1, 10));
        this.lesPions.add(new Pion(3, true, null, 7, 0, this.j1, 11));
        this.lesPions.add(new Pion(4, false, this.lesPions.get(10), 7, 0, this.j1, 12));

//        Joueur 2
        this.lesPions.add(new Pion(3, true, null, 0, 6, this.j2, 13));
        this.lesPions.add(new Pion(4, false, this.lesPions.get(12), 0, 6, this.j2, 14));
        this.lesPions.add(new Pion(1, true, null, 1, 6, this.j2, 15));
        this.lesPions.add(new Pion(2, false, this.lesPions.get(14), 1, 6, this.j2, 16));

        this.lesPions.add(new Pion(3, true, null, 3, 6, this.j2, 17));
        this.lesPions.add(new Pion(4, false, this.lesPions.get(16), 3, 6, this.j2, 18));
        this.lesPions.add(new Pion(1, true, null, 4, 6, this.j2, 19));
        this.lesPions.add(new Pion(2, false, this.lesPions.get(18), 4, 6, this.j2, 20));

        this.lesPions.add(new Pion(3, true, null, 6, 6, this.j2, 21));
        this.lesPions.add(new Pion(4, false, this.lesPions.get(20), 6, 6, this.j2, 22));
        this.lesPions.add(new Pion(1, true, null, 7, 6, this.j2, 23));
        this.lesPions.add(new Pion(2, false, this.lesPions.get(22), 7, 6, this.j2, 24));

    }

    /**
     * Role : Cette méthode permet de deplacer un pion
     *
     * @param lePion le pion que l'on souhaite deplacer
     * @param i      le numéro du déplacement a effectuer
     * @param libere true si on libère le pion caché, faux sinon
     */
    public boolean deplacerPion(Pion lePion, int i, boolean libere, boolean g) {
        boolean ret = false;

        int x = deplacementPossibles(lePion)[i][0];
        int y = deplacementPossibles(lePion)[i][1];
        if (x != -1 && y != -1) {
            if (estLibre(x, y)) {
                lePion.setXY(x, y);
                ret = true;

                //gérer libération des pions
                if (libere && lePion.getAMange() != null) {
                    lePion.getAMange().setEstMange(false);
                    lePion.setAMange(null);
                } else if (!libere && lePion.getAMange() != null) {
                    lePion.getAMange().setXY(x, y);
                }

            }
            else if((!estLibre(x, y) && (getPion(x, y).getTAILLE() == lePion.getTAILLE()-1)) && lePion.getAMange() == null && !lePion.getLeJoueur().equals(getPion(x,y).getLeJoueur())){
                manger(lePion, getPion(x,y));
                lePion.setXY(x,y);
                ret = true;
            }
            else if((!estLibre(x,y)) && lePion.getLeJoueur().equals(getPion(x,y).getLeJoueur())){
                if(!g){
                    System.out.println("Vous ne pouvez pas manger votre propre pion");
                }
            }
            else if (!estLibre(x,y) && lePion.getAMange() != null){
                if(!g){
                    System.out.println("Vous ne pouvez pas manger un pion quand il y en a un sous le votre.");
                }
            }
            else {
                if(!g) {
                    System.out.println("Vous ne pouvez pas manger un pion plus gros !");
                }
            }


        } else {
            if(!g) {
                System.out.println("Deplacement hors des limites, veuillez choisir un autre deplacement s'il vous plait.");
            }
        }

        return ret;
    }

    /**
     * Role : Cette méthode permet de manger un pion
     *
     * @param mangeur le pion qui mange
     * @param mange   le pion qui est mangé
     */
    public void manger(Pion mangeur, Pion mange) {
        mangeur.setAMange(mange);
        mange.setEstMange(true);
    }

    /**
     * Role : Cette méthode permet de connaitre les deplacements possible d'un pion
     *
     * @param lePion le pion que l'on veut deplacer
     * @return les coordonnées de déplacements possibles
     */
    public int[][] deplacementPossibles(Pion lePion) {
        int[][] ret = new int[8][2];
//      Solution 0
        if (lePion.getX() - 1 >= 0 && lePion.getY() - 1 >= 0) {
            ret[0][0] = lePion.getX() - 1;
            ret[0][1] = lePion.getY() - 1;
        } else {
            ret[0][0] = -1;
            ret[0][1] = -1;
        }

//      Solution 1
        if (lePion.getX() - 1 >= 0) {
            ret[1][0] = lePion.getX() - 1;
            ret[1][1] = lePion.getY();
        } else {
            ret[1][0] = -1;
            ret[1][1] = -1;
        }


//      Solution 2
        if (lePion.getX() - 1 >= 0 && lePion.getY() + 1 < 7) {
            ret[2][0] = lePion.getX() - 1;
            ret[2][1] = lePion.getY() + 1;
        } else {
            ret[2][0] = -1;
            ret[2][1] = -1;
        }

//      Solution 3
        if (lePion.getY() + 1 < 7) {
            ret[3][0] = lePion.getX();
            ret[3][1] = lePion.getY() + 1;
        } else {
            ret[3][0] = -1;
            ret[3][1] = -1;
        }

//      Solution 4
        if (lePion.getX() + 1 < 8 && lePion.getY() + 1 < 7) {
            ret[4][0] = lePion.getX() + 1;
            ret[4][1] = lePion.getY() + 1;
        } else {
            ret[4][0] = -1;
            ret[4][1] = -1;
        }


//      Solution 5
        if (lePion.getX() + 1 < 8) {
            ret[5][0] = lePion.getX() + 1;
            ret[5][1] = lePion.getY();
        } else {
            ret[5][0] = -1;
            ret[5][1] = -1;
        }

//      Solution 6
        if (lePion.getX() + 1 < 8 && lePion.getY() - 1 >= 0) {
            ret[6][0] = lePion.getX() + 1;
            ret[6][1] = lePion.getY() - 1;
        } else {
            ret[6][0] = -1;
            ret[6][1] = -1;
        }

//      Solution 7
        if (lePion.getY() - 1 >= 0) {
            ret[7][0] = lePion.getX();
            ret[7][1] = lePion.getY() - 1;
        } else {
            ret[7][0] = -1;
            ret[7][1] = -1;
        }

//      Return -1 dans le tableau si le pion ne peut pas aller dans cette direction
        return ret;
    }

    /**
     * Role : Cette méthode permet de recuperer un pion
     *
     * @param num le numéro du pion
     * @return le pion correspondant dans la grille
     */
    Pion getPion(int num) {
        Pion ret = null;
        for (Pion p : this.lesPions) {
            if (p.getNum() == num) {
                ret = p;
            }
        }
        return ret;
    }

    /**
     * Recupere un pion en fonction de ses coordonnées
     *
     * @param x coordonnée x
     * @param y coordonnée y
     * @return le pion en coordonnée x y
     */
    public Pion getPion(int x, int y) {
        Pion ret = null;
        for (Pion p : this.lesPions) {
            if ( x == p.getX() && y == p.getY() ) {
                    if(ret == null || (ret != null && ret.getTAILLE() < p.getTAILLE())) {
                        ret = p;
                    }
            }
        }
        return ret;
    }

    /**
     * Vérifie si les conditions de victoire du joueur passé en paramtètre sont réunies
     *
     * @param j le joueur a vérifié
     * @return true si le joueur a réuni les conditions de victoire, false sinon
     */
    boolean verifVictoire(Joueur j) {
        boolean ret = false;
        int score = 0;
        if (j.equals(j1)) {
            for (Pion p : this.lesPions) {
                if (p.getY() == 6 && p.getLeJoueur().equals(j)) {
                    score += 5 - p.getTAILLE();
                }
            }
        } else if (j.equals(j2)) {
            for (Pion p : this.lesPions) {
                if (p.getY() == 0 && p.getLeJoueur().equals(j)) {
                    score += 5 - p.getTAILLE();
                }
            }
        }
        if (score >= 12) {
            ret = true;
        }

        return ret;
    }

    /**
     * permet de savoir si une case possède un pion ou non
     *
     * @param x la première coordonnées
     * @param y la deuxième coordonnée
     */
    private boolean estLibre(int x, int y) {
        boolean ret = true;
        if (getPion(x, y) != null) {
            ret = false;
        }
        return ret;
    }
}
