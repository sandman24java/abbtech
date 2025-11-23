package FacadePattern;

public class BluRayPlayer {
    public void on() {
        System.out.println("BluRayPlayer on");
    }
    public void play(String movie) {
        System.out.println("BluRayPlayer plays movie " + movie);
    }
    public void off() {
        System.out.println("BluRayPlayer off");
    }
}
