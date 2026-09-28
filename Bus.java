public class Bus extends Vehicle
{
    private String destination;

    public Bus(String tag, String driverName, String destination)
    {
        super(tag, driverName, 40);
        this.destination = destination;
    }
    public Bus()
    {
        this("", "", "");
    }

    public String getDestination()
    {
        return destination;
    }
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    @Override
    public Fuel getFuelType()
    {
        return Fuel.Diesel;
    }

    @Override
    public String toString()
    {
        return "Bus -> " + super.toString() + " | Destination: " + destination + " | Fuel: " + getFuelType();
    }

    public static Bus addBus()
    {
        Bus b = new Bus();

        b.setTag(Utility.getCustomInput("Enter bus's tag: "));
        b.setDriverName(Utility.getCustomInput("Enter the name of the bus driver: "));
        b.setDestination(Utility.getCustomInput("Enter the bus destination: "));

        return b;
    }
}