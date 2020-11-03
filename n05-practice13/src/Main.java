import java.util.Scanner;

public class Main {
    private static final Graph graph = new Graph();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            getGraph();

            System.out.print("Введите имя первой вершиной: ");
            String startName = in.nextLine();

            System.out.print("Введите имя второй вершиной: ");
            String endName = in.nextLine();

            int res = AlgorithmDijkstra.findShortestPath(graph, startName, endName);
            System.out.println("Ответ: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getGraph() throws Exception {
        System.out.print("Введите количество вершин: ");
        int size = Integer.parseInt(in.nextLine());

        for (int i = 0; i < size; i++) {
            System.out.println("Введите имя " + (i+1) + " вершины: ");
            graph.addNode(in.nextLine());
        }

        System.out.println("Введите рёбра в формате: " +
                "\"вес вершины\" пробел \"имя первой вершины\" пробел \"имя второй вершины\"");
        System.out.println("Введите \"q\" для конца ввода");

        while (true) {
            String line = in.nextLine().replace("\"", "");

            if (line.equals("q")) break;

            String[] strings = line.split(" ");

            graph.addEdge(Integer.parseInt(strings[0]), strings[1], strings[2]);
        }
    }

    private static void test () {
        Graph graph = new Graph();

        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");

        try {
            graph.addEdge(14, "1", "6");
            graph.addEdge(9, "1", "3");
            graph.addEdge(7, "1", "2");

            graph.addEdge(10, "2", "3");
            graph.addEdge(15, "2", "4");

            graph.addEdge(11, "3", "4");
            graph.addEdge(2, "3", "6");

            graph.addEdge(6, "4", "5");

            graph.addEdge(9, "5", "6");

            System.out.println(AlgorithmDijkstra.findShortestPath(graph, "1", "6"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
