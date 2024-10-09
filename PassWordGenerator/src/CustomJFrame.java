import java.awt.GridBagConstraints;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


public class CustomJFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel upperCaseLetters = new JLabel("Uppercase letters");
	JLabel lowerCaseLetters = new JLabel("Lowercase letters");
	JLabel numbers = new JLabel("numbers");
	JLabel symbols = new JLabel("symbols");
	JLabel passwordLength = new JLabel("Password Length: ");
	JCheckBox upperCaseCheck = new JCheckBox();
	JFormattedTextField passwordLengthField =  new JFormattedTextField(00);
	JCheckBox symbolsCheck = new JCheckBox();
	JCheckBox lowerCaseCheck = new JCheckBox();
	JCheckBox numbersCheck = new JCheckBox();
	JTextField generatedPasswordField = new JTextField(20);

	public CustomJFrame() 
	{
		ButtonListener actionListener = new ButtonListener();
		
		//calls up from JFrame to make a jframe object
		GridBagConstraints layoutManager = new GridBagConstraints();
		setTitle("Rhett's Password Generator");
		
		setSize(300,400);
		
		setLayout(new GridBagLayout());
		//this right-aligns the radio buttons for later, and makes the preceding text look sharp
		layoutManager.anchor = GridBagConstraints.WEST;
		layoutManager.insets = new Insets(5,5,5,5);
		
		//ButtonListener actionListener = new ButtonListener();
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		add(upperCaseLetters,layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		add(lowerCaseLetters,layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 2;
		add(numbers,layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 3;
		add(symbols,layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 4;
		add(passwordLength,layoutManager);
		
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 0;
		upperCaseCheck.setSelected(true);
		add(upperCaseCheck,layoutManager);
		
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 1;
		lowerCaseCheck.setSelected(true);
		add(lowerCaseCheck,layoutManager);
		
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 2;
		numbersCheck.setSelected(true);
		add(numbersCheck,layoutManager);
		
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 3;
		symbolsCheck.setSelected(true);
		add(symbolsCheck,layoutManager);
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 4;
		passwordLengthField.setValue(16);
		passwordLengthField.setColumns(2);
		add(passwordLengthField,layoutManager);
		
		layoutManager.gridwidth = 2;
		
		JButton generateButton = new JButton("Generate Password");
		generateButton.addActionListener(actionListener);
		layoutManager.gridx = 0;
		layoutManager.gridy = 5;
		add(generateButton,layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 6;
		add(generatedPasswordField,layoutManager);
		
		generateButton.doClick();
	}

	
	public class ButtonListener implements ActionListener
	{
		
		/**
		 * @param e the object that created the event
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand().equals("Generate Password"))
			{
			}
			
			
			if(e.getActionCommand().equals("Generate Password"))
			{
				System.out.println("Generate!");
				
				int passwordLength = Integer.parseInt(passwordLengthField.getText());

				String GeneratedPassword = randomPasswordGenerator.passwordGenerator(upperCaseCheck.isSelected(),lowerCaseCheck.isSelected(),
						   numbersCheck.isSelected(), symbolsCheck.isSelected(),false,passwordLength);
				
				generatedPasswordField.setText(GeneratedPassword);
				
				StringSelection stringSelection = new StringSelection(GeneratedPassword);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
	
		}
		
		public static void clear()
		{
			
		}
		
	}
}
