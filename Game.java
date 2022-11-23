https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around through caves.  It should really be extended 
 *  to make it more interesting and more playable !
 *  This main class creates and initialises all the others: it creates all
 *  caves, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @Ziqi Yan 21814078
 * @version 2018.11.22
 */
public class Game {

    private Cave currentCave;
    private Parser parser;
    private Monster weight;
    private Tools currenttools;
    private boolean nodoor= false;  
    private Blood blood;
    private Gold gold;
    private Shop currentExtraProtect;
    private itemsRate rateset;
    /**
     * Create the game and initialise factors within the gaming programme.
     */
	public Game() {
		createCave();
		createTools();
		parser = new Parser();
		weight = new Monster();
		blood = new Blood();
		gold = new Gold();
		rateset =new itemsRate();
	}
	/**
     
     * @param blood Starting blood.
     * @param count Counting how many monster killed.
     * @param command The command to be processed.
     * @param weight If weight <=0, determine monster been killed.
     * @param false When there is door for cave then implement next step.
     * @param b Start gold from 0.
     * @param blood Blood under 0 print "you die".
     */
	public void play() {
		blood.setBlood(50);//Initiallise the starting blood
        printWelcome(); 
        boolean finished = false;
        int count=0;
        while (! finished) {        	
        	Command command = parser.getCommand(); 
            finished = processCommand(command); 
            System.out.println("Now, the tools in yours hand is "+currenttools.getDescription()+ " , and rate " +currenttools.getRate());
            //Initiallise gold, and when monster has been killed, print a sentence to show result and gold you get from killing the monster.
            int b= gold.getGold();
            while(nodoor==false) {
        	if(weight.ifKillMonster()>0) { 
        		break;
        	}
        	else {
        		System.out.println();
        		count++;
        		b+=10;
        		System.out.println("Congratulation, you kill a monster, you win 10 gold! You totally have "+b+" gold"); 
        		
        		gold.setGold(b);
        		break;
        		
        	}
            }
            //When blood is less than one, print sentence out which shows you died during the fight
            while(blood.getBlood()<=0) {
            	System.out.println("Sorry, you died!!!");System.exit(0);
            }
            //When you kill four monsters, you win the game and sentence will be printed out to show you win the game. 
            while(count==4) {
            	System.out.println("Congratulation, you win!!!!"); System.exit(0);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
	}
	//Create starting tool.
	private void createTools()
	{
		Tools tool1;
		tool1 = new Tools("start tool", 1);
		currenttools = tool1;
	}
	/**
     * Define the exits of caves.  Every direction either leads
     * to another cave or is null (no exit there).
     * @param east Outside  to Cave1.
     * @param south Outside  to Cave2.
     * @param west Outside  to Cave3.
     * @param west Cave1  to outside .
     * @param north Outside  to Cave2.
     * @param east Outside  to Cave3.
     */
	    
    private void createCave()
    {
        Cave cave1, cave2, cave3, outside;
      
        //Initialise its internal map.
        cave1 = new Cave("in cave1");
        cave2 = new Cave("in cave2");
        cave3 = new Cave("in cave3");
        outside = new Cave("outside the entrance of caves");
        
        //Initialise room exits
        outside.setExit("east", cave1);
        outside.setExit("south", cave2);
        outside.setExit("west", cave3);

        cave1.setExit("west", outside);
        cave2.setExit("north", outside);
        cave3.setExit("east", outside);
        currentCave = outside;  // start game outside
    }
    //Print welcome sentences for starting game.
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Monster game!");
        System.out.println("There are three caves infront you, in the cave there is a monster, you need use tools to kill it");
        System.out.println("Please choose a tool to kill monster (start, intermediate, upper)");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentCave.getLongDescription());
        System.out.println("Now, you have "+ blood.getBlood()+" blood");
    }
    /**
     *Recognizing the command word and implementing user's order if they input right keyword.  
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        
        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            nodoor = true;
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goCave(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }else if(commandWord == CommandWord.CHOOSE) {
        	chooseTools(command);
        }else if(commandWord == CommandWord.SHOP) {
        	addProtect(command);
        	nodoor = true;
        }
        // else command not recognised.
        return wantToQuit;
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the cave.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();;
        nodoor = true;
    }
    
    /**
     * Changing tool with different attack rate for both monster and player. Otherwise, print "change tool fail".
     * @param command Second word comand, select attacking tools.
     */
    private void chooseTools(Command command) {
    	if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("change what?");
            return;
        }
    	Tools tool1,tool2, tool3;
		tool1 = new Tools("start tool", 1);
		tool2 = new Tools("intermediate tool", 2);
		tool3 = new Tools("upper tool", 5);
		nodoor=true;
    	String tools = command.getSecondWord();
       	if(tools.equals("start")) {
    		currenttools = tool1;
    	}else if(tools.equals("intermediate")) {
    		currenttools = tool2;
    	}else if(tools.equals("upper")) {
    		currenttools = tool3;
    	}
    	
