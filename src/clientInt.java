
import java.io.*;
import java.net.*;
import java.util.*;


public class clientInt 
{



Socket toServer;
ObjectInputStream streamFromServer;
PrintStream streamToServer;

static Vector<String> vector;

@SuppressWarnings("unchecked")
public void receive()
{
	
try
{
toServer = new Socket("192.168.43.169",1001);
streamFromServer = new ObjectInputStream(toServer.getInputStream());
streamToServer = new PrintStream(toServer.getOutputStream());


//send a message to the server
streamToServer.println("From Timer");

//receive vectors from the server
 vector =(Vector<String>)streamFromServer.readObject();

streamFromServer.close();

}//end of try
catch(Exception e)
{
System.out.println("Exception9" + e ) ;
}

}//end of TimerListener class

public  Vector<String> getVector()
	{return vector;}


public static void main(String args[])
{

clientInt CI = new clientInt();
CI.receive();

}

public clientInt() {
	clientInt CI = new clientInt();
	CI.receive();
}
}//end of class