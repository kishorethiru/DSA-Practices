package fileread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Kishore
 *
 */
public class FileReader {
	public static void main(String[] args) throws IOException {
		java.io.FileReader fr = null;
		try {
			fr = new java.io.FileReader(new File("./src/concepts/read.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		List<String> data = new ArrayList<>();
		br.lines().forEach((each)->data.add(each));
		Map<String,List<String>> op  = new HashMap<>();
		List<String> headers = Arrays.asList(data.get(0).split("\s{2,}")) ;
		for(int i = 2; i < data.size(); i++) {
			String[] eachItem = data.get(i).split("\s{2,}");
			for(int j = 0 ; j < eachItem.length;j++) {
				if(op.containsKey(headers.get(j))){
					List<String> list = op.get(headers.get(j));
					list.add(eachItem[j]);
					op.put(headers.get(j), list);
				}
				else {
					List<String> newItem = new ArrayList<>();
					newItem.add(eachItem[j]);
					op.put(headers.get(j), newItem);
				}
			}		
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./src/concepts/readWrite.txt")));
		data.stream().forEach((each)->{
			try {
				bw.write(each+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		bw.close();
		System.out.println(op);
	}
}