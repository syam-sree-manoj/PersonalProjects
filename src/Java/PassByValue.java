package Java;

public class PassByValue {
    /*
    Java is always pass-by-value.
    For primitives, the value of the variable is passed.
    For objects, the value of the reference (a copy of the memory address) is passed,
    meaning changes to the object's fields persist, but reassigning the reference does not affect the original.
     */

    public class Main {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder("Hello");
            modifyObject(sb);
            System.out.println(sb); // Output: "Hello, World!" (field modified)

            resetObject(sb);
            System.out.println(sb); // Output: "Hello, World!" (original reference unaffected)
        }

        public static void modifyObject(StringBuilder sb) {
            sb.append(", World!"); // Modifies the original object
        }

        public static void resetObject(StringBuilder sb) {
            sb = new StringBuilder("New Object"); // Changes only the local reference
        }
    }

}
