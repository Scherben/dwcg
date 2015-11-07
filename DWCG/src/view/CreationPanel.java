
//	+++ PACKAGE +++

package view;


//	+++ IMPORT +++

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
//import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import attributes.Advance;
import attributes.Skill;
import attributes.SoloModeAbility;
import attributes.SpecialAbility;
import attributes.Talent;
import attributes.Trait;

import control.CreationControl;

import model.CreationModel;

import resources.Functions;


//	+++ CLASS +++

@SuppressWarnings("serial")
//serialisation is currently not needed
public class CreationPanel extends JPanel implements Observer{


//	+++ FIELDS +++

	private CreationControl control;
	private CreationModel m;
	Color label_color = new Color(154,22,22);

	CardLayout cl;
	GridBagLayout gbl;

	//General Structure
	JPanel p_prog;
	JPanel p_cre;
	JScrollPane sp_prog;
	JScrollPane sp_cre;
	JSplitPane spi_cre;

	//Progress Panel Elements
	//Progress Title
	private JPanel p_prog_title;
	private JLabel l_prog_title;

	//Progress Description
	JPanel p_prog_description;
	private JLabel l_prog_name;
	private JLabel l_prog_val_name;
	private JLabel l_prog_chapter;
	private JLabel l_prog_val_chapter;
	private JLabel l_prog_speciality;
	private JLabel l_prog_val_speciality;
	private JLabel l_prog_rank;
	private JLabel l_prog_val_rank;
	private JLabel l_prog_xptotal;
	private JLabel l_prog_val_xptotal;
	private JLabel l_prog_demeanour;
	private JLabel l_prog_val_demeanour;
	private JLabel l_prog_chapterdemeanour;
	private JLabel l_prog_val_chapterdemeanour;
	private JLabel l_prog_pastevent;
	private JLabel l_prog_val_pastevent;
	private JLabel l_prog_description;
	private JLabel l_prog_val_description;
	private JLabel l_prog_xprest;
	private JLabel l_prog_val_xprest;

	//Progress Characteristics
	JPanel p_prog_characteristics;
	private JLabel l_prog_weaponskill;
	private JLabel l_prog_ballisticskill;
	private JLabel l_prog_strength;
	private JLabel l_prog_toughness;
	private JLabel l_prog_agility;
	private JLabel l_prog_intelligence;
	private JLabel l_prog_perception;
	private JLabel l_prog_willpower;
	private JLabel l_prog_fellowship;
	private JLabel l_prog_val_weaponskill;
	private JLabel l_prog_val_ballisticskill;
	private JLabel l_prog_val_strength;
	private JLabel l_prog_val_toughness;
	private JLabel l_prog_val_agility;
	private JLabel l_prog_val_intelligence;
	private JLabel l_prog_val_perception;
	private JLabel l_prog_val_willpower;
	private JLabel l_prog_val_fellowship;

	//Progress Values
	JPanel p_prog_values;
	private JLabel l_prog_wounds;
	private JLabel l_prog_val_wounds;
	private JLabel l_prog_insanity;
	private JLabel l_prog_val_insanity;
	private JLabel l_prog_fate;
	private JLabel l_prog_val_fate;
	private JLabel l_prog_corruption;
	private JLabel l_prog_val_corruption;
	private JLabel l_prog_reknown;
	private JLabel l_prog_val_reknown;
	private JLabel l_prog_movement;
	private JLabel l_prog_movhalf;
	private JLabel l_prog_val_movhalf;
	private JLabel l_prog_movfull;
	private JLabel l_prog_val_movfull;
	private JLabel l_prog_movcharge;
	private JLabel l_prog_val_movcharge;
	private JLabel l_prog_movrun;
	private JLabel l_prog_val_movrun;

	//Progress Special Ability
	private JPanel p_prog_specialabilities;
	private JLabel l_prog_specialability;
	private JPanel p_prog_specialabilities_values;

	//Progress Traits
	private JPanel p_prog_traits;
	private JLabel l_prog_trait;
	private JPanel p_prog_traits_values;

	//Progress Skills
	private JPanel p_prog_skills;
	private JLabel l_prog_skill;
	private JPanel p_prog_skills_values;
	private JLabel l_prog_basic;
	private JLabel l_prog_trained;
	private JLabel l_prog_ten;
	private JLabel l_prog_twenty;
			
	//Progress Talents
	private JPanel p_prog_talents;
	private JLabel l_prog_talent;
	private JPanel p_prog_talents_values;

	//Progress Psychic Powers
	private JPanel p_prog_psypowers;
	private JLabel l_prog_psypower;
	private JLabel l_prog_psyrating;
	private JLabel l_prog_val_psyrating;
	private JPanel p_prog_psypowers_values;

	//Progress Solo Mode Abilities
	private JPanel p_prog_soloma;
	private JLabel l_prog_soloma;
	private JPanel p_prog_soloma_values;

	//Progress Squad Mode Abilities
	//private JPanel p_prog_squadma;
	//private JLabel l_prog_squadma;

	//Progress Equipment
	private JPanel p_prog_equipment;
	private JLabel l_prog_equipment;
	private JPanel p_prog_equipment_values;

	//Creation Panel Elements
	//Creation Steps
	JPanel p_cre_step1 = new JPanel();
	JPanel p_cre_step2 = new JPanel();
	JPanel p_cre_step3 = new JPanel();
	JPanel p_cre_step4 = new JPanel();
	JPanel p_cre_step5 = new JPanel();
	//JPanel p_cre_step6 = new JPanel();
	//JPanel p_cre_step7 = new JPanel();
	//JPanel p_cre_step8 = new JPanel();

	//Creation Elements for Step 1
	JPanel p_cre_characteristics;
	private JLabel l_cre_step1_title;
	private JLabel l_cre_weaponskill;
	private JLabel l_cre_ballisticskill;
	private JLabel l_cre_strength;
	private JLabel l_cre_toughness;
	private JLabel l_cre_agility;
	private JLabel l_cre_intelligence;
	private JLabel l_cre_perception;
	private JLabel l_cre_willpower;
	private JLabel l_cre_fellowship;
	private JLabel l_cre_val_weaponskill;
	private JLabel l_cre_val_ballisticskill;
	private JLabel l_cre_val_strength;
	private JLabel l_cre_val_toughness;
	private JLabel l_cre_val_agility;
	private JLabel l_cre_val_intelligence;
	private JLabel l_cre_val_perception;
	private JLabel l_cre_val_willpower;
	private JLabel l_cre_val_fellowship;
	//private JPanel p_cre_roll;
	private JButton b_cre_rerollweaponskill;
	private JButton b_cre_rerollballisticskill;
	private JButton b_cre_rerollstrength;
	private JButton b_cre_rerolltoughness;
	private JButton b_cre_rerollagility;
	private JButton b_cre_rerollintelligence;
	private JButton b_cre_rerollperception;
	private JButton b_cre_rerollwillpower;
	private JButton b_cre_rerollfellowship;
	private JButton b_cre_rollcharacteristics;

	//Creation Elements for Step 2
	private JLabel l_cre_step2_title;
	private JComboBox<String> cob_cre_chpt;
	
	//Creation Elements for Step 3
	private JComboBox<String> cob_cre_spty;
	private JLabel l_cre_step3a_title;
	private JComboBox<String> cob_cre_sptyspecab;
	private JLabel l_cre_step3b_title;

	//Creation Elements for Step 4
	private JLabel l_cre_step4_title;
	private JComboBox<String> cob_cre_tactics;
		
	//Creation Elements for Step 6
	//private JComboBox<String> cob_cre_equipment;

	//Creation Elements for Step 7
	//private JComboBox<String> cob_cre_chptdemeanours;

	//Creation Elements for Step 8
	//private JTextArea ta_cre_rolledname;
	//private JTextArea ta_cre_newname;

	//needs handling
	//private static final String[] equipment = {"different Equipment choices depending on the chosen speciality"};
	

//	+++ CONSTRUCTORS +++

