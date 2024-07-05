/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pos_application;

import Dependency.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mayan
 */
public class customerAnalysis extends javax.swing.JPanel {

    /**
     * Creates new form customerAnalysis
     */
    public customerAnalysis() {
        initComponents();
        fetchData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Top_Cust_day = new javax.swing.JLabel();
        Top_Cust_week = new javax.swing.JLabel();
        Top_Cust_month = new javax.swing.JLabel();
        freq_cust_week = new javax.swing.JLabel();
        freq_cust_month = new javax.swing.JLabel();
        value1 = new javax.swing.JLabel();
        value2 = new javax.swing.JLabel();
        value3 = new javax.swing.JLabel();
        value5 = new javax.swing.JLabel();
        value4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(217, 227, 241));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Customer Analysis");

        Top_Cust_day.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Top_Cust_day.setText("Top Customer of the Day :");

        Top_Cust_week.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Top_Cust_week.setText("Top Customer of the Week :");

        Top_Cust_month.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Top_Cust_month.setText("Top Customer of the Month :");

        freq_cust_week.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        freq_cust_week.setText("Most Frequent Customer of the week :");

        freq_cust_month.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        freq_cust_month.setText("Most Frequent Customer of the Month :");

        value1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        value1.setText("Value1");

        value2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        value2.setText("Value2");

        value3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        value3.setText("Value3");

        value5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        value5.setText("Value5");

        value4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        value4.setText("Value4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(freq_cust_month)
                        .addGap(18, 18, 18)
                        .addComponent(value5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(freq_cust_week)
                        .addGap(18, 18, 18)
                        .addComponent(value4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Top_Cust_week)
                        .addGap(18, 18, 18)
                        .addComponent(value2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Top_Cust_month)
                        .addGap(18, 18, 18)
                        .addComponent(value3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Top_Cust_day)
                        .addGap(18, 18, 18)
                        .addComponent(value1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(416, 416, 416))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Top_Cust_day)
                    .addComponent(value1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Top_Cust_week)
                    .addComponent(value2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Top_Cust_month)
                    .addComponent(value3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freq_cust_week)
                    .addComponent(value4))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freq_cust_month)
                    .addComponent(value5))
                .addContainerGap(285, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // THis method is used to retrieve data from database and fill it on the window regarding top customers etc
    private void fetchData() {
    try {
        Statement s = db.mycon().createStatement();
        
        // Query for today's top customer
        ResultSet val1 = s.executeQuery("SELECT customer_id, customer_name, SUM(total_amount) AS total_spent FROM orders WHERE STR_TO_DATE(order_date, '%d/%m/%Y') = CURDATE() GROUP BY customer_id, customer_name ORDER BY total_spent DESC LIMIT 1");
        if (val1.next()) {
            value1.setText(val1.getString("customer_name") + " (₹ " + val1.getString("total_spent") + ")");
        } else {
            value1.setText("None");
        }
        val1.close();

        // Query for the current week's top customer
        ResultSet val2 = s.executeQuery("SELECT customer_id, customer_name, SUM(total_amount) AS total_spent FROM orders WHERE YEARWEEK(STR_TO_DATE(order_date, '%d/%m/%Y'), 1) = YEARWEEK(CURDATE(), 1) GROUP BY customer_id, customer_name ORDER BY total_spent DESC LIMIT 1");
        if (val2.next()) {
            value2.setText(val2.getString("customer_name") + " (₹ " + val2.getString("total_spent") + ")");
        } else {
            value2.setText("None");
        }
        val2.close();

        // Query for the current month (from 1st of the month till today) top customer
        ResultSet val3 = s.executeQuery("SELECT customer_id, customer_name, SUM(total_amount) AS total_spent FROM orders WHERE STR_TO_DATE(order_date, '%d/%m/%Y') BETWEEN DATE_FORMAT(CURDATE(), '%Y-%m-01') AND CURDATE() GROUP BY customer_id, customer_name ORDER BY total_spent DESC LIMIT 1");
        if (val3.next()) {
            value3.setText(val3.getString("customer_name") + " (₹ " + val3.getString("total_spent") + ")");
        } else {
            value3.setText("None");
        }
        val3.close();

        s.close();
    } catch (SQLException e) {
        System.out.print(e);
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Top_Cust_day;
    private javax.swing.JLabel Top_Cust_month;
    private javax.swing.JLabel Top_Cust_week;
    private javax.swing.JLabel freq_cust_month;
    private javax.swing.JLabel freq_cust_week;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel value1;
    private javax.swing.JLabel value2;
    private javax.swing.JLabel value3;
    private javax.swing.JLabel value4;
    private javax.swing.JLabel value5;
    // End of variables declaration//GEN-END:variables
}