/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;

/**
 *
 * @author ryuzaki
 */
/*
/*
    HİBRİTROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ EN KARMAŞIK SINIFTIR .BU SINIF ROBOT SINIFININ ÖZELLİKLERİNİN YANI SIRA 
        GEZGİNROBOT VE MANİPULATOR ROBOTUNUN ÖZELLİKLERİNİDE BARINDIRABİLMEKTEDİR.YANİ HEM TEKERLEKLİ 
        AYNI ZAMANDA PARALEL BİR ROBOT OLUŞTURABİLİRSİNİZ . SEBEBİ İSE GEZGİNROBOT VE MANİPULATOR ROBOTU İMPLEMENT
        EDERKEN ROBOT SINIFINIDA EXTEND ETMEKTEDİR. YANİ BİR HİBRİT ROBOTA GEZGİN VE MANİPULATOR ROBOTU ÖZELLİKLERİ
        TAŞIYABİLEN BİR ROBOTDUR DİYEBİLİRSİNİZ
    FONKSİYONLARI : 
        @override engelGecmeSuresiBul();
*/

public  class HibritRobot extends Robot implements GezginRobot,ManipulatorRobot {
    public int sabitlemeSuresi;
    public int gecisSuresi;

    @Override
    public double engelGecmeSuresiBul() {
        
        return 0;
    }
    public HibritRobot(int konumX,int konumY ,int tekerlekSayisi,float gezinmeHizi,float yukMiktari,int motorSayisi,String robotTuru,int kolUzunlugu,float yukTasimaKapasitesi,float tasimaHizi)
    {
        super(konumX,konumY ,yukMiktari ,motorSayisi ,robotTuru);
        
    }
    public HibritRobot()
    {
        
    }

    @Override
    void yazdir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
