# Assignment 5 — Strategy Pattern

## Project Overview

This project demonstrates the **Strategy Design Pattern** using a simple Calculator system.

The goal of the project is to replace conditional logic with interchangeable algorithms that implement a common interface.

The calculator can perform different mathematical operations by switching strategies at runtime.

## Strategy Pattern

The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each algorithm in a separate class, and makes them interchangeable.

In this project, the calculator does not contain `if` or `switch` statements to decide which mathematical operation should be used.

Instead, each operation is implemented as a separate strategy.

## Project Structure

- `OperationStrategy` — Strategy interface
- `AddStrategy` — Concrete Strategy for addition
- `SubtractStrategy` — Concrete Strategy for subtraction
- `MultiplyStrategy` — Concrete Strategy for multiplication
- `Calculator` — Context
- `Main` — Client

## How It Works

The `OperationStrategy` interface declares one common method:

```java
double execute(double a, double b);
```

Each Concrete Strategy implements this method differently.

### Addition Strategy

```java
public class AddStrategy implements OperationStrategy {

    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
```

### Subtraction Strategy

```java
public class SubtractStrategy implements OperationStrategy {

    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
```

### Multiplication Strategy

```java
public class MultiplyStrategy implements OperationStrategy {

    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}
```

## Context

The `Calculator` class acts as the Context.

It stores a reference to `OperationStrategy` and delegates the calculation to the selected strategy.

```java
public class Calculator {

    private OperationStrategy strategy;

    public Calculator(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double a, double b) {
        return strategy.execute(a, b);
    }
}
```

## Runtime Strategy Switching

The strategy can be changed while the program is running.

```java
Calculator calculator =
        new Calculator(new AddStrategy());

System.out.println("Addition: " +
        calculator.calculate(10, 5));

calculator.setStrategy(new SubtractStrategy());

System.out.println("Subtraction: " +
        calculator.calculate(10, 5));

calculator.setStrategy(new MultiplyStrategy());

System.out.println("Multiplication: " +
        calculator.calculate(10, 5));
```

The `Calculator` class does not need to know how each algorithm works.

It only works with the common `OperationStrategy` interface.

## Example Output

```text
Addition: 15.0
Subtraction: 5.0
Multiplication: 50.0
```

## Advantages of the Strategy Pattern

- Removes conditional logic from the Context
- Allows algorithms to be changed at runtime
- Makes new strategies easy to add
- Keeps each algorithm in a separate class
- Improves flexibility and maintainability
- Supports the Open/Closed Principle

## Technologies

- Java 17
- IntelliJ IDEA
- Maven

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure Java 17 is selected.
3. Open `Main.java`.
4. Run the `main()` method.
5. The console will display the results of all three strategies.

## Conclusion

The project demonstrates how the Strategy Pattern allows different algorithms to be selected and changed at runtime.

The `Calculator` depends only on the `OperationStrategy` interface, while each mathematical operation is implemented in its own Concrete Strategy class.

This design removes unnecessary conditional logic and makes the system easier to extend without modifying existing strategy classes.