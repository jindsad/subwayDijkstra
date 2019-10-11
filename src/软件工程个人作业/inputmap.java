package 软件工程个人作业;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class inputmap {
    public List<String>  inputmapname(String mapname){
    	  List<String> list = new ArrayList<String>();
    	  String line =new String();
    	try (FileReader reader = new FileReader(mapname);
                BufferedReader br = new BufferedReader(reader);
           ) {
      	  while ((line = br.readLine()) != null) {
              if (line.lastIndexOf("---") < 0) {
                  list.add(line);
              }
          }
          return list;
           } catch (IOException e) {
               e.printStackTrace();
           }
    	return null;
    	
    }
}
