 
package com.hamedapps.dispersionequation.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import com.hamedapps.dispersionequation.part.DataPart;

public class ComputeHandler {
	@Execute
	public void execute(EPartService partService) {
		MPart part = partService.findPart("com.hamedapps.dispersionequation.part.datapart");
		DataPart dataPart = (DataPart) part.getObject();
		dataPart.updateDispersionEquation();
		
		System.out.println(dataPart.getDe().getK());
		
		//TODO set results
	}
		
}