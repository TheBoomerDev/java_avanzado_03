package piratasGame.game.luchadores.insultos;

import java.util.ArrayList;
import java.util.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/*
    Patron Builder
 */
public class FileHandler {

    private final String filename;
    private File file;
    private List<String> lineas = new ArrayList<String>();

    public FileHandler(String fileName){
        this.filename = fileName;
        String dirPath = "c:/";
        this.file = new File(dirPath+this.filename);
    }

    public void read() throws FileNotFoundException {
        if (!this.file.exists()) return;
        Scanner lector = new Scanner(this.file);
        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            this.lineas.add(linea);
        }
        lector.close();
    }

    public List<String> getLines(){
        return lineas;
    }
}
