/**
 * Event class
 */
public class Event extends Task {
    // Attribute
    private String start;
    private String end;

    // Constructor

    /**
     * The constructor of Event class
     * 
     * @param name name of the event
     * @param start the start of the event
     * @param end the end of the event
     */
    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    /**
     * Method to return the string representation of event
     * 
     * @return the string representation of event
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + " )";
    }

    /**
     * Method to check whether the command is event
     * 
     * @param str the command
     * @return whether the command is event
     * @throws InvalidEventException
     */
    public static boolean isEvent(String str) throws InvalidEventException {
        if(str.split(" ")[0].equals("event")) {
            if(str.indexOf("/from ") == -1 || str.substring(str.indexOf("/from ") + 5).indexOf( "/from ") == -1) {
                throw new InvalidEventException();
            } else {
                return true;
            }
        }
        return false;
    }
}
