import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

public class Main {

    private JPanel MainGui;
    private JButton addButton;
    private JButton addButton1;
    private JButton addButton2;
    private JButton addButton3;
    private JTextField textField1;
    private JTextField betreuerTextField;
    private JTextField anzPunkte1;
    private JTextField anzPunkte2;
    private JTextField anzPunkte4;
    private JTextField anzPunkte3;
    private JSpinner spinner1;
    private JButton auswertenButton;
    private JTextField punkteTextField;
    private JTextField punkte;
    private JTextField textField2;

    int punkte1 = 0;
    int punkte3 = 0;

    public Main(){
        anzPunkte1.setText("0");
        anzPunkte3.setText("0");

        JFrame MainF = new JFrame("Counter");

        MainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainF.setSize(500, 500);
        MainF.setLocationRelativeTo(null);
        MainF.add(MainGui);
        MainF.setVisible(true);

        FileRader fileRader = new FileRader();

        if(fileRader.dateiexisiert()){
            //spielstandherstellen();
        }else {
            fileRader.dateierstellen();
            System.out.println("Datei erstellt!");
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try{
                        if(punkte != null){
                            int p = Integer.parseInt(punkte.getText());
                            punkte1 = punkte1 + p;
                            String s = String.valueOf(punkte1);
                            anzPunkte1.setText(s);

                            fileRader.inFileSchreiben(punkte1, getPunkte3());
                        }
                    }catch(Exception exception){

                    }
            }
        });
        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (punkte != null) {
                        int p = Integer.parseInt(punkte.getText());
                        punkte3 = punkte3 + p;
                        String s = String.valueOf(punkte3);
                        anzPunkte3.setText(s);
                        fileRader.inFileSchreiben(getPunkte1(), punkte3);
                    }
                }catch(Exception exception){

                }
            }
        });
        auswertenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(anzPunkte1 != null & anzPunkte3 != null & punkte1 > punkte3){
                    textField2.setText("Die Teilnehmer haben gewonnen!");
                }
                if(anzPunkte1 != null & anzPunkte3 != null & punkte1 < punkte3){
                    textField2.setText("Die Betreuer haben gewonnen!");
                }
                if(anzPunkte1 != null & anzPunkte3 != null & punkte1 == punkte3){
                    textField2.setText("Unenschieden!");
                }
            }
        });
    }

    public int getPunkte1(){
        return punkte1;
    }

    public int getPunkte3(){
        return punkte3;
    }

    public static void main(String args[]){
        new Main();
    }
}
