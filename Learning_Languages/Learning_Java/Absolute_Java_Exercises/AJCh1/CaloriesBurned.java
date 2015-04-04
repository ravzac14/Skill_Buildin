/* Zack Raver; ravzac14
 * 4/4/14
 * 
 * "Absolute Java" by Walter Savitch
 * Ch.1 Programming Project #1:
 * 
 * Calculate and output the total number of calories burned for a 150 pound(2.2 lbs = 1 kg) person who:
 * 	runs 6 MPH for 30 minutes
 * 	plays basketball for 30 minutes
 * 	sleeps for 6 hours
 * 
 * Using the formula Calories/minute = 0.0175 x MET x Weight in kg
 * NOTE: MET values for the activities are listed in the text and are defined as such below
 */


public class CaloriesBurned {
	//All the metabolic equivalents (METs):
	public static final int runMet = 10;
	public static final int baskMet = 8;
	public static final int sleepMet = 1;
	
	public static float findWeightInKg(float wInPounds){
		float wInKg = 0;
		
		wInKg = wInPounds / 2.2F;
		return wInKg;
	}
	
	
	public static double calBurn() {
		float totRun, totBask, totSleep; 
		double calBurn;
		
		totRun = runMet * 30;
		totBask = baskMet * 30;
		totSleep = sleepMet * 360;
		calBurn = 0.0175 * (totRun + totBask + totSleep) * CaloriesBurned.findWeightInKg(150); //The formula this follows is above
		
		return calBurn; 
	}
	
	
	public static void main(String[] args) {
		System.out.printf("For a 150-lb person they would burn %2.2f calories if they ran (at 6 mph) for 30 minutes, "
				+ "played basketball for 30 minutes and slept for 6 hours", CaloriesBurned.calBurn());
	}

}
