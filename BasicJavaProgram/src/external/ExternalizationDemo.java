package external;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ExternalizationDemo {

	public static void main(String[] args) {
		External external = new External();
		external.setEmpID(1);
		external.setEmpName("Manjit");
		external.setEmpSal(10);
		external.setTemp(10);
		external.setParentEmpID(80);
		System.out.println(external.getEmpID()+">>"+external.getEmpName()+">>"+external.getEmpSal()+">>"+external.getTemp()+">>"+external.getParentEmpID());
		try {
			FileOutputStream fs = new FileOutputStream("exter");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(external);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream fi = new FileInputStream("exter");
			ObjectInputStream os = new ObjectInputStream(fi);
			External ext = (External) os.readObject();
			System.out.println(ext.getEmpID()+">>"+ext.getEmpName()+">>"+ext.getEmpSal()+">>"+ext.getTemp()+">>"+ext.getParentEmpID());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

class ExternalParent {
	private long parentEmpID;

	/**
	 * @return the parentEmpID
	 */
	public long getParentEmpID() {
		return parentEmpID;
	}

	/**
	 * @param parentEmpID the parentEmpID to set
	 */
	public void setParentEmpID(long parentEmpID) {
		this.parentEmpID = parentEmpID;
	}
	
}

class External extends ExternalParent implements Externalizable, Serializable {

	private transient long empID;
	private transient String empName;
	private transient long empSal;
	private long temp;
	public External(){
		System.out.println("No -arg Construct");
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(this.getEmpID());
		out.writeLong(this.getEmpSal());
		out.writeObject(this.getEmpName());
		out.writeLong(this.getParentEmpID());
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.setParentEmpID(in.readLong());
		this.setEmpID(in.readLong());
		this.setEmpName((String) in.readObject());
		this.setEmpSal(in.readLong());
		
		
		
	}

	/**
	 * @return the empID
	 */
	public long getEmpID() {
		return empID;
	}

	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(long empID) {
		this.empID = empID;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empSal
	 */
	public long getEmpSal() {
		return empSal;
	}

	/**
	 * @param empSal the empSal to set
	 */
	public void setEmpSal(long empSal) {
		this.empSal = empSal;
	}

	/**
	 * @return the temp
	 */
	public long getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(long temp) {
		this.temp = temp;
	}
	
}
