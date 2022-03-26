import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class main {

    /**
     * 
     * @param matrix : 2D matrix, stores game.
     * @param m : x  - cordinate
     * @param n : y = cordinate
     * @return : int -> number of connected 1s
     */
    public static int solnHelper(int matrix[][], int m, int n) {
        if (isInvalidCord(matrix, n, m) || matrix[m][n] == 0) {
            return 0;
        }
        int count = matrix[m][n]--;
        count += solnHelper(matrix, m + 1, n);
        count += solnHelper(matrix, m - 1, n);
        count += solnHelper(matrix, m, n + 1);
        count += solnHelper(matrix, m, n + 1);
        return count;
    }

    /**
     * 
     * @param matrix : 2D matrix, stores game.
     * @return : String -> Answer statement.
     */
    public static String soln(int matrix[][]) {
        int max = 0;
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                candidates.add(solnHelper(matrix, i, j));
            }
        }
        ArrayList<Integer> candidate = new ArrayList<Integer>();
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i) != 0) {
                candidate.add(candidates.get(i));
            }
        }

        return "The input has " + candidate.size() + " connected groups with sizes as " + candidate.toString();
    }


    public static void main(String[] args) {
        Instant start = Instant.now();
       //   Matrix Input
       Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        int ct = 0;
        // Input
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine();
        String[] array = input.split(", ");
        // String to Integer and stored in 2-D Array
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = Integer.parseInt(array[ct]);
                ct++;
            }
        }

        System.out.println(soln(grid)); // Prints answer
        in.close();
        scnr.close();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toSeconds(); 
        System.out.println("Time taken to execute the code : " + timeElapsed);
    }

    /**
     * 
     * @param matrix : 2D matrix, stores game.
     * @param n : x  - cordinate
     * @param m : y = cordinate
     * @return : boolean -> True of valid cordinates, else false.
     */
    public static boolean isInvalidCord(int matrix[][], int n, int m) {
        return (n < 0 || m < 0 || n >= matrix.length || m >= matrix.length);
    }
}



        // for(int grid_i=0; grid_i < n; grid_i++){
        //     for(int grid_j=0; grid_j < m; grid_j++){
        //         System.out.println(grid[grid_i][grid_j]);
        //     }
        //     //System.out.println("");
        // }