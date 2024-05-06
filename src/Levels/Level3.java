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
 * The type Level 3.
 */
public class Level3 implements Interface.LevelInformation {

    private Color[] color = new Color[]{Color.RED, Color.darkGray, Color.cyan,
            Color.orange, Color.GREEN, Color.MAGENTA};

    @Override
    public int numberOfBalls() {
        return 92;
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

    @Override
    public int paddleSpeed() {
        return 9;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "CANT DEFEAT BARMAN";
    }

    @Override
    public Sprite getBackground() {
        class BackGround implements Interface.Sprite {

            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(120, 120, 120));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(new Color(39, 39, 39));
                d.fillPolygon(new Polygon(new int[]{398, 399, 402, 406, 412, 420, 429, 441, 449, 458, 471, 484, 496,
                        514, 526, 538, 548, 556, 561, 568, 569, 572, 577, 578, 584, 593, 601, 614, 624, 635, 644, 654,
                        662, 673, 665, 652, 635, 616, 598, 575, 547, 527, 506, 492, 480, 468, 474, 480, 488, 495, 497,
                        493, 487, 479, 457, 436, 427, 425, 424, 424, 423, 419, 417, 411, 402, 394, 389, 383, 375, 373,
                        370, 368, 366, 366, 366, 366, 365, 357, 347, 336, 323, 310, 302, 296, 294, 297, 302, 309, 315,
                        322, 328, 318, 305, 288, 267, 248, 229, 214, 195, 179, 162, 150, 138, 119, 125, 134, 140, 149,
                        157, 166, 176, 187, 195, 201, 210, 213, 218, 223, 226, 227, 234, 242, 250, 260, 268, 277, 289,
                        297, 305, 315, 323, 332, 339, 345, 352, 358, 365, 370, 377, 385, 391, 392, 395, 398, 399},
                        new int[]{590, 588, 582, 573, 565, 557, 547, 537, 531, 527, 521, 518, 517, 520, 520, 522, 525,
                                529, 530, 534, 526, 516, 508, 497, 492, 485, 480, 476, 472, 471, 471, 470, 470, 471,
                                463, 459, 450, 444, 434, 427, 417, 415, 411, 409, 409, 408, 413, 416, 423, 430, 440,
                                450, 455, 459, 462, 461, 455, 441, 430, 421, 417, 421, 425, 429, 429, 429, 429, 428,
                                424, 421, 416, 424, 434, 441, 447, 453, 455, 461, 462, 462, 461, 458, 453, 445, 440,
                                432, 425, 419, 417, 413, 411, 408, 412, 411, 415, 420, 424, 430, 436, 442, 447, 454,
                                461, 468, 471, 471, 471, 471, 471, 472, 474, 476, 482, 487, 492, 497, 505, 517, 525,
                                531, 530, 526, 523, 521, 521, 521, 518, 518, 518, 521, 525, 527, 530, 533, 537, 540,
                                547, 550, 557, 565, 573, 577, 584, 589, 592}, 145));
                d.fillPolygon(new Polygon(new int[]{49, 742, 737, 726, 718, 695, 664, 622, 586, 562, 552, 548, 546,
                        541, 538, 535, 533, 531, 521, 510, 501, 491, 480, 471, 457, 448, 439, 428, 420, 409, 396,
                        383, 373, 362, 350, 338, 329, 319, 310, 302, 299, 292, 288, 282, 276, 270, 266, 262, 258,
                        257, 256, 253, 251, 250, 247, 247, 242, 238, 224, 205, 185, 159, 139, 120, 97, 83, 71,
                        61, 51},
                        new int[]{353, 355, 349, 344, 342, 340, 335, 326, 317, 308, 295, 111, 82, 55, 40, 39,
                                47, 56, 71, 84, 98, 92, 89, 85, 83, 81, 78, 78, 75, 75, 75, 77, 75, 77, 77,
                                81, 84, 86, 90, 92, 94, 98, 93, 86, 78, 72, 64, 56, 50, 44, 37, 44, 52, 65,
                                75, 86, 290, 301, 308, 317, 322, 328, 333, 337, 340, 340, 344, 349, 353},
                        69));
                d.setColor(Color.white);
                d.fillPolygon(new Polygon(new int[]{282, 352, 288, 282}, new int[]{193, 217, 211, 193}, 4));
                d.fillPolygon(new Polygon(new int[]{441, 510, 505, 441}, new int[]{217, 192, 209, 218}, 4));
                d.setColor(new Color(232, 202, 196));
                d.fillPolygon(new Polygon(new int[]{278, 396, 514, 492, 444, 347, 301, 278},
                        new int[]{241, 281, 241, 322, 339, 340, 323, 242}, 8));
            }

            @Override
            public void timePassed() {

            }
        }
        return new BackGround();
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 + i; j++) {
                Block block = new Block(new Geometry.Point(725 - j * 45, 220 - i * 20), 45, 20, color[i % 6]);
                list.add(block);
            }
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
