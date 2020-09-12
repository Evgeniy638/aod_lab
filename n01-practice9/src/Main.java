public class Main {
    public static void main(String[] args) {
        int length = 10;
        int[] arr = getRandomArray(length);

        System.out.println("Оригинальный массив");
        printArray(arr);

        int[] arrSortByArray = sortArrayInArray(arr.clone());
        System.out.println("Массив отсортированный с помощью очереди, реализованной на массиве: ");
        printArray(arrSortByArray);

        int[] arrSortByQueue = sortArrayInList(arr.clone());
        System.out.println("Массив отсортированный с помощью очереди, реализованной на списке: ");
        printArray(arrSortByQueue);
    }

    private static int[] sortArrayInArray(int[] arr) {
        MyQueue[] myQueues = new MyQueueInArray[arr.length];

        for (int i = 0; i < myQueues.length; i++) {
            myQueues[i] = new MyQueueInArray();
            convertIntToQueue(myQueues[i], arr[i], 4);
        }

        return sortArr(myQueues, arr);
    }

    private static int[] sortArrayInList(int[] arr) {
        MyQueue[] myQueues = new MyQueueInList[arr.length];

        for (int i = 0; i < myQueues.length; i++) {
            myQueues[i] = new MyQueueInList();
            convertIntToQueue(myQueues[i], arr[i], 4);
        }

        return sortArr(myQueues, arr);
    }

    private static void convertIntToQueue(MyQueue myQueue, int number, int length) {
        for (int i = 0; i < length; i++) {
            myQueue.push(number % 10);
            number /= 10;
        }
    }

    private static int[] sortArr(MyQueue[] discharges, int[] arr) {
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (discharges[j].get() > discharges[j+1].get()) {
                        int tmp = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = tmp;

                        MyQueue tmpQ = discharges[j+1];
                        discharges[j+1] = discharges[j];
                        discharges[j] = tmpQ;
                    }
                }
            }

            for (int j = 0; j < arr.length; j++) {
                discharges[j].remove();
            }
        }

        return arr;
    }

    private static Integer getRandomNumber() {
        return (int) (Math.random() * 1000);
    }

    private static int[] getRandomArray(int length) {
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = getRandomNumber();
        }

        return arr;
    }

    private static void printArray(int[] arr) {
        for (int el: arr) {
            System.out.println(el);
        }
    }
}
