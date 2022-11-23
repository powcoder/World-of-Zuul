https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/**
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around through caves.  It should really be extended 
 *  to make it more interesting and more playable !
 *  
 * This class is used to get and set value for products in shop
 * Also print notification after buying in shop.
 * @Ziqi Yan 21814078
 * @version 2018.11.22
 */
public class Shop {
	private String description;
	private int value;
	private Gold a =new Gold();
        //Initiallise container.
	public Shop(String description, int value) {
		this.description=description;
		this.value=value;
	}
	//@return Getter and setter of description and value of items.
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	//@return Print receipt after buying.
	 public String getLongDescription() {
		return "You buy a "+description +" cost "+value+ " gold, you have "+a.getGold();
	 }
	 //@return blood after purchasing blood tool in shop.
	 public int updateBlood(int j) {
		 j+=100;
		 System.out.println("You have successfully added 100 blood");
		 return j;
	 }
	
}
