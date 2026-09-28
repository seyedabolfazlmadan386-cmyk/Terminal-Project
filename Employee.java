public class Employee extends Person implements Workable
{
    private int workingHour;

    public Employee(String nationalCode, String name)
    {
        super(nationalCode, name);
        this.workingHour = 8;
    }

    @Override
    public void work()
    {
        System.out.println("Employee " + this.getName() + "is working at terminal.");
    }
}