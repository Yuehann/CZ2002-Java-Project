import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		CourseIndex i=new CourseIndex(00001,"cz2001", 3, null, null);
		DBWriter dw=new DBWriter("index.txt");
		dw.appendNew(dw.write(i));
	}

}