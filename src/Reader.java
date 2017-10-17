import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVReader;

public class Reader {

	private CSVReader reader;
	private ArrayList<NlyteSheet> lines;
	private String[] header;

	public Reader() throws FileNotFoundException {

		String fileName = "src/Update.csv";
		reader = new CSVReader(new FileReader(fileName));
		lines = new ArrayList<>();
	}

	public void readLines() throws IOException {

		// Header
		header = reader.readNext();
		// First Line
		String[] line = reader.readNext();

		while (line != null) {
			// Filtering Locations
			lines.add(new NlyteSheet(line));
			line = reader.readNext();
		}
	}

	public ArrayList<NlyteSheet> getList() {
		return lines;
	}
	// Return Header of File
	public String[] getHeader() {
		return header;
	}
}
