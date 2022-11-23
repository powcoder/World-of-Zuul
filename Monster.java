https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder

import java.util.Random;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class initialise the weight of monster and method how tools attack monsters.
 * 
 *
 * @author  Ziqi Yan 21814078
 * @version 2018.11.22
 */
public class Monster {
	
	private int   weight;
    private Parser Parser;
    private Tools currenttools;
    private itemsRate rateset = new itemsRate();
    
    public Monster() {
		Parser = new Parser();
		
    }

	Random a = new Random();
	
    private Blood blood = new Blood();
        /*Creating monster has random blood under 20 blood.(May have 0 blood which means free gold for player. )
         * @param weight Monster weight equals random number from 0-20.
         */
	public  void  createMonster() {
		 
		 weight=a.nextInt(20);
		 
		 System.out.println("This monster has  "+weight+" blood");
	}
	//This part haven't been used in this version. Boss will be updated in next version in an appropriate way to make more funs for players.
	public  void  createBossMonster() {
		 
		 weight=100;
		 
		 System.out.println("This is boss monster has  "+weight+" blood, you kill it, you will win");
	}
	//Fighting methods and caculation. 
	public int ifKillMonster() {
		createMonster();
		//@param wguke weight larger than 0. Continue the loop.
		while(weight>0) {
		System.out.println("please choose a tool to attack");
        System.out.print("> ");     // print prompt
        Command command = Parser.getCommand();
    	command.getSecondWord();
        //@param tools Get second command words to select one of three tools.
    	Tools tool1,tool2, tool3;
		tool1 = new Tools("start", 1);
		tool2 = new Tools("intermediate", 2);
		tool3 = new Tools("upper", 5);
    	String tools = command.getSecondWord();
    	//Prevent from inputing wrong words make programme crash.
        if(command.getCommandWord() == CommandWord.CHOOSE &&(command.getSecondWord().equals("start") || command.getSecondWord().equals("intermediate") || command.getSecondWord().equals("upper"))) {       	
        if(tools.equals("start")) {
    		currenttools = tool1;
    	}else if(tools.equals("intermediate")) {
    		currenttools = tool2;
    	}else if(tools.equals("upper")) {
    		currenttools = tool3;
    	}else {
    		System.out.println("input wrong");break;
    	}
        System.out.println("Now, the tools in yours hand is "+currenttools.getDescription()+ " , and rate " +currenttools.getRate());
        //Caculation methods.
        weight-= currenttools.getRate()*(1+rateset.getAttackRate());
        int newblod= blood.getBlood();
        newblod-=weight*(0.5-rateset.getDefenceRate())+currenttools.getRate();
        blood.setBlood(newblod);
       	System.out.println("The monster has "+weight+" blood");
       	System.out.println("You have "+newblod+" blood");
       	//@param CommandWord Print help or notification when input unknown command or quit.
		}  else if(command.getCommandWord() == CommandWord.UNKNOWN) {
			System.out.println("I don't know what you mean...");     	
		}else if(command.getCommandWord() == CommandWord.QUIT) {
			break; 
		}else {
			System.out.println("You input a wrong tools");
		}
		}//@return weight After loop weight.
		return weight;
	}
}
