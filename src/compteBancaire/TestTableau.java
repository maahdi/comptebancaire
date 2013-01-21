/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compteBancaire;

/**
 *
 * @author yoshi
 */
public class TestTableau {
    public static void main(String [] args){
        int [][] tab1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int [][] tab2;
        
        int maxLigne = 4;
        int maxColonne = 3;
        
        tab2 = new int[maxColonne][maxLigne];
        int tmp;
        
        for (int i = 0; i < maxLigne; i++){
            for (int j = 0; j < maxColonne; j++){
                tab2 [j][i] = tab1 [i][j];
            }
        }
        
        for (int i = 0; i < maxColonne; i++){
            for (int j = 0; j < maxLigne; j++){
                System.out.print(tab2[i][j]);
            }System.out.println();
        }
    }
}
