package timetablemanagement.View;

import timetablemanagement.Database.DBconnecter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL'
 */
public class ManageSession extends javax.swing.JFrame {
     Connection con=null;
     String[] strArr=new String[20];
    /**
     * Creates new form ManageSession
     */
    public ManageSession() {
        initComponents();
        con=DBconnecter.connection();
        table_update();
        getDetails();
    }

     private void getDetails(){
             int count=0;
        try {
            PreparedStatement st=con.prepareStatement("SELECT `Lecturername` FROM `lecturers details`");
            ResultSet rs=st.executeQuery();
           
            lecture.addItem(null);
            lec1.addItem(null);
            while(rs.next()){ 
                 String LecName=rs.getString("Lecturername");
                 lecture.addItem(LecName);
                 lec1.addItem(LecName);
            }
            PreparedStatement st1=con.prepareStatement("SELECT * FROM `tag details`");
            ResultSet rs1=st1.executeQuery();
           
            tag.addItem(null);
            while(rs1.next()){ 
                 String Tag=rs1.getString("relatedtag");
                 tag.addItem(Tag);
            }
            PreparedStatement st2=con.prepareStatement("SELECT * FROM `student details`");
            ResultSet rs2=st2.executeQuery();
           
            group.addItem(null);
            while(rs2.next()){ 
                 String Groupid=rs2.getString("Groupid");
                 group.addItem(Groupid);
            }
            PreparedStatement st3=con.prepareStatement("SELECT * FROM `subject details`");
            ResultSet rs3=st3.executeQuery();
           
            sub.addItem(null);
            while(rs3.next()){ 
                 strArr[count]=rs3.getString("subjectcode");
                 String subjectname=rs3.getString("subjectname");
                 sub.addItem(subjectname);
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
    private void table_update(){
        int c;
        try {
            PreparedStatement st=con.prepareStatement("SELECT ID,Selectlecturer1,Selectlecturer2,subjectCode ,selectsubject,selectgroup,selecttag FROM sessiondetails ");
            
            
            ResultSet rs=st.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();
            
            DefaultTableModel df=(DefaultTableModel)manage.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v1=new Vector();
                
                for(int a=1;a<=c;a++){
                   
                    v1.add(rs.getString(1)); 
                    v1.add(rs.getString(2)); 
                    v1.add(rs.getString(3));  
                    v1.add(rs.getString(4));  
                    v1.add(rs.getString(5));
                    v1.add(rs.getString(6));  
                    v1.add(rs.getString(7));  
                    
                   
                }
                df.addRow(v1);

            }
            
          

             
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
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

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lec1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        manage = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lecture = new javax.swing.JComboBox<>();
        tag = new javax.swing.JComboBox<>();
        group = new javax.swing.JComboBox<>();
        sub = new javax.swing.JComboBox<>();
        counts = new javax.swing.JTextField();
        due = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton00 = new javax.swing.JButton();

        jLabel8.setText("Select Group");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage session");

        jButton5.setText("Add session");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        manage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecture 1", "Lecture 2", "Subject Code", "Subject Name", "Group ID", "Tag"
            }
        ));
        manage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(manage);

        jButton1.setText("Back");

        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Refresh");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        lecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectureActionPerformed(evt);
            }
        });

        counts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countsActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Lecture(s)");

        jLabel3.setText("Select Tag");

        jLabel5.setText("Select Group");

        jLabel6.setText("Select Subject");

        jLabel7.setText("No.Of.Student");

        jLabel9.setText("Duration");

        jButton00.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lec1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton00, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lecture, 0, 134, Short.MAX_VALUE)
                                    .addComponent(tag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sub, 0, 75, Short.MAX_VALUE)
                                    .addComponent(group, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(due, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(counts))
                                .addGap(22, 22, 22)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(lec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton00))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(counts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(due, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton5))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lectureActionPerformed

    private void countsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countsActionPerformed

    private void manageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageMouseClicked
    DefaultTableModel df=(DefaultTableModel)manage.getModel();
     int SelectedIndex=manage.getSelectedRow();
     
     String ID=df.getValueAt(SelectedIndex,0).toString();
   
        try {
            PreparedStatement st1=con.prepareStatement("SELECT `ID`, `Selectlecturer1`, `Selectlecturer2`, `selecttag`, `selectgroup`, `selectsubject`, `subjectCode`, `noofstudents`, `duration` FROM `sessiondetails` WHERE `ID`="+ID+"");
            
            
            ResultSet rs1=st1.executeQuery();
            while(rs1.next()){
              lecture.setSelectedItem(rs1.getString("Selectlecturer1"));
              tag.setSelectedItem(rs1.getString("selecttag"));
              group.setSelectedItem(rs1.getString("selectgroup"));
              sub.setSelectedItem(rs1.getString("selectsubject"));
              counts.setText(rs1.getString("noofstudents"));
              due.setText(rs1.getString("duration"));
            }
            
          

             
        } catch (Exception e) {
             e.printStackTrace();
             
        }
     
    }//GEN-LAST:event_manageMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      
        DefaultTableModel df=(DefaultTableModel)manage.getModel();
        int SelectedIndex=manage.getSelectedRow();
     
        String id=df.getValueAt(SelectedIndex,0).toString();
        try {
            PreparedStatement st=con.prepareStatement("UPDATE `sessiondetails` SET `Selectlecturer1`=?,`selecttag`=?,`selectgroup`=?,`subjectCode`=?,`noofstudents`=?,`duration`=? WHERE `ID`="+id+"");
            st.setString(1,lecture.getSelectedItem().toString());
            st.setString(2,tag.getSelectedItem().toString() );
            st.setString(3,group.getSelectedItem().toString() );
            st.setString(4,sub.getSelectedItem().toString());
            st.setString(5,counts.getText());
            st.setString(6,due.getText() );
           
             int count=st.executeUpdate();
            if(count>0){
               JOptionPane.showMessageDialog(null, "Succesfully updated");
               table_update();
              
            }
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       DefaultTableModel df=(DefaultTableModel)manage.getModel();
        int SelectedIndex=manage.getSelectedRow();
     
        String id=df.getValueAt(SelectedIndex,0).toString();
        
        try {
            PreparedStatement st1=con.prepareStatement("DELETE FROM `sessiondetails` WHERE ID="+id+"");
             int count=st1.executeUpdate();
            if(count>0){
               JOptionPane.showMessageDialog(null, "Succesfully deleted");
               table_update();
             
            }
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

         int c;
        try {
            PreparedStatement st=con.prepareStatement("SELECT ID,Selectlecturer1,Selectlecturer2,subjectCode ,selectsubject,selectgroup,selecttag FROM sessiondetails  WHERE `Selectlecturer1`='"+lec1.getSelectedItem().toString()+"' OR `Selectlecturer2`='"+lec1.getSelectedItem().toString()+"'");
            
            
            ResultSet rs=st.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();
            
            DefaultTableModel df=(DefaultTableModel)manage.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v1=new Vector();
                
                for(int a=1;a<=c;a++){
                   
                    v1.add(rs.getString(1)); 
                    v1.add(rs.getString(2)); 
                    v1.add(rs.getString(3));  
                    v1.add(rs.getString(4));  
                    v1.add(rs.getString(5));
                    v1.add(rs.getString(6));  
                    v1.add(rs.getString(7));  
                    
                   
                }
                df.addRow(v1);

            }
            
          

             
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       table_update();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        new AddSession().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField counts;
    private javax.swing.JTextField due;
    private javax.swing.JComboBox<String> group;
    private javax.swing.JButton jButton00;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lec1;
    private javax.swing.JComboBox<String> lecture;
    private javax.swing.JTable manage;
    private javax.swing.JComboBox<String> sub;
    private javax.swing.JComboBox<String> tag;
    // End of variables declaration//GEN-END:variables
}