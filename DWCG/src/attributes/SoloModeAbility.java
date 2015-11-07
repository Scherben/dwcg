
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class SoloModeAbility {
	String name;
	int rank;


//	+++ CONSTRUCTOR +++

	public SoloModeAbility(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}


//	+++ COPY CONSTRUCTOR +++

	// currently not needed
	// public SoloModeAbility(SoloModeAbility solo_mode_ability){
	// 	this(solo_mode_ability.getName(), solo_mode_ability.getRank());
	// }


//	+++ GETTER +++

	public String getName() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
}
