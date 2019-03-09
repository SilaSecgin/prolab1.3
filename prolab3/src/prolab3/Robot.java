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
    ROBOT SINIFI : 
        AĞAÇ YAPISINDAKİ TÜM ROBOTLARIN ORTAK ÖZELLİKLERİNİ BARINDIRDIĞI ABSTRACT BİR SINIFTIR
        DEĞİŞKENLER : 
            float yukMiktari;
            int motorSayisi;
            String robotTuru;
        FONKSİYONLAR: 
            Değişkenlerin set ve get metotları 
*/
public abstract class Robot {
    
    //DEĞİŞKENLER
    int konumX,konumY;
    float yukMiktari;
    int motorSayisi;
    String robotTuru;
    float hareketSuresi=0;
    
    //CONSTRUCTERLAR
    Robot(int konumX,int konumY , float yukMiktari , int motorSayisi , String robotTuru){
        this.konumX = konumX;
        this.konumY = konumY;
        this.yukMiktari = yukMiktari;
        this.motorSayisi = motorSayisi;
        this.robotTuru = robotTuru;
    }
    Robot(){
        
    }
    
    //SET VE GET METOTLARI
    public void  setHareketSuresi(float hareketSuresi)
    {
        this.hareketSuresi = hareketSuresi;
    }
    public float getHareketSuresi()
    {
        return this.hareketSuresi;
    }
    public  void setRobotTuru(String robotTuru){
        this.robotTuru=robotTuru;
    }
    public void setKonumX(int konumX){
        this.konumX = konumX;
    }
    public int getKonumX(){
        return this.konumX;
    }
    public void setKonumY(int konumY){
        this.konumY = konumY;
    }
    public int getKonumY(){
        return this.konumY;
    }    
    public String getRobotTuru()
    {
        return this.robotTuru;
    }
    public  void setYukMiktari(float yukMiktari){
        this.yukMiktari=yukMiktari;
    }
    public  float getYukMiktari(){
        return this.yukMiktari;
    }   
    public  void setMotorSayisi(int motorSayisi){
        this.motorSayisi = motorSayisi;
    } 
    public  int getMotorSayisi(){
        return motorSayisi;
    }
    
    //ABSTRACT METOTLAR
    abstract void yazdir();
    
}
