public interface Impostor
{
    // Impostors will be able to mess with Players through sabotage and freeze tagging them.

    public void freeze(Player p);

    public void sabotage(Player p);
}
