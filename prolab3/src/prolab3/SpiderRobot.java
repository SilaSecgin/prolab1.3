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
    SPİDERROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ GEZGİNROBOT SINIFINI İMPLEMENT EDERKEN ROBOT SINIFINI EXTEND EDEN 
        BİR ROBOT SINIFIDIR. YANİ SPİDERROBOT SINIFI GEZGİNROBOT SINIFININ ÖZELLİKLERİNİ TAŞIYAN 
        BİR ROBOTDUR DİYEBİLİRİZ.BU ROBOTLAR ENGELDEN GEÇEMEZLER
    DEĞİŞKENLERİ:
        float gezinmehizi;
        int bacakSayisi;
    FONKSİYONLARI : 
        set-get metotları
       @override engelGecmeSuresiBul();
*/
public class SpiderRobot extends Robot  implements GezginRobot {

    float gezinmeHizi;
    int bacakSayisi;
    
    public SpiderRobot(int konumX,int konumY , float yukMiktari , int motorSayisi , String robotTuru,float gezinmeHizi ,int bacakSayisi){
        super(konumX,konumY , yukMiktari ,motorSayisi , robotTuru);
        this.gezinmeHizi = gezinmeHizi;
        this.bacakSayisi = bacakSayisi;
    }
    public SpiderRobot(){
        
    }
    public int getBacakSayisi()
    {
       return this.bacakSayisi;
    }
    
    public void setBacakSayisi(int bacakSayisi)
    {
       this.bacakSayisi = bacakSayisi;
    } 
    public float getGezinmeHizi()
    {
        return this.gezinmeHizi;
    }    
    public void setGezinmeHizi(float gezinmeHizi)
    {
        this.gezinmeHizi = gezinmeHizi;
    }  

    @Override
    public double engelGecmeSuresiBul() {
        System.out.println("Spider robotlar engelden gecemezler.. ");
        return 0;
    }

    @Override
    void yazdir() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Robotunuzun turu : "+this.robotTuru);
        System.out.println("Robotunuzun tekerlek sayisi : "+this.bacakSayisi);
        System.out.println("Robotunuzun gezinme Hizi : "+this.gezinmeHizi);
        System.out.println("Robotunuzun yuk miktari : "+this.yukMiktari);
        System.out.println("Robotunuzun motor sayisi : "+this.motorSayisi);
        System.out.println("Robotunuzun x konumu : "+this.konumX);
        System.out.println("Robotunuzun y konumu: "+this.konumY);
    }
}
