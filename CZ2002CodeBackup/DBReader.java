import java.io.IOException;

public class DBReader extends DBAccess{
		private String read;
		
		DBReader(String filename,String target) throws IOException{
			super(filename);
			this.read=super.search(target);
		}
		
//		setContent(Course c){}
//		setContent(Student s){}
//		setContent(Index i){}
//		setContent(Grade g){}
}	
