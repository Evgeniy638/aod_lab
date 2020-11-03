public class Path {
    int weight;
    Node node1;
    Node node2;

    public Path(int weight, Node node1, Node node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getOtherNodeByName(String name) {
        if (!node1.name.equals(name)) {
            return node1;
        }

        return node2;
    }
}
