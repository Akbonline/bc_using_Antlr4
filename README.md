# bc_using_Antlr4
Unix basic calculator(bc) tool using Antlr4
COP4020 UF Spring 2019 Project 1


#Usage:

antlr4 -no-listener -visitor Grammar.g4

javac Grammar*.java MainVisitor.java

java MainVisitor <testFile.bc>


#To view the tree:

grun Grammar prog -gui <testFile.bc>

or

grun Grammar prog -tree <testFile.bc>
