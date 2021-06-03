/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablems;

import timetablems.DbConnection_1;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Akila
 */
public class ViewWorkTimes extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public ViewWorkTimes() {
        initComponents();
        
        //Database Connection
        con = DbConnection_1.ConnectionDB();
        
        //Center the screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        //Close without affecting other windows
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        show_days();
    }
    
    //Close current JFrame when close button pressed
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    
    //Get data into an arraylist
    public ArrayList<WorkTime> dayList(){
    
        ArrayList<WorkTime> dayList = new ArrayList<>();
        
        try{
        
            String sql = "SELECT * FROM worktime";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            WorkTime wt;
            while(rs.next()){
                wt = new WorkTime(rs.getInt("w_id"),rs.getInt("nof_days"),rs.getString("w_days"),rs.getString("w_time"),rs.getString("time_slots"),rs.getString("st_time"));
                dayList.add(wt);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong");
            
        }
        return dayList;
    }
    
    //Function to display data
    public void show_days(){
        ArrayList<WorkTime> list = dayList();
        DefaultTableModel model = (DefaultTableModel)dayTable.getModel();
        Object[] row = new Object[6];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getW_id();
            row[1]=list.get(i).getNof_days();
            row[2]=list.get(i).getW_days();
            row[3]=list.get(i).getW_time();
            row[4]=list.get(i).getTime_slots();
            row[5]=list.get(i).getSt_time();
            model.addRow(row);
        }
    }
    
    

           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hr = new javax.swing.JComboBox<>();
        startT = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tSlot = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        mon = new javax.swing.JCheckBox();
        tue = new javax.swing.JCheckBox();
        wed = new javax.swing.JCheckBox();
        thu = new javax.swing.JCheckBox();
        fri = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        sun = new javax.swing.JCheckBox();
        wNo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dayTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Working Days");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 110, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Working Time Per Day");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        hr.setBackground(new java.awt.Color(240, 240, 240));
        hr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07Hours ", "07Hours 30Minutes", "08Hours", "08Hours 30Minutes", "09Hours", "09Hours 30Minutes", "10Hours", "10Hours 30Minutes", "11Hours", "11Hours 30Minutes", "12Hours" }));
        hr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrActionPerformed(evt);
            }
        });
        jPanel2.add(hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 154, -1));

        startT.setBackground(new java.awt.Color(240, 240, 240));
        startT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:30", "9:00" }));
        startT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTActionPerformed(evt);
            }
        });
        jPanel2.add(startT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 65, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Starting Time");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 100, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Time Slots");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 80, -1));

        tSlot.setBackground(new java.awt.Color(240, 240, 240));
        tSlot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tSlot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 hour", "30 minutes" }));
        tSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSlotActionPerformed(evt);
            }
        });
        jPanel2.add(tSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 102, 204));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 100, 34));

        btnDelete.setBackground(new java.awt.Color(0, 102, 204));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 93, 34));

        btnClose.setBackground(new java.awt.Color(0, 102, 204));
        btnClose.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 93, 34));

        mon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        mon.setText("Monday");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        jPanel2.add(mon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        tue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tue.setText("Tuesday");
        tue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tueActionPerformed(evt);
            }
        });
        jPanel2.add(tue, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        wed.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        wed.setText("Wednesday");
        wed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wedActionPerformed(evt);
            }
        });
        jPanel2.add(wed, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        thu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        thu.setText("Thursday");
        thu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuActionPerformed(evt);
            }
        });
        jPanel2.add(thu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        fri.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fri.setText("Friday");
        fri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friActionPerformed(evt);
            }
        });
        jPanel2.add(fri, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, -1, -1));

        sat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sat.setText("Saturday");
        sat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satActionPerformed(evt);
            }
        });
        jPanel2.add(sat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        sun.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sun.setText("Sunday");
        sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunActionPerformed(evt);
            }
        });
        jPanel2.add(sun, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        wNo.setBackground(new java.awt.Color(240, 240, 240));
        wNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        wNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wNoActionPerformed(evt);
            }
        });
        jPanel2.add(wNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 65, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("No of Working Days");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 140, -1));

        dayTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dayTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No of Working Days", "Working Days", "Working Time Per Day", "Time slot", "Starting Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dayTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dayTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 683, 67));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Working Days & Hours");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 61));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 740, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dayTableMouseClicked
        int i = dayTable.getSelectedRow();
        TableModel model = dayTable.getModel();

        String nof_days = model.getValueAt(i, 1).toString();
        switch(nof_days){
            case "1":
            wNo.setSelectedIndex(0);
            break;
            case "2":
            wNo.setSelectedIndex(1);
            break;
            case "3":
            wNo.setSelectedIndex(2);
            break;
            case "4":
            wNo.setSelectedIndex(3);
            break;
            case "5":
            wNo.setSelectedIndex(4);
            break;
            case "6":
            wNo.setSelectedIndex(5);
            break;
            case "7":
            wNo.setSelectedIndex(6);
            break;
        }

        String  w_days = model.getValueAt(i, 2).toString();
        switch(w_days){
            case "Monday":
            mon.setSelected(true);
            break;
            case "Tuesday":
            tue.setSelected(true);
            break;
            case "Wednesday":
            wed.setSelected(true);
            break;
            case "Thursday":
            thu.setSelected(true);
            break;
            case "Friday":
            fri.setSelected(true);
            break;
            case "Saturday":
            sat.setSelected(true);
            break;
            case "Sunday":
            sun.setSelected(true);

            break;
            //                default:
            //                    mon.setSelected(false);
            //                    tue.setSelected(false);
            //                    wed.setSelected(false);
            //                    thu.setSelected(false);
            //                    fri.setSelected(false);
            //                    sat.setSelected(false);
            //                    sun.setSelected(false);
            //                    break;
        }

        String  w_time = model.getValueAt(i, 3).toString();
        switch(w_time){
            case "07Hours":
            hr.setSelectedIndex(0);
            break;
            case "07Hours 30Minutes":
            hr.setSelectedIndex(1);
            break;
            case "08Hours":
            hr.setSelectedIndex(2);
            break;
            case "08Hours 30Minutes":
            hr.setSelectedIndex(3);
            break;
            case "09Hours":
            hr.setSelectedIndex(4);
            break;
            case "09Hours 30Minutes":
            hr.setSelectedIndex(5);
            break;
            case "10Hours":
            hr.setSelectedIndex(6);
            break;
            case "10Hours 30Minutes":
            hr.setSelectedIndex(7);
            break;
            case "11Hours":
            hr.setSelectedIndex(8);
            break;
            case "11Hours 30Minutes":
            hr.setSelectedIndex(9);
            break;
            case "12Hours":
            hr.setSelectedIndex(10);
            break;
            default:
            hr.setSelectedIndex(4);
            break;
        }

        String  time_slots = model.getValueAt(i, 4).toString();
        switch(time_slots){
            case "1 Hour":
            tSlot.setSelectedIndex(0);
            break;
            case "30 Minutes":
            tSlot.setSelectedIndex(1);
            break;

        }

        String  st_time = model.getValueAt(i, 5).toString();
        switch(st_time){
            case "8:30":
            tSlot.setSelectedIndex(0);
            break;
            case "9:00":
            tSlot.setSelectedIndex(1);
            break;
        }
    }//GEN-LAST:event_dayTableMouseClicked

    private void wNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wNoActionPerformed

    }//GEN-LAST:event_wNoActionPerformed

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

        int p = JOptionPane.showConfirmDialog(null,"<html><br><p style=\"text-align:center;\"> Do You Want to Delete Selected Records?</p><br></html>","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(p==0){  
          try{
            int row = dayTable.getSelectedRow();
            String value = (dayTable.getModel().getValueAt(row, 0).toString());

            String sql = "DELETE FROM worktime where w_id="+value;
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            
            //Auto Refresh Table
            DefaultTableModel model = (DefaultTableModel) dayTable.getModel();
            model.setRowCount(0);
            show_days();

            JOptionPane.showMessageDialog(null,"Successfully Deleted!");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong! "+e);
            System.out.print(e);
        }
         
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try{
            int row = dayTable.getSelectedRow();
            String value = (dayTable.getModel().getValueAt(row, 0).toString());

            String sql = "UPDATE worktime SET nof_days=?,w_days=?,w_time=?,time_slots=?,st_time=? where w_id="+value;
            pst = con.prepareStatement(sql);

            String wdn = wNo.getSelectedItem().toString();
            pst.setString(1,wdn);

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
            pst.setString(2, wds);

            String wt = hr.getSelectedItem().toString();
            pst.setString(3,wt);

            String ts = tSlot.getSelectedItem().toString();
            pst.setString(4,ts);

            String st = startT.getSelectedItem().toString();
            pst.setString(5,st);

            pst.executeUpdate();

            //Auto Refresh Table
            DefaultTableModel model = (DefaultTableModel) dayTable.getModel();
            model.setRowCount(0);
            show_days();

            JOptionPane.showMessageDialog(null,"Successfully Updated!");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong! "+e);
            System.out.print(e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSlotActionPerformed

    }//GEN-LAST:event_tSlotActionPerformed

    private void startTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startTActionPerformed

    private void hrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        close();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(ViewWorkTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewWorkTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewWorkTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewWorkTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewWorkTimes().setVisible(true);
            }
        });
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable dayTable;
    private javax.swing.JCheckBox fri;
    private javax.swing.JComboBox<String> hr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
