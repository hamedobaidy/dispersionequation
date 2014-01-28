 
package com.hamedapps.dispersionequation.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AboutHandler {
	@Execute
	public void execute(Shell shell) {
		MessageDialog.openInformation(shell, "About", "Solving Dispersion Equation.\nBy: Hamed Mohammadi\nemail: hamedapps@gmail.com");
	}
		
}