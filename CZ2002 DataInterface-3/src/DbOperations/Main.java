package DbOperations;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Course c=new Course("cz2001","computing",2,"SqweE","SE");
		DbWriter dw=new DbWriter("1.txt");
		dw.write(c);
		dw.updateWrite(c);
	}

}
