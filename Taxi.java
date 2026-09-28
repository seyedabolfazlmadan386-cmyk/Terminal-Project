public class Taxi extends Vehicle
{
    public Taxi(String tag, String driverName)
    {
        super(tag, driverName, 4);
    }
    public Taxi()
    {
        this("", "");
    }

    @Override
    public Fuel getFuelType()
    {
           return Fuel.Gasoline;
    }

    @Override
    public String toString()
    {
        return "Taxi -> " + super.toString() + " | Fuel: " + getFuelType();
    }

    public static Taxi addTaxi()
    {
        Taxi t = new Taxi();

        t.setTag(Utility.getCustomInput("Enter taxi's tag: "));
        t.setDriverName(Utility.getCustomInput("Enter the name of the taxi driver: "));

        return t;
    }
}