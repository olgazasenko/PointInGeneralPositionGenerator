/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointingeneralpositiongenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olga
 */
public class PointInGeneralPositionGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String filePath = "/Users/ozasenko/Documents/NetBeansProjects/";
            PrintWriter writerCSD = new PrintWriter(filePath + "CountFlopsCSD/data/paint2.txt", "UTF-8");
            //PrintWriter writerBrute = new PrintWriter(filePath + "CountFLOBruteForce/data/K3N10000.txt", "UTF-8");

            //int n = 0;
            int k = 10;
            int t = 0, index1, index2;
            writerCSD.println(String.valueOf(k));
            //writerBrute.println(String.valueOf(k));
            HashMap<Double, Integer> map = new HashMap<>();

            Random rand = new Random();
            int n = 6000;
            //int max = 1700, min = 1680;
            int minCoord = -500, maxCoord = 500, ni = n / k, 
                    nLeftOver = n - ni * (k - 1);
            for (int i = 0; i < k; i++) {
                //ni = rand.nextInt((max - min) + 1) + min;
                //n += ni;
                if (i == k - 1) {
                    ni = nLeftOver;
                }
                writerCSD.println(String.valueOf(ni));
                //writerBrute.println(String.valueOf(ni));

                for (int j = 0; j < ni; j++) {
                    double x = rand.nextInt((maxCoord - minCoord) + 1) + minCoord;
                    double y = rand.nextInt((maxCoord - minCoord) + 1) + minCoord;
                    if (x == 0 && y == 0) {
                        j--;
                        continue;
                    }
                    double theta = Math.toDegrees(Math.atan2(y, x));
                    if (theta < 0.0) {
                        theta += 360.0;
                    }
                    if (theta < 0.0 || theta >= 360.0) {
                        System.out.println("ATTENTION");
                    }
                    try {
                        index1 = map.get(theta);
                    } catch (Exception e) {
                        index1 = -1;
                    }
                    try {
                        index2 = map.get((theta + 180.0) % 360.0);
                    } catch (Exception e) {
                        index2 = -1;
                    }
                    if (index1 == -1 && index2 == -1) {
                        map.put(theta, t);
                        writerCSD.println(String.valueOf(x).concat(" ").concat(String.valueOf(y)));
                        //writerBrute.println(String.valueOf(x).concat(" ").concat(String.valueOf(y)));
                        t++;
                    } else {
                        j--;
                    }
                }
            }
            writerCSD.close();
            //writerBrute.close();
            System.out.println("n = " + n);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(PointInGeneralPositionGenerator.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}
