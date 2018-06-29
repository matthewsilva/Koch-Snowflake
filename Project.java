import javax.swing.SwingUtilities;

public class Project {
	static MTH215Project project;
	public static void makeProject() throws MatrixException {
		project = new MTH215Project();
	}
	public static void main(String args[]) throws MatrixException {
		makeProject();
		
	}
}
