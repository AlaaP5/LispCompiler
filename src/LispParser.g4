parser grammar LispParser;

options {
    tokenVocab = LispLexer;
}


program: expression* EOF;


functionCall:
    OPEN_BRACKETS SYMBOL expression* CLOSE_BRACKETS;


expression:
    arithmeticOp
    | comparisonOp
    | functionDef
    | variableDef
    | conditional
    | loopExpression
    | letBinding
    | lambdaExpression
    | builtInFunctionCall
    | functionCall
    | atom
    | printStatement;


printStatement:
    OPEN_BRACKETS PRINT expression CLOSE_BRACKETS;


arithmeticOp:
    OPEN_BRACKETS (PLUS | MINUS | MULTIPLY | DIVIDE | PERCENT) expression expression CLOSE_BRACKETS;


comparisonOp:
    OPEN_BRACKETS (PERCENT | AND | OR | NOT | EQUALW | GREATER_THAN | LESS_THAN | GREATER_EQUAL | LESS_EQUAL | EQUAL) expression expression CLOSE_BRACKETS;


atom:
    comparisonOp
    | NUMBER
    | STRING
    | BOOLEAN
    | SYMBOL
    | NIL;


functionDef:
    OPEN_BRACKETS DEFUN SYMBOL OPEN_BRACKETS SYMBOL* CLOSE_BRACKETS expression+ CLOSE_BRACKETS;


variableDef:
    OPEN_BRACKETS (DEFPARAMETER | SETQ) SYMBOL expression CLOSE_BRACKETS;


conditional:
    OPEN_BRACKETS IF expression expression (expression)? CLOSE_BRACKETS
    | OPEN_BRACKETS COND (
        OPEN_BRACKETS expression expression CLOSE_BRACKETS
    )+ CLOSE_BRACKETS;


loopExpression:
    OPEN_BRACKETS (LOOP | WHILE) expression+ CLOSE_BRACKETS;


letBinding:
    OPEN_BRACKETS LET OPEN_BRACKETS binding* CLOSE_BRACKETS expression+ CLOSE_BRACKETS;

binding:
    OPEN_BRACKETS SYMBOL expression CLOSE_BRACKETS;


lambdaExpression:
    OPEN_BRACKETS LAMBDA OPEN_BRACKETS SYMBOL* CLOSE_BRACKETS expression+ CLOSE_BRACKETS;


builtInFunctionCall:
    OPEN_BRACKETS (
        FORMAT
        | APPLY
        | FUNCALL
        | OPEN
        | EOF
    ) expression* CLOSE_BRACKETS;
