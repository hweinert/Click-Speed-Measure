import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainFrame extends JFrame {
	
	private ClickSpeedMeter meter = new ClickSpeedMeter();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Click Speed Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cpsLabel = new JLabel("Clicks per Second: ");
		cpsLabel.setBounds(10, 72, 115, 14);
		contentPane.add(cpsLabel);
		
		JLabel secondsPastLabel = new JLabel("Seconds past:");
		secondsPastLabel.setBounds(10, 97, 115, 14);
		contentPane.add(secondsPastLabel);
		
		JLabel clicksLabel = new JLabel("Clicks:");
		clicksLabel.setBounds(10, 122, 115, 14);
		contentPane.add(clicksLabel);
		
		JLabel cpsNumLabel = new JLabel("0.00");
		cpsNumLabel.setBounds(152, 72, 46, 14);
		contentPane.add(cpsNumLabel);
		
		JLabel secondsPastNumLabel = new JLabel("0.00");
		secondsPastNumLabel.setBounds(152, 97, 46, 14);
		contentPane.add(secondsPastNumLabel);
		
		JLabel clicksNumLabel = new JLabel("0");
		clicksNumLabel.setBounds(152, 122, 46, 14);
		contentPane.add(clicksNumLabel);
		
		JButton clickButton = new JButton("Click me!");
		clickButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clickButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meter.countClick();
				
				double clicksPerSecond = meter.calculateNumOfClicksPerSecond();
				double secondsBygone = meter.calculateSecondsBygone();
				int numOfClicks = meter.getNumOfClicks();
				
				DecimalFormat formatter = new DecimalFormat("0.00");
				cpsNumLabel.setText(formatter.format(clicksPerSecond));
				secondsPastNumLabel.setText(formatter.format(secondsBygone));
				clicksNumLabel.setText(numOfClicks + "");
				
			}
		});
		clickButton.setBounds(10, 11, 115, 50);
		contentPane.add(clickButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meter = new ClickSpeedMeter();
				cpsNumLabel.setText("0.00");
				secondsPastNumLabel.setText("0.00");
				clicksNumLabel.setText("0");				
			}
		});
		resetButton.setBounds(152, 11, 115, 50);
		contentPane.add(resetButton);
	}
}
