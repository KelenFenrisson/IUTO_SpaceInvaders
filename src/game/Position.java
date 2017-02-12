package game;

/** classe Position
 *
 * Parente des classes des elements de jeu.
 *
 * ##################### Attributs :
 *
 * double x : abscisse
 * double y; ordonnee
 *
 * ##################### Methodes :
 *
 * Constructeur(double, double):
 *
 * double getX():
 * double setX(double):
 *
 * double getY():
 * double setY(double)::
 *
 * boolean equals(double, double)
 *
 * Created by mathieu on 06/02/17.
 */

public class Position
{
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean equals(Position autre)
    {
        return this.getX()==autre.getX() && this.getY()==autre.getY();
    }
}
