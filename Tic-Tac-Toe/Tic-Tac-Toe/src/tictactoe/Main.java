package tictactoe;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String[] sarr=new String[9];
        for(int i=0;i<9;i++){
            sarr[i]=" ";
        }

        printGrid(sarr);
        String currentPlayer="X";

//        if(ImpossibleCond(sarr)==true){
//            System.out.println("Impossible");
//        }else if(xWins(sarr)==true&&oWins(sarr)==true){
//            System.out.println("Impossible");
//        }else if(xWins(sarr)==true){
//            System.out.println("X wins");
//        }else if(oWins(sarr)==true){
//            System.out.println("O wins");
//        }else if(gameNotFinished(sarr)==true){
//            System.out.println("Game not finished");
//        }else{
//            System.out.println("Draw");
//        }
            scanner.nextLine();
            System.out.print("Enter the coordinates: ");
            boolean truth=true;
                while(truth){
                    String  y =scanner.nextLine();
                    if(isInputValid(y,sarr,currentPlayer)==true){
                        if(xWins(sarr)){
                            System.out.println("X wins");
                            truth=false;
                        }else if(oWins(sarr)){
                            System.out.println("O wins");
                            truth=false;
                        }else if(!gameNotFinished(sarr)){
                            System.out.println("Draw");
                            truth=false;
                        }else{
                            if(currentPlayer.equals("X")){
                                currentPlayer="O";
                            }else{
                                currentPlayer="X";
                            }
                        }
                    }
                }







    }
    public static boolean xWins(String[] sarr){
        if((sarr[0].equals("X")&&sarr[1].equals("X")&&sarr[2].equals("X"))||
                (sarr[3].equals("X")&&sarr[4].equals("X")&&sarr[5].equals("X"))||
        (sarr[6].equals("X")&&sarr[7].equals("X")&&sarr[8].equals("X"))||
        (sarr[0].equals("X")&&sarr[4].equals("X")&&sarr[8].equals("X"))||
                (sarr[2].equals("X")&&sarr[4].equals("X")&&sarr[6].equals("X"))||
                (sarr[0].equals("X")&&sarr[3].equals("X")&&sarr[6].equals("X"))||
                (sarr[1].equals("X")&&sarr[4].equals("X")&&sarr[7].equals("X"))||
                (sarr[2].equals("X")&&sarr[5].equals("X")&&sarr[8].equals("X"))
        ){
            return true;

        }
        return false;
    }
    public static boolean oWins(String[] sarr){
        if((sarr[0].equals("O")&&sarr[1].equals("O")&&sarr[2].equals("O"))||
                (sarr[3].equals("O")&&sarr[4].equals("O")&&sarr[5].equals("O"))||
                (sarr[6].equals("O")&&sarr[7].equals("O")&&sarr[8].equals("O"))||
                (sarr[0].equals("O")&&sarr[4].equals("O")&&sarr[8].equals("O"))||
                (sarr[2].equals("O")&&sarr[4].equals("O")&&sarr[6].equals("O"))||
                (sarr[0].equals("O")&&sarr[3].equals("O")&&sarr[6].equals("O"))||
                (sarr[1].equals("O")&&sarr[4].equals("O")&&sarr[7].equals("O"))||
                (sarr[2].equals("O")&&sarr[5].equals("O")&&sarr[8].equals("O"))
        ){
            return true;

        }
        return false;
    }
    public static boolean gameNotFinished(String[] sarr){
        for(int i =0;i<9;i++){
            if(sarr[i].equals(" ")){
                return true;
            }
        }
        return false;
    }
    public static boolean isInputValid(String s,String[] sarr,String currentPlayer){
        String x=s.split(" ")[0];
        String y=s.split(" ")[1];
        try {
            int Xcoor=Integer.parseInt(x);
            int Ycoor=Integer.parseInt(y);
            if(Xcoor>3||Xcoor<1||Ycoor>3||Ycoor<1){
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
            else if(sarr[indexMod(Xcoor,Ycoor)].equals(" ")==false){
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }else{
                sarr[indexMod(Xcoor,Ycoor)]=currentPlayer;
                printGrid(sarr);
            }

        }catch(Exception e){
            System.out.println("You should enter numbers!");
            return false;
        }

        return true;
    }

    public static int indexMod(int x,int y){
        if(x==1&&y==1){
            return 6;
        }else if(x==1&&y==2){
            return 3;
        }else if(x==1&&y==3){
            return 0;
        }else if(x==2&&y==1){
            return 7;
        }else if(x==2&&y==2){
            return 4;
        }else if(x==2&&y==3){
            return 1;
        }else if(x==3&&y==1){
            return 8;
        }else if(x==3&&y==2){
            return 5;
        }else{
            return 2;
        }
    }

    public static void printGrid(String[] sarr){

        System.out.println("---------");
        for(int i=0;i<9;i++){
            if(i%3==0){
                System.out.print("| ");
            }
            System.out.print(sarr[i]+" ");
            if((i+1)%3==0){
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.println("---------");
    }


    public static boolean ImpossibleCond(String[] sarr){
        int xcount=0;
        int ocount=0;
        for(int i=0;i<9;i++){
            if(sarr[i].equals("X")){
                xcount++;
            }else if(sarr[i].equals("O")){
                ocount++;
            }
        }
        if(xcount>ocount&&xcount-ocount>1){
            return true;
        }else if(xcount<ocount&&ocount-xcount>1){
            return true;
        }
        return false;
    }
}
