package game;
/** CLASSE Position
 *
 *
 * Couple de coordonnees
 *
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 * double x : abscisse
 * double y; ordonnee
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public Position(double x, double y)
 *
 * double getX():
 * double setX(double):
 *
 * double getY():
 * double setY(double)::
 *
 * boolean equals(double, double)
 *
 * *********************************************************************************************************************
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
