/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Ryan Avila
 */
public class Mining {

    String[] dataBundle;
    String[][] complexBundle;
    ArrayList<String> key;
    HashMap<String, Integer> dataFound;
    ArrayList<String> DuplicateData;
    ArrayList<PPN> DupPPNBundle;

    public Mining() {
        dataFound = new HashMap<String, Integer>();
        DupPPNBundle = new ArrayList<PPN>();
        DuplicateData = new ArrayList<String>();
        key = new ArrayList<String>();
    }

    public void SearchAuto() {
        for (int i = 1; i < dataBundle.length; i++) {
            Search(dataBundle[i]);
        }
    }

    public void SearchComplexAuto() {
        for (int i = 0; i < complexBundle.length; i++) {

            for (int j = 1; j < complexBundle[i].length; j++) {
                SearchPure(complexBundle[i][j]);
            }
            switch (i) {
                case 0:
                    System.out.println("JANUARY");
                    break;
                case 1:
                    System.out.println("FEBRUARY");
                    break;
                case 2:
                    System.out.println("MARCH");
                    break;
                case 3:
                    System.out.println("APRIL");
                    break;
                case 4:
                    System.out.println("MAY");
                    break;
                case 5:
                    System.out.println("JUNE");
                    break;
                case 6:
                    System.out.println("JULY");
                    break;
                case 7:
                    System.out.println("AUGUST");
                    break;
                case 8:
                    System.out.println("SEPTEMBER");
                    break;
                case 9:
                    System.out.println("OCTOBER");
                    break;
                case 10:
                    System.out.println("NOVEMBER");
                    break;
                case 11:
                    System.out.println("DECEMBER");
                    break;
            }
            printResult();
            dataFound = new HashMap<String, Integer>();
            key = new ArrayList<String>();
            System.out.println("");
        }
    }

    public void SearchPure(String search) {
        if (!key.contains(search)) {
            key.add(search);
            dataFound.put(search, 0);
            int numOfData = 0;
            for (int i = 1; i < dataBundle.length; i++) {
                if (dataBundle[i].equals(search)) {
                    numOfData++;
                }
            }
            dataFound.replace(search, numOfData);
        }

    }

    public void Search(String search) {
        if (!key.contains(search)) {
            key.add(search);
            dataFound.put(search, 0);
            int numOfData = 0;
            System.out.println("Searching for " + search + " ......");

            for (int i = 1; i < dataBundle.length; i++) {
                if (dataBundle[i].equals(search)) {
                    System.out.println(search + " Found");
                    numOfData++;
                }
            }
            dataFound.replace(search, numOfData);
            System.out.println("");
        }
    }

    public ArrayList<PPN> GetTheDuplicate() throws IOException {
        Reader read = new Reader();
        read.setInputFile("c:/tmp/input.xls");
        for (int i = 1; i < dataBundle.length; i++) {
            SearchAndRead(dataBundle[i]);
        }
        printDuplicate();
        for (String str : DuplicateData) {
            String[] Row = str.split("&");
            for (String r : Row) {
                PPN tax = new PPN(read.GetPPNBundle(Integer.parseInt(r)));
                DupPPNBundle.add(tax);
            }
        }
        return DupPPNBundle;
    }

    public ArrayList<PPN> GetAllTheDuplicate() throws IOException {
        String[][] bundle = null;
        Reader read = new Reader();
        read.setInputFile("c:/tmp/input.xls");
        for (int i = 0; i < complexBundle.length; i++) {
            for (int j = 1; j < complexBundle[i].length; j++) {
                SearchAndRead(complexBundle[i][j]);
            }
        }
        printDuplicate();
        for (String str : DuplicateData) {
            String[] Row = str.split("&");
            for (String r : Row) {
                PPN tax = new PPN(read.GetPPNBundle(Integer.parseInt(r)));
                DupPPNBundle.add(tax);
            }
        }
        return DupPPNBundle;
    }

    public void SearchAndRead(String search) {
        if (!key.contains(search)) {
            key.add(search);
            int numOfData = 0;
            String tmp = "";
            System.out.println("Searching for " + search + " ......");
            for (int i = 1; i < dataBundle.length; i++) {
                if (dataBundle[i].equals(search)) {
                    System.out.println(search + " Found");
                    numOfData++;

                    if (numOfData == 1) {
                        tmp = String.valueOf(i);
                    }
                    if (numOfData > 1) {
                        tmp += "&" + String.valueOf(i);
                    }
                }
            }
            if(numOfData > 1){
            DuplicateData.add(tmp);
            }
            
        }
        System.out.println("");
    }

    public void printDuplicate() {
        for (String dup : DuplicateData) {
            System.out.println(dup);
        }
    }

    public void printResult() {
        int notFound = 0;
        for (String k : key) {
            if (dataFound.get(k) > 1) {
                System.out.println(k + " = " + dataFound.get(k));
            } else {
                notFound++;
            }
        }
        if (notFound == key.size()) {
            System.out.println("NO DUPLICATE DATA FOUND");
        }

    }
}
