import java.io.*;
import java.util.*;

public class _BOJ_Stack_S3_17413 {
    static public void main(String args[]){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
            String inputData = reader.readLine();
            
            boolean reverse = true;
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < inputData.length(); i++){
                char c = inputData.charAt(i);
                if(c == '<'){
                    reverse = false;
                }else if(c == '>'){
                    reverse = true;
                }

                if(c == '<' || c == ' '){
                    while(!stack.empty()){
                        writer.write(stack.pop());
                    }
                    writer.write(c);
                }else if(c == '>'){
                    writer.write(c);
                }
                else{
                    if(reverse){
                        stack.push(c);
                    }else{
                        writer.write(c);
                    }
                }
            }

            while(!stack.empty()){
                writer.write(stack.pop());
            }

        } catch (Exception e) {  }
    }
}
