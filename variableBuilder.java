import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class variableBuilder {

	public static void main(String[] args) throws IOException {

		config config = new config();
		config.openConfig("C:\\6513.txt","C:\\output.txt", false);
		
		config.findVariables();



	}
	
	public static class config {
		public BufferedReader in;
		public Writer out;
		
		public config (){
			in = null;
			out = null;
		}
		
		public void openConfig(String fileIn, String fileOut, Boolean ow) throws IOException {
			File input = new File(fileIn);
			FileOutputStream output = new FileOutputStream(fileOut, ow);
			this.in = new BufferedReader(new FileReader(input));
			this.out = new BufferedWriter(new OutputStreamWriter(output));
		}
		
		public void findVariables() throws IOException {
			String line = null;
			while ((line = this.in.readLine()) != null) {
				if(line.startsWith("hostname ")){
					System.out.println(line.substring(9, line.length()));
				}else if(line.startsWith("interface ")) {
					System.out.println(line.substring(10,line.length()));
					//line = this.in.readLine();
					do {
						line = this.in.readLine();
						if(line.startsWith(" description")){
							System.out.println(line);
						}else if (line.startsWith(" ip address ")){
							System.out.println(line);
						} else if(line.startsWith(" switchport access ")){
							System.out.println(line);
						} else if(line.contains("trunk")){
							System.out.println(line);
						}
						if (line.startsWith(" shutdown")){
							System.out.println(line);
						}
					}while(line.startsWith(" "));
				} 
			}
			return;
		}

	}

}
