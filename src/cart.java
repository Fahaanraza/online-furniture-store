
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 91805
 */
public class cart extends javax.swing.JFrame {

    /**
     * Creates new form cart
     */
    public cart() {
        initComponents();
        table_update();
    }

    //MAGIC STORE BY FAHAAN
    
    @SuppressWarnings("unchecked")
    Connection con1;
        ResultSet ls= null;
        PreparedStatement pst=null;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buynow = new javax.swing.JButton();
        backtostore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Totalprice", "PID", "Product_name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 450, 452, 102);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\91805\\Desktop\\3.PNG")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 610, 390);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Cart_details");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 410, 180, 30);

        buynow.setText("Buy now");
        buynow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buynowActionPerformed(evt);
            }
        });
        getContentPane().add(buynow);
        buynow.setBounds(330, 570, 110, 25);

        backtostore.setText("Back to Store");
        backtostore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtostoreActionPerformed(evt);
            }
        });
        getContentPane().add(backtostore);
        backtostore.setBounds(200, 570, 120, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buynowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buynowActionPerformed
        // TODO add your handling code here:
        order_confrim p = new order_confrim();
        p.setVisible(true);
        
    }//GEN-LAST:event_buynowActionPerformed

    private void backtostoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtostoreActionPerformed
        // TODO add your handling code here:
        homescreen q = new homescreen();
        q.setVisible(true);
    }//GEN-LAST:event_backtostoreActionPerformed

    /**
     * @param args the command line arguments
    
    */
    
    private void table_update() {
        int CC;
        try {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
                  
            PreparedStatement insert = con1.prepareStatement("SELECT * FROM cart");
            ResultSet Rs = insert.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
 
            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("Quantity"));
                    v2.add(Rs.getString("Totalprice"));
                    v2.add(Rs.getString("PID"));
                    v2.add(Rs.getString("Product_name"));
                   
                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtostore;
    private javax.swing.JButton buynow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
