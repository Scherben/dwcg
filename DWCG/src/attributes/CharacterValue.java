
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class CharacterValue {
	int value;
	String name = "";
	

//	+++ CONSTRUCTOR +++

	public CharacterValue(String name, int value) {
		this.name = name;
		this.value = value;
	}


//	+++ COPY CONSTRUCTOR +++

	public CharacterValue(CharacterValue character_value) {
		this(character_value.getName(), character_value.getValue());
	}


//	+++ GETTER +++

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public int getValue(int multiplier) {
		return value * multiplier;
	}


//	+++ SETTER +++

	public void setValue(int value) {
		this.value = value;
	}
}
