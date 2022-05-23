package week03.points;

import java.util.Scanner;

class Solution {

    static class points {
        int x1;
        int y1;
        int x2;
        int y2;
        int[] coords1 = new int[2];
        int[] coords2 = new int[2];

        public points(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.coords1[0] = x1;
            this.coords1[1] = y1;
            this.coords2[0] = x2;
            this.coords2[1] = y2;
        }

        public int[] checkPoints(){
            double d1 = Math.sqrt(Math.pow(this.x1,2) + Math.pow(this.y1,2));
            double d2 = Math.sqrt(Math.pow(this.x2,2) + Math.pow(this.y2,2));
            if (d1 < d2){
                return coords1;
            } else {
                return coords2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        int arrayLen = 4;
        int[][] twoDArray = new int[cases][arrayLen];
        for (int i=0; i < cases; i++){

            for (int j = 0; j < arrayLen; j++) {
                if(in.hasNext()) {
                    twoDArray[i][j] = in.nextInt();
                }
            }
            in.nextLine();
        }

        for (int i = 0; i < cases; i++) {
            int caseNum = i + 1;
            points oAB = new points(twoDArray[i][0],twoDArray[i][1],twoDArray[i][2],twoDArray[i][3]);
            System.out.println("Case #"+ caseNum +": "+ oAB.checkPoints()[0] + " " + oAB.checkPoints()[1]);

        }

    }
}
