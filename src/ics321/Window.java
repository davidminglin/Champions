package ics321;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
public class Window extends JFrame {

	private JPanel contentPane;
	private Home home;
	private Login login;
	private ChampionStats stats;
	private ChampionInfo info;
	private ChampionVs vs;
	private ChampionFilter filter;
	private CardLayout cardLayout;
	private JPanel MainPanel;
	private JPanel hitVS;
	private JPanel items;
	private JPanel monsters;
	private JPanel structures;
	private static Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
	       {
	           String url = "jdbc:mysql://192.254.189.7:3306/vpawid_321project";
	           Class.forName ("com.mysql.jdbc.Driver");
	           connection = DriverManager.getConnection (url,"vpawid_test","ics321");
	           // System.out.println ("Database connection established");
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Window() throws IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (connection != null) {
		            try {
		            	connection.close();;
		            	// System.out.println ("Database connection terminated");
		            } catch (Exception e) {
		            	System.out.println(e.getMessage());
		            }
		        }
			}
		});
		home = new Home();
		login = new Login();
		stats = new ChampionStats(connection);
		info = new ChampionInfo(connection);
		vs = new ChampionVs(connection);
		filter = new ChampionFilter(connection);
		hitVS = new HitVS(connection);
		items = new Items(connection);
		monsters = new Monsters(connection);
		structures = new Structures(connection);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel TopPanel = new JPanel();
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(5, 40, 83, 23);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(MainPanel, "Panel 1");
			}
		});
		TopPanel.setLayout(null);
		TopPanel.add(btnHome);
		
		JButton btnStats = new JButton("Stats");
		btnStats.setBounds(94, 40, 83, 23);
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 2");
			}
		});
		TopPanel.add(btnStats);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.setBounds(182, 40, 83, 23);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 3");
			}
		});
		TopPanel.add(btnInfo);
		
		JButton btnVs = new JButton("VS");
		btnVs.setBounds(356, 40, 83, 23);
		btnVs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 4");
			}
		});
		TopPanel.add(btnVs);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setBounds(268, 40, 83, 23);
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 5");
			}
		});
		TopPanel.add(btnFilter);
		
		JButton btnHits = new JButton("Hits");
		btnHits.setBounds(20, 65, 95, 23);
		btnHits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 6");
			}
		});
		TopPanel.add(btnHits);
		
		JLabel lblChampions = new JLabel("Champions");
		lblChampions.setBounds(127, 0, 199, 43);
		lblChampions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblChampions.setHorizontalAlignment(SwingConstants.CENTER);
		TopPanel.add(lblChampions);
		
		MainPanel = new JPanel();
		MainPanel.setLayout(new CardLayout(0, 0));
		MainPanel.add(login, "Panel 0");
		MainPanel.add(home, "Panel 1");
		home.setLayout(null);
		MainPanel.add(stats, "Panel 2");
		MainPanel.add(info, "Panel 3");
		MainPanel.add(vs, "Panel 4");
		MainPanel.add(filter, "Panel 5");
		MainPanel.add(hitVS, "Panel 6");
		MainPanel.add(items, "Panel 7");
		MainPanel.add(monsters, "Panel 8");
		MainPanel.add(structures, "Panel 9");
		cardLayout = (CardLayout) MainPanel.getLayout();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(TopPanel, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
						.addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(TopPanel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnItems = new JButton("Items");
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(MainPanel, "Panel 7");
			}
		});
		btnItems.setBounds(125, 65, 95, 23);
		TopPanel.add(btnItems);
		
		JButton btnMonsters = new JButton("Monsters");
		btnMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 8");
			}
		});
		btnMonsters.setBounds(230, 65, 95, 23);
		TopPanel.add(btnMonsters);
		
		JButton btnStructures = new JButton("Structures");
		btnStructures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(MainPanel, "Panel 9");
			}
		});
		btnStructures.setBounds(330, 65, 95, 23);
		TopPanel.add(btnStructures);
		contentPane.setLayout(gl_contentPane);
	}
}
