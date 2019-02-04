grammar proto1;

exprList: topExpr ( ';' topExpr)* ';'? ; 

varDef: VAR ID '=' expr;

topExpr: expr
    { System.out.println("result: "+ Integer.toString($expr.i));}
;

expr returns [int i]: 
       el=expr op='*' er=expr { $i=$el.i*$er.i; }
    | el=expr op='/' er=expr { $i=$el.i/$er.i; }
    | el=expr op='+' er=expr { $i=$el.i+$er.i; }
    | el=expr op='-' er=expr { $i=$el.i-$er.i; }
    | el=expr op='++' er=expr { $i=$el.i+1; }
    | el=expr op='--' er=expr { $i=$el.i-1; }
    | el=expr op='%' er=expr { $i=$el.i%$er.i; }
    | el=expr op='^' er=expr { $i=$el.i^$er.i; }
    | INT { $i=Integer.parseInt($INT.text); }
    | ID                
    | '(' e=expr ')'
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

ID: [_A-Za-z]+;
INT: [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
