/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dflmatrixmaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Imtiaz
 */
public class DFLMatrixMaker {

    BufferedReader br = null;
    public  void  listFilesForFolder(final File folder) throws FileNotFoundException, IOException {
       
        
        int[][] finalMatrix = new int[15][14];
        String over30 = "30+ samples\n";
        int k = 0;
    for (final File fileEntry : folder.listFiles()) {
       String sCurrentLine;
        br = new BufferedReader(new FileReader(fileEntry.getPath()));
        //System.out.println(fileEntry.getName());
         int i=0;
        int j=0;
        float[] data = new float[40];
        while ((sCurrentLine = br.readLine()) != null) {
                                if(i>15)
                                {
				    if (Float.parseFloat(sCurrentLine)>0f && Float.parseFloat(sCurrentLine)<100f)
                                    {
                                        data[j] = Float.parseFloat(sCurrentLine);
                                        j++;
                                    }
                                }
                                i++;
			}
        System.out.println("File name: "+fileEntry.getName()+" Non Zero entries: "+j);
        
        if(j>29)
        {
           for(int index = 0; index< 40; index++)
           {
               if(data[index]>=10f && data[index]<12f)
                   finalMatrix[0][k] +=1;
               else if(data[index]>=12f && data[index]<14f)
                   finalMatrix[1][k] +=1;
               else if(data[index]>=14f && data[index]<16f)
                   finalMatrix[2][k] +=1;
               else if(data[index]>=16f && data[index]<18f)
                   finalMatrix[3][k] +=1;
               else if(data[index]>=18f && data[index]<20f)
                   finalMatrix[4][k] +=1;
               else if(data[index]>=20f && data[index]<22f)
                   finalMatrix[5][k] +=1;
               else if(data[index]>=22f && data[index]<24f)
                   finalMatrix[6][k] +=1;
               else if(data[index]>=24f && data[index]<26f)
                   finalMatrix[7][k] +=1;
               else if(data[index]>=26f && data[index]<28f)
                   finalMatrix[8][k] +=1;
               else if(data[index]>=28f && data[index]<30f)
                   finalMatrix[9][k] +=1;
               else if(data[index]>=30f && data[index]<32f)
                   finalMatrix[10][k] +=1;
               else if(data[index]>=32f && data[index]<34f)
                   finalMatrix[11][k] +=1;
               else if(data[index]>=34f && data[index]<36f)
                   finalMatrix[12][k] +=1;
               else if(data[index]>=36f && data[index]<38f)
                   finalMatrix[13][k] +=1;
               else if(data[index]>=38f && data[index]<40f)
                   finalMatrix[14][k] +=1;
               
               
           }
           k++;
            over30+="C"+k+":"+fileEntry.getName()+"\n";
            //System.out.println(fileEntry.getName()); 
        }
         
        
    }
   
        System.out.println(over30);
        String matrix="";
    for(int mati = 0; mati<15; mati++)
         {
             for(int matj = 0; matj<14; matj++)
             {
                 matrix+=finalMatrix[mati][matj]+" ";
                 System.out.print(finalMatrix[mati][matj]+" ");
             }
             matrix+=";";
             System.out.println();
         }
        System.out.println(matrix);
         TextCopy tc = new TextCopy();
        tc.jTextField1.setText(matrix);
        tc.setVisible(true);
        
}
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        final File folder = new File("./LMF");
        DFLMatrixMaker dm = new DFLMatrixMaker();
        dm.listFilesForFolder(folder);
       

    }
    
}
