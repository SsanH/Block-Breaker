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
 * The type Level 4.
 */
public class Level4 implements Interface.LevelInformation {
    private Color[] color = new Color[]{Color.RED, Color.darkGray, Color.cyan,
            Color.orange, Color.GREEN, Color.MAGENTA};


    @Override
    public int numberOfBalls() {
        return 150;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Geometry.Velocity.fromAngleAndSpeed(i * 10 + 5, 5);
            list.add(v);
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "MASSACRE";
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
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.white);
                d.fillCircle(400, 300, 300);
                d.setColor(Color.black);
                d.fillPolygon(new Polygon(new int[]{358, 357, 358, 358, 354, 354, 358, 357, 362, 361, 359, 357,
                        354, 352, 350, 347, 343, 341, 338, 338, 336, 334, 333, 331, 330, 330, 330, 327, 323,
                        320, 317, 316, 316, 316, 315, 309, 299, 298, 305, 319, 330, 338, 341, 343, 347, 350, 350, 347,
                        341, 333, 330, 337, 337, 340, 347, 357, 358, 355, 354, 354, 350, 345, 333, 324, 316, 305, 296,
                        291, 292, 296, 302, 310, 317, 327, 336, 341, 345, 347, 348, 350, 357, 361, 362, 366, 371, 378,
                        386, 393, 400, 406, 408, 406, 414, 420, 427, 431, 431, 429, 428, 432, 420, 420, 441, 456, 470,
                        480, 471, 453, 446, 428, 410, 415, 413, 415, 418, 414, 413, 417, 413, 415, 414, 358},
                        new int[]{607, 568, 540, 505, 504, 488, 484, 448, 441, 438, 435, 432, 431, 431,
                                429, 428, 428, 429, 432, 435, 438, 438, 436, 435, 432, 431, 428, 429, 429,
                                428, 425, 422, 421, 418, 418, 417, 411, 396, 378, 376, 376, 378, 382, 376,
                                372, 372, 368, 365, 364, 359, 354, 337, 320, 312, 306, 300, 299, 296, 293,
                                291, 292, 296, 298, 299, 302, 308, 316, 316, 312, 306, 302, 298, 293, 291,
                                291, 291, 289, 288, 284, 278, 275, 274, 270, 267, 263, 260, 260, 263, 266,
                                273, 281, 287, 292, 298, 305, 315, 327, 341, 352, 358, 366, 373, 364, 362,
                                371, 393, 408, 417, 425, 425, 439, 449, 455, 495, 499, 505, 546, 555, 562,
                                599, 607, 607}, 122));
                d.fillPolygon(new Polygon(new int[]{233, 236, 237, 244, 243, 282, 282, 292, 292, 355, 358,
                        358, 344, 338, 343, 288, 273, 267, 281, 250, 232},
                        new int[]{551, 551, 545, 545, 549, 545, 537, 538, 544, 533, 521, 545, 554, 552,
                                547, 558, 577, 575, 558, 562, 552}, 21));
                d.fillPolygon(new Polygon(new int[]{323, 399, 453, 453, 554, 552, 555, 567, 569, 592, 590,
                        595, 597, 603, 609, 607, 623, 597, 589, 572, 569, 534, 499, 425, 425, 456, 495, 457,
                        401, 331, 324, 323},
                        new int[]{568, 559, 552, 546, 538, 514, 511, 511, 532, 532, 511, 508, 504, 505, 510,
                                515, 531, 538, 539, 554, 550, 553, 575, 581, 578, 578, 559, 563, 574, 584,
                                580, 568}, 32));
                d.fillRectangle(390, 575, 150, 15);
                d.fillPolygon(new Polygon(new int[]{350, 320, 327, 357, 399, 387, 350},
                        new int[]{290, 251, 244, 284, 332, 343, 291}, 7));
                d.setColor(new Color(177, 0, 0));
                d.fillCircle(390, 150, 105);
                d.setColor(Color.black);
                d.fillPolygon(new Polygon(new int[]{411, 408, 404, 402, 399, 398, 396, 395, 394, 394, 396,
                        399, 402, 406, 411, 419, 425, 433, 442, 449, 455, 461, 465, 469, 471, 474, 476,
                        476, 478, 476, 475, 470, 467, 463, 462, 458, 455, 450, 445, 438, 436, 431, 425,
                        417, 414, 406, 403, 396, 393, 386, 381, 374, 365, 360, 353, 344, 335, 326, 316,
                        310, 302, 298, 294, 290, 292, 295, 301, 307, 314, 322, 330, 336, 343, 347, 351,
                        355, 356, 357, 360, 360, 360, 361, 364, 366, 369, 372, 378, 382, 390, 395, 403,
                        411, 412, 412},
                        new int[]{50, 57, 61, 66, 73, 78, 83, 88, 94, 97, 105, 111, 116, 121, 125, 130,
                                135, 141, 146, 151, 156, 164, 170, 176, 181, 187, 193, 200, 206, 213, 218, 222,
                                218, 212, 208, 201, 197, 192, 188, 185, 184, 180, 179, 180, 181, 183, 185, 189,
                                191, 193, 197, 200, 201, 205, 208, 209, 210, 209, 208, 204, 200, 197, 193, 188,
                                187, 187, 188, 188, 188, 187, 185, 183, 179, 174, 168, 164, 159, 151, 147,
                                130, 116, 105, 95, 87, 80, 73, 65, 58, 54, 50, 48, 48, 50, 53}, 94));
                d.setColor(new Color(177, 0, 0));
                d.fillCircle(390, 150, 21);
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
            for (int j = 0; j < 20; j++) {
                Block block = new Block(new Geometry.Point(30 + 37 * j, 150 + 25 * i), 37, 25, color[i % 6]);
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
