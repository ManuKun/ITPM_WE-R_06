/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablems;

import com.sun.glass.events.KeyEvent;
import timetablems.DBConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Supun
 */
public class ManageSessions extends javax.swing.JFrame {

    /**
     * Creates new form ManageSessions
     */
    public ManageSessions() throws SQLException {
        initComponents();
        con = DBConnect.connect();
        load();
        fillLecturer();
        fillSubject();
        fillGroup();
        fillTag();
        
       // disabale Maximize button
        setResizable(false);
        Ltable.setBackground(Color.white);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        //jfram not close
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    ResultSet rs;
    
    private void fillLecturer(){
        try{
            
            String sql = "select * from lecturer ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                txtname1.addItem(name);
                txtname2.addItem(name);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void fillSubject(){
        try{
            
            String sql = "select * from subject";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String code = rs.getString("s_code");
                txtscode.addItem(code);
                String name = rs.getString("name");
                txtsname.addItem(name);
            
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void fillGroup(){
        try{
            
            String sql = "select * from student";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String group = rs.getString("subgroupid");
                txtgid.addItem(group); 
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void fillTag(){
        try{
            
            String sql = "select * from tag group by relatedtag";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String Tag = rs.getString("relatedtag");
                txttag.addItem(Tag); 
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void load()
    {
       int a;
        try {
            pst = con.prepareStatement("select * from session");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df = (DefaultTableModel)Ltable.getModel();
            df.setRowCount(0);
            
           while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i <= a; i++)
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name1"));
                    v2.add(rs.getString("name2"));
                    v2.add(rs.getString("s_code"));
                    v2.add(rs.getString("s_name"));
                    v2.add(rs.getString("gid"));
                    v2.add(rs.getString("tag"));
                    v2.add(rs.getString("nuofstu"));
                    v2.add(rs.getString("duration"));
                    //v2.add(rs.getString("alldetails"));
                   
                }

                df.addRow(v2);
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsname = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ltable = new javax.swing.JTable();
        txtname1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtdur = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtname2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttag = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        txtscode = new javax.swing.JComboBox<>();
        txtgid = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtnos = new javax.swing.JTextField();
        Search1 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        Refresh = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsnameActionPerformed(evt);
            }
        });
        txtsname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsnameKeyReleased(evt);
            }
        });
        jPanel1.add(txtsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 499, 202, 28));

        Ltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Select Lecturers 1", "Select Lecturers 2", "Subjects Code", "Subjects Name", "Sub Group ID", "Select Tag", "No. of Students", "Durations"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Ltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtableMouseClicked(evt);
            }
        });
        Ltable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LtableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Ltable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, 1010, 244));

        txtname1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtname1KeyReleased(evt);
            }
        });
        jPanel1.add(txtname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 361, 202, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Select Lecturer(s) 1");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 361, 130, 28));

        txtdur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdurKeyReleased(evt);
            }
        });
        jPanel1.add(txtdur, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 503, 202, 28));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Subjects Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 499, 130, 28));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("No. of Students");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 453, -1, 28));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Select Lecturer(s) 2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 407, 130, 28));

        Clear.setBackground(new java.awt.Color(0, 102, 204));
        Clear.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        Clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ClearKeyReleased(evt);
            }
        });
        jPanel1.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 359, 100, 33));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sub Group ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 361, 96, 28));

        txtname2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[Not Selected]" }));
        txtname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtname2ActionPerformed(evt);
            }
        });
        txtname2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtname2KeyReleased(evt);
            }
        });
        jPanel1.add(txtname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 407, 202, 28));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Durations");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 499, 96, 28));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Hrs");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 502, 30, 28));

        txttag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttagKeyReleased(evt);
            }
        });
        jPanel1.add(txttag, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 407, 202, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Subjects Code");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 453, 130, 28));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Select Tag");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 407, 96, 28));

        txtsearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 178, 34));

        txtscode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtscode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtscodeActionPerformed(evt);
            }
        });
        txtscode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtscodeKeyReleased(evt);
            }
        });
        jPanel1.add(txtscode, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 453, 202, 28));

        txtgid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtgid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtgidKeyReleased(evt);
            }
        });
        jPanel1.add(txtgid, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 361, 202, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Sessions");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 11, -1, -1));

        txtnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnosKeyReleased(evt);
            }
        });
        jPanel1.add(txtnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 456, 202, 28));

        Search1.setBackground(new java.awt.Color(0, 102, 204));
        Search1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Search1.setForeground(new java.awt.Color(255, 255, 255));
        Search1.setText("Search");
        Search1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
            }
        });
        Search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Search1KeyReleased(evt);
            }
        });
        jPanel1.add(Search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 58, 110, 35));

        Update.setBackground(new java.awt.Color(0, 102, 204));
        Update.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        Update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UpdateKeyReleased(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 410, 100, 33));

        Delete.setBackground(new java.awt.Color(0, 102, 204));
        Delete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 461, 100, 33));

        jComboBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lecture", "Lab", "Tutorial", "Evalution" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jComboBox7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox7KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 58, 141, 33));

        Refresh.setBackground(new java.awt.Color(0, 102, 204));
        Refresh.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Refresh");
        Refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        jPanel1.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 115, 35));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 550));

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

    private void txtscodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtscodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtscodeActionPerformed

    private void txtname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtname2ActionPerformed

    private void LtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtableMouseClicked
        // TODO add your handling code here:
        df = (DefaultTableModel)Ltable.getModel();

        int selected = Ltable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
        String Lecturer1 = Ltable.getValueAt(selected, 1).toString();
            for(int i=0; i<txtname1.getItemCount();i++) {
		if(txtname1.getItemAt(i).toString().equalsIgnoreCase(Lecturer1)) {
			txtname1.setSelectedIndex(i);
                    }
		}
                                
	String Lecturer2 = Ltable.getValueAt(selected, 2).toString();
            for(int i=0; i<txtname2.getItemCount();i++) {
		if(txtname2.getItemAt(i).toString().equalsIgnoreCase(Lecturer2)) {
                    txtname2.setSelectedIndex(i);
                    }
		}
							
	String SubjectCode = Ltable.getValueAt(selected, 3).toString();
            for(int i=0; i<txtscode.getItemCount();i++) {
		if(txtscode.getItemAt(i).toString().equalsIgnoreCase(SubjectCode)) {
                    txtscode.setSelectedIndex(i);
                    }
		}
				
				
	String SubjectName = Ltable.getValueAt(selected, 4).toString();
            for(int i=0; i<txtsname.getItemCount();i++) {
		if(txtsname.getItemAt(i).toString().equalsIgnoreCase(SubjectName)) {
                    txtsname.setSelectedIndex(i);
                    }
		}

	String StudentGroup = Ltable.getValueAt(selected, 5).toString();
            for(int i=0; i<txtgid.getItemCount();i++) {
		if(txtgid.getItemAt(i).toString().equalsIgnoreCase(StudentGroup)) {
                    txtgid.setSelectedIndex(i);
                    }
		}
				
	String Tag =Ltable.getValueAt(selected, 6).toString();
            for(int i=0; i<txttag.getItemCount();i++) {
                if(txttag.getItemAt(i).toString().equalsIgnoreCase(Tag)) {
                    txttag.setSelectedIndex(i);
                    }
		}
            
        txtnos.setText(df.getValueAt(selected, 7).toString());
        txtdur.setText(df.getValueAt(selected, 8).toString());

       
    }//GEN-LAST:event_LtableMouseClicked

    private void txtsnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsnameActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
         txtsearch.setText("");
         jComboBox7.setSelectedIndex(0);
            
            df.setRowCount(0);
        try {
            load();
        } catch (Exception ex) {
            Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RefreshActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
            
            txtname1.setSelectedIndex(0);
            txtname2.setSelectedIndex(0);
            txtscode.setSelectedIndex(0);
            txtsname.setSelectedIndex(0);
            txtgid.setSelectedIndex(0);
            txttag.setSelectedIndex(0);
            txtnos.setText("");
            txtdur.setText("");
            txtsearch.setText("");
            jComboBox7.setSelectedIndex(0);
            
            df.setRowCount(0);
        try {
            load();
        } catch (Exception ex) {
            Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClearActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:        
        if(txtnos.getText().trim().isEmpty() || txtdur.getText().trim().isEmpty()){
            Component frame = null;
            
              JOptionPane.showMessageDialog(frame, "Please fill in a valid value!!!");
        }
        else{
        
            df = (DefaultTableModel) Ltable.getModel();
        
            int selected = Ltable.getSelectedRow();
            int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
            String Lecture1 = txtname1.getSelectedItem().toString();
            String Lecture2 = txtname2.getSelectedItem().toString();
            String S_code = txtscode.getSelectedItem().toString();
            String S_name = txtsname.getSelectedItem().toString();
            String Group = txtgid.getSelectedItem().toString();            
            String Tag = txttag.getSelectedItem().toString();
            String NOStudent = txtnos.getText();        
            String Duration = txtdur.getText();
            String Details = Lecture1+"/"+Lecture2+"/"+S_code+"/"+S_name+"/"+Group+"/"+Tag+"/"+NOStudent+"/"+Duration;
            String Details1 = Lecture1+"/"+Lecture2+"/"+S_code+"/"+S_name+"/"+Group+"/"+Tag;
            
            
            int x = JOptionPane.showConfirmDialog(null, "Are you want to update Session?", "Update", JOptionPane.YES_NO_OPTION);
            
        if(x == 0)
        {
            try {
                pst = con.prepareStatement("update session set name1 =?, name2 =?, s_code =?, s_name =?, gid =?, tag =?, nuofstu =?, duration =?, alldetails =?, rajitha =? where id =?");
                pst.setString(1,Lecture1);
                pst.setString(2,Lecture2);
                pst.setString(3,S_code);
                pst.setString(4,S_name);
                pst.setString(5,Group);
                pst.setString(6,Tag);
                pst.setString(7,NOStudent);
                pst.setString(8,Duration);
                pst.setString(9,Details);
                pst.setString(10,Details1);
                pst.setInt(11,id);
                
                pst.executeUpdate();
                 
                JOptionPane.showMessageDialog(this, "Session Updated Successfully");
                
                    txtname1.setSelectedIndex(0);
                    txtname2.setSelectedIndex(0);
                    txtscode.setSelectedIndex(0);
                    txtsname.setSelectedIndex(0);
                    txtgid.setSelectedIndex(0);
                    txttag.setSelectedIndex(0);
                    txtnos.setText("");
                    txtdur.setText("");
                
                //errorname.setText("");
                //erroreid.setText("");
                
                load();
            } catch (SQLException ex) {
                Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
        }    
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        df = (DefaultTableModel)Ltable.getModel();

        int selected = Ltable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());

        int x = JOptionPane.showConfirmDialog(null, "Are you want to delete the record?", "Delete", JOptionPane.YES_NO_OPTION);

        if(x == 0)
        {
            try {
                pst = con.prepareStatement("delete from session where id = ?");
                pst.setInt(1,id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,"Session Deleted Successfully");

                txtname1.setSelectedIndex(0);
                txtname2.setSelectedIndex(0);
                txtscode.setSelectedIndex(0);
                txtsname.setSelectedIndex(0);
                txtgid.setSelectedIndex(0);
                txttag.setSelectedIndex(0);
                txtnos.setText("");
                txtdur.setText("");

                load();

            } catch (SQLException ex) {
                Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search1ActionPerformed
        // TODO add your handling code here:
        String val = txtsearch.getText().toString();
        String val2 = jComboBox7.getSelectedItem().toString();
        
         int a;
         
         //select * from tableName where tag = '"+Tag+"' AND name1 like '"+name+"'
         //select * from tableName where tag = '"+Tag+"' AND name1 = '"+name+"'                  
        try {

            pst  = con.prepareStatement("select * from session where name1 like '%"+val+"%' AND tag = '"+val2+"'");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a= rd.getColumnCount();
            df = (DefaultTableModel)Ltable.getModel();
            df.setRowCount(0);
            
            while(rs.next()){       
                
                Vector v2 = new Vector();
                for(int i =1; i<=a; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name1"));
                    v2.add(rs.getString("name2"));
                    v2.add(rs.getString("s_code"));
                    v2.add(rs.getString("s_name"));
                    v2.add(rs.getString("gid"));
                    v2.add(rs.getString("tag"));
                    v2.add(rs.getString("nuofstu"));
                    v2.add(rs.getString("duration")); 
                }
                df.addRow(v2);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Search1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
            df.setRowCount(0);
            load();
            
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             jComboBox7.requestFocus();
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtnosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnosKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtdur.requestFocus();
         }
    }//GEN-LAST:event_txtnosKeyReleased

    private void LtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LtableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LtableKeyPressed

    private void txtname1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtname1KeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtname2.requestFocus();
         }
    }//GEN-LAST:event_txtname1KeyReleased

    private void txtname2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtname2KeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtscode.requestFocus();
         }
    }//GEN-LAST:event_txtname2KeyReleased

    private void txtscodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtscodeKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtsname.requestFocus();
         }
    }//GEN-LAST:event_txtscodeKeyReleased

    private void txtsnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsnameKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtgid.requestFocus();
         }
    }//GEN-LAST:event_txtsnameKeyReleased

    private void txtgidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgidKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txttag.requestFocus();
         }
    }//GEN-LAST:event_txtgidKeyReleased

    private void txttagKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttagKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             txtnos.requestFocus();
         }
    }//GEN-LAST:event_txttagKeyReleased

    private void txtdurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdurKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             Clear.requestFocus();
         }
    }//GEN-LAST:event_txtdurKeyReleased

    private void ClearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClearKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             Update.requestFocus();
         }
    }//GEN-LAST:event_ClearKeyReleased

    private void UpdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             Delete.requestFocus();
         }
    }//GEN-LAST:event_UpdateKeyReleased

    private void jComboBox7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox7KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             Search1.requestFocus();
         }
    }//GEN-LAST:event_jComboBox7KeyReleased

    private void Search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search1KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             Refresh.requestFocus();
         }
    }//GEN-LAST:event_Search1KeyReleased

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
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageSessions().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JTable Ltable;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Search1;
    private javax.swing.JButton Update;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtdur;
    private javax.swing.JComboBox<String> txtgid;
    private javax.swing.JComboBox<String> txtname1;
    private javax.swing.JComboBox<String> txtname2;
    private javax.swing.JTextField txtnos;
    private javax.swing.JComboBox<String> txtscode;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox<String> txtsname;
    private javax.swing.JComboBox<String> txttag;
    // End of variables declaration//GEN-END:variables
}
