package game;

/** CLASSE ChainePositionnee
 *
 *
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 * private double x;
 * private double y;
 * private String chaine;
 * *********************************************************************************************************************
 *
 * METHODES
 * public ChainePositionnee(double x, double y, String str)
 * public double getx()
 * public double gety()
 * public String getChaine()
 * public void setx(double x)
 * public void sety(double y)
 * public void setChaine(String c)
 * public boolean contient(double tx, double ty)
 * *********************************************************************************************************************
 */
public class ChainePositionnee{
	/* ======== Attributs ======== */
	private double x,y;
    private String chaine;
    
    /* ======== Constructeur ======== */
	public ChainePositionnee(double x, double y, String str){
		this.x=x;
		this.y=y;
		this.chaine=str;
	}
	
	/* ======== Getteurs ======== */
	public double getx(){ return this.x; }
	public double gety(){ return this.y; }
	public String getChaine(){ return this.chaine; }
		
	/* ======== Setteurs ======== */
	public void setx(double x){ this.x=x; }
	public void sety(double y){ this.y=y; }
	public void setChaine(String c){ this.chaine=c; }
	
	/* ======== Autres méthodes ======== */
	/**
	 * Cette méthode renvoie true si le point de coordonnées (tx, ty)
	 * coincide avec l'un des caractères de la chaine positionnée
	 */
	public boolean contient(double tx, double ty){
		return  (this.x <=tx  && (int) this.y == (int) ty && tx < this.x+chaine.length());
	}
 }
