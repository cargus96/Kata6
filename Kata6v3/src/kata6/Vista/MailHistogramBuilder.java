package kata6.Vista;

import kata6.Controlador.Attribute;
import java.util.List;
import kata6.Modelo.Histogram;
import kata6.Modelo.Mail;

    public class MailHistogramBuilder <T>{
        private final List<T> items;
        public MailHistogramBuilder(List <T> items){
            this.items=items;
    }
    public <A>Histogram<A> build (Attribute <T,A> attribute){
        Histogram<A> histo = new Histogram<>();
        for(T item : items){
            A value = attribute.get(item);
            histo.increment(value);
        }
        return histo;
    }
}