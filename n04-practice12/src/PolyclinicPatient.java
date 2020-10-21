public class PolyclinicPatient {
    private final int numberCard;
    private int chronicDiseaseCode;
    private String secondNameDoctor;

    public PolyclinicPatient(int numberCard, int chronicDiseaseCode, String secondNameDoctor) {
        this.numberCard = numberCard;
        this.chronicDiseaseCode = chronicDiseaseCode;
        this.secondNameDoctor = secondNameDoctor;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public int getChronicDiseaseCode() {
        return chronicDiseaseCode;
    }

    public void setChronicDiseaseCode(int chronicDiseaseCode) {
        this.chronicDiseaseCode = chronicDiseaseCode;
    }

    public String getSecondNameDoctor() {
        return secondNameDoctor;
    }

    public void setSecondNameDoctor(String secondNameDoctor) {
        this.secondNameDoctor = secondNameDoctor;
    }

    @Override
    public String toString() {
        return numberCard +
                " " + chronicDiseaseCode +
                " " + secondNameDoctor;
    }
}
