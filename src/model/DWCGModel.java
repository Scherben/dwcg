
//	+++ PACKAGE +++

package model;


//	+++ IMPORT +++

import java.util.Observable;


//	+++ CLASS +++

public class DWCGModel extends Observable{
	private Object panel;
	
	public void setPanel(Object panel){
		this.panel = panel;
		setChanged();
		notifyObservers();
	}
	
	public Object getPanel(){
		return panel;
	}
}
