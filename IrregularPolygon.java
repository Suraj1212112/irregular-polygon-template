import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon;

    public IrregularPolygon() {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    public void add(Point2D.Double point) {
        myPolygon.add(point);
    }

    public double perimeter() {
        double total = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size());
            total += p1.distance(p2);
        }
        return total;
    }

    public double area() {
        double sum = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size());
            sum += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }
        return Math.abs(sum) / 2;
    }

    public void draw() {
        DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
        pen.up();
        pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        pen.down();

        for (Point2D.Double point : myPolygon) {
            pen.move(point.getX(), point.getY());
        }

        pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
    }
}
