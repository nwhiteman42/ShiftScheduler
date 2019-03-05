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
		Scanner scan = new Scanner(System.in);
		try {
			
			FileWriter outputFile = new FileWriter(file);
			
			// creating CSV Writer separated by ";"
			CSVWriter csv = new CSVWriter(outputFile, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			
			// creating a List containing data
			List<String[]> data = new ArrayList<String[]>();
			
			int numberOfRows = 25;
			System.out.println("Enter Data");
			for ( int i = 0; i < numberOfRows; i++) {
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
