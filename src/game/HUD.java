package game;

/** CLASSE HUD
 *
 * Depuis l'apparition de Game.fxml qui gère la vue. Cette classe a t-elle encore un sens ?
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 * 
 * private int screenWidth;
 * private int screenHeight;
 * private int score;
 * private int levelNum;
 * private ChainePositionnee scoreTag;
 * private ChainePositionnee newGameMsg;
 * private ChainePositionnee newLevelMsg;
 * private ChainePositionnee endLevelMsg;
 * private ChainePositionnee gameOverMsg;
 *
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public HUD(int largeur, int hauteur)
 * public int getScore()
 * public int getLevelNum()
 * public ChainePositionnee getScoreTag()
 * public ChainePositionnee getNewGameMsg()
 * public ChainePositionnee getNewLevelMsg()
 * public ChainePositionnee getEndLevelMsg()
 * public ChainePositionnee getGameOverMsg()
 * public void setScore(int score)
 * public void setLevelNum(int levelNum)
 * public void setScoreTag(ChainePositionnee scoreTag)
 * public void setNewGameMsg(ChainePositionnee newGameMsg)
 * public void setNewLevelMsg(ChainePositionnee newLevelMsg)
 * public void setEndLevelMsg(ChainePositionnee endLevelMsg)
 * public void setGameOverMsg(ChainePositionnee gameOverMsg) 
 * *********************************************************************************************************************
 */
public class HUD extends Dessin {
    private int screenWidth;
    private int screenHeight;
    private Score score;
    private Niveau niveau;
    private ChainePositionnee scoreTag;
    private ChainePositionnee newGameMsg;
    private ChainePositionnee newLevelMsg;
    private ChainePositionnee endLevelMsg;
    private ChainePositionnee gameOverMsg;

    public HUD(int largeur, int hauteur, Score score, Niveau niveau) {
        this.screenWidth = largeur;
        this.screenHeight = hauteur;
        this.score = score;
        this.niveau = niveau;
    }

    // =================================================================================================================
    // ==================================================   GETTERS   ==================================================
    // =================================================================================================================

    public Score getScore() {
        return score;
    }

    public ChainePositionnee getScoreTag() {
        return scoreTag;
    }

    public ChainePositionnee getNewGameMsg() {
        return newGameMsg;
    }

    public ChainePositionnee getNewLevelMsg() {
        return newLevelMsg;
    }

    public ChainePositionnee getEndLevelMsg() {
        return endLevelMsg;
    }

    public ChainePositionnee getGameOverMsg() {
        return gameOverMsg;
    }

    public Niveau getNiveau() {
        return niveau;
    }
// =================================================================================================================
    // ==================================================   SETTERS   ==================================================
    // =================================================================================================================

    public void setScore(Score score) {
        this.score = score;
    }

    public void setScoreTag(ChainePositionnee scoreTag) {
        this.scoreTag = scoreTag;
    }

    public void setNewGameMsg(ChainePositionnee newGameMsg) {
        this.newGameMsg = newGameMsg;
    }

    public void setNewLevelMsg(ChainePositionnee newLevelMsg) {
        this.newLevelMsg = newLevelMsg;
    }

    public void setEndLevelMsg(ChainePositionnee endLevelMsg) {
        this.endLevelMsg = endLevelMsg;
    }

    public void setGameOverMsg(ChainePositionnee gameOverMsg) {
        this.gameOverMsg = gameOverMsg;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

// =================================================================================================================
// =================================================   METHODES   ==================================================
// =================================================================================================================

    public void update() {
        this.vider();
        this.ajouteChaine(0.5, this.screenHeight-1, this.getNiveau().getNom());
        this.ajouteChaine(0.5, this.screenHeight-2, this.getScore().toString());

    }
}