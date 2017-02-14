package game;

import java.util.ArrayList;

/** CLASSE Alien
 *
 * Cette classe n'a pour le moment pas beaucoup de sens mais pourra me servir s'il me reste du temps pour personnaliser
 * le comportement des aliens
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 *
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public Alien(double x, double y, ArrayList<Dessin> listeVues, int numVue, int vies)
 *
 * *********************************************************************************************************************
 */

public class Alien extends Personnage
{
    public Alien(double x, double y, ArrayList<Dessin> listeVues, int numVue, int vies) {
        super(x, y, listeVues, numVue, vies);
    }
}
