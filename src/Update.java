import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Update {

	private static final String OUTFILENAME = "C:\\Users\\matlevy\\workspace\\The fix\\final.txt";

	public static void main(String[] args) throws IOException {

		// Reading Nlyte XLSX file
		Reader nlyte = new Reader();
		nlyte.readLines();
		ArrayList<NlyteSheet> list = nlyte.getList();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTFILENAME))) {

			for (int i = 0; i != list.size(); ++i) {
				StringBuilder sb = new StringBuilder();
				NlyteSheet values = list.get(i);
    
				// Appending Serial Number
				String serial = values.serialNumber();
				// Adding to SQL Statement
				//sb.append("UPDATE [dbo].[Asset] SET [SerialNumber] = '" + serial + "'");

				// Getting Asset Tag
				String tag = values.assetTag();
				// Adding to SQL Statement
				//sb.append(",[Tag] =  '" + tag + "'");
				
				
				//Getting Meterial
				String material = values.MaterialName();
				sb.append("UPDATE [dbo].[Asset] SET [MaterialID] = '" + material + "'");

				// Getting Number
				// first = sCurrentLine.lastIndexOf(",");
				String number = values.getNumber();
				// Adding to SQL Statement
				sb.append(" WHERE [dbo].[Asset].AssetID = '" + number + "';\n");

				bw.write(sb.toString() + "\n");
				System.out.print(sb.toString());
			}
		}

	}

}
