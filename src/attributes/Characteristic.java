
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class Characteristic {
	String name = "";
	boolean has_bonus = false;
	int roll = 0;
	int advance_bonus = 0;
	int chapter_bonus = 0;


//	+++ CONSTRUCTOR +++

	public Characteristic(String name, boolean has_bonus) {
		this.name = name;
		this.has_bonus = has_bonus;
		roll = 0;
	}


//	+++ COPY CONSTRUCTOR +++

	public Characteristic(Characteristic characteristic) {
		this(characteristic.getName(), characteristic.hasBonus());
		setRoll(characteristic.getRoll());
		setChapterBonus(characteristic.getChapterBonus());
		setAdvanceBonus(characteristic.getAdvanceBonus());
	}


//	+++ GETTER +++

	public String getName() {
		return name;
	}

	public int getValue() {
		return 30 + roll + advance_bonus + chapter_bonus;
	}

	public int getBonus() {
		int total = 30 + roll + advance_bonus + chapter_bonus;
		return  (total - (total % 10)) / 10;
	}

	public int getRoll() {
		return roll;
	}

	public int getAdvanceBonus() {
		return advance_bonus;
	}

	public int getChapterBonus() {
		return chapter_bonus;
	}


//	+++ SETTER +++	

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public void setAdvanceBonus(int advance_bonus) {
		this.advance_bonus = advance_bonus;
	}

	public void setChapterBonus(int chapter_bonus) {
		this.chapter_bonus = chapter_bonus;
	}


//	+++ HAS +++

	public boolean hasBonus() {
		return has_bonus;
	}
}
