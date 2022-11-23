https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class initialise the rate of three tools(start,intermediate,upper) 
 * Get and set this rate
 *
 * @author  Ziqi Yan 21814078
 * @version 2018.11.22
 */
public class Tools {	
    private String description;
    private int rate;
	
	public Tools(String description, int rate) {
        this.description = description;
        this.rate = rate;
	}
        //@return description of attack tools
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
        //@return the attack rate which is 1,2,5.
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


	
}
