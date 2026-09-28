import java.util.ArrayList;

public class TerminalManager
{
    private ArrayList<Vehicle> terminalVehicles;
    private ArrayList<Vehicle> allVehicles;
    private PassengerManager passengerManager;
    private TravelHistory travelHistory;
    private final String[] names;

    public TerminalManager(PassengerManager passengerManager, TravelHistory travelHistory)
    {
        this.passengerManager = passengerManager;
        this.travelHistory = travelHistory;

        terminalVehicles = new ArrayList<>();
        allVehicles = new ArrayList<>();

        names = new String[]{"Mohammad Ahmadi", "Ali Rezaei", "Hossein Karimi", "Amir Hosseini", "Mehdi Ebrahimi",
        "Reza Moradi", "Ahmad Salehi", "Hassan Rahimi", "Sajjad Nazari", "Farhad Jafari",
        "Sina Behzadi", "Arman Khalili", "Kian Pourali", "Nima Shamsi", "Behnam Ghasemi",
        "Omid Bahrami", "Parsa Mousavi", "Alireza Kazemi", "Morteza Fallahi", "Pouya Rahmati"};

        createVehicles();
    }

    private void createVehicles()
    {
        for(int i = 0; i < 5; i++)
        {
            Bus bus = new Bus("B" + (i + 1), names[i], "Tehran");

            allVehicles.add(bus);
            terminalVehicles.add(bus);
        }
        for(int i = 5; i < 10; i++)
        {
            Bus bus = new Bus("B" + (i + 1), names[i], "Shiraz");

            allVehicles.add(bus);
            terminalVehicles.add(bus);
        }
        for(int i = 0; i < 5; i++)
        {
            Taxi taxi = new Taxi("T" + (i + 1), names[i + 10]);

            allVehicles.add(taxi);
            terminalVehicles.add(taxi);
        }
        for(int i = 0; i < 5; i++)
        {
            Van van = new Van("V" + (i + 1), names[i + 15]);

            allVehicles.add(van);
            terminalVehicles.add(van);
        }
    }

    public void addVehicle(Vehicle vehicle)
    {
        allVehicles.add(vehicle);
        terminalVehicles.add(vehicle);
    }
    public void travelHistory(Travel travel)
    {
        travelHistory.addTravel(travel);
    }
    public void addPassenger()
    {
        passengerManager.addPassenger();
    }
    public Passenger searchPassenger(String nationalCode)
    {
        return passengerManager.searchPassenger(nationalCode);
    }
    public Vehicle searchVehicle(String tag)
    {
        for(Vehicle vehicle : allVehicles)
        {
            if(vehicle.getTag().equals(tag))
                return vehicle;
        }

        return null;
    }
    public void showPassengersByDestination(String destination)
    {
        boolean found = false;

        for(Passenger passenger : passengerManager.getAllPassengers())
        {
            if(passenger.getDestination().equalsIgnoreCase(destination))
            {
                System.out.println(passenger.toString());
                found = true;
            }
        }

        if(!found)
            System.out.println("No passenger found for destination " + destination);
    }

    public void showAllVehicles()
    {
        for(Vehicle vehicle : allVehicles)
        {
            System.out.println(vehicle.toString());
        }
    }
    public void showSingleVehicle(String tag)
    {
        Vehicle vehicle = searchVehicle(tag);

        if(vehicle == null)
        {
            System.out.println("Vehicle not found.");
            return;
        }
        System.out.println(vehicle);
    }
    public void showTerminalVehicles()
    {
        for(Vehicle vehicle : terminalVehicles)
        {
            System.out.println(vehicle.toString());
        }
    }
    public void showPassengers()
    {
        for(Passenger passenger : passengerManager.getAllPassengers())
        {
            System.out.println(passenger.toString());
        }
    }
    public void showHistory()
    {
        for(Travel travel : travelHistory.getHistory())
        {
            System.out.println(travel);
        }
    }

