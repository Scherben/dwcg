
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class SquadModeAbility {
	String name;
	int rank;


//	+++ CONSTRUCTORS +++

	public SquadModeAbility(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}


//	+++ COPY CONSTRUCTOR +++

	// currently not needed
	// public SquadModeAbility(SquadModeAbility squad_mode_ability){
	// 	this(squad_mode_ability.getName(), squad_mode_ability.getRank());
	// }


//	+++ GETTER +++

	public String getName() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
}
