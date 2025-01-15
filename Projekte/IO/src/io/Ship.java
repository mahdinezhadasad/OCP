package IO.src.io;


enum Direction { NORTH, SOUTH, EAST, WEST }

public class Ship {
    public static void main(String[] compass) {
        System.out.print(Direction.valueOf(compass[0]));
    }
}