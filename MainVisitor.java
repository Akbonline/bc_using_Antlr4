import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;

public class MainVisitor {
    private static class Visitor extends GrammarBaseVisitor<Double> {

        Map<String, Double> memory = new HashMap<String, Double>(); //Store variables
        Boolean format = false;

        @Override
        public Double visitAssign(GrammarParser.AssignContext ctx)
        {
            String id = ctx.ID().getText();
            Double value = visit(ctx.expr());
            memory.put(id, value);

            return value;
        }

        @Override
        public Double visitPrintExpr(GrammarParser.PrintExprContext ctx)
        {
            Double value = visit(ctx.expr()); // evaluate the expr chil

            if(Math.floor(value) == value && !format) //Check if output is a whole number
                System.out.println("Output: " + String.format("%.0f", value)); // print the result formatted
            else
            {
                format=false;
                System.out.println("Output: " + String.format("%.13f", value)); //print the result
            }
            return (double)0; // return dummy value
        }

        @Override
        public Double visitId(GrammarParser.IdContext ctx)
        {
            String id = ctx.ID().getText();
            if ( memory.containsKey(id) ) return memory.get(id);
            return (double)0;
        }

        @Override
        public Double visitParens(GrammarParser.ParensContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Double visitMulDivMod(GrammarParser.MulDivModContext ctx) {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.MUL)
            {
                return left * right;
            }
            else if (ctx.op.getType() == GrammarParser.DIV)
            {
                format=true;
                return left / right;
            }
            else if (ctx.op.getType() == GrammarParser.MOD)
            {
                return left % right;
            }
            else return (double)0;
        }

        @Override
        public Double visitAddSub(GrammarParser.AddSubContext ctx) {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.ADD) {
                return left + right;
            } else {
                return left - right;
            }
        }

        @Override
        public Double visitPower(GrammarParser.PowerContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.POW)
            {
                return (Double)Math.pow(left, right);
            }
            else
                return visitChildren(ctx);
        }

        @Override
        public Double visitPreIncrement(GrammarParser.PreIncrementContext ctx)
        {
            Double left = visit(ctx.expr());
            ++left;
            return left;
        }

        @Override
        public Double visitPreDecrement(GrammarParser.PreDecrementContext ctx)
        {
            Double left = visit(ctx.expr());
            --left;
            return left;
        }

        @Override
        public Double visitPostIncrement(GrammarParser.PostIncrementContext ctx)
        {
            Double left = visit(ctx.expr());
            left++;
            return left;
        }

        @Override
        public Double visitPostDecrement(GrammarParser.PostDecrementContext ctx)
        {
            Double left = visit(ctx.expr());
            left--;
            return left;
        }

        @Override
        public Double visitNegation(GrammarParser.NegationContext ctx) //Needs work
        {
            return -1*visit(ctx.expr());
        }

        @Override
        public Double visitNot(GrammarParser.NotContext ctx) //Needs work
        {
            Double expression = visit(ctx.expr());
            if(expression == 0)
              return (double)1;
            else
              return (double)0;
        }

        @Override
        public Double visitSqrt(GrammarParser.SqrtContext ctx)
        {
            format = true;
            Double left = visit(ctx.expr());
            return (Double)Math.sqrt(left);
        }

        @Override
        public Double visitGreaterThan(GrammarParser.GreaterThanContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if(left > right)
            {
                return (double)1;
            }
            else
                return (double)0;
        }

        @Override
        public Double visitGreaterThanOrEqual(GrammarParser.GreaterThanOrEqualContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if(left > right || left.compareTo(right)==0)
            {
                return (double)1;
            }
            else
                return (double)0;
        }

        @Override
        public Double visitLessThan(GrammarParser.LessThanContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if(left < right)
            {
                return (double)1;
            }
            else
                return (double)0;
        }

        @Override
        public Double visitLessThanOrEqual(GrammarParser.LessThanOrEqualContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if(left < right || left.compareTo(right)==0)
            {
                return (double)1;
            }
            else
                return (double)0;
        }

        @Override
        public Double visitIsEqualTo(GrammarParser.IsEqualToContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if(left.compareTo(right)==0)
            {
                return (double)1;
            }
            else
                return (double)0;
        }

        @Override
        public Double visitNotEqualTo(GrammarParser.NotEqualToContext ctx)
        {
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if(left.compareTo(right)!=0)
            {
                return (double)1;
            }
            else
                return (double)0;
        }


        @Override
        public Double visitSine(GrammarParser.SineContext ctx)
        {
            format=true;
            Double left = visit(ctx.expr());
            return (Double)Math.sin(left);
        }
        @Override
        public Double visitCosine(GrammarParser.CosineContext ctx)
        {
            format=true;
            Double left = visit(ctx.expr());
            return (Double)Math.cos(left);
        }
        @Override
        public Double visitEToTheX(GrammarParser.EToTheXContext ctx)
        {
            format=true;
            Double left = visit(ctx.expr());
            return (Double)Math.exp(left);
        }
        @Override
        public Double visitNatLog(GrammarParser.NatLogContext ctx)
        {
            format=true;
            Double left = visit(ctx.expr());
            return (Double)Math.log(left);
        }

        @Override
        public Double visitInt(GrammarParser.IntContext ctx) {
            return Double.valueOf(ctx.INT().getText());
        }
    }
    static String convertStreamToString(java.io.InputStream is)
    {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null )
        {
            is = new FileInputStream(inputFile);
        }

        CharStream input = CharStreams.fromStream(is);
        GrammarLexer lexer = new GrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.prog(); // parse

        Visitor eval = new Visitor();
        eval.visit(tree);

        //Print tree like -tree grun option
        String strTree = "";
        strTree = tree.toStringTree(parser);
        //System.out.println("\n\nTree: \n" + strTree); //Uncomment this to print the tree
    }
}
