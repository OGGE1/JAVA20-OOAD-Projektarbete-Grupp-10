/**
 * Created by Oscar Norman <br>
 * Date: 2020-11-24   <br>
 * Time: 13:59   <br>
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10 <br>
 */
public class Yatzy {
    boolean playAgain = true;
    Database database;

    Yatzy(){
        database = new Database();
        while(playAgain){
            new Game(this, database);
        }
    }

    public void quit(){
        playAgain = false;
    }
}
