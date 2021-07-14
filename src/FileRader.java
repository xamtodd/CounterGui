import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileRader {
    int punkte1;
    int punkte3;
    File file = new File("src/spielstand.txt");

    public FileRader() {

    }

    public void dateierstellen() {
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean dateiexisiert() {
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void filelesen(){
        String inhalt = "";

        try{
            Scanner s = new Scanner(file);

            while (s.hasNext()){
                inhalt = inhalt.concat(s.next());
            }
            System.out.println(inhalt);

            String[] elemente = inhalt.split(";");

            punkte1 = Integer.parseInt(elemente[0]);
            punkte3 = Integer.parseInt(elemente[1]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void inFileSchreiben(int punkte1, int punkte3){
        try{
            OutputStream stream = new FileOutputStream(file);
            String p1 = String.valueOf(punkte1);
            String p3 = String.valueOf(punkte3);
            String text = p1 + ";" + p3;

            stream.write(text.getBytes());
            stream.close();

            System.out.println(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dateiloeschen(){
        inFileSchreiben(0,0);
    }

    public int getPunkte1(){
        return punkte1;
    }

    public int getPunkte3(){
        return punkte3;
    }
}
