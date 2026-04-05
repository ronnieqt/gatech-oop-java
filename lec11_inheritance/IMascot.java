// Interfaces can also contain constants -- specifically public static ones

public interface IMascot
{
    // Any variable that is declared in an interface is inherently
    //   public, static, and final regardless of the modifiers used or omitted.
    // We may want to incorporate a limit to the amount of time that any kind of Mascot spends celebrating.
    double MAX_CELEBRATION_SEC = 30;
    // public static final double MAX_CELEBRATION_SEC = 30;

    // By implementing the interface, each class can directly access its constants using just their names 
    //   as if they were defined within the class (e.g e.g. MAX_CELEBRATION_SEC instead of Mascot.MAX_CELEBRATION_SEC).

    // NOTE: instance variables are not allowed in interfaces.

    public void celebrate();  // after a score

    public void whine();  // after a blown referee call

    public void chant();  // before a field goal or free throw attempt

    public void run();  // for many reasons
}
