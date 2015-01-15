import java.io.File;



public class FolderList {

	public static void main(String []args) {
		// .............list file
	    File directory = new File("E:\\study");

	    // get all the files from a directory
	    File[] fList = directory.listFiles();

	    for (File file : fList) {
	        if (file.isFile()) {
	           System.out.println(file.getAbsolutePath());
	        } else if (file.isDirectory()) {
	           // listf(file.getAbsolutePath());
	        	System.out.println(file.getAbsolutePath()+"1111111111");
	        }
	    }
	    //System.out.println(fList);
	}
	
	 public File[] listf(String directoryName) {

		    // .............list file
		    File directory = new File(directoryName);

		    // get all the files from a directory
		    File[] fList = directory.listFiles();

		    for (File file : fList) {
		        if (file.isFile()) {
		          // System.out.println(file.getAbsolutePath());
		        } else if (file.isDirectory()) {
		           // listf(file.getAbsolutePath());
		        }
		    }
		    //System.out.println(fList);
		    return fList;
		}          

	
	
	
}
