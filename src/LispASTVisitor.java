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
    public String visitArithmeticOp(LispParser.ArithmeticOpContext ctx) {

        String operator = ctx.getChild(1).getText();
        String operationName = switch (operator) {
            case "+" -> "Addition";
            case "-" -> "Subtraction";
            case "*" -> "Multiplication";
            case "/" -> "Division";
            case "%" -> "Modulus";
            default -> "Unknown Operation";
        };

        String leftOperand = visit(ctx.expression(0));
        String rightOperand = visit(ctx.expression(1));

        return "Arithmetic: (" + operationName +
                " | Left: " + leftOperand +
                " | Right: " + rightOperand + ")";
    }

    @Override
    public String visitComparisonOp(LispParser.ComparisonOpContext ctx) {

        String operator = ctx.getChild(1).getText();
        String operationName = switch (operator) {
            case ">" -> "Greater Than";
            case "<" -> "Less Than";
            case ">=" -> "Greater or Equal";
            case "<=" -> "Less or Equal";
            case "=" -> "Equal";
            case "/=" -> "Not Equal";
            case "and" -> "And";
            case "or" -> "Or";
            case "not" -> "Not";
            default -> "Unknown Comparison";
        };

        String leftOperand = visit(ctx.expression(0));
        String rightOperand = visit(ctx.expression(1));

        return "Comparison: (" + operationName +
                " | Left: " + leftOperand +
                " | Right: " + rightOperand + ")";
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

            params.append(ctx.SYMBOL(i).getText()).append("  ");
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
        for (LispParser.BindingContext bindingCtx : ctx.binding()) {
            bindings.append(visit(bindingCtx)).append("\n");
        }

        StringBuilder body = new StringBuilder("Body:\n");
        for (LispParser.ExpressionContext expressionCtx : ctx.expression()) {
            body.append(visit(expressionCtx)).append("\n");
        }

        return "Let Binding:\n" + bindings + body;
    }

    @Override
    public String visitBinding(LispParser.BindingContext ctx) {

        String variableName = ctx.SYMBOL().getText();
        String value = visit(ctx.expression());
        return "Variable: " + variableName + " = " + value;
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
