
//	+++ PACKAGE +++

package attributes;


//	+++ IMPORT +++

import java.util.ArrayList;


//	+++ CLASS +++

public class Speciality {
	String name;
	ArrayList<Skill> skills = new ArrayList<Skill>();
	ArrayList<SpecialAbility> special_abilities = new ArrayList<SpecialAbility>();
	ArrayList<Advance> advances = new ArrayList<Advance>();
	boolean has_skills = false;
	boolean has_special_abilities = false;


//	+++ CONSTRUCTOR +++

	public Speciality(String name, ArrayList<Advance> advances) {
		this.name = name;
		this.advances = advances;
	}


//	+++ COPY CONSTRUCTOR +++

	public Speciality(Speciality speciality) {
		this(speciality.getName(), speciality.getAdvances());
		ArrayList<Advance> _advances = new ArrayList<Advance>();
		for (Advance a : advances) {
			_advances.add(a);
		}
		advances = _advances;

		if (speciality.hasSkills()) {
			setSkills(speciality.getSkills());
			ArrayList<Skill> _skills = new ArrayList<Skill>();
			for (Skill es : skills) {
				Skill s = new Skill(es);
				_skills.add(s);
			}
			skills = _skills;
		}

		if (speciality.hasSpecialAbilities()) {
			setSpecialAbilities(speciality.getSpecialAbilities());
			ArrayList<SpecialAbility> _special_abilities = new ArrayList<SpecialAbility>();
			for (SpecialAbility esa : special_abilities) {
				SpecialAbility sa = new SpecialAbility(esa);
				_special_abilities.add(sa);
			}
			special_abilities = _special_abilities;
		}
	}


//	+++ GETTER +++

	public String getName() {
		return name;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public ArrayList<SpecialAbility> getSpecialAbilities() {
		return special_abilities;
	}

	public ArrayList<Advance> getAdvances() {
		return advances;
	}


//	+++ SETTER +++

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
		has_skills = true;
	}

	public void setSpecialAbilities(ArrayList<SpecialAbility> special_abilities) {
		this.special_abilities = special_abilities;
		this.has_special_abilities = true;
	}


//	+++ HAS +++

	public boolean hasSkills() {
		return has_skills;
	}

	public boolean hasSpecialAbilities() {
		return has_special_abilities;
	}
}