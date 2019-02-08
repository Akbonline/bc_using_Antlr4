grammar Grammar;

prog: stat+ ;

stat: expr NEWLINE #printExpr
    | ID '=' expr NEWLINE #assign
    | NEWLINE #blank
    ;

expr: VAR op='=' expr #setVariable
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
    | SUB expr #Negation
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

ID: [_a-zA-Z]+ ;
VAR: [_A-Za-z]+ ;
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
