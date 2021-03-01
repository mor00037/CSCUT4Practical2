
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;




public class FilesInOut {
    
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("You need to add your own code to do anything");
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println("supply filename for input:");
        
            String inputFileName= in.nextLine();
            File ipf =  new File(inputFileName);
            System.out.println("Input file opened successfully");
            BufferedReader br = new BufferedReader(new FileReader(ipf));
            System.out.println("Input file ready for reading");
         
        String outputFileName= in.nextLine();
        File opf = new File(outputFileName);
        if (opf.createNewFile()) {
            System.out.println("Output File created successfully");
        }else {
            System.out.println("Output File already exists.");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(opf,true));
        System.out.println("Output file ready for writing.");
        
        String line = null;
        String opLine = "";
        StringBuilder builder = new StringBuilder();
        
        while((line = br.readLine()) != null){          
            line = " "+ line;
                for(int i = 0; i<line.length();i++) {
                    char ch = line.charAt(i);
                    Boolean flag = Character.isDigit(line.charAt(i));
                    if(ch == ' '){
                        opLine = opLine + ch;
                        i++;
                        ch = line.charAt(i);
                        opLine = opLine + Character.toUpperCase(ch);
                    }else if(flag){
                        builder.append(ch);
                        if (builder.length()==7) {
                            builder.insert(1,'/');
                            builder.insert(4,'/');
                            
                            opLine = opLine + builder;
                            builder.setLength(0);
                        }   
                    }
                    else {
                        opLine = opLine + ch;
                    }
                }
                opLine = opLine.trim();
                opLine = opLine + "\n";
            
        }
        bw.write(opLine);
        bw.write(builder.toString());
        
        System.out.println("Operations completed :D");
        br.close();
        bw.close();

        
    }


}
