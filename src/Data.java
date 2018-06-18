
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sayantan
 */
class Data {
    int numData;
    int numFeatures;
    float data[][];
    Data(String path) {
        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);
            int n = 0;
            while (!sc.hasNext()) {
                n++;
            }
            sc.close();
            sc = new Scanner(f);
            int m = sc.nextLine().split(",").length;
            this.numData = n;
            this.numFeatures = m;
            sc.close();
            data = new float[n][m];
            sc = new Scanner(f);
            for(int i=0; i<n; i++){
                String s[] = sc.nextLine().split(",");
                if(s.length != m){
                    System.out.println("Data missing");
                    break;
                }
                for(int j=0; j<m; j++){
                    data[i][j] = Float.parseFloat(s[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
