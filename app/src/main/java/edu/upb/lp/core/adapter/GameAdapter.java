package edu.upb.lp.core.adapter;

// import edu.upb.lp.progra.superMegaJuegoSuperCool.SuperMegaJuegoSuperCoolConnector;

import edu.upb.lp.progra.bugWorld.BugWorldUI;

/**
 * This class allows to select what UI will be used by the Android library.
 * 
 * @author Alexis Marechal
 * @author Alfredo Villalba
 */
public class GameAdapter {
	public static AppConnector selectGame(AndroidLibrary gui) {
		return new BugWorldUI(gui);
	}	
}
