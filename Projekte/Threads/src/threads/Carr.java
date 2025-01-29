package Threads.src.threads;

interface Drive {
    int SPEED = 5;
    default int getSpeed(){
        return SPEED;
    }
}

interface Hover{
    
    int MAX_SPEED= 5;
    default int getSpeed(){return MAX_SPEED;}
}
enum Direction { NORTH, SOUTH, EAST, WEST; };
public class Carr implements Drive, Hover {
    
    public static void main(String[] compass) {
        if (compass.length == 0) {
            System.out.println("No input provided");
            return;
        }
        System.out.print(Direction.valueOf(compass[0].toUpperCase()));
    }
    
    @Override
    public int getSpeed() {
        return Drive.super.getSpeed ();
    }
}