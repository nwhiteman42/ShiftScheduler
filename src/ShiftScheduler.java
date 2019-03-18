import com.opencsv.CSVWriter;
import java.io.*; 
import java.util.*; 

public class ShiftScheduler {
	
	private static final String CSV_FILE_PATH = "./result.csv";
	
	public static void main( String[] args) {
		addData(CSV_FILE_PATH);
	}

	public static void addData(String output) {
		File file = new File(output);
		File file2 = new File("C:\\Users\\Cameron\\Documents\\C Programs\\DO NOT FUCKING DELETE.txt");
		Scanner scan;
		try {
			
			scan = new Scanner(file2);
			
			FileWriter outputFile = new FileWriter(file);
			
			// creating CSV Writer separated by ";"
			CSVWriter csv = new CSVWriter(outputFile, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			
			// creating a List containing data
			List<String[]> data = new ArrayList<String[]>();
			
			// int numberOfRows = 25;
			// System.out.println("Enter Data");
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] rowData = row.split(" ");
				data.add(rowData);
			}
			
			csv.writeAll(data);
			
			
			csv.close();
		}
		catch ( IOException e) {
			e.printStackTrace();
		}
	}
}
