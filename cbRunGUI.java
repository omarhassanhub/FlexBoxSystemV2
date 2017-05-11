import javax.swing.JOptionPane;
public class cbRunGUI {
	public static void main(String args[]) {
		//Run Graphical User Interface
		cbGUI runGUI = new cbGUI();
		runGUI.cbBoxGUI2();
		
		JOptionPane.showMessageDialog(null, 
			"In order to run the database, please do the following:" + "\n" + 
			"Turn on Apache, MySQL" + "\n" + "Add com.mysql.jdbc.Driver to the class path" +
			"\n" + "Import SQL tables to phpMyAdmin");
			
	}//End of main
}//End of cbRunGUI class
