lexer grammar QuotationMarks;

@header{package antlr;}

IDENTIFIER       : '"'(~'"' |'""')*'"';