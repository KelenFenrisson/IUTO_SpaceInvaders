package game;// CLASSE DONNEE AUX ETUDIANTS
// A COMPLETER
import gui.Main;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.ArrayList;

/** CLASSE GestionJeu
 *
 * Gère le déroulement du jeu. Elle est TENTACULAIRE ! Il faut absolument que je fasse quelque chose à
 * ce sujet une fois terminee
 *
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * private int largeur;
 * private int hauteur;
 * private Dessin dessin;
 * private HUD hud;
 * private Score score;
 * private ArrayList<Dessin> elementsdeJeu;
 * private ChargeurDessin chargeurAlien;
 * private ChargeurDessin chargeurVaisseau;
 * private ChargeurDessin chargeurProjectile;
 * private Niveau niveau;
 * private Vaisseau vaisseau;
 * private ArrayList<Alien> listeEnnemis;
 * private ArrayList<Projectile> listeTirs;
 * private int compteTours;
 * 
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public GestionJeu()
 * public void initHUD()
 * public int getLargeur()
 * public int getHauteur()
 * public HUD getHud()
 * public Score getScore()
 * public ArrayList<Dessin> getElementsdeJeu()
 * public ChargeurDessin getChargeurAlien()
 * public ChargeurDessin getChargeurVaisseau()
 * public ChargeurDessin getChargeurProjectile()
 * public Niveau getNiveau()
 * public Vaisseau getVaisseau()
 * public ArrayList<Alien> getListeEnnemis()
 * public ArrayList<Projectile> getListeTirs()
 * public int getCompteTours()
 * public void setLargeur(int largeur)
 * public void setHauteur(int hauteur)
 * public void setDessin(Dessin dessin)
 * public void setHud(HUD hud)
 * public void setScore(Score score)
 * public void setElementsdeJeu(ArrayList<Dessin> elementsdeJeu)
 * public void setChargeurAlien(ChargeurDessin chargeurAlien)
 * public void setChargeurVaisseau(ChargeurDessin chargeurVaisseau)
 * public void setChargeurProjectile(ChargeurDessin chargeurProjectile)
 * public void setNiveau(Niveau niveau)
 * public void setVaisseau(Vaisseau vaisseau)
 * public void setListeEnnemis(ArrayList<Alien> listeEnnemis)
 * public void setListeTirs(ArrayList<Projectile> listeTirs)
 * public void setCompteTours(int compteTours)
 * public Dessin getDessin()
 * public void jouerUnTour()
 * public void toucheEspace()
 * public void toucheDroite()
 * public void creerEnnemis()
 * public void deplacerEnnemis()
 * public void deplacerTirs()
 * public void detecterCollisions()
 * public void nettoyagetableau()
 * public void majScore(int points)
 * public void checkCycleJeu()
 * public void levelOver()
 * public void gameOver()
 * *********************************************************************************************************************
 */
public class GestionJeu{

    // =================================================================================================================
    // ==============================================   ATTRIBUTES    ==================================================
    // =================================================================================================================

	private int largeur;
	private int hauteur;
	private Dessin dessin;
	private HUD hud;
	private Score score;
    private ArrayList<Dessin> elementsdeJeu;
	private ChargeurDessin chargeurAlien;
    private ChargeurDessin chargeurVaisseau;
    private ChargeurDessin chargeurProjectile;
    private Niveau niveau;
    private Vaisseau vaisseau;
    private ArrayList<Alien> listeEnnemis;
    private ArrayList<Projectile> listeTirs;
    private int compteTours;

    // =================================================================================================================
    // ==============================================   CONSTRUCTOR   ==================================================
    // =================================================================================================================
	// ATTENTION, seul le constructeur sans paramètre est accepté

    public GestionJeu() {
        this.largeur = Main.LARGEUR_VUE;
        this.hauteur = Main.HAUTEUR_VUE;
        this.dessin = new Dessin();
        this.score = new Score();
        this.elementsdeJeu = new ArrayList<Dessin>();
        this.chargeurAlien = new ChargeurDessin("src/game/skins_aliens.txt");
        this.chargeurVaisseau = new ChargeurDessin("src/game/skins_ships.txt");
        this.chargeurProjectile = new ChargeurDessin("src/game/skins_missiles.txt");
        this.niveau = new Niveau(1,"",1,1,1);
        this.vaisseau = new Vaisseau(0, 0,this.chargeurVaisseau.getListeDessin(),0,1);
        this.listeEnnemis = new ArrayList<Alien>();
        this.listeTirs = new ArrayList<Projectile>();
        this.hud = new HUD(this.getLargeur(), this.getHauteur());
        this.compteTours = 0;

        this.initHUD();
        this.elementsdeJeu.add(this.vaisseau);
        this.creerEnnemis();

    }


