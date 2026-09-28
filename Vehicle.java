import java.util.ArrayList;

public abstract class Vehicle implements FuelType
{
    private String tag;
    private String driverName;
    private final int capacity;
    private final ArrayList<Passenger> passengers;

    public Vehicle(String tag, String driverName, int capacity)
    {
        this.tag = tag;
        this.driverName = driverName;
        this.capacity = capacity;
        passengers = new ArrayList<>();
    }

    public String getTag()
    {
        return tag;
    }
    public String getDriverName()
    {
        return driverName;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public int getCurrentPassengers()
    {
        return passengers.size();
    }
    public ArrayList<Passenger> getPassengers()
    {
        return passengers;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }
    public void setDriverName(String driverName)
    {
        this.driverName = driverName;
    }

    public void enterTerminal()
    {
        System.out.println("Vehicle " + tag + " entered terminal.");
    }

    public boolean isFull()
    {
        return passengers.size() >= capacity;
    }

    public void addPassenger(Passenger passenger)
    {
        if(!isFull())
        {
            passengers.add(passenger);
        }
    }

    public void exitTerminal()
    {
        System.out.println("Vehicle " + tag + " exited terminal.");
    }

    @Override
    public abstract Fuel getFuelType();

    @Override
    public String toString()
    {
        return "Tag: " + tag +
                " | Driver: " + driverName +
                " | Passengers: " + getCurrentPassengers() + "/" + capacity;
    }
}