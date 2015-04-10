package ics321;


import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;



public class HitVS extends JPanel {
	
	String champion = "";
	String structure = "";
	String Monster = "";
	String hp = "";
	String damage = "";
	String attackSpeed = "";
	String armor = "";
	String level = "1";
	String hthRegen = "";
	String mgcResist = "";
	String item = "";
	
	int    	bonusDamage = 0;
	int 	bonusAbility = 0;
	int		armPen = 0;
	int 	attacks = 0; //textfield return var
	double 	time = 0; //textfield return var
	double  bonusAttackSpeed = 0;
	double  armPenPerc;

	
	String enemyhp = "";
	String enemydamage = "";
	String enemyattackSpeed = "";
	String enemyarmor = "0";
	String enemylevel = "0";
	String enemyhthRegen = "";
	String enemymgcResist = "";
	
	float dmg; 
	float hpperlvl;	
	float attackSpeedperlvl;
	float armorperlvl;
	float hthRegenperlvl;
	float mgcResistperlvl;
	float damageperlvl;
	
	float enemyhpperlvl;	
	float enemyattackSpeedperlvl;
	float enemyarmorperlvl;
	float enemyhthRegenperlvl;
	float enemymgcResistperlvl;
	float enemydamageperlvl;
	
	
	boolean uniqueBC = false;
	boolean uniqueBR = false;
	boolean uniqueLW = false;
	boolean uniqueYG = false;
	boolean deathcap = false;
	boolean monOrStruct = true; //boolean for determining Monster or Structure
	NumberFormat formatter;
	
	private JTextField textField;
	private JTextField textField2;
	private CardLayout cards = null;