	public CreationPanel(CreationModel m) {
		this.m = m;
		control = new CreationControl(this.m);
		this.m.addObserver(this);

	//	+++ Create new Objects +++
		
		cl = new CardLayout();
		p_prog = new JPanel();
		p_cre = new JPanel();
		sp_prog = new JScrollPane(p_prog, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp_prog.getVerticalScrollBar().setUnitIncrement(20);
		sp_cre = new JScrollPane(p_cre, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp_cre.getVerticalScrollBar().setUnitIncrement(20);
		spi_cre = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		p_prog_title = new JPanel();
		l_prog_title = new JLabel("Your Character:", JLabel.CENTER);
		l_prog_title.setFont(new Font("Sans", Font.PLAIN, 14));
		l_prog_title.setForeground(label_color);
		p_prog_description = new JPanel();
		l_prog_name = new JLabel("Name:");
		l_prog_name.setForeground(label_color);
		l_prog_val_name = new JLabel();
		l_prog_chapter = new JLabel(CreationModel.CHAPTER + ":");
		l_prog_chapter.setForeground(label_color);
		l_prog_val_chapter = new JLabel();
		l_prog_speciality = new JLabel(CreationModel.SPECIALITY + ":");
		l_prog_speciality.setForeground(label_color);
		l_prog_val_speciality = new JLabel();
		l_prog_rank = new JLabel(CreationModel.RANK + ":");
		l_prog_rank.setForeground(label_color);
		l_prog_val_rank = new JLabel("" + m.getCharacterValueValue(CreationModel.RANK, 1));
		l_prog_xptotal = new JLabel(CreationModel.XPTOTAL + ":");
		l_prog_xptotal.setForeground(label_color);
		l_prog_val_xptotal = new JLabel("" + m.getCharacterValueValue(CreationModel.XPTOTAL, 1));
		l_prog_demeanour = new JLabel(CreationModel.DEMEANOUR + ":");
		l_prog_demeanour.setForeground(label_color);
		l_prog_val_demeanour = new JLabel();
		l_prog_chapterdemeanour = new JLabel(CreationModel.CHAPTER + " " + CreationModel.DEMEANOUR + ":");
		l_prog_chapterdemeanour.setForeground(label_color);
		l_prog_val_chapterdemeanour = new JLabel();
		l_prog_pastevent = new JLabel(CreationModel.PASTEVENT + ":");
		l_prog_pastevent.setForeground(label_color);
		l_prog_val_pastevent = new JLabel();
		l_prog_description = new JLabel(CreationModel.DESCRIPTION + ":");
		l_prog_description.setForeground(label_color);
		l_prog_val_description = new JLabel();
		l_prog_xprest = new JLabel(CreationModel.XPREST + ":");
		l_prog_xprest.setForeground(label_color);
		l_prog_val_xprest = new JLabel("" + m.getCharacterValueValue(CreationModel.XPREST, 1));
		p_prog_characteristics = new JPanel();
		l_prog_weaponskill = new JLabel(CreationModel.WS_ + ":");
		l_prog_weaponskill.setForeground(label_color);
		l_prog_ballisticskill = new JLabel(CreationModel.BS_ + ":");
		l_prog_ballisticskill.setForeground(label_color);
		l_prog_strength = new JLabel(CreationModel.S_ + ":");
		l_prog_strength.setForeground(label_color);
		l_prog_toughness = new JLabel(CreationModel.T_ + ":");
		l_prog_toughness.setForeground(label_color);
		l_prog_agility = new JLabel(CreationModel.AGI_ + ":");
		l_prog_agility.setForeground(label_color);
		l_prog_intelligence = new JLabel(CreationModel.INT_ + ":");
		l_prog_intelligence.setForeground(label_color);
		l_prog_perception = new JLabel(CreationModel.PER_ + ":");
		l_prog_perception.setForeground(label_color);
		l_prog_willpower = new JLabel(CreationModel.WP_ + ":");
		l_prog_willpower.setForeground(label_color);
		l_prog_fellowship = new JLabel(CreationModel.FEL_ + ":");
		l_prog_fellowship.setForeground(label_color);
		l_prog_val_weaponskill = new JLabel("" + m.getCharacteristicValue(CreationModel.WEAPONSKILL));
		l_prog_val_ballisticskill = new JLabel("" + m.getCharacteristicValue(CreationModel.BALLISTICSKILL));
		l_prog_val_strength = new JLabel("" + m.getCharacteristicValue(CreationModel.STRENGTH));
		l_prog_val_toughness = new JLabel("" + m.getCharacteristicValue(CreationModel.TOUGHNESS));
		l_prog_val_agility = new JLabel("" + m.getCharacteristicValue(CreationModel.AGILITY));
		l_prog_val_intelligence = new JLabel("" + m.getCharacteristicValue(CreationModel.INTELLIGENCE));
		l_prog_val_perception = new JLabel("" + m.getCharacteristicValue(CreationModel.PERCEPTION));
		l_prog_val_willpower = new JLabel("" + m.getCharacteristicValue(CreationModel.WILLPOWER));
		l_prog_val_fellowship = new JLabel("" + m.getCharacteristicValue(CreationModel.FELLOWSHIP));
		p_prog_values = new JPanel();
		l_prog_wounds = new JLabel(CreationModel.WOUNDS + ":");
		l_prog_wounds.setForeground(label_color);
		l_prog_val_wounds = new JLabel("" + m.getCharacterValueValue(CreationModel.WOUNDS, 1));
		l_prog_insanity = new JLabel(CreationModel.INSANITY + ":");
		l_prog_insanity.setForeground(label_color);
		l_prog_val_insanity = new JLabel("" + m.getCharacterValueValue(CreationModel.INSANITY, 1));
		l_prog_fate = new JLabel(CreationModel.FATE + ":");
		l_prog_fate.setForeground(label_color);
		l_prog_val_fate = new JLabel("" + m.getCharacterValueValue(CreationModel.FATE, 1));
		l_prog_corruption = new JLabel(CreationModel.CORRUPTION + ":");
		l_prog_corruption.setForeground(label_color);
		l_prog_val_corruption = new JLabel("" + m.getCharacterValueValue(CreationModel.CORRUPTION, 1));
		l_prog_reknown = new JLabel(CreationModel.REKNOWN + ":");
		l_prog_reknown.setForeground(label_color);
		l_prog_val_reknown = new JLabel("" + m.getCharacterValueValue(CreationModel.REKNOWN, 1));
		l_prog_movement = new JLabel(CreationModel.MOVEMENT + ":");
		l_prog_movement.setForeground(label_color);
		l_prog_movhalf = new JLabel("Half:");
		l_prog_movhalf.setForeground(label_color);
		l_prog_val_movhalf = new JLabel("" + m.getCharacterValueValue(CreationModel.MOVEMENT, 1));
		l_prog_movfull = new JLabel("Full:");
		l_prog_movfull.setForeground(label_color);
		l_prog_val_movfull = new JLabel("" + m.getCharacterValueValue(CreationModel.MOVEMENT, 2));
		l_prog_movcharge = new JLabel("Charge:");
		l_prog_movcharge.setForeground(label_color);
		l_prog_val_movcharge = new JLabel("" + m.getCharacterValueValue(CreationModel.MOVEMENT, 3));
		l_prog_movrun = new JLabel("Run:");
		l_prog_movrun.setForeground(label_color);
		l_prog_val_movrun = new JLabel("" + m.getCharacterValueValue(CreationModel.MOVEMENT, 4));
		p_prog_specialabilities = new JPanel();
		l_prog_specialability = new JLabel("Special Abilities");
		l_prog_specialability.setForeground(label_color);
		p_prog_specialabilities_values = new JPanel();
		p_prog_traits = new JPanel();
		l_prog_trait = new JLabel("Traits");
		l_prog_trait.setForeground(label_color);
		p_prog_traits_values = new JPanel();
		p_prog_skills = new JPanel();
		l_prog_skill = new JLabel("Skills");
		l_prog_skill.setForeground(label_color);
		p_prog_skills_values = new JPanel();
		l_prog_basic = new JLabel("Basic");
		l_prog_basic.setForeground(label_color);
		l_prog_trained = new JLabel("Trained");
		l_prog_trained.setForeground(label_color);
		l_prog_ten = new JLabel("+10");
		l_prog_ten.setForeground(label_color);
		l_prog_twenty = new JLabel("+20");
		l_prog_twenty.setForeground(label_color);
		p_prog_talents = new JPanel();
		l_prog_talent = new JLabel("Talents");
		l_prog_talent.setForeground(label_color);
		p_prog_talents_values = new JPanel();
		p_prog_psypowers = new JPanel();
		l_prog_psypower = new JLabel("Psychic Powers");
		l_prog_psypower.setForeground(label_color);
		l_prog_psyrating = new JLabel(CreationModel.PSYRATING + ":");
		l_prog_psyrating.setForeground(label_color);
		l_prog_val_psyrating = new JLabel("" + m.getCharacterValueValue(CreationModel.PSYRATING, 1));
		p_prog_psypowers_values = new JPanel();
		p_prog_soloma = new JPanel();
		l_prog_soloma = new JLabel("Solo Mode Abilities");
		l_prog_soloma.setForeground(label_color);
		p_prog_soloma_values = new JPanel();
		p_prog_equipment = new JPanel();
		l_prog_equipment = new JLabel("Equipment");
		l_prog_equipment.setForeground(label_color);
		p_prog_equipment_values = new JPanel();
		p_cre_step1 = new JPanel();
		p_cre_step2 = new JPanel();
		p_cre_step3 = new JPanel();
		p_cre_step4 = new JPanel();
		p_cre_step5 = new JPanel();
		//p_cre_step6 = new JPanel();
		//p_cre_step7 = new JPanel();
		//p_cre_step8 = new JPanel();
		p_cre_characteristics = new JPanel();
		l_cre_step1_title = new JLabel("Roll all your Characteristics", JLabel.CENTER);
		l_cre_step1_title.setFont(new Font("Sans", Font.PLAIN, 14));
		l_cre_weaponskill = new JLabel(CreationModel.WS_, JLabel.CENTER);
		l_cre_ballisticskill = new JLabel(CreationModel.BS_, JLabel.CENTER);
		l_cre_strength = new JLabel(CreationModel.S_, JLabel.CENTER);
		l_cre_toughness = new JLabel(CreationModel.T_, JLabel.CENTER);
		l_cre_agility = new JLabel(CreationModel.AGI_, JLabel.CENTER);
		l_cre_intelligence = new JLabel(CreationModel.INT_, JLabel.CENTER);
		l_cre_perception = new JLabel(CreationModel.PER_, JLabel.CENTER);
		l_cre_willpower = new JLabel(CreationModel.WP_, JLabel.CENTER);
		l_cre_fellowship = new JLabel(CreationModel.FEL_, JLabel.CENTER);
		l_cre_val_weaponskill = new JLabel();
		l_cre_val_ballisticskill = new JLabel();
		l_cre_val_strength = new JLabel();
		l_cre_val_toughness = new JLabel();
		l_cre_val_agility = new JLabel();
		l_cre_val_intelligence = new JLabel();
		l_cre_val_perception = new JLabel();
		l_cre_val_willpower = new JLabel();
		l_cre_val_fellowship = new JLabel();
		//p_cre_roll = new JPanel();
		b_cre_rerollweaponskill = new JButton("reroll");
		b_cre_rerollballisticskill = new JButton("reroll");
		b_cre_rerollstrength = new JButton("reroll");
		b_cre_rerolltoughness = new JButton("reroll");
		b_cre_rerollagility = new JButton("reroll");
		b_cre_rerollintelligence = new JButton("reroll");
		b_cre_rerollperception = new JButton("reroll");
		b_cre_rerollwillpower = new JButton("reroll");
		b_cre_rerollfellowship = new JButton("reroll");
		b_cre_rollcharacteristics = new JButton("roll all");
		l_cre_step2_title = new JLabel("Choose your Chapter", JLabel.CENTER);
		l_cre_step2_title.setFont(new Font("Sans", Font.PLAIN, 14));
		cob_cre_chpt = new JComboBox<String>();
		l_cre_step3a_title = new JLabel("Choose your Speciality", JLabel.CENTER);
		l_cre_step3a_title.setFont(new Font("Sans", Font.PLAIN, 14));
		cob_cre_spty = new JComboBox<String>();
		l_cre_step3b_title = new JLabel("Choose your Special Ability", JLabel.CENTER);
		l_cre_step3b_title.setFont(new Font("Sans", Font.PLAIN, 14));
		cob_cre_sptyspecab = new JComboBox<String>();
		l_cre_step4_title = new JLabel("Choose your specialized Tactic", JLabel.CENTER);
		l_cre_step4_title.setFont(new Font("Sans", Font.PLAIN, 14));
		cob_cre_tactics = new JComboBox<String>();
		
		//cob_cre_equipment = new JComboBox<String>();
		//cob_cre_chptdemeanours = new JComboBox<String>();
		//ta_cre_rolledname = new JTextArea("rolled name, depends on Chapter");
		//ta_cre_newname = new JTextArea("Type a name in or take the rolled name");
		cob_cre_chpt.setName("Chapter_Combobox");
		cob_cre_spty.setName("Speciality_Combobox");
		cob_cre_sptyspecab.setName("Special_Ability_Combobox");
		cob_cre_tactics.setName("Tactics_Combobox");

		Functions.putList(cob_cre_chpt, m.getChapterList());
		Functions.putList(cob_cre_spty, m.getSpecialityList());
		Functions.putList(cob_cre_tactics, m.getTacticsList());

		b_cre_rerollweaponskill.setEnabled(false);
		b_cre_rerollballisticskill.setEnabled(false);
		b_cre_rerollstrength.setEnabled(false);
		b_cre_rerolltoughness.setEnabled(false);
		b_cre_rerollagility.setEnabled(false);
		b_cre_rerollintelligence.setEnabled(false);
		b_cre_rerollperception.setEnabled(false);
		b_cre_rerollwillpower.setEnabled(false);
		b_cre_rerollfellowship.setEnabled(false);

		cob_cre_chpt.setEnabled(false);
		cob_cre_spty.setEnabled(false);
		cob_cre_sptyspecab.setEnabled(false);
		cob_cre_tactics.setEnabled(false);
		//cob_cre_chptdemeanours.setEnabled(false);
		//cob_cre_equipment.setEnabled(false);


	//	+++ Progress Panel +++

		//Title
		//setLayout for the Progress Title Panel and setConstraints for Progress Title Panel Elements
		p_prog_title.setLayout(gbl = new GridBagLayout());
		GridBagConstraints gbc = makegbc(0,0,1,1);
		gbc.insets = new Insets(5, 1, 5, 1);
		gbl.setConstraints(l_prog_title, gbc);

		//Adding the different Progress Labels to the Progress Title Panel
		p_prog_title.add(l_prog_title);

		//Description
		//setLayout for the Progress Description Panel and setConstraints for Progress Description Panel Elements
		p_prog_description.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_name, makegbc(0,0,1,1));
		gbl.setConstraints(l_prog_chapter, makegbc(0,1,1,1));
		gbl.setConstraints(l_prog_speciality, makegbc(0,2,1,1));
		gbl.setConstraints(l_prog_rank, makegbc(0,3,1,1));
		gbl.setConstraints(l_prog_xptotal, makegbc(0,4,1,1));
		gbl.setConstraints(l_prog_val_name, makegbc(1,0,1,1));
		gbl.setConstraints(l_prog_val_chapter, makegbc(1,1,1,1));
		gbl.setConstraints(l_prog_val_speciality, makegbc(1,2,1,1));
		gbl.setConstraints(l_prog_val_rank, makegbc(1,3,1,1));
		gbl.setConstraints(l_prog_val_xptotal, makegbc(1,4,1,1));
		gbl.setConstraints(l_prog_demeanour, makegbc(2,0,1,1));
		gbl.setConstraints(l_prog_chapterdemeanour, makegbc(2,1,1,1));
		gbl.setConstraints(l_prog_pastevent, makegbc(2,2,1,1));
		gbl.setConstraints(l_prog_description, makegbc(2,3,1,1));
		gbl.setConstraints(l_prog_xprest, makegbc(2,4,1,1));
		gbl.setConstraints(l_prog_val_demeanour, makegbc(3,0,1,1));
		gbl.setConstraints(l_prog_val_chapterdemeanour, makegbc(3,1,1,1));
		gbl.setConstraints(l_prog_val_pastevent, makegbc(3,2,1,1));
		gbl.setConstraints(l_prog_val_description, makegbc(3,3,1,1));
		gbl.setConstraints(l_prog_val_xprest, makegbc(3,4,1,1));

		//Adding the different Progress Labels to the Progress Description Panel
		p_prog_description.add(l_prog_name);
		p_prog_description.add(l_prog_val_name);
		p_prog_description.add(l_prog_chapter);
		p_prog_description.add(l_prog_val_chapter);
		p_prog_description.add(l_prog_speciality);
		p_prog_description.add(l_prog_val_speciality);
		p_prog_description.add(l_prog_rank);
		p_prog_description.add(l_prog_val_rank);
		p_prog_description.add(l_prog_xptotal);
		p_prog_description.add(l_prog_val_xptotal);
		p_prog_description.add(l_prog_demeanour);
		p_prog_description.add(l_prog_val_demeanour);
		p_prog_description.add(l_prog_chapterdemeanour);
		p_prog_description.add(l_prog_val_chapterdemeanour);
		p_prog_description.add(l_prog_pastevent);
		p_prog_description.add(l_prog_val_pastevent);
		p_prog_description.add(l_prog_description);
		p_prog_description.add(l_prog_val_description);
		p_prog_description.add(l_prog_xprest);
		p_prog_description.add(l_prog_val_xprest);

		//Characteristic
		//setLayout for the Progress Characteristic Panel and setConstraints for Progress Characteristic Panel Elements
		p_prog_characteristics.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_weaponskill, makegbc(0,0,1,1));
		gbl.setConstraints(l_prog_val_weaponskill, makegbc(1,0,1,1));
		gbl.setConstraints(l_prog_ballisticskill, makegbc(2,0,1,1));
		gbl.setConstraints(l_prog_val_ballisticskill, makegbc(3,0,1,1));
		gbl.setConstraints(l_prog_strength, makegbc(4,0,1,1));
		gbl.setConstraints(l_prog_val_strength, makegbc(5,0,1,1));
		gbl.setConstraints(l_prog_toughness, makegbc(6,0,1,1));
		gbl.setConstraints(l_prog_val_toughness, makegbc(7,0,1,1));
		gbl.setConstraints(l_prog_agility, makegbc(8,0,1,1));
		gbl.setConstraints(l_prog_val_agility, makegbc(9,0,1,1));
		gbl.setConstraints(l_prog_intelligence, makegbc(10,0,1,1));
		gbl.setConstraints(l_prog_val_intelligence, makegbc(11,0,1,1));
		gbl.setConstraints(l_prog_perception, makegbc(12,0,1,1));
		gbl.setConstraints(l_prog_val_perception, makegbc(13,0,1,1));
		gbl.setConstraints(l_prog_willpower, makegbc(14,0,1,1));
		gbl.setConstraints(l_prog_val_willpower, makegbc(15,0,1,1));
		gbl.setConstraints(l_prog_fellowship, makegbc(16,0,1,1));
		gbl.setConstraints(l_prog_val_fellowship, makegbc(17,0,1,1));

		//Adding the different Progress Labels to the Progress Characteristic Panel
		p_prog_characteristics.add(l_prog_weaponskill);
		p_prog_characteristics.add(l_prog_val_weaponskill);
		p_prog_characteristics.add(l_prog_ballisticskill);
		p_prog_characteristics.add(l_prog_val_ballisticskill);
		p_prog_characteristics.add(l_prog_strength);
		p_prog_characteristics.add(l_prog_val_strength);
		p_prog_characteristics.add(l_prog_toughness);
		p_prog_characteristics.add(l_prog_val_toughness);
		p_prog_characteristics.add(l_prog_agility);
		p_prog_characteristics.add(l_prog_val_agility);
		p_prog_characteristics.add(l_prog_intelligence);
		p_prog_characteristics.add(l_prog_val_intelligence);
		p_prog_characteristics.add(l_prog_perception);
		p_prog_characteristics.add(l_prog_val_perception);
		p_prog_characteristics.add(l_prog_willpower);
		p_prog_characteristics.add(l_prog_val_willpower);
		p_prog_characteristics.add(l_prog_fellowship);
		p_prog_characteristics.add(l_prog_val_fellowship);

		//Values
		//setLayout for the Progress Values Panel and setConstraints for Progress Values Panel Elements
		p_prog_values.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_wounds, makegbc(0,0,1,1));
		gbl.setConstraints(l_prog_movement, makegbc(0,1,2,1));
		gbl.setConstraints(l_prog_val_wounds, makegbc(1,0,1,1));
		gbl.setConstraints(l_prog_insanity, makegbc(2,0,1,1));
		gbl.setConstraints(l_prog_movhalf, makegbc(2,1,1,1));
		gbl.setConstraints(l_prog_val_insanity, makegbc(3,0,1,1));
		gbl.setConstraints(l_prog_val_movhalf, makegbc(3,1,1,1));
		gbl.setConstraints(l_prog_fate, makegbc(4,0,1,1));
		gbl.setConstraints(l_prog_movfull, makegbc(4,1,1,1));
		gbl.setConstraints(l_prog_val_fate, makegbc(5,0,1,1));
		gbl.setConstraints(l_prog_val_movfull, makegbc(5,1,1,1));
		gbl.setConstraints(l_prog_corruption, makegbc(6,0,1,1));
		gbl.setConstraints(l_prog_movcharge, makegbc(6,1,1,1));
		gbl.setConstraints(l_prog_val_corruption, makegbc(7,0,1,1));
		gbl.setConstraints(l_prog_val_movcharge, makegbc(7,1,1,1));
		gbl.setConstraints(l_prog_reknown, makegbc(8,0,1,1));
		gbl.setConstraints(l_prog_movrun, makegbc(8,1,1,1));
		gbl.setConstraints(l_prog_val_reknown, makegbc(9,0,1,1));
		gbl.setConstraints(l_prog_val_movrun, makegbc(9,1,1,1));

