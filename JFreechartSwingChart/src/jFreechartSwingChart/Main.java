package jFreechartSwingChart;

import org.jfree.ui.RefineryUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PieChart demo = new PieChart("Comparación", "Que sistemas operativo usan?");
         demo.pack();
         demo.setVisible(true);
         
         final XYPlotSeries demo1 = new XYPlotSeries("XY Series Demo");
         demo1.pack();
         RefineryUtilities.centerFrameOnScreen(demo1);
         demo1.setVisible(true);

	}

}
