

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DriveName {


   public static void main(String[] args) {
      
	   
	   InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
			//Getting IPAddress of localhost - getHostAddress return IP Address
	        // in textual format
	        String ipAddress = addr.getHostAddress();
	      
	        System.out.println("IP address of localhost from Java Program: " + ipAddress);
	      
	        //Hostname
	       String hostname = addr.getHostName();
	        System.out.println("Name of hostname : " + hostname);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      File[] paths;
      
      try{      
         // returns pathnames for files and directory
         paths = File.listRoots();
         
         // for each pathname in pathname array
         for(File path:paths)
         {
            // prints file and directory paths
            System.out.println(path);
         }
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}