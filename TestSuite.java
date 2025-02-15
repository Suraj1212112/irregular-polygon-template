import java.awt.geom.*;

public class TestSuite {
    public static void run() {
        System.out.println("Starting TestSuite");
        boolean pass = true;

        pass &= testPolygon("Single Point", new double[][] { { 0, 0 } }, 0, 0);
        pass &= testPolygon("Unit Square", new double[][] { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } }, 4, 1);
        pass &= testPolygon("Parallelogram", new double[][] { { 20, 10 }, { 70, 20 }, { 50, 50 }, { 0, 40 } }, 174.0914, 1700);
        pass &= testPolygon("Bowtie", new double[][] { { 0, 0 }, { 100, 50 }, { 100, 0 }, { 0, 50 } }, 323.6067, 0);

        if (pass) {
            System.out.println("--- TEST PASSED! Congrats! ---");
        } else {
            System.out.println("--- TEST FAILED! :( ---");
        }
    }

    private static boolean testPolygon(String name, double[][] points, double expectedPerimeter, double expectedArea) {
        IrregularPolygon poly = new IrregularPolygon();
        for (double[] point : points) {
            poly.add(new Point2D.Double(point[0], point[1]));
        }
        poly.draw();

        boolean perimeterPass = Math.abs(poly.perimeter() - expectedPerimeter) < 0.001;
        boolean areaPass = Math.abs(poly.area() - expectedArea) < 0.001;

        if (perimeterPass && areaPass) {
            System.out.println("PASS: " + name);
            return true;
        } else {
            System.out.println("FAIL: " + name);
            return false;
        }
    }
}
