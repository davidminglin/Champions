package ics321;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;


@SuppressWarnings({ "serial", "unused" })
public class ChampionVs extends JPanel {
	
	double hp = 0;
	double mana = 0;
	double damage = 0;
	double armor = 0;
	double mgcResist = 0;
	double range = 0;
	double attackSpeed;
	double moveSpeed;
	double hthRegen;
	double manaRegen;
	double hpperlvl;		
	double manaperlvl;
	double hthRegenperlvl;
	double manaRegenperlvl;
	double damageperlvl;
	double attackSpeedperlvl;
	double armorperlvl;
	double mgcResistperlvl;
	double tempVar;
	
	int hp2 = 0;
	int mana2 = 0;
	int damage2 = 0;
	int armor2 = 0;
	int mgcResist2 = 0;
	int range2 = 0;
	double attackSpeed2;
	double moveSpeed2;
	double hthRegen2;
	double manaRegen2;
	double hpperlvl2;		
	double manaperlvl2;
	double hthRegenperlvl2;
	double manaRegenperlvl2;
	double damageperlvl2;
	double attackSpeedperlvl2;
	double armorperlvl2;
	double mgcResistperlvl2;
	
	StringBuilder ch1;
	StringBuilder ch2;
	NumberFormat formatter;
	NumberFormat asformatter;
	
