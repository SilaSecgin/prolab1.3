/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*

    MAİN SINIFI : 
        DİĞER SINIFLARDAN ROBOT TÜRÜNE GÖRE NESNE OLUŞTURMA OLUŞTURULAN NESNELERİN 
        KULLANICI TARAFINDAN İSTENEN VERİLERİ ALMA IZGARA OLUŞTURMA GİBİ FONKSİYONLARIN 
        YAZILDIĞI SINIFTIR
        FONKSİYONLARI : 
            gezginRobot(); 
            manipulatorRobot();
            hibritRobot();
            engelYerleştir();
            robotYon();
*/
package prolab3;

/**
 *
 * @author ryuzaki
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class Grids extends Canvas {
      public int width, height, rows, columns,list[][];
      
      

      Grids(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows = r;
        columns = c;
      }
      Grids(){
          
      }
      @Override
      public void paint(Graphics g) {
        int k;
        width = getSize().width;
        height = getSize().height;
        
        int htOfRow = height / (rows);
        for (k = 0; k < rows; k++)
          g.drawLine(0, k * htOfRow , width, k * htOfRow );

        int wdOfRow = width / (columns);
        for (k = 0; k < columns; k++)
          g.drawLine(k*wdOfRow , 0, k*wdOfRow , height);
        //SYAH DOLDURMA 
        for(k=0;k<list.length;k++)
            for(int l=0;l<list.length;l++){
                if(list[k][l] !=0)
                    g.fill3DRect((k*70)-10, l*35, 70, 35, true);
            }        
      }
    }
public class Prolab3 extends Frame  {
    static Scanner scan = new Scanner(System.in);
    static Robot robot ;
    static Robot robotlar[];
    static int sayi=0,t;
    static int [][] izgara = new int[20][20];
    Grids grid;
    //asagısı kapsullenmıs 
    private static void gezginRobot(Grids grid) {
        int konumX,konumY;
        System.out.println("1-Tekerlekli Robot");
        System.out.println("2-Paletli Robot");
        System.out.println("3-Spider Robot");
        System.out.print("Gezgin Robotunuzun türünü seciniz: ");
        int secim = scan.nextInt();
        switch(secim){
            case 1:
                t=0;
                 do{
                     if(t>0)
                         System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz...");
                    System.out.print("Tekerlekli Robotunuzun x koordinatını giriniz: ");
                    konumX = scan.nextInt();
                    System.out.print("Tekerlekli Robotunuzun y koordinatını giriniz: ");
                    konumY = scan.nextInt();
                    t++;
                 }while(konumX>20 || konumY>20);
                //konum Dolumu?
                if(izgara[konumX-1][konumY-1]==0)
                {
                    izgara[konumX-1][konumY-1]=-1;
                    grid.list=izgara;
                    grid.repaint();
                    System.out.print("Tekerlek Sayisini giriniz: ");
                    int tekerlekSayisi = scan.nextInt();
                    System.out.print("Gezinme Hizini giriniz: ");
                    float gezinmeHizi = scan.nextFloat();
                    System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                    float yukMiktari = scan.nextFloat();
                    System.out.print("Motor sayisini giriniz: ");
                    int motorSayisi = scan.nextInt();
                    robot = new TekerlekliRobot(konumX,konumY,yukMiktari,motorSayisi,"Tekerlekli",gezinmeHizi,tekerlekSayisi);
                    robotlar[sayi]=robot;
                    sayi++;
                }
                else{
                    System.out.println("konum dolu robot olusturulamadı");
                }
                break;
            case 2:
                t=0;
                do{
                    if(t>0)
                        System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz...");
                    System.out.print("Paletli Robotunuzun x koordinatını giriniz: ");
                    konumX = scan.nextInt();
                    System.out.print("Paletli Robotunuzun y koordinatını giriniz: ");
                    konumY = scan.nextInt();                    
                }while(konumX>20 || konumY>20);

                if(izgara[konumX-1][konumY-1]==0)
                {                 
                    izgara[konumX-1][konumY-1]=-1;
                    grid.list=izgara;
                    grid.repaint();
                    System.out.print("Palet Sayisini giriniz: ");
                    int paletSayisi = scan.nextInt();
                    System.out.print("Gezinme Hizini giriniz: ");
                    float gezinmeHizi = scan.nextFloat();
                    System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                    float yukMiktari = scan.nextFloat();
                    System.out.print("Motor sayisini giriniz: ");
                    int motorSayisi = scan.nextInt();
                    robot = new PaletliRobot(konumX,konumY,yukMiktari,motorSayisi,"Paletli",gezinmeHizi,paletSayisi);
                    robotlar[sayi]=robot;
                    sayi++;
                }
                else{
                    System.out.println("konum dolu robot olusturulamadı");
                }            
                break;
            case 3:
                t=0;
                do{
                    if(t>0)
                       System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz..."); 
                    System.out.print("Spider Robotunuzun x koordinatını giriniz: ");
                    konumX = scan.nextInt();
                    System.out.print("Spider Robotunuzun y koordinatını giriniz: ");
                    konumY = scan.nextInt();                
                }while(konumX>20 || konumY>20);

                if(izgara[konumX-1][konumY-1]==0)
                {               
                    izgara[konumX-1][konumY-1]=-1;
                    grid.list = izgara;
                    grid.repaint();
                    System.out.print("Bacak Sayisini giriniz: ");
                    int bacakSayisi = scan.nextInt();
                    System.out.print("Gezinme Hizini giriniz: ");
                    float gezinmeHizi = scan.nextFloat();
                    System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                    float yukMiktari = scan.nextFloat();
                    System.out.print("Motor sayisini giriniz: ");
                    int motorSayisi = scan.nextInt(); 
                    robot= new SpiderRobot(konumX,konumY,yukMiktari,motorSayisi,"Spider",gezinmeHizi,bacakSayisi);
                    robotlar[sayi]=robot; 
                    sayi++;
                }
                else{
                    System.out.println("konum dolu robot olusturulamadı");
                }     
                break;
            default:
                break;
        }
    }

    private static void manipulatorRobot(Grids grid) {
        int konumX,konumY;
        System.out.println("1-Seri Robot");
        System.out.println("2-Paletli Robot");
        System.out.print("Manipulator Robotunuzun türünü seciniz: ");
        int secim = scan.nextInt();
        switch(secim){
            case 1:
                t=0;
                do{
                    if(t>0)
                       System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz..."); 
                    System.out.print("Seri Robotunuzun x koordinatını giriniz: ");
                    konumX = scan.nextInt();
                    System.out.print("Seri Robotunuzun y koordinatını giriniz: ");
                    konumY = scan.nextInt();                
                }while(konumX>20 || konumY>20);

                if(izgara[konumX-1][konumY-1]==0)
                {               
                    izgara[konumX-1][konumY-1]=-1;
                    grid.list = izgara;
                    grid.repaint();
                    System.out.print("Kol uzunlugunu giriniz: ");
                    int kolUzunlugu = scan.nextInt();
                    System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                    float yukMiktari = scan.nextFloat();
                    System.out.print("Yuk tasıma kapasitesini giriniz: ");
                    float yukTasimaKapasitesi = scan.nextFloat();
                    System.out.print("Motor sayisini giriniz: ");
                    int motorSayisi = scan.nextInt(); 
                    System.out.println("Taşıma hızını giriniz: ");
                    float tasimaHizi = scan.nextFloat();
                    robot= new SeriRobot(konumX,konumY,yukMiktari,motorSayisi,"Spider",yukTasimaKapasitesi,kolUzunlugu,tasimaHizi);
                    robotlar[sayi]=robot; 
                    sayi++;
                }
                else{
                    System.out.println("konum dolu robot olusturulamadı");
                }     
                break;            
            case 2:
                t=0;
                do{
                    if(t>0)
                       System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz..."); 
                    System.out.print("Paralel Robotunuzun x koordinatını giriniz: ");
                    konumX = scan.nextInt();
                    System.out.print("Paralel Robotunuzun y koordinatını giriniz: ");
                    konumY = scan.nextInt();                
                }while(konumX>20 || konumY>20);

                if(izgara[konumX-1][konumY-1]==0)
                {               
                    izgara[konumX-1][konumY-1]=-1;
                    grid.list = izgara;
                    grid.repaint();
                    System.out.print("Kol uzunlugunu giriniz: ");
                    int kolUzunlugu = scan.nextInt();
                    System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                    float yukMiktari = scan.nextFloat();
                    System.out.print("Yuk tasıma kapasitesini giriniz: ");
                    float yukTasimaKapasitesi = scan.nextFloat();
                    System.out.print("Motor sayisini giriniz: ");
                    int motorSayisi = scan.nextInt(); 
                    System.out.println("Taşıma hızını giriniz: ");
                    float tasimaHizi = scan.nextFloat();
                    robot= new ParalelRobot(konumX,konumY,yukMiktari,motorSayisi,"Paralel",yukTasimaKapasitesi,kolUzunlugu,tasimaHizi);
                    robotlar[sayi]=robot; 
                    sayi++;
                }
                else{
                    System.out.println("konum dolu robot olusturulamadı");
                }               
                break;
            default:
                break;
        }
    }

    private static void hibritRobot(Grids grid) {
        int gezginK,manipK;
        System.out.println("1-Tekerlekli");
        System.out.println("2-Paletli");
        System.out.println("3-Spider");
        System.out.println("Robotunuzun Gezgin kısmını giriniz: ");
        gezginK = scan.nextInt();

        System.out.println("1-Seri");
        System.out.println("2-Paralel");
        System.out.println("Robotunuzun Manipulator kısmını giriniz: ");
        manipK = scan.nextInt();
        int konumX=0,konumY=0;
        switch(gezginK){
            case 1:
                    t=0;
                    do{
                        if(t>0)
                            System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz...");
                        System.out.print("Hibrit Robotunuzun x koordinatını giriniz: ");
                        konumX = scan.nextInt();
                        System.out.print("Hibrit Robotunuzun y koordinatını giriniz: ");
                        konumY = scan.nextInt();
                        t++;
                    }while(konumX>20 || konumY>20);
                    if(izgara[konumX-1][konumY-1]==0){
                        izgara[konumX-1][konumY-1]=-1;
                        grid.list = izgara;
                        grid.repaint();
                        System.out.print("Tekerlek Sayisini giriniz: ");
                        int tekerlekSayisi = scan.nextInt();
                        System.out.print("Gezinme Hizini giriniz: ");
                        float gezinmeHizi = scan.nextFloat();
                        System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                        float yukMiktari = scan.nextFloat();
                        System.out.print("Motor sayisini giriniz: ");
                        int motorSayisi = scan.nextInt();
                        System.out.print("Kol uzunlugunu giriniz: ");
                        int kolUzunlugu = scan.nextInt();
                        System.out.print("Yuk tasıma kapasitesini giriniz: ");
                        float yukTasimaKapasitesi = scan.nextFloat();
                        System.out.println("Taşıma hızını giriniz: ");
                        float tasimaHizi = scan.nextFloat();
                        robot = new HibritRobot(konumX,konumY,tekerlekSayisi,gezinmeHizi,yukMiktari,motorSayisi,"Tekerlekli-Seri",kolUzunlugu,yukTasimaKapasitesi,tasimaHizi);                        
                        robotlar[sayi]=robot; 
                        sayi++;
                    }
                    else{
                        System.err.println("Konum dolu robot oluşturulamadı..");
                    }
                    
                break;
            case 2:
                    t=0;
                    do{
                        if(t>0)
                            System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz...");
                        System.out.print("Hibrit Robotunuzun x koordinatını giriniz: ");
                        konumX = scan.nextInt();
                        System.out.print("Hibrit Robotunuzun y koordinatını giriniz: ");
                        konumY = scan.nextInt();
                        t++;
                    }while(konumX>20 || konumY>20);
                    if(izgara[konumX-1][konumY-1]==0){
                        izgara[konumX-1][konumY-1]=-1;
                        grid.list = izgara;
                        grid.repaint();
                        System.out.print("Palet Sayisini giriniz: ");
                        int paletSayisi = scan.nextInt();
                        System.out.print("Gezinme Hizini giriniz: ");
                        float gezinmeHizi = scan.nextFloat();
                        System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                        float yukMiktari = scan.nextFloat();
                        System.out.print("Motor sayisini giriniz: ");
                        int motorSayisi = scan.nextInt();
                        System.out.print("Kol uzunlugunu giriniz: ");
                        int kolUzunlugu = scan.nextInt();
                        System.out.print("Yuk tasıma kapasitesini giriniz: ");
                        float yukTasimaKapasitesi = scan.nextFloat();
                        System.out.println("Taşıma hızını giriniz: ");
                        float tasimaHizi = scan.nextFloat();
                        robot = new HibritRobot(konumX,konumY,paletSayisi,gezinmeHizi,yukMiktari,motorSayisi,"Tekerlekli-Seri",kolUzunlugu,yukTasimaKapasitesi,tasimaHizi);                        
                        robotlar[sayi]=robot; 
                        sayi++;
                    }
                    else{
                        System.err.println("Konum dolu robot oluşturulamadı..");
                    }
                break;
            case 3:
                    t=0;
                    do{
                        if(t>0)
                            System.out.println("Robot ızgara dışına çıkamaz tekrar giriniz...");
                        System.out.print("Hibrit Robotunuzun x koordinatını giriniz: ");
                        konumX = scan.nextInt();
                        System.out.print("Hibrit Robotunuzun y koordinatını giriniz: ");
                        konumY = scan.nextInt();
                        t++;
                    }while(konumX>20 || konumY>20);
                    if(izgara[konumX-1][konumY-1]==0){
                        izgara[konumX-1][konumY-1]=-1;
                        grid.list = izgara;
                        grid.repaint();
                        System.out.print("Bacak Sayisini giriniz: ");
                        int bacakSayisi = scan.nextInt();
                        System.out.print("Gezinme Hizini giriniz: ");
                        float gezinmeHizi = scan.nextFloat();
                        System.out.print("Kaldıracagı Yuk miktarini giriniz: ");
                        float yukMiktari = scan.nextFloat();
                        System.out.print("Motor sayisini giriniz: ");
                        int motorSayisi = scan.nextInt();
                        System.out.print("Kol uzunlugunu giriniz: ");
                        int kolUzunlugu = scan.nextInt();
                        System.out.print("Yuk tasıma kapasitesini giriniz: ");
                        float yukTasimaKapasitesi = scan.nextFloat();
                        System.out.println("Taşıma hızını giriniz: ");
                        float tasimaHizi = scan.nextFloat();
                        robot = new HibritRobot(konumX,konumY,bacakSayisi,gezinmeHizi,yukMiktari,motorSayisi,"Tekerlekli-Seri",kolUzunlugu,yukTasimaKapasitesi,tasimaHizi);                        
                        robotlar[sayi]=robot; 
                        sayi++;
                    }
                    else{
                        System.err.println("Konum dolu robot oluşturulamadı..");
                    }
                break;
            default:
                break;
        }
        
    }

    private static void engelYerlestir(int engelSayisi,Grids grid) {
        int konumX,konumY,k=1;
        while(engelSayisi>0){
            System.out.print(k+". engelin x konumunu giriniz: ");
            konumX = scan.nextInt();
            System.out.print(k+". engelin y konumunu giriniz: ");
            konumY = scan.nextInt();
            if(izgara[konumX-1][konumY-1]!=0){
                System.err.println("Seçtiğiniz konum dolu başka bir konum giriniz..");
            }
            else{
                izgara[konumX-1][konumY-1]=1;
                grid.list = izgara;
                grid.repaint();
                engelSayisi--;
                k++;
            }
          
        }
    }

    private static void robotYon(Robot robot,Grids grid) {
        int hareketYonu,birimSayisi=0,toplamSure=0;
        if("Spider".equals(robot.robotTuru) || "Paletli".equals(robot.robotTuru) || "Tekerlekli".equals(robot.robotTuru))
        {
            do{
                int sonKonum=0, engelSayisi=0;
                System.out.println("1-SAG");
                System.out.println("2-SOL");
                System.out.println("3-İLERİ");
                System.out.println("4-GERİ");
                System.out.print("Robotun hareket yonunu giriniz(CIKIS İCİN 0 GİRİNİZ) : ");
                hareketYonu = scan.nextInt();
                if(hareketYonu==0)         
                    break;
                int l=0;
                while(l<=0)
                {
                    if(l<0)
                        System.err.println("Robotunuz harita dışına çıkmamalı!!");
                    System.out.print("Robotunuz kaç birim hareket etsin: ");
                    birimSayisi = scan.nextInt();
                    switch (hareketYonu) {
                        case 1:
                            if(robot.konumX+birimSayisi<20)
                                l=1;
                            else
                                l--;
                            break;
                        case 2:
                            if(robot.konumX-birimSayisi>0)
                                l=1;
                            else
                                l--;
                            break;
                        case 3:
                            if(robot.konumY-birimSayisi>0)
                                l=1;
                            else
                                l--;
                            break;
                        case 4:
                            if(robot.konumY+birimSayisi<20)
                                l=1;
                            else
                                l--;
                            break;
                        default:
                            break;
                    }
                }          
                    switch(hareketYonu){
                        case 1:
                            if("Spider".equals(robot.robotTuru)){
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[(robot.konumX-1)+i][robot.konumY-1]==-1)
                                    {
                                        System.err.println("Robotunuz başka bir robota takıldı...");
                                        break;
                                    }
                                    else if(izgara[(robot.konumX-1)+i][robot.konumY-1]==1)
                                    {
                                        System.err.println("Robotunuz bir engele takıldı...");
                                        break;                            
                                    }
                                    else{
                                        sonKonum++;
                                    }                                
                                }
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[(robot.konumX-1)+sonKonum][robot.konumY-1]=-1;
                                robot.setKonumX(robot.konumX+sonKonum);
                                grid.list=izgara;
                                grid.repaint();
                                toplamSure += sonKonum;
                            }
                            else{
                                engelSayisi=0;
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[(robot.konumX-1)+i][robot.konumY-1]!=0)
                                    {
                                        engelSayisi++;
                                    }      
                                    else{
                                        sonKonum++;
                                    }                                
                                }
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[(robot.konumX-1)+birimSayisi][robot.konumY-1]=-1;
                                robot.setKonumX(robot.konumX+birimSayisi);
                                grid.list=izgara;
                                grid.repaint();
                                if("Tekerlekli".equals(robot.robotTuru)){
                                    toplamSure+=(birimSayisi-engelSayisi)+((TekerlekliRobot)robot).engelGecmeSuresiBul()*engelSayisi;

                                }
                                else{
                                    toplamSure+=(birimSayisi-engelSayisi)+((PaletliRobot)robot).engelGecmeSuresiBul()*engelSayisi;
                                }
                            }
                            robot.setHareketSuresi(robot.getHareketSuresi()+toplamSure);
                            break;
                        case 2:
                            if("Spider".equals(robot.robotTuru)){
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[(robot.konumX-1)-i][robot.konumY-1]==-1)
                                    {
                                        System.err.println("Robotunuz başka bir robota takıldı...");
                                        break;
                                    }
                                    else if(izgara[(robot.konumX-1)-i][robot.konumY-1]==1)
                                    {
                                        System.err.println("Robotunuz bir engele takıldı...");
                                        break;                            
                                    }
                                    else{
                                        sonKonum++;
                                    }
                                }
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[(robot.konumX-1)-sonKonum][robot.konumY-1]=-1;
                                robot.setKonumX(robot.konumX-sonKonum);
                                grid.list=izgara;
                                grid.repaint();                                
                                toplamSure += sonKonum;                            
                            }
                            else{
                                engelSayisi=0;
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[(robot.konumX-1)+i][robot.konumY-1]!=0)
                                    {
                                        engelSayisi++;
                                    }      
                                    else{
                                        sonKonum++;
                                    }                                
                                }                            
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[(robot.konumX-1)-birimSayisi][robot.konumY-1]=-1;
                                robot.setKonumX(robot.konumX-birimSayisi);
                                grid.list=izgara;
                                grid.repaint(); 
                                if("Tekerlekli".equals(robot.robotTuru)){
                                    toplamSure+=(birimSayisi-engelSayisi)+((TekerlekliRobot)robot).engelGecmeSuresiBul()*engelSayisi;

                                }
                                else{
                                    toplamSure+=(birimSayisi-engelSayisi)+((PaletliRobot)robot).engelGecmeSuresiBul()*engelSayisi;
                                }
                            }
                            robot.setHareketSuresi(robot.getHareketSuresi()+toplamSure);                            
                            break;
                        case 3:
                            if("Spider".equals(robot.robotTuru)){
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[robot.konumX-1][(robot.konumY-1)-i]==-1)
                                    {
                                        System.err.println("Robotunuz başka bir robota takıldı...");
                                        break;
                                    }
                                    else if(izgara[robot.konumX-1][(robot.konumY-1)-i]==1)
                                    {
                                        System.err.println("Robotunuz bir engele takıldı...");
                                        break;                            
                                    }
                                    else{
                                        sonKonum++;
                                    }
                                }
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[robot.konumX-1][(robot.konumY-1)-sonKonum]=-1;
                                robot.setKonumY(robot.konumY-sonKonum);
                                grid.list=izgara;
                                grid.repaint();
                                toplamSure += sonKonum;
                            }
                            else{
                                engelSayisi=0;
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[(robot.konumX-1)+i][robot.konumY-1]!=0)
                                    {
                                        engelSayisi++;
                                    }      
                                    else{
                                        sonKonum++;
                                    }                                
                                }                            
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[robot.konumX-1][(robot.konumY-1)-birimSayisi]=-1;
                                robot.setKonumY(robot.konumY-birimSayisi);
                                grid.list=izgara;
                                grid.repaint();
                                if("Tekerlekli".equals(robot.robotTuru)){
                                    toplamSure+=(birimSayisi-engelSayisi)+((TekerlekliRobot)robot).engelGecmeSuresiBul()*engelSayisi;

                                }
                                else{
                                    toplamSure+=(birimSayisi-engelSayisi)+((PaletliRobot)robot).engelGecmeSuresiBul()*engelSayisi;
                                }
                            }
                            robot.setHareketSuresi(robot.getHareketSuresi()+toplamSure);                            

                            break;
                        case 4:
                            if("Spider".equals(robot.robotTuru)){
                                for(int i =1;i<=birimSayisi;i++){

                                    if(izgara[robot.konumX-1][(robot.konumY-1)+i]==-1)
                                    {
                                        System.err.println("Robotunuz başka bir robota takıldı...");
                                        break;
                                    }
                                    else if(izgara[(robot.konumX-1)+i][robot.konumY-1]==1)
                                    {
                                        System.err.println("Robotunuz bir engele takıldı...");
                                        break;                            
                                    }
                                    else{
                                        sonKonum++;
                                    }
                                }
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[robot.konumX-1][(robot.konumY-1)+sonKonum]=-1;
                                robot.setKonumY(robot.konumY+sonKonum);
                                grid.list=izgara;
                                grid.repaint();
                                toplamSure += sonKonum;
                            }
                            else{
                                engelSayisi=0;
                                for(int i =1;i<=birimSayisi;i++){
                                    if(izgara[(robot.konumX-1)+i][robot.konumY-1]!=0)
                                    {
                                        engelSayisi++;
                                    }      
                                    else{
                                        sonKonum++;
                                    }                                
                                }                            
                                izgara[robot.konumX-1][robot.konumY-1]=0;
                                izgara[robot.konumX-1][(robot.konumY-1)+birimSayisi]=-1;
                                robot.setKonumY(robot.konumY+birimSayisi);
                                grid.list=izgara;
                                grid.repaint();      
                                if("Tekerlekli".equals(robot.robotTuru)){
                                    toplamSure+=(birimSayisi-engelSayisi)+((TekerlekliRobot)robot).engelGecmeSuresiBul()*engelSayisi;

                                }
                                else{
                                    toplamSure+=(birimSayisi-engelSayisi)+((PaletliRobot)robot).engelGecmeSuresiBul()*engelSayisi;
                                }
                            }
                            robot.setHareketSuresi(robot.getHareketSuresi()+toplamSure);                                                   
                            break;
                        default:
                            break;
                    }            
            }while(hareketYonu!=0); 
            System.out.println("Robotunuz toplam "+robot.getHareketSuresi()+" suresince son konuma varmıştır.");            
        }
        else if("Paralel".equals(robot.robotTuru) || "Seri".equals(robot.robotTuru)){
            do{
                System.out.println("1-SAG");
                System.out.println("2-SOL");
                System.out.println("3-İLERİ");
                System.out.println("4-GERİ");
                System.out.print("Kolun hareket yonunu giriniz(CIKIS İCİN 0 GİRİNİZ) : ");
                hareketYonu = scan.nextInt();
                if(hareketYonu==0)         
                    break;
                int l=0;
                while(l<=0)
                {
                    if(l<0)
                        System.err.println("Gireceğiniz değer Kol uzunlugunu geçmemeli!!");
                    System.out.print("Yük kaç birim götürülsün : ");
                    birimSayisi = scan.nextInt();
                    if("ParalelRobot".equals(robot.robotTuru)){
                        if(((ParalelRobot)robot).kolUzunlugu<birimSayisi){
                            l--;
                        }
                        else{
                            l=1;
                        }
                    }
                    else{
                        if(((SeriRobot)robot).kolUzunlugu<birimSayisi){
                            l--;
                        }
                        else{
                            l=1;
                        }
                    }
                }          
            }while(hareketYonu!=0);
        }
        else{
            //HİBRİT ROBOT
        }
    }
     //PROLAB 3 SINIFININ CONSTRUCTER 
    Prolab3(String title, int w, int h, int rows, int columns) {
        setTitle(title);
        grid = new Grids(w, h, rows, columns);
        add(grid);
      }

    public static void main(String[] args) {       
        Prolab3 pr3 = new Prolab3("Draw Grids", 200, 200, 20, 20);
        pr3.setVisible(true);
        int secim ,robotSayisi,engelSayisi;
       
        System.out.print("Kaç tane robot girmek istiyorsunuz : ");
        robotSayisi=scan.nextInt();
        robotlar=new Robot[robotSayisi];
        
        do{
            System.out.println("1-EVET");
            System.out.println("2-HAYIR");
            System.out.print("Izgara uzerine engel yerlestirmek istiyormusunuz ? :");
            secim = scan.nextInt();  
        }
        while(secim!=1 && secim!=2);
    
        if(secim==1){
            System.out.print("Kaç tane engel girmek istiyorsunuz : ");
            engelSayisi=scan.nextInt();
            engelYerlestir(engelSayisi,pr3.grid);           
        }
        else{
            System.out.println("Engel olunmadıgı varsayılacaktır...");            
        }
        
        while(robotSayisi>0){
            
            System.out.println("1-Gezgin Robot");
            System.out.println("2-Manipulator(Hareketsiz) Robot");
            System.out.println("3-Hibrit(Manipulator-Gezgin) Robot");
            System.out.print("Olusturmak istediginiz robot turunu seciniz: ");
            secim = scan.nextInt();

            switch (secim) {
                case 1:
                    gezginRobot(pr3.grid);
                    break;
                case 2:
                    manipulatorRobot(pr3.grid);
                    break;
                case 3:
                    hibritRobot(pr3.grid);
                    break;
                default:
                    break;
            }   
            robotSayisi--;
        }
        for (prolab3.Robot robotlar1 : robotlar) {
            robotlar1.yazdir();
        }
        int numara=1;
        do{
            System.out.println("Hareket ettirmek istediginiz robot numarasını giriniz: (Cıkıs için 0)");
            numara = scan.nextInt();
            if(numara!=0)
            {
                try{
                    robotYon(robotlar[numara-1],pr3.grid);
                }catch(Exception ex){
                    System.err.println("Girdiginiz robot bulunmamaktadır");
                }                
            }                
        }while(numara!=0);
    }
    
}
