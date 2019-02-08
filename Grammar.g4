grammar Grammar;

prog: stat+ ;

stat: expr NEWLINE #printExpr
    | ID '=' expr NEWLINE #assign
    | ID '=' 'read()' NEWLINE expr #assign
    | NEWLINE #blank
    ;

expr: SUB expr #Negation
    | expr op=('||'|'&&') expr #andOr
    | '!'expr #not
    | expr '>' expr #greaterThan
    | expr '>=' expr #greaterThanOrEqual
    | expr '<' expr #lessThan
    | expr '<=' expr #lessThanOrEqual
    | expr '==' expr #isEqualTo
    | expr op=('+'|'-') expr # AddSub
    | expr op=('*'|'/'|'%') expr # MulDivMod
    | expr op='^' expr #power
    | expr'++' #PostIncrement
    | expr'--' #PostDecrement
    | '++'expr #PreIncrement
    | '--'expr #PreDecrement
    | 'sqrt''('expr')' #sqrt
    | 's''('expr')' #sine
    | 'c''('expr')' #cosine
    | 'l''('expr')' #natLog
    | 'e''('expr')' #eToTheX
    | INT           # Int
    | ID #id
    | '('expr')'    # Parens
    ;

ID:  [_a-zA-Z]+ ;
STRING: '"' .*? '"' ;
INT: [0-9]+ ;
MUL: '*' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;
MOD: '%' ;
POW: '^' ;
EQ: '=' ;
GT: '>' ;
GE: '>=';
LT: '<' ;
LE: '<=' ;
INCR: '++';
DECR: '--';
COMMENT: '/*' .*? '*/' -> skip ;
NEWLINE:'\r'? '\n' ;
WS : [ \t]+ -> skip ;
SPACE: ' ' -> skip ;
