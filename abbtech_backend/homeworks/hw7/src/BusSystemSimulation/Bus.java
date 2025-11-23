package BusSystemSimulation;

import java.util.*;

public class Bus {
    private final int MAX_OCCUPANCY = 5;
    private List<Passenger> passengers_list = new LinkedList<>();

    public void getBusList() {
        System.out.println("Final passengers list:" +  passengers_list.toString());
    }


    public void add_passengers(List<Passenger> entered_list) {
        Iterator<Passenger> it = entered_list.iterator();
        while (it.hasNext() && passengers_list.size() < MAX_OCCUPANCY) {
            Passenger p = it.next();
            passengers_list.add(p);
            it.remove();
            System.out.println(p.getName() + " boarded the bus.");
        }
        System.out.println(passengers_list.toString());
    }
        public void remove_passengers () {
            System.out.println(passengers_list.toString());
            Random rand = new Random();
            int maxRemovals = Math.min(3, passengers_list.size());
            int remove_limit = rand.nextInt(maxRemovals);
            if (remove_limit == 0 || passengers_list.isEmpty()) {
                System.out.println("There are no passengers leaving the bus.");
            } else {
                List<Passenger> removed_passengers = new LinkedList<>();
                for (int i = 0; i < remove_limit; i++) {
                    int index = rand.nextInt(passengers_list.size());
                    Passenger removed_passenger = passengers_list.remove(index);
                    removed_passengers.add(removed_passenger);
                }
                removed_passengers.sort(new Comparator<Passenger>() {
                    public int compare(Passenger chosen, Passenger next) {
                        return Boolean.compare(next.getIsPriority(), chosen.getIsPriority());
                    }
                });
                for (Passenger p : removed_passengers) {
                    System.out.println(p.getName() + " left the bus.");
                }
            };
        }

        public void move_to_next_stop () {
            try {
                Thread.sleep(1000);
                System.out.println("Moving to next stop");
                Thread.sleep(2000);
                System.out.println("Arrived to next stop");
            } catch (InterruptedException e) {
            }
        }
        }
