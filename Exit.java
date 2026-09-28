public class Exit extends Travel
{
    public Exit(Vehicle vehicle, Person person)
    {
        super(vehicle, person);
    }

    @Override
    public String getType()
    {
        return "Exit";
    }
}