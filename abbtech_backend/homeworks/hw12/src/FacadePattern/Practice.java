package FacadePattern;

public class Practice {
    public static void main(String[] args) {

        Amplifier amp = new Amplifier();
        TV tv = new TV();
        Lights lights = new Lights();
        BluRayPlayer bluRayPlayer = new BluRayPlayer();
        HomeTheaterFacade myHomeTheaterFacade = new HomeTheaterFacade(tv,amp,lights,bluRayPlayer);
        myHomeTheaterFacade.watchMovie("Stranger Things");
        myHomeTheaterFacade.endMovie();

    }
}