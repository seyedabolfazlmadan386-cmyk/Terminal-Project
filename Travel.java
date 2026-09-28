import java.time.LocalDateTime;  public abstract class Travel
{
    private Vehicle vehicle;
    private Person person;
    private LocalDateTime dateTime;

    public Travel(Vehicle vehicle, Person person)
    {
        this.vehicle = vehicle;
        this.person = person;
        this.dateTime = LocalDateTime.now();
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }
    public LocalDateTime getDateTime()
    {
        return dateTime;
    }
    public Person getPerson()
    {
        return person;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }
    public void setPerson(Person person)
    {
        this.person = person;
    }

    public abstract String getType();

    @Override
    public String toString()
    {
        return getType() +
                " | Vehicle: " +
                (vehicle != null ? vehicle.getTag() : "-") +
                " | Person: " +
                (person != null ? person.getName() : "-") +
                " | Time: " +
                dateTime;
    }
}