import com.opencsv.CSVWriter;

import java.awt.Desktop;
import java.io.*; 
import java.util.*; 

public class ShiftScheduler {
	
	private static final String CSV_FILE_PATH = "./result.csv";
	
	public static void main( String[] args) {
	
		addData(CSV_FILE_PATH);
	}

	public static void addData(String output) {
		File file = new File(output);
		File file2 = new File("DO NOT DELETE.txt");
		Scanner scan;
		try {
			
			scan = new Scanner(file2);
			
			FileWriter outputFile = new FileWriter(file);
			
			// creating CSV Writer separated by ";"
			CSVWriter csv = new CSVWriter(outputFile, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			
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
			
			showFile(output);
		}
		catch ( IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void showFile(String fileName) throws IOException {
		File file = new File(fileName);
		
		if ( !Desktop.isDesktopSupported()) {
			System.out.print("Desktop is not supported");
			return;
		}
		
		Desktop desktop = Desktop.getDesktop();
		if(file.exists()) desktop.open(file);
	}
	
	public static void addDataArray(ArrayList<Employee> array, String output) throws Exception {
		File file = new File(output);
		try {
		
			FileWriter outputFile = new FileWriter(file);
			
			// creating a CSVWriter separated by ";"
			@SuppressWarnings("deprecation")
			CSVWriter csv = new CSVWriter(outputFile, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER);
			
			//New List to store strings
			String[][] data = new String[25][8];
			//Hard-coding the first row and column
			data[0][0] = "Time";
			data[0][1] = "Sunday";
			data[0][2] = "Monday";
			data[0][3] = "Tuesday";
			data[0][4] = "Wednesday";
			data[0][5] = "Thursday";
			data[0][6] = "Friday";
			data[0][7] = "Saturday";
			data[1][0] = "0:00 - 1:00";
			data[2][0] = "1:00 - 2:00";
			data[3][0] = "2:00 - 3:00";
			data[4][0] = "3:00 - 4:00";
			data[5][0] = "4:00 - 5:00";
			data[6][0] = "5:00 - 6:00";
			data[7][0] = "6:00 - 7:00";
			data[8][0] = "7:00 - 8:00";
			data[9][0] = "8:00 - 9:00";
			data[10][0] = "9:00 - 10:00";
			data[11][0] = "10:00 - 11:00";
			data[12][0] = "11:00 - 12:00";
			data[13][0] = "12:00 - 13:00";
			data[14][0] = "13:00 - 14:00";
			data[15][0] = "14:00 - 15:00";
			data[16][0] = "15:00 - 16:00";
			data[17][0] = "16:00 - 17:00";
			data[18][0] = "17:00 - 18:00";
			data[19][0] = "18:00 - 19:00";
			data[20][0] = "19:00 - 20:00";
			data[21][0] = "20:00 - 21:00";
			data[22][0] = "21:00 - 22:00";
			data[23][0] = "22:00 - 23:00";
			data[24][0] = "23:00 - 23:59";
			for ( int i = 0; i < array.size(); i++) {
				//Getting all the needed information
				String name = array.get(i).getName( );
				int index2 = 0;
				TimeEntry[ ] times = array.get(i).getAvailability( );
				for ( int j = 0; j < times.length; j++ ) {
					TimeEntry temp = times[j];
					String day = temp.getDay();
					switch ( day ) {
					case "Sunday": 
						index2 = 1;
						break;
					case "Monday":
						index2 = 2;
						break;
					case "Tuesday":
						index2 = 3;
						break;
					case "Wednesday":
						index2 = 4;
						break;
					case "Thursday":
						index2 = 5;
						break;
					case "Friday":
						index2 = 6;
						break;
					case "Saturday":
						index2 = 7;
						break;
					default:
						throw new Exception("Not valid day");
					}
					
					int timeStart = times[j].startTime;
					int timeEnd = times[j].endTime;
					timeStart = (timeStart/100) + 1;
					timeEnd = (timeEnd/100) + 1;
					
					while ( timeStart < timeEnd ) {
						if ( data[timeStart][index2] == null ) {
							data[timeStart][index2] = name;
							timeStart++;
						} else {
							data[timeStart][index2] = data[timeStart][index2] + " // " + name;
							timeStart++;
						}
					}
				}
			}
			
			for ( int i = 0; i < 25; i++ ) {
				csv.writeNext(data[i]);
			}
			
			csv.close();
			
			showFile(output);
			
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
}
