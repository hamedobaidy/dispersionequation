 
package com.hamedapps.dispersionequation.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class DataPart {
	private Text textT;
	private Text textH;
	@Inject
	public DataPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		Label lblWavePeriodsec = new Label(parent, SWT.NONE);
		lblWavePeriodsec.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWavePeriodsec.setText("Wave Period (sec): ");
		
		textT = new Text(parent, SWT.BORDER);
		textT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaterDepthm = new Label(parent, SWT.NONE);
		lblWaterDepthm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaterDepthm.setText("Water Depth (m): ");
		
		textH = new Text(parent, SWT.BORDER);
		textH.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//TODO Your code here
	}
	
	
	
	
}