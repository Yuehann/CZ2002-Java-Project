import java.io.*;
import java.util.ArrayList;


public class SerializeFile {
	File f;
	ArrayList<Object> target;
	boolean targetexists;
	boolean targetempty;
	boolean fexists;
	boolean fempty;
	boolean targetadded;
	
	public SerializeFile(String filename) {
		f=new File(filename);
		this.target=new ArrayList<Object>();
		this.targetexists=target!=null;
		this.targetempty=target.size()==0;
		this.fexists=this.f.exists();
		this.fempty=f.length()==0;
		this.targetadded=false;
	}
	
	public File getfile() {
		return this.f;
	}
	
	public boolean checkempty() {
		return this.fempty;
	}
	
	public ArrayList<Object> gettarget(){
		return this.target;
	}
	public void printTarget(char mode) {
		if (!targetadded) this.fillArray();
		else {
			if (!targetexists||targetempty) System.out.println("Empty List!");
			else {
				if (mode=='s') {
					for(int i=0;i<this.target.size();i++) {
						System.out.println();
					}
					}
			}
		}
	}
//----------------------------------------Append----------------changed to return a boolean to inform success/fail-----------------//
	//  Polymophism ??
	public boolean appendNew(Object o) {
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
				return true;
			}
			
			else if (fexists&&fempty) {
				fos=new FileOutputStream(f);
				out=new ObjectOutputStream(fos);
				out.writeObject(o);
				out.close();
				fempty=f.length()==0;
				fexists=this.f.exists();
				return true;
			}
			
			else if (!fexists){
				f.createNewFile();
				fos=new FileOutputStream(f);
				out=new ObjectOutputStream(fos);
				out.writeObject(o);
				out.close();
				fempty=f.length()==0;
				fexists=this.f.exists();
				return true;
			}
			
			else //System.out.println("Appending error!");
				return false;
		} 
//		catch exceptions
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: "+e.getMessage());
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			System.out.println("IOExcepton: "+e.getMessage());
			return false;
		}}
//	    end 
	


	//----------------------------------------Fill target array----------------------------------------	
	public void fillArray(){
		try {
			FileInputStream fis;
			ObjectInputStream  in;
		if ((!fexists)||fempty) {
			System.out.println("Empty file:"+this.f.getPath());
			}
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
				targetadded=true;
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
	public void updateWrite(CourseIndex i){
		if (!targetadded) this.fillArray();
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
	
	public void updateWrite(Course i){
		if (!targetadded) this.fillArray();
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
	
	public void updateWrite(Students i){
		if (!targetadded) this.fillArray();
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
	
	public void updateWrite(StudentCourseGrade i){
			if (!targetadded) this.fillArray();
			if (targetexists&&!targetempty) {
				if (i==null) System.out.println("Nothing to update!");
				else {
					int j=this.search(i.getStudentId(),i.getCourseId());
		
					if (j!=-1) {
						if (i.getStudentId()==null) target.remove(j);
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
		if (!targetadded) this.fillArray();
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
				for(int k=0;k<this.target.size();k++) {
					if ((((Course)(target.get(k))).getCourseID()).compareTo(num)==0) {
						return k;
					}
				}
				return -1;
			}
			else if (mode=='s') {
					for(int j=0;j<this.target.size();j++) {
						if ((((Students)(target.get(j))).getStudentId()).compareTo(num)==0) {
							return j;
						}
					}
					return -1;
			}
			else return -1;
		}
		
		return -1;
}
	
	public int search(String sid, String cid) {
		if (!targetadded) this.fillArray();
		if (targetexists&&!targetempty) {
			for(int j=0;j<this.target.size();j++) {
				if ((String.valueOf(((StudentCourseGrade)(target.get(j))).getStudentId()).compareTo(sid)==0)
						&&(String.valueOf(((StudentCourseGrade)(target.get(j))).getCourseId()).compareTo(cid)==0)){
					return j;
				}
			}
			return -1;
		}
		else return -1;
	}
	
//----------------------------------------read one object from target----------------------------------------	
	public Object read(String id,char mode) {
		if (!targetadded) this.fillArray();
		if (targetexists&&!targetempty) {
			int count=this.search(id,mode);
			if (count==-1) return null;
			else return target.get(count);}
		else {
			System.out.println("Target not availavle!");
			return null;}
		}
	
	public Object read(String sid,String cid) {
		if (!targetadded) this.fillArray();
		if (targetexists&&!targetempty) {
			int count=this.search(sid,cid);
			if (count==-1) return null;
			else return target.get(count);}
		else {
			System.out.println("Target not availavle!");
			return null;}
		}
	
	public ArrayList<StudentCourseGrade> readAll(String sid,char mode){
		if (!targetadded) this.fillArray();
		ArrayList<StudentCourseGrade> scg=new ArrayList<StudentCourseGrade>();
		if (targetexists&&!targetempty) {
			if (mode=='s') {
				for(int j=0;j<this.target.size();j++) {
					if ((String.valueOf(((StudentCourseGrade)(target.get(j))).getStudentId()).compareTo(sid)==0)){
						scg.add((StudentCourseGrade) target.get(j));
					}
				}
			}
			else if (mode=='c') {
				for(int j=0;j<this.target.size();j++) {
					if ((String.valueOf(((StudentCourseGrade)(target.get(j))).getCourseId()).compareTo(sid)==0)){
						scg.add((StudentCourseGrade) target.get(j));
					}
				}
			}
			}
		return scg;}
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
