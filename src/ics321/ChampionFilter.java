package ics321;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class ChampionFilter extends JPanel {

	String filter = "";
	boolean role = false;
	boolean sort = false;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextArea text;
	private String textBox;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ChampionFilter(final Connection connection) {
		JLabel lblView = new JLabel("View:");
		lblView.setBounds(23, 23, 47, 31);
		lblView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox = new JComboBox();
		comboBox.setBounds(69, 29, 108, 22);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getResult(connection);
				text.setText(textBox);
				text.setCaretPosition(0);
			}

		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HP", "HP+", "HP5", "HP5+", "MP", "MP+", "MP5", "MP5+", 
				"AD", "AD+", "AS", "AS+", "AR", "AR+", "MR", "MR+", "MS", "Range", "RP Cost", "IP Cost", "Popularity", "Win Rate", "Ban Rate"}));
		
		
		JButton btnNewButton = new JButton("Role");
		btnNewButton.setBounds(216, 28, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					role = !role;
					getResult(connection);
					text.setText(textBox);
					text.setCaretPosition(0);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Sort");
		btnNewButton_1.setBounds(334, 29, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					sort = !sort;
					getResult(connection);
					text.setText(textBox);
					text.setCaretPosition(0);
			}
		});
			
		text = new JTextArea("Aatrox\tTop Lane\t395\r\nAhri\tMiddle Lane\t380\r\nAkali\tMiddle Lane\t445\r\nAlistar\tSupport\t442\r\nAmumu\tJungler\t472\r\nAnivia\tMiddle Lane\t350\r\nAnnie\tSupport\t384\r\nAshe\tAD Carry\t395\r\nAzir\tMiddle Lane\t390\r\nBlitzcrank\tSupport\t423\r\nBrand\tMiddle Lane\t380\r\nBraum\tSupport\t430\r\nCaitlyn\tAD Carry\t390\r\nCassiopeia\tMiddle Lane\t380\r\nCorki\tAD Carry\t375\r\nDarius\tTop Lane\t426\r\nDiana\tMiddle Lane\t438\r\nDraven\tAD Carry\t420\r\nElise\tJungler\t395\r\nEvelynn\tJungler\t380\r\nEzreal\tAD Carry\t350\r\nFiddleSticks\tSupport\t390\r\nFiora\tTop Lane\t450\r\nFizz\tMiddle Lane\t414\r\nGalio\tMiddle Lane\t435\r\nGangplank\tTop Lane\t495\r\nGaren\tTop Lane\t455\r\nGnar\tTop Lane\t430\r\nGragas\tMiddle Lane\t434\r\nGraves\tAD Carry\t410\r\nHecarim\tJungler\t440\r\nHeimerdinger\tMiddle Lane\t350\r\nIrelia\tTop Lane\t456\r\nJanna\tSupport\t356\r\nJax\tTop Lane\t450\r\nJayce\tTop Lane\t420\r\nJinx\tAD Carry\t380\r\nKarma\tSupport\t383\r\nKarthus\tMiddle Lane\t390\r\nKassadin\tMiddle Lane\t433\r\nKatarina\tMiddle Lane\t425\r\nKayle\tMiddle Lane\t418\r\nKennen\tMiddle Lane\t403\r\nLeblanc\tMiddle Lane\t390\r\nLeona\tSupport\t430\r\nLissandra\tMiddle Lane\t365\r\nLucian\tAD Carry\t420\r\nLulu\tSupport\t415\r\nLux\tMiddle Lane\t345\r\nMalphite\tTop Lane\t423\r\nMalzahar\tMiddle Lane\t380\r\nMaokai\tJungler\t421\r\nMordekaiser\tTop Lane\t421\r\nMorgana\tMiddle Lane\t403\r\nNami\tSupport\t365\r\nNasus\tJungler\t410\r\nNautilus\tJungler\t432\r\nNidalee\tTop Lane\t390\r\nNocturne\tJungler\t440\r\nNunu\tJungler\t437\r\nOlaf\tJungler\t441\r\nOrianna\tMiddle Lane\t385\r\nPantheon\tMiddle Lane\t433\r\nPoppy\tTop Lane\t423\r\nQuinn\tAD Carry\t390\r\nRammus\tJungler\t420\r\nRenekton\tTop Lane\t426\r\nRengar\tTop Lane\t435\r\nRiven\tTop Lane\t414\r\nRumble\tTop Lane\t450\r\nRyze\tMiddle Lane\t414\r\nSejuani\tJungler\t440\r\nShaco\tJungler\t441\r\nShen\tTop Lane\t428\r\nShyvana\tTop Lane\t435\r\nSinged\tTop Lane\t405\r\nSion\tMiddle Lane\t420\r\nSivir\tAD Carry\t378\r\nSkarner\tJungler\t440\r\nSona\tSupport\t353\r\nSoraka\tSupport\t398\r\nSwain\tMiddle Lane\t385\r\nSyndra\tMiddle Lane\t380\r\nTalon\tMiddle Lane\t440\r\nTaric\tSupport\t468\r\nTeemo\tTop Lane\t378\r\nThresh\tSupport\t411\r\nTristana\tAD Carry\t415\r\nTrundle\tJungler\t455\r\nTryndamere\tTop Lane\t461\r\nTwitch\tAD Carry\t389\r\nUdyr\tJungler\t427\r\nUrgot\tAD Carry\t437\r\nVarus\tAD Carry\t400\r\nVayne\tAD Carry\t359\r\nVeigar\tMiddle Lane\t355\r\nVi\tJungler\t440\r\nViktor\tMiddle Lane\t385\r\nVladimir\tMiddle Lane\t400\r\nVolibear\tJungler\t440\r\nWarwick\tJungler\t428\r\nWukong\tTop Lane\t435\r\nXerath\tMiddle Lane\t380\r\nYasuo\tMiddle Lane\t380\r\nYorick\tTop Lane\t421\r\nZac\tJungler\t455\r\nZed\tMiddle Lane\t445\r\nZiggs\tMiddle Lane\t390\r\nZilean\tMiddle Lane\t380\r\nZyra\tSupport\t355");
		text.setTabSize(15);
		text.setBounds(23, 75, 400, 218);
		setLayout(null);
		add(lblView);
		add(comboBox);
		add(btnNewButton);
		add(btnNewButton_1);
		add(text);
		final JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setBounds(23, 75, 400, 218);
		add(scrollPane);
	}
	
	private String getResult(final Connection connection){
		filter = (String) comboBox.getSelectedItem();
		if(connection != null){
			try {
				Statement statement = connection.createStatement();
				filter = nameReturn(filter);
				textBox = "";
				String qryStatement =  "select Champion_name, role,  " + filter + " from champion_stats, champion_info" + 
						" where champion_stats.Champion_name = champion_info.champion";
				
				if( role && sort){
					qryStatement =  qryStatement + " ORDER BY role, " + filter + " DESC";
				}
				else if(role && sort == false){
					qryStatement = qryStatement + " ORDER BY role, Champion_name ASC";
				}
				else if(sort && role == false){
					qryStatement = qryStatement + " ORDER BY " + filter + " DESC";
				}
				
				ResultSet result = statement.executeQuery(qryStatement);
				while( result.next()){
					textBox = textBox + result.getString("Champion_name") + "\t" + result.getString("role") + 
							"\t" + result.getString(filter) + "\n";
				}
			} catch (SQLException e) {
				System.out.println("Uh-Oh someting wong");
				e.printStackTrace();
			}
			
		}
		return textBox;
	}
	
	private String nameReturn(String combobox){
		String  nameToReturn = "";
		switch(combobox){
		case "AR": nameToReturn = "base_armor"; break;
		case "AR+": nameToReturn = "armorperlevel"; break;
		case "AD": nameToReturn = "base_attackdamage"; break;
		case "AD+": nameToReturn = "attackdamageperlevel"; break;
		case "Range": nameToReturn = "attackrange"; break;
		case "AS": nameToReturn = "attackspeedoffset"; break;
		case "AS+": nameToReturn = "attackspeedperlevel"; break;
		case "HP": nameToReturn = "base_hp"; break;
		case "HP+": nameToReturn = "hpperlevel"; break;
		case "HP5": nameToReturn = "hpregen"; break;
		case "HP5+": nameToReturn = "hpregenperlevel"; break;
		case "MP": nameToReturn = "mp"; break;
		case "MP+": nameToReturn = "mpperlevel"; break;
		case "MP5": nameToReturn = "mpregen"; break;
		case "MP5+": nameToReturn = "mpregenperlevel"; break;
		case "MR": nameToReturn = "mresist"; break;
		case "MR+": nameToReturn = "mresistperlevel"; break;
		case "MS": nameToReturn = "movespeed"; break;
		case "IP Cost": nameToReturn = "ip"; break;
		case "RP Cost": nameToReturn = "rp"; break;
		case "Popularity": nameToReturn = "popular"; break;
		case "Win Rate": nameToReturn = "winrate"; break;
		case "Ban Rate": nameToReturn = "banrate"; break;
		default: System.out.println("This part is not suppose to show up");
		}
		return nameToReturn;
		
	}
}
