package game;

import java.util.ArrayList;

/**
 * Created by mathieu on 09/02/17.
 */
public class Diaporama extends Dessin
{
    private double x; // x mini
    private double y; // y mini
    private ArrayList<Dessin> listeVues; // Liste des vues
    private int numVue;
    private double largeur;
    private double hauteur;

    public Diaporama(double x, double y, ArrayList<Dessin> listeVues, int numVue)
    {
        super();
        this.listeVues = listeVues;
        this.numVue = numVue;
        this.setNumVue(this.numVue);
        this.setX(x);
        this.setY(y);
        this.largeur = this.getLargeur();
        this.hauteur = this.getHauteur();

    }

    // Retourne le x le plus petit parmi this.getChaines()
    public double getX()
    {
        // On choppe la liste de ChainesPositionnes associées à la vue en cours
        ArrayList<ChainePositionnee> listeChaines = this.getChaines();

        //On colle le mini au x de la premiere chaine
        this.x = listeChaines.get(0).getx();

        //Pour chaque chaine a partir de la seconde,
        for(int i=1;i<listeChaines.size();++i)
        {
            if (listeChaines.get(i).getx()<x) // si la chaine a un x plus petit
            {
                this.x=listeChaines.get(i).getx(); // x devient le x de la chaine
            }
        }
        return this.x;
    }

    // Met à x les coordonnées de toutes les ChainePositionnee de this.getChaines()
    public void setX(double nx)
    {
        ArrayList<ChainePositionnee> listeChaines = this.getChaines();
        for(int i=0;i<listeChaines.size();++i)
        {
            listeChaines.get(i).setx(nx);
        }
    }

    public double getY()
    {
        ArrayList<ChainePositionnee> listeChaines = this.getChaines();
        this.y = listeChaines.get(0).gety();
        for(int i=1;i<listeChaines.size();++i)
        {
            if (listeChaines.get(i).gety()<y)
            {
                this.y=listeChaines.get(i).gety();
            }
        }
        return this.y;
    }


    // Met à ny+y les coordonnées de toutes les ChainePositionnee de this.getChaines()
    public void setY(double ny)
    {
        ArrayList<ChainePositionnee> listeChaines = this.getChaines();
        for(int i=0;i<listeChaines.size();++i)
        {
            ChainePositionnee chaine = listeChaines.get(i);
            chaine.sety(ny+i); //chaine.gety()+
        }
    }

    public int getLargeur()
    {
        return this.getChaines().get(0).getChaine().length();
    }

    public int getHauteur() {
        return this.getChaines().size();
    }

    public ArrayList<Dessin> getListeVues() {
        return listeVues;
    }

    public void setListeVues(ArrayList<Dessin> listeVues) {
        this.listeVues = listeVues;
    }

    // Retourne l'indice de la vue actuelle dans this.listeVues
    public int getNumVue() {
        return this.numVue;
    }

    //Met à this.listeVues.get(numVue) le dessin actuel, aux coordonnées actuelles et change numVue
    public void setNumVue(int numVue)
    {
        this.vider();
        this.ajouteDessin(this.listeVues.get(numVue));
    }

}
