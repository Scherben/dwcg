
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class Talent {
	String name = "", group = "";
	

//	+++ CONSTRUCTOR +++
	
	public Talent(String name, String group) {
		this.name = name;
		this.group = group;
	}


//	+++ COPY CÓNSTRUCTOR +++

	// currently not needed
	// public Talent(Talent talent){
	// 	this(talent.getName(), talent.getGroup());
	// }


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

}
