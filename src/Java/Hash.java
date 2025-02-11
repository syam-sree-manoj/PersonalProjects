package Java;

public class Hash {
    /*
    In Java, when you use HashSet<int[]>, the equality check is based on reference comparison, not value comparison.
    This is because arrays in Java do not override equals() and hashCode() from Object, meaning two arrays with the same elements are not considered equal unless they refer to the exact same memory location.

    For int[] (Primitive Arrays)
        Uses default Object implementation of equals(), which checks memory reference, not array contents.
    For Objects
        If you store custom objects in a HashSet, equality is determined by overriding equals() and hashCode().

    class Node {
        int u, v;

        Node(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return u == node.u && v == node.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }

    Set<Node> visited = new HashSet<>();
    visited.add(new Node(1, 2));
    System.out.println(visited.contains(new Node(1, 2)));  // true

     */
}
