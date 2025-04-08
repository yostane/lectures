///usr/bin/env jbang "$0" "$@" ; exit $?

public class CircleCollisionDetector {
  public static void main(String[] args) {
    CircleCollisionDetector circleCollisionDetector = new CircleCollisionDetector();
    circleCollisionDetector.isColliding(0, 0, 10, 10, 0, 10);
  }

  /**
   * La distance entre les deux cercles est plus petite que la somme des rayons
   * 
   * @param xa
   * @param ya
   * @param ra
   * @param xb
   * @param yb
   * @param rb
   * @return
   */
  boolean isColliding(int xa, int ya, int ra, int xb, int yb, int rb) {
    return Math.pow(xb - xa, 2) + Math.pow(yb - ya, 2) < Math.pow(rb + ra, 2);
  }
}
