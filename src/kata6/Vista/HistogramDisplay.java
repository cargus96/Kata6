package kata6.Vista;
import java.awt.Container;
import java.awt.Dimension;
import kata6.Modelo.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay <T> extends ApplicationFrame {
    
    private final Histogram<T> histogram;
    private final String nameEjeX;
    public HistogramDisplay(Histogram<T> histogram,String ejeX){
        
        super("Histograma con JFree");
        this.nameEjeX=ejeX;
        this.histogram = histogram;
        setContentPane(createPanel());
        pack(); 
        }
    
    public  void execute(){
        setVisible(true);
    }
    private Container createPanel(){
        ChartPanel chartPanel = new ChartPanel (createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension (500,400));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma",
                "Dominio",
                "nÂº emails",
                dataSet,
                PlotOrientation.VERTICAL,
                true,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;
        
        
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.getKey(key),"", (Comparable)key);
            
        }
        return dataSet;
        
        
    }
}
