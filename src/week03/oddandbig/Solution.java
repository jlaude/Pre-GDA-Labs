package week03.oddandbig;

import java.util.Scanner;

class Solution {

    static class oddAndBig {
        int x;
        int y;
        int z;

        public oddAndBig(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean checkOddAndBig(){
            return this.x % 2 != 0 && this.y % 2 != 0 && this.z % 2 != 0 && this.x > 10 && this.y > 10 && this.z > 10;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int lines = in.nextInt();
        in.nextLine();
        int arrayLen = 3;
        int[][] twoDArray = new int[lines][arrayLen];
        for (int i=0; i < lines; i++){

            for (int j = 0; j < arrayLen; j++) {
                if(in.hasNext()) {
                    twoDArray[i][j] = in.nextInt();
                }
            }
            in.nextLine();
        }

        for (int i = 0; i < lines; i++) {
            int caseNum = i + 1;
            oddAndBig oAB = new oddAndBig(twoDArray[i][0],twoDArray[i][1],twoDArray[i][2]);
            if (oAB.checkOddAndBig()){
                System.out.println("Case #"+ caseNum +": Yes");
            } else{
                System.out.println("Case #" + caseNum + ": No");
            }

        }

    }
}
