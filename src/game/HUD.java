package game;

/** Classe gérant l'affichage des infos sur le dessin du jeu
 * Created by mathieu on 11/02/17.
 */
public class HUD extends Dessin
{
    private int screenWidth;
    private int screenHeight;
    private int score;
    private int levelNum;
    private ChainePositionnee scoreTag;
    private ChainePositionnee newGameMsg;
    private ChainePositionnee newLevelMsg;
    private ChainePositionnee endLevelMsg;
    private ChainePositionnee gameOverMsg;

    public HUD(int largeur, int hauteur)
    {
        this.screenWidth = largeur;
        this.screenHeight = hauteur;
    }

    // =================================================================================================================
    // ==================================================   GETTERS   ==================================================
    // =================================================================================================================

    public int getScore() {
        return score;
    }

    public int getLevelNum() {
        return levelNum;
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

    // =================================================================================================================
    // ==================================================   SETTERS   ==================================================
    // =================================================================================================================

    public void setScore(int score) {
        this.score = score;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
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
}
