grammar newprot;

start
    : expr
    | equa
    ;

expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	INT
    |	'(' expr ')'
    ;
equa
    : VAR EQ expr
    | VAR OP VAR
    | VAR
    ;
expr1
    : VAR OP2
    | OP2 VAR
    ;
EQ
    : '='
    ;
OP
    : '+'
    | '-'
    | '*'
    | '/'
    | '%'
    ;
OP2
    : '--'
    | '++'
    ;
OP3
    : '>'
    | '<'
    | '<='
    | '>='
    ;
VAR
   : VALID_ID_START VALID_ID_CHAR*
   ;

fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;
fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
   ;

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;