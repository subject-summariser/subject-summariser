/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject.outline.summary;

/**
 *
 * @author laurabecker
 */
public class GenerateSummaryFrame3 extends javax.swing.JFrame {

    /**
     * Creates new form GenerateSummaryFrame3
     */
    public GenerateSummaryFrame3() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lantinghei TC", 0, 30)); // NOI18N
        jLabel1.setText("Generate a summary");
        jInternalFrame1.getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 80, 304, 42);

        jLabel2.setFont(new java.awt.Font("Lantinghei TC", 0, 15)); // NOI18N
        jLabel2.setText("Select the information you want to include:");
        jInternalFrame1.getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 160, 300, 22);

        jCheckBox1.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jCheckBox1.setText("Key Contacts");
        jInternalFrame1.getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(90, 190, 116, 24);

        jCheckBox2.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jCheckBox2.setText("Assessment Type");
        jInternalFrame1.getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(90, 220, 146, 24);

        jCheckBox3.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jCheckBox3.setText("Due Dates");
        jInternalFrame1.getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(90, 250, 99, 24);

        jCheckBox4.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jCheckBox4.setText("Weighting");
        jInternalFrame1.getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(260, 190, 95, 24);

        jCheckBox5.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jCheckBox5.setText("Required Texts");
        jInternalFrame1.getContentPane().add(jCheckBox5);
        jCheckBox5.setBounds(260, 220, 129, 24);

        jCheckBox6.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jCheckBox6.setText("Pass Criteria");
        jInternalFrame1.getContentPane().add(jCheckBox6);
        jCheckBox6.setBounds(260, 250, 113, 24);
        jInternalFrame1.getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 6, 0, 0);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subject/outline/summary/Images/llama.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jInternalFrame1.getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 10, 60, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subject/outline/summary/Images/Generate box.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jInternalFrame1.getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 120, 340, 170);

        jButton1.setFont(new java.awt.Font("Lantinghei TC", 0, 13)); // NOI18N
        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton1);
        jButton1.setBounds(190, 290, 97, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new GenerateSummaryFrame4().setVisible(true);
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
            java.util.logging.Logger.getLogger(GenerateSummaryFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateSummaryFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateSummaryFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateSummaryFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateSummaryFrame3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
