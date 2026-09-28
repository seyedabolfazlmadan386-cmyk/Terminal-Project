public class Driver extends Person implements Workable
{
    public Driver(String nationalCode, String name)
    {
        super(nationalCode, name);
    }

    @Override
    public void work()
    {
        System.out.println("Driver " + this.getName() + "is driving.");
    }
}