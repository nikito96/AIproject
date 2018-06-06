package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField xTextField;
	private JTextField yTextField;
	private JTextField weightTextField;
	private Panel panel = Panel.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setTitle("Graph");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setLocation(10, 101);
		panel.setSize(825, 450);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(46, 20, 86, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 23, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(142, 23, 17, 14);
		contentPane.add(lblX);
		
		xTextField = new JTextField();
		xTextField.setBounds(160, 20, 46, 20);
		contentPane.add(xTextField);
		xTextField.setColumns(10);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(216, 23, 22, 14);
		contentPane.add(lblY);
		
		yTextField = new JTextField();
		yTextField.setBounds(236, 20, 46, 20);
		contentPane.add(yTextField);
		yTextField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(292, 23, 46, 14);
		contentPane.add(lblWeight);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(348, 20, 71, 20);
		contentPane.add(weightTextField);
		weightTextField.setColumns(10);
		
		JButton btnAddNode = new JButton("add Node");
		btnAddNode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.createNode(nameTextField.getText(), Integer.parseInt(xTextField.getText()),
						Integer.parseInt(yTextField.getText()), Integer.parseInt(weightTextField.getText()));
				panel.repaint();
				nameTextField.setText("");
				xTextField.setText("");
				yTextField.setText("");
				weightTextField.setText("");
			}
		});
		btnAddNode.setBounds(441, 19, 89, 23);
		contentPane.add(btnAddNode);
		
		JButton btnAddLink = new JButton("add Link");
		btnAddLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkFrame alf = new LinkFrame();
				alf.setVisible(true);
			}
		});
		btnAddLink.setBounds(540, 19, 89, 23);
		contentPane.add(btnAddLink);
		
		JButton btnSearchPanel = new JButton("Search panel");
		btnSearchPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchFrame sf = new SearchFrame();
				sf.setVisible(true);
			}
		});
		
		btnSearchPanel.setBounds(688, 19, 119, 23);
		contentPane.add(btnSearchPanel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save save = new Save();
				save.setVisible(true);
			}
		});
		btnSave.setBounds(688, 53, 70, 23);
		contentPane.add(btnSave);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Open open = new Open();
				open.setVisible(true);
			}
		});
		btnOpen.setBounds(768, 53, 70, 23);
		contentPane.add(btnOpen);
	}
}
