lexer grammar Music;

@header{package antlr;}

TOKEN1 : 'L'('a')+(' ')*;
TOKEN2 : 'L'('a')+(' ')*'L'('a')+(' ')*;
TOKEN3 : 'L'('a')+(' ')*'L'('a')+(' ')*'L'('a')+(' ')*'Li'(' ')*;
WS    : [ \t\r\n]+ -> skip ;