		//Adding the different Progress Labels to the Progress Values Panel
		p_prog_values.add(l_prog_wounds);
		p_prog_values.add(l_prog_val_wounds);
		p_prog_values.add(l_prog_insanity);
		p_prog_values.add(l_prog_val_insanity);
		p_prog_values.add(l_prog_fate);
		p_prog_values.add(l_prog_val_fate);
		p_prog_values.add(l_prog_corruption);
		p_prog_values.add(l_prog_val_corruption);
		p_prog_values.add(l_prog_reknown);
		p_prog_values.add(l_prog_val_reknown);
		p_prog_values.add(l_prog_movement);
		p_prog_values.add(l_prog_movhalf);
		p_prog_values.add(l_prog_val_movhalf);
		p_prog_values.add(l_prog_movfull);
		p_prog_values.add(l_prog_val_movfull);
		p_prog_values.add(l_prog_movcharge);
		p_prog_values.add(l_prog_val_movcharge);
		p_prog_values.add(l_prog_movrun);
		p_prog_values.add(l_prog_val_movrun);

		//Special Ability
		//setLayout for the Progress Special Ability Panel and setConstraints for Progress Special Ability Panel Elements
		p_prog_specialabilities.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_specialability,makegbc(0,0,2,1));

		//Adds Progress Title Label to the Progress Special Ability Panel
		p_prog_specialabilities.add(l_prog_specialability);

		//Values
		p_prog_specialabilities_values.setLayout(gbl = new GridBagLayout());

		//Trait
		//setLayout for the Progress Trait Panel and setConstraints for Progress Trait Panel Element
		p_prog_traits.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_trait,makegbc(0,0,2,1));

		//Adds Progress Title Label to the Progress Trait Panel
		p_prog_traits.add(l_prog_trait);

		//Values
		p_prog_traits_values.setLayout(gbl = new GridBagLayout());
		
		//Adding all predefined Traits as Labels
		addProgTraitLabels(gbl);

		//Skills
		//setLayout for the Progress Skills Panel and setConstraints for Progress Skills Panel Elements
		p_prog_skills.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_skill,makegbc(0,0,2,1));
		
		//Adds Progress Title Label to the Progress Skills Panel
		p_prog_skills.add(l_prog_skill);

		//Values
		p_prog_skills_values.setLayout(gbl = new GridBagLayout());
		
		//Adding all predefined Skills as Labels
		addProgSkillLabels(gbl);
		
		//Talents
		//setLayout for the Progress Talents Panel and setConstraints for Progress Talents Panel Elements
		p_prog_talents.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_talent,makegbc(0,0,2,1));

		//Adds Progress Title Label to the Progress Talents Panel
		p_prog_talents.add(l_prog_talent);

		//Values
		p_prog_talents_values.setLayout(gbl = new GridBagLayout());

		//Adding all predefined Talents as Labels
		addProgTalentLabels(gbl);
		
		//Psypowers
		//setLayout for the Progress Psypowers Panel and setConstraints for Progress Psypowers Panel Elements
		p_prog_psypowers.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_psypower,makegbc(0,0,2,1));
		gbl.setConstraints(l_prog_psyrating,makegbc(2,0,1,1));
		gbl.setConstraints(l_prog_val_psyrating,makegbc(3,0,1,1));

		//Adds Progress Title Label to the Progress Psychic Powers Panel
		p_prog_psypowers.add(l_prog_psypower);
		p_prog_psypowers.add(l_prog_psyrating);
		p_prog_psypowers.add(l_prog_val_psyrating);

		//Values
		p_prog_psypowers_values.setLayout(gbl = new GridBagLayout());

		//Solo Mode Ability
		//setLayout for the Progress Solo Mode Ability Panel and setConstraints for Progress Solo Mode Ability Panel Elements
		p_prog_soloma.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_soloma,makegbc(0,0,2,1));

		//Adds Progress Title Label to the Progress Solo Mode Ability Panel
		p_prog_soloma.add(l_prog_soloma);

		//Values
		p_prog_soloma_values.setLayout(gbl = new GridBagLayout());

		//Adding all predefined Solo Mode Abilities as Labels
		addProgSoloModeAbilityLabels(gbl);

		//Equipment
		//setLayout for the Progress Equipment Panel and setConstraints for Progress Equipment Panel Elements
		p_prog_equipment.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_prog_equipment,makegbc(0,0,2,1));

		//Adds Progress Title Label to the Progress Equipment Panel
		p_prog_equipment.add(l_prog_equipment);

		//Values
		p_prog_equipment_values.setLayout(gbl = new GridBagLayout());

		//Progress
		//setLayout for the Progress Panel and setConstraints for Progress Topic Elements
		p_prog.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(p_prog_title, makegbc(0,0,1,1));
		gbl.setConstraints(p_prog_description, makegbc(0,1,1,1));
		gbl.setConstraints(p_prog_characteristics,makegbc(0,2,1,1));
		gbl.setConstraints(p_prog_values,makegbc(0,3,1,1));
		gbl.setConstraints(p_prog_specialabilities,makegbc(0,4,1,1));
		gbl.setConstraints(p_prog_specialabilities_values,makegbc(0,5,1,1));
		gbl.setConstraints(p_prog_traits,makegbc(0,6,1,1));
		gbl.setConstraints(p_prog_traits_values,makegbc(0,7,1,1));		
		gbl.setConstraints(p_prog_skills,makegbc(0,8,1,1));
		gbl.setConstraints(p_prog_skills_values,makegbc(0,9,1,1));
		gbl.setConstraints(p_prog_talents,makegbc(0,10,1,1));
		gbl.setConstraints(p_prog_talents_values,makegbc(0,11,1,1));
		gbl.setConstraints(p_prog_psypowers,makegbc(0,12,1,1));
		gbl.setConstraints(p_prog_psypowers_values,makegbc(0,13,1,1));
		gbl.setConstraints(p_prog_soloma,makegbc(0,14,1,1));
		gbl.setConstraints(p_prog_soloma_values,makegbc(0,15,1,1));
		gbl.setConstraints(p_prog_equipment,makegbc(0,16,1,1));
		gbl.setConstraints(p_prog_equipment_values,makegbc(0,17,1,1));

		//Adding the different Progress-Topic-Panels to the Progress Panel
		p_prog.add(p_prog_title);
		p_prog.add(p_prog_description);
		p_prog.add(p_prog_characteristics);
		p_prog.add(p_prog_values);
		p_prog.add(p_prog_specialabilities);
		p_prog.add(p_prog_specialabilities_values);
		p_prog.add(p_prog_traits);
		p_prog.add(p_prog_traits_values);
		p_prog.add(p_prog_skills);
		p_prog.add(p_prog_skills_values);
		p_prog.add(p_prog_talents);
		p_prog.add(p_prog_talents_values);
		p_prog.add(p_prog_psypowers);
		p_prog.add(p_prog_psypowers_values);
		p_prog.add(p_prog_soloma);
		p_prog.add(p_prog_soloma_values);
		p_prog.add(p_prog_equipment);
		p_prog.add(p_prog_equipment_values);
		

	//	+++ Creation Panel +++

		//Step 1
		
		//addActionCommands to all Creation Buttons Step 1
		b_cre_rerollweaponskill.setActionCommand("Reroll " + CreationModel.WEAPONSKILL);
		b_cre_rerollballisticskill.setActionCommand("Reroll " + CreationModel.BALLISTICSKILL);
		b_cre_rerollstrength.setActionCommand("Reroll " + CreationModel.STRENGTH);
		b_cre_rerolltoughness.setActionCommand("Reroll " + CreationModel.TOUGHNESS);
		b_cre_rerollagility.setActionCommand("Reroll " + CreationModel.AGILITY);
		b_cre_rerollintelligence.setActionCommand("Reroll " + CreationModel.INTELLIGENCE);
		b_cre_rerollperception.setActionCommand("Reroll " + CreationModel.PERCEPTION);
		b_cre_rerollwillpower.setActionCommand("Reroll " + CreationModel.WILLPOWER);
		b_cre_rerollfellowship.setActionCommand("Reroll " + CreationModel.FELLOWSHIP);
		b_cre_rollcharacteristics.setActionCommand("Roll all Characteristics");

		//addActionListener to all Creation Buttons Step 1
		b_cre_rerollweaponskill.addActionListener(control);
		b_cre_rerollballisticskill.addActionListener(control);
		b_cre_rerollstrength.addActionListener(control);
		b_cre_rerolltoughness.addActionListener(control);
		b_cre_rerollagility.addActionListener(control);
		b_cre_rerollintelligence.addActionListener(control);
		b_cre_rerollperception.addActionListener(control);
		b_cre_rerollwillpower.addActionListener(control);
		b_cre_rerollfellowship.addActionListener(control);
		b_cre_rollcharacteristics.addActionListener(control);

		//setToolTipText to all Creation Elements Step 1
		b_cre_rerollweaponskill.setToolTipText("Reroll " + CreationModel.WEAPONSKILL);
		b_cre_rerollballisticskill.setToolTipText("Reroll " + CreationModel.BALLISTICSKILL);
		b_cre_rerollstrength.setToolTipText("Reroll " + CreationModel.STRENGTH);
		b_cre_rerolltoughness.setToolTipText("Reroll " + CreationModel.TOUGHNESS);
		b_cre_rerollagility.setToolTipText("Reroll " + CreationModel.AGILITY);
		b_cre_rerollintelligence.setToolTipText("Reroll " + CreationModel.INTELLIGENCE);
		b_cre_rerollperception.setToolTipText("Reroll " + CreationModel.PERCEPTION);
		b_cre_rerollwillpower.setToolTipText("Reroll " + CreationModel.WILLPOWER);
		b_cre_rerollfellowship.setToolTipText("Reroll " + CreationModel.FELLOWSHIP);
		b_cre_rollcharacteristics.setToolTipText("Roll all Characteristics");
		l_cre_weaponskill.setToolTipText(CreationModel.WEAPONSKILL);
		l_cre_ballisticskill.setToolTipText(CreationModel.BALLISTICSKILL);
		l_cre_strength.setToolTipText(CreationModel.STRENGTH);
		l_cre_toughness.setToolTipText(CreationModel.TOUGHNESS);
		l_cre_agility.setToolTipText(CreationModel.AGILITY);
		l_cre_intelligence.setToolTipText(CreationModel.INTELLIGENCE);
		l_cre_perception.setToolTipText(CreationModel.PERCEPTION);
		l_cre_willpower.setToolTipText(CreationModel.WILLPOWER);
		l_cre_fellowship.setToolTipText(CreationModel.FELLOWSHIP);
		
		//setLayout for Creation Panel Step 1 and setConstraints for Creation Elements Step 1 
		p_cre_step1.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_cre_step1_title, makegbc(0,0,9,1));
		gbl.setConstraints(l_cre_weaponskill, makegbc(0,1,1,1));
		gbl.setConstraints(l_cre_ballisticskill, makegbc(1,1,1,1));
		gbl.setConstraints(l_cre_strength, makegbc(2,1,1,1));
		gbl.setConstraints(l_cre_toughness, makegbc(3,1,1,1));
		gbl.setConstraints(l_cre_agility, makegbc(4,1,1,1));
		gbl.setConstraints(l_cre_intelligence, makegbc(5,1,1,1));
		gbl.setConstraints(l_cre_perception, makegbc(6,1,1,1));
		gbl.setConstraints(l_cre_willpower, makegbc(7,1,1,1));
		gbl.setConstraints(l_cre_fellowship, makegbc(8,1,1,1));
		gbl.setConstraints(l_cre_val_weaponskill, makegbc(0,2,1,1));
		gbl.setConstraints(l_cre_val_ballisticskill, makegbc(1,2,1,1));
		gbl.setConstraints(l_cre_val_strength, makegbc(2,2,1,1));
		gbl.setConstraints(l_cre_val_toughness, makegbc(3,2,1,1));
		gbl.setConstraints(l_cre_val_agility, makegbc(4,2,1,1));
		gbl.setConstraints(l_cre_val_intelligence, makegbc(5,2,1,1));
		gbl.setConstraints(l_cre_val_perception, makegbc(6,2,1,1));
		gbl.setConstraints(l_cre_val_willpower, makegbc(7,2,1,1));
		gbl.setConstraints(l_cre_val_fellowship, makegbc(8,2,1,1));
		gbl.setConstraints(b_cre_rerollweaponskill, makegbc(0,3,1,1));
		gbl.setConstraints(b_cre_rerollballisticskill, makegbc(1,3,1,1));
		gbl.setConstraints(b_cre_rerollstrength, makegbc(2,3,1,1));
		gbl.setConstraints(b_cre_rerolltoughness, makegbc(3,3,1,1));
		gbl.setConstraints(b_cre_rerollagility, makegbc(4,3,1,1));
		gbl.setConstraints(b_cre_rerollintelligence, makegbc(5,3,1,1));
		gbl.setConstraints(b_cre_rerollperception, makegbc(6,3,1,1));
		gbl.setConstraints(b_cre_rerollwillpower, makegbc(7,3,1,1));
		gbl.setConstraints(b_cre_rerollfellowship, makegbc(8,3,1,1));
		gbl.setConstraints(b_cre_rollcharacteristics, makegbc(4,4,1,1));

		//Adding the different Creation Elements Step 1 to the Creation Step 1 Panel
		p_cre_step1.add(l_cre_step1_title);
		p_cre_step1.add(l_cre_weaponskill);
		p_cre_step1.add(l_cre_ballisticskill);
		p_cre_step1.add(l_cre_strength);
		p_cre_step1.add(l_cre_toughness);
		p_cre_step1.add(l_cre_agility);
		p_cre_step1.add(l_cre_intelligence);
		p_cre_step1.add(l_cre_perception);
		p_cre_step1.add(l_cre_willpower);
		p_cre_step1.add(l_cre_fellowship);
		p_cre_step1.add(l_cre_val_weaponskill);
		p_cre_step1.add(l_cre_val_ballisticskill);
		p_cre_step1.add(l_cre_val_strength);
		p_cre_step1.add(l_cre_val_toughness);
		p_cre_step1.add(l_cre_val_agility);
		p_cre_step1.add(l_cre_val_intelligence);
		p_cre_step1.add(l_cre_val_perception);
		p_cre_step1.add(l_cre_val_willpower);
		p_cre_step1.add(l_cre_val_fellowship);
		p_cre_step1.add(b_cre_rerollweaponskill);
		p_cre_step1.add(b_cre_rerollballisticskill);
		p_cre_step1.add(b_cre_rerollstrength);
		p_cre_step1.add(b_cre_rerolltoughness);
		p_cre_step1.add(b_cre_rerollagility);
		p_cre_step1.add(b_cre_rerollintelligence);
		p_cre_step1.add(b_cre_rerollperception);
		p_cre_step1.add(b_cre_rerollwillpower);
		p_cre_step1.add(b_cre_rerollfellowship);
		p_cre_step1.add(b_cre_rollcharacteristics);
		
		//Step 2
		//setLayout for Creation Panel Step 2 and setConstraints for Creation Elements Step 2 
		p_cre_step2.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_cre_step2_title, makegbc(0,0,1,1));
		gbl.setConstraints(cob_cre_chpt, makegbc(0,1,1,1));

		cob_cre_chpt.setToolTipText("Choose your Chapter");
		cob_cre_chpt.setSelectedItem("");

		//Adding the different Creation Elements Step 2 to the Creation Step 2 Panel
		p_cre_step2.add(l_cre_step2_title);
		p_cre_step2.add(cob_cre_chpt);
			
		//Step 3
		//setLayout for Creation Panel Step 3 and setConstraints for Creation Elements Step 3 
		p_cre_step3.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_cre_step3a_title, makegbc(0,0,1,1));
		gbl.setConstraints(cob_cre_spty, makegbc(0,1,1,1));
		gbl.setConstraints(l_cre_step3b_title, makegbc(0,2,1,1));
		gbl.setConstraints(cob_cre_sptyspecab, makegbc(0,3,1,1));

		cob_cre_spty.setToolTipText("Choose your Speciality");
		cob_cre_sptyspecab.setToolTipText("Choose your Special Ability");
		cob_cre_spty.setSelectedItem("");

		//Adding the different Creation Elements Step 3 to the Creation Step 3 Panel
		p_cre_step3.add(l_cre_step3a_title);
		p_cre_step3.add(cob_cre_spty);
		p_cre_step3.add(l_cre_step3b_title);
		p_cre_step3.add(cob_cre_sptyspecab);

		//Step 4
		//setLayout for Creation Panel Step 4 and setConstraints for Creation Elements Step 4 
		p_cre_step4.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(l_cre_step4_title, makegbc(0,0,1,1));
		gbl.setConstraints(cob_cre_tactics, makegbc(0,1,1,1));
		
		cob_cre_tactics.setToolTipText("Choose your specialized Tactic");
		cob_cre_tactics.setSelectedItem("");
		
		//Adding the different Creation Elements Step 4 to the Creation Step 4 Panel
		p_cre_step4.add(l_cre_step4_title);
		p_cre_step4.add(cob_cre_tactics);

		//Step 5
		//setLayout for Creation Panel Step 5 and setConstraints for Creation Elements Step 5 
		p_cre_step5.setLayout(gbl = new GridBagLayout());

		//Adding the different Creation Elements Step 5 to the Creation Step 5 Panel
		addCreAdvances(gbl, false);

		//Step 6
		//setLayout for Creation Panel Step 6 and setConstraints for Creation Elements Step 6 
		//p_cre_step6.setLayout(gbl = new GridBagLayout());
		//gbl.setConstraints(cob_cre_equipment, makegbc(0,0,1,1));

		//Adding the different Creation Elements Step 6 to the Creation Step 6 Panel
		//p_cre_step6.add(cob_cre_equipment);

		//Step 7
		//setLayout for Creation Panel Step 7 and setConstraints for Creation Elements Step 7 
		//p_cre_step7.setLayout(gbl = new GridBagLayout());
		//gbl.setConstraints(cob_cre_chptdemeanours, makegbc(0,0,1,1));

		//Adding the different Creation Elements Step 7 to the Creation Step 7 Panel
		//p_cre_step7.add(cob_cre_chptdemeanours);

		//Step 8
		//setLayout for Creation Panel Step 8 and setConstraints for Creation Elements Step 8 
		//p_cre_step8.setLayout(gbl = new GridBagLayout());
		//gbl.setConstraints(ta_cre_rolledname, makegbc(0,0,1,1));
		//gbl.setConstraints(ta_cre_newname, makegbc(0,1,1,1));
		
		//ta_cre_rolledname.setPreferredSize(new Dimension(0,0));
		//ta_cre_newname.setPreferredSize(new Dimension(0,0));

		//Adding the different Creation Elements Step 8 to the Creation Step 8 Panel
		//p_cre_step8.add(ta_cre_rolledname);
		//p_cre_step8.add(ta_cre_newname);


		//Creation Panel
		//setLayout for the Creation Panel and setConstraints for Creation Panel Step 1-8 Elements
		p_cre.setLayout(gbl = new GridBagLayout());
		gbl.setConstraints(p_cre_step1, makegbc(0,0,1,1));
		gbl.setConstraints(p_cre_step2, makegbc(0,1,1,1));
		gbl.setConstraints(p_cre_step3, makegbc(0,2,1,1));
		gbl.setConstraints(p_cre_step4, makegbc(0,3,1,1));
		gbl.setConstraints(p_cre_step5, makegbc(0,4,1,1));
		//gbl.setConstraints(p_cre_step6, makegbc(0,5,1,1));
		//gbl.setConstraints(p_cre_step7, makegbc(0,6,1,1));
		//gbl.setConstraints(p_cre_step8, makegbc(0,7,1,1));
		
		//Adding the Creation Panel Step 1-8 to the Creation Panel
		p_cre.add(p_cre_step1);
		p_cre.add(p_cre_step2);
		p_cre.add(p_cre_step3);
		p_cre.add(p_cre_step4);
		p_cre.add(p_cre_step5);
		//p_cre.add(p_cre_step6);
		//p_cre.add(p_cre_step7);
		//p_cre.add(p_cre_step8);

		
	//	+++ General +++

		//addItemListener to all Comboboxes
		cob_cre_chpt.addItemListener(control);
		cob_cre_spty.addItemListener(control);
		cob_cre_sptyspecab.addItemListener(control);
		cob_cre_tactics.addItemListener(control);

		//set Scrollpanes Progress and Creation for SplitPane North to use
		spi_cre.setLeftComponent(sp_prog);
		spi_cre.setRightComponent(sp_cre);
		spi_cre.setOneTouchExpandable(true);

		//set minimum and preferred size for Progress Scrollpane and Creation Scrollpane
		sp_prog.setMinimumSize(new Dimension(550,400));
		sp_cre.setMinimumSize(new Dimension(350,400));
		sp_prog.setPreferredSize(new Dimension(600,800));
		sp_cre.setPreferredSize(new Dimension(800,800));

		//Layout for TheGeneratePanel
		this.setLayout(new BorderLayout());

		this.add(spi_cre, BorderLayout.CENTER);
	}


