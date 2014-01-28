 
package com.hamedapps.dispersionequation.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

import com.hamedapps.dispersionequation.model.DispersionEquation;

public class DataPart {
	private Text textT;
	private Text textH;
	
	private DispersionEquation de = null;
	
	@Inject
	public DataPart() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		Label lblWavePeriodsec = new Label(parent, SWT.NONE);
		lblWavePeriodsec.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWavePeriodsec.setText("Wave Period (sec): ");
		
		textT = new Text(parent, SWT.BORDER);
		textT.setText("10");
		textT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaterDepthm = new Label(parent, SWT.NONE);
		lblWaterDepthm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaterDepthm.setText("Water Depth (m): ");
		
		textH = new Text(parent, SWT.BORDER);
		textH.setText("100");
		textH.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//TODO Your code here
	}
	
	
	public void updateDispersionEquation() {
		try {
			double t = Double.parseDouble(textT.getText());
			double h = Double.parseDouble(textH.getText());
			de = new DispersionEquation(t, h);
		} catch(NumberFormatException nfex) {
			MessageDialog.openError(textT.getShell(), "Error", "Enter valid number.");
		}
	}

	/**
	 * @return the de
	 */
	public DispersionEquation getDe() {
		return de;
	}

	/**
	 * @param de the de to set
	 */
	public void setDe(DispersionEquation de) {
		this.de = de;
	}
	
}