	/**
	 * Create the panel.
	 */
	public HitVS(final Connection connection) {
		setLayout(null);
		
		JLabel lblChampion = new JLabel("Champion:");
		lblChampion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChampion.setBounds(34, 39, 80, 24);
		add(lblChampion);
		
		final JComboBox comboName = new JComboBox();
		comboName.setModel(new DefaultComboBoxModel(new String[] {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", "Azir", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Cassiopeia", "Cho'Gath", "Corki", "Darius", "Diana", "Dr. Mundo", "Draven", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia", "Janna", "Jarvan IV", "Jax", "Jayce", "Jinx", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Kha'Zix", "Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna", "Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs", "Zilean", "Zyra"}));
		comboName.setBounds(130, 39, 80, 28);
		add(comboName);
		
		JLabel lbltimetodefeat = new JLabel("Time to Defeat:");
		lbltimetodefeat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltimetodefeat.setBounds(255, 237, 150, 24);
		add(lbltimetodefeat);
		
		JLabel lblHitsNeeded = new JLabel("Hits Needed:");
		lblHitsNeeded.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHitsNeeded.setBounds(255, 214, 150, 24);
		add(lblHitsNeeded);
		

		
		textField = new JTextField();
		textField.setText("11.9 secs");
		textField.setBounds(355, 240, 80, 20);
		add(textField);
		textField.setColumns(17);
		
		textField2 = new JTextField();
		textField2.setText("8 hits");
		textField2.setBounds(355, 217, 80, 20);
		add(textField2);
		textField2.setColumns(17);
		

		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevel.setBounds(34, 81, 46, 14);
		add(lblLevel);
		
		final JComboBox comboLevel = new JComboBox();
		comboLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));
		comboLevel.setBounds(130, 78, 46, 24);
		add(comboLevel);
		
		final JPanel cardPanel = new JPanel();
		cardPanel.setBounds(255, 39, 190, 136);
		add(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel MonsterPanel = new JPanel();
		cardPanel.add(MonsterPanel, "Panel 1");
		MonsterPanel.setLayout(null);
		
		final JComboBox comboTime = new JComboBox();
		comboTime.setBounds(83, 79, 46, 24);
		MonsterPanel.add(comboTime);
		comboTime.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "30", "40", "50", "60"}));
		
		final JComboBox comboMinion = new JComboBox();
		comboMinion.setBounds(83, 40, 97, 28);
		MonsterPanel.add(comboMinion);
		comboMinion.setModel(new DefaultComboBoxModel(new String[] {"min_melee", "min_caster", "min_siege", "min_super", "wraith_camp", "wolf_camp", "blue_camp", "wight_camp", "golem_camp", "dragon_pit", "baron_pit"}));
		
		JLabel lblMonster = new JLabel("Monster:");
		lblMonster.setBounds(10, 40, 80, 24);
		MonsterPanel.add(lblMonster);
		lblMonster.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 81, 46, 14);
		MonsterPanel.add(lblTime);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		final JButton btnStructures = new JButton("Structures");
		btnStructures.setBounds(37, 0, 102, 23);
		MonsterPanel.add(btnStructures);
		btnStructures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monOrStruct = false; //boolean to mark switch between structures and monsters
				cards.show(cardPanel, "Panel 2");
			}
		});
		
		JPanel StructurePanel = new JPanel();
		StructurePanel.setLayout(null);
		cardPanel.add(StructurePanel, "Panel 2");
		
		final JComboBox comboMonster = new JComboBox();
		comboMonster.setModel(new DefaultComboBoxModel(new String[] { "outer_tur", "inner_tur", "inhib_tur", "nexus_tur", "inhib", "nexus"}));
		comboMonster.setBounds(83, 40, 97, 28);
		StructurePanel.add(comboMonster);
		
		JLabel lblStructure = new JLabel("Structure:");
		lblStructure.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStructure.setBounds(10, 40, 80, 24);
		StructurePanel.add(lblStructure);
		
		
		JButton btnMonsters = new JButton("Monsters");
		btnMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monOrStruct = true; //boolean to mark switch between structures and monsters
				cards.show(cardPanel, "Panel 1");
			}
		});
		btnMonsters.setBounds(37, 0, 102, 23);
		StructurePanel.add(btnMonsters);
		cards = (CardLayout) cardPanel.getLayout();
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 125, 250, 140);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblItem = new JLabel("Equipped Items:");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItem.setBounds(35, 108, 100, 18);
		add(lblItem);
		
		
		final JComboBox combo1 = new JComboBox();
		combo1.setToolTipText("");
		combo1.setBounds(0, 10, 150, 20);
		combo1.setModel(new DefaultComboBoxModel(new String[] {"Empty Item Slot 1", "Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Blade (Showdown)", "Doran's Ring", "Doran's Ring (Showdown)", "Doran's Shield", "Doran's Shield (Showdown)", "Elixir of Fortitude", "Enchantment: Furor", "Enchantment: Homeguard", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Farsight Orb (Trinket)", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Greater Stealth Totem (Trinket)", "Greater Vision Totem (Trinket)", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Manamune (Crystal Scar)", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Oracle's Lens (Trinket)", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Poro-Snax", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Rod of Ages (Crystal Scar)", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Scrying Orb (Trinket)", "Seeker's Armguard", "Seraph's Embrace", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Soul Anchor (Trinket)", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stealth Ward", "Stinger", "Sunfire Cape", "Sweeping Lens (Trinket)", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "Tear of the Goddess (Crystal Scar)", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Total Biscuit of Rejuvenation", "Total Biscuit of Rejuvenation", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warding Totem (Trinket)", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		panel.add(combo1);
		
		final JComboBox combo2 = new JComboBox();
		combo2.setModel(new DefaultComboBoxModel(new String[] {"Empty Item Slot 2", "Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Blade (Showdown)", "Doran's Ring", "Doran's Ring (Showdown)", "Doran's Shield", "Doran's Shield (Showdown)", "Elixir of Fortitude", "Enchantment: Furor", "Enchantment: Homeguard", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Farsight Orb (Trinket)", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Greater Stealth Totem (Trinket)", "Greater Vision Totem (Trinket)", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Manamune (Crystal Scar)", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Oracle's Lens (Trinket)", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Poro-Snax", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Rod of Ages (Crystal Scar)", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Scrying Orb (Trinket)", "Seeker's Armguard", "Seraph's Embrace", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Soul Anchor (Trinket)", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stealth Ward", "Stinger", "Sunfire Cape", "Sweeping Lens (Trinket)", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "Tear of the Goddess (Crystal Scar)", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Total Biscuit of Rejuvenation", "Total Biscuit of Rejuvenation", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warding Totem (Trinket)", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		combo2.setBounds(0, 32, 150, 20);
		panel.add(combo2);
		
		final JComboBox combo3 = new JComboBox();
		combo3.setModel(new DefaultComboBoxModel(new String[] {"Empty Item Slot 3", "Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Blade (Showdown)", "Doran's Ring", "Doran's Ring (Showdown)", "Doran's Shield", "Doran's Shield (Showdown)", "Elixir of Fortitude", "Enchantment: Furor", "Enchantment: Homeguard", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Farsight Orb (Trinket)", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Greater Stealth Totem (Trinket)", "Greater Vision Totem (Trinket)", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Manamune (Crystal Scar)", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Oracle's Lens (Trinket)", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Poro-Snax", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Rod of Ages (Crystal Scar)", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Scrying Orb (Trinket)", "Seeker's Armguard", "Seraph's Embrace", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Soul Anchor (Trinket)", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stealth Ward", "Stinger", "Sunfire Cape", "Sweeping Lens (Trinket)", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "Tear of the Goddess (Crystal Scar)", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Total Biscuit of Rejuvenation", "Total Biscuit of Rejuvenation", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warding Totem (Trinket)", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		combo3.setBounds(0, 54, 150, 20);
		panel.add(combo3);
		
		final JComboBox combo4 = new JComboBox();
		combo4.setModel(new DefaultComboBoxModel(new String[] {"Empty Item Slot 4", "Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Blade (Showdown)", "Doran's Ring", "Doran's Ring (Showdown)", "Doran's Shield", "Doran's Shield (Showdown)", "Elixir of Fortitude", "Enchantment: Furor", "Enchantment: Homeguard", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Farsight Orb (Trinket)", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Greater Stealth Totem (Trinket)", "Greater Vision Totem (Trinket)", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Manamune (Crystal Scar)", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Oracle's Lens (Trinket)", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Poro-Snax", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Rod of Ages (Crystal Scar)", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Scrying Orb (Trinket)", "Seeker's Armguard", "Seraph's Embrace", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Soul Anchor (Trinket)", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stealth Ward", "Stinger", "Sunfire Cape", "Sweeping Lens (Trinket)", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "Tear of the Goddess (Crystal Scar)", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Total Biscuit of Rejuvenation", "Total Biscuit of Rejuvenation", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warding Totem (Trinket)", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		combo4.setBounds(0, 76, 150, 20);
		panel.add(combo4);
		
		final JComboBox combo5 = new JComboBox();
		combo5.setModel(new DefaultComboBoxModel(new String[] {"Empty Item Slot 5", "Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Blade (Showdown)", "Doran's Ring", "Doran's Ring (Showdown)", "Doran's Shield", "Doran's Shield (Showdown)", "Elixir of Fortitude", "Enchantment: Furor", "Enchantment: Homeguard", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Farsight Orb (Trinket)", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Greater Stealth Totem (Trinket)", "Greater Vision Totem (Trinket)", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Manamune (Crystal Scar)", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Oracle's Lens (Trinket)", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Poro-Snax", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Rod of Ages (Crystal Scar)", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Scrying Orb (Trinket)", "Seeker's Armguard", "Seraph's Embrace", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Soul Anchor (Trinket)", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stealth Ward", "Stinger", "Sunfire Cape", "Sweeping Lens (Trinket)", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "Tear of the Goddess (Crystal Scar)", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Total Biscuit of Rejuvenation", "Total Biscuit of Rejuvenation", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warding Totem (Trinket)", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		combo5.setBounds(0, 98, 150, 20);
		panel.add(combo5);
		
		final JComboBox combo6 = new JComboBox();
		combo6.setModel(new DefaultComboBoxModel(new String[] {"Empty Item Slot 6", "Abyssal Scepter", "Aegis of the Legion", "Aether Wisp", "Amplifying Tome", "Ancient Coin", "Archangel's Staff", "Ardent Censer", "Athene's Unholy Grail", "Atma's Impaler", "Avarice Blade", "B. F. Sword", "Banner of Command", "Banshee's Veil", "Berserker's Greaves", "Bilgewater Cutlass", "Blackfire Torch", "Blade of the Ruined King", "Blasting Wand", "Boots of Mobility", "Boots of Speed", "Boots of Swiftness", "Brawler's Gloves", "Catalyst the Protector", "Chain Vest", "Chalice of Harmony", "Cloak of Agility", "Cloth Armor", "Crystalline Flask", "Dagger", "Deathfire Grasp", "Dervish Blade", "Doran's Blade", "Doran's Blade (Showdown)", "Doran's Ring", "Doran's Ring (Showdown)", "Doran's Shield", "Doran's Shield (Showdown)", "Elixir of Fortitude", "Enchantment: Furor", "Enchantment: Homeguard", "Entropy", "Essence Reaver", "Executioner's Calling", "Explorer's Ward", "Face of the Mountain", "Faerie Charm", "Farsight Orb (Trinket)", "Feral Flare", "Fiendish Codex", "Forbidden Idol", "Frost Queen's Claim", "Frostfang", "Frozen Heart", "Frozen Mallet", "Giant's Belt", "Glacial Shroud", "Golden Transcendence", "Greater Stealth Totem (Trinket)", "Greater Vision Totem (Trinket)", "Grez's Spectral Lantern", "Guardian Angel", "Guardian's Horn", "Guinsoo's Rageblade", "Haunting Guise", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Head of Kha'Zix", "Health Potion", "Hexdrinker", "Hextech Gunblade", "Hextech Revolver", "Hextech Sweeper", "Hunter's Machete", "Iceborn Gauntlet", "Ichor of Illumination", "Ichor of Rage", "Infinity Edge", "Ionian Boots of Lucidity", "Kindlegem", "Last Whisper", "Liandry's Torment", "Lich Bane", "Locket of the Iron Solari", "Long Sword", "Lord Van Damm's Pillager", "Madred's Razors", "Mana Potion", "Manamune", "Manamune (Crystal Scar)", "Maw of Malmortius", "Mejai's Soulstealer", "Mercurial Scimitar", "Mercury's Treads", "Mikael's Crucible", "Moonflair Spellblade", "Morellonomicon", "Muramana", "Muramana", "Nashor's Tooth", "Needlessly Large Rod", "Negatron Cloak", "Ninja Tabi", "Nomad's Medallion", "Null-Magic Mantle", "Odyn's Veil", "Ohmwrecker", "Oracle's Extract", "Oracle's Lens (Trinket)", "Orb of Winter", "Overlord's Bloodmail", "Perfect Hex Core", "Phage", "Phantom Dancer", "Pickaxe", "Poro-Snax", "Prospector's Blade", "Prospector's Ring", "Prototype Hex Core", "Quicksilver Sash", "Quill Coat", "Quill Coat", "Rabadon's Deathcap", "Randuin's Omen", "Ravenous Hydra (Melee Only)", "Recurve Bow", "Rejuvenation Bead", "Relic Shield", "Rod of Ages", "Rod of Ages (Crystal Scar)", "Ruby Crystal", "Ruby Sightstone", "Runaan's Hurricane (Ranged Only)", "Rylai's Crystal Scepter", "Sanguine Blade", "Sapphire Crystal", "Scrying Orb (Trinket)", "Seeker's Armguard", "Seraph's Embrace", "Seraph's Embrace", "Sheen", "Sightstone", "Sorcerer's Shoes", "Soul Anchor (Trinket)", "Spectre's Cowl", "Spellthief's Edge", "Spirit of the Ancient Golem", "Spirit of the Ancient Golem", "Spirit of the Elder Lizard", "Spirit of the Spectral Wraith", "Spirit Stone", "Spirit Visage", "Statikk Shiv", "Stealth Ward", "Stinger", "Sunfire Cape", "Sweeping Lens (Trinket)", "Sword of the Divine", "Sword of the Occult", "Talisman of Ascension", "Targon's Brace", "Tear of the Goddess", "Tear of the Goddess (Crystal Scar)", "The Black Cleaver", "The Bloodthirster", "The Brutalizer", "The Hex Core mk-1", "The Hex Core mk-2", "The Lightbringer", "Thornmail", "Tiamat (Melee Only)", "Total Biscuit of Rejuvenation", "Total Biscuit of Rejuvenation", "Trinity Force", "Twin Shadows", "Twin Shadows", "Vampiric Scepter", "Vision Ward", "Void Staff", "Warden's Mail", "Warding Totem (Trinket)", "Warmog's Armor", "Wicked Hatchet", "Will of the Ancients", "Wit's End", "Wooglet's Witchcap", "Wriggle's Lantern", "Youmuu's Ghostblade", "Zeal", "Zeke's Herald", "Zephyr", "Zhonya's Hourglass"}));
		combo6.setBounds(0, 120, 150, 20);
		panel.add(combo6);
		
				
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(connection != null) {
					try {
						Statement statement = connection.createStatement();
					    PreparedStatement itemsPS = connection.prepareStatement("select * from itemV2 where item_name = ?");
					    
					    //Resets var before items stats re-checked
					    bonusDamage = 0;
					    bonusAttackSpeed = 0;
					    armPen = 0;
					    armPenPerc = 0.0;
					    bonusAbility = 0;
					    
					    
					    //Resets passive booleans
					    uniqueBC = false;
					    uniqueBR = false;
					    uniqueLW = false;
					    uniqueYG = false;
					    deathcap = false;
								    
					    //Item Stats Queries
					    item = (String) combo1.getSelectedItem();
					    //Check if item was selected
					    if(item != "Empty Item Slot 1") {
					    	item = (String) combo1.getSelectedItem();
							itemsPS.setString(1, item);
							ResultSet item1res = itemsPS.executeQuery();
							item1res.next();
							bonusDamage += item1res.getInt(13);
							bonusAttackSpeed += item1res.getDouble(5);
							bonusAbility += item1res.getInt(3);
						    //Case, item passive arm pen
							if((String)combo1.getSelectedItem() == "The Black Cleaver") {
								if(!uniqueBC) {
									armPen += 10;
								}
								uniqueBC = true;
							}
							else if((String)combo1.getSelectedItem() == "The Brutalizer") {
								if(!uniqueBR) {
									armPen += 10;
								}
								uniqueBR = true;
							}
							else if((String)combo1.getSelectedItem() == "Last Whisper") {
								if(!uniqueLW) {
									armPenPerc = 0.35;
								}
								uniqueLW = true;
							}
							else if((String)combo1.getSelectedItem() == "Youmuu's Ghostblade") {
								if(!uniqueYG) {
									armPen += 20;
								}
								uniqueYG = true;
							}
							else if((String)combo1.getSelectedItem() == "Rabadon's Deathcap") {
								deathcap = true;
							}
					    }
						
					    item = (String) combo2.getSelectedItem();
						if(item != "Empty Item Slot 2") {
							item = (String) combo2.getSelectedItem();
							itemsPS.setString(1, item);
							ResultSet item2res = itemsPS.executeQuery();
							item2res.next();
							bonusDamage += item2res.getInt(13);
							bonusAttackSpeed += item2res.getDouble(5);
							bonusAbility += item2res.getInt(3);
						    //Case, item passive arm pen
							if((String)combo2.getSelectedItem() == "The Black Cleaver") {
								if(!uniqueBC) {
									armPen += 10;
								}
								uniqueBC = true;
							}
							else if((String)combo2.getSelectedItem() == "The Brutalizer") {
								if(!uniqueBR) {
									armPen += 10;
								}
								uniqueBR = true;
							}
							else if((String)combo2.getSelectedItem() == "Last Whisper") {
								if(!uniqueLW) {
									armPenPerc = 0.35;
								}
								uniqueLW = true;
							}
							else if((String)combo2.getSelectedItem() == "Youmuu's Ghostblade") {
								if(!uniqueYG) {
									armPen += 20;
								}
								uniqueYG = true;
							}
							else if((String)combo2.getSelectedItem() == "Rabadon's Deathcap") {
								deathcap = true;
							}
						}

						item = (String) combo3.getSelectedItem();
						if(item != "Empty Item Slot 3") {
							item = (String) combo3.getSelectedItem();
							itemsPS.setString(1, item);
							ResultSet item3res = itemsPS.executeQuery();
							item3res.next();
							bonusDamage += item3res.getInt(13);
							bonusAttackSpeed += item3res.getDouble(5);
							bonusAbility += item3res.getInt(3);
						    //Case, item passive arm pen
							if((String)combo3.getSelectedItem() == "The Black Cleaver") {
								if(!uniqueBC) {
									armPen += 10;
								}
								uniqueBC = true;
							}
							else if((String)combo3.getSelectedItem() == "The Brutalizer") {
								if(!uniqueBR) {
									armPen += 10;
								}
								uniqueBR = true;
							}
							else if((String)combo3.getSelectedItem() == "Last Whisper") {
								if(!uniqueLW) {
									armPenPerc = 0.35;
								}
								uniqueLW = true;
							}
							else if((String)combo3.getSelectedItem() == "Youmuu's Ghostblade") {
								if(!uniqueYG) {
									armPen += 20;
								}
								uniqueYG = true;
							}
							else if((String)combo3.getSelectedItem() == "Rabadon's Deathcap") {
								deathcap = true;
							}
						}
					
						item = (String) combo4.getSelectedItem();
						if(item != "Empty Item Slot 4") {
							item = (String) combo4.getSelectedItem();
							itemsPS.setString(1, item);
							ResultSet item4res = itemsPS.executeQuery();
							item4res.next();
							bonusDamage += item4res.getInt(13);
							bonusAttackSpeed += item4res.getDouble(5);
							bonusAbility += item4res.getInt(3);
						    //Case, item passive arm pen
							if((String)combo4.getSelectedItem() == "The Black Cleaver") {
								if(!uniqueBC) {
									armPen += 10;
								}
								uniqueBC = true;
							}
							else if((String)combo4.getSelectedItem() == "The Brutalizer") {
								if(!uniqueBR) {
									armPen += 10;
								}
								uniqueBR = true;
							}
							else if((String)combo4.getSelectedItem() == "Last Whisper") {
								if(!uniqueLW) {
									armPenPerc = 0.35;
								}
								uniqueLW = true;
							}
							else if((String)combo4.getSelectedItem() == "Youmuu's Ghostblade") {
								if(!uniqueYG) {
									armPen += 20;
								}
								uniqueYG = true;
							}
							else if((String)combo4.getSelectedItem() == "Rabadon's Deathcap") {
								deathcap = true;
							}
						}

						item = (String) combo5.getSelectedItem();
						if(item != "Empty Item Slot 5") {
							item = (String) combo5.getSelectedItem();
							itemsPS.setString(1, item);
							ResultSet item5res = itemsPS.executeQuery();
							item5res.next();
							bonusDamage += item5res.getInt(13);
							bonusAttackSpeed += item5res.getDouble(5);
							bonusAbility += item5res.getInt(3);
						    //Case, item passive arm pen
							if((String)combo5.getSelectedItem() == "The Black Cleaver") {
								if(!uniqueBC) {
									armPen += 10;
								}
								uniqueBC = true;
							}
							else if((String)combo5.getSelectedItem() == "The Brutalizer") {
								if(!uniqueBR) {
									armPen += 10;
								}
								uniqueBR = true;
							}
							else if((String)combo5.getSelectedItem() == "Last Whisper") {
								if(!uniqueLW) {
									armPenPerc = 0.35;
								}
								uniqueLW = true;
							}
							else if((String)combo5.getSelectedItem() == "Youmuu's Ghostblade") {
								if(!uniqueYG) {
									armPen += 20;
								}
								uniqueYG = true;
							}
							else if((String)combo5.getSelectedItem() == "Rabadon's Deathcap") {
								deathcap = true;
							}
						}
						
						item = (String) combo6.getSelectedItem();
						if(item != "Empty Item Slot 6") {
							item = (String) combo6.getSelectedItem();
							itemsPS.setString(1, item);
							ResultSet item6res = itemsPS.executeQuery();
							item6res.next();
							bonusDamage += item6res.getInt(13);
							bonusAttackSpeed += item6res.getDouble(5);
							bonusAbility += item6res.getInt(3);
						    //Case, item passive arm pen
							if((String)combo6.getSelectedItem() == "The Black Cleaver") {
								if(!uniqueBC) {
									armPen += 10;
								}
								uniqueBC = true;
							}
							else if((String)combo6.getSelectedItem() == "The Brutalizer") {
								if(!uniqueBR) {
									armPen += 10;
								}
								uniqueBR = true;
							}
							else if((String)combo6.getSelectedItem() == "Last Whisper") {
								if(!uniqueLW) {
									armPenPerc = 0.35;
								}
								uniqueLW = true;
							}
							else if((String)combo6.getSelectedItem() == "Youmuu's Ghostblade") {
								if(!uniqueYG) {
									armPen += 20;
								}
								uniqueYG = true;
							}
							else if((String)combo6.getSelectedItem() == "Rabadon's Deathcap") {
								deathcap = true;
							}
						}
						
						//case deathcap passive
						if(deathcap) {
							bonusAbility *= 1.30;
						}

						//Champ Base Stats Query Start
						level = (String) comboLevel.getSelectedItem();
						champion = (String) comboName.getSelectedItem();
						String qryStatement = "select * from champion_stats where Champion_name = '" + champion + "'"; 	//added champion name
						ResultSet result = statement.executeQuery(qryStatement);
						float lvl = Float.parseFloat(level); 
						result.next();
						 hpperlvl =  lvl * Float.parseFloat(result.getString(11));		
						 hthRegenperlvl = lvl * Float.parseFloat(result.getString(13));
						 damageperlvl = lvl * Float.parseFloat(result.getString(6));
						 attackSpeedperlvl = lvl * Float.parseFloat(result.getString(9));
						 armorperlvl = lvl * Float.parseFloat(result.getString(4));
						 mgcResistperlvl = lvl * Float.parseFloat(result.getString(20));
						hp =  String.format("%.2f", (hpperlvl + Float.parseFloat(result.getString(10))));		
						hthRegen = String.format("%.2f", (hthRegenperlvl + Float.parseFloat(result.getString(12))));
						System.out.println(result.getString(5));
						System.out.println(bonusDamage);
						if(!monOrStruct && bonusAbility*.4 > bonusDamage) {
							bonusDamage = (int) (bonusAbility*0.4);
						}
						
						damage = String.format("%.2f", (damageperlvl + bonusDamage + Float.parseFloat(result.getString(5))));
						attackSpeed = String.format("%.2f", ((.625/(Float.parseFloat(result.getString(8)) + 1))*((attackSpeedperlvl)/100 + 1 + bonusAttackSpeed)));
						armor = String.format("%.2f", (armorperlvl + Float.parseFloat(result.getString(3))));
						mgcResist = String.format("%.2f", (mgcResistperlvl + Float.parseFloat(result.getString(19))));
						
					
						//attack speed cap
						if(Double.parseDouble(attackSpeed) > 2.5) {
							attackSpeed = "2.5";
						}
						
						//Case champ vs Monster
						if(monOrStruct) {
							enemylevel = (String) comboTime.getSelectedItem();
							Monster = (String) comboMinion.getSelectedItem();
							String qryStatement2 = "select * from monsters where mon_name = '" + Monster + "' AND time = '" + enemylevel + "'"; 
							ResultSet result2 = statement.executeQuery(qryStatement2);
							
							result2.next();
							enemyhp = result2.getString(5);
							enemyarmor = result2.getString(6);
							
							//Case of armor 0 or negative armor
							if(Float.parseFloat(enemyarmor) < 1.0) {
								dmg = (Float.parseFloat(damage))*(2 - (100/(100 - (Float.parseFloat(enemyarmor) - armPen))));
							}
							else {
								dmg = (float) ((Float.parseFloat(damage))*(100/(100 + ((Float.parseFloat(enemyarmor)*(1-armPenPerc)) - armPen))));
							}
							System.out.println(dmg);
							attacks = (int)Math.ceil(Float.parseFloat(enemyhp)/dmg);
							time = attacks/Double.parseDouble(attackSpeed);
						}
						//Case champ vs structures
						else if(!monOrStruct) {
							structure = (String) comboMonster.getSelectedItem();
							String qryStatement2 = "select * from structures where struc_name = '" + structure + "'"; 
							ResultSet result2 = statement.executeQuery(qryStatement2);
							
							result2.next();
							enemyhp = result2.getString(7);
							enemyarmor = result2.getString(3);
							
							//Case of armor 0 or negative armor
							if(Float.parseFloat(enemyarmor) < 1.0) {
								dmg = (Float.parseFloat(damage))*(2 - (100/(100 - Float.parseFloat(enemyarmor))));
							}
							else {
								dmg = (Float.parseFloat(damage))*(100/(100 + Float.parseFloat(enemyarmor)));
							}
							System.out.println(bonusAbility*0.4);
							System.out.println(dmg);
							attacks = (int)Math.ceil(Float.parseFloat(enemyhp)/dmg);
							time = attacks/Double.parseDouble(attackSpeed);
						}
						

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				formatter = new DecimalFormat("#0.0");     
				
				//Update text boxes with results
				textField2.setText(String.valueOf(attacks)+" hits");
				textField.setText(String.valueOf(formatter.format(time))+" secs");
				
			}
		});
		btnCalculate.setBounds(295, 178, 95, 28);
		add(btnCalculate);

	}
}
