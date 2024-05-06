package Geometry;

import java.util.ArrayList;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */


public class Rectangle {

    private Point upperLeft;
    private double width, height;

    /**
     *  Create a new rectangle with location and width/height.
     * @param upperLeft
     * @param width
     * @param height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * constructor for upperleft point.
     * @param x
     * @param y
     */
    public void setUpperLeft(double x, double y) {
        Point upperLeft2 = new Point(x, y);
        this.upperLeft = upperLeft2;
    }

    /**
     * @return x co-ordinate of upperleft point.
     */
    public double getX() {
        return upperLeft.getX();
    }

    /**
     * @return x co-ordinate of upperleft point.
     */
    public double getY() {
        return upperLeft.getY();
    }

    /**
     * Return a (possibly empty) List of intersection points.
     * with the specified line.
     * @param line to check intersections with Retangle
     * @return lists of intersections, possibly null.
     */

    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] l1;
        l1 = this.rectangleLines();
        java.util.List<Point> list = new ArrayList<>(5);
        for (int i = 0; i < 4; i++) {
            if (line.isIntersecting(l1[i])) {
                list.add(line.intersectionWith(l1[i]));
            }
        }
        return list;
    }

    /**
     * @return the width the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * a rectangle is built out of 4 lines, and this function creates those lines.
     * @return the lines that make up each side of the rectangle.
     */
    public Line[] rectangleLines() {
        Line[] lines = new Line[4];
        Point upRight, downRight, downLeft;
        upRight = new Point(this.upperLeft.getX() + this.width, upperLeft.getY());
        downLeft = new Point(this.upperLeft.getX(), upperLeft.getY() + this.height);
        downRight = new Point(this.upperLeft.getX() + this.width, upperLeft.getY() + this.height);
        lines[0] = new Line(this.upperLeft, upRight);
        lines[1] = new Line(downLeft, downRight);
        lines[2] = new Line(upRight, downRight);
        lines[3] = new Line(this.upperLeft, downLeft);
        return lines;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

}