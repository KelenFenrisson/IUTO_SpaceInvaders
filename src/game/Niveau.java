package game;

/**
 * Created by mathieu on 11/02/17.
 */
class Niveau
{
    int num;
    String nom;
    double vitesseEnnemis;
    int vieEnnemis;
    int modScoreEnnemis;
    boolean termine;

    Niveau(int num, String nom, double vitesseEnnemis, int vieEnnemis, int modScoreEnnemis) {
        this.num = num;
        this.nom = nom;
        this.vitesseEnnemis = vitesseEnnemis;
        this.vieEnnemis = vieEnnemis;
        this.modScoreEnnemis = modScoreEnnemis;
    }

    int getNum() {
        return num;
    }


    String getNom()
    {
        if(this.nom.isEmpty())
        {
            this.nom="Niveau "+this.getNum();
        }
        return nom;
    }

    double getVitesseEnnemis()
    {
        if(this.vitesseEnnemis<=0)
        {
            this.vitesseEnnemis=0.01;
        }
        return vitesseEnnemis;
    }


    int getVieEnnemis() {
        if(this.vieEnnemis<=0)
        {
            this.vieEnnemis=1;
        }
        return vieEnnemis;
    }

    int getModScoreEnnemis() {
        if(this.modScoreEnnemis<=0)
        {
            this.modScoreEnnemis=num;
        }
        return modScoreEnnemis;
    }

    boolean isTermine()
    {
        return termine;
    }

    public void setTermine(boolean termine) {
        this.termine = termine;
    }
}
