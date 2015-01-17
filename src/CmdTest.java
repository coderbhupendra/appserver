import java.io.*;
import java.util.List;

public class CmdTest {
    public static void main(String[] args) throws Exception {
    	try {
    	    String str ="C:/SongList.txt";
    	    Process process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/C",str});
    	    System.out.println(str);
    	    
    	    String[] command = new String[3];
    	    command[0] = "cmd";
    	    command[1] = "/C";
    	    command[2] = "C:/SongList.txt";

    	    Process p = Runtime.getRuntime().exec (command);
    	    
    	    String file = "C:/SongList";

    	    //Process process1 = Runtime.getRuntime().exec(new String[]{"cmd", "/C", "notepad.exe", file});
    	    
    	    final String dosCommand = "cmd /c dir /s";
    	      final String location = "D:\\books";
    	      try {
    	         final Process process2 = Runtime.getRuntime().exec(
    	            dosCommand + " " + location);
    	         final InputStream in = process2.getInputStream();
    	         int ch;
    	         while((ch = in.read()) != -1) {
    	            System.out.print((char)ch);
    	         }
    	      } catch (IOException e) {
    	         e.printStackTrace();
    	      }
    	    } catch (Exception ex) {}
    	    }
}
