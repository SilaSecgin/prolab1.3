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
    PALETLİROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ GEZGİNROBOT SINIFINI İMPLEMENT EDERKEN ROBOT SINIFINI EXTEND EDEN 
        BİR ROBOT SINIFIDIR. YANİ PALETLİROBOT SINIFI GEZGİNROBOT SINIFININ ÖZELLİKLERİNİ TAŞIYAN 
        BİR ROBOTDUR DİYEBİLİRİZ.
    DEĞİŞKENLERİ:
        float gezinmehizi;
        int paletSayisi;
    FONKSİYONLARI : 
        set-get metotları
       @override engelGecmeSuresiBul();
*/
public class PaletliRobot extends Robot  implements GezginRobot {

    float gezinmeHizi;
private    int paletSayisi;
    public PaletliRobot(int konumX , int konumY,float yukMiktari,int motorSayisi,String robotTuru,float gezinmeHizi , int paletSayisi)
    {
        super(konumX,konumY , yukMiktari ,motorSayisi , robotTuru);
        this.gezinmeHizi = gezinmeHizi;
        this.paletSayisi = paletSayisi;
    }
    public PaletliRobot()
    {
        
    }
    public int getPaletSayisi(){
       return this.paletSayisi;
    }   
    public void setPaletSayisi(int paletSayisi){
       this.paletSayisi = paletSayisi;
    } 
    public void setGezinmeHizi(float gezinmeHizi){
        this.gezinmeHizi = gezinmeHizi;
    }
    public float getGezinmeHizi(){
        return this.gezinmeHizi;
    }
    @Override
    public double engelGecmeSuresiBul() {
        return this.getMotorSayisi()*3;
    }

    @Override
    void yazdir() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Robotunuzun turu : "+this.robotTuru);
        System.out.println("Robotunuzun palet sayisi : "+this.paletSayisi);
        System.out.println("Robotunuzun gezinme Hizi : "+this.gezinmeHizi);
        System.out.println("Robotunuzun yuk miktari : "+this.yukMiktari);
        System.out.println("Robotunuzun motor sayisi : "+this.motorSayisi);
        System.out.println("Robotunuzun x konumu : "+this.konumX);
        System.out.println("Robotunuzun y konumu: "+this.konumY);
    }

  
}
