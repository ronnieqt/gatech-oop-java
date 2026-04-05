import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate
{
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed)
    {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name)
    {
        this(name, 15, 6, 10);
    }

    @Override
    public void emergencyMeeting()
    {
        // A Player that is frozen cannot call an emergency meeting.
        if (isFrozen()) {
            return;
        }
        // Holds a meeting and freezes the most suspicious Player, only considering Players that are not frozen.
        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        // The player that has the highest susLevel will be accused of being the impostor and will be voted off.
        for (int i = players.length - 1; i >= 0; --i) {
            if (!players[i].isFrozen()) {
                if (i == 0 || players[i - 1].compareTo(players[i]) < 0) {
                    players[i].setFrozen(true);
                }
                // If two players have the same highest susLevel, no player will be voted off.
                break;
            }
        }
        // At the end of the vote, check if the game is over.
        gameOver();
    }

    public void completeTask()
    {
        if (isFrozen()) {
            return;
        }
        boolean alreadyDone = numTasks == 0;
        if (taskSpeed > 20) {
            numTasks -= 2;
        }
        else {
            numTasks -= 1;
        }
        if (numTasks < 0) {
            numTasks = 0;
        }
        if (!alreadyDone && numTasks == 0) {
            System.out.println("I have completed all my tasks");
            setSusLevel((int) (0.5 * getSusLevel()));
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blue = (BlueAstronaut) o;
            return getName().equals(blue.getName()) && isFrozen() == blue.isFrozen()
                    && getSusLevel() == blue.getSusLevel() && this.numTasks == blue.getNumTasks()
                    && this.taskSpeed == blue.getTaskSpeed();
        }
        return false;
    }

    @Override
    public String toString()
    {
        String res = super.toString();
        res += " I have " + this.numTasks + " left over.";
        if (getSusLevel() > 15) {
            res = res.toUpperCase();
        }
        return res;
    }

    public int getNumTasks()
    {
        return numTasks;
    }

    public int getTaskSpeed()
    {
        return taskSpeed;
    }
}
