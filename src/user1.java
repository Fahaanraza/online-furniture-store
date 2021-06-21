
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class user1 extends javax.swing.JFrame {

    /**
     * Creates new form user1
     */
    public user1() {
        initComponents();
    }

    //MAGIC STORE BY FAHAAN
    
    @SuppressWarnings("unchecked")
    Connection con1;
    PreparedStatement insert;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        c = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        d = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        e = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        f = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setText("Email");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 540, 90, 16);
        getContentPane().add(c);
        c.setBounds(190, 530, 386, 22);

        jLabel4.setText("Phn_No");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 580, 100, 16);
        getContentPane().add(d);
        d.setBounds(190, 570, 386, 22);

        jLabel5.setText("Address");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 610, 110, 16);
        getContentPane().add(e);
        e.setBounds(190, 610, 386, 22);

        jLabel6.setText("Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 640, 90, 16);

        jLabel1.setText("User_id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 460, 120, 16);
        getContentPane().add(f);
        f.setBounds(190, 640, 386, 22);
        getContentPane().add(a);
        a.setBounds(190, 460, 380, 22);

        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(100, 670, 77, 25);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 500, 110, 16);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setText("User");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(220, 400, 150, 40);
        getContentPane().add(b);
        b.setBounds(190, 490, 386, 22);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\91805\\Desktop\\3.PNG")); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 620, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed

        try {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_furniture", "root", "0786");  //establish the connection
            Class.forName("com.mysql.cj.jdbc.Driver");  //load and register the driver
            Statement st = con1.createStatement();

            String User_id = a.getText();
            String Password = b.getText();
            String Email = c.getText();
            int Phn_No = Integer.parseInt(d.getText());
            String Address = e.getText();
            String Name = f.getText();
            st.executeUpdate("insert into user values ('"+Name+"','"+Email+"','"+User_id+"','"+Password+"','"+Address+"','"+Phn_No+"');");

            JOptionPane.showMessageDialog(this,"Registration Successfull");
            homescreen h = new homescreen();
                    h.setVisible(true);
            con1.close();
            

            // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user1.class.getName()).log(Level.SEVERE, null, ex);

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_signupActionPerformed

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
            java.util.logging.Logger.getLogger(user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private javax.swing.JTextField e;
    private javax.swing.JTextField f;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
