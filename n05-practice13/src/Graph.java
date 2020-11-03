import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(String name) {
        nodes.add(new Node(name));
    }

    public void addEdge(int weight, String name1, String name2) throws Exception {
        Node node1 = nodes.get(getIndexNodeByName(name1));
        Node node2 = nodes.get(getIndexNodeByName(name2));

        Path path = new Path(weight, node1, node2);

        node1.adjacentPaths.add(path);
        node2.adjacentPaths.add(path);
    }

    public int getIndexNodeByName(String name) throws Exception {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).name.equals(name)) {
                return i;
            }
        }

        throw new Exception("Вершина с именем " + name + " не найдена");
    }
}