//	+++ METHODS +++

	//Just to not have "Functions.makegbc()" everywhere
	private GridBagConstraints makegbc(int x, int y, int width, int height) {
		return Functions.makegbc(x, y, width, height);
	}

	private void addProgSpecialAbilityLabels(GridBagLayout gbl) {
		if (m.hasSpeciality()) {
			if (m.getSpeciality().hasSpecialAbilities()) {
				int y = 0;
				int x = 0;

				for (SpecialAbility sa : m.getSpecialAbilities()) {
					JLabel name = new JLabel(sa.getName());

					gbl.setConstraints(name, makegbc(x,y,1,1));
					p_prog_specialabilities_values.add(name);

					if (x == 0)
						x++;
					else
						x--;
					if (x % 2 != 1)
						y++;
				}
			}
		}
	}

	private void addProgTraitLabels(GridBagLayout gbl) {
		int y = 0;
		int x = 0;

		for (Trait t : m.getTraits()) {
			JLabel name = new JLabel(t.getKeyName());

			gbl.setConstraints(name, makegbc(x,y,1,1));
			p_prog_traits_values.add(name);

			if (x == 0)
				x++;
			else
				x--;
			if (x % 2 == 0)
				y++;
		}
	}

	private void addProgSkillLabels(GridBagLayout gbl) {
		gbl.setConstraints(l_prog_basic,makegbc(2,0,1,1));
		gbl.setConstraints(l_prog_trained,makegbc(3,0,1,1));
		gbl.setConstraints(l_prog_ten,makegbc(4,0,1,1));
		gbl.setConstraints(l_prog_twenty,makegbc(5,0,1,1));

		p_prog_skills_values.add(l_prog_basic);
		p_prog_skills_values.add(l_prog_trained);
		p_prog_skills_values.add(l_prog_ten);
		p_prog_skills_values.add(l_prog_twenty);

		int y = 1;

		for (Skill s : m.getSkills()) {
			JLabel name = new JLabel(s.getKeyName());
			JLabel basic = new JLabel(s.isBasic() ? CreationModel.MARK : CreationModel.DEMARK);
			JLabel trained = new JLabel(s.isTrained() ? CreationModel.MARK : CreationModel.DEMARK);
			JLabel ten = new JLabel(CreationModel.DEMARK);
			JLabel twenty = new JLabel(CreationModel.DEMARK);

			switch(s.getBonus()) {
				case 10: ten.setText(CreationModel.MARK); break;
				case 20: twenty.setText(CreationModel.MARK); break;
				default:break;
			}

			JLabel[] labels = {name, basic, trained, ten, twenty};
			for (int x = 0; x <= 4; x++) {
				gbl.setConstraints(labels[x], makegbc(x == 0 ? x : x + 1, y, x == 0 ? 2 : 1, 1));
			}

			p_prog_skills_values.add(name);
			p_prog_skills_values.add(basic);
			p_prog_skills_values.add(trained);
			p_prog_skills_values.add(ten);
			p_prog_skills_values.add(twenty);
			
			y++;
		}
	}
		
	private void addProgTalentLabels(GridBagLayout gbl) {
		int y = 0;
		int x = 0;

		for (Talent t : m.getTalents()) {
			if (t.getKeyName().indexOf(CreationModel.PSYCHICTECHNIQUE) == -1) {
				JLabel name = new JLabel(t.getKeyName());
				gbl.setConstraints(name, makegbc(x,y,1,1));
				p_prog_talents_values.add(name);

				if (x == 0)
					x++;
				else
					x--;
				if (x % 2 == 0)
					y++;
			}
		}
	}
		
