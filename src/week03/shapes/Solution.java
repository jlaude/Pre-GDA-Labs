package week03.shapes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    static class point {
        int x1;
        int y1;

        public point(int x1, int y1){
            this.x1 = x1;
            this.y1 = y1;
        }
    }

    static class triangle {
        float x1;
        float y1;
        float x2;
        float y2;
        float x3;
        float y3;

        public triangle(int x1, int y1, int x2, int y2, int x3, int y3){
            this.x1 = (float) x1;
            this.y1 = (float) y1;
            this.x2 = (float) x2;
            this.y2 = (float) y2;
            this.x3 = (float) x3;
            this.y3 = (float) y3;
        }

        public float triangleArea(){
            return Math.abs((this.x1 * (this.y2 - this.y3)) + (this.x2 * (this.y3 - this.y1)) + (this.x3 * (this.y1 - this.y2))) / 2;
        }
    }

    static class rectangle {
        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;

        public rectangle(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public float rectangleLength() {
            Integer[] xArray = {this.x1, this.x2, this.x3};
            float maxX = (float) Collections.max(Arrays.asList(xArray));
            float minX = (float) Collections.min(Arrays.asList(xArray));

            float recLen;
            recLen = maxX - minX;
            return recLen;

        }

            public float rectangleHeight() {
                Integer[] yArray = {this.y1, this.y2, this.y3};
                float maxY =  (float) Collections.max(Arrays.asList(yArray));
                float minY = (float) Collections.min(Arrays.asList(yArray));

                float recHeight;
                recHeight = maxY - minY;
                return recHeight;

        }
    }

    static class segment {
        int x1;
        int y1;
        int x2;
        int y2;


        public segment(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public float segmentLength(){
            return (float) Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        int arrayLen = 6;
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
            point p1 = new point(twoDArray[i][0],twoDArray[i][1]);
            point p2 = new point(twoDArray[i][2],twoDArray[i][3]);
            point p3 = new point(twoDArray[i][4],twoDArray[i][5]);

            segment seg1 = new segment(p1.x1,p1.y1,p2.x1,p2.y1);
            segment seg2 = new segment(p2.x1,p2.y1,p3.x1,p3.y1);
            segment seg3 = new segment(p3.x1,p3.y1,p1.x1,p1.y1);

            triangle tri = new triangle(p1.x1,p1.y1,p2.x1,p2.y1,p3.x1,p3.y1);

            rectangle rec = new rectangle(p1.x1,p1.y1,p2.x1,p2.y1,p3.x1,p3.y1);

            float ta = tri.triangleArea();
            float tp = seg1.segmentLength() + seg2.segmentLength() + seg3.segmentLength();

            float ra = Math.abs(rec.rectangleHeight()) * Math.abs(rec.rectangleLength());
            float rp = Math.abs(rec.rectangleLength()) *2 + 2* Math.abs(rec.rectangleHeight());

            System.out.printf("Case #" + caseNum + ": %.2f %.2f %.2f %.2f%n",ta,tp,ra,rp);

        }

    }
}
