// Demonstration of accessing private variables
// of other instantiations of the same class
public class PrivateVariables {

	private int var;
	private String val;

	public static void main(String[] args) {
		PrivateVariables cat = new PrivateVariables();
		PrivateVariables dog = new PrivateVariables(true);
		System.out.println(cat.equals(dog));
		dog.setVal("14");
		dog.setVar(12);
		System.out.println(cat.equals(dog));
	}

	public PrivateVariables() {
		this.var = 12;
		this.val = "14";
	}

	public PrivateVariables(boolean boo) {
	}

	public void setVar(int i) {
		this.var = i;
	}

	public void setVal(String s) {
		this.val = s;
	}

	public boolean equals(PrivateVariables other) {
		if(this == other)
			return true;
		if(this.var == other.var && this.val.equals(other.val))
			return true;
		return false;
	}
}
