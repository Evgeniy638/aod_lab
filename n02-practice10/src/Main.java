import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] arr = inputArr();
        int[] arr = new int[]{
                5, 1, 2, 3, 6, 7, 4, 10, 8, 9
        };

        AVLTree avlTree = new AVLTree(arr);

        avlTree.printTree();

        System.out.println(Arrays.toString(avlTree.getArr()));
    }

    private static int[] inputArr() {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        return arr;
    }
}
