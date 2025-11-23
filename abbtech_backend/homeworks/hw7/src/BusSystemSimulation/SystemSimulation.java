package BusSystemSimulation;

import java.util.*;

public class SystemSimulation {
    public static void main(String[] args)  {
        Bus bus = new Bus();
        bus.add_passengers(Stops.getPassengers_of_stop1());
        Stops.display_passengers_on_stop(Stops.getPassengers_of_stop1());
        bus.move_to_next_stop();


        bus.remove_passengers();
        bus.add_passengers(Stops.getPassengers_of_stop2());
        Stops.display_passengers_on_stop(Stops.getPassengers_of_stop2());
        bus.move_to_next_stop();


        bus.remove_passengers();
        bus.add_passengers(Stops.getPassengers_of_stop3());
        Stops.display_passengers_on_stop(Stops.getPassengers_of_stop3());
        bus.getBusList();

    }
}
