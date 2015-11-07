
//	+++ PACKAGE +++

package view;


//	+++ IMPORT +++

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import control.DWCGControl;

import model.DWCGModel;


//	+++ CLASS +++

@SuppressWarnings("serial")
//serialisation is currently not needed
public class DWCGFrame extends JFrame implements Observer{
	CardLayout cl = new CardLayout();
	private Container cp = getContentPane();
	private final static String SHOW = "Show Frame";

	private MenuBar menubar;
	private Menu m_character;
	private Menu m_dwcg;
	private MenuItem mi_new;
	private MenuItem mi_load;
	private MenuItem mi_exit;
	private MenuItem mi_about;
	private MenuItem mi_help;
	
	private DWCGControl control;
		
	
//  +++ CONSTRUCTORS +++

	public DWCGFrame(DWCGModel model){
		control = new DWCGControl(model);
		model.addObserver(this);
		
		menubar = new MenuBar();
		m_character = new Menu("Character");
		m_dwcg = new Menu("DWCG");
		mi_new = new MenuItem("New Character");
		mi_load = new MenuItem("Load Character");
		mi_exit = new MenuItem("Exit");
		mi_about = new MenuItem("About");
		mi_help = new MenuItem("Help");
		mi_new.setActionCommand("New Character");
		mi_load.setActionCommand("Load Character");
		mi_exit.setActionCommand("Exit");
		mi_about.setActionCommand("About");
		mi_help.setActionCommand("Help");
		mi_new.addActionListener(control);
		mi_load.addActionListener(control);
		mi_exit.addActionListener(control);
		mi_about.addActionListener(control);
		mi_help.addActionListener(control);
		m_character.add(mi_new);
		m_character.add(mi_load);
		m_character.add(mi_exit);
		m_dwcg.add(mi_about);
		m_dwcg.add(mi_help);
		menubar.add(m_character);
		menubar.add(m_dwcg);
		setMenuBar(menubar);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setSize(getToolkit().getScreenSize());
		
		cp.setLayout(cl);

		setTitle("Deathwatch Character Generator");
		setBackground(new Color(84,92,102));
		setSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}


//	+++ METHODS +++

	@Override
	public void update(Observable model, Object arg) {
		Object panel = ((DWCGModel)model).getPanel();
		if(panel instanceof CreationPanel){
			cp.add((CreationPanel)panel, SHOW);
		}else {
			//TODO show the other Panels when they are done
		}
		cl.show(cp, SHOW);
		this.revalidate();
	}
}