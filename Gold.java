https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/**
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around through caves.  It should really be extended 
 *  to make it more interesting and more playable !
 *  
 * This class return and set gold. 
 * @Ziqi Yan 21814078
 * @version 2018.11.22
 */
public class Gold {
    //Using static to prevent  visiting again through other pathway. It may re-initiallise the variation.
	private static int gold=0;
        //@return Stter and getter of gold gold
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		Gold.gold = gold;
	}
	
	
}
