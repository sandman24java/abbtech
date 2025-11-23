package BusSystemSimulation;

public class Passenger  {
    String name;
    Boolean isPriority;
    public Passenger(String name,boolean isPriority) {
        this.name = name;
        this.isPriority = isPriority;
    }
    @Override
    public String toString(){
        return this.getName() ;
    }
    public String getName(){
        if (isPriority) {
            return name + " (Priority)";
        }
        else{
            return name;
        }

    }
    public Boolean getIsPriority(){
        return isPriority;
    }



}
