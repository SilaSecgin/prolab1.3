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
    PARALELROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ MANİPULATOR SINIFINI İMPLEMENT EDERKEN ROBOT SINIFINI EXTEND EDEN 
        BİR ROBOT SINIFIDIR. YANİ PARALELROBOT SINIFI MANİPULATORROBOT SINIFININ ÖZELLİKLERİNİ TAŞIYAN 
        BİR ROBOTDUR DİYEBİLİRİZ.
    DEĞİŞKENLERİ:
        float yukTasimaKapasitesi;
        int kolUzunlugu;
        float tasimaHizi;
    FONKSİYONLARI : 
        set-get metotları
       
*/
public class ParalelRobot extends Robot implements ManipulatorRobot{
    float yukTasimaKapasitesi;
    int kolUzunlugu;
    float tasimaHizi;
    
    public ParalelRobot(int konumX,int konumY , float yukMiktari , int motorSayisi , String robotTuru,float yukTasimaKapasitesi , int kolUzunlugu , float tasimaHizi)
    {   
        super(konumX,konumY ,yukMiktari ,motorSayisi ,robotTuru);
        this.yukTasimaKapasitesi = yukTasimaKapasitesi;
        this.kolUzunlugu = kolUzunlugu;
        this.tasimaHizi = tasimaHizi;
    }
    public ParalelRobot()
    {
        
    }

    @Override
    void yazdir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
