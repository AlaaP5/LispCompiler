// Generated from LispParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LispParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LispParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LispParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LispParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(LispParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#internalFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInternalFunctionCall(LispParser.InternalFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#writeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteExpression(LispParser.WriteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LispParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(LispParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#dolistExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDolistExpression(LispParser.DolistExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#whenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenExpression(LispParser.WhenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#arithmeticOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOp(LispParser.ArithmeticOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(LispParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#quotedList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedList(LispParser.QuotedListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#operations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperations(LispParser.OperationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(LispParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#variableDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDef(LispParser.VariableDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(LispParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#loopExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopExpression(LispParser.LoopExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#letBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetBinding(LispParser.LetBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(LispParser.BindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(LispParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LispParser#builtInFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionCall(LispParser.BuiltInFunctionCallContext ctx);
}