package ics321;

import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Items extends JPanel {
	
	int ap  = 0;
	int ad = 0;
	int movFlat = 0;
	int hpFlat = 0;
	int armFlat = 0;
	int mRes = 0;
	int mpFlat = 0;
	
	double crit;
	double atkSpd;
	double movPer;
	double mpReg;
	double hpReg;
	double lsPer;
	
	
	
	
	
	double tempDub;
	String item = "";
	
	
	private JTextField txtAD;
	private JTextField txtAP;
	private JTextField txtMR;
	private JTextField txtLS;
	private JTextField txtHP;
	private JTextField txtMP;
	private JTextField txtMovePer;
	private JTextField txtASpd;
	private JTextField txtCrit;
	private JTextField txtHPRgn;
	private JTextField txtARM;
	private JTextField txtMPRgn;
	private JTextField txtMvSpd;

	/**
	 * Create the panel.
	 */
	public Items(final Connection connection) {
		setLayout(null);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(20, 22, 109, 33);
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblItem);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(connection != null) {
					try {
					    PreparedStatement itemStat = connection.prepareStatement("select * from itemV2 where item_name = ?");					
				    	item =  (String) comboBox.getSelectedItem();
						itemStat.setString(1, item);
						ResultSet stats = itemStat.executeQuery();
						stats.next();
						
						ap  = stats.getInt(3);
						ad = stats.getInt(13);
						movFlat = stats.getInt(7);
						hpFlat = stats.getInt(8);
						armFlat = stats.getInt(9);
						mRes = stats.getInt(12);
						mpFlat = stats.getInt(15);
						crit = stats.getDouble(4);
						atkSpd = stats.getDouble(5);
						movPer = stats.getDouble(6);
						mpReg = stats.getDouble(10);
						hpReg = stats.getDouble(11);
						lsPer = stats.getDouble(14);
						
					}
					catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				txtAD.setText(String.valueOf(ad));
				txtAP.setText(String.valueOf(ap));
				txtMR.setText(String.valueOf(mRes));
				txtLS.setText(String.valueOf(lsPer));
				txtHP.setText(String.valueOf(hpFlat));
				txtMP.setText(String.valueOf(mpFlat));
				txtMovePer.setText(String.valueOf(movPer));
				txtASpd.setText(String.valueOf(atkSpd));
				txtCrit.setText(String.valueOf(crit));
				txtHPRgn.setText(String.valueOf(hpReg));
				txtARM.setText(String.valueOf(armFlat));
				txtMPRgn.setText(String.valueOf(mpReg));
				txtMvSpd.setText(String.valueOf(movFlat));
				
			
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Ring", "Doran's Shield", "Elixir of Fortitude", "Enchantment: Furor", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Seeker's Armguard", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stinger", "Sunfire Cape", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		comboBox.setBounds(78, 24, 200, 33);
		add(comboBox);
		
		JLabel lblAd = new JLabel("AD:");
		lblAd.setBounds(20, 86, 39, 14);
		add(lblAd);
		
		JLabel lblAp = new JLabel("AP:");
		lblAp.setBounds(175, 140, 46, 14);
		add(lblAp);
		
		JLabel lblAspd = new JLabel("ASpd:");
		lblAspd.setBounds(175, 89, 46, 14);
		add(lblAspd);
		
		JLabel lblHp = new JLabel("HP:");
		lblHp.setBounds(20, 182, 46, 14);
		add(lblHp);
		
		JLabel lblCrit = new JLabel("Crit:");
		lblCrit.setBounds(330, 89, 46, 14);
		add(lblCrit);
		
		JLabel lblArm = new JLabel("ARM:");
		lblArm.setBounds(330, 185, 46, 14);
		add(lblArm);
		
		JLabel lblLs = new JLabel("LS:");
		lblLs.setBounds(20, 137, 46, 14);
		add(lblLs);
		
		JLabel lblMvspd = new JLabel("MvSpd:");
		lblMvspd.setBounds(175, 278, 46, 14);
		add(lblMvspd);
		
		JLabel lblMprgn = new JLabel("MPRgn:");
		lblMprgn.setBounds(175, 231, 46, 14);
		add(lblMprgn);
		
		JLabel lblHprgn = new JLabel("HPRgn:");
		lblHprgn.setBounds(175, 185, 46, 14);
		add(lblHprgn);
		
		JLabel lblMove = new JLabel("Move+:");
		lblMove.setBounds(20, 275, 46, 14);
		add(lblMove);
		
		JLabel lblMr = new JLabel("MR:");
		lblMr.setBounds(330, 140, 46, 14);
		add(lblMr);
		
		JLabel lblMp = new JLabel("MP:");
		lblMp.setBounds(20, 228, 46, 14);
		add(lblMp);
		
		txtAD = new JTextField();
		txtAD.setText("0");
		txtAD.setBounds(78, 83, 60, 20);
		txtAD.setColumns(10);
		add(txtAD);
		
		txtAP = new JTextField();
		txtAP.setText("70");
		txtAP.setColumns(10);
		txtAP.setBounds(230, 137, 60, 20);
		add(txtAP);
		
		txtMR = new JTextField();
		txtMR.setText("45");
		txtMR.setColumns(10);
		txtMR.setBounds(374, 137, 60, 20);
		add(txtMR);
		
		txtLS = new JTextField();
		txtLS.setText("0");
		txtLS.setColumns(10);
		txtLS.setBounds(78, 134, 60, 20);
		add(txtLS);
		
		txtHP = new JTextField();
		txtHP.setText("0");
		txtHP.setColumns(10);
		txtHP.setBounds(76, 179, 60, 20);
		add(txtHP);
		
		txtMP = new JTextField();
		txtMP.setText("0");
		txtMP.setColumns(10);
		txtMP.setBounds(78, 225, 60, 20);
		add(txtMP);
		
		txtMovePer = new JTextField();
		txtMovePer.setText("0");
		txtMovePer.setColumns(10);
		txtMovePer.setBounds(78, 272, 60, 20);
		add(txtMovePer);
		
		txtASpd = new JTextField();
		txtASpd.setText("0");
		txtASpd.setColumns(10);
		txtASpd.setBounds(230, 86, 60, 20);
		add(txtASpd);
		
		txtCrit = new JTextField();
		txtCrit.setText("0");
		txtCrit.setColumns(10);
		txtCrit.setBounds(374, 86, 60, 20);
		add(txtCrit);
		
		txtHPRgn = new JTextField();
		txtHPRgn.setText("0");
		txtHPRgn.setColumns(10);
		txtHPRgn.setBounds(230, 182, 60, 20);
		add(txtHPRgn);
		
		txtARM = new JTextField();
		txtARM.setText("0");
		txtARM.setColumns(10);
		txtARM.setBounds(374, 182, 60, 20);
		add(txtARM);
		
		txtMPRgn = new JTextField();
		txtMPRgn.setText("0");
		txtMPRgn.setColumns(10);
		txtMPRgn.setBounds(230, 228, 60, 20);
		add(txtMPRgn);
		
		txtMvSpd = new JTextField();
		txtMvSpd.setText("0");
		txtMvSpd.setColumns(10);
		txtMvSpd.setBounds(230, 275, 60, 20);
		add(txtMvSpd);

	}
}
