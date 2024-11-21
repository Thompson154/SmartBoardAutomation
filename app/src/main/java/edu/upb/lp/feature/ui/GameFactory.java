package edu.upb.lp.feature.ui;

import edu.upb.lp.core.adapter.AndroidLibrary;
import edu.upb.lp.core.adapter.AppConnector;
import edu.upb.lp.progra.bugWorld.BugWorldUI;

/**
 * This class allows to select what UI will be used by the Android library.
 * 
 * @author Alexis Marechal
 * @author Alfredo Villalba
 * @author Paul Landaeta
 */
public class GameFactory {
	public static AppConnector selectGame(AndroidLibrary gui) {
		return new BugWorldUI(gui);
	}	
}
