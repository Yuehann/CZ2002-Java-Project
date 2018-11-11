import java.io.*;
import java.util.ArrayList;
public class SerializeFile {
	File f;
	ArrayList<Object> target;
	boolean targetexists;
	boolean targetempty;
	boolean fexists;
	boolean fempty;
	
	public SerializeFile(String filename) {
		f=new File(filename);
		this.target=new ArrayList<Object>();
		this.targetexists=target!=null;
		this.targetempty=target.size()==0;
		this.fexists=this.f.exists();
		this.fempty=f.length()==0;
	}
	public File getfile() {
		return this.f;
	}
	
//----------------------------------------Append----------------------------------------
	public void appendNew(Object o) {
		try {
			FileOutputStream fos;
			ObjectOutputStream out;
			//!!care exist but empty
			if (fexists&&!fempty) {
				fos=new FileOutputStream(f,true);
				out=new ObjectOutputStream(fos);
				long pos=fos.getChannel().position()-4;
				fos.getChannel().truncate(pos);
				out.writeObject(o);
				out.close();
				fempty=f.length()==0;
				fexists=this.f.exists();
			}
			
			else if (fexists&&fempty) {
				fos=new FileOutputStream(f);
				out=new ObjectOutputStream(fos);
				out.writeObject(o);
				out.close();
				fempty=f.length()==0;
				fexists=this.f.exists();
			}
			
			else if (!fexists){
				f.createNewFile();
				fos=new FileOutputStream(f);
				out=new ObjectOutputStream(fos);
				out.writeObject(o);
				out.close();
				fempty=f.length()==0;
				fexists=this.f.exists();
			}
			
			else System.out.println("Appending error!");
		} 
//		catch exceptions
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOExcepton: "+e.getMessage());
		}}
//	    end 
	


	//----------------------------------------Fill target array----------------------------------------	
	public void fillArray(){
		try {
			FileInputStream fis;
			ObjectInputStream  in;
		if ((!fexists)||fempty) System.out.println("File not available!");
		else {
		
				fis=new FileInputStream(f);
				in=new ObjectInputStream(fis);
				
				if (targetexists&&!targetempty) target.clear();
				
				while (fis.available()>0) {
					target.add(in.readObject());
				}
				in.close();
				targetexists=target!=null;
				targetempty=target.size()==0;
		}
		}
		
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOExcepton: "+e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound: "+e.getMessage());
		}
		}
//----------------------------------------update----------------------------------------	
	public void updateWrite(CourseIndex i) throws FileNotFoundException, IOException {
		
		if (targetexists&&!targetempty) {
			if (i==null) System.out.println("Nothing to update!");
			else {
				int j=this.search(String.valueOf(i.getIndex()),'i');
		
				if (j!=-1) {
					if (i.getCourseId()==null) target.remove(j);
					else target.set(j,i);
					this.writeArray();
				}
				else System.out.println("Object not found.");
			}
		}
	
		else {
			if (i==null) System.out.println("Nothing to update!");
			else this.appendNew(i);
		}
	}
	
	public void updateWrite(Course i) throws FileNotFoundException, IOException {
		
		if (targetexists&&!targetempty) {
			if (i==null) System.out.println("Nothing to update!");
			else {
				int j=this.search(String.valueOf(i.getCourseID()),'c');
		
				if (j!=-1) {
					if (i.getCourseName()==null) target.remove(j);
					else target.set(j,i);
					this.writeArray();
				}
				else System.out.println("Object not found.");
			}
		}
	
		else {
			if (i==null) System.out.println("Nothing to update!");
			else this.appendNew(i);
		}
	}
	
	public void updateWrite(Students i) throws FileNotFoundException, IOException {
		
		if (targetexists&&!targetempty) {
			if (i==null) System.out.println("Nothing to update!");
			else {
				int j=this.search(String.valueOf(i.getStudentId()),'s');
		
				if (j!=-1) {
					if (i.getStudentName()==null) target.remove(j);
					else target.set(j,i);
					this.writeArray();
				}
				else System.out.println("Object not found.");
			}
		}
	
		else {
			if (i==null) System.out.println("Nothing to update!");
			else this.appendNew(i);
		}
	}
	
	
			
//----------------------------------------search in target----------------------------------------	
	public int search(String num,char mode) {
		if (targetexists&&!targetempty) {
			if (mode=='i') {
				for(int j=0;j<this.target.size();j++) {
					if (String.valueOf(((CourseIndex)(target.get(j))).getIndex()).compareTo(num)==0) {
						return j;
					}
				}
				return -1;
			}
			else if (mode=='c') {
				for(int j=0;j<this.target.size();j++) {
					if ((((Course)(target.get(j))).getCourseID()).compareTo(num)==0) {
						return j;
					}
					return -1;
				}
			}
			else if (mode=='s') {
					for(int j=0;j<this.target.size();j++) {
						if ((((Students)(target.get(j))).getStudentId()).compareTo(num)==0) {
							return j;
						}
					return -1;
					}
			}
			else return -1;
		}
		
		return -1;
}
//----------------------------------------read one object from target----------------------------------------	
	public Object read(String id,char mode) {
		if (targetexists&&!targetempty) {
			int count=this.search(id,mode);
			return target.get(count);}
		else {
			System.out.println("Target not availavle!");
			return null;}
		}
//----------------------------------------write target to file----------------------------------------			
	public void writeArray() {
		ObjectOutputStream out;
		try {
			
		if (targetexists&&!targetempty&&fexists) {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			for(int j=0;j<this.target.size();j++) {
				out.writeObject(target.get(j));
			}
			out.close();
		}
		
		else if(targetexists&&targetempty&&fexists){
			String path=f.getPath();
			f.delete();
			f=new File(path);
		}
		else System.out.println("Write error!");
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOExcepton: "+e.getMessage());
	}
		
		
		
	}
}
