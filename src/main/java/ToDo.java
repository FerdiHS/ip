/**
 * Class for ToDo
 */
public class ToDo extends Task {
    // Constructor

    /**
     * Constructor of class ToDo
     * @param name the name of the todo
     */
    public ToDo(String name) {
        super(name);
    };

    /**
     * Method to return the string representation of todo
     * 
     * @return the string representation of todo
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Method to check whether the command is a todo or not
     * 
     * @param str the command
     * @return whether the command is a todo or not
     * @throws InvalidToDoException
     */
    public static boolean isToDo(String str) throws InvalidToDoException{
        if(str.split(" ")[0].equals("todo")) {
            if(str.equals("todo")) {
                throw new InvalidToDoException();
            } else {
                return true;
            }
        }
        return false;
    }
}