import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
    }

    //MAGIC STORE BY FAHAAN
    
    @SuppressWarnings("unchecked")
     Connection con1;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel6.setText("Admin Details");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 450, 78, 16);

        jLabel7.setText("Admin_id");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(190, 480, 53, 16);

        jLabel8.setText("Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(190, 540, 55, 16);
        getContentPane().add(a);
        a.setBounds(330, 480, 80, 22);
        getContentPane().add(b);
        b.setBounds(330, 540, 80, 22);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 580, 63, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\91805\\Desktop\\3.PNG")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
            Statement st = con1.createStatement();

                String Admin_id = a.getText();
                String Password = b.getText();
                String sel = "select * from admin where Admin_id = '" + Admin_id + "' and Password = '" + Password + "';";
                ResultSet rs = st.executeQuery(sel);
                JOptionPane.showMessageDialog(this,"Login Successfull");
            if (rs.next()) {
       
                    Product h = new Product();
                    h.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                a.setText("");
                b.setText("");
            }
                con1.close();   //close the connection
            } catch (SQLException ce) {
                System.out.println("Error... " + ce);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
