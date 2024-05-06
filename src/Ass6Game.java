import Game.GameFlow;
import Interface.LevelInformation;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;

import java.util.ArrayList;
import java.util.List;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public class Ass6Game {
    /**
     * runs the game.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        for (String s : args) {
            if (s.equals("1")) {
                Level1 level1 = new Level1();
                levels.add(level1);
            }
            if (s.equals("2")) {
                Level2 level2 = new Level2();
                levels.add(level2);
            }
            if (s.equals("3")) {
                Level3 level3 = new Level3();
                levels.add(level3);
            }
            if (s.equals("4")) {
                Level4 level4 = new Level4();
                levels.add(level4);
            }
        }
        if (levels.size() == 0) {
            Level1 level1 = new Level1();
            levels.add(level1);
            Level2 level2 = new Level2();
            levels.add(level2);
            Level3 level3 = new Level3();
            levels.add(level3);
            Level4 level4 = new Level4();
            levels.add(level4);
        }
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(levels);
    }
}
