/**
 * 
 * File Processing Reference:
 * BufferedWriter
 * http://dsearls.org/courses/C113Java/JavaClassFiles/BufferedWriter/BufferedWriter.htm
 * BufferedReader
 * http://dsearls.org/courses/C113Java/JavaClassFiles/BufferedReader/BufferedReader.htm
 * 
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileProcessing {
	private static final Boolean APPEND = true; 
	public static void main(String[] args) {
		try {
			File file = new File("mydatafile.txt");

			file.createNewFile();

			FileWriter fwr = new FileWriter(file, APPEND);
			BufferedWriter bwr = new BufferedWriter(fwr); 
			Scanner keyboard = new Scanner(System.in);

			String result = "";
			System.out.print("Enter the name of your favorite movies.");
			System.out.println("Press 'q' to quit:");

			while(!result.equals("q")) {
				result = keyboard.nextLine();
				if (!result.equals("q")){
					bwr.write(result + "\n");
				}
			}
			bwr.flush();
			bwr.close();


			// Reading the file
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			//read each line and also split each line on the space between words
			//show each word in the output
			while ( (line = br.readLine())!= null)     {
				System.out.println("Line is: " + line);	    	  
				String[] words = line.split(" ");
				for (int i =0; i < words.length; i++) {
					System.out.println("word "+ i + " is: " + words[i]);
				}
			}
			br.close();
		}catch(Exception e){

		}
	}
}
