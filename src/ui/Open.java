package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Open extends JFrame {

	private JPanel contentPane;
	private JTextField namePathTextField;

	/**
	 * Create the frame.
	 */
	public Open() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		namePathTextField = new JTextField();
		namePathTextField.setBounds(10, 53, 224, 20);
		contentPane.add(namePathTextField);
		namePathTextField.setColumns(10);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpen.setBounds(244, 52, 89, 23);
		contentPane.add(btnOpen);
		
		JLabel lblNameAndPath = new JLabel("Name and path of the file:");
		lblNameAndPath.setBounds(49, 26, 171, 14);
		contentPane.add(lblNameAndPath);
	}
}
