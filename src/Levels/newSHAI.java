package Levels;

import Game.Block;
import Game.GameLevel;
import Geometry.Velocity;
import Interface.Sprite;
import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class newSHAI implements Interface.LevelInformation {

    private Color[] color = new Color[]{Color.darkGray, Color.cyan,
            Color.orange, Color.GREEN, Color.MAGENTA};


    @Override
    public int numberOfBalls() {
        return 2;
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
                d.setColor(new Color(109, 59, 48));
                d.fillPolygon(new Polygon(new int[]{327, 322, 317, 317, 312, 305, 304, 295, 287, 279, 275, 276, 268, 255, 246, 229, 213, 215, 212, 200, 188, 179, 174, 175, 177, 162, 144, 136, 132, 142, 162, 173, 178, 177, 171, 163, 148, 146, 149, 153, 131, 112, 104, 110, 118, 135, 144, 141, 150, 167, 186, 190, 196, 205, 212, 219, 225, 211, 207, 212, 217, 228, 245, 262, 288, 304, 316, 325, 344, 360, 363, 355, 350, 351, 360, 373, 380, 389, 407, 407, 432, 447, 439, 439, 435, 445, 473, 486, 491, 490, 489, 498, 507, 512, 514, 514, 537, 553, 563, 574, 577, 580, 575, 579, 588, 596, 600, 601, 601, 613, 624, 637, 636, 659, 664, 667, 678, 680, 679, 670, 660, 653, 658, 662, 662, 655, 651, 657, 658, 649, 640, 629, 630, 638, 657, 657, 653, 638, 624, 605, 608, 607, 607, 590, 577, 561, 556, 546, 536, 520, 502, 493, 499, 495, 487, 482, 452, 424, 407, 388, 361, 329}, new int[]{489, 495, 498, 506, 510, 529, 546, 548, 545, 539, 548, 560, 561, 553, 561, 569, 571, 558, 552, 532, 521, 518, 497, 481, 469, 470, 461, 444, 426, 436, 439, 436, 415, 403, 401, 392, 377, 356, 338, 321, 321, 310, 295, 293, 299, 299, 284, 237, 212, 196, 186, 161, 140, 124, 115, 112, 83, 68, 47, 36, 48, 60, 62, 55, 55, 59, 64, 49, 30, 22, 26, 34, 47, 65, 78, 62, 56, 49, 39, 36, 30, 30, 40, 47, 55, 62, 62, 49, 34, 23, 15, 19, 31, 43, 53, 62, 66, 73, 81, 80, 65, 59, 43, 38, 52, 68, 81, 89, 132, 142, 152, 187, 195, 198, 191, 174, 187, 207, 222, 234, 242, 245, 255, 266, 288, 308, 322, 346, 371, 398, 414, 423, 448, 455, 453, 461, 470, 485, 493, 495, 504, 523, 536, 561, 571, 574, 562, 552, 552, 560, 556, 549, 533, 512, 502, 493, 511, 524, 528, 523, 511, 489}, 162));
                d.setColor(new Color(203, 32, 50));
                d.fillPolygon(new Polygon(new int[]{287, 270, 249, 232, 216, 208, 204, 205, 209, 216, 221, 230, 268, 313, 350, 397, 462, 527, 562, 578, 586, 591, 596, 601, 605, 603, 595, 586, 570, 550, 523, 531, 542, 548, 554, 553, 553, 546, 516, 477, 443, 418, 398, 364, 323, 291, 253, 249, 247, 254, 259, 268, 279, 285, 285}, new int[]{528, 506, 468, 427, 373, 321, 268, 212, 166, 125, 97, 61, 108, 171, 222, 299, 224, 157, 112, 68, 98, 124, 154, 203, 253, 306, 372, 410, 452, 489, 519, 489, 441, 396, 363, 291, 268, 243, 257, 278, 301, 325, 347, 310, 278, 258, 245, 267, 291, 363, 394, 440, 491, 511, 531}, 55));
                d.setColor(new Color(235, 190, 169));
                d.fillPolygon(new Polygon(new int[]{406, 375, 335, 306, 292, 263, 251, 249, 253, 270, 306, 334, 360, 398, 436, 470, 498, 529, 548, 553, 554, 553, 548, 521, 507, 476, 438, 406}, new int[]{528, 516, 497, 474, 460, 422, 340, 262, 246, 249, 266, 285, 308, 346, 309, 283, 266, 253, 245, 267, 312, 358, 410, 451, 468, 498, 519, 529}, 28));
                d.setColor(new Color(119, 71, 57));
                d.fillPolygon(new Polygon(new int[]{271, 289, 331, 347, 360, 373, 373, 361, 347, 320, 309, 295, 283, 270}, new int[]{330, 338, 338, 342, 347, 356, 363, 371, 373, 373, 367, 360, 350, 331}, 14));
                d.fillPolygon(new Polygon(new int[]{540, 523, 479, 465, 449, 438, 438, 451, 491, 503, 512, 527, 541}, new int[]{331, 337, 338, 342, 347, 355, 364, 372, 373, 367, 363, 351, 331}, 13));
                d.setColor(new Color(249, 250, 252));
                d.fillPolygon(new Polygon(new int[]{523, 510, 472, 452, 438, 451, 491, 511, 523},new int[]{342, 346, 347, 354, 363, 372, 372, 359, 342}, 9));
                d.fillPolygon(new Polygon(new int[]{287, 302, 337, 356, 371, 359, 327, 317, 297, 287},new int[]{340, 346, 347, 352, 363, 371, 373, 372, 358, 340}, 10));

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
