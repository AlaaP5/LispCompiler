parser grammar LispParser;

options {
    tokenVocab = LispLexer;
}

// (Root Rule)
program: expression* EOF;

functionCall:
    OPEN_BRACKETS SYMBOL expression* CLOSE_BRACKETS;

// (Expressions)
expression:
    comparisonOp
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


comparisonOp:
    OPEN_BRACKETS (PERCENT | AND | OR | NOT | EQUALW | GREATER_THAN | LESS_THAN | GREATER_EQUAL | LESS_EQUAL | EQUAL | PLUS | DIVIDE | MULTIPLY | MINUS) expression expression CLOSE_BRACKETS;

// (Atoms)
atom:
    comparisonOp
    | NUMBER
    | STRING
    | BOOLEAN
    | SYMBOL
    | NIL;



// (Function Definition)
functionDef:
    OPEN_BRACKETS DEFUN SYMBOL OPEN_BRACKETS SYMBOL* CLOSE_BRACKETS expression+ CLOSE_BRACKETS;


// (Variable Definition)
variableDef:
    OPEN_BRACKETS (DEFPARAMETER | SETQ) SYMBOL expression CLOSE_BRACKETS;

// (Conditional)
conditional:
    OPEN_BRACKETS IF expression expression (expression)? CLOSE_BRACKETS
    | OPEN_BRACKETS COND (
        OPEN_BRACKETS expression expression CLOSE_BRACKETS
    )+ CLOSE_BRACKETS;

// (Loop Expressions)
loopExpression:
    OPEN_BRACKETS (LOOP | WHILE) expression+ CLOSE_BRACKETS;

// (Let Binding)
letBinding:
    OPEN_BRACKETS LET OPEN_BRACKETS (
        OPEN_BRACKETS SYMBOL expression CLOSE_BRACKETS
    )* CLOSE_BRACKETS expression+ CLOSE_BRACKETS;


// Lambda
lambdaExpression:
    OPEN_BRACKETS LAMBDA OPEN_BRACKETS SYMBOL* CLOSE_BRACKETS expression+ CLOSE_BRACKETS;


// (Built-in Function Call)
builtInFunctionCall:
    OPEN_BRACKETS (
        FORMAT
        | APPLY
        | FUNCALL
        | OPEN
        | EOF
    ) expression* CLOSE_BRACKETS;
