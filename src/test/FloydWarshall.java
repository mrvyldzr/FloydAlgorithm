
package test;

import java.util.Scanner;
 
public class FloydWarshall
{
    private int[][] matris_uzunluk;
    public int k�se_sayisi;
    public static final int sonsuz = 999;
 
    public FloydWarshall(int k�sesayisi)
    {
        matris_uzunluk = new int[k�sesayisi + 1][k�sesayisi + 1];
        this.k�se_sayisi = k�sesayisi;
    }
 
    public void floydwarshall(int adjacencymatrix[][])
    {
        int i = 1;
        for (int kaynak = 1; kaynak <= k�se_sayisi; kaynak++)
        {
            for (int hedef = 1; hedef <= k�se_sayisi; hedef++)
            {
                
                matris_uzunluk[kaynak][hedef] = adjacencymatrix[kaynak][hedef];
            }
        }
 
        for (int hedef = 1; hedef <= k�se_sayisi; hedef++)
        {
            for (int kaynak = 1; kaynak <= k�se_sayisi; kaynak++)
            {
                for (int destination = 1; destination <= k�se_sayisi; destination++)
                {
                    if (matris_uzunluk[kaynak][hedef] + matris_uzunluk[hedef][destination]
                         < matris_uzunluk[kaynak][destination]){
                        System.out.print("iterasyon" + i);
                        matris_uzunluk[kaynak][destination] = matris_uzunluk[kaynak][hedef] 
                            + matris_uzunluk[hedef][destination];
                        yazd�r(matris_uzunluk);
                        i++;
                   
                        
                    }
             
                }
          
            }
   
        }
        
    
    }
    
    public void yazd�r(int [][] array){
         System.out.print("\n" );   
         for (int kaynak = 1; kaynak <= k�se_sayisi; kaynak++)
            System.out.print("\t" + kaynak);
 
        System.out.println();
        for (int kaynak = 1; kaynak <= k�se_sayisi; kaynak++)
        {
            System.out.print(kaynak + "\t");
            for (int destination = 1; destination <= k�se_sayisi; destination++)
            {
                System.out.print(matris_uzunluk[kaynak][destination] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int k�se_sayisi;
 
        Scanner scan = new Scanner(System.in);
        System.out.println("K��eleri giriniz: ");
        k�se_sayisi = scan.nextInt();
 
        adjacency_matrix = new int[k�se_sayisi + 1][k�se_sayisi + 1];
        System.out.println("Grafik i�in A��rl�kl� Matris giriniz: ");
        for (int source = 1; source <= k�se_sayisi; source++)
        {
            for (int destination = 1; destination <= k�se_sayisi; destination++)
            {
                adjacency_matrix[source][destination] = scan.nextInt();
                if (source == destination)
                {
                    adjacency_matrix[source][destination] = 0;
                    continue;
                }
                if (adjacency_matrix[source][destination] == 0)
                {
                    adjacency_matrix[source][destination] = sonsuz;
                }
            }
        }
 
        System.out.println("Sonuc");
        FloydWarshall floydwarshall = new FloydWarshall(k�se_sayisi);
        floydwarshall.floydwarshall(adjacency_matrix);
        scan.close();
    }
}
