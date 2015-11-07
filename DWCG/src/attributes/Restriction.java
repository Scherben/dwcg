
//	+++ PACKAGE +++

package attributes;


//	+++ CLASS +++

public class Restriction {
	Speciality speciality;
	boolean is_speciality = false;
	// currently not needed
	// Chapter chapter;
	// boolean is_chapter = false;


//	+++ CONSTRUCTORS +++

	public Restriction(Speciality speciality){
		this.speciality = speciality;
		is_speciality = true;
	}

	// currently not needed
	// public Restriction(Chapter chapter){
	// 	this.chapter = chapter;
	// 	is_chapter = true;
	// }


//	+++ GETTER +++

	// currently not needed
	// public Chapter getChapter(){
	// 	return chapter;
	// }

	public Speciality getSpeciality(){
		return speciality;
	}


//	+++ IS +++

	// currently not needed
	// public boolean isChapter(){
	// 	return is_chapter;
	// }

	public boolean isSpeciality(){
		return is_speciality;
	}
}
