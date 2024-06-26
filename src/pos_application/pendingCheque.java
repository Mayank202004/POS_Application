/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pos_application;

import Dependency.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayan
 */
public class pendingCheque extends javax.swing.JPanel {

    /**
     * Creates new form pendingCheque
     */
    public pendingCheque() {
        initComponents();
        tb_load();
    }
    
    
    public void tb_load() {
    // To load MySQL table to jTable
    try {
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        Statement s = db.mycon().createStatement();
        
        // Get today's date
        Date today = new Date(System.currentTimeMillis());

        // Format today's date as a string in dd-mm-yyyy format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String todayString = dateFormat.format(today);
        
        ResultSet rs = s.executeQuery("SELECT supplier_id, supplier_name, cheque_date, total_amount FROM purchases WHERE payment_method = 'Cheque' AND STR_TO_DATE(cheque_date, '%d-%m-%Y') >= STR_TO_DATE('" + todayString + "', '%d-%m-%Y')");
        while (rs.next()) {
            Vector v = new Vector();
            v.add(rs.getString("supplier_id"));
            v.add(rs.getString("supplier_name"));
            v.add(rs.getString("cheque_date"));
            v.add(rs.getString("total_amount"));
            dt.addRow(v);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        searchbytextfield2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Pending Cheques");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Payee (Supplier Name)", "Date", "Total Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Search By:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Date" }));

        searchbytextfield2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbytextfield2ActionPerformed(evt);
            }
        });
        searchbytextfield2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbytextfield2KeyReleased(evt);
            }
        });

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(423, 423, 423)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(searchbytextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)))
                        .addGap(0, 422, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchbytextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchbytextfield2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbytextfield2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbytextfield2ActionPerformed

    private void searchbytextfield2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbytextfield2KeyReleased
    // Search By Logic
    String name = searchbytextfield2.getText();
    String searchby = (String) jComboBox1.getSelectedItem();

    try {
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        Statement s = db.mycon().createStatement();

        String query = "";

        // Check the selected search criteria and construct the query accordingly
        if (searchby.equals("Name")) {
            query = "SELECT supplier_id, supplier_name, cheque_date,total_amount FROM purchases WHERE payment_method = 'Cheque' AND supplier_name LIKE '%" + name + "%'";
        } else if (searchby.equals("Date")) {
            query = "SELECT supplier_id, supplier_name, cheque_date,total_amount FROM purchases WHERE payment_method = 'Cheque' AND cheque_date = '" + name + "'";
        }
        ResultSet rs = s.executeQuery(query);
        while (rs.next()) {
            Vector v = new Vector();
            v.add(rs.getString("supplier_id"));
            v.add(rs.getString("supplier_name"));
            v.add(rs.getString("cheque_date"));
            v.add(rs.getString("total_amount"));
            dt.addRow(v);
        }
    } catch (SQLException e) {
        tb_load(); // Load the default data or handle the exception appropriately
    }
    }//GEN-LAST:event_searchbytextfield2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();

            String query = "SELECT supplier_id, supplier_name, cheque_date,total_amount FROM purchases WHERE payment_method = 'Cheque'";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("supplier_id"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("cheque_date"));
                v.add(rs.getString("total_amount"));
                dt.addRow(v);
            }
        } catch (SQLException e) {
            tb_load(); // Load the default data or handle the exception appropriately
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchbytextfield2;
    // End of variables declaration//GEN-END:variables
}
