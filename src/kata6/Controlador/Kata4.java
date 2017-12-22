package kata6.Controlador;

import java.io.IOException;
import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Vista.HistogramDisplay;
import kata6.Vista.MailHistogramBuilder;
import kata6.Vista.MailListReader;

public class Kata4 {

    

    public static void main(String[] args) throws IOException, Exception {
        Kata4 kata= new Kata4();
        kata.execute();
        
    }
    public Histogram<String> histogram;
    public List<String> mailList;
    
    private void execute() throws Exception{
        input();
        process();
        output();
    }
    private void process() throws Exception{
        histogram = MailHistogramBuilder.build(mailList);
        
    }
    private void input() throws IOException{
        String filename = "Mail.txt";
        mailList = MailListReader.read(filename);
    }
    private void output(){ 
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}