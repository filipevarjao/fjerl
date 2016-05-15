import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FjavaToOOErlang extends FjavaBaseListener {
	@Override public void enterCompilationUnit(FjavaParser.CompilationUnitContext ctx) {
	}
	@Override public void exitCompilationUnit(FjavaParser.CompilationUnitContext ctx) { }
	
	@Override public void enterTypeDeclaration(FjavaParser.TypeDeclarationContext ctx) { }
	
	@Override public void exitTypeDeclaration(FjavaParser.TypeDeclarationContext ctx) { }
	
	@Override public void enterClassDeclaration(FjavaParser.ClassDeclarationContext ctx) {
		String value = String.valueOf(ctx.Identifier().getText());
		String parentClass = ctx.type().getText();

		System.out.println("-class("+value.toLowerCase()+").");
		if (!new String("Object").equals(parentClass)) {
			System.out.println("-extends("+parentClass.toLowerCase()+").");
		}
		System.out.println();
		
//		System.out.println(ctx.children);
	}
	@Override public void exitClassDeclaration(FjavaParser.ClassDeclarationContext ctx) { }

	@Override public void enterClassBody(FjavaParser.ClassBodyContext ctx) { }
	
	@Override public void exitClassBody(FjavaParser.ClassBodyContext ctx) { }
	
	@Override public void enterClassBodyDeclaration(FjavaParser.ClassBodyDeclarationContext ctx) { }
	
	@Override public void exitClassBodyDeclaration(FjavaParser.ClassBodyDeclarationContext ctx) { }
	
	@Override public void enterMemberDeclaration(FjavaParser.MemberDeclarationContext ctx) { }
	
	@Override public void exitMemberDeclaration(FjavaParser.MemberDeclarationContext ctx) { }
	
	@Override public void enterMethodDeclaration(FjavaParser.MethodDeclarationContext ctx) { }
	
	@Override public void exitMethodDeclaration(FjavaParser.MethodDeclarationContext ctx) { }
	
	@Override public void enterFieldDeclaration(FjavaParser.FieldDeclarationContext ctx) { }

	@Override public void exitFieldDeclaration(FjavaParser.FieldDeclarationContext ctx) { }

	@Override public void enterFormalParameters(FjavaParser.FormalParametersContext ctx) { }

	@Override public void exitFormalParameters(FjavaParser.FormalParametersContext ctx) { }

	@Override public void enterFormalParameterList(FjavaParser.FormalParameterListContext ctx) { }

	@Override public void exitFormalParameterList(FjavaParser.FormalParameterListContext ctx) { }

	@Override public void enterFormalParameter(FjavaParser.FormalParameterContext ctx) { }

	@Override public void exitFormalParameter(FjavaParser.FormalParameterContext ctx) { }

	@Override public void enterLastFormalParameter(FjavaParser.LastFormalParameterContext ctx) { }

	@Override public void exitLastFormalParameter(FjavaParser.LastFormalParameterContext ctx) { }

	@Override public void enterVariableDeclarators(FjavaParser.VariableDeclaratorsContext ctx) { }

	@Override public void exitVariableDeclarators(FjavaParser.VariableDeclaratorsContext ctx) { }

	@Override public void enterVariableDeclarator(FjavaParser.VariableDeclaratorContext ctx) { }

	@Override public void exitVariableDeclarator(FjavaParser.VariableDeclaratorContext ctx) { }
	
	@Override public void enterVariableInitializer(FjavaParser.VariableInitializerContext ctx) { }
	
	@Override public void exitVariableInitializer(FjavaParser.VariableInitializerContext ctx) { }
	
	@Override public void enterVariableDeclaratorId(FjavaParser.VariableDeclaratorIdContext ctx) { }
	
	@Override public void exitVariableDeclaratorId(FjavaParser.VariableDeclaratorIdContext ctx) { }
	
	@Override public void enterMethodBody(FjavaParser.MethodBodyContext ctx) { }
	
	@Override public void exitMethodBody(FjavaParser.MethodBodyContext ctx) { }
	
	@Override public void enterConstructorBody(FjavaParser.ConstructorBodyContext ctx) { }
	
	@Override public void exitConstructorBody(FjavaParser.ConstructorBodyContext ctx) { }
	
	@Override public void enterBlock(FjavaParser.BlockContext ctx) { }
	
	@Override public void exitBlock(FjavaParser.BlockContext ctx) { }
	
	@Override public void enterBlockStatement(FjavaParser.BlockStatementContext ctx) { }
	
	@Override public void exitBlockStatement(FjavaParser.BlockStatementContext ctx) { }
	
	@Override public void enterStatement(FjavaParser.StatementContext ctx) { }
	
	@Override public void exitStatement(FjavaParser.StatementContext ctx) { }
	
	@Override public void enterStatementExpression(FjavaParser.StatementExpressionContext ctx) { }
	
	@Override public void exitStatementExpression(FjavaParser.StatementExpressionContext ctx) { }
	
	@Override public void enterExpression(FjavaParser.ExpressionContext ctx) { }
	
	@Override public void exitExpression(FjavaParser.ExpressionContext ctx) { }
	
	@Override public void enterExpressionList(FjavaParser.ExpressionListContext ctx) { }
	
	@Override public void exitExpressionList(FjavaParser.ExpressionListContext ctx) { }
	
	@Override public void enterPrimary(FjavaParser.PrimaryContext ctx) { }
	
	@Override public void exitPrimary(FjavaParser.PrimaryContext ctx) { }
	
	@Override public void enterCreator(FjavaParser.CreatorContext ctx) { }
	
	@Override public void exitCreator(FjavaParser.CreatorContext ctx) { }
	
	@Override public void enterCreatedName(FjavaParser.CreatedNameContext ctx) { }
	
	@Override public void exitCreatedName(FjavaParser.CreatedNameContext ctx) { }
	
	@Override public void enterInnerCreator(FjavaParser.InnerCreatorContext ctx) { }
	
	@Override public void exitInnerCreator(FjavaParser.InnerCreatorContext ctx) { }
	
	@Override public void enterSuperSuffix(FjavaParser.SuperSuffixContext ctx) { }
	
	@Override public void exitSuperSuffix(FjavaParser.SuperSuffixContext ctx) { }
	
	@Override public void enterClassCreatorRest(FjavaParser.ClassCreatorRestContext ctx) { }
	
	@Override public void exitClassCreatorRest(FjavaParser.ClassCreatorRestContext ctx) { }
	
	@Override public void enterArguments(FjavaParser.ArgumentsContext ctx) { }
	
	@Override public void exitArguments(FjavaParser.ArgumentsContext ctx) { }
	
	@Override public void enterTypeArgumentsOrDiamond(FjavaParser.TypeArgumentsOrDiamondContext ctx) { }
	
	@Override public void exitTypeArgumentsOrDiamond(FjavaParser.TypeArgumentsOrDiamondContext ctx) { }
	
	@Override public void enterNonWildcardTypeArguments(FjavaParser.NonWildcardTypeArgumentsContext ctx) { }
	
	@Override public void exitNonWildcardTypeArguments(FjavaParser.NonWildcardTypeArgumentsContext ctx) { }
	
	@Override public void enterTypeList(FjavaParser.TypeListContext ctx) { }
	
	@Override public void exitTypeList(FjavaParser.TypeListContext ctx) { }
	
	@Override public void enterNonWildcardTypeArgumentsOrDiamond(FjavaParser.NonWildcardTypeArgumentsOrDiamondContext ctx) { }
	
	@Override public void exitNonWildcardTypeArgumentsOrDiamond(FjavaParser.NonWildcardTypeArgumentsOrDiamondContext ctx) { }
	
	@Override public void enterTypeArguments(FjavaParser.TypeArgumentsContext ctx) { }
	
	@Override public void exitTypeArguments(FjavaParser.TypeArgumentsContext ctx) { }
	
	@Override public void enterTypeArgument(FjavaParser.TypeArgumentContext ctx) { }
	
	@Override public void exitTypeArgument(FjavaParser.TypeArgumentContext ctx) { }
	
	@Override public void enterTypeParameters(FjavaParser.TypeParametersContext ctx) { }
	
	@Override public void exitTypeParameters(FjavaParser.TypeParametersContext ctx) { }
	
	@Override public void enterTypeParameter(FjavaParser.TypeParameterContext ctx) { }
	
	@Override public void exitTypeParameter(FjavaParser.TypeParameterContext ctx) { }
	
	@Override public void enterTypeBound(FjavaParser.TypeBoundContext ctx) { }
	
	@Override public void exitTypeBound(FjavaParser.TypeBoundContext ctx) { }
	
	@Override public void enterType(FjavaParser.TypeContext ctx) {
		String value = String.valueOf(ctx.classType().Identifier(0).getText());
		if (value != "Object"){
			
		} 
	}
	@Override public void exitType(FjavaParser.TypeContext ctx) { }
	
	@Override public void enterClassType(FjavaParser.ClassTypeContext ctx) { }
	
	@Override public void exitClassType(FjavaParser.ClassTypeContext ctx) { }
	
	@Override public void enterPrimitiveType(FjavaParser.PrimitiveTypeContext ctx) { }
	
	@Override public void exitPrimitiveType(FjavaParser.PrimitiveTypeContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }
}