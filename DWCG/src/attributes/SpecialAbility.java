
//	+++ PACKAGE +++

package attributes;


//	+++ IMPORT +++

import java.util.ArrayList;


//	+++ CLASS +++

public class SpecialAbility {
	String name;
	ArrayList<Talent> talents;
	Trait trait;
	boolean has_trait = false;
	boolean has_talents = false;
	boolean choosable = false;


//	+++ CONSTRUCTOR +++

	public SpecialAbility(String name, boolean choosable) {
		this.name = name;
		this.choosable = choosable;
	}


//	+++ COPY CONSTRUCTOR +++

	public SpecialAbility(SpecialAbility special_ability) {
		this(special_ability.getName(), special_ability.isChoosable());
		if(special_ability.hasTalents())
			setTalents(new ArrayList<Talent>(special_ability.getTalents()));
		if(special_ability.hasTrait())
			setTrait(new Trait(special_ability.getTrait()));
	}


//	+++ GETTER +++

	public String getName() {
		return name;
	}
	
	public ArrayList<Talent> getTalents() {
		return talents;
	}
	
	public Trait getTrait() {
		return trait;
	}


//	+++ SETTER +++

	public void setTalents(ArrayList<Talent> talents) {
		this.talents = talents;
		has_talents = true;
	}

	public void setTrait(Trait trait) {
		this.trait = trait;
		has_trait = true;
	}


//	+++ HAS +++

	public boolean hasTalents() {
		return has_talents;
	}

	public boolean hasTrait() {
		return has_trait;
	}


//	+++ IS +++

	public boolean isChoosable() {
		return choosable;
	}
}
