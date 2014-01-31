 
package com.hamedapps.dispersionequation.part;

import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.swtchart.Chart;
import org.swtchart.IAxis;
import org.swtchart.IAxisSet;
import org.swtchart.ILineSeries;
import org.swtchart.ILineSeries.PlotSymbolType;
import org.swtchart.ISeries.SeriesType;
import org.swtchart.ISeriesSet;

public class ChartPart {
	private Chart chart;

	@Inject
	public ChartPart() {
		//TODO Your code here
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		chart = new Chart(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(chart);
		scrolledComposite.setMinSize(chart.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		IAxisSet axisSet = chart.getAxisSet();
		IAxis xAxis = axisSet.getXAxis(0);
		xAxis.getTitle().setText("kh");
		chart.getTitle().setText("Single root to dispersion equation");
		axisSet.getYAxis(0).getTitle().setText(" ");
		//TODO Your code here
	}
	
	
	public void updateChart( Vector<Double> khs, Vector<Double> khVsTanhkhs, Vector<Double> khVsYs) {
		
		double[] ySeries = new double[khVsTanhkhs.size()];
		for (int i = 0; i < ySeries.length; i++) {
			ySeries[i] = khVsTanhkhs.get(i);
		}

		ISeriesSet seriesSet = chart.getSeriesSet();
		ILineSeries tanhSeries = (ILineSeries) seriesSet.createSeries(SeriesType.LINE, "tanh(kh)");
		tanhSeries.setSymbolType(PlotSymbolType.NONE);
		tanhSeries.setYSeries(ySeries);
		double[] kh = new double[khs.size()];
		for (int i = 0; i < kh.length; i++) {
			kh[i] = khs.get(i);
		}
		tanhSeries.setXSeries(kh);
		double[] sSeries = new double[khVsYs.size()];
		for (int i = 0; i < sSeries.length; i++) {
			sSeries[i] = khVsYs.get(i);
		}
		ILineSeries sigmaSeries = (ILineSeries) seriesSet.createSeries(SeriesType.LINE, "σ^2*h/gkh");
		sigmaSeries.setSymbolType(PlotSymbolType.NONE);
		Color color = new Color(chart.getShell().getDisplay(), 255, 0, 0);
		sigmaSeries.setLineColor(color);
		sigmaSeries.setYSeries(sSeries);
		sigmaSeries.setXSeries(kh);
		
		chart.getAxisSet().adjustRange();
		chart.redraw();
	}
	
}