//	private void addProgPsychicPowerLabels(GridBagLayout gbl) {
//		if ((Talent) Functions.getSpecific(m.getTalents(), CreationModel.PSYRATING + " (-)") != null) {
//			int y = 0;
//			int x = 0;
//
//			for (Talent t : m.getTalents()) {
//				if (t.getKeyName().indexOf(CreationModel.PSYCHICTECHNIQUE) != -1) {
//					JLabel name = new JLabel(t.getKeyName());
//					gbl.setConstraints(name, makegbc(x,y,1,1));
//					p_prog_psypowers_values.add(name);
//
//					if (x == 0)
//						x++;
//					else
//						x--;
//					if (x % 2 == 0)
//						y++;
//				}
//			}
//		}
//	}
		
	private void addProgSoloModeAbilityLabels(GridBagLayout gbl) {
		int y = 0;
		int x = 0;

		for (SoloModeAbility sma : m.getSoloModeAbilities()) {
			JLabel name = new JLabel(sma.getName());

			gbl.setConstraints(name, makegbc(x,y,1,1));
			p_prog_soloma_values.add(name);

			if (x == 0)
				x++;
			else
				x--;
			if (x % 2 == 0)
				y++;
		}
	}

	private void addCreAdvances(GridBagLayout gbl, boolean box_enabled) {
		int y = 0;

		JLabel deathwatch_advances_title = new JLabel(CreationModel.DEATHWATCH + " Advances");
		deathwatch_advances_title.setForeground(label_color);
		gbl.setConstraints(deathwatch_advances_title, makegbc(0,y,8,1));
		p_cre_step5.add(deathwatch_advances_title);
		y = addCreClassificationAdvances(m.getAvailableDeathwatchAdvances(), gbl, box_enabled, y);

		JLabel spacemarine_advances_title = new JLabel(CreationModel.SPACEMARINE + " Advances");
		spacemarine_advances_title.setForeground(label_color); 
		gbl.setConstraints(spacemarine_advances_title, makegbc(0,y,8,1));
		p_cre_step5.add(spacemarine_advances_title);
		y = addCreClassificationAdvances(m.getAvailableSpacemarineAdvances(), gbl, box_enabled, y);

		if (m.hasChapter()) {
			JLabel chapter_advances_title = new JLabel(m.getChapter().getName() + " Advances");
			chapter_advances_title.setForeground(label_color); 
			gbl.setConstraints(chapter_advances_title, makegbc(0,y,8,1));
			p_cre_step5.add(chapter_advances_title);
			y = addCreClassificationAdvances(m.getChapter().getAdvances(), gbl, box_enabled, y);
		}

		if (m.hasSpeciality()) {
			JLabel speciality_advances_title = new JLabel(m.getSpeciality().getName() + " Advances");
			speciality_advances_title.setForeground(label_color); 
			gbl.setConstraints(speciality_advances_title, makegbc(0,y,8,1));
			p_cre_step5.add(speciality_advances_title);
			y = addCreClassificationAdvances(m.getSpeciality().getAdvances(), gbl, box_enabled, y);
		}
	}

	private int addCreClassificationAdvances(ArrayList<Advance> al, GridBagLayout gbl, boolean box_enabled, int y) {
		int x = 0;
		y++;
		JLabel left_title_name = new JLabel("Name");
		left_title_name.setForeground(label_color);
		JLabel left_title_cost = new JLabel("Cost");
		left_title_cost.setForeground(label_color);
		JLabel right_title_name = new JLabel("Name");
		right_title_name.setForeground(label_color);
		JLabel right_title_cost = new JLabel("Cost");
		right_title_cost.setForeground(label_color);
		gbl.setConstraints(left_title_name, makegbc(x,y,2,1));
		x += 2;
		gbl.setConstraints(left_title_cost, makegbc(x,y,2,1));
		x += 2;
		gbl.setConstraints(right_title_name, makegbc(x,y,2,1));
		x += 2;
		gbl.setConstraints(right_title_cost, makegbc(x,y,2,1));
		x = 0;
		y++;
		p_cre_step5.add(left_title_name);
		p_cre_step5.add(left_title_cost);
		p_cre_step5.add(right_title_name);
		p_cre_step5.add(right_title_cost);

		for (Advance a : al) {
			Advance ea = (Advance) Functions.getSpecific(m.getAdvances(), a.getKeyName());
			JLabel name = new JLabel(a.getName());
			JLabel cost = new JLabel(""+a.getCost());
			JCheckBox box = new JCheckBox();
			if (ea != null)
				box.setSelected(true);
			if (a.getCost() <= m.getCharacterValueValue(CreationModel.XPREST, 1) || ea != null)
				box.setEnabled(box_enabled);
			else
				box.setEnabled(false);
			box.setName(a.getKeyName());
			box.setToolTipText("advance your Character with" + a.getKeyName());
			box.addItemListener(control);
			gbl.setConstraints(name, makegbc(x,y,2,1));
			x += 2;
			gbl.setConstraints(cost, makegbc(x,y,1,1));
			x++;
			gbl.setConstraints(box, makegbc(x,y,1,1));
			p_cre_step5.add(name);
			p_cre_step5.add(cost);
			p_cre_step5.add(box);

			if (x == 7) {
				x = 0;
				y++;
			}else
				x++;
		}
		y++;
		return y;
	}

	@Override
	public void update(Observable model, Object arg) {
		CreationModel om = (CreationModel) model;
		String flag = om.getFlag();

		switch(flag) {

			case "All Characteristics Rolled": 
				//deactivate rollall Button
				b_cre_rollcharacteristics.setEnabled(false);
				//activate the reroll Buttons
				b_cre_rerollweaponskill.setEnabled(true);
				b_cre_rerollballisticskill.setEnabled(true);
				b_cre_rerollstrength.setEnabled(true);
				b_cre_rerolltoughness.setEnabled(true);
				b_cre_rerollagility.setEnabled(true);
				b_cre_rerollintelligence.setEnabled(true);
				b_cre_rerollperception.setEnabled(true);
				b_cre_rerollwillpower.setEnabled(true);
				b_cre_rerollfellowship.setEnabled(true);
				refreshCharacteristicValues();
				break;
			
			case "One Characteristic Rerolled": 
				//deactivate Reroll Buttons
				b_cre_rerollweaponskill.setEnabled(false);
				b_cre_rerollballisticskill.setEnabled(false);
				b_cre_rerollstrength.setEnabled(false);
				b_cre_rerolltoughness.setEnabled(false);
				b_cre_rerollagility.setEnabled(false);
				b_cre_rerollintelligence.setEnabled(false);
				b_cre_rerollperception.setEnabled(false);
				b_cre_rerollwillpower.setEnabled(false);
				b_cre_rerollfellowship.setEnabled(false);
				cob_cre_chpt.setEnabled(true);
				refreshCharacteristicValues();
				break;
			
			case CreationModel.CHAPTER: 
				if (!cob_cre_spty.isEnabled()) {
					//just to prevent further handling while the creation proceeds
					cob_cre_spty.setEnabled(true);
				}
				//remove Item Listener for Items affected of change
				cob_cre_spty.removeItemListener(control);
				cob_cre_sptyspecab.removeItemListener(control);
				Functions.putList(cob_cre_spty, om.getSpecialityList());
				if(om.hasSpeciality())
					cob_cre_spty.setSelectedItem(om.getSpeciality().getName());
				else {
					refreshTraitLabels();
					refreshSkillLabels();
					refreshSpecialAbilitiesLabels();
					cob_cre_sptyspecab.removeAllItems();
					cob_cre_sptyspecab.setEnabled(false);
				}
				//add removed Item-Listener
				cob_cre_spty.addItemListener(control);
				cob_cre_sptyspecab.addItemListener(control);

				
				refreshCharacterInformations();
				refreshCharacterValueValues();
				refreshCharacteristicValues();
				refreshSoloModeAbilityLabels();
				refreshAvailableAdvances(false);
				refreshTalentLabels();
				break;

			case CreationModel.SPECIALITY: 
				//security measure 
				cob_cre_chpt.setEnabled(false);

				if (!cob_cre_sptyspecab.isEnabled()) {
					cob_cre_sptyspecab.setEnabled(true);
				}

				Functions.putList(cob_cre_sptyspecab, om.getSpecialAbilityList());
				refreshCharacterInformations();
				refreshSpecialAbilitiesLabels();
				refreshTalentLabels();
				refreshTraitLabels();
				refreshSkillLabels();
				refreshAvailableAdvances(false);
				break;

			case CreationModel.SPECIALABILITY: 
				//security measure 
				cob_cre_spty.setEnabled(false);

				refreshAvailableAdvances(false);
				refreshSpecialAbilitiesLabels();
				refreshTalentLabels();
				refreshTraitLabels();
				if (!cob_cre_tactics.isEnabled()) {
					cob_cre_tactics.setEnabled(true);
				}
				break;
			case "Tactic": 
				//security measure 
				cob_cre_sptyspecab.setEnabled(false);

				refreshSkillLabels();
				refreshAvailableAdvances(true);
				//security measure 
				cob_cre_tactics.setEnabled(false);
				break;
			case "Advance":
				refreshAvailableAdvances(true);
				refreshSkillLabels();
				refreshTalentLabels();
				refreshCharacteristicValues();
				refreshCharacterValueValues();
				break;
			case "Advances unchanged":
				JOptionPane.showMessageDialog(null, "The Character already has this Skill or Talent you tried to add.");
				break;
			default: break;
		}
	}

	private void refreshCharacterInformations() {
		l_prog_val_name.setText("" + m.getName());
		l_prog_val_demeanour.setText("" + m.getDemeanour());
		if (m.hasChapter()) {
			l_prog_val_chapter.setText("" + m.getChapter().getName());
			l_prog_val_chapterdemeanour.setText("" + m.getChapter().getDemeanour());
		} else {
			l_prog_val_chapter.setText("");
			l_prog_val_chapterdemeanour.setText("");
		}
		if (m.hasSpeciality())
			l_prog_val_speciality.setText("" + m.getSpeciality().getName());
		else
			l_prog_val_speciality.setText("");
		l_prog_val_pastevent.setText("" + m.getPastEvent());
		l_prog_val_description.setText("" + m.getDescription());
	}

	private void refreshCharacteristicValues() {
		l_cre_val_weaponskill.setText("" + (m.getCharacteristicValue(CreationModel.WEAPONSKILL)));
		l_cre_val_ballisticskill.setText("" + (m.getCharacteristicValue(CreationModel.BALLISTICSKILL)));
		l_cre_val_strength.setText("" + (m.getCharacteristicValue(CreationModel.STRENGTH)));
		l_cre_val_toughness.setText("" + (m.getCharacteristicValue(CreationModel.TOUGHNESS)));
		l_cre_val_agility.setText("" + (m.getCharacteristicValue(CreationModel.AGILITY)));
		l_cre_val_intelligence.setText("" + (m.getCharacteristicValue(CreationModel.INTELLIGENCE)));
		l_cre_val_perception.setText("" + (m.getCharacteristicValue(CreationModel.PERCEPTION)));
		l_cre_val_willpower.setText("" + (m.getCharacteristicValue(CreationModel.WILLPOWER)));
		l_cre_val_fellowship.setText("" + (m.getCharacteristicValue(CreationModel.FELLOWSHIP)));

		l_prog_val_weaponskill.setText("" + (m.getCharacteristicValue(CreationModel.WEAPONSKILL)));
		l_prog_val_ballisticskill.setText("" + (m.getCharacteristicValue(CreationModel.BALLISTICSKILL)));
		l_prog_val_strength.setText("" + (m.getCharacteristicValue(CreationModel.STRENGTH)));
		l_prog_val_toughness.setText("" + (m.getCharacteristicValue(CreationModel.TOUGHNESS)));
		l_prog_val_agility.setText("" + (m.getCharacteristicValue(CreationModel.AGILITY)));
		l_prog_val_intelligence.setText("" + (m.getCharacteristicValue(CreationModel.INTELLIGENCE)));
		l_prog_val_perception.setText("" + (m.getCharacteristicValue(CreationModel.PERCEPTION)));
		l_prog_val_willpower.setText("" + (m.getCharacteristicValue(CreationModel.WILLPOWER)));
		l_prog_val_fellowship.setText("" + (m.getCharacteristicValue(CreationModel.FELLOWSHIP)));
	}

	private void refreshCharacterValueValues() {
		l_prog_val_wounds.setText("" + (m.getCharacterValueValue(CreationModel.WOUNDS, 1)));
		l_prog_val_insanity.setText("" + (m.getCharacterValueValue(CreationModel.INSANITY, 1)));
		l_prog_val_movhalf.setText("" + (m.getCharacterValueValue(CreationModel.MOVEMENT, 1)));
		l_prog_val_movfull.setText("" + (m.getCharacterValueValue(CreationModel.MOVEMENT, 2)));
		l_prog_val_movcharge.setText("" + (m.getCharacterValueValue(CreationModel.MOVEMENT, 3)));
		l_prog_val_movrun.setText("" + (m.getCharacterValueValue(CreationModel.MOVEMENT, 4)));
		l_prog_val_fate.setText("" + (m.getCharacterValueValue(CreationModel.FATE, 1)));
		l_prog_val_corruption.setText("" + (m.getCharacterValueValue(CreationModel.CORRUPTION, 1)));
		l_prog_val_rank.setText("" + (m.getCharacterValueValue(CreationModel.RANK, 1)));
		l_prog_val_xprest.setText("" + (m.getCharacterValueValue(CreationModel.XPREST, 1)));
		l_prog_val_xptotal.setText("" + (m.getCharacterValueValue(CreationModel.XPTOTAL, 1)));
		l_prog_val_reknown.setText("" + (m.getCharacterValueValue(CreationModel.REKNOWN, 1)));
		l_prog_val_psyrating.setText("" + (m.getCharacterValueValue(CreationModel.PSYRATING, 1)));
	}

	private void refreshTalentLabels() {
		p_prog_talents_values.removeAll();
		GridBagLayout gbl = (GridBagLayout) p_prog_talents_values.getLayout();
		addProgTalentLabels(gbl);
		p_prog_talents_values.revalidate();
	}

	private void refreshTraitLabels() {
		p_prog_traits_values.removeAll();
		GridBagLayout gbl = (GridBagLayout) p_prog_traits_values.getLayout();
		addProgTraitLabels(gbl);
		p_prog_traits_values.revalidate();
	}

	private void refreshSoloModeAbilityLabels() {
		p_prog_soloma_values.removeAll();
		GridBagLayout gbl = (GridBagLayout) p_prog_soloma_values.getLayout();
		addProgSoloModeAbilityLabels(gbl);
		p_prog_soloma_values.revalidate();
	}

	private void refreshSkillLabels() {
		p_prog_skills_values.removeAll();
		GridBagLayout gbl = (GridBagLayout) p_prog_skills_values.getLayout();
		addProgSkillLabels(gbl);
		p_prog_skills_values.revalidate();
	}

	private void refreshSpecialAbilitiesLabels() {
		p_prog_specialabilities_values.removeAll();
		GridBagLayout gbl = (GridBagLayout) p_prog_specialabilities_values.getLayout();
		addProgSpecialAbilityLabels(gbl);
		p_prog_specialabilities_values.revalidate();
	}

	private void refreshAvailableAdvances(boolean box_enabled) {
		p_cre_step5.removeAll();
		GridBagLayout gbl = (GridBagLayout) p_cre_step5.getLayout();
		addCreAdvances(gbl, box_enabled);
		p_cre_step5.revalidate();
	}
}