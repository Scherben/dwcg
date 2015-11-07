
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class Skill {
	int bonus;
	boolean is_basic, is_trained;
	String name, group, characteristic, descriptor;


//	+++ CONSTRUCTOR +++

	public Skill(String name, String group, String characteristic, String descriptor, int bonus, boolean is_basic, boolean is_trained) {
		this.name = name;
		this.group = group;
		this.characteristic = characteristic;
		this.descriptor = descriptor;
		this.bonus = bonus;
		this.is_basic = is_basic;
		this.is_trained = is_trained;
	}


//	+++ COPY CONSTRUCTOR +++

	public Skill(Skill skill) {
		this(skill.getName(), skill.getGroup(), skill.getCharacteristic(), skill.getDescriptor(), skill.getBonus(), skill.isBasic(), skill.isTrained());
	}


//	+++ GETTER +++

	public String getName() {
		return name;
	}

	public String getGroup() {
		return group;
	}

	public String getKeyName() {
		return name + " (" + group + ")";
	}

	public String getCharacteristic() {
		return characteristic;
	}
	
	public String getDescriptor() {
		return descriptor;
	}
	
	public int getBonus() {
		return bonus;
	}


//	+++ SETTER +++

	public void setBonus(int bonus) {
		this.bonus=bonus;
	}
	
	public void setTrained(boolean is_trained) {
		this.is_trained=is_trained;
	}


//	+++ IS +++

	public boolean isBasic() {
		return is_basic;
	}
	
	public boolean isTrained() {
		return is_trained;
	}
}
