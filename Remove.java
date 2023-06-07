import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Remove {
    
    //Percorre todos os arquivos do conjunto
    public static void removeSpecChar(List<String> arquivos) throws IOException{
        for (String str : arquivos) 
            Remove.removerCaracteresEspeciais(str);
    }

    //Remove caracteres especiais
    private static void removerCaracteresEspeciais(String arquivo)  throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        StringBuilder conteudo = new StringBuilder();
        String linha;
        
        //Substitui os caracters por espaços em branco
        while ((linha = reader.readLine()) != null) {
            linha = linha.replaceAll("[,!?.]", "");
            
            conteudo.append(linha).append("\n");
        }
        reader.close();

        //Recoloca as palavras nos arquivos sem os caracters especiais
        PrintWriter writer = new PrintWriter(arquivo);
        writer.print(conteudo.toString());
        
        writer.close();
    }

    //Remove palavras desconsideradas
    public static List<List<String>> WordRemove(List<List<String>> List, int count1, int[] count2, List<String> list2, int count3){
        for(int i = 0; i < count1; i++){
            for(int j = 0; j < count2[i]; j++){

                //Compara cada palavra com a lista inteira de palavras desconsideradas (vê se tem como melhorar se n, esquece)
                for(int k = 0; k < count3; k++){
                    if(List.get(i).get(j).equals(list2.get(k))){
                        List.get(i).remove(list2.get(k));
                        count2[i]--;
                    }    
                }
            }
        }

        return List;
    }

    
}