	String champion = "";
	String champion3 = "";
	String champion1 = "Aatrox";
	String champion2 = "Aatrox";
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox1;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JLabel lblWinner1;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ChampionVs(final Connection connection) {
		ch1 = new StringBuilder();
		ch2 = new StringBuilder();
		setLayout(null);
		JLabel lblChampion1 = new JLabel("Champion 1");
		lblChampion1.setBounds(60, 10, 88, 14);
		add(lblChampion1);
		
		JLabel lblChampion2 = new JLabel("Champion 2");
		lblChampion2.setBounds(300, 10, 88, 14);
		add(lblChampion2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(60, 30, 100, 28);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				champion1 = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", "Azir", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr. Mundo", "Draven", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia", "Janna", "Jarvan IV", "Jax", "Jayce", "Jinx", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Kha'Zix", "Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna", "Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zyra"}));
		add(comboBox);
		
		comboBox1 = new JComboBox();
		comboBox1.setBounds(300, 30, 100, 29);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				champion2 = (String) comboBox1.getSelectedItem();
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", "Azir", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr. Mundo", "Draven", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia", "Janna", "Jarvan IV", "Jax", "Jayce", "Jinx", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Kha'Zix", "Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna", "Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zyra"}));
		add(comboBox1);
		
		JButton btnNewButton = new JButton("VS");
		btnNewButton.setBounds(196, 30, 60, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(connection != null) {
					try {
						
						Statement statement = connection.createStatement();
						champion = (String) comboBox.getSelectedItem();
					    PreparedStatement champstat = connection.prepareStatement("select * from champion_stats where Champion_name = ?");
						champstat.setString(1, champion);
						ResultSet champ1 = champstat.executeQuery();
						
						asformatter = new DecimalFormat("#0.000"); 
						
						
						champ1.next();
						hpperlvl = champ1.getDouble(11);		
						manaperlvl = champ1.getDouble(16);
						hthRegenperlvl = champ1.getDouble(13);
						manaRegenperlvl = champ1.getDouble(18);
						damageperlvl = champ1.getDouble(6);
						attackSpeedperlvl = champ1.getDouble(9);
						armorperlvl = champ1.getDouble(4);
						mgcResistperlvl = champ1.getDouble(20);
						hp =  champ1.getInt(10);	
						mana = champ1.getInt(15);
						hthRegen = champ1.getDouble(12);
						manaRegen = champ1.getDouble(17);
						damage = champ1.getInt(5);
						attackSpeed = 0.625/(1 - champ1.getDouble(8));
						armor = champ1.getInt(3);
						mgcResist = champ1.getInt(19);
						moveSpeed = champ1.getDouble(14);
						range = champ1.getInt(7);
						
						champion3 = (String) comboBox1.getSelectedItem();
						
						champstat.setString(1, champion3);
						ResultSet champ2 = champstat.executeQuery();
						
						champ2.next();
						hpperlvl2 = champ2.getDouble(11);		
						manaperlvl2 = champ2.getDouble(16);
						hthRegenperlvl2 = champ2.getDouble(13);
						manaRegenperlvl2 = champ2.getDouble(18);
						damageperlvl2 = champ2.getDouble(6);
						attackSpeedperlvl2 = champ2.getDouble(9);
						armorperlvl2 = champ2.getDouble(4);
						mgcResistperlvl2 = champ2.getDouble(20);
						hp2 =  champ2.getInt(10);	
						mana2 = champ2.getInt(15);
						hthRegen2 = champ2.getDouble(12);
						manaRegen2 = champ2.getDouble(17);
						damage2 = champ2.getInt(5);
						attackSpeed2 = 0.625/(1 - champ2.getDouble(8));
						armor2 = champ2.getInt(3);
						mgcResist2 = champ2.getInt(19);
						moveSpeed2 = champ2.getDouble(14);
						range2 = champ2.getInt(7);
						
						
						ch1.setLength(0);
						ch2.setLength(0);

						
						formatter = new DecimalFormat("#0.0"); 
						

						if(damage > damage2) {
							tempVar = ((1 - (damage2/damage))*100);
							ch1.append("Dmg:             "+damage+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(damage < damage2) {
							tempVar = ((1 - (damage/damage2))*100);
							ch2.append("Dmg:             "+damage2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(hp > hp2) {
							tempVar = ((1 - (hp2/hp))*100);
							ch1.append("Hp:                 "+hp+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(hp < hp2) {
							tempVar = ((1 - (hp/hp2))*100);
							ch2.append("Hp:                 "+hp2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(mana > mana2) {
							tempVar = ((1 - (mana2/mana))*100);
							ch1.append("Mp:                 "+mana+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(mana < mana2) {
							tempVar = ((1 - (mana/mana2))*100);
							ch2.append("Mp:                 "+mana2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(armor > armor2) {
							tempVar = ((1 - (armor2/armor))*100);
							ch1.append("Arm:               "+armor+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(armor < armor2) {
							tempVar = ((1 - (armor/armor2))*100);
							ch2.append("Arm:               "+armor2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(attackSpeed > attackSpeed2) {
							tempVar = ((1 - (attackSpeed2/attackSpeed))*100);
							ch1.append("Atkspd:          "+(asformatter.format(attackSpeed))+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(attackSpeed < attackSpeed2) {
							tempVar = ((1 - (attackSpeed/attackSpeed2))*100);
							ch2.append("Atkspd:          "+(asformatter.format(attackSpeed2))+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(moveSpeed > moveSpeed2) {
							tempVar = ((1 - (moveSpeed2/moveSpeed))*100);
							ch1.append("MvSp:            "+moveSpeed+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(moveSpeed < moveSpeed2) {
							tempVar = ((1 - (moveSpeed/moveSpeed2))*100);
							ch2.append("MvSp:            "+moveSpeed2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(range > range2) {
							tempVar = ((1 - (range2/range))*100);
							ch1.append("Range:          "+range+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(range < range2) {
							tempVar = ((1 - (range/range2))*100);
							ch2.append("Range:          "+range2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(mgcResist > mgcResist2) {
							tempVar = ((1 - (mgcResist2/mgcResist))*100);
							ch1.append("Mres: "+mgcResist+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(mgcResist < mgcResist2) {
							tempVar = ((1 - (mgcResist/mgcResist2))*100);
							ch2.append("Mres: "+mgcResist2+" (+" +(formatter.format(tempVar))+"%) \n");
						}

						if(hthRegen > hthRegen2) {
							tempVar = ((1 - (hthRegen2/hthRegen))*100);
							ch1.append("HpReg:         "+hthRegen+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(hthRegen < hthRegen2) {
							tempVar = ((1 - (hthRegen/hthRegen2))*100);
							ch2.append("HpReg:         "+hthRegen2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(manaRegen > manaRegen2) {
							tempVar = ((1 - (manaRegen2/manaRegen))*100);
							ch1.append("MpReg:         "+manaRegen+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(manaRegen < manaRegen2) {
							tempVar = ((1 - (manaRegen/manaRegen2))*100);
							ch2.append("MpReg:         "+manaRegen2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
								
						if(hpperlvl > hpperlvl2) {
							tempVar = ((1 - (hpperlvl2/hpperlvl))*100);
							ch1.append("Hp/lvl:            "+hpperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(hpperlvl < hpperlvl2) {
							tempVar = ((1 - (hpperlvl/hpperlvl2))*100);
							ch2.append("Hp/lvl:            "+hpperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(manaperlvl > manaperlvl2) {
							tempVar = ((1 - (manaperlvl2/manaperlvl))*100);
							ch1.append("Mp/lvl:            "+manaperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(manaperlvl < manaperlvl2) {
							tempVar = ((1 - (manaperlvl/manaperlvl2))*100);
							ch2.append("Mp/lvl:            "+manaperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(hthRegenperlvl > hthRegenperlvl2) {
							tempVar = ((1 - (hthRegenperlvl2/hthRegenperlvl))*100);
							ch1.append("HpReg/lvl:    "+hthRegenperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(hthRegenperlvl < hthRegenperlvl2) {
							tempVar = ((1 - (hthRegenperlvl/hthRegenperlvl2))*100);
							ch2.append("HpReg/lvl:    "+hthRegenperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(manaRegenperlvl > manaRegenperlvl2) {
							tempVar = ((1 - (manaRegenperlvl2/manaRegenperlvl))*100);
							ch1.append("MpReg/lvl:    "+manaRegenperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(manaRegenperlvl < manaRegenperlvl2) {
							tempVar = ((1 - (manaRegenperlvl/manaRegenperlvl2))*100);
							ch2.append("MpReg/lvl:    "+manaRegenperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(damageperlvl > damageperlvl2) {
							tempVar = ((1 - (damageperlvl2/damageperlvl))*100);
							ch1.append("Dmg/lvl:        "+damageperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(damageperlvl < damageperlvl2) {
							tempVar = ((1 - (damageperlvl/damageperlvl2))*100);
							ch2.append("Dmg/lvl:        "+damageperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(attackSpeedperlvl > attackSpeedperlvl2) {
							tempVar = ((1 - (attackSpeedperlvl2/attackSpeedperlvl))*100);
							ch1.append("As/lvl:            "+attackSpeedperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(attackSpeedperlvl < attackSpeedperlvl2) {
							tempVar = ((1 - (attackSpeedperlvl/attackSpeedperlvl2))*100);
							ch2.append("As/lvl:            "+attackSpeedperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(armorperlvl > armorperlvl2) {
							tempVar = ((1 - (armorperlvl2/armorperlvl))*100);
							ch1.append("Arm/lvl:          "+armorperlvl+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						else if(armorperlvl < armorperlvl2) {
							tempVar = ((1 - (armorperlvl/armorperlvl2))*100);
							ch2.append("Arm/lvl:          "+armorperlvl2+" (+" +(formatter.format(tempVar))+"%) \n");
						}
						
						if(mgcResistperlvl > mgcResistperlvl2) {
							tempVar = ((1 - (mgcResistperlvl2/mgcResistperlvl))*100);
							ch1.append("Mres/lvl:        "+mgcResistperlvl+" (+" +(formatter.format(tempVar))+"%)");
						}
						else if(mgcResistperlvl < mgcResistperlvl2) {
							tempVar = ((1 - (mgcResistperlvl/mgcResistperlvl2))*100);
							ch2.append("Mres/lvl:        "+mgcResistperlvl2+" (+" +(formatter.format(tempVar))+"%)");
						}
							
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					if(ch1.toString().equals(ch2.toString())) {
						ch1.append("Draw");
						ch2.append("Draw");
					}
						
					textArea.setText(ch1.toString());
					textArea1.setText(ch2.toString());
					
				}
			}
		});
		add(btnNewButton);
		
		JLabel lblWinner = new JLabel("");
		lblWinner.setBounds(171, 145, 60, 23);
		lblWinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblWinner);
		
		lblWinner1 = new JLabel("");
		lblWinner1.setBounds(241, 145, 68, 23);
		lblWinner1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblWinner1);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 70, 180, 360);
		add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(260, 70, 180, 360);
		add(textArea1);

	}
}
