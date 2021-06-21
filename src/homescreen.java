
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class homescreen extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public homescreen() {
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
        b = new javax.swing.JTable();
        textfield = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        addtocart = new javax.swing.JButton();
        buynow = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        bb = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        e = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        b.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_id", "Price", "Product_name", "variant"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        b.setColumnSelectionAllowed(true);
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(b);
        b.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 380, 630, 200);

        textfield.setBorder(null);
        getContentPane().add(textfield);
        textfield.setBounds(430, 350, 110, 20);

        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(550, 350, 71, 25);

        addtocart.setText("Add to Cart");
        addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartActionPerformed(evt);
            }
        });
        getContentPane().add(addtocart);
        addtocart.setBounds(780, 400, 97, 25);

        buynow.setText("Buy now");
        buynow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buynowActionPerformed(evt);
            }
        });
        getContentPane().add(buynow);
        buynow.setBounds(680, 400, 81, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\91805\\Desktop\\3.PNG")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 380);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Product Selected");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(710, 100, 190, 20);

        jLabel3.setText("Product_name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 190, 120, 30);

        jLabel4.setText("Product_ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(680, 230, 90, 30);

        jLabel5.setText("Price ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(700, 280, 32, 16);

        jLabel6.setText("variant");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(700, 320, 41, 16);
        getContentPane().add(a);
        a.setBounds(790, 200, 120, 22);
        getContentPane().add(bb);
        bb.setBounds(790, 240, 120, 22);
        getContentPane().add(c);
        c.setBounds(790, 280, 120, 22);
        getContentPane().add(d);
        d.setBounds(790, 320, 120, 22);

        logout.setText("Log out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(890, 0, 75, 25);

        jLabel7.setText("Quantity");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(700, 360, 60, 16);

        e.setText("1");
        getContentPane().add(e);
        e.setBounds(790, 360, 120, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        int CC;
        try {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
            Statement st = con1.createStatement();
            String tf=textfield.getText();
            PreparedStatement insert = con1.prepareStatement("SELECT * FROM product WHERE product_name LIKE '%"+tf+"%'; ");
            ResultSet Rs = insert.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) b.getModel();
            DFT.setRowCount(0);
 
            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("PID"));
                    v2.add(Rs.getString("Price"));
                    v2.add(Rs.getString("Product_name"));
                    v2.add(Rs.getString("variant"));
                }
                DFT.addRow(v2);
            }       
           }catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }   
    }//GEN-LAST:event_searchActionPerformed

    private void bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) b.getModel();
        int selectedIndex = b.getSelectedRow();      
        a.setText(model.getValueAt(selectedIndex, 2).toString());
        bb.setText(model.getValueAt(selectedIndex, 0).toString());
        c.setText(model.getValueAt(selectedIndex, 1).toString());
        d.setText(model.getValueAt(selectedIndex, 3).toString());
        
    }//GEN-LAST:event_bMouseClicked

    private void addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartActionPerformed
        // TODO add your handling code here:
        cart h = new cart();
        h.setVisible(true);
        
        try {
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
                Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
                Statement st = con1.createStatement();
                
                String Product_id = bb.getText();
                String Product_name = a.getText();
                int Price =  Integer.parseInt(c.getText());
                int Quantity = Integer.parseInt(e.getText());
                String ins = "insert into cart (Quantity, Totalprice, PID, Product_name) values ("+Quantity+","+Price+",'"+Product_id+"','"+Product_name+"');";
                
                st.executeUpdate(ins);
                table_update();
                a.setText("");
                bb.setText("");
                c.setText("");
                d.setText("");
                
                JOptionPane.showMessageDialog(null, "product added to cart");
                con1.close();   //close the connection
            } catch (SQLException ce) {
                JOptionPane.showMessageDialog(null,ce);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        
        
        
        
        
    }//GEN-LAST:event_addtocartActionPerformed

    private void buynowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buynowActionPerformed
        // TODO add your handling code here:
        order_confrim p = new order_confrim();
        p.setVisible(true);
        
        
        
    }//GEN-LAST:event_buynowActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog("logout Successfull");
        menu r = new menu();
        r.setVisible(true);
        
    }//GEN-LAST:event_logoutActionPerformed

    private void table_update() {
        int CC;
        try {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
                  
            PreparedStatement insert = con1.prepareStatement("SELECT * FROM product");
            ResultSet Rs = insert.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) b.getModel();
            DFT.setRowCount(0);
 
            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("PID"));
                    v2.add(Rs.getString("Price"));
                    v2.add(Rs.getString("Product_name"));
                    v2.add(Rs.getString("variant"));
                   
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
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homescreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JButton addtocart;
    private javax.swing.JTable b;
    private javax.swing.JTextField bb;
    private javax.swing.JButton buynow;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private javax.swing.JTextField e;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton search;
    private javax.swing.JTextField textfield;
    // End of variables declaration//GEN-END:variables
}
