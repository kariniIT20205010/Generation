package resource;

public class Source {
    private static Integer Id;
    private static String Name;
    private static String Place;
    private static String Type;

    public Source(){}

    public static Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public static String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public static String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public static String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }



    @Override
    public String toString() {
        return "Source{" +
                "id=" + Id +
                ", Name='" + Name + '\'' +
                ", Place='" + Place + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
