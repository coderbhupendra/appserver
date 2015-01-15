

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {

  public final static int SOCKET_PORT = 1001;  // you may change this
  public final static String FILE_TO_SEND = "E:/study/i sem/java game programming/1.mp4";  // you may change this

  @SuppressWarnings("resource")
public static void main (String [] args ) throws IOException {
	
	  //start time 
	long startTime = System.currentTimeMillis();
	  
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket servsock = null;
    Socket sock = null;
    int size=0;
    try {
      servsock = new ServerSocket(SOCKET_PORT);
      while (true) {
        System.out.println("Waiting...");
        try {
        	
        	//get the size of the file 
            File f = new File(FILE_TO_SEND);
            System.out.println("file size..."+f.length());
            
          sock = servsock.accept();
          System.out.println("Accepted connection : " + sock);
          // send file
          File myFile = new File (FILE_TO_SEND);
         // System.out.println("file size..."+f.length());
           size=(int)f.length();
          int a=50000000;int b=0;
          int i=0;int rema=0;int cons=0;
          
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          os = sock.getOutputStream();
          
          while(b<size) 
          {
          byte [] mybytearray  = new byte [(int)a];
         System.out.println("count" +i+" read"+b +"out of"+size+mybytearray);
         
          if(rema<a)cons=rema;else cons=a;
          int x=bis.read(mybytearray,0,cons);
          
          
         // System.out.println("Sending " + FILE_TO_SEND + "(" + a + " bytes)");
         os.write(mybytearray,0,x);
          os.flush();
          b+=x;
          rema=size-b;
          //System.out.println("count" +i+" read"+b +"out of"+size+mybytearray);
          i++;
          
       // System.out.println("x"+x+"  " +"b "+b +"  "+mybytearray);
          }
          System.out.println("Done.");
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
          long endTime = System.currentTimeMillis();


          System.out.println("That took " + (endTime - startTime)/1000 + " seconds"+"  speed "+(size/(1024*1024))/((endTime - startTime)/1000)+"Mbps");
       
        }
      }
    }
    finally {
      if (servsock != null) servsock.close();
    }
  }
}
