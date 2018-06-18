/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sayantan
 */
import java.io.File;
import java.util.*;
public class Clusters {
    int k;
    float centroids[][];
    Data data;
    int classLabel[];

    public Clusters(Data data, int k) {
        this.k = k;
        this.data = data;
        centroids = new float[k][data.numFeatures];
        classLabel = new int[data.numData];
        //Random center initialization
        HashSet<Integer> initialCenterIndex = new HashSet<>();
        Random rand = new Random(System.currentTimeMillis());
        while(initialCenterIndex.size() <= k){
            int point = rand.nextInt(data.numData);
            if(!initialCenterIndex.contains(point))
                initialCenterIndex.add(point);
        }
        int x=0;
        for(int i : initialCenterIndex){
            System.arraycopy(data.data[i], 0, centroids[x], 0, data.numFeatures);
            x++;
        }
        
    }
    public void runKmeans(int n){
        int index;
        float squreMinDistance;
        for(int i=0; i<n; i++){
            boolean flag = true;
            float dataSum[][] = new float[k][data.numFeatures];
            int numDataInCluster[] = new int[k];
            Arrays.fill(numDataInCluster, 0);
            Arrays.fill(dataSum, 0);
            for(int j=0; j<data.numData; j++){
                index = 0;
                squreMinDistance = 0;
                for(int r=0; r<data.numFeatures; r++){
                        squreMinDistance += (data.data[j][r]-centroids[0][r])*(data.data[j][r]-centroids[0][r]);
                    }
                for(int m=0; m<k ; m++){
                    float dis =0;
                    for(int r=1; r<data.numFeatures; r++){
                        dis += (data.data[j][r]-centroids[m][r])*(data.data[j][r]-centroids[m][r]);
                    }
                    if(dis < squreMinDistance){
                        dis = squreMinDistance;
                        index = m;
                    }
                }
                if(classLabel[j] != index)
                    flag = false;
                classLabel[j] = index;
                numDataInCluster[index]++;
                for(int r=0; r<data.numFeatures; r++){
                    dataSum[index][r] += data.data[j][r]; 
                }
            }
            if(flag)
                break;
        }
    }
    
}
