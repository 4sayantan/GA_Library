
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sayantan
 */
public class Gene{
    public static Random rand = new Random();
    public static double mutationProb = 0.1;
    public static float ul = 1.0f;//Set uppper limit here
    public static float ll = 0.5f;
    public static int geneSize = 0;
    //..............................................
    float value = -1;
    public static void seed(long d){
        rand.setSeed(d);
    }
    int seq[];
    Gene(int n){
        geneSize = n;
        seq = new int[n];
        for(int i=0; i<n; i++){
            seq[i] = ((double)0.5 < rand.nextDouble()? 1:0);
        }
    }
    public float getValue(){
        int base = 1;
        int val = 0;
        for(int i: seq){
            val += i*base;
            base *= 2;
        }
        return (ll + ((val/(base-1))*(ul-ll)));
    }
    public void mutation(){
        for(int i=0; i<geneSize; i++){
            if(rand.nextFloat() < mutationProb )
                seq[i] = (seq[i]+1)%2;
        }
    }
}
