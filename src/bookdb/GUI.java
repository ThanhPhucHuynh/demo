/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdb;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Thanh Phuc Huynh
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    int index;
    String getID=null;
    connector cn = new connector();
   // DefaultTableModel dm;
   public String name;
    public GUI(String name) {
        this.name=name;
        initComponents();
        setResizable(false);
      //  try {
       // setBackground(new Color(0,0,0,0));
     //   viewsetting.setEnable(true);
           // BOOK1.setVisible(false);
           table_listBook.setVisible(false);
           search.setVisible(false);
           hello.setText("Wellcome "+name);
            btn_sellClick(false);
            DefaultTableModel model = (DefaultTableModel) tb1.getModel();
            book[] books = cn.dvsv();
         //   TimeUnit.SECONDS.sleep(1);
            System.out.println("lenght: "+books.length);
            //book[]  = cn.dvsv();
            int i=0;
            
            while(i!=(books.length)){
             //   System.out.println(books[i].getAuthor());
                model.addRow(new Object[] {books[i].getID(),books[i].getName(),books[i].getAuthor(),books[i].getCategory(),books[i].getPrice(),books[i].getSL()});
                i++;
            }
            //
            
            
            
            cn.checkAdmin("B1706515", "123");
      //  } catch (InterruptedException ex) {
        //    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       // }
            //tb1.setComponentPopupMenu(pop);
                  sort();
        
    }
    public GUI(String name,int u) {
        this.name=name;
        initComponents();
        setResizable(false);
      //  try {
       // setBackground(new Color(0,0,0,0));
     //   viewsetting.setEnable(true);
           // BOOK1.setVisible(false);
           
           hello.setText("Wellcome "+name);
           
           btn_sellClick(false);
            DefaultTableModel model = (DefaultTableModel) tb1.getModel();
            book[] books = cn.dvsv();
        
            System.out.println("lenght: "+books.length);
            
            int i=0;
            
            while(i!=(books.length)){
                model.addRow(new Object[] {books[i].getID(),books[i].getName(),books[i].getAuthor(),books[i].getCategory(),books[i].getPrice(),books[i].getSL()});
                i++;
            }
            //
            
            sort();
            
        cn.checkAdmin("B1706515", "123");
    
        
        btn_BOOK.setBackground(Color.white);
        btn_BOOK.setForeground(Color.BLUE);
        btn_BOOK.setBorder(BorderFactory.createEmptyBorder());
        btn_BOOK.setBorderPainted(false);
        btn_BOOK.setOpaque(true);
        table_listBook.setVisible(true);
        GT.setVisible(false);
        search.setVisible(true);
    }
    //sap xep thep cot
    public void sort(){
          DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        TableRowSorter <DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        tb1.setRowSorter(sorter);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop = new javax.swing.JPopupMenu();
        grouprad = new javax.swing.ButtonGroup();
        GT = new javax.swing.JLabel();
        btn_sell = new javax.swing.JButton();
        btn_BOOK = new javax.swing.JButton();
        hello = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        table_listBook = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        text_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        add_book = new javax.swing.JLabel();
        btn_del = new javax.swing.JButton();
        panelSell = new javax.swing.JPanel();
        rad_menbers = new javax.swing.JRadioButton();
        rad_guest = new javax.swing.JRadioButton();
        panel_menber = new javax.swing.JPanel();
        inputID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backgound = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1220, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Web 1280 – 2.jpg"))); // NOI18N
        getContentPane().add(GT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1030, 800));

        btn_sell.setBackground(new java.awt.Color(51, 102, 255));
        btn_sell.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_sell.setForeground(new java.awt.Color(255, 255, 255));
        btn_sell.setText("SELL");
        btn_sell.setBorder(null);
        btn_sell.setBorderPainted(false);
        btn_sell.setContentAreaFilled(false);
        btn_sell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_sell.setDefaultCapable(false);
        btn_sell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sellMouseClicked(evt);
            }
        });
        getContentPane().add(btn_sell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 220, 40));

        btn_BOOK.setBackground(new java.awt.Color(51, 102, 255));
        btn_BOOK.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_BOOK.setForeground(new java.awt.Color(255, 255, 255));
        btn_BOOK.setText("BOOK");
        btn_BOOK.setBorder(null);
        btn_BOOK.setBorderPainted(false);
        btn_BOOK.setContentAreaFilled(false);
        btn_BOOK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_BOOK.setDefaultCapable(false);
        btn_BOOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BOOKMouseClicked(evt);
            }
        });
        getContentPane().add(btn_BOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 220, 40));

        hello.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hello.setForeground(new java.awt.Color(255, 255, 255));
        hello.setText("Wellcome");
        hello.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helloMouseClicked(evt);
            }
        });
        getContentPane().add(hello, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 87, 130, 40));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Book", "Name", "Author", "Category", "Gia", "So Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        table_listBook.setViewportView(tb1);
        if (tb1.getColumnModel().getColumnCount() > 0) {
            tb1.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        search.add(table_listBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 770, 480));

        text_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_searchActionPerformed(evt);
            }
        });
        text_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_searchKeyTyped(evt);
            }
        });
        search.add(text_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        search.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 50, 70));

        add_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        add_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_bookMouseClicked(evt);
            }
        });
        search.add(add_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 70));

        btn_del.setText("Del");
        btn_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delMouseClicked(evt);
            }
        });
        search.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 80, 30));

        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 830, 670));

        panelSell.setBackground(new java.awt.Color(255, 255, 255));
        panelSell.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grouprad.add(rad_menbers);
        rad_menbers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rad_menbers.setText("Menbers");
        rad_menbers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rad_menbersMouseClicked(evt);
            }
        });
        panelSell.add(rad_menbers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 130, 40));

        grouprad.add(rad_guest);
        rad_guest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rad_guest.setText("Guest");
        rad_guest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rad_guestMouseClicked(evt);
            }
        });
        panelSell.add(rad_guest, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 130, 40));

        panel_menber.setBackground(new java.awt.Color(255, 255, 255));
        panel_menber.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_menber.add(inputID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 40));

        jLabel2.setText("ID member:");
        panel_menber.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 20));

        panelSell.add(panel_menber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 260, 100));

        getContentPane().add(panelSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 900, 650));

        backgound.setBackground(new java.awt.Color(255, 255, 255));
        backgound.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        backgound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Web 1280 – 1.jpg"))); // NOI18N
        backgound.setAlignmentY(0.0F);
        getContentPane().add(backgound, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BOOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BOOKMouseClicked
        // TODO add your handling code here:
       // btn_BOOK.setContentAreaFilled(true);
        
        BookClick(true);
    }//GEN-LAST:event_btn_BOOKMouseClicked

    private void helloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helloMouseClicked
        // TODO add your handling code here
        GT.setVisible(true);
        BookClick(false);
        btn_sellClick(false);
