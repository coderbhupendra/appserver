import java.io.*;
public class Music {
	public static void main(String args[]) {
	    extract(new File("c:\\"));

	}

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
	        else if (x.getName().endsWith(".mp3"))
	            System.out.println(x.getPath());//name should be included in path
	    }

	}
}