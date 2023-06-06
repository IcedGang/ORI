import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class funcoesResposta{

    //Retorna uma lista com a resposta para a consulta feita
    public static List<String> preencheArqvResposta(Map<String, Map<Integer, Integer>> contadorPalavras, List<String> consulta, List<String> arquivos){
        List<String> resp = new ArrayList<>();
        List<Integer> aux1 = new ArrayList<>(Collections.nCopies(consulta.size(), 0));
        String aux = consulta.get(0);
        
        //Checa se a consulta é para And
        if(aux.contains(",")){
            //Separa as palavras a partir do operador
            String[] aux2 = aux.split(",");

            for (int i = 0; i < aux2.length; i++)
                resp.add(aux2[i]);
            
            int i = 0;
            while(i != resp.size()){
                //Procura as palavras no índice
                for (Map.Entry<String, Map<Integer, Integer>> palavra : contadorPalavras.entrySet()) {
                    if(resp.get(i).equals(palavra.getKey())){
                        Map<Integer, Integer> Arquivos = palavra.getValue();

                        //Adiciona o arquivo encontrado em uma lista
                        for (Map.Entry<Integer, Integer> arquivo : Arquivos.entrySet()) 
                            aux1.add(arquivo.getKey());

                    }
                    
                    break;
                }


                i++;
            }

        }

        //Checa se a consulta é para Or
        else if(aux.contains(";")){
            //Separa as palavras a partir do operador
            String[] aux2 = aux.split(";");

            for (int i = 0; i < aux2.length; i++)
                resp.add(aux2[i]);
            
            //Procura as palavras no índice
            for (Map.Entry<String, Map<Integer, Integer>> palavra : contadorPalavras.entrySet()) {
                if(resp.contains(palavra.getKey())){
                    Map<Integer, Integer> Arquivos = palavra.getValue();

                    //Adiciona o arquivo encontrado em uma lista
                    for (Map.Entry<Integer, Integer> arquivo : Arquivos.entrySet()){
                        if (!aux1.contains(arquivo.getKey())) 
                            aux1.add(arquivo.getKey());
                    }

                }

            }  
        }

        resp.clear();
            
        //O tamanho da lista é a quantidade de arquivos em que a consulta foi encontrada
        resp.add(String.valueOf(aux1.size()));

        for (Integer k : aux1) {
            resp.add(arquivos.get(k));
        }

        return resp;
    }
}