    	else {
    		System.out.println("Change tool fail");
    	}
    	
    }
   /**Shoping. After buying one of attack,defence,blood. Particular Gold will be take away from gold you own.
    * @param command Select the tool be bought in shop.
    */
    private void addProtect(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("shop what?? (attack, defence,blood)");
            return;
        }
        
        String tool = command.getSecondWord();
        int i=gold.getGold();
		if(tool.equals("attack")) {
			Shop attack = new Shop("attack tool", 10);
	//As long as you got enough gold(over 10),the following method will be implemented.		
			if(i-10>=0) {
				currentExtraProtect=attack;//Update content in shop.			
				
				int newgold = gold.getGold()-10;//Minus the price you should pay.(10gold)
				double rate = rateset.getAttackRate()+0.1;//Caculation of new attack rate.
				rateset.setAttackRate(rate);//Setter of new attack rate.
				gold.setGold(newgold);//Setter of new gold amount.
				System.out.println(currentExtraProtect.getLongDescription());
			}else {
				    //Print notification when do not have enough gold.
			    System.out.println("You don't have enough money to buy this product");
			}
			

		}else if(tool.equals("defence")) {
			Shop defence = new Shop("defence tool", 15);
			if(i-15>=0) {
				currentExtraProtect=defence;
				
				int newgold = gold.getGold()-15;
				if(rateset.getDefenceRate()<0.4) {
				double rate = rateset.getDefenceRate()+0.1;//Caculation of new defence rate.
				rateset.setDefenceRate(rate);//Setter of new defence rate.
				gold.setGold(newgold);//Setter of new amount.
				System.out.println(currentExtraProtect.getLongDescription());}else {
					System.out.println("You have enough protection");//Make sure monster deal positive damage to player.
				}
			}else {
				System.out.println("You don't have enough money to buy this product");
			}
			
		}else if(tool.equals("blood")) {
			Shop bloods = new Shop("blood tool", 10);
			if(i-10>=0) {
				currentExtraProtect=bloods;
			
			int newgold = gold.getGold()-10;
			gold.setGold(newgold);//Setter of new gold amount. 
			blood.setBlood(currentExtraProtect.updateBlood(blood.getBlood()));//Setter of new blood.
			System.out.println(currentExtraProtect.getLongDescription());
			}else {
				System.out.println("You don't have enough money to buy this function");
			}
			
		}

    }
    
    
    //Print our recommendation when input a wrong second word.
    private void goCave(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Cave nextRoom = currentCave.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
            nodoor=true;
        }else if(direction == "outside") {
        	nodoor=true;
        }
        else {
        	currentCave = nextRoom;
            System.out.println(currentCave.getLongDescription());
            nodoor=false;
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            nodoor = true;
            return true;  // signal that we want to quit
        }
    }
    
	public static void main(String[] args) {
		Game g= new Game();
		g.play();
	}

}
