package model;

public class Energy {
    private static Integer Id;
    private static String Type;
    private static String Volt;

    public Energy(){}

    public static Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public static String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public static String getVolt() {
        return Volt;
    }

    public void setVolt(String Volt) {
        this.Volt = Volt;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + Id +
                ", Type='" + Type + '\'' +
                ", Type='" + Volt + '\'' +
                '}';
    }
}
