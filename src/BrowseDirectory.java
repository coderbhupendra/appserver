import java.awt.Desktop;
import java.io.*;

public class BrowseDirectory {

	
    public void path(String directory) throws IOException {
        String userHomePath = System.getProperty("user.home")+ "/Desktop";
        File userHome = new File(userHomePath);
        
        File file = new File(directory);
      
        Desktop.getDesktop().open(userHome);
        try {
            String path = "C:\\Drivers\\audio\\G95YY\\Vista64";
            Runtime runtime = Runtime.getRuntime();
         runtime.exec("explorer.exe"+path);
               
        } catch (Exception E) {
        }
     
    }
}