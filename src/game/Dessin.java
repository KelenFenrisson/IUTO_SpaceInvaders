package game;


import java.util.ArrayList;

/** CLASSE Dessin
 *
 *
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * private ArrayList<ChainePositionnee> listeChaines;
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public Dessin()
 * public ArrayList<ChainePositionnee> getChaines()
 * public void ajouteChaine(double x, double y, String chaine)
 * public void ajouteDessin(Dessin autreDessin)
 * public boolean contient(double posx, double posy)
 * public void vider()
 * *********************************************************************************************************************
 */
 
public class Dessin {
	/* ======== Attributs ======== */
    private ArrayList<ChainePositionnee> listeChaines;
    
    /* ======== Constructeur ======== */
    public Dessin(){
		this.listeChaines= new ArrayList<ChainePositionnee>();
	}
	
	/* ======== Getteurs ======== */
    public ArrayList<ChainePositionnee> getChaines(){
		return this.listeChaines;
	}
	
	/* ======== Autres méthodes ======== */

    public void ajouteChaine(double x, double y, String chaine){
        this.listeChaines.add(new ChainePositionnee(x,y,chaine));
    }


    public void ajouteDessin(Dessin autreDessin){
        for(ChainePositionnee cp : autreDessin.getChaines())
            this.listeChaines.add(cp);
    }

	/**
	 * indique si une position (x,y) coincide avec l'un des caractères
	 * de l'ensemble des chaines de caractères
	 */ 
    public boolean contient(double posx, double posy){
        for(ChainePositionnee cp: listeChaines){
            if (cp.contient(posx, posy) && cp.getChaine().charAt((int)(posx-cp.getx()))!=' ')
                return true;
        }
        return false;
    }
    
    /**
	 * permet de vider le dessin
	 */ 
    public void vider(){ this.listeChaines.clear();}

}
