public class Menu
{
    private TerminalManager manager;
    private PassengerManager passengerManager;
    private TravelHistory history;

    public Menu()
    {
        passengerManager = new PassengerManager();
        history = new TravelHistory();

        manager = new TerminalManager(passengerManager, history);
    }

    public void showMenu()
    {
        int choice;

        do
        {
            System.out.println("\n========== TERMINAL MANAGEMENT ==========");
            System.out.println("1. Add Passenger");
            System.out.println("2. Add Bus");
            System.out.println("3. Add Taxi");
            System.out.println("4. Add Van");
            System.out.println("5. Add Passenger To Bus");
            System.out.println("6. Add Passenger To Taxi");
            System.out.println("7. Add Passenger To Van");
            System.out.println("8. Show All Vehicles");
            System.out.println("9. Show single Vehicles");
            System.out.println("10. Show Vehicles In Terminal");
            System.out.println("11. Show Passengers");
            System.out.println("12. Show Travel History");
            System.out.println("13. Show Passengers By Destination");
            System.out.println("14. Show Travels Of Passenger");
            System.out.println("15. Show Travels Of Vehicle");
            System.out.println("16. Show all travels");
            System.out.println("17. Show Buses");
            System.out.println("18. Show Taxis");
            System.out.println("19. Show Vans");
            System.out.println("20. Show travels");
            System.out.println("0. Exit");

            choice = Integer.valueOf(Utility.scanner.nextLine());
            processOption(choice);
        } while (choice != 0);
    }

    private void processOption(int choice)
    {
        switch (choice)
        {
            case 1:
                manager.addPassenger();
                break;
            case 2:
                manager.addBus();
                break;
            case 3:
                manager.addTaxi();
                break;
            case 4:
                manager.addVan();
                break;
            case 5:
                manager.addPassengerToBus(Utility.getCustomInput("National Code: "));
                break;
            case 6:
                manager.addPassengerToTaxi(Utility.getCustomInput("National Code: "));
                break;
            case 7:
                manager.addPassengerToVan(Utility.getCustomInput("National Code: "));
                break;
            case 8:
                manager.showAllVehicles();
                break;
            case 9:
                manager.showSingleVehicle(Utility.getCustomInput("Enter vehicle's tag: "));
                break;
            case 10:
                manager.showTerminalVehicles();
                break;
            case 11:
                manager.showPassengers();
                break;
            case 12:
                manager.showTravels();
                break;
            case 13:
                manager.showPassengersByDestination(Utility.getCustomInput("Destination: "));
                break;
            case 14:
                manager.showTravelsByPassenger(Utility.getCustomInput("National Code: "));
                break;
            case 15:
                manager.showTravelsByVehicle(Utility.getCustomInput("Vehicle Tag: "));
                break;
            case 16:
                manager.showTravels();
                break;
            case 17:
                manager.showBus(Utility.getCustomInput("Destination: "));
                break;
            case 18:
                manager.showTaxi();
                break;
            case 19:
                manager.showVan();
                break;
            case 20:
                manager.showTravels();
                break;
            case 0:
                System.out.println("Good Bye...");
                return;
            default:
                System.out.println("Invalid Choice!");
        }
    }
}