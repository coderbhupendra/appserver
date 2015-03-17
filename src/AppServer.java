//import classes
import java.net.*;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
//Code for the AppServer class

import javax.imageio.ImageIO;

public class AppServer implements Runnable
{
	
ServerSocket server;
Socket fromClient;
Thread serverThread;

public AppServer()
{
	InetAddress ip;
	try {
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		System.out.print("FunChat server started..........");
	} catch (UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
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
static ObjectOutputStream streamToClient;
int ctr = 0;
BufferedReader streamFromClient;
static Vector<String> vector,tempvector;
static Vector<Integer> id,check;

static int checkfile=1;
String message = " ";
static String str = new String("UsrList");
static String path="C:\\";
String posx = null,posy = null;

static
{
vector = new Vector<String>(1,1);
id = new Vector<Integer>(1,1);
check=new Vector<Integer>(1,1);
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
	path="D:\\";
	FolderList g=new FolderList();
    File[] ans=File.listRoots();
    
   
    
    for (int i = 0; i < ans.length-1; i++) {
      //  System.out.println(vector.size()+String.valueOf(ans[i])) ;
        vector.addElement(String.valueOf(ans[i]));
        System.out.println(String.valueOf(ans[i]));
       //tempvector.addElement(String.valueOf(ans[i]));
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
if((msg.equals("D")))
{System.out.println("D");
	
	path="D:\\";
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

if((msg.equals("musicsteps")))
	
	{
		
		String index = streamFromClient.readLine();

	path=index;
	//open the file here
	File file = new File(path);
    FolderList g=new FolderList();

	//to check if a path represents afile or directory 
	if(file.isDirectory()){
	System.out.println("path"+path ) ;
	File[] ans=g.listf(path);

	for (int i = 0; i < ans.length; i++) {
		 
	    
	    File file1 = new File(String.valueOf(ans[i])); 
	    if (file1.isHidden() || !file1.canRead()) 
        continue;
	    else
	    {
	   if(file1.isFile()){
		   if (file1.getName().endsWith(".mp4")||file1.getName().endsWith(".mp3"))
		{  id.add(1);
		   vector.addElement(String.valueOf(ans[i]));}
		   }
		   
	   
	   if(file1.isDirectory()){
		  {id.add(2);vector.addElement(String.valueOf(ans[i]));}
		   }
	    }
	}

	System.out.println("data send in music steps line 239") ;
	streamToClient.writeObject(vector);
	streamToClient.writeObject(id);

	vector.removeAllElements();
	id.removeAllElements();
	}
	else 
	{
Desktop.getDesktop().open(file);
	}
	/*else
	{vector.removeAllElements();System.out.println("path11111222 ") ;
	id.removeAllElements();
	vector.add(path);id.add(11);
		streamToClient.writeObject(vector);
		streamToClient.writeObject(id);
		vector.removeAllElements();
		id.removeAllElements();
	}*/

	}

if((msg.equals("music")))
{
	
	System.out.println("music");
	String index = streamFromClient.readLine();
	System.out.println(index);
	extract(new File(index));
	
	
	streamToClient.writeObject(vector);

	vector.removeAllElements();

   

}
if((msg.equals("fileornot")))
{
	
	System.out.println("fileornot");
	String index = streamFromClient.readLine();
	System.out.println(index);
	File file = new File(index);
	

	
	if(file.isFile()){ check.add(1);
		System.out.println("fileornot000000000");}

	else{check.add(0);System.out.println("fileornot111111");}
	 
	streamToClient.writeObject(check);
check.removeAllElements();
   

}
if((msg.equals("play")))
{
	
	System.out.println("play");
	
	String index = streamFromClient.readLine();

	path=index;
	//open the file here
	File file = new File(path);
	Desktop.getDesktop().open(file);
   

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
	 
    
    File file1 = new File(String.valueOf(ans[i])); 
    
    if (file1.isHidden() || !file1.canRead()) 
        continue;
    else vector.addElement(String.valueOf(ans[i]));
    
   if(file1.isFile()){
	  // System.out.println("path11111 "+String.valueOf(ans[i])) ; 
	   if (file1.isHidden() || !file1.canRead()) 
           continue;
	   else id.add(1);
	   }
   
   if(file1.isDirectory()){
	  // System.out.println("path11111222 "+String.valueOf(ans[i])) ;
	   if (file1.isHidden() || !file1.canRead()) 
           continue; 
	   else id.add(2);
	   }
}
System.out.println("path1jjjjjjj") ;
streamToClient.writeObject(vector);
streamToClient.writeObject(id);

vector.removeAllElements();
id.removeAllElements();
}
/*else
{vector.removeAllElements();System.out.println("path11111222 ") ;
id.removeAllElements();
vector.add(path);id.add(11);
	streamToClient.writeObject(vector);
	streamToClient.writeObject(id);
	vector.removeAllElements();
	id.removeAllElements();
}*/

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
	 
   
    File file1 = new File(String.valueOf(ans[i])); 
    if (file1.isHidden() || !file1.canRead()) 
        continue;
    {
    	 vector.addElement(String.valueOf(ans[i]));
    	 
    if(file1.isFile()){
    	//System.out.println("path11111 "+String.valueOf(ans[i])) ; 
    	id.add(1);}
    if(file1.isDirectory()){
    	//System.out.println("path11111222 "+String.valueOf(ans[i]));
    	id.add(2);
    }
    }
  
}

streamToClient.writeObject(vector);
streamToClient.writeObject(id);
vector.removeAllElements();


id.removeAllElements();

}

}

if((msg.equals("backmusic")))
	
{System.out.println("backmusic");

	
String indexback = streamFromClient.readLine();

path=indexback;
//open the file here
File file = new File(path);
FolderList g=new FolderList();

//to check if a path represents afile or directory 
if(file.isDirectory()){
System.out.println("path"+path) ;
File[] ans=g.listf(path);

for (int i = 0; i < ans.length; i++) {
	 
   
    File file1 = new File(String.valueOf(ans[i])); 
    if (file1.isHidden() || !file1.canRead()) 
        continue;
    {
    	 
    	 
    if(file1.isFile()&&(file1.getName().endsWith(".mp4")||file1.getName().endsWith(".mp3"))){
    	//System.out.println("path11111 "+String.valueOf(ans[i])) ; 
    	id.add(1);vector.addElement(String.valueOf(ans[i]));}
    if(file1.isDirectory()){
    	//System.out.println("path11111222 "+String.valueOf(ans[i]));
    	id.add(2);vector.addElement(String.valueOf(ans[i]));
    }
    }
  
}

streamToClient.writeObject(vector);
streamToClient.writeObject(id);
vector.removeAllElements();


id.removeAllElements();

}

}

if((msg.equals("position")))
{   
	
	
	try{
		posx = streamFromClient.readLine();
		
		posy = streamFromClient.readLine();

			}catch(Exception e)
			{
			System.out.println("Cannot get the client stream connect2400"+ e);
			}
	
	
	float dx=Float.parseFloat(posx);
	float dy=Float.parseFloat(posy);
	
	try {
		
		Robot r = new Robot();
		System.out.print((int)dx+":"+(int)dy+"\n");
		r.mouseMove((int)dx,(int)dy);
		
		} catch(AWTException e) {}
		

}
else if((msg.equals("enter")))
{Robot r = new Robot();  
r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);}
else if((msg.equals("first")))
{Robot r = new Robot();  
r.mousePress(InputEvent.BUTTON1_DOWN_MASK);

r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);}
else if((msg.equals("second")))
{Robot r = new Robot();//  r.mousePress(InputEvent.BUTTON2_DOWN_MASK);
r.keyPress(KeyEvent.VK_UP);
r.delay(200);
r.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);}
else if((msg.equals("third")))
{Robot r = new Robot(); // r.mousePress(InputEvent.BUTTON3_DOWN_MASK);

r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);}
else if((msg.equals("wheelup")))
{Robot r = new Robot();  
r.keyPress(KeyEvent.VK_LEFT);
r.delay(200);
}
else if((msg.equals("wheeldown"))){Robot r = new Robot();  
r.keyPress(KeyEvent.VK_RIGHT);
r.delay(200);
}

