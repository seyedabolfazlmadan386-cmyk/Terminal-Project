public class Entry extends Travel
{
    public Entry(Vehicle vehicle, Person person)
    {
        super(vehicle, person);
    }

    @Override
    public String getType()
    {
        return "Entry";
    }
}