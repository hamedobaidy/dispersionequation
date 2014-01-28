 
package com.hamedapps.dispersionequation.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.action.IStatusLineManager;

public class ComputeHandler {
	@Execute
	public void execute(IStatusLineManager statusLineManager) {
		statusLineManager.setMessage("Ready");
	}
		
}