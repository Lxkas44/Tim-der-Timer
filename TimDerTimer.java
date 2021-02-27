import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimDerTimer

{
    private int m = 0;
    private int s = 0;
    private int st = 0;
    private int delay = 1000;
    JLabel stunde = new JLabel("Stunde: 0");
    JLabel sek = new JLabel("Sekunde: 0");
    JLabel min = new JLabel("Minute: 0");
    JButton start = new JButton("Start");
    JButton info = new JButton("Info");
    JButton stopp = new JButton("Stopp");
    Timer timer = new Timer(delay,null);
    public TimDerTimer(){
        JFrame frame = new JFrame("Tim der Timer");
        
        JMenuBar jmb = new JMenuBar();
        frame.setJMenuBar(jmb);
        
        JMenu geschwindigkeit = new JMenu("Geschwindigkeit");
        jmb.add(geschwindigkeit);
        
        JMenuItem nullfünf = new JMenuItem("0,5x");
        geschwindigkeit.add(nullfünf);
        
        JMenuItem eins = new JMenuItem("1x");
        geschwindigkeit.add(eins);
        
        JMenuItem zwei = new JMenuItem("2x");
        geschwindigkeit.add(zwei);
        
        JPanel panel = new JPanel(new GridLayout(2,2));
        frame.add(panel);
        panel.add(stunde);
        panel.add(min);
        panel.add(sek);
        panel.add(start);
        panel.add(info);
        panel.add(stopp);
        stopp.setEnabled(false);

        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                start();
            }

        });

        stopp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                stopp();
            }

        });
        
        info.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                zeigeInfo();
            }

        });
        
        nullfünf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                timer.setDelay(2000);
            }

        });
        
        eins.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                timer.setDelay(1000);
            }

        });
        
        zwei.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                timer.setDelay(500);
            }

        });
        
        timer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(s < 59){
                    s++;
                    sek.setText("Sekunde: "+s);    
                }
                else if(m < 59) {
                    s = 0;
                    m++;
                    min.setText("Minute: "+m); 
                    sek.setText("Sekunde: "+s);                   
                }
                else if(st < 23){
                    s = 0;
                    m = 0;
                    st++;
                    min.setText("Minute: "+m);
                    sek.setText("Sekunde: "+s);  
                    stunde.setText("Stunde: "+st);
                }
                else{
                    timer.stop();
                    s = 0;
                    m = 0;
                    st = 0;
                    min.setText("Minute: "+m);
                    sek.setText("Sekunde: "+s);  
                    stunde.setText("Stunde: "+st);
                    start.setEnabled(true);
                    stopp.setEnabled(false);
                    
                    JFrame warnung = new JFrame("Warnung");
                    JPanel wpanel = new JPanel(new GridLayout(0,1));
                    warnung.add(wpanel);
                    JLabel wtext = new JLabel("Warnung: Zeitlimit überschritten!");
                    wpanel.add(wtext);
                    JButton ok = new JButton("OK");
                    ok.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        warnung.dispose();
                    }
                    });
                    wpanel.add(ok);
                    
                    warnung.pack();
                    warnung.setVisible(true);
                }
            }
        });
        
        frame.setPreferredSize(new Dimension(300, 150));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(){
        new TimDerTimer();
    }

    public void start(){
        timer.start();
        start.setEnabled(false);
        stopp.setEnabled(true);
    }

    public void stopp(){
        timer.stop();
        s = 0;
        m = 0;
        st = 0;
        min.setText("Minute: "+m);
        sek.setText("Sekunde: "+s); 
        stunde.setText("Stunde: "+st);
        start.setEnabled(true);
        stopp.setEnabled(false);
    }
    
    public void zeigeInfo(){
        JFrame info = new JFrame("Info");
        JPanel ipanel = new JPanel(new GridLayout(0,1));
        info.add(ipanel);
        JLabel itext = new JLabel("Copyright: Lxkas der fette Hurensohn!");
        ipanel.add(itext);
        JLabel itext2 = new JLabel("Version: 1.0 / 27.02.21");
        ipanel.add(itext2);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            info.dispose();
        }
        });
        ipanel.add(ok);
        
        info.pack();
        info.setVisible(true);        
    }
}