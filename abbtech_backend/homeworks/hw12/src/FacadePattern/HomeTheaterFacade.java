package FacadePattern;

public class HomeTheaterFacade {
    private TV tv;
    private Amplifier amp;
    private BluRayPlayer bluRayPlayer;
    private Lights lights;


    public HomeTheaterFacade(TV tv, Amplifier amp, Lights lights, BluRayPlayer bluRayPlayer) {
        this.tv = tv;
        this.amp = amp;
        this.bluRayPlayer = bluRayPlayer;
        this.lights = lights;
    }


    public void watchMovie(String movieName){
        System.out.println("Preparing to watch a movie...");

        lights.brightness(20);
        tv.turn_on();
        amp.on();
        amp.setVolume(15);
        bluRayPlayer.on();
        bluRayPlayer.play(movieName);
    }
    public void endMovie(){
        System.out.println("Shutting movie theater down...");

        lights.on();
        bluRayPlayer.off();
        amp.off();
        tv.turn_off();

    }

}
