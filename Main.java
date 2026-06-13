import java.util.Scanner;


class Vehicle {
    protected String vehicleNumber; 
    protected String brand;         
    protected double rentPerDay;    

    
    public Vehicle(String vehicleNumber, String brand, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }

    
    public double calculateRent(int days) {
        return this.rentPerDay * days;
    }

     
    public void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Brand/Model    : " + brand);
        System.out.println("Base Rate/Day  : " + rentPerDay);
    }
}


class Car extends Vehicle {
    
     
    public Car(String vehicleNumber, String brand, double rentPerDay) {
        super(vehicleNumber, brand, rentPerDay);  
    }

     
    @Override
    public double calculateRent(int days) {
         
        double baseRent = super.calculateRent(days);
        double premiumFee = 200 * days; 
        return baseRent + premiumFee;
    }
}


class Bike extends Vehicle {

    
    public Bike(String vehicleNumber, String brand, double rentPerDay) {
        super(vehicleNumber, brand, rentPerDay); 
    }

    
    @Override
    public double calculateRent(int days) {
        
        double standardRent = super.calculateRent(days);
        return standardRent * 0.90; 
    }
}


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle selectedVehicle = null;  
        String chosenBrand = "";
        double variableBaseRate = 0.0;

        System.out.println("================================================");
        System.out.println("      VEHICLE RENTAL MANAGEMENT SYSTEM          ");
        System.out.println("================================================");
        
        
        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice (1 or 2): ");
        int typeChoice = scanner.nextInt();
        
    
        if (typeChoice == 1) {
            System.out.println("\nSelect a Car Brand (Each has a unique base rate):");
            System.out.println("1. Hyundai i20    - Economy (Base: 600/day)");
            System.out.println("2. Tata Nexon     - SUV     (Base: 900/day)");
            System.out.println("3. Honda Civic    - Luxury  (Base: 1200/day)");
            System.out.print("Enter choice (1-3): ");
            int brandChoice = scanner.nextInt();
            
            switch(brandChoice) {
                case 1: 
                    chosenBrand = "Hyundai i20"; 
                    variableBaseRate = 600.0; 
                    break;
                case 2: 
                    chosenBrand = "Tata Nexon"; 
                    variableBaseRate = 900.0; 
                    break;
                case 3: 
                    chosenBrand = "Honda Civic"; 
                    variableBaseRate = 1200.0; 
                    break;
                default: 
                    chosenBrand = "Standard Car"; 
                    variableBaseRate = 700.0;
            }
            
            
            selectedVehicle = new Car("MH-12-CAR-4567", chosenBrand, variableBaseRate);
            
        } else if (typeChoice == 2) {
            System.out.println("\nSelect a Bike Brand (Each has a unique base rate):");
            System.out.println("1. Yamaha R15                 - Sports   (Base: 300/day)");
            System.out.println("2. Royal Enfield Classic 350  - Cruiser  (Base: 450/day)");
            System.out.println("3. KTM Duke 390               - Racing   (Base: 600/day)");
            System.out.print("Enter choice (1-3): ");
            int brandChoice = scanner.nextInt();
            
            switch(brandChoice) {
                case 1: 
                    chosenBrand = "Yamaha R15"; 
                    variableBaseRate = 300.0; 
                    break;
                case 2: 
                    chosenBrand = "Royal Enfield Classic 350"; 
                    variableBaseRate = 450.0; 
                    break;
                case 3: 
                    chosenBrand = "KTM Duke 390"; 
                    variableBaseRate = 600.0; 
                    break;
                default: 
                    chosenBrand = "Standard Bike"; 
                    variableBaseRate = 350.0;
            }
            
            
            selectedVehicle = new Bike("MH-14-BKE-1234", chosenBrand, variableBaseRate);
            
        } else {
            System.out.println("Invalid Vehicle Choice! Exiting.");
            scanner.close();
            return;
        }

         
        System.out.print("\nEnter number of days to rent: ");
        int days = scanner.nextInt();

        
        System.out.println("\n------------------------------------------------");
        System.out.println("            FINAL RENTAL RECEIPT                ");
        System.out.println("------------------------------------------------");
        
        selectedVehicle.displayDetails(); 
        System.out.println("Rental Duration: " + days + " days");
        
        
        double totalRent = selectedVehicle.calculateRent(days); 
        System.out.println("Total Rent Due : " + totalRent); 
        
        System.out.println("================================================");

        scanner.close();
    }
}
