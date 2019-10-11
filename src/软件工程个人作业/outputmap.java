package 软件工程个人作业;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class outputmap {
	 public void  output(String mapname,String road){
		 FileWriter writer;
	        try {
	            writer = new FileWriter(road);
	            writer.write(mapname);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
   }
}
