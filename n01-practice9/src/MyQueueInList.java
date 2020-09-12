class MyQueueInList extends MyQueue {
    private MyList myList;

    public MyQueueInList() {
        this(new MyList());
    }

    public MyQueueInList(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void push(Integer element) {
        myList.addFirst(element);
    }

    @Override
    public void remove() {
        myList.remove(myList.size() - 1);
    }

    @Override
    public int get() {
        try {
            return myList.getLastValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return !isEmpty();
    }
}