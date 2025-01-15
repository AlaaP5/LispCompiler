// Generated from LispParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LispParser}.
 */
public interface LispParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LispParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LispParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LispParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(LispParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(LispParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#internalFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterInternalFunctionCall(LispParser.InternalFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#internalFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitInternalFunctionCall(LispParser.InternalFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#writeExpression}.
	 * @param ctx the parse tree
	 */
	void enterWriteExpression(LispParser.WriteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#writeExpression}.
	 * @param ctx the parse tree
	 */
	void exitWriteExpression(LispParser.WriteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LispParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LispParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(LispParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(LispParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#dolistExpression}.
	 * @param ctx the parse tree
	 */
	void enterDolistExpression(LispParser.DolistExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#dolistExpression}.
	 * @param ctx the parse tree
	 */
	void exitDolistExpression(LispParser.DolistExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpression(LispParser.WhenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpression(LispParser.WhenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOp(LispParser.ArithmeticOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#arithmeticOp}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOp(LispParser.ArithmeticOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOp(LispParser.ComparisonOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOp(LispParser.ComparisonOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#quotedList}.
	 * @param ctx the parse tree
	 */
	void enterQuotedList(LispParser.QuotedListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#quotedList}.
	 * @param ctx the parse tree
	 */
	void exitQuotedList(LispParser.QuotedListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(LispParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(LispParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(LispParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(LispParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void enterVariableDef(LispParser.VariableDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void exitVariableDef(LispParser.VariableDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(LispParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(LispParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#loopExpression}.
	 * @param ctx the parse tree
	 */
	void enterLoopExpression(LispParser.LoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#loopExpression}.
	 * @param ctx the parse tree
	 */
	void exitLoopExpression(LispParser.LoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#letBinding}.
	 * @param ctx the parse tree
	 */
	void enterLetBinding(LispParser.LetBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#letBinding}.
	 * @param ctx the parse tree
	 */
	void exitLetBinding(LispParser.LetBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(LispParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(LispParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(LispParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(LispParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispParser#builtInFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInFunctionCall(LispParser.BuiltInFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispParser#builtInFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInFunctionCall(LispParser.BuiltInFunctionCallContext ctx);
}