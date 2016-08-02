
//	+++ PACKAGE +++

package resources;


//	+++ IMPORT +++

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import attributes.*;


//	+++ CLASS +++

public class Functions {
	private final static String separator = ",";


//	+++ METHODS +++

	public static LinkedList<String> loadCSV(String path) {
		String csvFile = path, line;
		LinkedList<String> list = new LinkedList<String>();
		BufferedReader br = null;

		try {
	 		br = new BufferedReader(new FileReader(csvFile));

	 		while((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public static HashMap<String,HashMap<String,String>> mapList(LinkedList<String> list, int control) {
		HashMap<String,HashMap<String,String>> map = new HashMap<String,HashMap<String,String>>();
		String[] head, line;
		
		head = list.get(0).split(separator);
		for (int i = 1; i < list.size(); i++) {
			line = list.get(i).split(separator);
			HashMap<String,String> h = new HashMap<String,String>();
			for (int j = 0; j < head.length; j++) {
				h.put(head[j],line[j]);
			}
			if (control == 1) {
				//Column 1 and 2 are used as the key
				map.put(line[0] + " " + "(" + line[1] + ")", h);
			} else {
				//Column 1 is used as a key
				map.put(line[0], h);
			}
		}
		//Errorhandling if csv is uncomplete (ArrayOutOfBondExeption)
		return map;
	}

	public static String[] arrayListToStringArray(ArrayList<String> list) {
		String line = "";
		
		for (int i = 0; i < list.size(); i++) {
			line = line + (list.get(i)) + separator;
		}
		if (line.length() != 0) {
			line = line.substring(0, line.length()-1);
		}
		return line.split(separator);
	}

	public static GridBagConstraints makegbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 100;
		gbc.weighty = 100;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		return gbc;
	}

	public static ArrayList<ArrayList<JLabel>> listJLabels(int size, int depth) {
		ArrayList<ArrayList<JLabel>> al1 = new ArrayList<ArrayList<JLabel>>();

		for (int i = 0; i < size; i++) {
			ArrayList<JLabel> al2 = new ArrayList<JLabel>();
			
			for (int j = 0; j < depth ; j++) {
				al2.add(new JLabel());
			}
			al1.add(al2);
		}
		return al1;
	}
	
	public static int randomCharacteristicValue() {
		int x, characteristic_value = 0;
		for (int i = 0; i < 2; i++) {
			x = (int)(Math.random() * 10);
			if (x == 0)
				x = 10;
			characteristic_value += x;
			//System.out.println("Dice" + i + ": " + x);
		}
		return characteristic_value;
	}

	public static void putList(JComboBox<String> jcb, ArrayList<String> al) {
		Collections.sort(al);
		jcb.removeAllItems();
		for (String item : al) {
			jcb.addItem(item);
		}
	}

	public static Object getSpecific(ArrayList<?> al, String name) {
		for (Object o : al) {
			if (o instanceof Trait) {
				if (((Trait) o).getKeyName().equals(name))
					return o;
			} else if (o instanceof Skill) {
				if (((Skill) o).getKeyName().equals(name))
					return o;
			} else if (o instanceof Talent) {
				if (((Talent) o).getKeyName().equals(name))
					return o;
			} else if (o instanceof Chapter) {
				if (((Chapter) o).getName().equals(name))
					return o;
			} else if (o instanceof Speciality) {
				if (((Speciality) o).getName().equals(name))
					return o;
			} else if (o instanceof SpecialAbility) {
				if (((SpecialAbility) o).getName().equals(name))
					return o;
			} else if (o instanceof Advance) {
				if (((Advance) o).getKeyName().equals(name))
					return o;
			} else if (o instanceof Characteristic) {
				if (((Characteristic) o).getName().equals(name))
					return o;
			} else if (o instanceof CharacterValue) {
				if (((CharacterValue) o).getName().equals(name))
					return o;
			}
		}
		return null;
	}
}
