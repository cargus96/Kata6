package kata6.Vista;

import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Modelo.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build(List<String> mail){
        Histogram<String> histo = new Histogram<>();
        for (String mail1 : mail) {
            histo.increment(new Mail(mail1).getDomain());
        }
            return histo;
        }
}
