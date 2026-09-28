public class Van extends Vehicle
{
    public Van(String tag, String driverName)
    {
        super(tag, driverName, 8);
    }

    public Van()
    {
        this("", "");
    }

    @Override
    public Fuel getFuelType()
    {
        return Fuel.CNG;
    }

    @Override
    public String toString()
    {
        return "Van -> " + super.toString() + " | Fuel: " + getFuelType();
    }

    public static Van addVan()
    {
        Van v = new Van();

        v.setTag(Utility.getCustomInput("Enter van's tag: "));
        v.setDriverName(Utility.getCustomInput("Enter the name of the van driver: "));

        return v;
    }
}