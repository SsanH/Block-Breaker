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
 * The type Level 2.
 */
public class Level2 implements Interface.LevelInformation {

    private Color[] color = new Color[]{Color.darkGray, Color.cyan,
            Color.orange, Color.GREEN, Color.MAGENTA};

    /**
     * @return number of balls in the game.
     */
    public int numberOfBalls() {
        return 4;
    }

    /**
     * @return list of the ball's velocity.
     */

    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Geometry.Velocity.fromAngleAndSpeed(10 * i + 5, 5);
            list.add(v);
        }
        return list;
    }

    /**
     * @return int paddle speed.
     */

    public int paddleSpeed() {
        return 8;
    }

    /**
     * @return int paddle width.
     */

    public int paddleWidth() {
        return 500;
    }

    /**
     * @return string with the name level.
     */
    public String levelName() {
        return "BECOME LEGENDARY";
    }

    /**
     * @return the background.
     */
    public Sprite getBackground() {
        class BackGround implements Interface.Sprite {
            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(165, 21, 35));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(new Color(14, 30, 45));
                d.drawText(200, 110, "BECOME LEGENDARY", 40);
                d.fillPolygon(new Polygon(new int[]{266, 259, 251, 245, 236, 229, 226, 222, 220, 221, 222, 225,
                        233, 239, 254, 267, 279, 293, 304, 318, 331, 347, 360, 539, 537, 368, 347, 338, 329,
                        318, 306, 295, 283, 272, 264, 258, 255, 255, 257, 259, 262, 264},
                        new int[]{412, 418, 424, 431, 440, 448, 454, 462, 469, 477, 483, 490, 496, 498, 500,
                                499, 499, 495, 492, 487, 483, 479, 474, 412, 412, 448, 452, 454, 456, 459,
                                459, 462, 462, 461, 457, 450, 444, 436, 428, 421, 415, 411}, 42));
                d.fillPolygon(new Polygon(new int[]{373, 410, 459, 502, 552, 566, 569, 561, 535,
                        495, 445, 406, 358, 308, 276, 230, 209, 201, 196, 217, 254, 323, 358, 375},
                        new int[]{119, 128, 155, 191, 194, 206, 193, 237, 254, 246, 212, 191, 189,
                                228, 249, 254, 252, 223, 195, 193, 202, 139, 126, 120}, 24));
                d.fillCircle(382, 288, 80);
                d.setColor(Color.white);
                d.fillPolygon(new Polygon(new int[]{386, 386, 389, 388, 390, 392, 389, 389, 388, 388, 390, 393,
                        397, 399, 403, 403, 405, 403, 403, 401, 397, 396, 397, 397, 397, 397, 396, 393, 392, 393,
                        392, 396, 394, 397, 396, 399, 401, 403, 405, 407, 409, 413, 414, 417, 417, 419, 420, 423, 423,
                        426, 427, 430, 430, 434, 434, 435, 436, 438, 438, 439, 441, 443, 445, 447, 445, 443, 439, 438,
                        432, 430, 428, 424, 423, 422, 420, 419, 418, 415, 415, 413, 411, 409, 407, 407, 403, 401, 398,
                        396, 394, 392, 388, 384, 382, 377, 375, 371, 368, 365, 361, 358, 358, 351, 350, 344, 343, 339,
                        337, 333, 327, 326, 325, 325, 326, 331, 334, 334, 335, 337, 337, 339, 340, 342, 342, 344, 346,
                        348, 352, 352, 355, 355, 360, 360, 364, 365, 368, 369, 371, 372, 375, 376, 376, 372, 372, 368,
                        368, 364, 363, 360, 363, 360, 360, 359, 356, 354, 351, 350, 348, 348, 350, 352, 358, 358, 360,
                        360, 363, 363, 364, 364, 368, 367, 369, 369, 372, 372, 375, 373, 372, 371, 371, 371, 372, 372,
                        375, 379, 381, 382},
                        new int[]{254, 246, 246, 239, 238, 229, 228, 225, 221, 219, 215, 213, 213, 216, 217, 221, 224,
                                226, 228, 230, 230, 230, 234, 238, 241, 246, 250, 255, 258, 264, 274, 274, 292, 293,
                                300, 300, 301, 301, 302, 302, 304, 305, 306, 306, 309, 310, 313, 313, 316, 316, 320,
                                320, 322, 323, 326, 327, 323, 323, 326, 326, 326, 326, 325, 330, 331, 335, 338, 339,
                                340, 339, 335, 334, 331, 331, 330, 329, 326, 327, 325, 325, 322, 325, 320, 321, 317,
                                318, 316, 317, 313, 314, 310, 310, 312, 313, 317, 316, 320, 321, 325, 323, 327, 330,
                                334, 335, 338, 340, 342, 343, 343, 340, 338, 334, 333, 334, 334, 333, 327, 327, 330,
                                329, 326, 325, 323, 318, 320, 317, 317, 314, 314, 310, 310, 308, 308, 305, 305, 301,
                                301, 297, 295, 288, 281, 280, 284, 285, 288, 288, 292, 295, 297, 299, 301, 302, 302,
                                302, 304, 302, 300, 297, 295, 293, 289, 285, 285, 284, 283, 280, 280, 278, 276, 274,
                                272, 270, 268, 267, 266, 264, 263, 260, 258, 255, 253, 251, 250, 250, 251, 251},
                        186));
                d.setColor(new Color(14, 30, 45));
                d.fillPolygon(new Polygon(new int[]{285, 312, 343, 375, 398, 427, 455, 472,
                        487, 460, 448, 434, 415, 392, 369, 354, 335, 322, 312, 309, 285},
                        new int[]{251, 228, 205, 195, 195, 207, 228, 244, 253, 254, 239, 222,
                                206, 199, 199, 206, 216, 231, 247, 254, 252}, 21));
                d.fillPolygon(new Polygon(new int[]{462, 549, 548, 464, 461}, new int[]{263, 263, 272, 271, 262}, 5));
                d.fillPolygon(new Polygon(new int[]{566, 692, 692, 676, 662, 649, 629, 624, 630, 633, 633, 617,
                        588, 571, 565, 566}, new int[]{262, 263, 272, 283, 289, 295, 293, 291, 285, 278, 272, 274,
                        272, 272, 272, 260}, 16));
                d.fillPolygon(new Polygon(new int[]{465, 626, 620, 613, 603, 588, 570, 561, 569, 571, 571, 557,
                        510, 472, 464, 465}, new int[]{275, 276, 292, 296, 302, 302, 301, 302, 295, 287, 280,
                        281, 280, 280, 281, 276}, 16));
                d.fillPolygon(new Polygon(new int[]{465, 465, 537, 548, 556, 563, 565, 465}, new int[]{287, 308,
                        310, 305, 301, 292, 287, 285}, 8));
                d.fillPolygon(new Polygon(new int[]{616, 640, 632, 619, 580, 586, 604, 619}, new int[]{297, 300,
                        313, 321, 321, 308, 309, 297}, 8));
                d.fillPolygon(new Polygon(new int[]{549, 582, 573, 561, 516, 525, 540, 550},
                        new int[]{308, 308, 321, 331, 331, 314, 313, 308}, 8));
                d.fillPolygon(new Polygon(new int[]{461, 519, 514, 504, 493, 452, 462}, new int[]{316, 316, 327,
                        334, 338, 339, 316}, 7));
                d.fillPolygon(new Polygon(new int[]{544, 557, 566, 570, 598, 591, 583, 574, 537, 542},
                        new int[]{338, 338, 334, 329, 329, 338, 344, 351, 351, 338}, 10));
                d.fillPolygon(new Polygon(new int[]{507, 537, 532, 525, 516, 507, 474, 479, 482, 495, 507},
                        new int[]{337, 338, 347, 354, 359, 361, 361, 354, 344, 343, 338}, 11));
                d.fillPolygon(new Polygon(new int[]{448, 476, 473, 468, 461, 456, 448, 430, 441, 448},
                        new int[]{344, 344, 354, 359, 361, 365, 367, 365, 356, 344}, 10));
                d.fillPolygon(new Polygon(new int[]{525, 552, 545, 536, 531, 495, 498, 512, 525},
                        new int[]{360, 359, 368, 375, 377, 377, 367, 367, 360}, 9));
                d.fillPolygon(new Polygon(new int[]{464, 494, 489, 482, 469, 431, 436, 438, 455, 457, 465},
                        new int[]{367, 367, 376, 381, 385, 385, 380, 372, 373, 369, 367}, 11));
                d.fillPolygon(new Polygon(new int[]{483, 512, 508, 500, 493, 455, 460, 473, 483},
                        new int[]{386, 386, 396, 398, 402, 402, 390, 392, 385}, 9));
                d.fillPolygon(new Polygon(new int[]{423, 453, 449, 443, 438, 428, 389, 397, 414, 423},
                        new int[]{390, 392, 398, 405, 410, 413, 413, 396, 396, 390}, 10));
                d.fillPolygon(new Polygon(new int[]{431, 417, 410, 405, 365, 360, 352, 339, 343, 350, 358, 405, 415,
                        424, 428, 431}, new int[]{373, 372, 376, 381, 380, 377, 373, 373, 382, 385, 390, 393, 390,
                        386, 381, 372}, 16));
                d.fillPolygon(new Polygon(new int[]{392, 388, 380, 392},
                        new int[]{397, 409, 396, 397}, 4));
                d.fillPolygon(new Polygon(new int[]{372, 360, 354, 350, 317, 323, 329, 337, 346, 379, 376, 372},
                        new int[]{396, 397, 394, 393, 393, 399, 405, 410, 413, 413, 405, 396}, 12));
                d.fillPolygon(new Polygon(new int[]{339, 334, 326, 318, 312, 309, 278, 280, 283, 289, 297, 305, 339,
                        337}, new int[]{385, 373, 373, 371, 368, 365, 367, 371, 375, 380, 384, 386, 386, 373},
                        14));
                d.fillPolygon(new Polygon(new int[]{296, 320, 323, 329, 339, 330, 318, 308, 300, 296},
                        new int[]{346, 344, 351, 358, 364, 367, 365, 361, 355, 348}, 10));
                d.fillPolygon(new Polygon(new int[]{276, 271, 263, 253, 247, 246, 219, 224, 229, 234, 255, 274, 271},
                        new int[]{376, 367, 368, 364, 361, 359, 359, 361, 369, 375, 377, 379, 367}, 13));
                d.fillCircle(557, 267, 6);
                d.fillPolygon(new Polygon(new int[]{297, 291, 289, 281, 274, 268, 267, 233, 237, 239, 246, 253, 260,
                        296}, new int[]{359, 354, 343, 343, 342, 338, 337, 338, 342, 350, 352, 356, 361, 360},
                        14));
                d.fillPolygon(new Polygon(new int[]{253, 306, 310, 316, 284, 274, 266, 259, 253},
                        new int[]{316, 317, 327, 337, 338, 334, 330, 325, 314}, 9));
                d.fillPolygon(new Polygon(new int[]{255, 249, 246, 230, 224, 217, 192, 195, 200, 205, 215, 221, 255},
                        new int[]{330, 323, 316, 317, 313, 308, 308, 314, 320, 323, 330, 331, 330}, 13));
                d.fillPolygon(new Polygon(new int[]{192, 188, 186, 170, 162, 156, 133, 137, 142, 149, 158, 191},
                        new int[]{320, 317, 308, 308, 306, 301, 301, 309, 314, 320, 322, 320}, 12));
                d.fillPolygon(new Polygon(new int[]{204, 304, 302, 304, 305, 229, 224, 216, 211, 205},
                        new int[]{285, 285, 295, 304, 309, 309, 304, 302, 296, 284}, 10));
                d.fillPolygon(new Polygon(new int[]{175, 201, 211, 219, 228, 233, 200, 192, 184, 174},
                        new int[]{330, 330, 333, 338, 337, 348, 351, 347, 340, 329}, 10));
                d.fillPolygon(new Polygon(new int[]{304, 142, 145, 152, 156, 165, 171, 208, 205, 201, 200, 200,
                        302, 304}, new int[]{275, 275, 284, 288, 291, 297, 301, 302, 297, 291, 284, 280, 281, 274},
                        14));
                d.fillPolygon(new Polygon(new int[]{205, 80, 80, 85, 91, 99, 107, 146, 142, 140, 137, 136, 205, 205},
                        new int[]{263, 262, 271, 278, 284, 289, 292, 293, 288, 281, 274, 268, 270, 262}, 14));
                d.fillPolygon(new Polygon(new int[]{221, 306, 305, 224, 220},
                        new int[]{264, 263, 272, 272, 263}, 5));
                d.fillCircle(213, 267, 6);
                d.setColor(new Color(226, 226, 226));
                d.fillPolygon(new Polygon(new int[]{217, 238, 246, 259, 249, 246, 234, 228, 216},
                        new int[]{254, 205, 207, 255, 257, 238, 237, 255, 254}, 9));
                d.fillPolygon(new Polygon(new int[]{254, 263, 284, 276, 254},
                        new int[]{204, 200, 246, 251, 204}, 5));
                d.fillPolygon(new Polygon(new int[]{300, 274, 281, 292, 301, 308, 306, 304, 327, 322, 297,
                        293, 297, 299, 295, 287, 283, 285, 288, 293, 297, 300, 304, 308, 300},
                        new int[]{233, 195, 184, 179, 180, 186, 194, 203, 209, 219, 211, 205, 198, 191,
                                187, 191, 194, 200, 205, 209, 215, 219, 222, 228, 234}, 25));
                d.fillPolygon(new Polygon(new int[]{323, 340, 340, 348, 350, 334, 323},
                        new int[]{148, 188, 207, 200, 186, 144, 152}, 7));
                d.fillPolygon(new Polygon(new int[]{351, 360, 372, 382, 390, 396, 396, 394, 389, 379, 368, 358,
                        351, 350, 347, 350},
                        new int[]{145, 137, 136, 136, 144, 152, 162, 173, 180, 187, 187, 186, 178, 167, 157,
                                146}, 16));
                d.fillPolygon(new Polygon(new int[]{410, 392, 403, 405, 418, 424, 427, 426, 422, 417, 411, 413, 415,
                        417, 418, 427, 428, 424, 419, 430, 436, 438, 435, 428, 418, 409, 390},
                        new int[]{140, 183, 191, 184, 149, 150, 157, 163, 166, 166, 166, 173, 180, 186, 196,
                                203, 199, 183, 171, 171, 169, 161, 150, 142, 140, 140, 183}, 27));
                d.fillPolygon(new Polygon(new int[]{456, 428, 435, 443, 453, 466, 476, 479, 481, 476, 470, 464,
                        456, 428}, new int[]{162, 200, 209, 216, 220, 220, 215, 203, 186, 179, 173, 165,
                        161, 201}, 14));
                d.fillPolygon(new Polygon(new int[]{460, 494, 502, 495, 483, 490, 481, 469, 457},
                        new int[]{228, 196, 199, 253, 247, 229, 222, 234, 228}, 9));
                d.fillPolygon(new Polygon(new int[]{511, 508, 520, 541, 541, 548, 548, 544, 518, 520, 511},
                        new int[]{254, 204, 203, 234, 201, 203, 251, 253, 216, 253, 254}, 11));
                d.setColor(new Color(20, 30, 40));
                d.fillPolygon(new Polygon(new int[]{485, 493, 493, 487}, new int[]{219, 208, 222, 219}, 4));
                d.fillPolygon(new Polygon(new int[]{284, 287, 292, 297, 299, 297, 293, 289, 281},
                        new int[]{195, 190, 186, 188, 192, 199, 204, 204, 196}, 9));
                d.fillPolygon(new Polygon(new int[]{411, 418, 423, 427, 428, 424, 417, 410, 418},
                        new int[]{162, 146, 150, 156, 162, 166, 167, 165, 146}, 9));
                d.fillPolygon(new Polygon(new int[]{356, 358, 359, 363, 369, 377, 384, 385, 386, 386, 386, 385, 384,
                        379, 377, 373, 371, 367, 364, 361, 359, 359, 358},
                        new int[]{162, 156, 150, 144, 142, 142, 148, 153, 161, 165, 169, 171, 174, 178, 178,
                                179, 179, 178, 177, 174, 170, 167, 163}, 23));
                d.fillPolygon(new Polygon(new int[]{440, 459, 461, 469, 470, 472, 472, 472, 470, 469,
                        465, 461, 456, 452, 447, 444, 440},
                        new int[]{204, 175, 174, 180, 184, 188, 191, 195, 200, 203, 207, 209, 211,
                                211, 209, 208, 205}, 17));
                d.fillPolygon(new Polygon(new int[]{234, 239, 245, 237},
                        new int[]{232, 220, 230, 230}, 4));
            }

            @Override
            public void timePassed() {
            }
        }
        return new BackGround();
    }

    /**
     * @return list of the blocks in the game.
     */

    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Block block = new Block(new Geometry.Point(30 + 74 * i, 200), 74, 25, this.color[i % 5]);
            list.add(block);
        }
        return list;
    }

    /**
     * @return the amount of blocks in the game.
     */

    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
