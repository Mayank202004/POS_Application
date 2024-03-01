package pos_application;

import Dependency.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mayan
 */
public class report extends javax.swing.JPanel {

  
    public report() {
        initComponents();
        showBarChart();
        
    }
     public void showBarChart(){
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Assuming 'db' is an instance of your database handler class
    try {
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT order_date, total_amount FROM orders ORDER BY order_date DESC LIMIT 5");

        while (rs.next()) {
            String date = rs.getString("order_date");
            double totalAmount = rs.getDouble("total_amount");
            dataset.setValue(totalAmount, "Amount", date);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Daily Contribution",
                "Date",
                "Amount",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barChartPanel = new ChartPanel(chart);
        jPanel1.removeAll();
        jPanel1.add(barChartPanel, BorderLayout.CENTER);
        jPanel1.validate();

    } catch (SQLException e) {
       
        System.out.print(e);
    }
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(598, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
