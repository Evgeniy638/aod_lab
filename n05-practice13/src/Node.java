import java.util.ArrayList;

public class Node {
    String name;

    ArrayList<Path> adjacentPaths;

    public Node(String name) {
        this.name = name;
        adjacentPaths = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }
}