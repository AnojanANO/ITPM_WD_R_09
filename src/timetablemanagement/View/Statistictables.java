package timetablemanagement.View;

import timetablemanagement.Database.DBconnecter;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL'
 */
public class Statistictables extends javax.swing.JFrame {

    Connection con=null;
    /**
     * Creates new form Statistictables
     */
    public Statistictables() {
        initComponents();
        this.setResizable(false);
        con=DBconnecter.connection();
          Lecname.setEditable(false);
          lastgroup.setEditable(false); 
          lastsub.setEditable(false);
          
        CheckDetails();
       
    }

   
    private void CheckDetails(){
       getLectureDetails();
       getStudentDetail();
       getSubjectDetail();
       getRoomDetail();
       double lec = 0,lab = 0;
       String lc = null,lb = null;
       try {
           
           
            PreparedStatement st=con.prepareStatement("SELECT SUM(capacity) as LEC FROM `locationdetails` WHERE roomtype='Lecture Hall'");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
               lc=rs.getString("LEC");
            }
            
            PreparedStatement st1=con.prepareStatement("SELECT SUM(capacity) as LAB FROM `locationdetails` WHERE roomtype='Laboratory'");
            ResultSet rs1=st1.executeQuery();
            
            while(rs1.next()){
               lb=rs1.getString("LAB");
                
                 
            }
          
            if(!(lc==null)){
                lec=Double.parseDouble(lc);
            }
            if(!(lb==null)){
                lab=Double.parseDouble(lb);
            }
     
               
        
       DefaultCategoryDataset dode=new DefaultCategoryDataset();
       dode.setValue(lec, "Capacity", "Lecture Hall");
       dode.setValue(lab, "Capacity", "Laboratory");
       
      
       
       JFreeChart chart=ChartFactory.createBarChart3D("Room Detail", "Rooms", "Capacity", dode,PlotOrientation.VERTICAL,false,true,false);
       CategoryPlot p=chart.getCategoryPlot();
       p.setRangeGridlinePaint(Color.black);
       
//       ChartFrame frame=new ChartFrame("Room Detail", chart,true);
//       frame.setVisible(true);
//       frame.setSize(300, 200);
       ChartPanel panel=new ChartPanel(chart);
       
       
       bPanel1.removeAll();
       bPanel1.add(panel);
       bPanel1.updateUI();
       
         
       //SELECT SUM(capacity) FROM `locationdetails` WHERE roomtype='Lecture Hall'
        } catch (Exception e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null,e.getMessage());
        }       
       
        
    }
    private void getLectureDetails(){
        try {
            PreparedStatement st=con.prepareStatement("SELECT COUNT(ID) as counting FROM `lecturers details`");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
               RLEC.setLabel(rs.getString("counting"));

            }
            PreparedStatement st1=con.prepareStatement("SELECT Lecturername FROM `lecturers details` ORDER BY ID DESC LIMIT 1");
            ResultSet rs1=st1.executeQuery();
            while(rs1.next()){
               Lecname.setText(rs1.getString(1));

            }
            
          

             
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        //SELECT COUNT(ID) as counting FROM `lecturers details`


           

    }
    
    private void getStudentDetail(){
        try {
            PreparedStatement st=con.prepareStatement("SELECT COUNT(ID) as counting FROM `student details`");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
               RSTD.setLabel(rs.getString("counting"));

            }
            PreparedStatement st1=con.prepareStatement("SELECT `subgroupid` FROM `student details` ORDER BY ID DESC LIMIT 1");
            ResultSet rs1=st1.executeQuery();
            while(rs1.next()){
               
               lastgroup.setText(rs1.getString(1));

            }
          

             
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        //SELECT `academicyearsemester`, `programme`, `Groupnumber`, `subgroupnumber` FROM `student details`
    }
    private void getRoomDetail(){
        try {
            PreparedStatement st=con.prepareStatement("SELECT COUNT(ID) as counting FROM `locationdetails`");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
               RROOM.setLabel(rs.getString("counting"));

            }
            
          

             
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    private void getSubjectDetail(){
        try {
            PreparedStatement st=con.prepareStatement("SELECT COUNT(ID) as counting FROM `subject details`");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
               RSUB.setLabel(rs.getString("counting"));

            }
             PreparedStatement st1=con.prepareStatement("SELECT subjectname FROM `subject details` ORDER BY ID DESC LIMIT 1");
            ResultSet rs1=st1.executeQuery();
            while(rs1.next()){
               lastsub.setText(rs1.getString(1));

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

        RSTD = new javax.swing.JButton();
        RSUB = new javax.swing.JButton();
        RROOM = new javax.swing.JButton();
        RLEC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        bPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Lecname = new javax.swing.JTextField();
        lastgroup = new javax.swing.JTextField();
        lastsub = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(790, 500));
        getContentPane().setLayout(null);

        RSTD.setBackground(new java.awt.Color(255, 255, 51));
        RSTD.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        RSTD.setText("2");
        getContentPane().add(RSTD);
        RSTD.setBounds(250, 40, 100, 76);

        RSUB.setBackground(new java.awt.Color(255, 255, 51));
        RSUB.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        RSUB.setText("4");
        getContentPane().add(RSUB);
        RSUB.setBounds(410, 40, 100, 76);

        RROOM.setBackground(new java.awt.Color(255, 255, 51));
        RROOM.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        RROOM.setText("5");
        getContentPane().add(RROOM);
        RROOM.setBounds(570, 40, 100, 76);

        RLEC.setBackground(new java.awt.Color(255, 255, 51));
        RLEC.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        RLEC.setText("3");
        getContentPane().add(RLEC);
        RLEC.setBounds(90, 40, 100, 76);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(19, 147, 0, 0);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Registered Lecturers");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 120, 140, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Registered Students");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 120, 140, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Registered Subjects");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 120, 140, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Registered Rooms");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(570, 120, 130, 15);

        jButton5.setText("Back");
        getContentPane().add(jButton5);
        jButton5.setBounds(10, 463, 73, 23);

        bPanel1.setLayout(new javax.swing.BoxLayout(bPanel1, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(bPanel1);
        bPanel1.setBounds(34, 157, 400, 286);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Latest Lecturer");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(460, 230, 110, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Latest Group");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(460, 280, 100, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Latest Subject");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(460, 340, 100, 17);

        Lecname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(Lecname);
        Lecname.setBounds(590, 220, 160, 30);

        lastgroup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(lastgroup);
        lastgroup.setBounds(590, 280, 160, 30);

        lastsub.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(lastsub);
        lastsub.setBounds(590, 340, 160, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\add subject.jpg")); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.setPreferredSize(new java.awt.Dimension(1040, 695));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 760, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Statistictables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistictables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistictables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistictables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistictables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Lecname;
    private javax.swing.JButton RLEC;
    private javax.swing.JButton RROOM;
    private javax.swing.JButton RSTD;
    private javax.swing.JButton RSUB;
    private javax.swing.JPanel bPanel1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastgroup;
    private javax.swing.JTextField lastsub;
    // End of variables declaration//GEN-END:variables
}
