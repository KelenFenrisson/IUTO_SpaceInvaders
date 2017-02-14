package game;

/** CLASSE SCore
 *
 * Compteur de points
 *
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 * private int points;
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public Score()
 * public int getPoints()
 * public void setPoints(int points)
 * *********************************************************************************************************************
 */
public class Score
{
    private int points;

    public Score()
    {
        this.points=0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
