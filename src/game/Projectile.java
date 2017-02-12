package game;

import java.util.ArrayList;

/**
 * Created by pubert on 09/02/17.
 */
public class Projectile extends Personnage
{
    private boolean hit;
    private int power;

    public Projectile(double x, double y, ArrayList<Dessin> listeVues, int numVue, int power)
    {
        super(x, y, listeVues, numVue, 1);
        this.hit=false;
        this.power=power;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
