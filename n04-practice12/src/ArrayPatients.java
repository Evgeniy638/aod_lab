import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayPatients {
    ArrayList<PolyclinicPatient> patients = new ArrayList<>();

    ArrayPatients() throws IOException {
        String data = FileHelper.readFile();
        String[] strings = data.split("\n");

        for (String str: strings) {
            String[] dataAboutPatients = str.split(" ");
            patients.add(new PolyclinicPatient(
                    Integer.parseInt(dataAboutPatients[0]),
                    Integer.parseInt(dataAboutPatients[1]),
                    dataAboutPatients[2]
            ));
        }
    }

    private void saveToFile() throws IOException {
        FileHelper.writeFile(this.toString());
    }

    private PolyclinicPatient getPatientByNumberCard(int numberCard) throws Exception {
        for (PolyclinicPatient p: patients) {
            if (numberCard == p.getNumberCard()) {
                return p;
            }
        }

        throw new Exception("Пациент с numberCard = " + numberCard + " не найден!");
    }

    public int[] getAllNumberPatients() {
        int[] numbers = new int[patients.size()];

        for (int i = 0; i < patients.size(); i++) {
            numbers[i] = patients.get(i).getNumberCard();
        }

        return numbers;
    }

    public void setSecondNameDoctor(int numberCard, String newSecondNameDoctor) {
        try {
            PolyclinicPatient polyclinicPatient = getPatientByNumberCard(numberCard);
            polyclinicPatient.setSecondNameDoctor(newSecondNameDoctor);
            this.saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String[] data = new String[patients.size()];

        for (int i = 0; i < patients.size(); i++) {
            data[i] = patients.get(i).toString();
        }

        return String.join("\n", data);
    }
}
