import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class launch {

    public static void main(String[] args){
        try {
            String source="test.txt";
            CharStream cs = fromFileName(source);
            gLexer lexer = new gLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            gParser parser = new gParser(token);
            ParseTree tree = parser.prule();
            myVisitor visitor = new myVisitor();
            visitor.visit(tree);

        }catch(IOException e){
            e.PrintStackTrace();
        }
    }
}