    // =================================================================================================================
    // ==================================================   INITS   ====================================================
    // =================================================================================================================
    public void initHUD()
    {


    }

    // =================================================================================================================
    // ==================================================   GETTERS   ==================================================
    // =================================================================================================================

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public HUD getHud() {
        return hud;
    }

    public Score getScore() {
        return score;
    }

    public ArrayList<Dessin> getElementsdeJeu() {
        return elementsdeJeu;
    }

    public ChargeurDessin getChargeurAlien() {
        return chargeurAlien;
    }

    public ChargeurDessin getChargeurVaisseau() {
        return chargeurVaisseau;
    }

    public ChargeurDessin getChargeurProjectile() {
        return chargeurProjectile;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Vaisseau getVaisseau() {
        return vaisseau;
    }

    public ArrayList<Alien> getListeEnnemis() {
        return listeEnnemis;
    }

    public ArrayList<Projectile> getListeTirs() {
        return listeTirs;
    }

    public int getCompteTours() {
        return compteTours;
    }


    // =================================================================================================================
    // ==================================================   SETTERS   ==================================================
    // =================================================================================================================


    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setDessin(Dessin dessin) {
        this.dessin = dessin;
    }

    public void setHud(HUD hud) {
        this.hud = hud;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setElementsdeJeu(ArrayList<Dessin> elementsdeJeu) {
        this.elementsdeJeu = elementsdeJeu;
    }

    public void setChargeurAlien(ChargeurDessin chargeurAlien) {
        this.chargeurAlien = chargeurAlien;
    }

    public void setChargeurVaisseau(ChargeurDessin chargeurVaisseau) {
        this.chargeurVaisseau = chargeurVaisseau;
    }

    public void setChargeurProjectile(ChargeurDessin chargeurProjectile) {
        this.chargeurProjectile = chargeurProjectile;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setVaisseau(Vaisseau vaisseau) {
        this.vaisseau = vaisseau;
    }

    public void setListeEnnemis(ArrayList<Alien> listeEnnemis) {
        this.listeEnnemis = listeEnnemis;
    }

    public void setListeTirs(ArrayList<Projectile> listeTirs) {
        this.listeTirs = listeTirs;
    }

    public void setCompteTours(int compteTours) {
        this.compteTours = compteTours;
    }



    // =================================================================================================================
    // ================================================   METHODS   ====================================================
    // =================================================================================================================


    // ATTENTION - la méthode getDessin() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette 
	// méthode au risque de saturer rapidement la mémoire
    public Dessin getDessin(){
	    this.dessin.vider();

        //Ajouter render ici
        for (Dessin element:this.elementsdeJeu)
        {
            this.dessin.ajouteDessin(element);
        }

		return dessin;
	}
	
	// ATTENTION - la méthode jouerUnTour() est appelée environ 40 fois par seconde
	// donc, il ne faut pas instancier de nouvel objet dans cette 
	// méthode au risque de saturer rapidement la mémoire
    public void jouerUnTour(){

	    // Deplacements
	    this.deplacerEnnemis();
        this.deplacerTirs();
	    // Collisions
        this.detecterCollisions();
        // Nettoyage
        this.nettoyagetableau();
        // Condition de fin de partie
        this.checkCycleJeu();
        // MaJ Affichage
	    this.getDessin();
        // Nouveau tour
        ++this.compteTours;
	}


    public void toucheEspace()
    {
        //System.out.println("Appui touche Espace");
        AudioClip pew = new AudioClip(Paths.get("src/sfx/phasers3.wav").toUri().toString());
        pew.setVolume(0.05);
        pew.play();
        Position canon = this.vaisseau.getPositionCanon();
        Projectile tir = new Projectile(canon.getX(), canon.getY(),this.chargeurProjectile.getListeDessin(),6,10);
        this.listeTirs.add(tir);
        this.elementsdeJeu.add(tir);
//        System.out.println("Taille liste des ennemis : "+ this.listeEnnemis.size());
//        System.out.println("Taille liste d'elements de jeu : "+ this.elementsdeJeu.size());
	}

    public void toucheDroite()
    {
        //System.out.println("Appui touche Droite");
		if(this.vaisseau.getX()+this.vaisseau.getLargeur()+1<this.getLargeur())
        {
            this.vaisseau.deplacer(1,0);
        }
	}

    public void toucheGauche(){
        //System.out.println("Appui touche Gauche");
        if(this.vaisseau.getX()-1>=0)
        {

            this.vaisseau.deplacer(-1,0);
        }
    }

    public void creerEnnemis()
    {
        // Un Alien a une taille max de (17,7) selon le fichier skins_aliens.txt

        for(int x = 10; x<this.getLargeur()-10;x+=18)
        {
            for(int y = this.getHauteur()-7; y>this.getHauteur()/2;y-=7)
            {
                Alien nouveau = new Alien(x,y, this.chargeurAlien.getListeDessin(), 4,10);
                this.listeEnnemis.add(nouveau);
                this.elementsdeJeu.add(nouveau);
            }
        }

        AudioClip ufo = new AudioClip(Paths.get("src/sfx/ufo2.wav").toUri().toString());
        ufo.setVolume(0.25);
        ufo.play();
        this.getNiveau().bgmPlay();

    }

    public void deplacerEnnemis()
    {
        //System.out.println("Déplacement des Aliens");
        for(Alien ennemi: this.listeEnnemis)
        {
            if((this.compteTours/100)%2!=0)
            {
                ennemi.deplacer(0.1,-0.05);
            }
            else
            {
                ennemi.deplacer(-0.1,-0.05);
            }
        }
    }

    public void deplacerTirs()
    {
        //System.out.println("Déplacement des tirs");
        for(Projectile tir:this.listeTirs)
        {
            tir.deplacer(0,1);
        }
    }

    public void detecterCollisions()
    {
        //System.out.println("Detection des collisions");
        for(Alien mob:this.listeEnnemis)
        {
            for(Projectile tir : this.listeTirs)
            {
                if (mob.contient(tir.getX(), tir.getY()))
                {
                    mob.subirDegats(tir.getPower());
                    tir.setHit(true);
                    this.majScore(10);
                }
            }
        }
    }

    public void nettoyagetableau()
    {
        ArrayList<Projectile> restants=new ArrayList<Projectile>(); // Tirs en jeu le prochain tour
        ArrayList<Alien> survivants=new ArrayList<Alien>();// Aliens en jeu le prochain tour
        ArrayList<Dessin> pions = new ArrayList<Dessin>();// Objets jeu a render le prochain tour
        pions.add(this.vaisseau);

        //System.out.println("Nettoyage du tableau");
        for(Projectile tir : this.listeTirs)
        {
            if(tir.getY()<this.getHauteur() && !tir.isHit())
            {
                restants.add(tir);
                pions.add(tir);
            }
        }
        this.listeTirs=restants;

        for(Alien mob:this.listeEnnemis)
        {
            if(!mob.isMort())
            {
                survivants.add(mob);
                pions.add(mob);
            }
        }
        this.listeEnnemis=survivants;
        this.elementsdeJeu = pions;

    }

    public void majScore(int points)
    {
        //System.out.println("Mise a jour du score");
        this.score.setPoints(this.score.getPoints()+points);
    }


    public void checkCycleJeu()
    {
        //System.out.println("Y a t'il victoire ou defaite ?");
        if(this.listeEnnemis.size()==0)
        {
            this.levelOver();
        }
        else
        {
            for(Alien mob : this.listeEnnemis)
                if(mob.getY()<=0)
                {
                    System.out.println("Le joueur perd une vie !");
                    this.gameOver();
                }
        }
    }

    public void levelOver()
    {
        //System.out.println("Fin du niveau");
        this.getNiveau().bgmStop();
    }


    public void gameOver()
    {
        System.out.println("Game Over");
        this.getNiveau().bgmStop();
    }
}
