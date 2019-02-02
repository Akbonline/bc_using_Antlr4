public class myVisitor extends gBaseVisitor<Object>{
    @Override public Object visitPrule(gParser.PruleContext ctx) {

        return visitChildren(ctx);

    }
}