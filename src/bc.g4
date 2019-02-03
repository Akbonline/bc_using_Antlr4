grammar calc;

expr 
    :expr1 OP expr1 
    |expr<EOF>
    ;

expr1 
    : expr2 ((ADD|SUB) expr2)*
    ;
expr2 
    : expr3 ((MULT|DIV) expr3)*
    ;
expr3 
    : expr4 ((POW expr4))*
    ;
expr4 : ADD expr4
      | SUB expr4
      | expr5
      ;
expr5 : VARIABLE
      | INT
      | LP expr1 RP
      ;
OP : EQ
   | GT
   | LT
   ;

LP : '('
    ;
RP : ')'
   ;
ADD: '+'
    ;
SUB: '-'
     ;
MULT: '*'
     ;
DIV: '/'
   ;
GT
   : '>'
   ;
LT
   : '<'
   ;
EQ
   : '='
   ;
COMMA
   : ','
   ;

VARIABLE
   : FIRST SECOND*
   ;
fragment FIRST
   : ('a' .. 'z')
   ;
fragment SECOND
   : FIRST 
   | ('0' .. '9')
   | ('A' .. 'Z') 
   | '_'
   ;
POINT
   : '.'
   ;
POW
   : '^'
   ;
INT
   : NUM (SIGN? NUM)?
   ;
fragment NUM
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;
fragment SIGN
   : ('+' | '-')
   ;
WS  : [\t\r\n]+ ->skip;
