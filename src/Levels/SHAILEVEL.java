package Levels;

import Game.Block;
import Game.GameLevel;
import Geometry.Velocity;
import Interface.Sprite;
import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SHAILEVEL implements Interface.LevelInformation {

    private Color[] color = new Color[]{Color.darkGray, Color.cyan,
            Color.orange, Color.GREEN, Color.MAGENTA};


    @Override
    public int numberOfBalls() {
        return 5;
    }

    @Override
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

    @Override
    public String levelName() {
        return "SHAI LEVEL";
    }

    @Override
    public Sprite getBackground() {
        Sprite backGround = new Sprite() {
            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.white);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.black);
                d.fillPolygon(new Polygon(new int[]{260, 258, 256, 256, 257, 262, 274, 284, 286, 285, 282, 276, 285, 298, 313, 327, 335, 342, 345, 352, 358, 370, 382, 397, 410, 425, 441, 430, 416, 408, 402, 399, 399, 409, 423, 432, 446, 459, 476, 464, 456, 453, 448, 449, 456, 464, 476, 488, 501, 514, 508, 503, 501, 501, 510, 517, 522, 524, 524, 522, 516, 524, 536, 547, 556, 561, 561, 555, 538, 526, 510, 488, 463, 444, 429, 418, 412, 416, 422, 429, 440, 449, 437, 428, 416, 406, 393, 396, 400, 409, 420, 430, 415, 402, 391, 382, 374, 368, 361, 351, 340, 329, 313, 322, 331, 339, 348, 336, 326, 307, 289, 273, 258, 274, 292, 277, 266, 253, 242, 235, 247, 257, 249, 243, 235, 230, 229, 230, 230, 235, 239, 246, 252, 260},
                        new int[]{363, 350, 335, 322, 309, 289, 270, 260, 270, 281, 295, 305, 303, 288, 272, 250, 231, 212, 186, 217, 234, 256, 273, 287, 301, 311, 318, 304, 282, 265, 249, 231, 217, 238, 262, 278, 293, 302, 312, 296, 281, 266, 254, 243, 259, 272, 288, 300, 306, 311, 290, 279, 267, 260, 272, 287, 302, 320, 337, 350, 363, 356, 342, 318, 293, 256, 217, 193, 160, 143, 130, 115, 106, 100, 98, 99, 99, 93, 86, 81, 75, 69, 71, 75, 80, 85, 95, 91, 84, 79, 75, 70, 71, 75, 79, 85, 91, 98, 90, 81, 75, 70, 64, 72, 79, 88, 102, 107, 111, 108, 108, 111, 118, 119, 120, 130, 139, 150, 163, 182, 171, 165, 178, 192, 215, 235, 254, 270, 291, 311, 328, 342, 352, 363}, 134));
                d.setColor(new Color(244, 183, 56));
                d.fillPolygon(new Polygon(new int[]{348, 345, 340, 354, 343, 331, 313, 322, 330, 337, 324, 334, 342, 348},
                        new int[]{247, 263, 272, 277, 285, 294, 314, 296, 286, 280, 277, 267, 256, 247}, 14));
                d.setColor(Color.black);
                d.fillPolygon(new Polygon(new int[]{374, 381, 387, 396, 400, 404, 401, 397, 391, 384, 378, 374, 371},
                        new int[]{364, 361, 359, 360, 363, 365, 373, 370, 367, 368, 371, 373, 364}, 13));

                d.fillCircle(461,380,60);
                d.fillCircle(316,380,60);
                d.setColor(Color.white);
                d.fillCircle(461,380,51);
                d.fillCircle(316,380,51);
            }

            @Override
            public void timePassed() {

            }
        };

        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Block block = new Block(new Geometry.Point(30 + 74 * i, 200), 74, 25, this.color[i % 5]);
            list.add(block);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
