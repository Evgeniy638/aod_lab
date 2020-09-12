public class MyList {
    private class ElementList {
        ElementList next;
        int value;

        public ElementList() {
            this(0);
        }

        public ElementList(int value) {
            this(value, null);
        }

        public ElementList(int value, ElementList next) {
            this.value = value;
            this.next = next;
        }
    }

    private ElementList elementList;

    MyList() {
        elementList = null;
    }

    private ElementList getLastElement() throws Exception {
        if (elementList == null) throw new Exception("Список пуст");

        ElementList el = elementList;

        while (el.next != null) {
            el = el.next;
        }

        return el;
    }

    private ElementList getElement(int index) throws Exception {
        int currentIndex = 0;

        ElementList el = elementList;

        while (currentIndex != index) {
            if (el.next == null) throw new Exception("Индекса " + index + " нет!");

            currentIndex++;
            el = el.next;
        }

        return el;
    }

    public  void addFirst(int element) {
        if (elementList == null) {
            elementList = new ElementList(element);
        } else {
            elementList = new ElementList(element, elementList);
        }
    }

    public void add(int index, int element) throws Exception {
        ElementList el = getElement(index);
        el.next = new ElementList(element, el.next);
    }

    public void addLast(int element) {
        ElementList newElement = new ElementList(element);

        try {
            (getLastElement()).next = newElement;
        } catch (Exception e) {
            elementList = newElement;
            e.printStackTrace();
        }
    }

    public void remove(int index) {
        if (index == 0) {
            elementList = elementList.next;
        } else {
            try {
                ElementList prevElement = getElement(index - 1);
                prevElement.next = prevElement.next.next;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int size() {
        ElementList el = elementList;

        if (el == null) {
            return 0;
        }

        int length = 1;

        while (el.next != null) {
            length++;
            el = el.next;
        }

        return length;
    }

    public int getValue(int index) throws Exception {
        return (getElement(index)).value;
    }

    public int getLastValue() throws Exception {
        return (getLastElement()).value;
    }

    public boolean isEmpty() {
        return elementList == null;
    }
}
