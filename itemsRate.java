https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class return and set attack|defence rate.
 * 
 *
 * @author  Ziqi Yan 21814078
 * @version 2018.11.22
 */
public class itemsRate {
	//Initialise attackrate and defence rate both equal to 0 at the beginning. 
        private static double attackRate = 0;
	private static double defenceRate = 0;
	//@Return attackrate
	public double getAttackRate() {
		return attackRate;
	}
        //Get and set attackrate.
        public void setAttackRate(double attackRate) {
		itemsRate.attackRate = attackRate;
	}
	//@return defence rate.
	public double getDefenceRate() {
		return defenceRate;
	}
	//get and set defence rate.
	public void setDefenceRate(double defenceRate) {
		itemsRate.defenceRate = defenceRate;
	}
	
	
}
