package game;

import java.util.ArrayList;

/** CLASSE Projectile
 *
 * Classe des projectiles tirés par le vaisseau
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 * private boolean hit;
 * private int power;
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public Projectile(double x, double y, ArrayList<Dessin> listeVues, int numVue, int power)
 * public boolean isHit()
 * public void setHit(boolean hit)
 * public int getPower()
 * public void setPower(int power)
 * *********************************************************************************************************************
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
