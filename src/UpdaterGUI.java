import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Raffi
 */
public class UpdaterGUI extends javax.swing.JFrame {
    File directoryFolder;
    File paymentTracking;
    /**
     * Creates new form UpdaterGUI
     */
    public UpdaterGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        directoryButton = new javax.swing.JButton();
        folderDirectoryLabel = new javax.swing.JLabel();
        browseForPaymentTracking = new javax.swing.JButton();
        paymentTrackingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter the Date:");

        Update.setText("Update Invoices");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        directoryButton.setText("Browse for Invoices Folder");
        directoryButton.setAlignmentX(0.5F);
        directoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directoryButtonActionPerformed(evt);
            }
        });

        folderDirectoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        folderDirectoryLabel.setText("No File Chosen");

        browseForPaymentTracking.setText("Browse for Payment Tracking Excel File");
        browseForPaymentTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseForPaymentTrackingActionPerformed(evt);
            }
        });

        paymentTrackingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paymentTrackingLabel.setText("No File Chosen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateField)
                .addGap(10, 10, 10))
            .addComponent(paymentTrackingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(browseForPaymentTracking, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(directoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addComponent(folderDirectoryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browseForPaymentTracking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paymentTrackingLabel)
                .addGap(18, 18, 18)
                .addComponent(directoryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(folderDirectoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(Update)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        
    }//GEN-LAST:event_dateFieldActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        HashMap <String,Student> students = getStudents(paymentTracking);
        
        String date="";
        if(this.dateField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"You must enter a date","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
            date = this.dateField.getText();
        if(directoryFolder == null || paymentTracking == null)
        {
            JOptionPane.showMessageDialog(this,"You must browse for both files","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        updateFiles(directoryFolder,date,students);
    }//GEN-LAST:event_UpdateActionPerformed

    private void directoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directoryButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setCurrentDirectory(new File("."));
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();
            directoryFolder = selectedFile;
            this.folderDirectoryLabel.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_directoryButtonActionPerformed

    private void browseForPaymentTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseForPaymentTrackingActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();
            paymentTracking = selectedFile;
            this.paymentTrackingLabel.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_browseForPaymentTrackingActionPerformed

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
            java.util.logging.Logger.getLogger(UpdaterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdaterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdaterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdaterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdaterGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton browseForPaymentTracking;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton directoryButton;
    private javax.swing.JLabel folderDirectoryLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel paymentTrackingLabel;
    // End of variables declaration//GEN-END:variables
    public static void updateFiles(File mainFolder, String date, HashMap<String,Student> students)
    {
        ArrayList<String> problemStudents = new ArrayList<>();
        String month = getMonth(date);
        File folders[] = mainFolder.listFiles();
        for(int i = 0;i<folders.length;i++)
        {
            File[] arr = folders[i].listFiles();
            for(int j = 0;j<arr.length;j++)
            {
                Student student = getStudent(arr[j],students);
                if(student == null)
                {
                    problemStudents.add(arr[j].getName().substring(0,arr[j].getName().length()-4)); //adding name of file to problem students list, not including .xls extension
                    arr[j] = setNoticeFixFileName(arr[j]);
                    continue;
                }
                arr[j] = resetFileName(arr[j]);
                System.out.println("Writing to file " + arr[j].getName() + "...");
                int[] paymentInfo = getMonthsUnpaid(arr[j], student, date);
                updatePrice(arr[j],paymentInfo, student, date);
                updateDate(arr[j],date,month);
            }
        }
        String problemStudentPrintout = "Following student(s) could not be updated because of name mismatch:\n";
        if(problemStudents.size()>0)
        {
            for(int i = 0;i<problemStudents.size();i++)
            {
                problemStudentPrintout+=problemStudents.get(i)+"\n";
            }
        }
        else
        {
            problemStudentPrintout = "All student invoices updated successfully";
        }
        JOptionPane.showConfirmDialog(null,
                problemStudentPrintout,
                "Done running",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
    public static void updateDate(File file, String date, String month)
    {
        try
        {
                FileInputStream fsIP= new FileInputStream(file); 
                HSSFWorkbook wb = new HSSFWorkbook(fsIP);     
                HSSFSheet worksheet = wb.getSheetAt(0); 
                HSSFCell cell = null;
                cell = worksheet.getRow(12).getCell(12);
                cell.setCellValue(date);  
                cell = worksheet.getRow(45).getCell(2);
                cell.setCellValue("Payment is due within the first week of "+month);
                fsIP.close();
                FileOutputStream outputFile =new FileOutputStream(file);
                wb.write(outputFile); 
                outputFile.close();   
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static Student getStudent(File file, HashMap<String,Student> students)
    {
        String name = file.getName().replace(" ","");
        name = name.replace('_','&');
        name = name.substring(0,name.length()-4);
        return students.get(name);
    }
    public static int[] getMonthsUnpaid(File file, Student student, String date)
    {
        
        //determining # of months unpaid
        int month = getIntegerMonth(date);
        int monthsUnpaid = 0;
        int credit = 0;
        for(int i = month;i>=0;i--)
        {
            String payment = student.payments[i].replace(" ","");
            if(payment.equals(student.expected+"") || payment.equals("N/A") || payment.equals("PAID"))
                break;
            else if(payment.contains("CR"))
            {
                monthsUnpaid+=1;
                String intString = payment.substring(0,payment.indexOf('C'));
                credit = Integer.parseInt(intString);
                break;
            }
            else if(payment.equals("LATE") || payment.equals("0"))
                monthsUnpaid+=1;
        }
        int[] arr = {monthsUnpaid,credit};
        return arr;
    }
    public static int getIntegerMonth(String date)
    {
        int month = Integer.parseInt(date.substring(0,1));
        if(date.charAt(2) == '/')
            month = Integer.parseInt(date.substring(0,2));
        return month;
    }
    public static int getNextIntegerMonth(int month)
    {
        if(month == 12)
            return 1;
        else
            return month++;
    }
    public static String getMonth(String date)
    {
        int month = getIntegerMonth(date);
        String monthString;
        switch(month)
        {
            
            case 1:  monthString = "February";
                     break;
            case 2:  monthString = "March";
                     break;
            case 3:  monthString = "April";
                     break;
            case 4:  monthString = "May";
                     break;
            case 5:  monthString = "June";
                     break;
            case 6:  monthString = "July";
                     break;
            case 7:  monthString = "August";
                     break;
            case 8:  monthString = "September";
                     break;
            case 9:  monthString = "October";
                     break;
            case 10: monthString = "November";
                     break;
            case 11: monthString = "December";
                     break;
            case 12: monthString = "January";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
    }
    public static String getMonth(int month)
    {
        String monthString;
        switch(month)
        {
            case 0:  monthString = "January";
                     break;
            case 1:  monthString = "February";
                     break;
            case 2:  monthString = "March";
                     break;
            case 3:  monthString = "April";
                     break;
            case 4:  monthString = "May";
                     break;
            case 5:  monthString = "June";
                     break;
            case 6:  monthString = "July";
                     break;
            case 7:  monthString = "August";
                     break;
            case 8:  monthString = "September";
                     break;
            case 9:  monthString = "October";
                     break;
            case 10: monthString = "November";
                     break;
            case 11: monthString = "December";
                     break;
            case 12: monthString = "January";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
    }
    public static HashMap<String,Student> getStudents(File paymentTracking)
    {
        HashMap<String,Student> students = new HashMap<>();
        try
        {
            FileInputStream fsIP= new FileInputStream(paymentTracking); 
            HSSFWorkbook wb = new HSSFWorkbook(fsIP);
            int numSheets = wb.getNumberOfSheets();
            for(int i = 0;i<numSheets;i++)
            {
                HSSFSheet currSheet = wb.getSheetAt(i);
                int k = 1;
                HSSFRow currRow = currSheet.getRow(k);
                while(!currRow.getCell(0).getStringCellValue().equals("Total")) //while loop to go through all the students in the sheet
                {
                    String name = currRow.getCell(0).getStringCellValue().replace(" ","");
                    int expected = (int) currRow.getCell(1).getNumericCellValue();
                    String[] payments = new String[12];
                    for(int j = 0;j<12;j++)
                    {
                        HSSFCell currCell = currRow.getCell(j+2);
                        if(currCell == null)
                            payments[j] = "0";
                        else if(currCell.getCellType() == 1)
                            payments[j] = currCell.getStringCellValue();
                        else
                            payments[j] = (int)currCell.getNumericCellValue()+"";
                    }
                    Student s = new Student(name,expected,payments);
                    students.put(s.name, s);
                    k++;
                    currRow = currSheet.getRow(k);
                }
            }
            fsIP.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return students;
    }
    public static void updatePrice(File file, int[] paymentInfo, Student student, String date)
    {
        int month = getNextIntegerMonth(getIntegerMonth(date));
        int monthsUnpaid = paymentInfo[0];
        int credit = paymentInfo[1];
        try
        {
            if(monthsUnpaid == 0) //case that the student owes nothing
            {
                String newName = file.getAbsolutePath().substring(0,file.getAbsolutePath().length()-4) + " (Do not send).xls";
                File newFile = new File(newName);
                try 
                {
                    newFile.createNewFile();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(UpdaterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileInputStream fsIP= new FileInputStream(file);
                HSSFWorkbook wb = new HSSFWorkbook(fsIP);
                HSSFSheet worksheet = wb.getSheetAt(0);
                HSSFRow currRow;
                for(int i = 18;i<35;i++)
                {
                    currRow = worksheet.getRow(i);
                    currRow.getCell(2).setCellValue("");
                    currRow.getCell(3).setCellValue("");
                    currRow.getCell(11).setCellValue("");
                }
                HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
                FileOutputStream outputFile =new FileOutputStream(newFile);
                wb.write(outputFile); 
                outputFile.close();
                file.delete();
            }
            else
            {
                FileInputStream fsIP = new FileInputStream(file);
                HSSFWorkbook wb = new HSSFWorkbook(fsIP);
                HSSFSheet worksheet = wb.getSheetAt(0);
                int index = 18;
                HSSFRow currRow;
                String strMonth;
                for(int i = 18;i<35;i++)
                {
                    currRow = worksheet.getRow(i);
                    currRow.getCell(2).setCellValue("");
                    currRow.getCell(3).setCellValue("");
                    currRow.getCell(11).setCellValue("");
                }
                for(int i = 0;i<monthsUnpaid;i++)
                {
                    currRow = worksheet.getRow(index);
                    strMonth = getMonth(month);
                    currRow.getCell(2).setCellValue(1);
                    currRow.getCell(3).setCellValue("Monthly Tuition - "+strMonth);
                    currRow.getCell(11).setCellValue(student.expected);
                    index++;
                    month--;
                }
                if(credit>0)
                {
                    currRow = worksheet.getRow(index);
                    currRow.getCell(2).setCellValue(1);
                    currRow.getCell(3).setCellValue("$"+credit+" Credit");
                    currRow.getCell(11).setCellValue(-credit);
                }
                HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
                fsIP.close();
                FileOutputStream outputFile =new FileOutputStream(file);
                wb.write(outputFile); 
                outputFile.close();
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static File resetFileName(File file)
    {
        
        if(!(file.getName().contains("(Do not send)") || file.getName().contains("_")))
            return file;
        try
        {
            String newName = file.getAbsolutePath();
            if(file.getName().contains("(Do not send)"))
                newName = newName.substring(0,newName.length()-18) + ".xls"; //removing (do not send)
            newName = newName.replace("_","&");
            File newFile = new File(newName);
            try 
            {
                newFile.createNewFile();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(UpdaterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            FileInputStream fsIP= new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(fsIP);
            FileOutputStream outputFile =new FileOutputStream(newFile);
            wb.write(outputFile); 
            outputFile.close();
            file.delete();
            return newFile;
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return file;
    }
    public static File setNoticeFixFileName(File file)
    {
        try
        {
            String newName = file.getAbsolutePath();
            newName = newName.substring(0,newName.length()-4) + "(Fix name mismatch).xls"; //removing (do not send)
            newName = newName.replace("_","&");
            File newFile = new File(newName);
            try 
            {
                newFile.createNewFile();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(UpdaterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            FileInputStream fsIP= new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(fsIP);
            FileOutputStream outputFile =new FileOutputStream(newFile);
            wb.write(outputFile); 
            outputFile.close();
            file.delete();
            return newFile;
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return file;
    }
    
}
