public class ReaderSubscription {
    private final int number;
    private String fullName;
    private String address;

    public ReaderSubscription(int number, String fullName, String address) {
        this.number = number;
        this.fullName = fullName;
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        ReaderSubscription readerSubscription = ((ReaderSubscription) obj);

        return readerSubscription.getNumber() == this.getNumber() &&
                readerSubscription.getFullName().equals(this.getFullName()) &&
                readerSubscription.getAddress().equals(this.getAddress());
    }

    @Override
    public String toString() {
        return "ReaderSubscription{" +
                "number=" + number +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}