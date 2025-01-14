lexer grammar LispLexer;


// (Arithmetic Operations)
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';


// (Comparison Operators)
EQUAL: '=';
NOT_EQUAL: '/=';
GREATER_THAN: '>';
LESS_THAN: '<';
GREATER_EQUAL: '>=';
LESS_EQUAL: '<=';


// (Keywords)
DEFUN: 'defun';
DEFPARAMETER: 'defparameter';
SETQ: 'setq';
PROGN: 'progn';
RETURN: 'return';
IF: 'if';
COND: 'cond';
LET: 'let';
LOOP: 'loop';
WHILE: 'while';
CASE: 'case';
CATCH: 'catch';
THROW: 'throw';
LAMBDA: 'lambda';


// (Built-in Functions)
OPEN: 'open';
FORMAT: 'format';
APPLY: 'apply';
FUNCALL: 'funcall';
PRINT: 'print';

EQUALW: 'equal';
AND: 'and';
OR: 'or';
NOT: 'not';

// (Special Characters)
COMMA: ',';
QUOTE: '\'';
BACKQUOTE: '`';
TILDE: '~';
AMPERSAND: '&';
DOT: '.';
PIPE: '|';
PERCENT: '%';

// (Symbols)
SYMBOL: [a-zA-Z*+-/<>?='][a-zA-Z0-9*+-/<>?=']*;


// (Parentheses)
OPEN_BRACKETS: '(';
CLOSE_BRACKETS: ')';



// (Literals)
STRING: '"' (~["\\] | '\\' .)* '"';
NUMBER: [+-]?[0-9]+ ('.' [0-9]+)?;
BOOLEAN: 'true' | 'false';
NIL: 'nil';


// (Comments and Whitespace)
COMMENT: ';' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

