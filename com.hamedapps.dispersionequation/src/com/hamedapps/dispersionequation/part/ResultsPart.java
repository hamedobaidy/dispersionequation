 
package com.hamedapps.dispersionequation.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class ResultsPart {
	private Text textSigma;
	private Text textK;
	private Text textL;
	@Inject
	public ResultsPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		Label lblWaveAngularFrequency = new Label(parent, SWT.NONE);
		lblWaveAngularFrequency.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveAngularFrequency.setText("Wave Angular Frequency : ");
		
		textSigma = new Text(parent, SWT.BORDER);
		textSigma.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaveNumberk = new Label(parent, SWT.NONE);
		lblWaveNumberk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveNumberk.setText("Wave Number (k) : ");
		
		textK = new Text(parent, SWT.BORDER);
		textK.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWaveLengthl = new Label(parent, SWT.NONE);
		lblWaveLengthl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWaveLengthl.setText("Wave Length (L) : ");
		
		textL = new Text(parent, SWT.BORDER);
		textL.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//TODO Your code here
	}
	
	
	
	
}