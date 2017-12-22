package kata6.Modelo;

public class Person {
    private final Integer id;
    private final String name,mail,birthdate;
    private final Character gender;
    private final Float weight;

    public Person(Integer id, String name, Character gender,String birthdate, Float weight, String mail){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.birthdate=birthdate;
        this.weight=weight;
        this.mail=mail;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public Character getGender() {
        return gender;
    }
    
    public String getBirthdate() {
        return birthdate;
    }

    public Float getWeight() {
        return weight;
    }
}
