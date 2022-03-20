
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
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

    public PrayTimesGUI() {
        initComponents();
        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.jpg")).getImage().getScaledInstance(1900, 900, Image.SCALE_SMOOTH)));
        Timer t2 = new Timer();
        t2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                waktuBerjalan.setText(new SimpleDateFormat("EEEE dd-MM-yyyy").format(new java.util.Date()));
                jamBerjalan.setText(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
                jamif.setText(new SimpleDateFormat("HH:mm").format(new java.util.Date()));
                menitif.setText(new SimpleDateFormat("mm").format(new java.util.Date()));
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
                dzuhur.setText(prayerTimes.get(2));
                asyar.setText(prayerTimes.get(3));
                maghrib.setText(prayerTimes.get(5));
                isya.setText(prayerTimes.get(6));
//                countDownAdzan();
                

                if (jamif.getText().equals(prayerTimes.get(0))) {
                    panelSubuh.setBackground(Color.red);
                    panelDuhur.setBackground(Color.black);
                    panelAsyar.setBackground(Color.black);
                    panelMaghrib.setBackground(Color.black);
                    panelIsya.setBackground(Color.black);
                    displayAdzan("Shubuh");
                }
                if (jamif.getText().equals(prayerTimes.get(2))) {
                    panelSubuh.setBackground(Color.black);
                    panelDuhur.setBackground(Color.red);
                    panelAsyar.setBackground(Color.black);
                    panelMaghrib.setBackground(Color.black);
                    panelIsya.setBackground(Color.black);
                    displayAdzan("Dzuhur");
                }
                if (jamif.getText().equals(prayerTimes.get(3))) {
                    panelSubuh.setBackground(Color.black);
                    panelDuhur.setBackground(Color.black);
                    panelAsyar.setBackground(Color.red);
                    panelMaghrib.setBackground(Color.black);
                    panelIsya.setBackground(Color.black);
                    displayAdzan("Asyar");
                }
                if (jamif.getText().equals(prayerTimes.get(5))) {
                    panelSubuh.setBackground(Color.black);
                    panelDuhur.setBackground(Color.black);
                    panelAsyar.setBackground(Color.black);
                    panelMaghrib.setBackground(Color.red);
                    panelIsya.setBackground(Color.black);
                    displayAdzan("Maghrib");
                }
                if (jamif.getText().equals(prayerTimes.get(5))) {
                    panelSubuh.setBackground(Color.black);
                    panelDuhur.setBackground(Color.black);
                    panelAsyar.setBackground(Color.black);
                    panelMaghrib.setBackground(Color.black);
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
        menitif = new javax.swing.JLabel();
        countdown = new javax.swing.JLabel();
        jamif = new javax.swing.JLabel();
        jamBerjalan = new javax.swing.JLabel();
        waktuBerjalan = new javax.swing.JLabel();
        panelSubuh = new javax.swing.JPanel();
        subuh = new javax.swing.JLabel();
        subuh2 = new javax.swing.JLabel();
        panelIsya = new javax.swing.JPanel();
        isya = new javax.swing.JLabel();
        subuh3 = new javax.swing.JLabel();
        panelMaghrib = new javax.swing.JPanel();
        maghrib = new javax.swing.JLabel();
        subuh5 = new javax.swing.JLabel();
        panelAsyar = new javax.swing.JPanel();
        asyar = new javax.swing.JLabel();
        subuh1 = new javax.swing.JLabel();
        panelDuhur = new javax.swing.JPanel();
        dzuhur = new javax.swing.JLabel();
        subuh4 = new javax.swing.JLabel();
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 20, -1, 40));

        menitif.setForeground(new java.awt.Color(255, 255, 255));
        menitif.setText("jLabel1");
        getContentPane().add(menitif, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        countdown.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        countdown.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(countdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 710, 100));

        jamif.setForeground(new java.awt.Color(255, 255, 255));
        jamif.setText("jLabel1");
        getContentPane().add(jamif, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jamBerjalan.setForeground(new java.awt.Color(255, 255, 255));
        jamBerjalan.setText("jLabel2");
        getContentPane().add(jamBerjalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        waktuBerjalan.setForeground(new java.awt.Color(255, 255, 255));
        waktuBerjalan.setText("jLabel1");
        getContentPane().add(waktuBerjalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        panelSubuh.setBackground(new java.awt.Color(0, 0, 0));

        subuh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subuh.setForeground(new java.awt.Color(255, 255, 255));
        subuh.setText("jLabel1");

        subuh2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subuh2.setForeground(new java.awt.Color(255, 255, 255));
        subuh2.setText("Subuh");

        javax.swing.GroupLayout panelSubuhLayout = new javax.swing.GroupLayout(panelSubuh);
        panelSubuh.setLayout(panelSubuhLayout);
        panelSubuhLayout.setHorizontalGroup(
            panelSubuhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubuhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSubuhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subuh2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subuh))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelSubuhLayout.setVerticalGroup(
            panelSubuhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSubuhLayout.createSequentialGroup()
                .addComponent(subuh2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subuh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelSubuh, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, -1, -1));

        panelIsya.setBackground(new java.awt.Color(0, 0, 0));

        isya.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        isya.setForeground(new java.awt.Color(255, 255, 255));
        isya.setText("jLabel1");

        subuh3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subuh3.setForeground(new java.awt.Color(255, 255, 255));
        subuh3.setText("Isya'");

        javax.swing.GroupLayout panelIsyaLayout = new javax.swing.GroupLayout(panelIsya);
        panelIsya.setLayout(panelIsyaLayout);
        panelIsyaLayout.setHorizontalGroup(
            panelIsyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsyaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isya)
                    .addComponent(subuh3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelIsyaLayout.setVerticalGroup(
            panelIsyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIsyaLayout.createSequentialGroup()
                .addComponent(subuh3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(isya, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelIsya, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 610, -1, -1));

        panelMaghrib.setBackground(new java.awt.Color(0, 0, 0));

        maghrib.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        maghrib.setForeground(new java.awt.Color(255, 255, 255));
        maghrib.setText("jLabel1");

        subuh5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subuh5.setForeground(new java.awt.Color(255, 255, 255));
        subuh5.setText("Maghrib");

        javax.swing.GroupLayout panelMaghribLayout = new javax.swing.GroupLayout(panelMaghrib);
        panelMaghrib.setLayout(panelMaghribLayout);
        panelMaghribLayout.setHorizontalGroup(
            panelMaghribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaghribLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaghribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maghrib)
                    .addComponent(subuh5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelMaghribLayout.setVerticalGroup(
            panelMaghribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaghribLayout.createSequentialGroup()
                .addComponent(subuh5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(maghrib, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelMaghrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 610, -1, -1));

        panelAsyar.setBackground(new java.awt.Color(0, 0, 0));

        asyar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        asyar.setForeground(new java.awt.Color(255, 255, 255));
        asyar.setText("jLabel1");

        subuh1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subuh1.setForeground(new java.awt.Color(255, 255, 255));
        subuh1.setText("Asyar");

        javax.swing.GroupLayout panelAsyarLayout = new javax.swing.GroupLayout(panelAsyar);
        panelAsyar.setLayout(panelAsyarLayout);
        panelAsyarLayout.setHorizontalGroup(
            panelAsyarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsyarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAsyarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asyar)
                    .addComponent(subuh1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelAsyarLayout.setVerticalGroup(
            panelAsyarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsyarLayout.createSequentialGroup()
                .addComponent(subuh1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(asyar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelAsyar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 610, -1, -1));

        panelDuhur.setBackground(new java.awt.Color(0, 0, 0));

        dzuhur.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dzuhur.setForeground(new java.awt.Color(255, 255, 255));
        dzuhur.setText("jLabel1");

        subuh4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subuh4.setForeground(new java.awt.Color(255, 255, 255));
        subuh4.setText("Dzuhur");

        javax.swing.GroupLayout panelDuhurLayout = new javax.swing.GroupLayout(panelDuhur);
        panelDuhur.setLayout(panelDuhurLayout);
        panelDuhurLayout.setHorizontalGroup(
            panelDuhurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDuhurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDuhurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dzuhur)
                    .addComponent(subuh4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelDuhurLayout.setVerticalGroup(
            panelDuhurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDuhurLayout.createSequentialGroup()
                .addComponent(subuh4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(dzuhur, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelDuhur, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 610, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Setting set = new Setting();
        set.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    void setIqomah(int menit,int detik){
        this.menitIqomah = menit;
        this.detikIqomah = detik;
    }
    
    void countDownAdzan() {
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
    private javax.swing.JLabel menitif;
    private javax.swing.JPanel panelAsyar;
    private javax.swing.JPanel panelDuhur;
    private javax.swing.JPanel panelIsya;
    private javax.swing.JPanel panelMaghrib;
    private javax.swing.JPanel panelSubuh;
    private javax.swing.JLabel subuh;
    private javax.swing.JLabel subuh1;
    private javax.swing.JLabel subuh2;
    private javax.swing.JLabel subuh3;
    private javax.swing.JLabel subuh4;
    private javax.swing.JLabel subuh5;
    private javax.swing.JLabel waktuBerjalan;
    // End of variables declaration//GEN-END:variables
}
