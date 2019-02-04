grammar Grammar;

expr: expr op=('*'|'/') expr # MulDiv
    | expr op=('+'|'-') expr # AddSub
    | expr op='%' expr #modolo
    | expr op='^' expr #power
    | expr'++' #PostIncrement
    | expr'--' #PostDecrement
    | '++'expr #PreIncrement
    | '--'expr #PreDecrement
    | '-'expr #Negation
    | VAR op='=' expr #setVariable
    | expr '>' expr #greaterThan
    | expr '>=' expr #greaterThanOrEqual
    | expr '<' expr #lessThan
    | expr '<=' expr #lessThanOrEqual
    | '!'expr #not
    | expr op=('&&'|'||') expr #andOr
    | 'sqrt''('expr')' #sqrt
    | 's''('expr')' #sine
    | 'c''('expr')' #cosine
    | 'l''('expr')' #natLog
    | 'e''('expr')' #eToTheX
    | INT                    # Int
    | '('expr')'             # Parens
    ;


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
WS : [ \t\r\n]+ -> skip ;
