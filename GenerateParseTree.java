import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class GenerateParseTree {
    public static void main(String[] args) throws Exception {
    	
    	InputStream is = null;
    	String inputFile = null;
    	
          if (args.length > 0){ 
        	  inputFile = args[0];
          	  is = System.in;
          }else 
        	  inputFile = "/home/varjao/workspace/Fjava/src/HelloWorld.fjava";
          
          if (inputFile != null) 
        	  is = new FileInputStream(inputFile);
          
        try {
                //is = new FileInputStream("/home/varjao/workspace/fjerl/List.fjava");
                is = new FileInputStream(inputFile);
                String outputFile = inputFile.substring(0, inputFile.length()-5)+"cerl";

                ANTLRInputStream input = new ANTLRInputStream(is);
                FjavaLexer lexer = new FjavaLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                FjavaParser parser = new FjavaParser(tokens);
                ParseTree tree = parser.compilationUnit();
                System.out.println(tree.toStringTree(parser));

                FileWriter cerl = new FileWriter(new File(outputFile));
                BufferedWriter bw = new BufferedWriter(cerl);
                
                bw.write(tree.toStringTree(parser)); //bw.newLine();
                bw.close();
                
            } catch (Exception e) {
              e.printStackTrace();
              }
    }

}
