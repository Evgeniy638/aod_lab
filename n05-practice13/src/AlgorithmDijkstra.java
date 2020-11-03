import java.util.ArrayList;

public class AlgorithmDijkstra {
    private static ArrayList<Boolean> pastPaths;
    private static ArrayList<Integer> weightPaths;
    private static Graph graph;

    public static int findShortestPath(Graph graph, String startName, String endName) throws Exception {
        AlgorithmDijkstra.graph = graph;

        final int finalIndexNode = graph.getIndexNodeByName(endName);
        int currentIndexNode = graph.getIndexNodeByName(startName);
        Node curNode = graph.nodes.get(currentIndexNode);

        init(graph.nodes.size(), currentIndexNode, finalIndexNode);

        weightPaths.set(currentIndexNode, 0);

        while (!isWentAllWay()) {
            pastPaths.set(currentIndexNode, true);

            // изменяем размер путей
            for (Path path: curNode.adjacentPaths) {
                Node node = path.getOtherNodeByName(curNode.name);

                int index = graph.getIndexNodeByName(node.name);

                int newWeight = path.weight + weightPaths.get(currentIndexNode);

                weightPaths.set(index, Math.min(newWeight, weightPaths.get(index)));
            }

            // ищем новый путь
            boolean isFindFirst = false;
            int newIndex = 0;

            for(int i = 1; i < graph.nodes.size(); i++) {
                if (!pastPaths.get(i) && (weightPaths.get(i) < weightPaths.get(newIndex) || !isFindFirst)) {
                    newIndex = i;
                    isFindFirst = true;
                }
            }

            currentIndexNode = newIndex;
            curNode = graph.nodes.get(currentIndexNode);
        }

        return weightPaths.get(finalIndexNode);
    }

    private static void init(int size, int startIndexNode, int endIndexNode) {
        pastPaths = new ArrayList<>();
        weightPaths = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            pastPaths.add(false);
            weightPaths.add(Integer.MAX_VALUE);
        }
    }

    private static boolean isWentAllWay() {
        for (Boolean pastPath: pastPaths) {
            if (!pastPath) {
                return false;
            }
        }

        return true;
    }
}
