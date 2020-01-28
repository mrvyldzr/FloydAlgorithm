
package test;

import java.util.Scanner;
 
public class FloydWarshall
{
    private int[][] matris_uzunluk;
    public int köse_sayisi;
    public static final int sonsuz = 999;
 
    public FloydWarshall(int kösesayisi)
    {
        matris_uzunluk = new int[kösesayisi + 1][kösesayisi + 1];
        this.köse_sayisi = kösesayisi;
    }
 
    public void floydwarshall(int adjacencymatrix[][])
    {
        int i = 1;
        for (int kaynak = 1; kaynak <= köse_sayisi; kaynak++)
        {
            for (int hedef = 1; hedef <= köse_sayisi; hedef++)
            {
                
                matris_uzunluk[kaynak][hedef] = adjacencymatrix[kaynak][hedef];
            }
        }
 
        for (int hedef = 1; hedef <= köse_sayisi; hedef++)
        {
            for (int kaynak = 1; kaynak <= köse_sayisi; kaynak++)
            {
                for (int destination = 1; destination <= köse_sayisi; destination++)
                {
                    if (matris_uzunluk[kaynak][hedef] + matris_uzunluk[hedef][destination]
                         < matris_uzunluk[kaynak][destination]){
                        System.out.print("iterasyon" + i);
                        matris_uzunluk[kaynak][destination] = matris_uzunluk[kaynak][hedef] 
                            + matris_uzunluk[hedef][destination];
                        yazdýr(matris_uzunluk);
                        i++;
                   
                        
                    }
             
                }
          
            }
   
        }
        
    
    }
    
    public void yazdýr(int [][] array){
         System.out.print("\n" );   
         for (int kaynak = 1; kaynak <= köse_sayisi; kaynak++)
            System.out.print("\t" + kaynak);
 
        System.out.println();
        for (int kaynak = 1; kaynak <= köse_sayisi; kaynak++)
        {
            System.out.print(kaynak + "\t");
            for (int destination = 1; destination <= köse_sayisi; destination++)
            {
                System.out.print(matris_uzunluk[kaynak][destination] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void main(String... arg)
    {
        int adjacency_matrix[][];
        int köse_sayisi;
 
        Scanner scan = new Scanner(System.in);
        System.out.println("Köþeleri giriniz: ");
        köse_sayisi = scan.nextInt();
 
        adjacency_matrix = new int[köse_sayisi + 1][köse_sayisi + 1];
        System.out.println("Grafik için Aðýrlýklý Matris giriniz: ");
        for (int source = 1; source <= köse_sayisi; source++)
        {
            for (int destination = 1; destination <= köse_sayisi; destination++)
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
        FloydWarshall floydwarshall = new FloydWarshall(köse_sayisi);
        floydwarshall.floydwarshall(adjacency_matrix);
        scan.close();
    }
}
