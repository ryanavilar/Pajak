/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining;

/**
 *
 * @author Ryan Avila
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Reader {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    // ITERATE EVERY SHEET TO GET ALL DATA
    public String[][] readAll() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String[][] bundle = null;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            bundle = new String[w.getNumberOfSheets()][100000];
            // Get the first sheet
            for(int i = 0;i < w.getNumberOfSheets();i++){
                
                bundle[i] = readBundle(i);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return bundle;
    }
    
    //NEEDED FOR READ ALL
    private String[] readBundle(double sheets) throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String[] bundle = null;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet((int)sheets);
            bundle = new String[sheet.getRows()];
            // Loop over first 10 column and lines
            for (int i = 0; i < sheet.getRows(); i++) {
                Cell cell = sheet.getCell(1, i);
                bundle[i] = cell.getContents().toString();
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return bundle;
    }
    
    public void getShot(int a,int b){
        File inputWorkbook = new File(inputFile);
            Workbook w;
        try {
            
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            System.out.println(sheet.getCell(a,b).getContents().toString());
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] GetPPNBundle(int row) throws IOException {
        File inputWorkbook = new File(inputFile);
        
        Workbook w;
        String[] PPNbundle = null;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            PPNbundle = new String[14];
            // Loop over first 10 column and lines
            System.out.println("WIUW "+row);
            System.out.println("");
            
            for (int i = 0; i < sheet.getColumns(); i++) {
                System.out.println("iterasi ke - " + i);
                Cell cell = sheet.getCell(i, row);
                System.out.println(cell.getContents().toString());
                PPNbundle[i] = cell.getContents().toString();
                
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return PPNbundle;
    }
    
    // SIMPLE
    // Read Data in Excel and convert to Bundle(Aray)
    public String[] readBundle(int chose) throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String[] bundle = null;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            bundle = new String[sheet.getRows()];
            // Loop over first 10 column and lines
            for (int i = 0; i < sheet.getRows(); i++) {
                Cell cell = sheet.getCell(chose, i);
                bundle[i] = cell.getContents().toString();
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return bundle;
    }
}
