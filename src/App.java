import java.util.Scanner;

import javax.annotation.processing.SupportedOptions;

public class App {

    static int top = -1;
    static char[] pile;
    static int size;

    public static void main(String[] args) throws Exception {
     Scanner pad = new Scanner(System.in);
     String text;
     System.out.println("Digite uma palavra");
     text = pad.nextLine();
     size = text.length();
     pile = new char[size];

     for(int pos = 0; pos < size; pos ++){
        try{
            insert(text.charAt(pos));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     }

     for( int pos = 0; pos < size; pos++){
        try{
            System.out.println(remove());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     }
    }

    public static boolean isEmpty(){
        return (top == -1) ? true : false;
    }

    public static boolean isFull(){
        return (top + 1) == size ? true : false;
    }

    public static void insert(char l) throws Exception{
        if(! isFull()){
            pile[++top] = l;
        }else{
            throw new Exception("Pilha cheia!");
        }
    }

    public static char remove() throws Exception{
        if(! isEmpty()){
            return pile[top--];
        }else{
            throw new Exception("Pilha vazia!");
        }
    }

}
