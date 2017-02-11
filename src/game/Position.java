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

class Position
{
    private double x;
    private double y;

    Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    double getY() {
        return y;
    }

    void setY(double y) {
        this.y = y;
    }

    boolean equals(Position autre)
    {
        return this.getX()==autre.getX() && this.getY()==autre.getY();
    }
}
