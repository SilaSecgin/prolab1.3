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
    SERİROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ MANİPULATOR SINIFINI İMPLEMENT EDERKEN ROBOT SINIFINI EXTEND EDEN 
        BİR ROBOT SINIFIDIR. YANİ SERİROBOT SINIFI MANİPULATORROBOT SINIFININ ÖZELLİKLERİNİ TAŞIYAN 
        BİR ROBOTDUR DİYEBİLİRİZ.
    DEĞİŞKENLERİ:
        float yukTasimaKapasitesi;
        int kolUzunlugu;
        float tasimaHizi;
    FONKSİYONLARI : 
        set-get metotları
       
*/
public class SeriRobot extends Robot implements ManipulatorRobot {
    float yukTasimaKapasitesi;
    int kolUzunlugu;
    float tasimaHizi;
    
    public SeriRobot(int konumX,int konumY , float yukMiktari , int motorSayisi , String robotTuru,float yukTasimaKapasitesi , int kolUzunlugu , float tasimaHizi)
    {   
        super(konumX,konumY , yukMiktari , motorSayisi , robotTuru);
        this.yukTasimaKapasitesi = yukTasimaKapasitesi;
        this.kolUzunlugu = kolUzunlugu;
        this.tasimaHizi = tasimaHizi;
    }
    public SeriRobot()
    {
        
    }
    
    public float getYukTasimaKapasitesi()
    {
        return this.yukTasimaKapasitesi;
    }
    public void setYukTasimaKapasitesi(float yukTasimaKapasitesi){
        this.yukTasimaKapasitesi = yukTasimaKapasitesi;
    }

    @Override
    void yazdir() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Robotunuzun turu : "+this.robotTuru);
        System.out.println("Robotunuzun kol uzunlugu : "+this.kolUzunlugu);
        System.out.println("Robotunuzun tasima Hizi : "+this.tasimaHizi);
        System.out.println("Robotunuzun yuk miktari : "+this.yukMiktari);
        System.out.println("Robotunuzun motor sayisi : "+this.motorSayisi);
        System.out.println("Robotunuzun x konumu : "+this.konumX);
        System.out.println("Robotunuzun y konumu: "+this.konumY);
        System.out.println("Robotunuzun yük tasima kapasitesi : "+this.yukTasimaKapasitesi);
    }
    
}
