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
import java.util.ArrayList;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Writer {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void write(ArrayList<PPN> PPNBundle) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        createContent(excelSheet,PPNBundle);

        workbook.write();
        workbook.close();
        System.out.println("DATA DUPLICATE VIEWER CREATED");
    }

    private void createLabel(WritableSheet sheet)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        // Write a few headers
        addCaption(sheet, 0, 0, "NO");
        addCaption(sheet, 1, 0, "NO FAK");
        addCaption(sheet, 2, 0, "Tgl FAK");
        addCaption(sheet, 3, 0, "MPSendiri");
        addCaption(sheet, 4, 0, "MPSPL");
        addCaption(sheet, 5, 0, "NPWP");
        addCaption(sheet, 6, 0, "NPWPOK");
        addCaption(sheet, 7, 0, "NAMA");
        addCaption(sheet, 8, 0, "PPNSPL");
        addCaption(sheet, 9, 0, "PPNM");
        addCaption(sheet, 10, 0, "STAT");
        addCaption(sheet, 11, 0, "SELPPN");
        addCaption(sheet, 12, 0, "KOR");
        addCaption(sheet, 13, 0, "NpwpErr");
    }

    private void createContent(WritableSheet sheet, ArrayList<PPN> PPNBundle) throws WriteException,
            RowsExceededException {
        
        for(int i = 0;i < PPNBundle.size();i++){
            addLabel(sheet, 0, i+1 , String.valueOf(PPNBundle.get(i).No));
            addLabel(sheet, 1, i+1 , String.valueOf(PPNBundle.get(i).noFaktur));
            addLabel(sheet, 2, i+1 , String.valueOf(PPNBundle.get(i).TglFaktur));
            addLabel(sheet, 3, i+1 , String.valueOf(PPNBundle.get(i).MPSendiri));
            addLabel(sheet, 4, i+1 , String.valueOf(PPNBundle.get(i).MPSPL));
            addLabel(sheet, 5, i+1 , String.valueOf(PPNBundle.get(i).NPWP));
            addLabel(sheet, 6, i+1 , String.valueOf(PPNBundle.get(i).NPWPOK));
            addLabel(sheet, 7, i+1 , String.valueOf(PPNBundle.get(i).Nama));
            addLabel(sheet, 8, i+1 , String.valueOf(PPNBundle.get(i).PPNSPL));
            addLabel(sheet, 9, i+1 , String.valueOf(PPNBundle.get(i).PPNM));
            addLabel(sheet, 10, i+1 , String.valueOf(PPNBundle.get(i).STAT));
            addLabel(sheet, 11, i+1 , String.valueOf(PPNBundle.get(i).SELPPN));
            addLabel(sheet, 12, i+1 , String.valueOf(PPNBundle.get(i).KOR));
            addLabel(sheet, 13, i+1 , String.valueOf(PPNBundle.get(i).NpwpErr));
        }
        
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row,
            Integer integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);

    }
}
