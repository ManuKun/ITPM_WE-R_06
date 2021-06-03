/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetablems;

import java.awt.Component;
import timetablems.DbConnection_1;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ManageNotAvailableTimes extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DefaultTableModel df;
    
    /** Creates new form ManageNotAvailableTimes */
    public ManageNotAvailableTimes() {
        initComponents();
        
        con = DbConnection_1.ConnectionDB();
        
       setResizable(false);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Retrieve data to the table
        show_na_table();
        
         lCombo();
        groupCombo();
        subGroupCombo();
        locCombo();
        sCombo();
    }
    
    
    //Close current JFrame when close button pressed
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    //Get not available data into an arraylist
    public ArrayList<NAtime> naList(){
    
        ArrayList<NAtime> naList = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM not_available";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            NAtime nat;
            while(rs.next()){
                nat = new NAtime(rs.getInt("na_id"),rs.getString("lecName"),rs.getString("stgroup"),rs.getString("subGroup"),rs.getString("sessionSign"),rs.getString("day"),rs.getString("room"),rs.getString("startTime"),rs.getString("endTime"));
                naList.add(nat);
            } 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Something Went Wrong!","Something Went Wrong!",JOptionPane.WARNING_MESSAGE);
        }
        return naList;
    }
    
    //Function to display data 
    public void show_na_table(){
        ArrayList<NAtime> list = naList();
        DefaultTableModel model = (DefaultTableModel)naTable.getModel();
        Object[] row = new Object[9];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getNa_id();
            row[1]=list.get(i).getLecName();
            row[2]=list.get(i).getStgroup();
            row[3]=list.get(i).getSubGroup();
            row[4]=list.get(i).getSessionSign();
            row[5]=list.get(i).getDay();
            row[6]=list.get(i).getRoom();
            row[7]=list.get(i).getStartTime();
            row[8]=list.get(i).getEndTime();
            model.addRow(row);
        }
    }
    
        
    //Getting the name of the lecturer
    private void lCombo(){
        
        try{
        
            String sql = "SELECT * FROM lecturer";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            
                String name=rs.getString("name");
                lectCombo.addItem(name);
            
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    //Getting group IDs    
    private void groupCombo(){
        
        try{
        
            String sql = "SELECT * FROM student";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            
                String name=rs.getString("groupid");
                groupCombo.addItem(name);
            
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    //Getting sub group IDs    
    private void subGroupCombo(){
        
        try{
        
            String sql = "SELECT * FROM student";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            
                String name=rs.getString("subgroupid");
                subGroupCombo.addItem(name);
            
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    //Getting room   
    private void locCombo(){
        
        try{
        
            String sql = "SELECT * FROM location";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            
                String name=rs.getString("room");
                locCombo.addItem(name);
            
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    //Getting session   
    private void sCombo(){
        
        try{
        
            String sql = "SELECT * FROM Session";
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            
                String name=rs.getString("alldetails");
                sCombo.addItem(name);
            
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    
    //Reset values
    private void resetFields(){
    
        lectCombo.setSelectedIndex(0);
        groupCombo.setSelectedIndex(0);
        subGroupCombo.setSelectedIndex(0);
        sCombo.setSelectedIndex(0);
        dayCombo.setSelectedIndex(0);
        locCombo.setSelectedIndex(0);
        startCombo.setSelectedIndex(0);
        endCombo.setSelectedIndex(0);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lectCombo = new javax.swing.JComboBox<>();
        groupCombo = new javax.swing.JComboBox<>();
        subGroupCombo = new javax.swing.JComboBox<>();
        sCombo = new javax.swing.JComboBox<>();
        dayCombo = new javax.swing.JComboBox<>();
        locCombo = new javax.swing.JComboBox<>();
        startCombo = new javax.swing.JComboBox<>();
        endCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        naTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Select Session");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 146, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Select Group");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 140, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Select Sub Group");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 140, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Select Room");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 106, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Select Day");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 116, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Start Time");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 79, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("End Time");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 67, 20));

        btnUpdate.setBackground(new java.awt.Color(0, 102, 204));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 93, 34));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Select Lecturer");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, 20));

        btnDelete.setBackground(new java.awt.Color(0, 102, 204));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 93, 34));

        btnClose.setBackground(new java.awt.Color(0, 102, 204));
        btnClose.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 93, 34));

        btnReset.setBackground(new java.awt.Color(0, 102, 204));
        btnReset.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset All");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 93, 34));

        lectCombo.setBackground(new java.awt.Color(240, 240, 240));
        lectCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectComboActionPerformed(evt);
            }
        });
        jPanel2.add(lectCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 160, -1));

        groupCombo.setBackground(new java.awt.Color(240, 240, 240));
        groupCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        groupCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboActionPerformed(evt);
            }
        });
        jPanel2.add(groupCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 160, -1));

        subGroupCombo.setBackground(new java.awt.Color(240, 240, 240));
        subGroupCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subGroupCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subGroupComboActionPerformed(evt);
            }
        });
        jPanel2.add(subGroupCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 160, -1));

        sCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(sCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 300, -1));

        dayCombo.setBackground(new java.awt.Color(240, 240, 240));
        dayCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dayCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        dayCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboActionPerformed(evt);
            }
        });
        jPanel2.add(dayCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 170, -1));

        locCombo.setBackground(new java.awt.Color(240, 240, 240));
        locCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locComboActionPerformed(evt);
            }
        });
        jPanel2.add(locCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 170, -1));

        startCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30" }));
        jPanel2.add(startCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        endCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        endCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30" }));
        jPanel2.add(endCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, -1, -1));

        naTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        naTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        naTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecturer", "Group", "Sub Group", "Session", "Day", "Room", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        naTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(naTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 774, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Manage Not Available Times");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 314, 61));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 220, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Search Lecturers");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 120, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void naTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naTableMouseClicked
        df = (DefaultTableModel)naTable.getModel();

        int selected = naTable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
        String name = naTable.getValueAt(selected, 1).toString();
            for(int i=0; i<lectCombo.getItemCount();i++) {
		if(lectCombo.getItemAt(i).toString().equalsIgnoreCase(name)) {
			lectCombo.setSelectedIndex(i);
                    }
		}
                                
	String stgroup = naTable.getValueAt(selected, 2).toString();
            for(int i=0; i<groupCombo.getItemCount();i++) {
		if(groupCombo.getItemAt(i).toString().equalsIgnoreCase(stgroup)) {
                    groupCombo.setSelectedIndex(i);
                    }
		}
							
	String subGroup = naTable.getValueAt(selected, 3).toString();
            for(int i=0; i<subGroupCombo.getItemCount();i++) {
		if(subGroupCombo.getItemAt(i).toString().equalsIgnoreCase(subGroup)) {
                    subGroupCombo.setSelectedIndex(i);
                    }
		}
				
				
	String session = naTable.getValueAt(selected, 4).toString();
            for(int i=0; i<sCombo.getItemCount();i++) {
		if(sCombo.getItemAt(i).toString().equalsIgnoreCase(session)) {
                    sCombo.setSelectedIndex(i);
                    }
		}

	String day  = naTable.getValueAt(selected, 5).toString();
            for(int i=0; i<dayCombo.getItemCount();i++) {
		if(dayCombo.getItemAt(i).toString().equalsIgnoreCase(day)) {
                    dayCombo.setSelectedIndex(i);
                    }
		}
				
	String room =naTable.getValueAt(selected, 6).toString();
            for(int i=0; i<locCombo.getItemCount();i++) {
                if(locCombo.getItemAt(i).toString().equalsIgnoreCase(room)) {
                    locCombo.setSelectedIndex(i);
                    }
		}
            
        String start =naTable.getValueAt(selected, 7).toString();
            for(int i=0; i<startCombo.getItemCount();i++) {
                if(startCombo.getItemAt(i).toString().equalsIgnoreCase(start)) {
                    startCombo.setSelectedIndex(i);
                    }
		}
            
        String end =naTable.getValueAt(selected, 8).toString();
            for(int i=0; i<endCombo.getItemCount();i++) {
                if(endCombo.getItemAt(i).toString().equalsIgnoreCase(end)) {
                    endCombo.setSelectedIndex(i);
                    }
		}

 
    }//GEN-LAST:event_naTableMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        close();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int p = JOptionPane.showConfirmDialog(null,"<html><br><p style=\"text-align:center;\"> Do You Want to Delete Selected Records?</p><br></html>","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(p==0){   
        try{
            int row=naTable.getSelectedRow();
            String value=(naTable.getModel().getValueAt(row, 0).toString());
            String sql ="DELETE FROM not_available WHERE na_id ="+value;
            pst = con.prepareStatement(sql);
            pst.execute();
            
            //Auto Refresh Table
            DefaultTableModel model = (DefaultTableModel) naTable.getModel();
            model.setRowCount(0);
            show_na_table();
            JOptionPane.showMessageDialog(null,"Successfully Deleted!");

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Something Went Wrong!","Deletion Failed!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
             
            try {
                int row = naTable.getSelectedRow();
                String value = (naTable.getModel().getValueAt(row, 0).toString());
                
                String sql = "UPDATE not_available SET lecName=?,stgroup=?,subGroup=?,sessionSign=?,day=?,room=?,startTime=?,endTime=? where na_id="+value;
                pst = con.prepareStatement(sql);
                
                String name = lectCombo.getSelectedItem().toString();
                pst.setString(1,name);
                
                String stgroup = groupCombo.getSelectedItem().toString();
                pst.setString(2,stgroup);
                
                String subGroup = subGroupCombo.getSelectedItem().toString();
                pst.setString(3,subGroup);
                
                String session = sCombo.getSelectedItem().toString(); 
                pst.setString(4,session);
                
                String day = dayCombo.getSelectedItem().toString();
                pst.setString(5,day);
                
                String room = locCombo.getSelectedItem().toString();
                pst.setString(6,room);
                
                String start = startCombo.getSelectedItem().toString();
                pst.setString(7,start);
                
                String end = endCombo.getSelectedItem().toString();
                pst.setString(8,end);
                
                pst.executeUpdate(); 
                //Auto Refresh Table
                DefaultTableModel model = (DefaultTableModel) naTable.getModel();
                model.setRowCount(0);
                show_na_table();
                JOptionPane.showMessageDialog(null,"Successfully Updated!");
                

                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Something Went Wrong!","Update Failed!",JOptionPane.WARNING_MESSAGE);
            }
            
           
        
               

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String val = txtSearch.getText().toString();
        
        int a;
        
        try{
            pst = con.prepareStatement("select * from not_available where lecName like '%"+val+"%'");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a= rd.getColumnCount();
            df = (DefaultTableModel)naTable.getModel();
            df.setRowCount(0);
            
         while(rs.next()){
         
             Vector v2 = new Vector();
             for(int i = 1; i<=a; i++){
             
                 v2.add(rs.getString("na_id"));
                 v2.add(rs.getString("lecName"));
                 v2.add(rs.getString("stgroup"));
                 v2.add(rs.getString("subGroup"));
                 v2.add(rs.getString("sessionSign"));
                 v2.add(rs.getString("day"));
                 v2.add(rs.getString("room"));
                 v2.add(rs.getString("startTime"));
                 v2.add(rs.getString("endTime"));
             }
            
             df.addRow(v2);
         
         }
        }
        catch(Exception e){
        
            Logger.getLogger(ManageNotAvailableTimes.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {
              try{
                rs.close();
                pst.close();
            }
        catch(Exception e) {
            
        }}
    }//GEN-LAST:event_txtSearchKeyReleased

    private void lectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lectComboActionPerformed

    private void groupComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupComboActionPerformed

    private void subGroupComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subGroupComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subGroupComboActionPerformed

    private void dayComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayComboActionPerformed

    private void locComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locComboActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetFields();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(ManageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageNotAvailableTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageNotAvailableTimes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JComboBox<String> endCombo;
    private javax.swing.JComboBox<String> groupCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lectCombo;
    private javax.swing.JComboBox<String> locCombo;
    private javax.swing.JTable naTable;
    private javax.swing.JComboBox<String> sCombo;
    private javax.swing.JComboBox<String> startCombo;
    private javax.swing.JComboBox<String> subGroupCombo;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