else if((msg.equals("size")))
{   
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	System.out.print("w "+width+" "+"h "+height);
	
	try{
		Vector<Integer> points=new Vector<Integer>(1,1);
		points.add((int)(width));points.add((int)(height));
		streamToClient.writeObject(points);
		points.removeAllElements();

			}catch(Exception e)
			{
			System.out.println("Cannot get the client stream connect2400"+ e);
			}
	
	
}
else if((msg.equals("screen")))
{  
	screenshot sc=new screenshot();
	byte[] bim=sc.getscreen();
	
	//String str1 = new String(bim, "UTF-8");
	//Vector<String>image= new Vector<String>(1,1);
	//System.out.println("screen"+ bim);
	//image.add(str1);
	//streamToClient.writeObject(image);
	streamToClient.writeObject(bim);
	
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

//this for scanning mp4 through out the folder
public static void extractsong (File dir) {
    File l[] = dir.listFiles();

    if (l == null) {
       // System.out.println("[skipped] " + dir);
        return;
    }

    for (File x : l) {
        if (x.isDirectory())
        {  vector.addElement(x.getPath()); }
        if (x.isHidden() || !x.canRead()) 
            continue;
        else if (x.getName().endsWith(".mp4"))
        { // System.out.println(x.getPath()+"file");//name should be included in path
        
        vector.addElement(x.getPath());
        }
    }

}

// this for scanning mp4 through out the drive
public static void extract(File dir) {
    File l[] = dir.listFiles();

    if (l == null) {
       // System.out.println("[skipped] " + dir);
        return;
    }

    for (File x : l) {
        if (x.isDirectory())
            extract(x);
        if (x.isHidden() || !x.canRead()) 
            continue;
        else if (x.getName().endsWith(".mp4"))
        {  System.out.println(x.getPath());//name should be included in path
        
        vector.addElement(x.getPath());
        }
    }

}
//this for scanning mp4 through out the drive ==end

}