package game;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** CLASSE ChargeurDessin
 *
 * Cette classe va piocher les caracteres ASCII des personnages du jeu et les transforme en liste de Dessin()
 *
 * *********************************************************************************************************************
 * ATTRIBUTS
 *
 * private ArrayList<Dessin> listeDessin;
 * private String nomFichier;
 *
 * *********************************************************************************************************************
 * METHODES
 *
 * public ChargeurDessin(String nomFichier)
 * public ChargeurDessin(String nomFichier)
 * public ArrayList<Dessin> getListeDessin()
 * public ArrayList<Dessin> remplirListeDessin() throws IOException
 * public void setListeDessin(ArrayList<Dessin> listeDessin)
 * public String getNomFichier()
 * public void setNomFichier(String nomFichier)
 * *********************************************************************************************************************
 */
public class ChargeurDessin
{
    private ArrayList<Dessin> listeDessin;
    private String nomFichier;

    public ChargeurDessin(String nomFichier) {
        //this.listeDessin = new ArrayList<Dessin>();
        this.setNomFichier(nomFichier);
        try {
            this.setListeDessin(this.remplirListeDessin());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Dessin> getListeDessin()
    {
        ArrayList<Dessin> liste = null;
        try {
            liste = this.remplirListeDessin();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Dessin> remplirListeDessin() throws IOException
    {
        ArrayList<Dessin> liste = new ArrayList<Dessin>();
        //On prepare un Dessin
        Dessin dessin = null;
        //On recupere les lignes du fichier
        List<String> lines = Files.readAllLines(Paths.get(this.getNomFichier()), Charset.defaultCharset());

        // Pour chaque ligne du fichier
        for(int i=0; i<lines.size();++i)
        {
            lines.set(i,this.nettoyerLigne(lines.get(i)));

            int ligneD=0; // Indice y de depart pour  un dessin

            // Si la ligne est vide, c'est un debut de dessin a la prochaine
            //On enregistre le courant, on prepare un new Dessin, et on met l'indice y a zero
            if(lines.get(i).isEmpty())
            {

                if (dessin!=null)
                {
                    Collections.reverse(dessin.getChaines());
                    liste.add(dessin);
                }
                dessin = new Dessin();
                ligneD=0;
                //System.out.println("Nouveau dessin");
            }
            else
            {
                dessin.ajouteChaine(0,ligneD, lines.get(i));
                ++ligneD;
                //System.out.println(lines.get(i));
            }

        }
        return liste;
    }

    public int getTailleListe()
    {
        return this.getListeDessin().size();
    }

    public String nettoyerLigne(String ligne)
    {
        String propre = ""; // C'est mieux.
        for(int i=0;i<ligne.length();++i)
        {
            if(ligne.charAt(i) == '░')
            {
                propre += ' ';
            }
            else
            {
                propre += ligne.charAt(i);
            }
        }
        return propre;
    }

    public void afficheDessins()
    {
        System.out.println("Il y a "+ this.getListeDessin().size() +" dessins");
        for(Dessin pic:this.getListeDessin())
        {
            for(ChainePositionnee cp:pic.getChaines())
            {
                System.out.println("Il y a "+ this.getListeDessin().size() +"dessins"+cp.getChaine());
            }
        }
    }

    public void setListeDessin(ArrayList<Dessin> listeDessin) {
        this.listeDessin = listeDessin;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }
}

