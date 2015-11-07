
//	+++ PACKAGE +++

package control;


//	+++ IMPORT +++

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CreationPanel;
import model.CreationModel;
import model.DWCGModel;


//	+++ CLASS +++

public class DWCGControl implements ActionListener {
	private DWCGModel dmodel;
	private CreationModel cmodel;
	private CreationPanel cpanel;


//	+++ CONSTRUCTOR +++

	public DWCGControl(DWCGModel dmodel) {
		this.dmodel = dmodel;
	}
	

//	+++ METHODS +++

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();

		switch (cmd) {
		 	case "New Character":
		 		cmodel = new CreationModel();
		 		cpanel = new CreationPanel(cmodel);
		 		dmodel.setPanel(cpanel);
		 		break;
	 		case "Load Character":
	 			//TODO Load Character
	 			break;
			case "About":
				//TODO About the Generator
				break;
			case "Help":
				//TODO Help for the User
				break;
			case "Exit":
				System.exit(0);
			default: break;
		};
	}
}