//Importa as Classes que vamos usar no programa
import java.util.*;
import java.io.IOException;

//Classe Principal
public class Indice{
    
    //Metodo main
    public static void main(String[] args) throws IOException{
        //Listas
        List<String> strSet = new ArrayList<String>();  //Lista para guardar os dados do arquivo de conjuntos(conjunto.txt)
        List<String> strInconsiderate = new ArrayList<String>();  //Lista para guardadar os dados do arquivo desconsiderados(desconsideradas.txt)
        List<String> strQuery = new ArrayList<String>();  //Lista para guardar os dados do arquivo de consulta(consulta.txt)
        List<List<String>> strBaseFile = new ArrayList<List<String>>(); //Lista para guardar os arquivos que estão na lista conjunto.txt

        //Contadores
        int countFilesSet = Arqv.readFile(strSet, "conjunto.txt");  //Faz a leitura dos arquivo conjunto.txt
        int countFilesinconsiderate = Arqv.readFile(strInconsiderate, "desconsideradas.txt");  //Faz a leitura dos arquivo desconsideradas.txt
        int coutFilesQuery = Arqv.readFile(strQuery, "consulta.txt");  //Faz a leitura dos arquivo consulta.txt
        int[] count = new int[countFilesSet];  //Array para guardar a quantidade de palavras dos arquivos do arquivo conjunto.txt

        
        //faz a leitura do arquivo conjunto.txt
        strBaseFile = Arqv.readArqv(strBaseFile, strSet, countFilesSet, count);

        //Remove pontos e virgulas
        strBaseFile = Remove.internalRemove(strBaseFile, countFilesSet, count);

        //Remove palavras desconsideradas
        strBaseFile = Remove.WordRemove(strBaseFile, countFilesSet, count, strInconsiderate, countFilesinconsiderate);
        
        //Imprime o indice
        Print(strBaseFile, countFilesSet, count);
    }

    public static void Print(List<List<String>> List, int count1, int[] count){
        for(int i = 0; i < count1; i++){
            for(int j = 0; j < count[i]; j++)
                System.out.printf("%s\n", List.get(i).get(j)); //Desse jeito podemos acessar os indices da lista de listas, get(i) é um arquivo e get(j) é uma palavra do arquivo
            
            System.out.printf("\n");
        }
    }


}