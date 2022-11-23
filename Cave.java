https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder

import java.util.HashMap;
import java.util.Set;
/**
 * Class Cave - a cave in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Cave" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @Ziqi Yan  21814078  
 * @version 2018.11.22
 */
public class Cave {

    private String description;
    private HashMap<String, Cave> exits;
/**
     * Create a room described "description". Initially, it has
     * no exits. Concept of "description" have not been used in this programme.
     * @param description The room's description.
     */
    public Cave(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Cave>();
    }
 
    public void setExit(String direction, Cave neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Cave getExit(String direction) 
    {
        return exits.get(direction);
    }
}
