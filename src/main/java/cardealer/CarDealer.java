package cardealer;

import java.io.*;
import java.util.*;

public class CarDealer {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<Car> cars = new ArrayList<>();
        Car newCar = new Car("ABC123", "Fiat", "Punto", 2014, 250000, 6200.0F);
        cars.add(newCar);
        cars.add( new Car("DEF456", "Volkswagen", "Golf", 2020, 150000, 9000.0F) );

        new FileOutputStream("cars.txt", true).close();
        int menuOption = 0;
        System.out.println("Willkommen im Autohaus, bitte waehlen Sie aus den folgenden Optionen (Druecken Sie 0 fuer das Menue)");
        displayMenu();
        do {
            System.out.println("\n\nWas wuerden Sie gerne tun? (0 fuer das Hauptmenue)");
            menuOption = sc.nextInt();
            while(menuOption <0 || menuOption >6)
            {
                System.out.println("Bitte geben Sie einen korrekten Menuepunkt ein. (0, um das Menue zu sehen)");
                menuOption = sc.nextInt();
            }
            doMenuOption(menuOption,cars);

        } while(menuOption != 6);

        FileOutputStream fos = new FileOutputStream("cars.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Car car : cars) {
            oos.writeObject(car);
        }
        fos.close();
    }

    public static void displayMenu() {
        System.out.println("Was moechten Sie gerne tun?");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Zeigt alle vorhandenen Fahrzeugdatensaetze in der Datenbank an (in beliebiger Reihenfolge).");
        System.out.println("2. Fuegen Sie der Datenbank einen neuen Fahrzeugdatensatz hinzu.");
        System.out.println("3. Loeschen eines Fahrzeugdatensatzes aus einer Datenbank.");
        System.out.println("4. Suche nach einem Auto (anhand seiner Chassisnummer).");
        System.out.println("5. Zeigen Sie eine Liste von Fahrzeugen innerhalb einer bestimmten Preisspanne an.");
        System.out.println("6. Programm beenden.\n\n");
    }

    public static void displayCars(ArrayList<Car> cars) {
        String formatter = "| %-2d | %-6s       | %-15s | %-15s | %-5d | %-8d | CHF %.2f   |%n";
        System.out.format("+----+--------------+-----------------+-----------------+-------+----------+---------------+%n");
        System.out.printf("| #  | ChassisNr    | Marke           | Modell          | Jahr  | Km       | Preis         |%n");
        System.out.format("+----+--------------+-----------------+-----------------+-------+----------+---------------+%n");
        int i = 0;
        for (Car car : cars) {
            System.out.format(formatter,++i,car.getChassisNr(),car.getBrand(),car.getModel(),car.getYear(),car.getKm(),car.getPrice());
        }
        System.out.format("+----+--------------+-----------------+-----------------+-------+----------+---------------+%n");
    }

    public static void displayCars(Car car) {
        String formatter = "| %-2d | %-6s       | %-15s | %-15s | %-5d | %-8d | CHF %.2f   |%n";
        System.out.format("+----+--------------+-----------------+-----------------+-------+----------+--------------+%n");
        System.out.printf("| #  | ChassisNr    | Marke           | Modell          | Jahr  | Km       | Preis        |%n");
        System.out.format("+----+--------------+-----------------+-----------------+-------+----------+--------------+%n");
        System.out.format(formatter,1,car.getChassisNr(),car.getBrand(),car.getModel(),car.getYear(),car.getKm(),car.getPrice());
        System.out.format("+----+--------------+-----------------+-----------------+-------+----------+--------------+%n");
    }

    public static void doMenuOption(int action, ArrayList<Car> cars) throws Exception {
        String newCar, ChassisNr, brand, model;
        Car foundCar = null;
        int carNumber = 0, year = 0, km = 0;
        float priceMin = 0.00F, priceMax = 0.00F, price = 0.00F;
        boolean validInput = true;
        switch (action) {
            case 0:
                System.out.println("Hauptmenue");
                displayMenu();
                break;
            case 1:
                System.out.println("Liste der Autos");
                displayCars(cars);
                break;
            case 2:
                System.out.println("Neues Fahrzeug zur Datenbank hinzufügen.");
                addNewCar(cars);
                break;
            case 3:
                System.out.println("Loeschen eines Fahrzeugs aus einer Datenbank.");
                deleteCar(cars);
                break;
            case 4:
                System.out.println("Suche nach einem cardealer.Car.");
                searchCar(cars);
                break;
            case 5:
                System.out.println("Liste der Fahrzeuge in einer bestimmten Preisklasse.");
                listCarByPriceRange(cars);
                break;
            case 6:
                break;
            default:
                break;
        }
    }

    public static void addNewCar(ArrayList<Car> cars) {

        boolean validInput;
        String ChassisNr, brand, model;
        int km = 0, year = 0;
        float price = 0.0F;

        System.out.println("Geben Sie ein neues Auto in folgendem Format ein:");
        System.out.println("CHASSIS_NR BRAND MODEL YEAR KM PRICE");
        System.out.println("z.B.: ABC789 Fiat Panda 2014 7300 8000");
        do {
            validInput = true;
            ChassisNr = sc.next();
            brand = sc.next();
            model = sc.next();
            if(sc.hasNextInt())
                year = sc.nextInt();
            else validInput = false;
            if(sc.hasNextInt())
                km = sc.nextInt();
            else validInput = false;
            if(sc.hasNextFloat())
                price = sc.nextFloat();
            else validInput = false;
            if(!validInput)
            {
                System.out.println("\nFalsches Format.");
                System.out.println("Geben Sie ein neues Auto in folgendem Format ein:");
                System.out.println("CHASSIS_NR BRAND MODEL YEAR KM PRICE");
                System.out.println("z.B.: ABC789 Fiat Panda 2014 7300 8000\n");
            }
        } while(!validInput);
        cars.add(new Car(ChassisNr,brand,model,year,km,price));
    }

    public static void deleteCar(ArrayList<Car> cars)
    {
        int carNumber;

        if(cars.size()>0) {
            System.out.println("Bitte waehlen Sie die Nummer des Fahrzeugs, das Sie loeschen moechten");
            displayCars(cars);
            do {
                System.out.print("Auto loeschen #: ");
                while(!sc.hasNextInt())
                {
                    System.out.println("Das ist keine gueltige Eingabe");
                    sc.next();
                }
                carNumber = sc.nextInt();

            } while (carNumber < 1 || carNumber > cars.size());
            cars.remove(carNumber-1);
        } else System.out.println("Es sind keine Autos zu entfernen.");
    }

    public static void searchCar(ArrayList<Car> cars)
    {
        String ChassisNr;
        Car foundCar = null;

        do {
            System.out.print("ChassisNr des Fahrzeugs eingeben (5 alphanumerische Zeichen): ");
            ChassisNr = sc.next();
        }while(!ChassisNr.matches("^[a-zA-Z0-9]{3,15}$"));

        for (Car car : cars) {
            if(car.getChassisNr().equals(ChassisNr))
            {
                foundCar = car;
            }
        }
        if(foundCar != null)
            displayCars(foundCar);
        else
            System.out.println("Keine Autos gefunden.");
    }

    public static void listCarByPriceRange(ArrayList<Car> cars)
    {
        float priceMin = 0, priceMax = 0;
        do {
            if(priceMin > priceMax) System.out.println("Der Mindestpreis ist groesser als der Hoechstpreis.");
            System.out.print("Mindestbetrag eingeben: CHF ");
            while(!sc.hasNextFloat())
            {
                System.out.print("Ungueltige Eingabe! Mindestbetrag eingeben: CHF ");
                sc.next();
            }
            priceMin = sc.nextFloat();

            System.out.print("Hoechstbetrag eingeben: CHF ");
            while(!sc.hasNextFloat())
            {
                System.out.print("Ungueltige Eingabe! Hoechstbetrag eingeben: CHF ");
                sc.next();
            }
            priceMax = sc.nextFloat();
            System.out.println(priceMin+" "+priceMax);
        } while ( priceMin > priceMax );
    }
}