import java.io.*;

public class DBAccess {
	protected File f;
	protected int index;
//search based on the first attribute
	public DBAccess(String filename){
		this.f=new File(filename);
	}
	

	public String search(String target) throws IOException{
		String temp;
		int count=0;
		BufferedReader br=new BufferedReader(new FileReader(f));
		while((temp=br.readLine())!=null) {
			if (temp.split(" ")[0].compareTo(target)==0) {
				this.index=count;
				br.close();
				return temp;
			}
			else {
				count++;
			}
		}
		br.close();
		return "";
	}

}