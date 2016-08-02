
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class Trait {
	String name = "", group = "";
	int value = 0;


//	+++ CONSTRUCTOR +++

	public Trait(String name, String group, int value) {
		this.name = name;
		this.group = group;
		this.value = value;
	}


//	+++ COPY CONSTRUCTOR +++

	public Trait(Trait trait) {
		this(trait.getName(), trait.getGroup(), trait.getValue());
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

	public int getValue() {
		return value;
	}

//	+++ SETTER +++

	public void setValue(int value) {
		this.value = value;
	}
}
