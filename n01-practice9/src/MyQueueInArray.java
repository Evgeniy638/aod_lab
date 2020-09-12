import java.util.ArrayList;

class MyQueueInArray extends MyQueue{
    private final ArrayList<Integer> arrayList;

    public MyQueueInArray() {
        this(new ArrayList<>());
    }

    public MyQueueInArray(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public void push(Integer element) {
        arrayList.add(element);

        for (int i = arrayList.size() - 1; i >= 0 ; i--) {
            if (i == 0) {
                arrayList.set(i, element);
                continue;
            }

            arrayList.set(i, arrayList.get(i - 1));
        }
    }

    public void remove() {
        arrayList.remove(arrayList.size() - 1);
    }

    public int get() {
        return arrayList.get(arrayList.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return !isEmpty();
    }
}