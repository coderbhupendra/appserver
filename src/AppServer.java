//import classes
import java.net.*;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
//Code for the AppServer class

public class AppServer implements Runnable
{
	
ServerSocket server;
Socket fromClient;
Thread serverThread;

public AppServer()
{
System.out.print("FunChat server started..........");
try
{
server = new ServerSocket(1001);
serverThread = new Thread(this);
serverThread.start();
}
catch(Exception e)
{
System.out.println("Cannot start the thread4: " + e);
}
} //end of AppServer
public static void main(String args[])
{
new AppServer();
}
public void run()
{
try
{
while(true)
{
//Listening to the clients r e q u e s t

fromClient = server.accept();

//Creating the connect object
Connect con = new Connect(fromClient) ;
}
}
catch(Exception e)
{
System.out.println("Cannot listen to the client5"
+ e);
}
} //end of run
} //end of AppServer
//Code for the connect class
class Connect
{
ObjectOutputStream streamToClient;
int ctr = 0;
BufferedReader streamFromClient;
static Vector<String> vector,tempvector;
static int checkfile=1;
String message = " ";
static String str = new String("UsrList");
static String path="C:\\";
static
{
vector = new Vector<String>(1,1);
tempvector = new Vector<String>(1,1);


}

public Connect(Socket inFromClient)
{
	
//Retrieving the clients stream
String msg = " " ;

//to checkif the previous folder was a file or folder so that close it before opening new folder


try
{
	try{
streamFromClient = new BufferedReader(new InputStreamReader(inFromClient.getInputStream()));
streamToClient = new ObjectOutputStream(inFromClient.getOutputStream());
	}
	catch(Exception e)
	{
	System.out.println("Cannot get the client stream connect200"+ e);
	}
	try{
msg = streamFromClient.readLine();

	}catch(Exception e)
	{
	System.out.println("Cannot get the client stream connect2400"+ e);
	}
	
if((msg.equals("From Timer")))
{
	System.out.println("timer");
	path="G:\\";
	FolderList g=new FolderList();
    File[] ans=g.listf(path);
    
    for (int i = 0; i < ans.length; i++) {
      //  System.out.println(vector.size()+String.valueOf(ans[i])) ;
        vector.addElement(String.valueOf(ans[i]));
       // tempvector.addElement(String.valueOf(ans[i]));
    }
    
   
streamToClient.writeObject(vector);

vector.removeAllElements();

}
if((msg.equals("C")))
{
	System.out.println("C");
	path="C:\\";
	FolderList g=new FolderList();
    File[] ans=g.listf(path);
    
    for (int i = 0; i < ans.length; i++) {
      //  System.out.println(vector.size()+String.valueOf(ans[i])) ;
        vector.addElement(String.valueOf(ans[i]));
      //  tempvector.addElement(String.valueOf(ans[i]));
    }
    
   tempvector.addAll(0, vector);
streamToClient.writeObject(vector);

vector.removeAllElements();

}
if((msg.equals("E")))
{System.out.println("E");
	
	path="E:\\";
	FolderList g=new FolderList();
    File[] ans=g.listf(path);
    
    for (int i = 0; i < ans.length; i++) {
      //  System.out.println(vector.size()+String.valueOf(ans[i])) ;
        vector.addElement(String.valueOf(ans[i]));
       // tempvector.addElement(String.valueOf(ans[i]));
    }
    
    tempvector.addAll(0, vector);
streamToClient.writeObject(vector);

vector.removeAllElements();

}
if((msg.equals("G")))
{System.out.println("G");
	
	path="G:\\";
	FolderList g=new FolderList();
    File[] ans=g.listf(path);
    
    for (int i = 0; i < ans.length; i++) {
      //  System.out.println(vector.size()+String.valueOf(ans[i])) ;
        vector.addElement(String.valueOf(ans[i]));
      //  tempvector.addElement(String.valueOf(ans[i]));
    }
    
    tempvector.addAll(0, vector);
streamToClient.writeObject(vector);

vector.removeAllElements();

}
else if((msg.equals("inside")))
	
{
	
	String index = streamFromClient.readLine();

path=index;
//open the file here
File file = new File(path);




if(checkfile==2){
//close preveous window
Robot a = new Robot();
a.keyPress(KeyEvent.VK_ALT);  
a.keyPress(KeyEvent.VK_SPACE); 
a.keyRelease(KeyEvent.VK_ALT);  
a.keyRelease(KeyEvent.VK_SPACE);
a.keyPress(KeyEvent.VK_C);  
a.keyRelease(KeyEvent.VK_C);
checkfile=1;
}

if(file.isFile()){checkfile=1;}

if(file.isDirectory()){checkfile=0;}

Desktop.getDesktop().open(file);

FolderList g=new FolderList();

//to check if a path represents afile or directory 
if(file.isDirectory()){
System.out.println("path"+path) ;
File[] ans=g.listf(path);

for (int i = 0; i < ans.length; i++) {
	 
    vector.addElement(String.valueOf(ans[i]));
  
}

streamToClient.writeObject(vector);

vector.removeAllElements();

}

}
else if((msg.equals("back")))
	
{System.out.println("back");

	
	String indexback = streamFromClient.readLine();

path=indexback;
//open the file here
File file = new File(path);

if(checkfile==2){
	//close preveous window
	Robot a = new Robot();
	a.keyPress(KeyEvent.VK_ALT);  
	a.keyPress(KeyEvent.VK_SPACE); 
	a.keyRelease(KeyEvent.VK_ALT);  
	a.keyRelease(KeyEvent.VK_SPACE);
	a.keyPress(KeyEvent.VK_C);  
	a.keyRelease(KeyEvent.VK_C);
	checkfile=1;
	}

	if(file.isFile()){checkfile=1;}

	if(file.isDirectory()){checkfile=0;}

Desktop.getDesktop().open(file);

FolderList g=new FolderList();

//to check if a path represents afile or directory 
if(file.isDirectory()){
System.out.println("path"+path) ;
File[] ans=g.listf(path);

for (int i = 0; i < ans.length; i++) {
	 
    vector.addElement(String.valueOf(ans[i]));
  
}

streamToClient.writeObject(vector);

vector.removeAllElements();

}

}



}//end of try
catch(Exception e)
{
System.out.println("Cannot get the client stream connect21"+ e);
}
finally
{
try
{
inFromClient.close();
}
catch(IOException e)
{
System.out.print("Exception Occurred3: "+e);
}
}
}//end of Connect()
}