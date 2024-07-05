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
        dailyBarChart();
        
    }
     public void dailyBarChart(){
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Assuming 'db' is an instance of your database handler class
    try {
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM (SELECT order_date, SUM(total_amount) AS total_amount FROM orders GROUP BY order_date ORDER BY STR_TO_DATE(order_date, '%d/%m/%Y') DESC LIMIT 5 )AS subquery ORDER BY STR_TO_DATE(order_date, '%d/%m/%Y') ASC;");

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
     
     // weekly chart 
    public void weeklyBarChart(){
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try {
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT " 
    +"CONCAT(DATE_FORMAT(DATE_SUB(MIN(STR_TO_DATE(order_date, '%d/%m/%Y')), INTERVAL WEEKDAY(MIN(STR_TO_DATE(order_date, '%d/%m/%Y'))) DAY), '%Y-%m-%d'),' - ',"
        +"DATE_FORMAT(DATE_ADD(MAX(STR_TO_DATE(order_date, '%d/%m/%Y')), INTERVAL (6 - WEEKDAY(MAX(STR_TO_DATE(order_date, '%d/%m/%Y')))) DAY), '%Y-%m-%d')) AS Date_Range,"
        +"SUM(total_amount) AS Total_Amount FROM orders "+
        "WHERE STR_TO_DATE(order_date, '%d/%m/%Y') >= DATE_SUB(CURDATE(), INTERVAL 4 WEEK) "+
        "GROUP BY CONCAT('Week ', WEEK(STR_TO_DATE(order_date, '%d/%m/%Y')) - WEEK(NOW()) + 5) "
        +"ORDER BY Date_Range;");

        while (rs.next()) {
            String date = rs.getString("Date_Range");
            double totalAmount = rs.getDouble("total_amount");
            dataset.setValue(totalAmount, "Total_Amount", date);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Weekly Contribution",
                "Date Range",
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
    
    //Monthly bar chart
    public void monthlyBarChart(){
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    // Mapping of month numbers to month names
    String[][] monthNames = {
        {"1", "January"},
        {"2", "February"},
        {"3", "March"},
        {"4", "April"},
        {"5", "May"},
        {"6", "June"},
        {"7", "July"},
        {"8", "August"},
        {"9", "September"},
        {"10", "October"},
        {"11", "November"},
        {"12", "December"}
    };
    
    try {
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT "
            + "MONTH(STR_TO_DATE(order_date, '%d/%m/%Y')) AS Month,"
            + "SUM(total_amount) AS Total_Amount "
            + "FROM orders "
            + "WHERE STR_TO_DATE(order_date, '%d/%m/%Y') >= DATE_SUB(CURDATE(), INTERVAL 5 MONTH) "
            + "GROUP BY Month "
            + "ORDER BY Month;");

        while (rs.next()) {
            int monthNumber = rs.getInt("Month");
            double totalAmount = rs.getDouble("Total_Amount");
            
            // Get month name from the monthNames array
            String monthName = "";
            for (String[] month : monthNames) {
                if (Integer.parseInt(month[0]) == monthNumber) {
                    monthName = month[1];
                    break;
                }
            }
            
            // Add data to dataset
            dataset.setValue(totalAmount, "Total_Amount", monthName);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Monthly Contribution",
                "Month",
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
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();

        setBackground(new java.awt.Color(217, 227, 241));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        rSMaterialButtonRectangle1.setText("Daily Chart");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle2.setText("Weekly Chart");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle3.setText("Monthly CHART");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        weeklyBarChart();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        monthlyBarChart();
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        dailyBarChart();
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    // End of variables declaration//GEN-END:variables
}
