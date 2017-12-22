package kata6.Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.Modelo.*;
import kata6.Vista.*;

public class Kata6 {
    
    public static void main(String[] args) throws Exception {
        Kata6 kata4 = new Kata6();
        kata4.execute();
    }
    
    private void execute() throws Exception{
        input();
        process();
        output();
    }

    private String fileName;
    private List<Mail> mailList;
    private MailHistogramBuilder<Mail> builder;
    private MailHistogramBuilder<Person> builderPerson;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private List <Person> people;
    private Histogram<Character> gender;   
    private Histogram<Float> weight;

    private void process() {
        domains = builder.build(new Attribute<Mail, String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
        });
        
        
        letters = builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
        
        gender = builderPerson.build(new Attribute<Person, Character>() {
            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });
        
        weight = builderPerson.build(new Attribute<Person, Float>(){
            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
        });
    }

    private void input() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        fileName = "Mail.txt";
        mailList = MailListReader.read(fileName);
        builder = new MailHistogramBuilder<>(mailList);
        people = PersonListReader.read();
        builderPerson = new MailHistogramBuilder<>(people);
    }
    
    private void output() {
        new HistogramDisplay (domains, "Dominios").execute();
        new HistogramDisplay (letters, "Primer Caracter").execute();
        new HistogramDisplay (gender, "Gender").execute();
        new HistogramDisplay (weight, "Weight").execute();
    }
}