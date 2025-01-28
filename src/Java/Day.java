package Java;

// Custom enum with constructor and toString
enum Day {
    MONDAY("Start of the work week"),
    TUESDAY("Second day of the work week"),
    WEDNESDAY("Midweek"),
    THURSDAY("Almost Friday"),
    FRIDAY("End of the work week"),
    SATURDAY("Weekend!"),
    SUNDAY("Relax day");

    private final String description; // Field to hold the description

    // Constructor
    Day(String description) {
        this.description = description;
    }

    // Getter method for description
    public String getDescription() {
        return description;
    }

    // Overriding toString()
    @Override
    public String toString() {
        return this.name() + " - " + description;
    }
}

/*

public class Main {
    public static void main(String[] args) {
        // Printing all enum values with descriptions
        for (Day day : Day.values()) {
            System.out.println(day); // Calls overridden toString()
        }
    }
}

 */

