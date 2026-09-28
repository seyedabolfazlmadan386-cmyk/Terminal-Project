import java.util.ArrayList;

public class PassengerManager
{
    private ArrayList<Passenger> allPassengers;
    private ArrayList<Passenger> waitingPassengers;

    public PassengerManager()
    {
        allPassengers = new ArrayList<>();
        waitingPassengers = new ArrayList<>();
    }

    public ArrayList<Passenger> getWaitingPassengers()
    {
        return waitingPassengers;
    }
    public ArrayList<Passenger> getAllPassengers()
    {
        return allPassengers;
    }

    public void addPassenger()
    {
        Passenger passenger = Passenger.addPassenger();

        allPassengers.add(passenger);
        waitingPassengers.add(passenger);
    }
    public Passenger searchPassenger(String nationalCode)
    {
        for(Passenger passenger : allPassengers)
        {
            if(passenger.getNationalCode().equals(nationalCode))
                return passenger;
        }
        return null;
    }
    public void removeWaitingPassenger(Passenger passenger)
    {
        waitingPassengers.remove(passenger);
    }
}