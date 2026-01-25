public class CourseExam1 
{
    public static void main(String[] args)
    {}

    public static boolean stillRed(String[][] board) 
    {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] != null && board[r][c].equals("red")) {
                    return true;
                }
            }
        }
        return true;
    }
}
