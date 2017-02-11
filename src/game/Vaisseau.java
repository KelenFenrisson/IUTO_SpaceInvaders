package game;

import java.util.ArrayList;

/**
 * Created by pubert on 09/02/17.
 */
class Vaisseau extends Personnage
{
    ArrayList<Dessin> listeProjectiles;
    Vaisseau(double x, double y, ArrayList<Dessin> listeVues, int numVue, int vies)
    {
        super(x, y, listeVues, numVue, vies);
        this.listeProjectiles = new ArrayList<Dessin>();
    }

    void setListeProjectiles(ArrayList<Dessin> listeP)
    {
        this.listeProjectiles = listeP;
    }

    Position getPositionCanon()
    {
        return new Position(this.getX()+(this.getLargeur()/2), this.getY()+this.getHauteur());
    }


}
