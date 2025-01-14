import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class LispASTVisitor extends LispParserBaseVisitor<String> {

    @Override
    public String visitProgram(LispParser.ProgramContext ctx) {
        StringBuilder result = new StringBuilder("Program:\n");
        for (LispParser.ExpressionContext expression : ctx.expression()) {
            result.append(visit(expression)).append("\n");
        }
        return result.toString();
    }

    @Override
    public String visitComparisonOp(LispParser.ComparisonOpContext ctx) {
        String operator = ctx.getChild(1).getText();
        String operationName;

        switch (operator) {
            case "+":
                operationName = "Addition";
                break;
            case "-":
                operationName = "Subtraction";
                break;
            case "*":
                operationName = "Multiplication";
                break;
            case "/":
                operationName = "Division";
                break;
            case ">":
                operationName = "Greater_than";
                break;
            case "<":
                operationName = "Less_than";
                break;
            case ">=":
                operationName = "Greater_equal";
                break;
            case "<=":
                operationName = "Less_equal";
                break;
            case "=":
                operationName = "Equal";
                break;
            case "/=":
                operationName = "Not_Equal";
                break;
            case "%":
                operationName = "Rest";
                break;
            case "and":
                operationName = "And";
                break;
            case "or":
                operationName = "Or";
                break;
            case "not":
                operationName = "Not";
                break;
            case "equal":
                operationName = "Equal";
                break;
            default:
                operationName = "Unknown Operation";
        }

        String leftOperand = visit(ctx.expression(0));
        String rightOperand = visit(ctx.expression(1));
        return "Arithmetic : (" + "operation: " + operationName + " \n\t| Left: " + leftOperand + " \n\t| Right: " + rightOperand + ")";
    }

    @Override
    public String visitPrintStatement(LispParser.PrintStatementContext ctx) {
        String value = visit(ctx.expression());
        return "PrintStatement:\n" + value;
    }

    @Override
    public String visitAtom(LispParser.AtomContext ctx) {
        if (ctx.SYMBOL() != null) return "Symbol: " + ctx.SYMBOL().getText();
        if (ctx.NUMBER() != null) return "Number: " + ctx.NUMBER().getText();
        if (ctx.STRING() != null) return "String: " + ctx.STRING().getText();
        if (ctx.BOOLEAN() != null) return "Boolean: " + ctx.BOOLEAN().getText();
        return "NIL";
    }

    @Override
    public String visitFunctionDef(LispParser.FunctionDefContext ctx) {

        String name = ctx.SYMBOL(0).getText();
        StringBuilder params = new StringBuilder("Params: ");

        for (int i = 1; i < ctx.SYMBOL().size(); i++) {

            params.append(ctx.SYMBOL(i).getText()).append(" ");
        }

        StringBuilder body = new StringBuilder();
        for (LispParser.ExpressionContext expression : ctx.expression()) {
            body.append(visit(expression)).append("\n");
        }
        return "Function: " + name + "\n" + params + "\nBody:\n" + body;
    }

    @Override
    public String visitVariableDef(LispParser.VariableDefContext ctx) {
        String command = ctx.getStart().getText();
        String name = ctx.SYMBOL().getText();
        String value = visit(ctx.expression());
        return "Variable Definition: " + command + " " + name + " = " + value;
    }

    @Override
    public String visitConditional(LispParser.ConditionalContext ctx) {
        if (ctx.IF() != null) {
            String condition = visit(ctx.expression(0));
            String trueBranch = visit(ctx.expression(1));
            String falseBranch = ctx.expression(2) != null ? visit(ctx.expression(2)) : "NIL";

            return "If Condition:\nCondition: " + condition + "\nTrue Branch: " + trueBranch + "\nFalse Branch: " + falseBranch;
        } else if (ctx.COND() != null) {

            StringBuilder result = new StringBuilder("Cond Expression:\n");
            for (LispParser.ExpressionContext expr : ctx.expression()) {
                result.append(visit(expr)).append("\n");
            }
            return result.toString();
        }
        return null;
    }


    @Override
    public String visitLoopExpression(LispParser.LoopExpressionContext ctx) {
        String command = ctx.getStart().getText();
        StringBuilder body = new StringBuilder();
        for (LispParser.ExpressionContext expression : ctx.expression()) {
            body.append(visit(expression)).append("\n");
        }
        return "Loop (" + command + "):\n" + body;
    }

    @Override
    public String visitLetBinding(LispParser.LetBindingContext ctx) {
        StringBuilder bindings = new StringBuilder("Bindings:\n");
        for (LispParser.ExpressionContext binding : ctx.expression()) {
            bindings.append(visit(binding)).append("\n");
        }
        StringBuilder body = new StringBuilder();
        for (LispParser.ExpressionContext expression : ctx.expression()) {
            body.append(visit(expression)).append("\n");
        }
        return "Let Binding:\n" + bindings + "\nBody:\n" + body;
    }

    @Override
    public String visitLambdaExpression(LispParser.LambdaExpressionContext ctx) {
        StringBuilder params = new StringBuilder("Params: ");
        for (int i = 0; i < ctx.SYMBOL().size(); i++) {
            params.append(ctx.SYMBOL(i).getText()).append(" ");
        }
        StringBuilder body = new StringBuilder();
        for (LispParser.ExpressionContext expression : ctx.expression()) {
            body.append(visit(expression)).append("\n");
        }
        return "Lambda Expression:\n" + params + "\nBody:\n" + body;
    }

    @Override
    public String visitBuiltInFunctionCall(LispParser.BuiltInFunctionCallContext ctx) {
        String command = ctx.getChild(1).getText();
        StringBuilder args = new StringBuilder("\nArgs:\n");
        for (LispParser.ExpressionContext expression : ctx.expression()) {
            args.append(visit(expression)).append("\n");
        }
        return "Built-in Function Call : " + command + args;
    }

    @Override
    public String visitFunctionCall(LispParser.FunctionCallContext ctx) {
        String functionName = ctx.SYMBOL().getText();
        StringBuilder args = new StringBuilder("Arguments:\n");

        for (LispParser.ExpressionContext expression : ctx.expression()) {
            args.append(visit(expression)).append("\n");
        }

        return "Function Call: " + functionName + "\n" + args;
    }
}
