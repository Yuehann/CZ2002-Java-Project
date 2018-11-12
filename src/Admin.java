import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	private String adminID;

	private String passwordHash;

	/* Creates a new Admin with no attribute values*/
	
	public Admin() {
	}
	
	/**
	 * Creates a new Admin with the given attribute values
	 * @param adminID This Admin's adminID
	 * @param passwordHash This Admin's passwordHash
	 */
	
	public Admin(String adminID, String passwordHash) {
		this.adminID = adminID;
		this.passwordHash = passwordHash;
	}
	
	/**
	* Admin login method
	* Compares adminID and passwordHash with database data
	* @param adminID This Admin's adminID
	* @param passwordHash This Admin's passwordHash
	* @return login success failure boolean.
	*/
	
	@SuppressWarnings("unchecked")
	public boolean login(String adminID, String passwordHash) {
		boolean success = false;
		List<Admin> adminUsersList = new ArrayList<Admin>();

		try {
			adminUsersList = readSerializedObject();
			
			for(int i = 0; i < adminUsersList.size(); i++) {
				Admin admin1 = (Admin)adminUsersList.get(i);
								
				if (admin1 != null) {
					if (admin1.getAdminID().equals(adminID)) {
						if (admin1.getPasswordHash().equals(passwordHash)) {
							success = true;
						}
					} 
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	/**
	* Gets the adminID of this Student.
	* @return this Admin's adminID.
	*/
	public String getAdminID() {
		return adminID;
	}
	
	/**
	* Changes the adminID of this admin.
	* @param adminID This Admin's new adminID.
	* Default get/setter, Not used in actual implementation of program
	*/
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	/**
	* Gets the passwordHash of this Student.
	* @return this Admin's passwordHash.
	*/
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	* Changes the passwordHash of this admin.
	* @param passwordHash This Admin's new passwordHash.
	* Default get/setter, Not used in actual implementation of program
	*/
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	/**
	* Reads the data from the database file
	* @return list of objects in the database file.
	*/
	@SuppressWarnings("rawtypes")
	public List readSerializedObject() {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream("admin1.txt");
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList)in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return pDetails;
	}

	/**
	* Writes data to the database file
	* @param list The list of objects to write
	*/
	@SuppressWarnings("rawtypes")
	public void writeSerializedObject(List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("admin1.txt");
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
