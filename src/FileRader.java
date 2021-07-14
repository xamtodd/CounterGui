import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileRader {
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
}
