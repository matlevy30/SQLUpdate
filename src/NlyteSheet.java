
public class NlyteSheet {
	
	String[]values;
	
	public NlyteSheet(String[] values) {
		this.values = values;
	}
	

	public String assetTag() {
		return values[4].trim();
	}
	
	
	public String serialNumber() {
		return values[3].trim();
	}
	
	
	public void setSerial(String s) {
		values[3] = s.trim().toUpperCase();
	}
	
	
	public void setAssetTag(String s) {
		values[4] = s.trim().toUpperCase();
	}
	
	public String MaterialName() {
		return values[5].trim();
	}
	
	
	public String HostName() {
		return values[0].trim();
	}


	public String getNumber() {
		return values[1].trim();
	}
	
	
	public String[] getLine() {
		return values;
	}
	
	// Printing line values, local methods
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i != values.length; ++i) {
				sb.append(values[i] + ", ");
			}
			return sb.toString();
		}
}
