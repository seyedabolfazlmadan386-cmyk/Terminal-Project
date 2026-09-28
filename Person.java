public abstract class Person
{
    private String nationalCode;
    private String name;

    public Person(String nationalCode, String name)
    {
        this.nationalCode = nationalCode;
        this.name = name;
    }
    public Person()
    {
        this("", "");
    }

    public String getNationalCode()
    {
        return nationalCode;
    }
    public void setNationalCode(String nationalCode)
    {
        this.nationalCode = nationalCode;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "nationalCode='" + nationalCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}