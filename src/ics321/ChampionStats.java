package ics321;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@SuppressWarnings("serial")
public class ChampionStats extends JPanel {

	long start = 0;
	long end = 0;
	String champion = "Aatrox";
	String hp = "";
	String mana = "";
	String hthRegen = "";
	String manaRegen = "";
	String damage = "";
	String attackSpeed = "";
	String armor = "";
	String mgcResist = "";
	String moveSpeed = "";
	String range = "";
	String level = "1";
	float hpperlvl;		
	float manaperlvl;
	float hthRegenperlvl;
	float manaRegenperlvl;
	float damageperlvl;
	float attackSpeedperlvl;
	float armorperlvl;
	float mgcResistperlvl;
	private JTextField lblHPData;
	private JTextField lblManaData;
	private JTextField lblHlthRegenData;
	private JTextField lblManaRegenData;
	private JTextField lblDmgData;
	private JTextField lblAtkSpdData;
	private JTextField lblArmorData;
	private JTextField lblMgcResistData;
	private JTextField lblMoveSpdData;
	private JTextField lblRangeData;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ChampionStats(final Connection connection) {
		setLayout(null);
		
		comboBox = new JComboBox();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(connection != null) {
					try {
						start = System.nanoTime();
						Statement statement = connection.createStatement();
						champion = (String) comboBox.getSelectedItem();
						String qryStatement = "select * from champion_stats where Champion_name = '" + champion + "'"; 	//added champion name
						ResultSet result = statement.executeQuery(qryStatement);
						float lvl = Float.parseFloat(level); 
						
						result.next();
						 hpperlvl =  lvl * Float.parseFloat(result.getString(11));		
						 manaperlvl = lvl * Float.parseFloat(result.getString(16));
						 hthRegenperlvl = lvl * Float.parseFloat(result.getString(13));
						 manaRegenperlvl = lvl * Float.parseFloat(result.getString(18));
						 damageperlvl = lvl * Float.parseFloat(result.getString(6));
						 attackSpeedperlvl = lvl * Float.parseFloat(result.getString(9));
						 armorperlvl = lvl * Float.parseFloat(result.getString(4));
						 mgcResistperlvl = lvl * Float.parseFloat(result.getString(20));
						hp =  String.format("%.2f", (hpperlvl + Float.parseFloat(result.getString(10))));		
						mana = String.format("%.2f", (manaperlvl + Float.parseFloat(result.getString(15))));
						hthRegen = String.format("%.2f", (hthRegenperlvl + Float.parseFloat(result.getString(12))));
						manaRegen = String.format("%.2f", (manaRegenperlvl + Float.parseFloat(result.getString(17))));
						damage = String.format("%.2f", (damageperlvl + Float.parseFloat(result.getString(5))));
						attackSpeed = String.format("%.2f", ((.625/(Float.parseFloat(result.getString(8)) + 1))*(attackSpeedperlvl/100 + 1)));
						armor = String.format("%.2f", (armorperlvl + Float.parseFloat(result.getString(3))));
						mgcResist = String.format("%.2f", (mgcResistperlvl + Float.parseFloat(result.getString(19))));
						moveSpeed = result.getString(14);
						range = result.getString(7);
						end = System.nanoTime();
						System.out.println("Time for Champion: " + (end - start)/1000000  + " msecs");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}


				
				lblHPData.setText(hp);
				lblManaData.setText(mana);
				lblHlthRegenData.setText(hthRegen);
				lblManaRegenData.setText(manaRegen);
				lblDmgData.setText(damage);
				lblAtkSpdData.setText(attackSpeed);
				lblArmorData.setText(armor);
				lblMgcResistData.setText(mgcResist);
				lblMoveSpdData.setText(moveSpeed);
				lblRangeData.setText(range);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", "Azir", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Cassiopeia", "Chogath", "Corki", "Darius", "Diana", "DrMundo", "Draven", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia", "Janna", "Jarvan IV", "Jax", "Jayce", "Jinx", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Kha'Zix", "Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna", "Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "VelKoz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xerath", "XinZhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zyra"}));
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(104, 23, 116, 33);
		add(comboBox);
		
		JLabel lblChampion = new JLabel("Champion:");
		lblChampion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChampion.setBounds(20, 22, 109, 33);
		add(lblChampion);
		
		JLabel lblStats = new JLabel("Stats:");
		lblStats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStats.setBounds(20, 66, 62, 24);
		add(lblStats);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 95, 402, 204);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Health:");
		lblNewLabel.setBounds(31, 6, 78, 20);
		panel.add(lblNewLabel);
		
		lblHPData = new JTextField ("480.00");
		lblHPData.setBounds(119, 6, 69, 20);
		panel.add(lblHPData);
		
		JLabel lblMana = new JLabel("Mana:");
		lblMana.setBounds(231, 6, 64, 20);
		panel.add(lblMana);
		
		lblManaData = new JTextField ("75.00");
		lblManaData.setBounds(323, 6, 69, 20);
		panel.add(lblManaData);
		
		JLabel lblHlthRegen = new JLabel("Hlth Regen:");
		lblHlthRegen.setBounds(31, 45, 78, 20);
		panel.add(lblHlthRegen);
		
		lblHlthRegenData = new JTextField ("6.25");
		lblHlthRegenData.setBounds(119, 45, 69, 20);
		panel.add(lblHlthRegenData);
		
		JLabel lblMnaRegen = new JLabel("Mana Regen:");
		lblMnaRegen.setBounds(231, 45, 85, 20);
		panel.add(lblMnaRegen);
		
		lblManaRegenData = new JTextField ("0.00");
		lblManaRegenData.setBounds(323, 45, 69, 20);
		panel.add(lblManaRegenData);
		
		JLabel lblDmg = new JLabel("Dmg:");
		lblDmg.setBounds(31, 90, 57, 20);
		panel.add(lblDmg);
		
		lblDmgData = new JTextField ("58.20");
		lblDmgData.setBounds(119, 90, 69, 20);
		panel.add(lblDmgData);
		
		JLabel lblAtkSpd = new JLabel("Atk Spd:");
		lblAtkSpd.setBounds(231, 90, 64, 20);
		panel.add(lblAtkSpd);
		
		lblAtkSpdData = new JTextField ("0.67");
		lblAtkSpdData.setBounds(323, 90, 69, 20);
		panel.add(lblAtkSpdData);
		
		JLabel lblArmor = new JLabel("Armor:");
		lblArmor.setBounds(31, 135, 57, 20);
		panel.add(lblArmor);
		
		lblArmorData = new JTextField ("21.80");
		lblArmorData.setBounds(119, 135, 69, 20);
		panel.add(lblArmorData);
		
		JLabel lblMgcRst = new JLabel("Mgc Resist:");
		lblMgcRst.setBounds(231, 135, 85, 20);
		panel.add(lblMgcRst);
		
		lblMgcResistData = new JTextField ("31.25");
		lblMgcResistData.setBounds(323, 135, 69, 20);
		panel.add(lblMgcResistData);
		
		JLabel lblMoveSpd = new JLabel("Move Spd:");
		lblMoveSpd.setBounds(31, 173, 78, 27);
		panel.add(lblMoveSpd);
		
		lblMoveSpdData = new JTextField ("345");
		lblMoveSpdData.setBounds(119, 180, 69, 20);
		panel.add(lblMoveSpdData);
		
		JLabel lblRange = new JLabel("Range:");
		lblRange.setBounds(231, 180, 64, 20);
		panel.add(lblRange);
		
		lblRangeData = new JTextField ("150");
		lblRangeData.setBounds(323, 180, 69, 20);
		panel.add(lblRangeData);
		
		final JComboBox comboBoxLevel = new JComboBox();
		comboBoxLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(connection != null) {
					try {
						start = System.nanoTime();
						level = (String) comboBoxLevel.getSelectedItem();
						Statement statement = connection.createStatement();
						float lvl = Float.parseFloat(level); 
						String qryStatement = "select * from champion_stats where Champion_name = '" + champion + "'"; 	//added champion name
						ResultSet result = statement.executeQuery(qryStatement);
						
						result.next();
						 hpperlvl =  lvl * Float.parseFloat(result.getString(11));		
						 manaperlvl = lvl * Float.parseFloat(result.getString(16));
						 hthRegenperlvl = lvl * Float.parseFloat(result.getString(13));
						 manaRegenperlvl = lvl * Float.parseFloat(result.getString(18));
						 damageperlvl = lvl * Float.parseFloat(result.getString(6));
						 attackSpeedperlvl = lvl * Float.parseFloat(result.getString(9));
						 armorperlvl = lvl * Float.parseFloat(result.getString(4));
						 mgcResistperlvl = lvl * Float.parseFloat(result.getString(20));
						 
							hp =  String.format("%.2f", (hpperlvl + Float.parseFloat(result.getString(10))));		
							mana = String.format("%.2f", (manaperlvl + Float.parseFloat(result.getString(15))));
							hthRegen = String.format("%.2f", (hthRegenperlvl + Float.parseFloat(result.getString(12))));
							manaRegen = String.format("%.2f", (manaRegenperlvl + Float.parseFloat(result.getString(17))));
							damage = String.format("%.2f", (damageperlvl + Float.parseFloat(result.getString(5))));
							attackSpeed = String.format("%.2f", ((.625/(Float.parseFloat(result.getString(8)) + 1))*(attackSpeedperlvl/100 + 1)));
							armor = String.format("%.2f", (armorperlvl + Float.parseFloat(result.getString(3))));
							mgcResist = String.format("%.2f", (mgcResistperlvl + Float.parseFloat(result.getString(19))));
							
							lblHPData.setText(hp);
							lblManaData.setText(mana);
							lblHlthRegenData.setText(hthRegen);
							lblManaRegenData.setText(manaRegen);
							lblDmgData.setText(damage);
							lblAtkSpdData.setText(attackSpeed);
							lblArmorData.setText(armor);
							lblMgcResistData.setText(mgcResist);
							
							end = System.nanoTime();
							System.out.println("Time for Level: " + (end - start)/1000000  + " msecs");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			}
		});
		comboBoxLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));
		comboBoxLevel.setBounds(357, 24, 52, 33);
		add(comboBoxLevel);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevel.setBounds(300, 26, 52, 24);
		add(lblLevel);
		
	}
}
