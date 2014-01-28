 
package com.hamedapps.dispersionequation.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import com.hamedapps.dispersionequation.part.DataPart;
import com.hamedapps.dispersionequation.part.ResultsPart;

public class ComputeHandler {
	@Execute
	public void execute(EPartService partService) {
		DataPart dataPart = (DataPart) partService.findPart("com.hamedapps.dispersionequation.part.datapart").getObject();
		dataPart.updateDispersionEquation();
		
		System.out.println(dataPart.getDe().getK());
		
		//TODO set results
		ResultsPart resultPart = (ResultsPart) partService.findPart("com.hamedapps.dispersionequation.part.resultpart").getObject();
		resultPart.updateResults(dataPart.getDe().getSigma(), dataPart.getDe().getK(), dataPart.getDe().getL());
	}
		
}