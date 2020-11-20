public class Main {
    private static class Data {
        int[][] matrix;
        int[][] source;
    }

    private static String order = "";
    private static final Data data = new Data();

    public static int multiplyOrder(int[] p) {
        int n = p.length - 1;

        data.matrix = new int[n][n];
        data.source = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                data.matrix[i][j] = 0;
                data.source[i][j] = 0;
            }
        }

        for (int l = 1; l < n; ++l) {
            for (int i = 0; i < n - l; ++i) {
                int j = i + l;
                data.matrix[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    int expression = data.matrix[i][k] + data.matrix[k + 1][j] + p[i] * p[k + 1] * p[j + 1];

                    if (expression < data.matrix[i][j]) {
                        data.matrix[i][j] = expression;
                        data.source[i][j] = k;
                    }
                }
            }
        }
        return data.matrix[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Вариант 2");
        System.out.println("Разработать процедуру оптимального способа расстановки скобок в\n" +
                "произведении последовательности матриц, размеры которых равны\n" +
                "(5,10,3,12,5,50,6), чтобы количество скалярных умножений стало\n" +
                "минимальным (максимальным).");

        int[] test = { 5, 10, 3, 12, 5, 50, 6 };

        System.out.println("Минимальное количество скалярных умножений: " + Main.multiplyOrder(test));

        printOrder(0, test.length - 2);
        System.out.println(order);
    }

    private static void printOrder(int i, int j){
        if (i == j) {
            order += "A" + i;
        } else {
            order += "(";
            printOrder(i, data.source[i][j]);
            order += "*";
            printOrder(data.source[i][j] + 1, j);
            order += ")";
        }
    }
}
