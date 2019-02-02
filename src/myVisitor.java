public class myVisitor extends gBaseVisitor<Object>{
    @Override public Object visitPrule(gParser.PruleContext ctx) {
        System.out.println("Success");

        return visitChildren(ctx);

    }
}