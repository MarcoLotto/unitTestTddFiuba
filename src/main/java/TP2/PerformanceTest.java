package TP2;

import java.util.Date;

public abstract class PerformanceTest extends Test {

	private double topRunTime;
		
	public double getTopRunTime() {
		return topRunTime;
	}
	
	public void setTopRunTime(double topRunTime) {
		this.topRunTime = topRunTime;
	}

	public PerformanceTest(String name, double topRunTime) {
		super(name);
		this.topRunTime = topRunTime;
	}	
	
	/**
	 * Este metodo es el que el usuario sobreescribe para ejecutar una prueba de performance
	 */
	public abstract void runPerformanceTest();

	@Override
	public void run() {
		Date before = TimerUtils.getCurrentTime();
		this.runPerformanceTest();
		double finalTime = TimerUtils.calculateTimeInSeconds(before);
		Assert.isTrue(finalTime <= this.topRunTime, this.getName());		
	}
}
