import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String input = new String(Files.readAllBytes(Paths.get("C:/Users/LENOVO/Desktop/LispCompiler/src/test.lisp")));

        String input1 = new String(Files.readAllBytes(Paths.get("C:/Users/LENOVO/Desktop/LispCompiler/src/test1.lisp")));

        String input2 = new String(Files.readAllBytes(Paths.get("C:/Users/LENOVO/Desktop/LispCompiler/src/test2.lisp")));


        CharStream charStream = CharStreams.fromString(input2);

        LispLexer lexer = new LispLexer(charStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LispParser parser = new LispParser(tokens);

        ParseTree tree = parser.program();

        LispASTVisitor visitor = new LispASTVisitor();
        String result = visitor.visit(tree);

        System.out.println(result);

//        for (Token token : lexer.getAllTokens()) {
//            System.out.println("Token: " + token.getText() + ", Type: " + lexer.getVocabulary().getSymbolicName(token.getType()));
//        }
    }
}