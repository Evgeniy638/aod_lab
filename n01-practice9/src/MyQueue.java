abstract class MyQueue {
    abstract public void push(Integer element);
    abstract public void remove();
    abstract public int get();
    public int getAndRemove() {
        int value = get();
        remove();
        return value;
    };
    abstract public boolean isEmpty();
    abstract public boolean isFull();
}
