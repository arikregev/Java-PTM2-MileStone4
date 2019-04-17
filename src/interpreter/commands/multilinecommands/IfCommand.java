package interpreter.commands.multilinecommands;


import java.util.List;

import interpreter.Interpreter.ParseException;
import interpreter.commands.Command;
import interpreter.commands.factory.CommandFactory;
import interpreter.expression.builders.ExpressionBuilder;
import interpreter.expression.logic.BooleanExpression;
import interpreter.symboles.SymbolTable;
import interpreter.symboles.SymbolTable.SymbolException;
/**
 * Defining how our IF Command will behave 
 * 
 * @author Arik Regev
 *
 */
public class IfCommand extends ControlCommand{
	private BooleanExpression exp;
	
	public IfCommand(BooleanExpression exp) {
		this.exp = exp;
	}
	@Override
	public boolean execute(SymbolTable symTable) throws SymbolException {
		if(exp.calculateLogic(symTable)) { 
			return innerCommand.execute(symTable);
		}
		return true;
	}
	public static class Factory extends CommandFactory{
		@Override
		public Command create(List<String> tokens) throws ParseException, SymbolException {
			BooleanExpression booleanExp = new ExpressionBuilder().createBooleanExpression(tokens);
			if (!tokens.isEmpty())
				throw new ParseException("Invalid expression at: " + tokens.get(0));
			return new IfCommand(booleanExp);
			
		}
		
	}

}
