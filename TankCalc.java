// Nastassja Motro 9/11/17

// Import Layout, Listeners and Controls
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

// Class Name
public class TankCalc {
	// Controls for App
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JPanel buttonPanel;
	private JButton calculate;
	
	private JTextField ouncesEntry, yearsEntry;
		
	// Constructor
	public TankCalc() {
			prepareGUI();
	}
		
	// Entry Point
	public static void main(String[] args) {
		TankCalc swingTankCalc = new TankCalc();
		swingTankCalc.showTextField();
	}
		
	// Setup the GUI Environment
	private void prepareGUI() {
		// Setup App Frame
		mainFrame = new JFrame("Tanker Truck Calc");
		mainFrame.setSize(600, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonPanel = new JPanel();
		
		// Setup Labels
		headerLabel = new JLabel("Welcome to your very own Tanker Truck Calculator of sorts", JLabel.CENTER);
		statusLabel = new JLabel("By Nastassja Motro    4A", JLabel.CENTER);
		statusLabel.setSize(150, 150);
		ouncesEntry = new JTextField(4);
		yearsEntry = new JTextField(4);
		JLabel ounceText = new JLabel("Ounces drank per day:");
		
		JLabel yearsText = new JLabel("Estimated Lifespan:");
		
			
		// Setup Layout
		mainFrame.setLayout(new GridLayout(4, 1));
		calculate = new JButton("calculate");

		// Add Interactables
		controlPanel = new JPanel();
		controlPanel.add(ounceText);
		controlPanel.add(ouncesEntry);
		controlPanel.add(yearsText);
		controlPanel.add(yearsEntry);
		buttonPanel.add(calculate);
		
		
		
	}
		
	// Display Controls
	private void showTextField() {
		// Set Values for Controls
			
		// Action Listener for Button Click
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				float ounces = (float) Float.valueOf(ouncesEntry.getText());
				float years = (float) Float.valueOf(yearsEntry.getText());
				ounces *= 365;
				ounces *= years;
				ounces /= 128;
				ounces /= 11000;
				statusLabel.setText("So you will drink approximately " + ounces + " 11,000 gallon tankers of water. Congrats!");
				mainFrame.setVisible(true);
			}
		});
			
		// Place Controls on Panels
		
		// Don't Forget to Set Visibility
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(buttonPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
}

