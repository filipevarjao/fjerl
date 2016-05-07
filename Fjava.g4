grammar Fjava;


classDeclaration
    :   'class' Identifier typeParameters?
        ('extends' type)?
        classBody
    ;

classBody
    :   '{' classBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   ';'
    |   block
    |   memberDeclaration
//    |   classDeclaration // maybe not
    ;

memberDeclaration
    :   methodDeclaration
    |   fieldDeclaration
    |   constructorDeclaration
    ;

methodDeclaration
    :   type Identifier formalParameters ('[' ']')*
        (   methodBody
        |   ';'
        )
    ;

fieldDeclaration
    :   type variableDeclarators ';'
    ;

constructorDeclaration
    :   Identifier formalParameters
        constructorBody
    ;

formalParameters
    :   '(' formalParameterList? ')'
    ;

formalParameterList
    :   formalParameter (',' formalParameter)* (',' lastFormalParameter)?
    |   lastFormalParameter
    ;

formalParameter
    :   type variableDeclaratorId
    ;

lastFormalParameter
    :   type '...' variableDeclaratorId
    ;

variableDeclarators
    :   variableDeclarator (',' variableDeclarator)*
    ;

variableDeclarator
    :   variableDeclaratorId ('=' variableInitializer)?
    ;

variableInitializer
    :   expression
    ;

variableDeclaratorId
    :   Identifier ('[' ']')*
    ;

methodBody
    :   block
    ;

constructorBody
    :   block
    ;

block
    :   '{' blockStatement* '}'
    ;

blockStatement
    :   statement
    ;

statement
    :   block
    |   'return' expression? ';'
    |   ';'
    |   statementExpression ';'
    |   Identifier ':' statement
    ;

statementExpression
    :   expression
    ;

expression
    :   primary
    |   expression '.' Identifier
    |   expression '.' 'this'
    |   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    |   expression '.' 'super' superSuffix
    |   expression '[' expression ']'
    |   expression '(' expressionList? ')'
    |   'new' creator
    |   '(' type ')' expression
    |   <assoc=right> expression
        (   '='
        )
        expression
    ;

expressionList
    :   expression (',' expression)*
    ;

primary
    :   '(' expression ')'
    |   'this'
    |   'super'
    |   Identifier
    ;

creator
    :   nonWildcardTypeArguments createdName classCreatorRest
    |   createdName (classCreatorRest)
    ;

createdName
    :   Identifier typeArgumentsOrDiamond? ('.' Identifier typeArgumentsOrDiamond?)*
    |   primitiveType
    ;

innerCreator
    :   Identifier nonWildcardTypeArgumentsOrDiamond? classCreatorRest
    ;

superSuffix
    :   arguments
    |   '.' Identifier arguments?
    ;

classCreatorRest
    :   arguments classBody?
    ;

arguments
    :   '(' expressionList? ')'
    ;

typeArgumentsOrDiamond
    :   '<' '>'
    |   typeArguments
    ;

nonWildcardTypeArguments
    :   '<' typeList '>'
    ;

typeList
    :   type (',' type)*
    ;

nonWildcardTypeArgumentsOrDiamond
    :   '<' '>'
    |   nonWildcardTypeArguments
    ;

// lembrete

typeArguments
    :   '<' typeArgument (',' typeArgument)* '>'
    ;

typeArgument
    :   type
    |   '?' (('extends' | 'super') type)?
    ;

typeParameters
    :   '<' typeParameter (',' typeParameter)* '>'
    ;

typeParameter
    :   Identifier ('extends' typeBound)?
    ;

typeBound
    :   type ('&' type)*
    ;

type
    :   classType ('[' ']')*
    |   primitiveType ('[' ']')*
    ;

classType
    :   Identifier typeArguments? ('.' Identifier typeArguments? )*
    ;

primitiveType
    :   'boolean'
    |   'int'
    ;

BOOLEAN       : 'boolean';
INT           : 'int';
EXTENDS       : 'extends';
SUPER         : 'super';
RETURN        : 'return';
NEW           : 'new';
CLASS         : 'class';

BooleanLiteral
    :   'true'
    |   'false'
    ;

IntegerLiteral
    :   DecimalIntegerLiteral
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;

fragment
IntegerTypeSuffix
    :   [lL]
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

// §3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// §3.12 Operators

ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
TILDE           : '~';
QUESTION        : '?';
COLON           : ':';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';
MOD             : '%';

ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
AND_ASSIGN      : '&=';
OR_ASSIGN       : '|=';
XOR_ASSIGN      : '^=';
MOD_ASSIGN      : '%=';
LSHIFT_ASSIGN   : '<<=';
RSHIFT_ASSIGN   : '>>=';
URSHIFT_ASSIGN  : '>>>=';

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;