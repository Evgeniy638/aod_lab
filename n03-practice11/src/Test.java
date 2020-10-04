import java.util.ArrayList;

public class Test {
    private static final int startIndex = 10000;
    private static final int endIndex = startIndex + 10;

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();

        ArrayList<ReaderSubscription> subscriptions = getRandomSubscriptions();

        testAdd(myHashTable, subscriptions);
        testSearch(myHashTable, subscriptions);
        testDelete(myHashTable, subscriptions);
    }

    private static void testAdd(MyHashTable myHashTable, ArrayList<ReaderSubscription> subscriptions) {
        System.out.println("\n\nТестируем добавление");

        for (ReaderSubscription readerSubscription: subscriptions) {
            myHashTable.add(readerSubscription);
        }

        myHashTable.print();
    }

    private static void testSearch(MyHashTable myHashTable, ArrayList<ReaderSubscription> subscriptions) {
        System.out.println("\n\nТестируем поиск");

        boolean attempt, expected;

        try {
            for (ReaderSubscription readerSubscription : subscriptions) {
                attempt = myHashTable.has(readerSubscription);

                if (!attempt)
                    throw new Exception("Ожидалось true, получено false");
            }

            ArrayList<ReaderSubscription> otherSubscriptions = getRandomSubscriptions();

            for (int i = 0; i < 5; i++) {
                expected = subscriptions.contains(otherSubscriptions.get(i));
                attempt = myHashTable.has(otherSubscriptions.get(i));

                if (expected != attempt)
                    throw new Exception("Ожидалось " + expected + ", получено " + attempt);
            }


            System.out.println("Тест пройден");

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Тест не пройден!");
        }
    }

    private static void testDelete(MyHashTable myHashTable, ArrayList<ReaderSubscription> subscriptions) {
        System.out.println("\n\nТестируем удаление");

        for (ReaderSubscription readerSubscription: subscriptions) {
            myHashTable.delete(readerSubscription);
        }

        myHashTable.delete(subscriptions.get(getRandomIndex(subscriptions.size())));

        myHashTable.print();
    }

    private static ArrayList<ReaderSubscription> getRandomSubscriptions() {
        ArrayList<ReaderSubscription> subscriptions = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            subscriptions.add(new ReaderSubscription(i, getRandomFullName(), getRandomAddress()));
        }

        return subscriptions;
    }

    private static String getRandomFullName() {
        String[] firstNames = {
                "Еремей",
                "Яков",
                "Вадим",
                "Варфоломей",
                "Кузьма",
                "Сергей",
                "Никон",
                "Артем",
                "Юлий"
        };

        String[] secondNames = {
                "Шаров",
                "Алексахин",
                "Хребтов",
                "Фотин",
                "Ягубский",
                "Епанчин",
                "Мягков",
                "Муравьёв",
                "Конаков",
                "Янечко",
        };

        String[] fatherNames = {
                "Еремеевич",
                "Федорович",
                "Тарасович",
                "Кондратиевич",
                "Родионович",
                "Анатолиевич"
        };

        return secondNames[getRandomIndex(secondNames.length)] + " " +
                firstNames[getRandomIndex(firstNames.length)] + " " +
                fatherNames[getRandomIndex(fatherNames.length)];
    }


    private static String getRandomAddress() {
        String[] addresses = {
                "64, avenue Bertrand Moulin",
                "6, place Bouchet",
                "Lilo-Rothe-Weg 5a",
                "Probstplatz 502",
                "40616 Luigi Fort Suite 931"
        };

        return addresses[getRandomIndex(addresses.length)];
    }

    private static int getRandomIndex(int length){
        return (int) (Math.random() * length);
    }
}
