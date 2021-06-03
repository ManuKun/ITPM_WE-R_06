
package timetablems;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class MainWorkTime extends javax.swing.JFrame {


    public MainWorkTime() {
        initComponents();
        
        setResizable(false);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Toppanel3 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        btnMgena = new javax.swing.JButton();
        btnAddna = new javax.swing.JButton();
        btnAddna1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Toppanel3.setBackground(new java.awt.Color(0, 153, 255));
        Toppanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton32.setBackground(new java.awt.Color(247, 227, 147));
        jButton32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton32.setText("Subjects");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32jButton1ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 11, -1, 46));

        jButton33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton33.setText("Home");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33jButton2ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 77, 45));

        jButton34.setBackground(new java.awt.Color(251, 149, 238));
        jButton34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton34.setText("Work Time");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34jButton3ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 11, -1, 46));

        jButton35.setBackground(new java.awt.Color(170, 221, 251));
        jButton35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton35.setText("Leturers");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35jButton4ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 11, -1, 46));

        jButton36.setBackground(new java.awt.Color(44, 253, 236));
        jButton36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton36.setText("Tags");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36jButton5ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 11, 79, 46));

        jButton37.setBackground(new java.awt.Color(246, 184, 113));
        jButton37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton37.setText("Sessions");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37jButton6ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 12, -1, 45));

        jButton38.setBackground(new java.awt.Color(169, 255, 155));
        jButton38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton38.setText("Students");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38jButton7ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 11, -1, 46));

        jButton39.setBackground(new java.awt.Color(255, 172, 172));
        jButton39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton39.setText("Locations");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39jButton8ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 11, -1, 46));

        jButton40.setBackground(new java.awt.Color(246, 253, 137));
        jButton40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton40.setText("Generate");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40jButton9ActionPerformed(evt);
            }
        });
        Toppanel3.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 11, -1, 46));

        getContentPane().add(Toppanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 70));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 954, -1));

        btnMgena.setBackground(new java.awt.Color(0, 102, 204));
        btnMgena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMgena.setForeground(new java.awt.Color(255, 255, 255));
        btnMgena.setText("Manage Not Available Times");
        btnMgena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMgenajButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMgena, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, 93));

        btnAddna.setBackground(new java.awt.Color(0, 102, 204));
        btnAddna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddna.setForeground(new java.awt.Color(255, 255, 255));
        btnAddna.setText("Add Work Times");
        btnAddna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddnajButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddna, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 220, 93));

        btnAddna1.setBackground(new java.awt.Color(0, 102, 204));
        btnAddna1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddna1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddna1.setText("Add Not Available Times");
        btnAddna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddna1jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddna1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 220, 93));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton32jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32jButton1ActionPerformed
        Subjects in = new Subjects();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton32jButton1ActionPerformed

    private void jButton33jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33jButton2ActionPerformed
        Dashboard in = new Dashboard();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton33jButton2ActionPerformed

    private void jButton34jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34jButton3ActionPerformed
        MainWorkTime in = new MainWorkTime();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton34jButton3ActionPerformed

    private void jButton35jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35jButton4ActionPerformed
        Lecturers in = new Lecturers();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton35jButton4ActionPerformed

    private void jButton36jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36jButton5ActionPerformed
        tags in = new tags();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton36jButton5ActionPerformed

    private void jButton37jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37jButton6ActionPerformed
        Sessions in = new Sessions();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton37jButton6ActionPerformed

    private void jButton38jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38jButton7ActionPerformed
        Student in = new Student();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton38jButton7ActionPerformed

    private void jButton39jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39jButton8ActionPerformed
        LocationMain in = new LocationMain();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton39jButton8ActionPerformed

    private void jButton40jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40jButton9ActionPerformed
        Generate in = new Generate();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton40jButton9ActionPerformed

    private void btnMgenajButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMgenajButton3ActionPerformed
        ManageNotAvailableTimes in = new ManageNotAvailableTimes();
        in.setVisible(true);
    }//GEN-LAST:event_btnMgenajButton3ActionPerformed

    private void btnAddnajButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddnajButton3ActionPerformed
        AddWorkingTimes in = new AddWorkingTimes();
        in.setVisible(true);
    }//GEN-LAST:event_btnAddnajButton3ActionPerformed

    private void btnAddna1jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddna1jButton3ActionPerformed
         AddNotAvailableTimes in = new AddNotAvailableTimes();
        in.setVisible(true);
    }//GEN-LAST:event_btnAddna1jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainWorkTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWorkTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWorkTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWorkTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWorkTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Toppanel3;
    private javax.swing.JButton btnAddna;
    private javax.swing.JButton btnAddna1;
    private javax.swing.JButton btnMgena;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
