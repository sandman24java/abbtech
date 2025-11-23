package BusSystemSimulation;

import java.util.*;

public class Stops {
     static List<Passenger> stop1 = new LinkedList<>(List.of(
            new Passenger("Murad", true),
            new Passenger("Nadir", false),
            new Passenger("Fidan", false),
            new Passenger("Cavid", true),
             new Passenger("Leman", false)

    ));
    static List<Passenger> stop2 = new LinkedList<>(List.of(
            new Passenger("Elvin", false)

    ));
    static List<Passenger> stop3 = new LinkedList<>(List.of(
            new Passenger("Ramil", false),
            new Passenger("Kamilla", false)
    ));

    public static List<Passenger> getPassengers_of_stop1() {
        stop1.sort(new Comparator<Passenger>() {
            public int compare(Passenger chosen, Passenger next) {
                return Boolean.compare(next.getIsPriority(), chosen.getIsPriority());
            }
        });
        return stop1;
    }
    public static List<Passenger> getPassengers_of_stop2() {
        return stop2;
    }
    public static List<Passenger> getPassengers_of_stop3() {
        return stop3;
    }
    public static void display_passengers_on_stop(List<Passenger> passengers) {
        System.out.println("Remaining passengers on stop:" + passengers.toString());
    }






}
