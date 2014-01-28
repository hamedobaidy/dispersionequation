 
package com.hamedapps.dispersionequation.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class DescriptionPart {
	@Inject
	public DescriptionPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		StyledText styledText = new StyledText(scrolledComposite, SWT.BORDER | SWT.WRAP);
		styledText.setText("Solving Dispersion Equation\nThis program solves Dispersion Equation by iterative and graphical methods.\n1- Set wave period and water depth values\n2- Click compute button or select Tools->Compute menu\n\nThe result will be displayed and chart will be updated.");
		styledText.setEditable(false);
		scrolledComposite.setContent(styledText);
		scrolledComposite.setMinSize(styledText.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}
	
	
	
	
}