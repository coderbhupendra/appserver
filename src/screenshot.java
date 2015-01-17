import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class screenshot
{
	public static void main(String[] args) throws Exception
	{
		Robot robot = new Robot();
 
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File("screenShot.jpg"));
	}
	public screenshot() {
		// TODO Auto-generated constructor stub
		
	}
	
	public  byte[] getscreen() throws IOException, AWTException
	{
		Robot robot = new Robot();
		 
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	//	ImageIO.write(screenShot, "JPG", new File("screenShot.jpg"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(screenShot, "JPG", baos);
		byte[] bytes = baos.toByteArray();
		
		return bytes;
		
	}
}