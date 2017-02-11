package game;

import java.util.ArrayList;

/**
 * Created by pubert on 09/02/17.
 */
class Personnage extends Diaporama
{
    boolean mort;
    boolean touche;
    int vies;

    Personnage(double x, double y, ArrayList<Dessin> listeVues, int numVue, int vies)
    {
        super(x, y, listeVues, numVue);
        this.vies = vies;
        this.touche = false;
    }

    boolean isMort() {
        return mort;
    }

    void setMort(boolean mort) {
        this.mort = mort;
    }

    public boolean isTouche() {
        return touche;
    }

    public void setTouche(boolean touche) {
        this.touche = touche;
    }

    int getVies() {
        return vies;
    }

    void setVies(int vies) {
        this.vies = vies;
    }

    void deplacer(double dx, double dy)
    {
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }

    void subirDegats(int montant)
    {
        this.setVies(this.getVies()-montant);
        if(this.getVies()>0) {
            this.setNumVue(this.getVies());
        }
        else
        {
            this.setMort(true);
        }
    }
}
