package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graph.Graph;
import graph.LinkType;
import graph.Node;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LinkFrame extends JFrame {

	private JPanel contentPane;
	private JTextField lenghtTextField;
	private Graph graph = new Graph();
	private LinkType lt;
	private Panel panel = Panel.getInstance();
	
	/**
	 * Create the frame.
	 */
	public LinkFrame() {
		setTitle("Add link");
		setDefaultCloseOperation(LinkFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox fromComboBox = new JComboBox();
		fromComboBox.setBounds(80, 51, 89, 20);
		fillCombo(fromComboBox);
		contentPane.add(fromComboBox);
		
		JComboBox toComboBox = new JComboBox();
		toComboBox.setBounds(231, 51, 89, 20);
		fillCombo(toComboBox);
		contentPane.add(toComboBox);
		
		JLabel lblLength = new JLabel("Length:");
		lblLength.setBounds(140, 100, 46, 14);
		contentPane.add(lblLength);
		
		lenghtTextField = new JTextField();
		lenghtTextField.setBounds(196, 97, 118, 20);
		contentPane.add(lenghtTextField);
		lenghtTextField.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(140, 135, 46, 14);
		contentPane.add(lblType);
		
		JComboBox typeComboBox = new JComboBox();
		typeComboBox.setBounds(196, 132, 118, 20);
		contentPane.add(typeComboBox);
		
		for(LinkType item : lt.values()) {
			typeComboBox.addItem(item);
		}
		
		JCheckBox chckbxTwoWay = new JCheckBox("Two way");
		chckbxTwoWay.setBounds(331, 51, 97, 23);
		contentPane.add(chckbxTwoWay);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				graph.addTwoWayRoute(graph.getHashMap().get(fromComboBox.getSelectedItem()), graph.getHashMap().get(toComboBox.getSelectedItem()),
						Double.parseDouble(lenghtTextField.getText()), (LinkType) typeComboBox.getSelectedItem(), chckbxTwoWay.isSelected());
				panel.repaint();
			}
		});
		btnAdd.setBounds(168, 206, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(33, 54, 37, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(196, 54, 25, 14);
		contentPane.add(lblTo);
	}
	
	private void fillCombo(JComboBox jcb){
		for(Node item : graph.getHashMap().values()) {
			jcb.addItem(item.getName());
		}
	}
}
