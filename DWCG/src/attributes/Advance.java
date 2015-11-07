
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class Advance {
	String classification, name;
	Skill skill;
	Talent talent;
	Characteristic characteristic;
	boolean is_skill = false;
	boolean is_talent = false;
	boolean is_characteristic = false;
	int cost;


//	+++ CONSTRUCTOR +++

	public Advance(String classification, String name, int cost) {
		this.name = name;
		this.classification = classification;
		this.cost = cost;
	}
	

//	+++ COPY CONSTRUCTOR +++

	//currently not needed
	// public Advance(Advance advance) {
	// 	this(advance.getClassification(), advance.getName(), advance.getCost());
	// 	if(advance.is_skill)
	// 		setSkill(new Skill(advance.getSkill()));
	// 	if(advance.is_talent)
	// 		setTalent(advance.getTalent());
	// 	if(advance.is_characteristic)
	// 		setCharacteristic(new Characteristic(advance.getCharacteristic()));
	// }


//	+++ GETTER +++

	public String getClassification() {
		return classification;
	}

	public String getName() {
		return name;
	}

	public String getKeyName() {
		return name + "|" + classification;
	}

	public Skill getSkill() {
		return skill;
	}

	public Talent getTalent() {
		return talent;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public int getCost() {
		return cost;
	}


//	+++ SETTER +++

	public void setSkill(Skill skill) {
		this.skill = skill;
		is_skill = true;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
		is_talent = true;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
		is_characteristic = true;
	}
	
	
//	+++ IS +++

	public boolean isTalent() {
		return is_talent;
	}

	public boolean isSkill() {
		return is_skill;
	}

	public boolean isCharacteristicBonus() {
		return is_characteristic;
	}
}
