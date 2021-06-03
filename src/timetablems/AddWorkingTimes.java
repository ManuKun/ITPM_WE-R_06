package timetablems;

import timetablems.DbConnection_1;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddWorkingTimes extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public AddWorkingTimes() {
        initComponents();
        
        //Database Connection
        con = DbConnection_1.ConnectionDB();
        
        setResizable(false);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        
    }
    
    //Close current JFrame when close button pressed
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wNo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        startT = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tSlot = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        mon = new javax.swing.JCheckBox();
        tue = new javax.swing.JCheckBox();
        wed = new javax.swing.JCheckBox();
        thu = new javax.swing.JCheckBox();
        fri = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        sun = new javax.swing.JCheckBox();
        hr = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("                          Add Working Days & Hours");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 721, 61));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("No of Working Days");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 97, 145, 30));

        wNo.setBackground(new java.awt.Color(240, 240, 240));
        wNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        wNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wNoActionPerformed(evt);
            }
        });
        jPanel1.add(wNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 65, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Working Days");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 167, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Working Time Per Day");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        startT.setBackground(new java.awt.Color(240, 240, 240));
        startT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:30", "9:00", "9:30", "10:00" }));
        startT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTActionPerformed(evt);
            }
        });
        jPanel1.add(startT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Starting Time");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 98, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Time Slots");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        tSlot.setBackground(new java.awt.Color(240, 240, 240));
        tSlot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tSlot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 hour", "30 minutes" }));
        tSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSlotActionPerformed(evt);
            }
        });
        jPanel1.add(tSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        btnSave.setBackground(new java.awt.Color(0, 102, 204));
        btnSave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 100, 34));

        btnEdit.setBackground(new java.awt.Color(0, 102, 204));
        btnEdit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("View");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 93, 34));

        btnDelete.setBackground(new java.awt.Color(0, 102, 204));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete All");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 90, 35));

        btnClose.setBackground(new java.awt.Color(0, 102, 204));
        btnClose.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 93, 34));

        mon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        mon.setText("Monday");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        jPanel1.add(mon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        tue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tue.setText("Tuesday");
        tue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tueActionPerformed(evt);
            }
        });
        jPanel1.add(tue, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        wed.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        wed.setText("Wednesday");
        wed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wedActionPerformed(evt);
            }
        });
        jPanel1.add(wed, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        thu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        thu.setText("Thursday");
        thu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuActionPerformed(evt);
            }
        });
        jPanel1.add(thu, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        fri.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fri.setText("Friday");
        fri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friActionPerformed(evt);
            }
        });
        jPanel1.add(fri, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        sat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sat.setText("Saturday");
        sat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satActionPerformed(evt);
            }
        });
        jPanel1.add(sat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        sun.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sun.setText("Sunday");
        sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunActionPerformed(evt);
            }
        });
        jPanel1.add(sun, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        hr.setBackground(new java.awt.Color(240, 240, 240));
        hr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07Hours ", "07Hours 30Minutes", "08Hours", "08Hours 30Minutes", "09Hours", "09Hours 30Minutes", "10Hours", "10Hours 30Minutes", "11Hours", "11Hours 30Minutes", "12Hours" }));
        hr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrActionPerformed(evt);
            }
        });
        jPanel1.add(hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 166, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrActionPerformed

    private void sunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunActionPerformed

    }//GEN-LAST:event_sunActionPerformed

    private void satActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satActionPerformed

    }//GEN-LAST:event_satActionPerformed

    private void friActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friActionPerformed

    }//GEN-LAST:event_friActionPerformed

    private void thuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thuActionPerformed

    }//GEN-LAST:event_thuActionPerformed

    private void wedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wedActionPerformed

    }//GEN-LAST:event_wedActionPerformed

    private void tueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tueActionPerformed

    }//GEN-LAST:event_tueActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed

    }//GEN-LAST:event_monActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int p = JOptionPane.showConfirmDialog(null,"<html><br><p style=\"text-align:center;\">This will Delete All Saved Records!</p><p style=\"text-align:center;\"> Do You Want to Continue?</p><br></html>","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

        if(p==0){
            String sql ="Delete FROM worktime";

            try{
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"All Records Successfully Deleted!");

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Something Went Wrong!","Deletion Failed!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        ViewWorkTimes in = new ViewWorkTimes();
        in.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try{
            String sql = "INSERT INTO worktime (w_id,nof_days,w_days,w_time,time_slots,st_time) VALUES(?,?,?,?,?,?);";
            pst = con.prepareStatement(sql);

            String wdn = wNo.getSelectedItem().toString();
            pst.setString(2,wdn);

            String wds = "";
            if(mon.isSelected()){
                wds+=mon.getText()+" ";
            }
            if(tue.isSelected()){
                wds+=tue.getText()+" ";
            }
            if(wed.isSelected()){
                wds+=wed.getText()+" ";
            }
            if(thu.isSelected()){
                wds+=thu.getText()+" ";
            }
            if(fri.isSelected()){
                wds+=fri.getText()+" ";
            }
            if(sat.isSelected()){
                wds+=sat.getText()+" ";
            }
            if(sun.isSelected()){
                wds+=sun.getText()+" ";
            }
            pst.setString(3, wds);

            String wt = hr.getSelectedItem().toString();
            pst.setString(4,wt);

            String ts = tSlot.getSelectedItem().toString();
            pst.setString(5,ts);

            String st = startT.getSelectedItem().toString();
            pst.setString(6,st);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Records Saved Successfully!");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong!","Insertion Failed!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSlotActionPerformed

    }//GEN-LAST:event_tSlotActionPerformed

    private void startTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startTActionPerformed

    private void wNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wNoActionPerformed

    }//GEN-LAST:event_wNoActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        close();
    }//GEN-LAST:event_btnCloseActionPerformed


    public static void main(String args[]) {
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWorkingTimes().setVisible(true);
            }
        });
     
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox fri;
    private javax.swing.JComboBox<String> hr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox mon;
    private javax.swing.JCheckBox sat;
    private javax.swing.JComboBox<String> startT;
    private javax.swing.JCheckBox sun;
    private javax.swing.JComboBox<String> tSlot;
    private javax.swing.JCheckBox thu;
    private javax.swing.JCheckBox tue;
    private javax.swing.JComboBox<String> wNo;
    private javax.swing.JCheckBox wed;
    // End of variables declaration//GEN-END:variables



}

