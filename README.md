# Vehicle Rental Management System

A Java-based console application that demonstrates **Object-Oriented Programming (OOP)** concepts including inheritance, method overriding, and runtime polymorphism.

## Overview

This system allows users to rent different vehicle types (Cars and Bikes) from various brands, each with unique pricing structures and rental calculations.

## Features

- **Vehicle Selection**: Choose between Cars or Bikes
- **Brand Options**: Multiple brands per vehicle type with different base rates
- **Dynamic Pricing**: 
  - **Cars**: Base rate + ₹200/day premium fee
  - **Bikes**: Base rate with 10% discount
- **Rental Duration**: Flexible rental period calculation
- **Receipt Generation**: Detailed rental receipt with final pricing

## OOP Concepts Demonstrated

### 1. **Inheritance**
- `Vehicle` (Base Class) → `Car`, `Bike` (Subclasses)
- Subclasses inherit properties and methods from the parent class

### 2. **Method Overriding**
- `calculateRent()` method overridden in `Car` and `Bike` classes
- Each subclass implements custom pricing logic

### 3. **Constructor Chaining**
- Subclass constructors use `super()` to call parent constructor
- Passes vehicle details to the parent class

### 4. **Polymorphism**
- Parent class reference (`Vehicle selectedVehicle`) holds child class objects
- Runtime method dispatch determines which `calculateRent()` method executes
- Same method call produces different results based on object type

### 5. **Encapsulation**
- Protected attributes restrict access within class hierarchy
- Private implementation details hidden from users

## Vehicle Pricing

### Cars
| Brand | Type | Base Rate | With Premium |
|-------|------|-----------|--------------|
| Hyundai i20 | Economy | ₹600/day | ₹800/day |
| Tata Nexon | SUV | ₹900/day | ₹1100/day |
| Honda Civic | Luxury | ₹1200/day | ₹1400/day |

### Bikes
| Brand | Type | Base Rate | With Discount |
|-------|------|-----------|---------------|
| Yamaha R15 | Sports | ₹300/day | ₹270/day |
| Royal Enfield Classic 350 | Cruiser | ₹450/day | ₹405/day |
| KTM Duke 390 | Racing | ₹600/day | ₹540/day |

## How to Use

### Prerequisites
- Java Development Kit (JDK) installed
- Command line or terminal access

### Compilation
```bash
javac Main.java
```

### Execution
```bash
java Main
```

### User Interaction
1. Select vehicle type (Car or Bike)
2. Choose a brand from the available options
3. Enter the number of days for rental
4. View the final rental receipt with total cost

## Project Structure

```
Vehicle Rental Management System/
├── Main.java          # Main application file
├── Vehicle.java       # Base class (included in Main.java)
├── Car.java           # Car subclass (included in Main.java)
├── Bike.java          # Bike subclass (included in Main.java)
└── README.md          # This file
```

## Code Architecture

### Class: Vehicle
- **Attributes**: vehicleNumber, brand, rentPerDay
- **Methods**: 
  - `calculateRent(int days)`: Calculates rental cost
  - `displayDetails()`: Shows vehicle information

### Class: Car (extends Vehicle)
- **Override**: `calculateRent()` adds ₹200/day premium

### Class: Bike (extends Vehicle)
- **Override**: `calculateRent()` applies 10% discount

### Class: Main
- **main()**: Entry point with user interaction logic

## Sample Interaction

```
================================================
      VEHICLE RENTAL MANAGEMENT SYSTEM          
================================================

Select Vehicle Type:
1. Car
2. Bike
Enter choice (1 or 2): 1

Select a Car Brand (Each has a unique base rate):
1. Hyundai i20    - Economy (Base: 600/day)
2. Tata Nexon     - SUV     (Base: 900/day)
3. Honda Civic    - Luxury  (Base: 1200/day)
Enter choice (1-3): 2

Enter number of days to rent: 5

------------------------------------------------
            FINAL RENTAL RECEIPT                
------------------------------------------------
Vehicle Number : MH-12-CAR-4567
Brand/Model    : Tata Nexon
Base Rate/Day  : 900.0
Rental Duration: 5 days
Total Rent Due : 6500.0
================================================
```

## Key Learning Points

This project demonstrates:
- How to structure class hierarchies
- Effective use of method overriding for customized behavior
- Runtime polymorphism through parent class references
- User input handling with Scanner
- Control flow with switch statements and conditionals

## Future Enhancements

- Add more vehicle types (Trucks, SUVs)
- Implement customer database with booking history
- Add discounts for long-term rentals
- Include damage assessment and additional charges
- File-based persistent storage

## Author
Created as a semester 2 Java project demonstrating OOP principles.

## License
Educational use.
