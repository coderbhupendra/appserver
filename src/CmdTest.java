import java.io.*;
import java.util.List;

public class CmdTest {
    public static void main(String[] args) throws Exception {
        
    	String path="E:\\";
    	
        FolderList g=new FolderList();
        File[] ans=g.listf(path);

        BrowseDirectory b=new BrowseDirectory();
        b.path(path);
        
        String path1 = "http:/zareahmer";

        int pos = path1.lastIndexOf("/");

        String x =path1.substring(pos+1 , path1.length()-1);
        System.out.println(x) ;
        
     String   headpath = "E:\\New Folder\\kajal";
        int pos1 = headpath.lastIndexOf("\\");
        String head =headpath.substring(0 , pos1);
        System.out.println(head) ;
        for (int i = 0; i < ans.length; i++) {
           // System.out.println(ans[i]) ;
            
        }
    }
}
