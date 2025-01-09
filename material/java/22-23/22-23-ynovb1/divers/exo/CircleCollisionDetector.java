package exo;

public class CircleCollisionDetector {
    public static void main(String[] args) {
        CircleCollisionDetector circleCollisionDetector = new CircleCollisionDetector();
        circleCollisionDetector.isColliding(0, 0, 10, 10, 0, 10);
    }

    boolean isColliding(int xa, int ya, int ra, int xb, int yb, int rb) {
        return Math.pow(xb - xa, 2) + Math.pow(yb - ya, 2) < Math.pow(rb + ra, 2);
    }
}
