import java.net.URL;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import javax.swing.SortOrder;
import java.util.ArrayList;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noyeongdan
 */
public class Refrigerator extends javax.swing.JFrame {
    Login login = new Login();
    
    private DefaultTableModel model;
    private DefaultTableModel m;
    private DefaultTableModel clear;
    
    public String getFood(){
        String a = jtable.getValueAt(jtable.getSelectedRow(), 1).toString();
        return a;
    }
    public String getDate(){
        String b = jtable.getValueAt(jtable.getSelectedRow(), 2).toString();
        return b;
    }
    /**
     * Creates new form Refrigerator
     */
    public Refrigerator() {
        initComponents();
        tbxuserID.setText(login.getID());
        tbxFood.setText(null);
        tbxExpiredate.setText(null);
        getDBData();
    }

    public void getDBData(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        ArrayList<String> Food = new ArrayList<String>();
        ArrayList<String> Expiredate = new ArrayList<String>();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();
            String sql = "select * from Refrigerator_management.Refri where userID = '" + tbxuserID.getText() + "'" + "order by Expiredate";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();/*!!!!!!*/
            while(rs.next()){
                Food.add(rs.getString("Food"));
                Expiredate.add(rs.getString("Expiredate"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(pstmt!= null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        DefaultTableModel RefriModel = (DefaultTableModel) jtable.getModel();
        for(int i=0; i<Food.size(); i++){
                RefriModel.addRow(new Object[]{Food.get(i),Expiredate.get(i)});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        UrlFrame = new javax.swing.JDialog();
        lblMain = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        R_LinkName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        R_Url = new javax.swing.JTextField();
        Register = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        UrlTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Location = new javax.swing.JTextField();
        Move = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lbluserID = new javax.swing.JLabel();
        lblFood = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        tbxuserID = new javax.swing.JTextField();
        tbxFood = new javax.swing.JTextField();
        tbxExpiredate = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnUpload = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        URLbtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        lblMain.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        lblMain.setText("냉장고 재료로 요리하는 영상보러가기!");

        jLabel2.setText("Url 등록하기");

        jLabel3.setText("Url 이름");

        jLabel4.setText("Url");

        Register.setText("등록");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        UrlTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "이름", "Url"
            }
        ));
        UrlTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UrlTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(UrlTable);

        jLabel1.setText("Url");

        Move.setText("이동하기");
        Move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UrlFrameLayout = new javax.swing.GroupLayout(UrlFrame.getContentPane());
        UrlFrame.getContentPane().setLayout(UrlFrameLayout);
        UrlFrameLayout.setHorizontalGroup(
            UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UrlFrameLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R_LinkName, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(R_Url))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Register)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UrlFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMain)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UrlFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(219, 219, 219))
            .addGroup(UrlFrameLayout.createSequentialGroup()
                .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UrlFrameLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UrlFrameLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Move)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UrlFrameLayout.setVerticalGroup(
            UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UrlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMain)
                .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UrlFrameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(R_LinkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(R_Url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UrlFrameLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Register)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(UrlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Move))
                .addGap(17, 17, 17))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        lblName.setText("냉장고 목록");

        lbluserID.setText("회원아이디");

        lblFood.setText("음식 이름");

        lblDate.setText("유통기한");

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "재료명", "유통기한"
            }
        ));
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtable);

        btnUpload.setText("추가");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnDelete.setText("삭제");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setText("종료");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnUpdate.setText("수정");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        URLbtn.setText("냉장고 재료 처리하러가기");
        URLbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URLbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbluserID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFood, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbxExpiredate)
                                    .addComponent(tbxFood)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tbxuserID))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblName)
                        .addGap(82, 82, 82))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(URLbtn)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbluserID)
                    .addComponent(tbxuserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFood)
                    .addComponent(tbxFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(tbxExpiredate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpload)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(URLbtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();

            String sql = "INSERT INTO Refrigerator_management" + ".Refri values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tbxuserID.getText());
            pstmt.setString(2, tbxFood.getText());
            pstmt.setString(3, tbxExpiredate.getText());
            pstmt.executeUpdate();
            
            //String arr[]={tbxFood.getText(), tbxExpiredate.getText()};
            //model = new DefaultTableModel();
            //model.addRow(arr); //테이블에 행 추가
            DefaultTableModel model = (DefaultTableModel) jtable.getModel();
            model.addRow(new Object[]{tbxFood.getText(), tbxExpiredate.getText()});
                        
            tbxFood.setText(null);
            tbxExpiredate.setText(null);
            
            clear = (DefaultTableModel)jtable.getModel();
            clear.setNumRows(0);
            
            getDBData();            
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(pstmt!= null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Refrigerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
                
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();
            String sql = "Delete from Refrigerator_management.Refri where userID = ? and Food = ? and Expiredate=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tbxuserID.getText());
            pstmt.setString(2, tbxFood.getText());
            pstmt.setString(3, tbxExpiredate.getText());
            pstmt.executeUpdate();
            
            int n = jtable.getSelectedRow();
            
            m = (DefaultTableModel)jtable.getModel();
            if(n>=0 && n < jtable.getRowCount()){
            m.removeRow(n);
            }
            
            tbxFood.setText(null);
            tbxExpiredate.setText(null);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        try {
            if(rs != null) rs.close();
            if(pstmt!= null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Refrigerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        int row = 0;
        row = jtable.getSelectedRow();
        
        tbxFood.setText(jtable.getValueAt(row, 0).toString());
        tbxExpiredate.setText(jtable.getValueAt(row,1).toString());
    }//GEN-LAST:event_jtableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String Dish = jtable.getValueAt(jtable.getSelectedRow(), 0).toString();
        String Day = jtable.getValueAt(jtable.getSelectedRow(), 1).toString();
        String Dish2 = tbxFood.getText(); // 바꿀 음식 이름
        String Day2 = tbxExpiredate.getText(); //바꿀 날짜
        
        
        try{            
            //String Fo = jtable.setValueAt(row, 0).toString());
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();
            String sql = "Update Refrigerator_management.Refri set Food = '" + Dish2 + "'where userID = '" + tbxuserID.getText() 
                            + "' and Food = '" + Dish + "' and Expiredate = '" + Day + "'" ;
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            sql = "Update Refrigerator_management.Refri set Expiredate = '" + Day2 + "' where userID = '" + tbxuserID.getText() 
                        + "' and Food = '" + Dish2 + "' and Expiredate = '" + Day + "'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            
            tbxFood.setText(null);
            tbxExpiredate.setText(null);
            
            clear = (DefaultTableModel)jtable.getModel();
            clear.setNumRows(0);
            
            getDBData(); 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(pstmt!= null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Refrigerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:
        String name=null;
        String url=null;

        name = R_LinkName.getText();
        url = R_Url.getText();

        boolean UrlOK = isUrl(url);
        boolean duplication = Duplication(url);

        if(UrlOK && duplication){
            insertUrl(name, url);
            DefaultTableModel UrlModel = (DefaultTableModel) UrlTable.getModel();
            UrlModel.addRow(new Object[]{name,url});
        }else if(!UrlOK){
            JOptionPane.showMessageDialog(null,"유효하지 않은 Url입니다.", "알림", JOptionPane.ERROR_MESSAGE);
        }else if(!duplication){
            JOptionPane.showMessageDialog(null,"이미 등록된 Url입니다.");
        }
    }//GEN-LAST:event_RegisterActionPerformed

    private void UrlTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UrlTableMouseClicked
        // TODO add your handling code here:
        int Row = 0;
        Row = UrlTable.getSelectedRow();
        Location.setText(UrlTable.getValueAt(Row, 1).toString());
    }//GEN-LAST:event_UrlTableMouseClicked

    private void MoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveActionPerformed
        // TODO add your handling code here:
        MoveUrl move = new MoveUrl();
        move.ButtonOpenWebActionPerformed(evt,Location.getText());
    }//GEN-LAST:event_MoveActionPerformed

    
    
    public static boolean isUrl(String url){
        try{
            new URL(url);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static boolean Duplication(String url){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        ArrayList<String> Url = new ArrayList<String>();
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();
        
            String sql = "select Url from Refrigerator_management.Link";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();/*!!!!!!*/
            while(rs.next()){
                Url.add(rs.getString("Url"));
            }//Url을 가져와서 ArrayList에 넣어준다.
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
		if(pstmt!= null) pstmt.close();
		if(conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        for(int i=0; i<Url.size(); i++){
            if(Url.get(i).equals(url)){
                return false;
            }
        }
        return true;
    }
    public static void insertUrl(String Link_name, String Url){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();
        
            String sql = "insert into Refrigerator_management.Link values(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Link_name);
            pstmt.setString(2, Url);
            pstmt.executeUpdate();/*!!!!!!*/
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
		if(pstmt!= null) pstmt.close();
		if(conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void initialize(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> Link_name = new ArrayList<String>();
        ArrayList<String> Url = new ArrayList<String>();
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DB.getConnection();
        
            String sql = "select * from Refrigerator_management.Link";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();/*!!!!!!*/
            while(rs.next()){
                Link_name.add(rs.getString("Link_name"));
                Url.add(rs.getString("Url"));
            }//링크 이름과 Url을 가져와서 ArrayList에 넣어준다.
	
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
		if(pstmt!= null) pstmt.close();
		if(conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        DefaultTableModel UrlModel = (DefaultTableModel) UrlTable.getModel();
        for(int i=0; i<Link_name.size(); i++){
            UrlModel.addRow(new Object[]{Link_name.get(i),Url.get(i)});
            //테이블에 가져온 값들을 넣어준다.
        }
    }
    int cnt=0;//처음 '냉장고 재료 처리하거가기'버튼을 눌렀는지 체크하는 변수
    private void URLbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URLbtnActionPerformed
        // TODO add your handling code here:
        cnt++;
        UrlFrame.setLocation(300,0);
        UrlFrame.setSize(500,500);
        UrlFrame.show();
        if(cnt==1){
            initialize();
        }
    }//GEN-LAST:event_URLbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Refrigerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Refrigerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Refrigerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Refrigerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Refrigerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Location;
    private javax.swing.JButton Move;
    private javax.swing.JTextField R_LinkName;
    private javax.swing.JTextField R_Url;
    private javax.swing.JButton Register;
    private javax.swing.JButton URLbtn;
    private javax.swing.JDialog UrlFrame;
    private javax.swing.JTable UrlTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jtable;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFood;
    private javax.swing.JLabel lblMain;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lbluserID;
    private javax.swing.JTextField tbxExpiredate;
    private javax.swing.JTextField tbxFood;
    private javax.swing.JTextField tbxuserID;
    // End of variables declaration//GEN-END:variables
}
