/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sayantan
 */
public class Chromosome {
    Gene genes[];
    public static int numGene;
    public static int geneSize;
    float fitness = Float.MIN_VALUE;

    public Chromosome() {
        this.genes = new Gene[numGene];
        for(int i=0; i<numGene; i++)
            genes[i] = new Gene(geneSize);
    }
    //Define or call fitness fuction.......................................
    public void calculateFitness(){
    
    }
    //Crossover.........................................................
    public static void crossover(Chromosome a, Chromosome b){
        for(int i=0; i<numGene; i++){
            int crossoverPoint = Gene.rand.nextInt(geneSize);
            for(int j=crossoverPoint; j<geneSize; j++){
                int temp = a.genes[i].seq[j];
                a.genes[i].seq[j] = b.genes[i].seq[j];
                b.genes[i].seq[j] = temp;
            }
        }
    }
    //Mutation...............................................................
    public void mutation(){
        for(Gene g: genes)
            g.mutation();
    }
    
}
