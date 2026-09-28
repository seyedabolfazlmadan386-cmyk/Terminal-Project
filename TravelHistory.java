import java.util.ArrayList;

public class TravelHistory
{
    private ArrayList<Travel> history;

    public TravelHistory()
    {
        history = new ArrayList<>();
    }

    public void addTravel(Travel travel)
    {
        history.add(travel);
    }

    public ArrayList<Travel> getHistory()
    {
        return history;
    }
}