import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleFileClient {

  public final static int SOCKET_PORT = 1001;      // you may change this
  public final static String SERVER = "192.168.43.169";  // localhost
  public final static String
       FILE_TO_RECEIVED = "E:/study/i sem/java game programming/2.mp4";  // you may change this, I give a
                                                            // different name because i don't want to
                                                            // overwrite the one used by server...

  public final static long FILE_SIZE =500000; // file size temporary hard coded
                                               // should bigger than the file to be downloaded

  public static void main (String [] args ) throws IOException {
	  
	  //start  time
	  long startTime = System.currentTimeMillis();
	  
    int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket sock = null;
    try {
      sock = new Socket(SERVER, SOCKET_PORT);
      System.out.println("Connecting...");

      
      
      
      int i=0;
      // receive file
      
      InputStream is = sock.getInputStream();
      fos = new FileOutputStream(FILE_TO_RECEIVED);
      bos = new BufferedOutputStream(fos);
      //bytesRead = is.read(mybytearray,0,mybytearray.length);
      //current = bytesRead;
      //bos.write(mybytearray, 0 , current);
      do {
    	  byte [] mybytearray  = new byte [(int)FILE_SIZE];
    	  bytesRead = is.read(mybytearray,0,mybytearray.length);
         
         if(bytesRead!=-1)
        	 {bos.write(mybytearray, 0 , bytesRead);
          bos.flush();}
         System.out.println(i+"Fileread " +current);
         if(bytesRead >= 0) current += bytesRead;
         i++;
      } while(bytesRead >-1);

     // bos.write(mybytearray, 0 , current);
      
      System.out.println("File " + FILE_TO_RECEIVED + " downloaded (" + current + " bytes read)");
    }
    finally {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (sock != null) sock.close();
      long endTime = System.currentTimeMillis();
 }
  }

}