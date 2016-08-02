/*
 *	++++++ Deathwatch Character Generator - DWCG ++++++
 *
 *	Author:		Raiko Niederlein
 *	Date:		24 JUN 2015
 *	Version:	1.0
 *
 */


//	+++ IMPORT +++

import database.DWCGDB;
import model.DWCGModel;
import view.DWCGFrame;


//	+++ CLASS +++

public class DWCG {


//	+++ MAIN +++

	public static void main(String[] args) {
		DWCGModel m = new DWCGModel();
		new DWCGFrame(m);
		
		new DWCGDB();
	}
}