//        btn_BOOK.setBackground(new java.awt.Color(51, 102, 255));
//        btn_BOOK.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
//        btn_BOOK.setForeground(new java.awt.Color(255, 255, 255));
//        table_listBook.setVisible(false);
        //btn_BOOK.setText("BOOK");
//        btn_BOOK.setBorder(null);
//        btn_BOOK.setBorderPainted(false);
//        btn_BOOK.setContentAreaFilled(false);
       // btn_BOOK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//        btn_BOOK.setDefaultCapable(false);
//        btn_BOOK.setOpaque(false);
//        search.setVisible(false);
    }//GEN-LAST:event_helloMouseClicked

    private void text_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_searchKeyTyped
        String text = text_search.getText();
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tb1.getModel());
        tb1.setRowSorter(rowSorter);
        
        rowSorter.setRowFilter(RowFilter.regexFilter(text_search.getText()));
        
        
    }//GEN-LAST:event_text_searchKeyTyped

    private void text_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_searchActionPerformed

    private void add_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_bookMouseClicked
        this.setVisible(false);
        new Add_book(this.name).setVisible(true);
        
        
    }//GEN-LAST:event_add_bookMouseClicked

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
         DefaultTableModel model = (DefaultTableModel) tb1.getModel();
          index = tb1.getSelectedRow();
         
         getID = model.getValueAt(index, 0).toString();
         System.out.println(getID);
    }//GEN-LAST:event_tb1MouseClicked

    private void btn_delMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        cn.delBook(getID);
        new GUI(name,1).setVisible(true);
        this.setVisible(false);
        //model.removeRow(index);
        
    }//GEN-LAST:event_btn_delMouseClicked

    private void btn_sellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sellMouseClicked
        // TODO add your handling code here:
        btn_sellClick(true);
    }//GEN-LAST:event_btn_sellMouseClicked

    private void rad_menbersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rad_menbersMouseClicked
        // TODO add your handling code here:
        if(rad_menbers.isSelected()){
            panel_menber.setVisible(true);
        }
        
    }//GEN-LAST:event_rad_menbersMouseClicked

    private void rad_guestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rad_guestMouseClicked
        // TODO add your handling code here:
        if(rad_guest.isSelected()){
            panel_menber.setVisible(false);
        }
    }//GEN-LAST:event_rad_guestMouseClicked
     public void BookClick(boolean click){
        if(click == false){
        //GT.setVisible(true);
        btn_BOOK.setBackground(new java.awt.Color(51, 102, 255));
        btn_BOOK.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_BOOK.setForeground(new java.awt.Color(255, 255, 255));
        table_listBook.setVisible(false);
        btn_BOOK.setBorder(null);
        btn_BOOK.setBorderPainted(false);
        btn_BOOK.setContentAreaFilled(false);
       // btn_BOOK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_BOOK.setDefaultCapable(false);
        btn_BOOK.setOpaque(false);
        //GT.setVisible(true);
        
        table_listBook.setVisible(false);
        search.setVisible(false);
        }else{
        btn_BOOK.setBackground(Color.white);
        btn_BOOK.setForeground(Color.BLUE);
        btn_BOOK.setBorder(BorderFactory.createEmptyBorder());
        btn_BOOK.setBorderPainted(false);
        btn_BOOK.setOpaque(true);
        GT.setVisible(false);
        search.setVisible(true);
        //BookClick(false);
        search.setVisible(true);
        //search.setVisible(true);
        table_listBook.setVisible(true);
        tb1.setVisible(true);
        //GT.setVisible(false);
        btn_sellClick(false);
        }
    }
    
    public void btn_sellClick(boolean click){
        if(click == false){
        //GT.setVisible(true);
        
        btn_sell.setBackground(new java.awt.Color(51, 102, 255));
        btn_sell.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_sell.setForeground(new java.awt.Color(255, 255, 255));
        //table_listBook.setVisible(false);
        //btn_BOOK.setText("BOOK");
        btn_sell.setBorder(null);
        btn_sell.setBorderPainted(false);
        btn_sell.setContentAreaFilled(false);
       // btn_BOOK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_sell.setDefaultCapable(false);
        btn_sell.setOpaque(false);
        panelSell.setVisible(false);
        }else{
        GT.setVisible(false);
        panelSell.setVisible(true);
        //search.setVisible(false);
        btn_sell.setBackground(Color.white);
        btn_sell.setForeground(Color.BLUE);
        btn_sell.setBorder(BorderFactory.createEmptyBorder());
        btn_sell.setBorderPainted(false);
        btn_sell.setOpaque(true);
        //GT.setVisible(false);
        rad_guest.setSelected(true);
        panel_menber.setVisible(false);
        BookClick(false);
        }
    }
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI("hihi").setVisible(true);
            //    connector connector = new connector();
              //  connector.dvsv();
             //   DefaultTableModel model = (DefaultTableModel) tb1.getModel();
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GT;
    private javax.swing.JLabel add_book;
    private javax.swing.JLabel backgound;
    private javax.swing.JButton btn_BOOK;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_sell;
    private javax.swing.ButtonGroup grouprad;
    private javax.swing.JLabel hello;
    private javax.swing.JTextField inputID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelSell;
    private javax.swing.JPanel panel_menber;
    private javax.swing.JPopupMenu pop;
    private javax.swing.JRadioButton rad_guest;
    private javax.swing.JRadioButton rad_menbers;
    private javax.swing.JPanel search;
    private javax.swing.JScrollPane table_listBook;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField text_search;
    // End of variables declaration//GEN-END:variables
}
