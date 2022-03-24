
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 62852
 */
public class PrayTimesGUI extends javax.swing.JFrame {

    /**
     * Creates new form PrayTimesGUI
     */
    double latitude = 7.9666;
    double longitude = 112.6326;
    double timezone = 7;
    int menitIqomah = 1;
    int detikIqomah = 59;
    
    String  crudImageAbsolutePath = null;
       String     crudImageName = null;
    
    
    public PrayTimesGUI(String path){
        
    
    }
    public PrayTimesGUI() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) Math.round(screenSize.getWidth());
        int height = (int) Math.round(screenSize.getHeight());
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg1.png")).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        Timer t2 = new Timer();
        setExtendedState(MAXIMIZED_BOTH);
        t2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String winggris = new SimpleDateFormat("EEEE").format(new java.util.Date());
                String windo = "";
                switch (winggris) {
                    case "Sunday":
                        waktuBerjalan.setText("Ahad");
                        break;
                    case "Monday":
                        waktuBerjalan.setText("Senin");
                        break;
                    case "Tuesday":
                        waktuBerjalan.setText("Selasa");
                        break;
                    case "Wednesday":
                        waktuBerjalan.setText("Rabu");
                        break;
                    case "Thursday":
                        waktuBerjalan.setText("Kamis");
                        break;
                    case "Friday":
                        waktuBerjalan.setText("Jum'at");
                        break;
                    case "Saturday":
                        waktuBerjalan.setText("Sabtu");
                        break;

                }
                jamBerjalan.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
                jamif.setText(new SimpleDateFormat("d MMMMM y").format(new java.util.Date()));
                
               
                int menitmin2 = Integer.parseInt(new SimpleDateFormat("mm").format(new java.util.Date())) - 2;

                PrayTime prayers = new PrayTime();

                prayers.setTimeFormat(prayers.Time24);
                prayers.setCalcMethod(prayers.Jafari);
                prayers.setAsrJuristic(prayers.Shafii);
                prayers.setAdjustHighLats(prayers.AngleBased);
                int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
                prayers.tune(offsets);

                Date now = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(now);

                ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal,
                        latitude, longitude, timezone);
                ArrayList<String> prayerNames = prayers.getTimeNames();

                subuh.setText(prayerTimes.get(0));
                syuruq.setText(prayerTimes.get(1));
                dzuhur.setText(prayerTimes.get(2));
                asyar.setText(prayerTimes.get(3));
                maghrib.setText(prayerTimes.get(5));
                isya.setText(prayerTimes.get(6));
