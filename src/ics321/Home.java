package ics321;

import java.io.IOException;
import javax.swing.*;


@SuppressWarnings("serial")
public class Home extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Home() throws IOException  {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 455, 315);
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 455, SpringLayout.WEST, panel);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/League.jpg")));
		// lblNewLabel.setIcon(new ImageIcon("src\\images\\League.jpg"));
		panel.add(lblNewLabel);
		
		
	}
}
