import java.util.List;

//Classe para remover caracteres
public class Remove {
    
    //Remove caracteres indesejados
    public static String removeChar(String S){
        S = removeSpace(S);
        S = removeEMark(S);
        S = removeQMark(S);

        return S;
    }

    //Remove ponto e vírgula, sem interferir nos arquivos base
    public static List<List<String>> internalRemove(List<List<String>> List, int count1, int[] count2){
        for(int i = 0; i < count1; i++){
            for(int j = 0; j < count2[i]; j++)
                List.get(i).set(j, listRemove(List.get(i).get(j))); 
            
        }

        return List;
    }

    //Remove caracteres indesejados
    private static String listRemove(String S){
        S = removeDot(S);
        S = removeComma(S);

        return S;
    }

    //Remove os espaços da String
    private static String removeSpace(String S){
        return S.replace(" ", "");
    }

    //Remove os pontos da String
    private static String removeDot(String S){
        return S.replace(".", "");
    }

    //Remove as virgulas da String
    private static String removeComma(String S){
        return S.replace(",", "");
    }

    //Remove as exclamações da String
    private static String removeEMark(String S){
        return S.replace("!", "");
    }

     //Remove as interrogações da String
     private static String removeQMark(String S){
        return S.replace("?", "");
    }
}
