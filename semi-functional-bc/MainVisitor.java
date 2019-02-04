/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

import java.lang.Math;

public class MainVisitor {
    private static class Visitor extends GrammarBaseVisitor<Integer> {

        @Override
        public Integer visitParens(GrammarParser.ParensContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Integer visitMulDiv(GrammarParser.MulDivContext ctx) {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.MUL) {
                return left * right;
            } else {
                return left / right;
            }
        }

        @Override
        public Integer visitAddSub(GrammarParser.AddSubContext ctx) {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.ADD) {
                return left + right;
            } else {
                return left - right;
            }
        }
        
        @Override 
        public Integer visitModolo(GrammarParser.ModoloContext ctx)
        {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.MOD) 
            {
                return left % right;
            }
            else
                return visitChildren(ctx);
        }
        
        @Override
        public Integer visitPower(GrammarParser.PowerContext ctx)
        {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.op.getType() == GrammarParser.POW) 
            {
                return (int)Math.pow(left, right);
            }
            else
                return visitChildren(ctx);
        }
        
        @Override
        public Integer visitPreIncrement(GrammarParser.PreIncrementContext ctx)
        {
            int left = visit(ctx.expr());
            ++left;
            return left;
        }
        
        @Override
        public Integer visitPreDecrement(GrammarParser.PreDecrementContext ctx)
        {
            int left = visit(ctx.expr());
            --left;
            return left;
        }
        
        @Override
        public Integer visitPostIncrement(GrammarParser.PostIncrementContext ctx)
        {
            int left = visit(ctx.expr());
            left++;
            return left;
        }
        
        @Override
        public Integer visitPostDecrement(GrammarParser.PostDecrementContext ctx)
        {
            int left = visit(ctx.expr());
            left--;
            return left;
        }
        
        @Override
        public Integer visitNegation(GrammarParser.NegationContext ctx) //Needs work
        {
            return -1*visit(ctx.expr()); //Doesn't work correctly'
        }
        
        @Override
        public Integer visitNot(GrammarParser.NotContext ctx) //Needs work
        {
            return 1; //Placeholder value, edit later
        }
        
        @Override
        public Integer visitSqrt(GrammarParser.SqrtContext ctx) 
        {
            int left = visit(ctx.expr());
            return (int)Math.sqrt(left);
        }
        
        @Override
        public Integer visitGreaterThan(GrammarParser.GreaterThanContext ctx)
        {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if(left > right)
            {
                return 1;
            }
            else
                return 0;
        }
        
        @Override
        public Integer visitGreaterThanOrEqual(GrammarParser.GreaterThanOrEqualContext ctx)
        {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if(left >= right)
            {
                return 1;
            }
            else
                return 0;
        }
        
        @Override
        public Integer visitLessThan(GrammarParser.LessThanContext ctx)
        {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if(left < right)
            {
                return 1;
            }
            else
                return 0;
        }
        
        @Override
        public Integer visitLessThanOrEqual(GrammarParser.LessThanOrEqualContext ctx)
        {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if(left <= right)
            {
                return 1;
            }
            else
                return 0;
        }
        
        @Override
        public Integer visitSine(GrammarParser.SineContext ctx)
        {
            int left = visit(ctx.expr());
            return (int)Math.sin(left);
        }
        @Override
        public Integer visitCosine(GrammarParser.CosineContext ctx)
        {
            int left = visit(ctx.expr());
            return (int)Math.cos(left);
        }
        @Override
        public Integer visitEToTheX(GrammarParser.EToTheXContext ctx)
        { 
            int left = visit(ctx.expr());
            return (int)Math.exp(left);
        }
        @Override
        public Integer visitNatLog(GrammarParser.NatLogContext ctx)
        {
            int left = visit(ctx.expr());
            return (int)Math.log(left);
        }

        @Override
        public Integer visitInt(GrammarParser.IntContext ctx) {
            return Integer.valueOf(ctx.INT().getText());
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

        Visitor eval = new Visitor();
        System.out.println(eval.visit(tree));
    }
}
