import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Remove {
    
    //Remove caracteres especiais
    public static void removerCaracteresEspeciais(String arquivo)  throws IOException{
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
    
}