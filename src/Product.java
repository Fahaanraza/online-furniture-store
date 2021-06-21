
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 91805
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
        table_update();
       
    }
    

    //MAGIC STORE BY FAHAAN
    
    @SuppressWarnings("unchecked")
    Connection con1;
    ResultSet rs= null;
    PreparedStatement pst=null;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        pname = new javax.swing.JLabel();
        pid = new javax.swing.JLabel();
        pri = new javax.swing.JLabel();
        var = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addproduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenu8.setText("jMenu8");

        jMenu10.setText("jMenu10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pname.setText("Product_name");
        getContentPane().add(pname);
        pname.setBounds(100, 450, 82, 16);

        pid.setText("Product_ID");
        getContentPane().add(pid);
        pid.setBounds(120, 500, 62, 16);

        pri.setText("Price");
        getContentPane().add(pri);
        pri.setBounds(160, 550, 28, 16);

        var.setText("variant");
        getContentPane().add(var);
        var.setBounds(150, 590, 39, 16);

        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        getContentPane().add(a);
        a.setBounds(230, 440, 160, 22);
        getContentPane().add(b);
        b.setBounds(230, 490, 160, 22);
        getContentPane().add(c);
        c.setBounds(230, 550, 160, 22);
        getContentPane().add(d);
        d.setBounds(230, 590, 160, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Product");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 400, 83, 28);

        addproduct.setText("Add Product");
        addproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductActionPerformed(evt);
            }
        });
        getContentPane().add(addproduct);
        addproduct.setBounds(160, 630, 101, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(490, 230, 676, 359);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel6.setText("Product Inventry");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(680, 170, 360, 50);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(140, 680, 53, 25);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(220, 680, 69, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\91805\\Desktop\\3.PNG")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-80, 10, 540, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_update() {
        int CC;
        try {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
                  
            PreparedStatement insert = con1.prepareStatement("SELECT * FROM Product");
            ResultSet Rs = insert.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
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
    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void addproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductActionPerformed
        // TODO add your handling code here:
        
        try {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
            Statement st = con1.createStatement();

            String Product_name = a.getText();
            int Product_ID = Integer.parseInt(b.getText());
            int Price = Integer.parseInt(c.getText());
            String variant = d.getText();
            st.executeUpdate("insert into product values ('"+Product_ID+"','"+Price+"','"+Product_name+"','"+variant+"');");
            JOptionPane.showMessageDialog(this,"Product added Successfull");
            a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
            con1.close();

            // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_addproductActionPerformed

    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();      
        a.setText(model.getValueAt(selectedIndex, 2).toString());
        b.setText(model.getValueAt(selectedIndex, 0).toString());
        c.setText(model.getValueAt(selectedIndex, 1).toString());
        d.setText(model.getValueAt(selectedIndex, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        
        try {
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
            Statement st = con1.createStatement();
                
                String Pn = a.getText();
                int pi =  Integer.parseInt(b.getText());
                int pr =  Integer.parseInt(c.getText());
                String vari = d.getText();
                
                
                String ins = "update product SET Price="+pr+",Product_name='"+Pn+"',Variant='"+vari+"' where PID = "+pi+";";
                st.executeUpdate(ins);
                table_update();
                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
                
                JOptionPane.showMessageDialog(null, "product updated");
                
                con1.close();   //close the connection
            } catch (SQLException ce) {
                JOptionPane.showMessageDialog(null,ce);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }    
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try {
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
            Statement st = con1.createStatement();
                
                String pId = b.getText();
                
                
                String ins = "delete from product where PID = "+pId+";";
                st.executeUpdate(ins);
                table_update();
                b.setText("");
                a.setText("");
                c.setText("");
                d.setText("");
                JOptionPane.showMessageDialog(null, "product deleted");
                con1.close();   //close the connection
            } catch (SQLException ce) {
                JOptionPane.showMessageDialog(null,ce);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        
        
        
        
        
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JButton addproduct;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel pid;
    private javax.swing.JLabel pname;
    private javax.swing.JLabel pri;
    private javax.swing.JLabel var;
    // End of variables declaration//GEN-END:variables
}