//                countDownAdzan();

                if (jamif.getText().equals(prayerTimes.get(0))) {
                    panelSubuh.setBackground(Color.red);
                    displayAdzan("Shubuh");
                }
                if (jamif.getText().equals(prayerTimes.get(2))) {
                    
                    panelDuhur.setBackground(Color.red);
                    displayAdzan("Dzuhur");
                }
                if (jamif.getText().equals(prayerTimes.get(3))) {
                    
                    panelAsyar.setBackground(Color.red);
                    displayAdzan("Asyar");
                }
                if (jamif.getText().equals(prayerTimes.get(5))) {
                    panelMaghrib.setBackground(Color.red);
                    displayAdzan("Maghrib");
                }
                if (jamif.getText().equals(prayerTimes.get(6))) {
                    panelIsya.setBackground(Color.red);
                    displayAdzan("Isya");
                }
            }
        }, 0, 1000);

        // Test Prayer times here
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tempatFoto = new javax.swing.JLabel();
        countdown = new javax.swing.JLabel();
        jamif = new javax.swing.JLabel();
        jamBerjalan = new javax.swing.JLabel();
        waktuBerjalan = new javax.swing.JLabel();
        panelSyuruq = new javax.swing.JPanel();
        syuruq = new javax.swing.JLabel();
        panelMaghrib = new javax.swing.JPanel();
        maghrib = new javax.swing.JLabel();
        panelSubuh = new javax.swing.JPanel();
        subuh = new javax.swing.JLabel();
        panelIsya = new javax.swing.JPanel();
        isya = new javax.swing.JLabel();
        panelAsyar = new javax.swing.JPanel();
        asyar = new javax.swing.JLabel();
        panelDuhur = new javax.swing.JPanel();
        dzuhur = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1580, 770));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("SETTINGS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 40, -1, 40));

        tempatFoto.setBackground(new java.awt.Color(251, 250, 241));
        tempatFoto.setOpaque(true);
        getContentPane().add(tempatFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 1240, 720));

        countdown.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        countdown.setForeground(new java.awt.Color(255, 0, 0));
        countdown.setText("countdown");
        getContentPane().add(countdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 950, 710, 100));

        jamif.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jamif.setText("jLabel1");
        getContentPane().add(jamif, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jamBerjalan.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jamBerjalan.setText("jLabel2");
        getContentPane().add(jamBerjalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        waktuBerjalan.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        waktuBerjalan.setText("jLabel1");
        getContentPane().add(waktuBerjalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        panelSyuruq.setBackground(new java.awt.Color(251, 250, 241));
        panelSyuruq.setForeground(new java.awt.Color(251, 250, 241));
        panelSyuruq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        syuruq.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        syuruq.setText("jLabel1");
        panelSyuruq.add(syuruq, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 70));

        getContentPane().add(panelSyuruq, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 340, 80));

        panelMaghrib.setBackground(new java.awt.Color(251, 250, 241));
        panelMaghrib.setForeground(new java.awt.Color(251, 250, 241));
        panelMaghrib.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        maghrib.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        maghrib.setText("jLabel1");
        panelMaghrib.add(maghrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 70));

        getContentPane().add(panelMaghrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, 340, 80));

        panelSubuh.setBackground(new java.awt.Color(251, 250, 241));
        panelSubuh.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        panelSubuh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subuh.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        subuh.setText("04.00");
        panelSubuh.add(subuh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 60));

        getContentPane().add(panelSubuh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 350, 70));

        panelIsya.setBackground(new java.awt.Color(251, 250, 241));
        panelIsya.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        isya.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        isya.setText("jLabel1");
        panelIsya.add(isya, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        getContentPane().add(panelIsya, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 830, 360, 80));

        panelAsyar.setBackground(new java.awt.Color(251, 250, 241));
        panelAsyar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asyar.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        asyar.setText("jLabel1");
        panelAsyar.add(asyar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 60));

        getContentPane().add(panelAsyar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 640, 380, 70));

        panelDuhur.setBackground(new java.awt.Color(251, 250, 241));
        panelDuhur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dzuhur.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        dzuhur.setText("jLabel1");
        panelDuhur.add(dzuhur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 80));

        getContentPane().add(panelDuhur, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 350, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 2930, 1780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Setting set = new Setting();
        set.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    void setIqomah(int menit, int detik) {
        this.menitIqomah = menit;
        this.detikIqomah = detik;
    }

    void countDownAdzan() {
        String menitif = new SimpleDateFormat("mm").format(new java.util.Date());
        if (menitif.equals(29)) {
            try {
                for (int i = 120; i >= 0; i--) {
                    Thread.sleep(1000);
                    countdown.setText("Waktu Adzan Kurang : " + i + " Detik ");
                    if (i == 0) {
                        countdown.setVisible(false);
                    }
                }
            } catch (InterruptedException e) {
            }
        }

    }

    void countDownIqomah() {
//        if (menitif.equals("38")) {
        try {
            for (int menit = menitIqomah; menit >= 0; menit--) {
                for (int detik = detikIqomah; detik >= 0; detik--) {
                    Thread.sleep(1000);
                    countdown.setText("Waktu Iqomah Kurang : " + menit + " Menit " + detik + " Detik ");
                    if (detik == 0 && menit == 0) {
                        countdown.setVisible(false);
                    }
                }
            }

        } catch (InterruptedException e) {
        }
//        }

    }
    
    void setGambar(File imageFile){
        try {
                Image images = ImageIO.read(imageFile);
                crudImageAbsolutePath = imageFile.getAbsolutePath();
            crudImageName = imageFile.getName();
            
            
//            //menampilkan image di label
            ImageIcon imageIcon = new ImageIcon(images);
            tempatFoto.setIcon(imageIcon);
//            //resize Image to Fit JLabel;
            Image imageResize = imageIcon.getImage().getScaledInstance(tempatFoto.getWidth(), tempatFoto.getHeight(), Image.SCALE_SMOOTH);
            tempatFoto.setIcon(new ImageIcon(imageResize));
            } catch (Exception e) {
            }
    }

    public void displayAdzan(String namaWaktu) {
        Adzan display = new Adzan(namaWaktu);
        display.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(600);
                if (i == 100) {
                    display.dispose();
                    countDownIqomah();
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrayTimesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrayTimesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrayTimesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrayTimesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrayTimesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asyar;
    private javax.swing.JLabel countdown;
    private javax.swing.JLabel dzuhur;
    private javax.swing.JLabel isya;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jamBerjalan;
    private javax.swing.JLabel jamif;
    private javax.swing.JLabel maghrib;
    private javax.swing.JPanel panelAsyar;
    private javax.swing.JPanel panelDuhur;
    private javax.swing.JPanel panelIsya;
    private javax.swing.JPanel panelMaghrib;
    private javax.swing.JPanel panelSubuh;
    private javax.swing.JPanel panelSyuruq;
    private javax.swing.JLabel subuh;
    private javax.swing.JLabel syuruq;
    private javax.swing.JLabel tempatFoto;
    private javax.swing.JLabel waktuBerjalan;
    // End of variables declaration//GEN-END:variables
}
