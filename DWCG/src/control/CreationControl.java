
//	+++ PACKAGE +++

package control;


//	+++ IMPORT +++

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import resources.C;

import model.CreationModel;


//	+++ CLASS +++

public class CreationControl implements ActionListener, ItemListener{
	private CreationModel cmodel;


//	+++ CONSTRUCTOR +++
	
	public CreationControl(CreationModel cmodel) {
		this.cmodel = cmodel;
	}
	

//	+++ METHODS +++
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		switch (cmd) {
			case "Roll all Characteristics":
				//roll the dice for all Characteristics
				cmodel.rollAllCharacteristics();
				break;
			case "Reroll " + C.WEAPONSKILL:
				//roll the dice for Weapon Skill again
				cmodel.rerollCharacteristic(C.WEAPONSKILL);
				break;
			case "Reroll " + C.BALLISTICSKILL:
				//roll the dice for Ballistic Skill again
				cmodel.rerollCharacteristic(C.BALLISTICSKILL);
				break;
			case "Reroll " + C.STRENGTH:
				//roll the dice for Strength again
				cmodel.rerollCharacteristic(C.STRENGTH);
				break;
			case "Reroll " + C.TOUGHNESS:
				//roll the dice for Toughness again
				cmodel.rerollCharacteristic(C.TOUGHNESS);
				break;
			case "Reroll " + C.AGILITY:
				//roll the dice for Agility again
				cmodel.rerollCharacteristic(C.AGILITY);
				break;
			case "Reroll " + C.INTELLIGENCE:
				//roll the dice for Intelligence again
				cmodel.rerollCharacteristic(C.INTELLIGENCE);
				break;
			case "Reroll " + C.PERCEPTION:
				//roll the dice for Perception again
				cmodel.rerollCharacteristic(C.PERCEPTION);
				break;
			case "Reroll " + C.WILLPOWER:
				//roll the dice for Willpower again
				cmodel.rerollCharacteristic(C.WILLPOWER);
				break;
			case "Reroll " + C.FELLOWSHIP:
				//roll the dice for Fellowship again
				cmodel.rerollCharacteristic(C.FELLOWSHIP);
				break;
			default: break;
		};
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox<String> check = null;

		if (e.getSource() instanceof JComboBox<?>) {
			//typesafety requires an SurpressWarning, to this Date there are only JComboBoxes with the Type String used, so it is save
			check = (JComboBox<String>)e.getSource();
			String combobox = check.getName();

			switch (combobox) {
				case "Chapter_Combobox":
					String chapter = e.getItem().toString();
					if ((e.getStateChange() == 1) && (chapter != "")) {
						cmodel.setChapter(chapter);
					}
					break;
				case "Speciality_Combobox":
					String speciality = e.getItem().toString();
					if ((e.getStateChange() == 1) && (speciality != "")) {
						cmodel.setSpeciality(speciality);
					}
					break;
				case "Special_Ability_Combobox":
					String special_ability = e.getItem().toString();
					if ((e.getStateChange() == 1) && (special_ability != "")) {
						cmodel.setSpecialAbility(special_ability);
					}
					break;
				case "Tactics_Combobox":
					String tactic = e.getItem().toString();
					if ((e.getStateChange() == 1) && (tactic != "")) {
						cmodel.setTactic(tactic);
					}
					break;
				default: break;
			};
		} else if (e.getSource() instanceof JCheckBox) {
			JCheckBox box = (JCheckBox) e.getSource();
			String name = box.getName();
			if (e.getStateChange() == 1) {
				cmodel.addAdvance(name);
				//System.out.println("selected");
			} else {
				cmodel.removeAdvances(name, null);
				//System.out.println("deselected");
			}
		}
	}
}