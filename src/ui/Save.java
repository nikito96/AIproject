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

public class Save extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField pathTextField;
	private FileSave fileSaver = new FileSave();

	/**
	 * Create the frame.
	 */
	public Save() {
		setTitle("Save");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(10, 72, 86, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		pathTextField = new JTextField();
		pathTextField.setBounds(106, 72, 129, 20);
		contentPane.add(pathTextField);
		pathTextField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileSaver.createFile(pathTextField.getText()+nameTextField.getText());
			}
		});
		btnSave.setBounds(245, 71, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(33, 54, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setBounds(159, 54, 46, 14);
		contentPane.add(lblPath);
	}
}
