import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor
{
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill)
    {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name)
    {
        this(name, 15, "experienced");
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
        // The player that has the highest susLevel (that is NOT the current impostor calling the meeting)
        // will be accused of being the impostor and will be voted off (freezed).
        for (int i = players.length - 1; i >= 0; --i) {
            if (!players[i].isFrozen() && !players[i].equals(this)) {
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

    @Override
    public void freeze(Player p)
    {
        // It is not possible to freeze another Impostor, and an Impostor that is frozen cannot attempt to freeze.
        if (p instanceof Impostor || isFrozen()) {
            return;
        }
        // A freeze is successful if the RedAstronaut's susLevel is less than the Player's.
        if (getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        }
        // If the freeze is unsuccessful, the RedAstronaut's susLevel doubles.
        else {
            setSusLevel(2 * getSusLevel());
        }
        // After the freeze attempt, check if the game.
        gameOver();
    }

    @Override
    public void sabotage(Player p)
    {
        if (p instanceof Impostor || p.isFrozen() || isFrozen()) {
            return;
        }
        double multiplier = (getSusLevel() < 20) ? 1.5 : 1.25;
        p.setSusLevel((int) (multiplier * p.getSusLevel()));
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof RedAstronaut) {
            RedAstronaut red = (RedAstronaut) o;
            return getName().equals(red.getName()) && isFrozen() == red.isFrozen()
                    && getSusLevel() == red.getSusLevel() && this.skill.equals(red.getSkill());
        }
        return false;
    }

    @Override
    public String toString()
    {
        String res = super.toString();
        res += " I am an " + skill + " player!";
        if (getSusLevel() > 15) {
            res = res.toUpperCase();
        }
        return res;
    }

    public String getSkill()
    {
        return skill;
    }

    // public static void main(String[] args)
    // {
    //     RedAstronaut ra1 = new RedAstronaut("ra1", 3, "experienced");
    //     RedAstronaut ra2 = new RedAstronaut("ra2", 1, "expert");
    //     RedAstronaut ra3 = new RedAstronaut("ra3", 2, "expert");
    //     RedAstronaut ra4 = new RedAstronaut("ra3", 16, "expert");
    //     for (Player p : RedAstronaut.getPlayers()) {
    //         System.out.println(p.toString());
    //     }
    //     ra1.emergencyMeeting();
    //     for (Player p : RedAstronaut.getPlayers()) {
    //         System.out.println(p.toString());
    //     }
    //     ra2.emergencyMeeting();
    //     for (Player p : RedAstronaut.getPlayers()) {
    //         System.out.println(p.toString());
    //     }
    // }
}
