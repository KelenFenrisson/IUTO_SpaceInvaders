package game;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by mathieu on 18/02/17.
 */
public class HighScore
{
    private List<String> scorelist;
    private String filename = "src/game/highscores.txt";

    public HighScore()
    {
        try {
            this.scorelist = Files.readAllLines(Paths.get(this.filename), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getScorelist() {
        return scorelist;
    }

    public void setScorelist(List<String> scorelist) {
        this.scorelist = scorelist;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public void addScore(int score)
    {
        boolean isadded = false;
        if(!this.scorelist.isEmpty())
        {
            for(int i=0;i<this.getScorelist().size();++i)
            {
                if(score>Integer.parseInt(this.getScorelist().get(i)) && !isadded)
                {
                    this.getScorelist().add(i, String.valueOf(score));
                    isadded=true;
                }
            }
            if(!isadded){this.getScorelist().add(String.valueOf(score));}
        }
        this.toFile();
    }

    public void toFile()
    {
        this.getScorelist();
        OpenOption option = StandardOpenOption.WRITE;
        for(int i=0;i<10;++i)
        {
            try {
                Files.write(Paths.get(this.filename), this.getScorelist(),Charset.defaultCharset(),option);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
