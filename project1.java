import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        System.out.println("Welcome to TICTACTOE game");
        System.out.println("AKA XOX game");
        boolean ans=true;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter which symbol would u want to take(X/O):");
        String symbol1= sc.next();
        String symbol=symbol1.toLowerCase();
        String[][] dp=new String[5][5];
        while (ans) {
            System.out.print("Enter the row number(1/2/3):");
            int row=sc.nextInt();
            System.out.print("Enter the Column number(1/2/3):");
            int column=sc.nextInt();
            if(row==1){
                row-=1;
            }else if(row==3){
                row+=1;
            }
            if(column==1){
                column-=1;
            }else if(column==3){
                column+=1;
            }
            Random random=new Random();
            List<Integer> rand=Arrays.asList(0,2,4);
            int randomrow=rand.get(random.nextInt(rand.size()));
            int randomcolumn=rand.get(random.nextInt(rand.size()));
            String cpuString;
            for (int i=0;i<=4;i+=2){
                for(int j=1;j<=3;j+=2){
                    dp[i][j]="|";
                }
            }
            for(int i=1;i<=3;i+=2){
                for(int j=1;j<=3;j+=2){
                    dp[i][j]="+";
                }
            }
            for(int i=1;i<=3;i+=2){
                for(int j=0;j<=4;j+=2){
                    dp[i][j]="-";
                }
            }
            for(int i=0;i<dp.length;i++){
                for (int j=0;j<dp[i].length;j++){
                    if(dp[i][j]==null){
                        dp[i][j]=".";
                    }
                }
            }
            if(symbol.equals("x")){
                cpuString="o";
            }else if(symbol.equals("o")){
                cpuString="x";
            }else{
                cpuString="x";
            }
            if(dp[row][column]=="x" || dp[row][column]=="o"){
                System.out.println("This is already taken.. Please enter valid row or column");
            }else{
                dp[row][column]=symbol;
            }
            if (dp[randomrow][randomcolumn]=="x" || dp[randomrow][randomcolumn]=="o"){
                randomrow=rand.get(random.nextInt(rand.size()));
                randomcolumn=rand.get(random.nextInt(rand.size()));
                dp[randomrow][randomcolumn]=cpuString;
            }else{
                dp[randomrow][randomcolumn]=cpuString;
            }
            int q=0;
            int w=2;
            int e=4;
            // |||
            if (row==q||row==w||row==e){
                if(dp[row][0]==symbol &&dp[row][2]==symbol&&dp[row][4]==symbol){
                    System.out.println("You Won");
                    ans=false;
                }
            }
            if (column==q||column==w||column==e){
                if(dp[0][column]==symbol &&dp[2][column]==symbol&&dp[4][column]==symbol){
                    System.out.println("You Won");
                    ans=false;
                }
            }
            if (randomrow==q||randomrow==w||randomrow==e){
                if(dp[randomrow][0]==cpuString &&dp[randomrow][2]==cpuString &&dp[randomrow][4]==cpuString){
                    System.out.println("PC Won!! Better luck next time!");
                    ans=false;
                }
            }
            if (randomcolumn==q||randomcolumn==w||randomcolumn==e){
                if(dp[0][randomcolumn]==cpuString &&dp[2][randomcolumn]==cpuString &&dp[4][randomcolumn]==cpuString){
                    System.out.println("PC Won!! Better luck next time!");
                    ans=false;
                }
            }
            // X
            if(dp[0][4]==symbol && dp[2][2]==symbol && dp[4][0]==symbol){
                System.out.println("You Won!");
                ans=false;
            }
            if(dp[0][0]==symbol && dp[2][2]==symbol && dp[4][4]==symbol){
                System.out.println("You Won!");
                ans=false;
            }
            if(dp[0][4]==cpuString && dp[2][2]==cpuString && dp[4][0]==cpuString){
                System.out.println("PC Won!! Better luck next time!");
                ans=false;
            }
            if(dp[0][0]==cpuString && dp[2][2]==cpuString && dp[4][4]==cpuString){
                System.out.println("PC Won!! Better luck next time!");
                ans=false;
            }
            for(int i=0;i<dp.length;i++){
                for (int j=0;j<dp[i].length;j++){
                    String val= dp[i][j];
                    System.out.print(val+" ");
                }
                System.out.println();
            }
        }
    }
}