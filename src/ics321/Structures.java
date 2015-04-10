package ics321;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;


public class Structures extends JPanel {
	private JTextField txtTurret;
	private JTextField txtAttack;
	private JTextField txtArmor;
	private JTextField txtHP;
	private JTextField txtAtkSpd;
	private JTextField txtMgcResist;
	String type, hp, att, attspd, armor, mr;

	/**
	 * Create the panel.
	 */
	public Structures(final Connection connection) {
		setLayout(null);
		
		JLabel lblStructure = new JLabel("Structure:");
		lblStructure.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStructure.setBounds(31, 43, 68, 20);
		add(lblStructure);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String building =  (String)comboBox.getSelectedItem();
				
					if(connection != null) {
						try {
							Statement statement = connection.createStatement();
							

							String qryStatement = "select * from structures where struc_name = '" + building + "'"; 	
							ResultSet result = statement.executeQuery(qryStatement);
							
							result.next();
							type =  result.getString(6);
							att =  result.getString(4);
							armor = result.getString(3);
							hp =  result.getString(7);
							attspd =  result.getString(8);
							mr =  result.getString(5);

							

						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					txtTurret.setText(type);
					txtAttack.setText(att);
					txtArmor.setText(armor);
					txtHP.setText(hp);
					txtAtkSpd.setText(attspd);
					txtMgcResist.setText(mr);

			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"outer_tur", "inner_tur", "inhib_tur", "nexus_tur", "inhib", "nexus", "obelisk"}));
		comboBox.setBounds(109, 43, 125, 25);
		add(comboBox);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(80, 109, 46, 14);
		add(lblType);
		
		JLabel lblHp = new JLabel("HP:");
		lblHp.setBounds(244, 109, 46, 14);
		add(lblHp);
		
		JLabel lblAttak = new JLabel("Attak:");
		lblAttak.setBounds(80, 164, 46, 14);
		add(lblAttak);
		
		JLabel lblAttackSpd = new JLabel("Attack Spd:");
		lblAttackSpd.setBounds(244, 164, 68, 14);
		add(lblAttackSpd);
		
		JLabel lblArmor = new JLabel("Armor:");
		lblArmor.setBounds(80, 225, 46, 14);
		add(lblArmor);
		
		JLabel lblMgcResist = new JLabel("Mgc Resist:");
		lblMgcResist.setBounds(244, 225, 68, 14);
		add(lblMgcResist);
		
		txtTurret = new JTextField();
		txtTurret.setText("turret");
		txtTurret.setBounds(136, 106, 68, 20);
		add(txtTurret);
		txtTurret.setColumns(10);
		
		txtAttack = new JTextField();
		txtAttack.setText("180");
		txtAttack.setColumns(10);
		txtAttack.setBounds(136, 158, 68, 20);
		add(txtAttack);
		
		txtArmor = new JTextField();
		txtArmor.setText("60");
		txtArmor.setColumns(10);
		txtArmor.setBounds(136, 219, 68, 20);
		add(txtArmor);
		
		txtHP = new JTextField();
		txtHP.setText("2550");
		txtHP.setColumns(10);
		txtHP.setBounds(314, 109, 68, 20);
		add(txtHP);
		
		txtAtkSpd = new JTextField();
		txtAtkSpd.setText("1");
		txtAtkSpd.setColumns(10);
		txtAtkSpd.setBounds(314, 158, 68, 20);
		add(txtAtkSpd);
		
		txtMgcResist = new JTextField();
		txtMgcResist.setText("107");
		txtMgcResist.setColumns(10);
		txtMgcResist.setBounds(314, 219, 68, 20);
		add(txtMgcResist);

	}

}
