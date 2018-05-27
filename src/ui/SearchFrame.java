package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public SearchFrame() {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox startComboBox = new JComboBox();
		startComboBox.setBounds(94, 19, 85, 20);
		contentPane.add(startComboBox);
		
		JLabel lblStartingPoint = new JLabel("Starting node:");
		lblStartingPoint.setBounds(10, 22, 74, 14);
		contentPane.add(lblStartingPoint);
		
		JLabel lblFinishNode = new JLabel("Ending node:");
		lblFinishNode.setBounds(189, 22, 63, 14);
		contentPane.add(lblFinishNode);
		
		JComboBox endComboBox = new JComboBox();
		endComboBox.setBounds(262, 19, 89, 20);
		contentPane.add(endComboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(324, 50, 89, 23);
		contentPane.add(btnSearch);
		
		JComboBox methodComboBox = new JComboBox();
		methodComboBox.setBounds(104, 50, 210, 20);
		contentPane.add(methodComboBox);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setBounds(52, 54, 46, 14);
		contentPane.add(lblMethod);
		
		JTextArea resultTextArea = new JTextArea();
		resultTextArea.setBounds(10, 89, 414, 162);
		contentPane.add(resultTextArea);
	}
}
