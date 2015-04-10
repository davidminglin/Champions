package ics321;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class ChampionInfo extends JPanel {

	String champion = "";
	String rp = "";
	String ip = "";
	String win = "";
	String ban = "";
	String pop = "";
	String release = "";
	String role = "";
	private JTextField lblRPCostData;
	private JTextField lblIPCostData;
	private JTextField lblWinRateData;
	private JTextField lblBanRateData;
	private JTextField lblPopularityData;
	private JTextField lblRoleData;
	private JTextField lblReleasedData;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ChampionInfo(Connection conn) {
		final Connection connection = conn;
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", "Azir", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr. Mundo", "Draven", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia", "Janna", "Jarvan IV", "Jax", "Jayce", "Jinx", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Kha'Zix", "Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna", "Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zyra"}));
		comboBox.setMaximumRowCount(10);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				champion = (String) comboBox.getSelectedItem();
				if(connection != null) {
					try {
						PreparedStatement statement = connection.prepareStatement("select * from champion_info where champion = '" + champion + "'");
						ResultSet result = statement.executeQuery();
						result.next();
						rp = result.getString(2);
						ip = result.getString(3);
						win = result.getString(5) + " %";
						ban = result.getString(6) + " %";
						pop = result.getString(4) + " %";
						release = result.getString(8);
						role = result.getString(7);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					rp = "";
					ip = "";
					win = " %";
					ban = " %";
					pop = " %";
					release = "";
					role = "";
				}
				
				lblRPCostData.setText(rp);
				lblIPCostData.setText(ip);
				lblWinRateData.setText(win);
				lblBanRateData.setText(ban);
				lblPopularityData.setText(pop);
				lblReleasedData.setText(release);
				lblRoleData.setText(role);
			}
		});
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 23, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 104, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 56, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 220, SpringLayout.WEST, this);
		setLayout(springLayout);
		add(comboBox);
		
		JLabel lblCh = new JLabel("Champion:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCh, 22, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCh, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCh, 55, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblCh, 129, SpringLayout.WEST, this);
		lblCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblCh);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 95, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 299, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 409, SpringLayout.WEST, this);
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblRPCost = new JLabel("RP Cost:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRPCost, 25, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblRPCost, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblRPCost, 45, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblRPCost, 87, SpringLayout.WEST, panel);
		panel.add(lblRPCost);
		
		lblRPCostData = new JTextField("975");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRPCostData, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblRPCostData, 107, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblRPCostData, 48, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblRPCostData, 183, SpringLayout.WEST, panel);
		panel.add(lblRPCostData);
		
		JLabel lblIpCost = new JLabel("IP Cost:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblIpCost, 25, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblIpCost, 226, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblIpCost, 51, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblIpCost, 282, SpringLayout.WEST, panel);
		panel.add(lblIpCost);
		
		lblIPCostData = new JTextField("6300");
		sl_panel.putConstraint(SpringLayout.NORTH, lblIPCostData, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblIPCostData, 290, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblIPCostData, 48, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblIPCostData, 366, SpringLayout.WEST, panel);
		panel.add(lblIPCostData);
		
		JLabel lblPopularity = new JLabel("Win Rate:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblPopularity, 70, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblPopularity, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPopularity, 90, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPopularity, 97, SpringLayout.WEST, panel);
		panel.add(lblPopularity);
		
		lblWinRateData = new JTextField("48.17 %");
		sl_panel.putConstraint(SpringLayout.NORTH, lblWinRateData, 67, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblWinRateData, 107, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblWinRateData, 93, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblWinRateData, 183, SpringLayout.WEST, panel);
		panel.add(lblWinRateData);
		
		JLabel lblNewLabel_1 = new JLabel("Ban Rate:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 70, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 226, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 96, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 288, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);
		
		lblBanRateData = new JTextField("0.31 %");
		sl_panel.putConstraint(SpringLayout.NORTH, lblBanRateData, 67, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblBanRateData, 290, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblBanRateData, 93, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblBanRateData, 366, SpringLayout.WEST, panel);
		panel.add(lblBanRateData);
		
		JLabel lblBanRate = new JLabel("Popularity:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblBanRate, 115, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblBanRate, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblBanRate, 138, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblBanRate, 97, SpringLayout.WEST, panel);
		panel.add(lblBanRate);
		
		lblPopularityData = new JTextField("2.29 %");
		sl_panel.putConstraint(SpringLayout.NORTH, lblPopularityData, 112, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblPopularityData, 107, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPopularityData, 138, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblPopularityData, 183, SpringLayout.WEST, panel);
		panel.add(lblPopularityData);
		
		JLabel lblRole = new JLabel("Role:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRole, 115, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblRole, 226, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblRole, 141, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblRole, 282, SpringLayout.WEST, panel);
		panel.add(lblRole);
		
		lblRoleData = new JTextField("Top Lane");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRoleData, 113, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblRoleData, 290, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblRoleData, 139, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblRoleData, 366, SpringLayout.WEST, panel);
		panel.add(lblRoleData);
		
		JLabel lblReleased = new JLabel("Released:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblReleased, 154, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblReleased, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblReleased, 180, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblReleased, 97, SpringLayout.WEST, panel);
		panel.add(lblReleased);
		
		lblReleasedData = new JTextField("6/13/2013");
		sl_panel.putConstraint(SpringLayout.NORTH, lblReleasedData, 153, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblReleasedData, 107, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblReleasedData, 181, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblReleasedData, 183, SpringLayout.WEST, panel);
		panel.add(lblReleasedData);
		
		JLabel lblInfo = new JLabel("Info:");
		springLayout.putConstraint(SpringLayout.NORTH, lblInfo, 66, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblInfo, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblInfo, 90, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblInfo, 82, SpringLayout.WEST, this);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblInfo);
		
	}
}
