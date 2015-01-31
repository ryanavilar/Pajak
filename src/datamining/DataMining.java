/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining;

import java.io.File;
import java.io.IOException;
import jxl.write.WriteException;


/**
 *
 * @author Ryan Avila
 */

public class DataMining {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, WriteException {
        // TODO code application logic here
        Reader test = new Reader();
        Mining min = new Mining();
        Writer testo = new Writer();
        testo.setOutputFile("c:/tmp/output2.xls");
        

//        System.out.println("INPUT PLUS");
        test.setInputFile("c:/tmp/input.xls");
//                test.getShot(8, 3000);
//                test.getShot(8, 1135);
        min.dataBundle = test.readBundle(8);
        min.complexBundle = test.readAll();
        
        testo.write(min.GetAllTheDuplicate());
//        min.SearchComplexAuto();
//        
//        System.out.println("INPUT MINUS");
//        test.setInputFile("c:/tmp/input2.xls");
//        min.dataBundle = test.readBundle();
//        min.complexBundle = test.readAll();
//        
//        min.SearchComplexAuto();
//        min.SearchAuto();
//        min.printResult();
        
       
  }

}
