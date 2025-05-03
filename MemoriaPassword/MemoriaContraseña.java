import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MemoriaContraseña {
    public static void main(String[] args){
        memoriaPassword();
    }

    static void memoriaPassword(){
        Scanner scan2 = new Scanner(System.in);
        
        int diff = 1;
        StringBuilder passIn = new StringBuilder();
        StringBuilder password = new StringBuilder();
        byte intentos = 0;

        System.out.println("que dificultad desea? (1-tres digitos 2-seis digitos, etc): ");
        diff = scan2.nextInt();
        scan2.nextLine();
        
        password = genCadena(diff);
        

        System.out.printf("CONTRASEÑA: %s ", password);
        
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(Exception e){
            System.out.println(e);
        }
       
        limpiaPantalla();
        
        while(intentos != 3){
        passIn.append(scan2.nextLine());
            
        if(areTheSame(passIn, password)){
            System.out.println("correcto!!");
            break;
        }else{
            System.out.println("incorrecto!");
            passIn.delete(0, passIn.length());
            intentos++;
        }
       }

        scan2.close();
    }
    
    static StringBuilder genCadena(int pDificultad){
        int i = 0, j = 0;
        Random rand = new Random();
            
        char[] enteros = {'0','1','2','3','4','5','6','7','8','9'};
        char[] abc = {'a', 'e', 'i', 'o', 'u', '+', '#', '_', '.', '-'};
        
        StringBuilder cadena = new StringBuilder();
        
        while(j != pDificultad){
            i = rand.nextInt(9);
            cadena.append(abc[i]);
            cadena.append(enteros[i]);
            cadena.append(abc[i+1]);
            j++;
        }

        return cadena;
    }

    static void limpiaPantalla(){
        byte i = 0;
        
        for(i=0; i<20; i++){
            System.out.printf("\n \n \n \n");
        }
    }

    static boolean areTheSame(StringBuilder str1, StringBuilder str2){
        boolean result = false;
        int i=0;

        if(str1.length() == str2.length()){
            result = true;

            for(i=0; i<str1.length(); i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    
                }else{
                    result = false;
                    break;
                }
            }
            
        }else{
            
        }

        return result;
    } 

}
