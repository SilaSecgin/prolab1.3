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
    TEKERLEKLİROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ GEZGİNROBOT SINIFINI İMPLEMENT EDERKEN ROBOT SINIFINI EXTEND EDEN 
        BİR ROBOT SINIFIDIR. YANİ TEKERLEKLİ ROBOT SINIFI GEZGİNROBOT SINIFININ ÖZELLİKLERİNİ TAŞIYAN 
        BİR ROBOTDUR DİYEBİLİRİZ.
    DEĞİŞKENLERİ:
        float gezinmehizi;
        int tekerlekSayisi;
    FONKSİYONLARI : 
        set-get metotları
       @override engelGecmeSuresiBul();
*/
public class TekerlekliRobot extends Robot implements GezginRobot {

    float gezinmeHizi;
    int tekerlekSayisi;
     
    public TekerlekliRobot(int konumX,int konumY , float yukMiktari , int motorSayisi , String robotTuru,float gezinmeHizi , int tekerlekSayisi)
    {
        super(konumX,konumY , yukMiktari ,motorSayisi , robotTuru);
        this.gezinmeHizi = gezinmeHizi;
        this.tekerlekSayisi = tekerlekSayisi;
    }
    public TekerlekliRobot()
    {
        
    }
    public float getGezinmeHizi(){
        return this.gezinmeHizi;
    }
    public void setGezinmeHizi(float gezinmeHizi){
        this.gezinmeHizi = gezinmeHizi;
    }
    public int getTekerlekSayisi(){
       return this.tekerlekSayisi;
    }
    
    public void setTekerlekSayisi(int tekerlekSayisi){
       this.tekerlekSayisi = tekerlekSayisi;
    }

    @Override
    public double engelGecmeSuresiBul() {
        return this.getMotorSayisi()*0.5;
    }

    @Override
    void yazdir() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Robotunuzun turu : "+this.robotTuru);
        System.out.println("Robotunuzun tekerlek sayisi : "+this.tekerlekSayisi);
        System.out.println("Robotunuzun gezinme Hizi : "+this.gezinmeHizi);
        System.out.println("Robotunuzun yuk miktari : "+this.yukMiktari);
        System.out.println("Robotunuzun motor sayisi : "+this.motorSayisi);
        System.out.println("Robotunuzun x konumu : "+this.konumX);
        System.out.println("Robotunuzun y konumu: "+this.konumY);
    }
    
    
}
