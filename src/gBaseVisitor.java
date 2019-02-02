
public class gBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements gVisitor<T> {

	@Override public T visitPrule(gParser.PruleContext ctx) { return visitChildren(ctx); }
}