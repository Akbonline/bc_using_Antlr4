# bc_using_Antlr4
Unix basic calculator(bc) tool using Antlr4

Usage:

antlr4 -no-listener -visitor Grammar.g4
javac Grammar*.java MainVisitor.java
java MainVisitor file.bc


To view the tree:

grun Grammar prog -gui file.bc

or

grun Grammar prog -tree file.bc
