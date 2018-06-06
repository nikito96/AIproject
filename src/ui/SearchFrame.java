package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import graph.Graph;
import graph.Node;
import graph.SearchByLength;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private Graph graph = new Graph();
	public static JTextArea resultTextArea;
	
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
		startComboBox.setBounds(104, 19, 96, 20);
		contentPane.add(startComboBox);
		fillCombo(startComboBox);
		
		JComboBox methodComboBox = new JComboBox();
		
		JLabel lblStartingPoint = new JLabel("Starting node:");
		lblStartingPoint.setBounds(10, 22, 95, 14);
		contentPane.add(lblStartingPoint);
		
		JLabel lblFinishNode = new JLabel("Ending node:");
		lblFinishNode.setBounds(210, 22, 104, 14);
		contentPane.add(lblFinishNode);
		
		JComboBox endComboBox = new JComboBox();
		endComboBox.setBounds(303, 19, 110, 20);
		contentPane.add(endComboBox);
		fillCombo(endComboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchByLength sl = new SearchByLength(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString());
				
				switch(methodComboBox.getSelectedItem().toString()) {
					case "Shortest Length": sl.search(startComboBox.getSelectedItem().toString(), endComboBox.getSelectedItem().toString());
					break;
				}
			}
		});
		btnSearch.setBounds(324, 50, 89, 23);
		contentPane.add(btnSearch);
		
		methodComboBox.setBounds(104, 50, 210, 20);
		contentPane.add(methodComboBox);
		methodComboBox.addItem("Greedy Search");
		methodComboBox.addItem("Shortest Length");
		
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setBounds(52, 54, 46, 14);
		contentPane.add(lblMethod);
		
		resultTextArea = new JTextArea();
				
		JScrollPane scrollPane = new JScrollPane(resultTextArea);
		scrollPane.setBounds(10, 89, 414, 162);
		contentPane.add(scrollPane);
		
	}
	
	private void fillCombo(JComboBox jcb) {
		for(Node n : graph.getHashMap().values()) {
			jcb.addItem(n.getName());
		}
	}
}
