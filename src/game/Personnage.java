package game;

import java.util.ArrayList;


/** CLASSE Personnage
 *
 *
 *
 * *********************************************************************************************************************
 * ATTRIBUTS
 *
 * private double x;
 * private double y;
 * private ArrayList<Dessin> listeVues;
 * private int numVue;
 * private double largeur;
 * private double hauteur;
 *
 * *********************************************************************************************************************
 * METHODES
 *
 * public Personnage(double x, double y, ArrayList<Dessin> listeVues, int numVue, int vies)
 * public boolean isMort()
 * public void setMort(boolean mort)
 * public boolean isTouche()
 * public void setTouche(boolean touche)
 * public int getVies()
 * public void setVies(int vies)
 * public void deplacer(double dx, double dy)
 * public void subirDegats(int montant)
 * *********************************************************************************************************************
 */
public class Personnage extends Diaporama
{
    private boolean mort;
    private boolean touche;
    private int vies;

    public Personnage(double x, double y, ArrayList<Dessin> listeVues, int numVue, int vies)
    {
        super(x, y, listeVues, numVue);
        this.vies = vies;
        this.touche = false;
    }

    public boolean isMort() {
        return mort;
    }

    public void setMort(boolean mort) {
        this.mort = mort;
    }

    public boolean isTouche() {
        return touche;
    }

    public void setTouche(boolean touche) {
        this.touche = touche;
    }

    public int getVies() {
        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }

    public void deplacer(double dx, double dy)
    {
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }

    public void subirDegats(int montant)
    {
        this.setVies(this.getVies()-montant);
        if(this.getVies()<=0) {
            this.setMort(true);
        }
    }
}
