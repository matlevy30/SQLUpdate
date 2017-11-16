import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PowerStrip {

    private static final String OUTFILENAME = "C:\\Users\\matlevy\\workspace\\The fix\\power.txt";

    public static void main(String[] args) throws IOException {

        // Reading Nlyte XLSX file
        Reader nlyte = new Reader();
        nlyte.readLines();
        ArrayList<NlyteSheet> list = nlyte.getList();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTFILENAME))) {

            for (int i = 0; i != list.size(); ++i) {
                StringBuilder sql = new StringBuilder();
                StringBuilder name = new StringBuilder();
                NlyteSheet values = list.get(i);
                if(!values.assetTag().equals("N/A")) {

                    if(values.HostName().contains(":")) {
                        name.append(values.HostName() + " " + "( CABLE ID " + values.serialNumber() + ")");
                    }
                    else {
                        // Appending PS Name
                        name.append("PS ");
                        //Appending Cabinate Name
                        name.append(values.cabName() + " ");
                        //Appending RU
                        name.append(values.ru() + " ");
                        //Appending Side
                        name.append(values.assetTag());
                        //Appending Cable ID
                        name.append(" ( CABLE ID " + values.serialNumber() + " )");
                    }

                    //Getting Meterial
                    String material = values.MaterialName();
                    sql.append("UPDATE [dbo].[Asset] SET [AssetName] = '" + name.toString() + "'");

                    // Getting Number
                    // first = sCurrentLine.lastIndexOf(",");
                    String number = values.getNumber();
                    // Adding to SQL Statement
                    sql.append(" WHERE [dbo].[Asset].AssetID = '" + number + "';\n");

                    bw.write(sql.toString() + "\n");
                    System.out.print(sql.toString());
                }
            }
        }

    }


}
