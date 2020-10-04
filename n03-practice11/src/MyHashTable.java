import java.util.Arrays;

public class MyHashTable {
    private ReaderSubscription[] subscriptions;

    public MyHashTable() {
        subscriptions = new ReaderSubscription[9];

        Arrays.fill(subscriptions, null);
    }

    public void add(int number, String fullName, String address) {
        add(new ReaderSubscription(number, fullName, address));
    }

    public void add(ReaderSubscription readerSubscription) {
        int index = getIndex(readerSubscription.getNumber());

        try {
            if (subscriptions[index] != null) {
                throw new Exception("Возникла коллизия с элементом " + readerSubscription +
                        ", по индексу " + index +
                        " уже есть элемент " + subscriptions[index]);
            }

            subscriptions[getIndex(readerSubscription.getNumber())] = readerSubscription;
        } catch (Exception e) {
            e.printStackTrace();

            if (subscriptions[index].getNumber() == readerSubscription.getNumber()) {
                for (int i = index; i < subscriptions.length; i++) {
                    if (subscriptions[i] == null) {
                        subscriptions[i] = readerSubscription;
                        return;
                    }
                }
            }

            ReaderSubscription[] newSubscriptions = new ReaderSubscription[subscriptions.length * 2];

            Arrays.fill(newSubscriptions, null);

            ReaderSubscription[] copy = subscriptions;
            subscriptions = newSubscriptions;

            for (ReaderSubscription subscription : copy) {
                if (subscription == null) continue;

                add(subscription);
            }

            add(readerSubscription);
        }
    }

    public boolean has(int number, String fullName, String address) {
        return has(new ReaderSubscription(number, fullName, address));
    }

    public boolean has(ReaderSubscription readerSubscription) {
        int index = getIndex(readerSubscription.getNumber());

        for (int i = index; i < subscriptions.length; i++) {
            if (subscriptions[i] != null && subscriptions[i].equals(readerSubscription)) {
                return true;
            }
        }

        return false;
    }

    public void delete(int number, String fullName, String address) {
        delete(new ReaderSubscription(number, fullName, address));
    }

    public void delete(ReaderSubscription readerSubscription) {
        int index = getIndex(readerSubscription.getNumber());

        for (int i = index; i < subscriptions.length; i++) {
            if (subscriptions[i] != null && subscriptions[i].equals(readerSubscription)) {
                subscriptions[i] = null;
            }
        }
    }

    @Override
    public String toString() {
        boolean hasElement = false;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i] == null) continue;

            hasElement = true;

            res.append("Элемент ").append(subscriptions[i]).append(" лежит по индексу ").append(i).append(",\n");
        }

        if (!hasElement) {
            return "Хеш-таблица пуста";
        }

        return res.toString();
    }

    public void print() {
        System.out.println(this);
    }

    private int getIndex(int numberSubscription) {
        return Integer.valueOf(numberSubscription).hashCode() % subscriptions.length;
    }
}
