/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pos_application;

import Dependency.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayan
 */
public class restockStatus extends javax.swing.JPanel {

    /**
     * Creates new form ProductList
     */
    public restockStatus() {
        initComponents();
        tb_load();
    }

    public void tb_load(){
        // Load Table from mysql to jTable
        try{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("select * from products WHERE Quantity < MinQTY");
            while(rs.next()){
                Vector v= new Vector();
                v.add(rs.getString(1)); // get column 1  
                v.add(rs.getString(2)); // get column 2  
                v.add(rs.getString(3)); // get column 3  
                v.add(rs.getString(4)); // get column 4  
                v.add(rs.getString(5)); // get column 5 
                v.add(rs.getString(6)); // get column 6 
                v.add(rs.getString(7)); // get column 7 
                v.add(rs.getString(8)); // get column 8 
                v.add(rs.getString(9)); // get column 9 
                dt.addRow(v);
            }
        }
        catch(SQLException e){
            System.out.println(e);}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        SearchByTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();

        setBackground(new java.awt.Color(217, 227, 241));
        setPreferredSize(new java.awt.Dimension(1046, 629));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Restock Status");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Search By :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Product ID", "Product Name", "Barcode", "Category" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        SearchByTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchByTextFieldActionPerformed(evt);
            }
        });
        SearchByTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchByTextFieldKeyReleased(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(217, 227, 241));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Barcode", "Buying Price", "MRP", "Selling Price", "Quantity", "Min Quantity"
            }
        ));
        jTable1.setAltoHead(20);
        jTable1.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        jTable1.setColorBordeHead(new java.awt.Color(0, 112, 192));
        jTable1.setColorFilasBackgound1(new java.awt.Color(217, 227, 241));
        jTable1.setColorFilasBackgound2(new java.awt.Color(217, 227, 241));
        jTable1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        jTable1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        jTable1.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(217, 227, 241));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(450, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(547, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchByTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchByTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchByTextFieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void SearchByTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchByTextFieldKeyReleased
         // Search By Logic 
      String name = SearchByTextField.getText();
      String searchby = (String) jComboBox1.getSelectedItem();

      // Map user-friendly names to actual column names
      searchby = switch (searchby) {
        case "Product Name" -> "ProductName";
        case "Barcode" -> "Barcode";
        case "Category" -> "Category";
        default -> "ProductID"; 
      };

      try {
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        Statement s = db.mycon().createStatement();

        String query = "SELECT * FROM products WHERE " + searchby + " LIKE '%" + name + "%' AND Quantity < MinQTY";
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            Vector v = new Vector();
            v.add(rs.getString(1)); //get column 1
            v.add(rs.getString(2)); //get column 2
            v.add(rs.getString(3)); // get column 3             
            v.add(rs.getString(4)); // get column 4  
            v.add(rs.getString(5)); // get column 5  
            v.add(rs.getString(6)); // get column 6  
            v.add(rs.getString(7)); // get column 7  
            v.add(rs.getString(8)); // get column 8  
            v.add(rs.getString(9)); // get column 9  
            dt.addRow(v);
        }
      } catch (SQLException e) {
            tb_load(); // Load the default data or handle the exception appropriately
      }
    }//GEN-LAST:event_SearchByTextFieldKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
   
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchByTextField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro jTable1;
    // End of variables declaration//GEN-END:variables
}

