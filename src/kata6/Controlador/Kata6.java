package kata6.Controlador;

import java.io.IOException;
import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Modelo.Mail;
import kata6.Vista.Attribute;
import kata6.Vista.HistogramDisplay;
import kata6.Vista.MailHistogramBuilder;
import kata6.Vista.MailListReader;

public class Kata6 {


    public static void main(String[] args) throws IOException, Exception {
       
        Kata6 kata= new Kata6();
        kata.execute();

        
    }
    
    Histogram<String> histogram;
    List<Mail> mailList;
    MailHistogramBuilder<Mail> builder;
    Histogram<String> domains;
    Histogram<Character> letters;
    
    private void execute() throws Exception{
        input();
        process();
        output();
    }
    private void process() throws Exception{
        domains = builder.build(new Attribute<Mail,String>(){
             @Override
             public String get (Mail item){
                 return item.getMail().split("@")[1];
             }
        });
        letters = builder.build(new Attribute<Mail,Character>(){
           @Override
           public Character get(Mail item){
               return item.getMail().charAt(0);
           }
        });
 
    }
    private void input() throws IOException{
        String filename = "Mail.txt";
        mailList = MailListReader.read(filename);  
        builder = new MailHistogramBuilder<>(mailList);
        
    }
    private void output(){        
        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"primer Caracter").execute();
    }
}