    public void addPassengerToVan(String nationalCode)
    {
        Passenger passenger = searchPassenger(nationalCode);

        if(passenger == null)
        {
            System.out.println("Passenger noy found");
            return;
        }



















        Passenger passenger = searchPassenger(nationalCode);

        if(passenger == null)
        {
            System.out.println("Passenger not found.");
            return;
        }

        for (int i = 0; i < terminalVehicles.size(); i++)
        {
            Vehicle vehicle = terminalVehicles.get(i);

            if(vehicle instanceof Van && !vehicle.isFull())
            {
                vehicle.addPassenger(passenger);
                passenger.setTraveled(true);
                passengerManager.removeWaitingPassenger(passenger);

                if(vehicle.isFull())
                {
                    vehicle.exitTerminal();
                    terminalVehicles.remove(i);
                    for(Passenger p : vehicle.getPassengers())
                    {
                        travelHistory(new Exit(vehicle, p));
                    }
                }
                return;
            }
        }
        System.out.println("No available van.");
    }
    public void addPassengerToTaxi(String nationalCode)
    {
        Passenger passenger = searchPassenger(nationalCode);

        if(passenger == null)
        {
            System.out.println("Passenger not found.");
            return;
        }

        for(int i = 0; i < terminalVehicles.size(); i++)
        {
            Vehicle vehicle = terminalVehicles.get(i);

            if(vehicle instanceof Taxi && !vehicle.isFull())
            {
                vehicle.addPassenger(passenger);

                passenger.setTraveled(true);
                passengerManager.removeWaitingPassenger(passenger);

                if(vehicle.isFull())
                {
                    vehicle.exitTerminal();

                    for(Passenger p : vehicle.getPassengers())
                    {
                        travelHistory(new Exit(vehicle, p));
                    }

                    terminalVehicles.remove(i);
                }
                return;
            }
        }

        System.out.println("No available taxi.");
    }
    public void addPassengerToBus(String nationalCode)
    {
        Passenger passenger = searchPassenger(nationalCode);

        if(passenger == null)
        {
            System.out.println("Passenger not found.");
            return;
        }

        for(int i = 0; i < terminalVehicles.size(); i++)
        {
            Vehicle vehicle = terminalVehicles.get(i);

            if(vehicle instanceof Bus && !vehicle.isFull())
            {
                vehicle.addPassenger(passenger);

                passenger.setTraveled(true);
                passengerManager.removeWaitingPassenger(passenger);

                if(vehicle.isFull())
                {
                    vehicle.exitTerminal();

                    for(Passenger p : vehicle.getPassengers())
                    {
                        travelHistory(new Exit(vehicle, p));
                    }

                    terminalVehicles.remove(i);
                }
                return;
            }
        }

        System.out.println("No available bus.");
    }

    public void addBus()
    {
        Bus bus = Bus.addBus();

        addVehicle(bus);
        bus.enterTerminal();
        travelHistory(new Entry(bus, null));
    }
    public void addVan()
    {
        Van van = Van.addVan();

        addVehicle(van);

        van.enterTerminal();
        travelHistory(new Entry(van, null));
    }
    public void addTaxi()
    {
        Taxi taxi = Taxi.addTaxi();

        addVehicle(taxi);

        taxi.enterTerminal();
        travelHistory(new Entry(taxi, null));
    }

    public void showBus(String destination)
    {
        for(Vehicle vehicle : terminalVehicles)
        {
            if(vehicle instanceof Bus && ((Bus) vehicle).getDestination().equals(destination))
            {
                System.out.println(vehicle);
            }
        }
    }
    public void showVan()
    {
        for(Vehicle vehicle : terminalVehicles)
        {
            if(vehicle instanceof Van)
            {
                System.out.println(vehicle);
            }
        }
    }
    public void showTaxi()
    {
        for(Vehicle vehicle : terminalVehicles)
        {
            if(vehicle instanceof Taxi)
            {
                System.out.println(vehicle);
            }
        }
    }

    public void showTravels()
    {
        for(Travel travel : travelHistory.getHistory())
            System.out.println(travel.toString());
    }
    public void showTravelsByPassenger(String nationalCode)
    {
        Passenger passenger = searchPassenger(nationalCode);

        if(passenger == null)
        {
            System.out.println("Passenger not found.");
            return;
        }

        System.out.println("Passenger: " + passenger.getName());

        boolean found = false;

        for(Travel travel : travelHistory.getHistory())
        {
            if(travel.getPerson() != null && travel.getPerson().equals(passenger))
            {
                System.out.println(travel);
                found = true;
            }
        }
        if(!found)
            System.out.println("No travels found for this passenger.");
    }
    public void showTravelsByVehicle(String tag)
    {
        Vehicle vehicle = searchVehicle(tag);

        if(vehicle == null)
        {
            System.out.println("Vehicle not found");
            return;
        }

        System.out.println("Vehicle: " + vehicle.getTag());

        boolean found = false;

        for(Travel travel : travelHistory.getHistory())
        {
            if(travel.getVehicle().equals(vehicle))
            {
                System.out.println(travel);
                found = true;
            }
        }
        if(!found)
            System.out.println("No travels found for this vehicle.");
    }

    public ArrayList<Vehicle> getTerminalVehicles()
    {
        return terminalVehicles;
    }
    public ArrayList<Vehicle> getAllVehicles()
    {
        return allVehicles;
    }
    public PassengerManager getPassengerManager()
    {
        return passengerManager;
    }

    public TravelHistory getTravelHistory()
    {
        return travelHistory;
    }
}