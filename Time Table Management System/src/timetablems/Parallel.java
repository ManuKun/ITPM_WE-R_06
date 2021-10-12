/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablems;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 94763
 */
public final class Parallel extends javax.swing.JFrame {
    
    
    
     
    //  Connection conn = null;
    //  PreparedStatement pst  = null;
    ResultSet rs= null;

    /**
     * Creates new form NewJFrame
     */
    public Parallel() {
        initComponents();
         conn =  ManageTag.ConnectDb();
        load();
        setResizable(false);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
    }

    
      Connection conn;
      PreparedStatement pst;
      DefaultTableModel df ;
    
    
    
    
    
    
    
    
    
      public static Connection ConnectDb()
    {
        
        try
            
        {
            Class.forName("org.sqlite.JDBC");
                     Connection conn = DriverManager.getConnection("jdbc:sqlite:ttms.db");
                     return conn;
        }
        catch(Exception e)
                {
                    
                    JOptionPane.showMessageDialog(null, e);
                    return null;
                }
                
    }
      
      
               
    public void load ()
            
    {
        
                   String sql = "Select* from parsessions";
        
        int a;
        try {
            pst  = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a= rd.getColumnCount();
            df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            
            
            while(rs.next())
            {
            
            Vector v2 = new Vector();
             for(int i=1; i<=a; i++)
                 
                 
             {
                      v2.add(rs.getInt("p_id")); 
                 v2.add(rs.getString("s1_lecname1"));
                  v2.add(rs.getString("s1_lecname2"));
                   v2.add(rs.getString("s2_lecname1"));
                   v2.add(rs.getString("s2_lecname2"));
                  v2.add(rs.getString("s1_subcode"));
                   v2.add(rs.getString("s2_subcode"));
                  v2.add(rs.getString("s1_groupid"));
                   v2.add(rs.getString("s2_groupid"));
                  v2.add(rs.getString("s1_tag"));
                 v2.add(rs.getString("s2_tag"));
                                    
             
             }
            df.addRow(v2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 143, 52));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Session 1 Lec 1", "Session 1 Lec2", "Session 2  Lec 1", "Session 2 lec 2", "Session 1 Sub-Code", "Session 2  Sub-Code", "Session 1 Gro-ID", "Session 2 Gro-ID", "Session 1 Tag", "Session 2 Tag"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 910, 262));

        Delete.setBackground(new java.awt.Color(0, 51, 255));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 420, 244, 64));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Parallel Sessions");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 20, 162, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         
         session_manage  jf1 = new  session_manage ();
             jf1.show();
             
             dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        
        
        
        
        
        
        
            
           df = (DefaultTableModel)jTable1.getModel();
                               
                               int selected = jTable1.getSelectedRow();
                         
                              int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
                                
                              int X =   JOptionPane.showConfirmDialog(null,"do you want delete","Delete",JOptionPane.YES_NO_OPTION);
        
        
            
                              if (X==0)
                              {
                                  try {
                                      
                                      
                                          pst =  conn.prepareStatement("Delete from parsessions where  p_id = ?");
                                         pst.setInt(1,id);
                                         pst.executeUpdate();
                                         
                                            JOptionPane.showMessageDialog(this,"parlallel  session deleted");
                                            
                                              
                          // TagN.setText("");
                            //  TagC.setText("");
                            //  TBox.setSelectedItem("");
                              
                                         
                                             
                                            load(); 
                                         
                                  }
                                  
                                        
         catch (SQLException ex) {
            Logger.getLogger( ManageTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                                  
                              }
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Parallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parallel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parallel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
