import javax.swing.JFrame;

public class PasswordGenerator {

	public static void main(String[] args) 
	{
		CustomJFrame frame = new CustomJFrame();
		
		FileReader filereader = new FileReader();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
		//goodbyeUser();
	}
}
