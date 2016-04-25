lexer grammar SixChar;

@header{package antlr;}

IDENTIFIER                  : (LETTER)(ALPHANUMERIC)(ALPHANUMERIC)(ALPHANUMERIC)(ALPHANUMERIC)(ALPHANUMERIC);
fragment LETTER           : ('a'..'z'|'A'..'Z');
fragment ALPHANUMERIC     : (LETTER|'0'..'9');
WS    : [ \t\r\n]+ -> skip ;