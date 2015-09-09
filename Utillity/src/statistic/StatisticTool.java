package statistic;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class StatisticTool {

	public static void main(String[] args) throws IOException {
		String fileUrl = "D:/loginPMIS.txt";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileUrl));
			Map<String, Integer> statistic = new HashMap<String, Integer>();
			String record = null;
			while((record = reader.readLine()) != null){
				int start = record.indexOf("?u=");
				if(start > 0){
					start += 3;
					int end = record.indexOf("&", start);
					String name = record.substring(start, end);
					if(name.contains("&")){
						System.out.println(name);
					}
					if(statistic.containsKey(name)){
						statistic.put(name, statistic.get(name) + 1);
					} else {
						statistic.put(name, 1);
					}
				}
			}
			
			HSSFWorkbook hssWorkbook = new HSSFWorkbook();
			HSSFSheet sheet = hssWorkbook.createSheet();
			HSSFRow row = null;
			HSSFCell cell = null;
			int rownum = 0;
			int total = 0;
			for(Map.Entry<String, Integer> entry : statistic.entrySet()){
				row = sheet.createRow(rownum);
				cell = row.createCell(0);
				cell.setCellValue(entry.getKey());
				cell = row.createCell(1);
				cell.setCellValue(entry.getValue());
				rownum++;
				total += entry.getValue();
			}
			
			System.out.println(total);
			FileOutputStream out = new FileOutputStream("D:/statistic.xls");
			hssWorkbook.write(out);
		} finally {
			if(reader != null) reader.close();
		}
		
	}
}
