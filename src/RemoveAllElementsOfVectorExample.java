import java.util.Vector;

public class RemoveAllElementsOfVectorExample {
 
  public static void main(String[] args) {
    //create a Vector object
    Vector v = new Vector();
   
    //Add elements to Vector
    //v.add("1");
    //v.add("2");
    //v.add("3");
   
    System.out.println("Size of Vector before removing elements : " + v.capacity());
    /*
      To remove all elements from the Vector use
      void clear() method.
    */
    //v.clear();
    //OR v.removeAllElements();
    System.out.println("Size of Vector after removing elements : " + v.size());
   
    /*
       Please note that removeAllElements method is also identical to clear
       method and can be used to remove all elements from the Vector.
    */
  }
}