package game;

import javafx.scene.media.AudioClip;
import java.nio.file.Paths;

/** CLASSE Niveau
 *
 *
 *
 * *********************************************************************************************************************
 * ATTRIBUTS
 *
 * private int num;
 * private String nom;
 * private double vitesseEnnemis;
 * private int vieEnnemis;
 * private int modScoreEnnemis;
 * private AudioClip bgm;
 * private boolean termine;
 *
 * *********************************************************************************************************************
 * METHODES
 *
 * public Niveau(int num, String nom, double vitesseEnnemis, int vieEnnemis, int modScoreEnnemis)
 * public int getNum()
 * public String getNom()
 * public double getVitesseEnnemis()
 * public int getVieEnnemis()
 * public int getModScoreEnnemis()
 * public AudioClip getBgm()
 * public void setBgm(AudioClip bgm)
 * public void bgmPlay()
 * public void bgmStop()
 * public boolean isTermine()
 * public void setTermine(boolean termine)
 * *********************************************************************************************************************
 */
public class Niveau
{
    private int num;
    private String nom;
    private double vitesseEnnemis;
    private int vieEnnemis;
    private int modScoreEnnemis;

    private AudioClip bgm;
    private boolean termine;

    public Niveau(int num, String nom, double vitesseEnnemis, int vieEnnemis, int modScoreEnnemis) {
        this.num = num;
        this.nom = nom;
        this.vitesseEnnemis = vitesseEnnemis;
        this.vieEnnemis = vieEnnemis;
        this.modScoreEnnemis = modScoreEnnemis;
        this.bgm = new AudioClip(Paths.get("src/sfx/bgm.wav").toUri().toString());
        this.bgm.setVolume(0.25);
    }

    public int getNum() {
        return num;
    }


    public String getNom()
    {
        this.nom="Niveau "+this.getNum();
        return nom;
    }

    public double getVitesseEnnemis()
    {
        if(this.vitesseEnnemis>0)
        {
            this.vitesseEnnemis=0.01;
        }
        return vitesseEnnemis;
    }


    public int getVieEnnemis() {
        if(this.vieEnnemis<=0)
        {
            this.vieEnnemis=1;
        }
        return vieEnnemis;
    }

    public int getModScoreEnnemis() {
        if(this.modScoreEnnemis<=0)
        {
            this.modScoreEnnemis=num;
        }
        return modScoreEnnemis;
    }

    public AudioClip getBgm() {
        return bgm;
    }

    public void setBgm(AudioClip bgm) {
        this.bgm = bgm;
    }

    public void bgmPlay() {
        this.bgm.play();
    }

    public void bgmStop() {
        this.bgm.stop();
    }


    public boolean isTermine()
    {
        return termine;
    }

    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    public String toString(){return ""+this.getNum();}
}
