import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;
public class InvoiceUpdater
{
    public static void main(String[] args)
    {
        try
        {
        FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\Raffi\\Desktop\\Beglarian, Colette.xls")); //Read the spreadsheet that needs to be updated
                  
                HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
                  
                HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
                  
                HSSFCell cell = null; // declare a Cell object
                
                cell = worksheet.getRow(12).getCell(12);   // Access the second cell in second row to update the value
                  
                cell.setCellValue("1/21/18");  // Get current cell value value and overwrite the value
                  
                fsIP.close(); //Close the InputStream
                 
                FileOutputStream output_file =new FileOutputStream("C:\\Users\\Raffi\\Desktop\\Beglarian, Colette.xls");  //Open FileOutputStream to write updates
                  
                wb.write(output_file); //write changes
                  
                output_file.close();  //close the stream    
        
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        /*Student s;
        int[] temp = {1,2,3,4};
        s = new Student("Kuzik","Stella",90,temp);
        s.displayStudent();*/
    }
}
