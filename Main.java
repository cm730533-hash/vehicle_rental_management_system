import java.util.Scanner;

// ==========================================
// STEP 1: CREATE BASE VEHICLE CLASS
// ==========================================
class Vehicle {
    protected String vehicleNumber; 
    protected String brand;         
    protected double rentPerDay;    // This will now hold a unique rate per brand 

    // Parameterized constructor 
    public Vehicle(String vehicleNumber, String brand, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }

    // Base method for method overriding 
    public double calculateRent(int days) {
        return this.rentPerDay * days;
    }

    // Helper method to display complete details 
    public void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Brand/Model    : " + brand);
        System.out.println("Base Rate/Day  : " + rentPerDay);
    }
}

// ==========================================
// STEP 2 & 3: CREATE SUBCLASSES & OVERRIDE METHODS
// ==========================================

// Car subclass extending Vehicle 
class Car extends Vehicle {
    
    // Step 4: Constructor chaining using super() 
    public Car(String vehicleNumber, String brand, double rentPerDay) {
        super(vehicleNumber, brand, rentPerDay); // Receives the brand's specific rate 
    }

    // Step 3: Overriding calculateRent() for Car 
    @Override
    public double calculateRent(int days) {
        // Cars have a higher rent rate structure : Base rate + a flat 200 daily premium fee 
        double baseRent = super.calculateRent(days);
        double premiumFee = 200 * days; 
        return baseRent + premiumFee;
    }
}

// Bike subclass extending Vehicle 
class Bike extends Vehicle {

    // Step 4: Constructor chaining using super() 
    public Bike(String vehicleNumber, String brand, double rentPerDay) {
        super(vehicleNumber, brand, rentPerDay); // Receives the brand's specific rate
    }

    // Step 3: Overriding calculateRent() for Bike 
    @Override
    public double calculateRent(int days) {
        // Bikes have a lower rent rate structure : Base rate with a flat 10% discount applied 
        double standardRent = super.calculateRent(days);
        return standardRent * 0.90; 
    }
}

// ==========================================
// STEP 5, 6 & 7: MAIN METHOD FOR TESTING
// ==========================================
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle selectedVehicle = null; // Parent class reference for dynamic method dispatch 
        String chosenBrand = "";
        double variableBaseRate = 0.0;

        System.out.println("================================================");
        System.out.println("      VEHICLE RENTAL MANAGEMENT SYSTEM          ");
        System.out.println("================================================");
        
        // 1. Select Vehicle Type 
        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice (1 or 2): ");
        int typeChoice = scanner.nextInt();
        
        // 2. Branching based on selection to assign unique rates per brand 
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
            
            // Instantiating Car subclass into parent reference dynamically 
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
            
            // Instantiating Bike subclass into parent reference dynamically
            selectedVehicle = new Bike("MH-14-BKE-1234", chosenBrand, variableBaseRate);
            
        } else {
            System.out.println("Invalid Vehicle Choice! Exiting.");
            scanner.close();
            return;
        }

        // 3. Input Rental Duration 
        System.out.print("\nEnter number of days to rent: ");
        int days = scanner.nextInt();

        // Step 6 & 7: Display Final Details and Polymorphic calculation 
        System.out.println("\n------------------------------------------------");
        System.out.println("            FINAL RENTAL RECEIPT                ");
        System.out.println("------------------------------------------------");
        
        selectedVehicle.displayDetails(); // Displays custom brand and unique assigned base rate
        System.out.println("Rental Duration: " + days + " days");
        
        // Runtime Polymorphism: Executes child calculation using custom variable base rate 
        double totalRent = selectedVehicle.calculateRent(days); 
        System.out.println("Total Rent Due : " + totalRent); // Shows finalized pricing 
        System.out.println("================================================");

        scanner.close();
    }
}
