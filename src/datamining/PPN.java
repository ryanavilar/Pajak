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
public class PPN {

    String No;
    String noFaktur;
    String TglFaktur;
    String MPSendiri;
    String MPSPL;
    String NPWP;
    String NPWPOK;
    String Nama;
    String PPNSPL;
    String PPNM;
    String STAT;
    String SELPPN;
    String KOR;
    String NpwpErr;

    public PPN(String No,
            String noFaktur,
            String TglFaktur,
            String MPSendiri,
            String MPSPL,
            String NPWP,
            String NPWPOK,
            String Nama,
            String PPNSPL,
            String PPNM,
            String STAT,
            String SELPPN,
            String KOR,
            String NpwpErr) {

        this.No = No;
        this.noFaktur = noFaktur;
        this.TglFaktur = TglFaktur;
        this.MPSendiri = MPSendiri;
        this.MPSPL = MPSPL;
        this.NPWP = NPWP;
        this.NPWPOK = NPWPOK;
        this.Nama = Nama;
        this.PPNSPL = PPNSPL;
        this.PPNM = PPNM;
        this.STAT = STAT;
        this.SELPPN = SELPPN;
        this.KOR = KOR;
        this.NpwpErr = NpwpErr;

    }

    public PPN(String[] PPNbundle) {
        this.No = PPNbundle[0];
        this.noFaktur = PPNbundle[1];
        this.TglFaktur = PPNbundle[2];
        this.MPSendiri = PPNbundle[3];
        this.MPSPL = PPNbundle[4];
        this.NPWP = PPNbundle[5];
        this.NPWPOK = PPNbundle[6];
        this.Nama = PPNbundle[7];
        this.PPNSPL = PPNbundle[8];
        this.PPNM = PPNbundle[9];
        this.STAT = PPNbundle[10];
        this.SELPPN = PPNbundle[11];
        this.KOR = PPNbundle[12];
        this.NpwpErr = PPNbundle[13];
    }

}
