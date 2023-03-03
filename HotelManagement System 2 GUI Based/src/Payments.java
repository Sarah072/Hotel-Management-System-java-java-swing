import java.io.File;
import java.io.IOException;

public class Payments {

	protected int payment_id;
	protected int payment_customer_id;
	protected String payment_description;
	protected double payment_amount;
	
	public Payments() throws IOException {
		File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Payments.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
	}
}
