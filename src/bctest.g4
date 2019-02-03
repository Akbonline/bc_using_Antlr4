grammar bctest;

exprList: topExpr (';' topExpr)* ';'? ;

varDef: VAR ID '=' expr;

topExpr: expr
   { System.out.println("result: " + Integer.toString($expr.i)); }
   ;
expr returns [int i]
   : el=expr op='*' er=expr {$i=$el.i*$er.i;}
   | el=expr op='/' er=expr {$i=$el.i/$er.i;}
   | el=expr op='+' er=expr {$i=$el.i+$er.i;}
   | el=expr op='-' er=expr {$i=$el.i-$er.i;}
   | el=expr op='++' {$i=$el.i+1;}
   | el=expr op='--' {$i=$el.i-1;}
   | INT {$i=Integer.parseInt($INT.text);}
   ;

VAR: 'var';
ID : [_A-Za-z]+;
INT : [0-9]+;
WS : [ \t\r\n]+ -> skip;
