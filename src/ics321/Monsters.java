package ics321;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Monsters extends JPanel {
	private JTextField txtGold;
	private JTextField txtHP;
	private JTextField txtAttk;
	private JTextField txtAP;
	private JTextField txtEXP;
	private JTextField txtArmor;
	private JTextField txtAS;
	private JTextField txtMR;
	float gold, hp, attack, ap, exp, armor, attspd, mr;
	int time;
	String Minion;

	/**
	 * Create the panel.
	 */
	public Monsters(final Connection connection) {
		setLayout(null);
		
		final JComboBox comboBox_Monsters = new JComboBox();
		comboBox_Monsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(connection != null) {
					try {
						Statement statement = connection.createStatement();
						 Minion = (String) comboBox_Monsters.getSelectedItem();

						String qryStatement = "select * from monsters where mon_name = '" + Minion + "' AND time = " + time; 	
						ResultSet result = statement.executeQuery(qryStatement);
						
						result.next();
						gold =  Float.parseFloat(result.getString(3));
						hp =  Float.parseFloat(result.getString(5));
						attack =  Float.parseFloat(result.getString(8));
						ap =  Float.parseFloat(result.getString(9));
						exp =  Float.parseFloat(result.getString(4));
						armor =  Float.parseFloat(result.getString(6));
						attspd =  Float.parseFloat(result.getString(10));
						mr =  Float.parseFloat(result.getString(7));
						

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				txtGold.setText(Float.toString(gold));
				txtHP.setText(Float.toString(hp));
				txtAttk.setText(Float.toString(attack));
				txtAP.setText(Float.toString(ap));
				txtEXP.setText(Float.toString(exp));
				txtArmor.setText(Float.toString(armor));
				txtAS.setText(Float.toString(attspd));
				txtMR.setText(Float.toString(mr));
			}
		});
		comboBox_Monsters.setModel(new DefaultComboBoxModel(new String[] {"min_melee", "min_caster", "min_siege", "min_super", "wraith_camp", "wolf_camp", "blue_camp", "wight_camp", "golem_camp", "dragon_pit", "baron_pit"}));
		comboBox_Monsters.setBounds(89, 43, 125, 25);
		add(comboBox_Monsters);
		
		JLabel lblMinion = new JLabel("Minion:");
		lblMinion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinion.setBounds(31, 43, 68, 20);
		add(lblMinion);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTime.setBounds(284, 43, 68, 20);
		add(lblTime);
		
		final JComboBox comboTime = new JComboBox();
		comboTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 time =  Integer.parseInt((String)comboTime.getSelectedItem());
				
					if(connection != null) {
						try {
							Statement statement = connection.createStatement();
							

							String qryStatement = "select * from monsters where mon_name = '" + Minion + "' AND time = " + time; 	
							ResultSet result = statement.executeQuery(qryStatement);
							
							result.next();
							gold =  Float.parseFloat(result.getString(3));
							hp =  Float.parseFloat(result.getString(5));
							attack =  Float.parseFloat(result.getString(8));
							ap =  Float.parseFloat(result.getString(9));
							exp =  Float.parseFloat(result.getString(4));
							armor =  Float.parseFloat(result.getString(6));
							attspd =  Float.parseFloat(result.getString(10));
							mr =  Float.parseFloat(result.getString(7));
							
							
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				 
					txtGold.setText(Float.toString(gold));
					txtHP.setText(Float.toString(hp));
					txtAttk.setText(Float.toString(attack));
					txtAP.setText(Float.toString(ap));
					txtEXP.setText(Float.toString(exp));
					txtArmor.setText(Float.toString(armor));
					txtAS.setText(Float.toString(attspd));
					txtMR.setText(Float.toString(mr));
			}
		});
		comboTime.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "30", "40", "50", "60"}));
		comboTime.setBounds(331, 43, 75, 25);
		add(comboTime);
		
		JLabel lblGold = new JLabel("Gold:");
		lblGold.setBounds(53, 115, 46, 14);
		add(lblGold);
		
		JLabel lblExp = new JLabel("Exp:");
		lblExp.setBounds(253, 115, 46, 14);
		add(lblExp);
		
		JLabel lblHP = new JLabel("HP:");
		lblHP.setBounds(53, 154, 46, 14);
		add(lblHP);
		
		JLabel lblArmor = new JLabel("Armor:");
		lblArmor.setBounds(253, 154, 46, 14);
		add(lblArmor);
		
		JLabel lblMgcResist = new JLabel("Mgc Resist:");
		lblMgcResist.setBounds(253, 230, 75, 14);
		add(lblMgcResist);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(53, 192, 46, 14);
		add(lblAttack);
		
		JLabel lblAttackSpeed = new JLabel("Attack Speed:");
		lblAttackSpeed.setBounds(253, 192, 75, 14);
		add(lblAttackSpeed);
		
		JLabel lblAp = new JLabel("AP:");
		lblAp.setBounds(53, 230, 46, 14);
		add(lblAp);
		
		txtGold = new JTextField();
		txtGold.setText("19.0");
		txtGold.setBounds(116, 112, 68, 17);
		add(txtGold);
		txtGold.setColumns(10);
		
		txtHP = new JTextField();
		txtHP.setText("455.0");
		txtHP.setColumns(10);
		txtHP.setBounds(116, 151, 68, 17);
		add(txtHP);
		
		txtAttk = new JTextField();
		txtAttk.setText("12.0");
		txtAttk.setColumns(10);
		txtAttk.setBounds(116, 192, 68, 17);
		add(txtAttk);
		
		txtAP = new JTextField();
		txtAP.setText("0.0");
		txtAP.setColumns(10);
		txtAP.setBounds(116, 227, 68, 17);
		add(txtAP);
		
		txtEXP = new JTextField();
		txtEXP.setText("58.88");
		txtEXP.setColumns(10);
		txtEXP.setBounds(338, 115, 68, 17);
		add(txtEXP);
		
		txtArmor = new JTextField();
		txtArmor.setText("0.0");
		txtArmor.setColumns(10);
		txtArmor.setBounds(338, 154, 68, 17);
		add(txtArmor);
		
		txtAS = new JTextField();
		txtAS.setText("1.25");
		txtAS.setColumns(10);
		txtAS.setBounds(338, 192, 68, 17);
		add(txtAS);
		
		txtMR = new JTextField();
		txtMR.setText("0.0");
		txtMR.setColumns(10);
		txtMR.setBounds(338, 227, 68, 17);
		add(txtMR);

	}
}
