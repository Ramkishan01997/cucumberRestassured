package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class tes extends Utils {
//test file 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s="ramkisha";
		String rev="";
		for(int i=s.length()-1;i>=0;i--) {
			rev=rev+s.charAt(i);
			
		}
		System.out.println(rev);
		System.out.println(getPropertyValue("baseUrl"));
		FileOutputStream fout=new FileOutputStream("mfile.txt");  
		   PrintStream pout=new PrintStream(fout);  
		   pout.println(1900);  
		   pout.println("Hello Java");  
		   pout.println("Welcome to Java");  
		   pout.close();  
		   fout.close();  
//		System.out.println(System.getProperty("user.dir"));

	}

}
