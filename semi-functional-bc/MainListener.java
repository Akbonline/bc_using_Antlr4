import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Stack;

public class MainListener {
    private static class Listener extends GrammarBaseListener {

        private Stack<Integer> stack = new Stack<Integer>();

        public int getResult() {
            return stack.peek();
        }

        @Override
        public void exitMulDiv(GrammarParser.MulDivContext ctx) {
            int right = stack.pop();
            int left = stack.pop();
            int result;
            if (ctx.op.getType() == GrammarParser.MUL) {
                result = left * right;
            } else {
                result = left / right;
            }
            stack.push(result);
        }

        @Override
        public void exitAddSub(GrammarParser.AddSubContext ctx) {
            int right = stack.pop();
            int left = stack.pop();
            int result;
            if (ctx.op.getType() == GrammarParser.ADD) {
                result = left + right;
            } else {
                result = left - right;
            }
            stack.push(result);
        }

        @Override
        public void exitModolo(GrammarParser.ModoloContext ctx)
        {
            int right = stack.pop();
            int left = stack.pop();
            int result = 0;
            if (ctx.op.getType() == GrammarParser.MOD)
            {
                result = left % right;
            }
            stack.push(result);
        }

        @Override
        public void exitPower(GrammarParser.PowerContext ctx)
        {
            int right = stack.pop();
            int left = stack.pop();
            int result = 0;
            if (ctx.op.getType() == GrammarParser.POW)
            {
                result = (int)Math.pow(left, right);
            }
            stack.push(result);
        }

        @Override
        public void exitPreIncrement(GrammarParser.PreIncrementContext ctx)
        {
            int left = stack.pop();
            int result;
            ++left;
            result = left;
            stack.push(result);
        }

        @Override
        public void exitPreDecrement(GrammarParser.PreDecrementContext ctx)
        {
            int left = stack.pop();
            int result;
            --left;
            result = left;
            stack.push(result);
        }

        @Override
        public void exitPostIncrement(GrammarParser.PostIncrementContext ctx)
        {
            int left = stack.pop();
            int result;
            left++;
            result = left;
            stack.push(result);
        }

        @Override
        public void exitPostDecrement(GrammarParser.PostDecrementContext ctx)
        {
            int left = stack.pop();
            int result;
            left--;
            result = left;
            stack.push(result);
        }

        @Override
        public void exitNegation(GrammarParser.NegationContext ctx) //Needs work
        {
            int result;
            result = -1*stack.pop(); //Doesn't work correctly'
            stack.push(result);
        }

        @Override
        public void exitNot(GrammarParser.NotContext ctx) //Needs work
        {
            int result;
            result = 1; //Placeholder value, edit later
            stack.push(result);
        }

        @Override
        public void exitSqrt(GrammarParser.SqrtContext ctx)
        {
            int left = stack.pop();
            int result;
            result = (int)Math.sqrt(left);
            stack.push(result);
        }

        @Override
        public void exitGreaterThan(GrammarParser.GreaterThanContext ctx)
        {
            int right = stack.pop();
            int left = stack.pop();
            int result;
            if(left > right)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
            stack.push(result);
        }

        @Override
        public void exitGreaterThanOrEqual(GrammarParser.GreaterThanOrEqualContext ctx)
        {
            int right = stack.pop();
            int left = stack.pop();
            int result;
            if(left >= right)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
            stack.push(result);
        }

        @Override
        public void exitLessThan(GrammarParser.LessThanContext ctx)
        {
            int right = stack.pop();
            int left = stack.pop();
            int result;
            if(left < right)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
            stack.push(result);
        }

        @Override
        public void exitLessThanOrEqual(GrammarParser.LessThanOrEqualContext ctx)
        {
            int right = stack.pop();
            int left = stack.pop();
            int result;
            if(left <= right)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
            stack.push(result);
        }

        @Override
        public void exitSine(GrammarParser.SineContext ctx)
        {
            int left = stack.pop();
            int result;
            result = (int)Math.sin(left);
            stack.push(result);
        }
        @Override
        public void exitCosine(GrammarParser.CosineContext ctx)
        {
            int left = stack.pop();
            int result;
            result = (int)Math.cos(left);
            stack.push(result);
        }
        @Override
        public void exitEToTheX(GrammarParser.EToTheXContext ctx)
        {
            int left = stack.pop();
            int result;
            result = (int)Math.exp(left);
            stack.push(result);
        }
        @Override
        public void exitNatLog(GrammarParser.NatLogContext ctx)
        {
            int left = stack.pop();
            int result;
            result = (int)Math.log(left);
            stack.push(result);
        }

        @Override
        public void exitInt(GrammarParser.IntContext ctx) {
            stack.push(Integer.valueOf(ctx.INT().getText()));
        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GrammarLexer lexer = new GrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //System.out.println(tokens.getText());

        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.expr(); // parse

        ParseTreeWalker walker = new ParseTreeWalker();
        Listener listener = new Listener();
        walker.walk(listener, tree);
        System.out.println(listener.getResult());

    }
}
