package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.transform.Templates;

	
public class lab1 {
	public static void main(String[] args) throws IOException {
		 FileReader fr= null;
		 BufferedReader br =null;

		try {
			fr = new FileReader("E:\\\\Java-Web19jsp04\\test.txt");
			br = new BufferedReader(fr);

			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {
			System.out.println("error is " + e);
		}
	}

}
