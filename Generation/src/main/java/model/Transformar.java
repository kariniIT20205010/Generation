package model;

public class Transformar {
    private static Integer Id;
    private static Integer en_Id;
    private static String active;
    private static String date;

    public Transformar(){}

    public static Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public static Integer geten_Id() {
        return en_Id;
    }

    public void seten_Id(Integer en_id) {
        this.en_Id = en_id;
    }

    public static String getactive() {
        return active;
    }

    public void setactive(String active) {
        this.active = active;
    }

    public static String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transformar{" +
                "id=" + Id +
                ", en_id='" + en_Id + '\'' +
                ", active='" + active + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
