public class Passenger extends Person
{
    private String destination;
    private boolean isTraveled;

    public Passenger(String nationalCode, String name, String destination)
    {
        super(nationalCode, name);
        this.destination = destination;
        this.isTraveled = false;
    }
    public Passenger()
    {
        this("", "", "");
        this.isTraveled = false;
    }

    public String getDestination()
    {
        return destination;
    }
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    public boolean isTraveled()
    {
        return isTraveled;
    }

    public void setTraveled(boolean traveled)
    {
        isTraveled = traveled;
    }

    public static Passenger addPassenger()
    {
        Passenger p = new Passenger();

        p.setName(Utility.getCustomInput("Enter your name: "));
        p.setNationalCode(Utility.getCustomInput("Enter your national Code: "));
        p.setDestination(Utility.getCustomInput("Enter your destination: "));

        return p;
    }
    public static Passenger addPassenger(String destination)
    {
        Passenger p = new Passenger();

        p.setName(Utility.getCustomInput("Enter your name: "));
        p.setNationalCode(Utility.getCustomInput("Enter your national Code: "));
        p.setDestination(destination);

        return p;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "\nDestination: " + destination +
                "\nTraveled: " + isTraveled;
    }
}