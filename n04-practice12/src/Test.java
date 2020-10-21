import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            ArrayPatients arrayPatients = new ArrayPatients();

//            testRandomSecondName(arrayPatients);
            testWriteSecondName(arrayPatients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testRandomSecondName(ArrayPatients arrayPatients) {
        System.out.println("Было:");
        System.out.println(arrayPatients);

        int[] numbersCard = arrayPatients.getAllNumberPatients();

        for (int number: numbersCard) {
            arrayPatients.setSecondNameDoctor(number, getRandomSecondName());
        }

        System.out.println("\n\nСтало:");
        System.out.println(arrayPatients);
    }

    public static void testWriteSecondName(ArrayPatients arrayPatients) {
        System.out.println("Было:");
        System.out.println(arrayPatients);

        Scanner in = new Scanner(System.in);

        System.out.print("Введите номер карточки: ");
        int number = Integer.parseInt(in.nextLine());

        System.out.print("Введите фамилию: ");
        String secondName = in.nextLine();

        arrayPatients.setSecondNameDoctor(number, secondName);

        System.out.println("\n\nСтало:");
        System.out.println(arrayPatients);
    }

    public static String getRandomSecondName() {
        String[] secondNames = {
                "Коренев",
                "Рязанов",
                "Барсуков",
                "Кабальнов",
                "Касимов",
                "Оропай",
                "Агеев",
                "Лоськов",
                "Зворыгин",
                "Шибалов",
                "Ретюнских",
                "Купревича",
                "Чеботова",
                "Забирова",
                "Кизатова",
                "Еськова",
                "Бушуева",
                "Сукачёва",
                "Семёнова",
                "Остапюка"
        };

        return secondNames[(int) Math.floor(Math.random() * secondNames.length)];
    }
}
