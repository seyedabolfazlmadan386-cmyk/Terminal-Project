import java.util.LinkedList;
import java.util.Queue;

public class PassengerQueue
{
    private Queue<Passenger> passengers;

    public PassengerQueue()
    {
        passengers = new LinkedList<>();
    }

    public void addPassenger(Passenger passenger)
    {
        passengers.offer(passenger);
    }

    public void remove(Passenger passenger)
    {
        passengers.remove(passenger);
    }

    public Queue<Passenger> getPassengers()
    {
        return passengers;
    }
}