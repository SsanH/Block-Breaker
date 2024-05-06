package Levels;

import Game.Block;
import Game.GameLevel;
import Geometry.Velocity;
import Interface.Sprite;
import biuoop.DrawSurface;

import java.awt.Polygon;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Level 1.
 */
public class Level1 implements Interface.LevelInformation {
    /**
     * @return int number of balls in the game.
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * @return the list of velocities initializes for the amount of balls.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Geometry.Velocity.fromAngleAndSpeed(10 * i + 15, 5);
            list.add(v);
        }
        return list;
    }

    /**
     * @return int paddle speed.
     */
    public int paddleSpeed() {
        return 7;
    }

    /**
     * @return int paddle width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * @return string Levelname.
     */
    public String levelName() {
        return "JUST HIT IT";
    }

    /**
     * @return initializes and returns the background of the game.
     */
    public Sprite getBackground() {
        class BackGround implements Interface.Sprite {

            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.white);

                d.fillPolygon(new Polygon(new int[]{292, 284, 276, 269, 259, 251, 248, 244, 242, 243, 244, 247, 256,
                        262, 279, 293, 306, 322, 334, 349, 364, 381, 396, 592, 590, 404, 381, 371, 361, 349, 336,
                        324, 311, 299, 290, 283, 280, 280, 282, 284, 288, 290},
                        new int[]{360, 366, 373, 381, 391, 399, 406, 415, 422, 431, 438, 446, 452, 454, 457, 455,
                                455, 451, 448, 442, 438, 433, 428, 360, 360, 399, 404, 406, 408, 411, 411, 415, 415,
                                414, 409, 402, 395, 386, 377, 370, 363, 359}, 42));
                d.setColor(new Color(220, 20, 60));
                d.drawText(250, 350, "JUST HIT IT", 60);
                d.setColor(new Color(160, 0, 0));
                d.drawLine(435, 168, 475, 168);
                d.drawLine(435, 169, 475, 169);
                d.drawLine(435, 170, 475, 170);
                d.drawLine(435, 171, 475, 171);
                d.drawLine(375, 168, 335, 168);
                d.drawLine(375, 169, 335, 169);
                d.drawLine(375, 170, 335, 170);
                d.drawLine(375, 171, 335, 171);
                d.drawLine(403, 200, 403, 240);
                d.drawLine(404, 200, 404, 240);
                d.drawLine(405, 200, 405, 240);
                d.drawLine(406, 200, 406, 240);
                d.drawLine(403, 140, 403, 100);
                d.drawLine(404, 140, 404, 100);
                d.drawLine(405, 140, 405, 100);
                d.drawLine(406, 140, 406, 100);
                d.drawLine(435, 168, 455, 178);
                d.drawLine(435, 169, 455, 179);
                d.drawLine(435, 170, 455, 180);
                d.drawLine(435, 171, 455, 181);
                d.drawLine(435, 168, 455, 158);
                d.drawLine(435, 169, 455, 159);
                d.drawLine(435, 170, 455, 160);
                d.drawLine(435, 171, 455, 161);
                d.drawLine(375, 168, 355, 178);
                d.drawLine(375, 169, 355, 179);
                d.drawLine(375, 170, 355, 180);
                d.drawLine(375, 171, 355, 181);
                d.drawLine(375, 168, 355, 158);
                d.drawLine(375, 169, 355, 159);
                d.drawLine(375, 170, 355, 160);
                d.drawLine(375, 171, 355, 161);
                d.drawLine(403, 198, 413, 218);
                d.drawLine(404, 199, 414, 219);
                d.drawLine(405, 200, 415, 220);
                d.drawLine(406, 201, 416, 221);
                d.drawLine(407, 201, 417, 221);
                d.drawLine(393, 218, 403, 198);
                d.drawLine(393, 218, 404, 198);
                d.drawLine(394, 219, 404, 199);
                d.drawLine(394, 219, 405, 199);
                d.drawLine(395, 220, 405, 200);
                d.drawLine(395, 220, 406, 200);
                d.drawLine(393, 218, 404, 198);
                d.drawLine(403, 139, 393, 119);
                d.drawLine(404, 139, 394, 119);
                d.drawLine(405, 140, 395, 120);
                d.drawLine(406, 141, 396, 121);
                d.drawLine(403, 139, 413, 119);
                d.drawLine(403, 139, 414, 119);
                d.drawLine(404, 139, 414, 119);
                d.drawLine(404, 139, 415, 119);
                d.drawLine(405, 140, 415, 120);
                d.drawLine(405, 140, 416, 120);
                d.drawLine(406, 141, 416, 121);
            }

            @Override
            public void timePassed() {

            }
        }
        return new BackGround();
    }

    /**
     * @return list of blocks in the level.
     */
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block = new Block(new Geometry.Point(385, 150), 40, 40, new Color(220, 20, 60));
        list.add(block);
        return list;
    }

    /**
     * @return number of blocks in the level.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
