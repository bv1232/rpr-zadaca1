package ba.unsa.etf.rpr;
import java.util.Stack;
/*
*Type ExpressionEvaluator.
*/
public class ExpressionEvaluator {
    /*
    *@param string an arbitrary string
    *@return boolean value true if the expression is valid
    */
    public static boolean isValid(String string){
        int nO = 0, nC = 0, brZ = 0;
        String[] s = string.split(" ");
        for( String i : s ){
            if (i.equals("(")) nO = nO + 1;
            if (i.equals(")")) nC = nC + 1;
            if (i.equals("+") || i.equals("-") || i.equals("*")
                    || i.equals("/") || i.equals("sqrt") ) brZ = brZ + 1;
        }
        if(nO != nC || nO == 0 || nC == 0 || brZ != nO || string.contains("  "))
            return false;
        return true;
    }
    /*
    *Method evaluate, evaluates the value of the expression using Dijsktra's algorithm.
    *@param string expression as a String.
    *@return returns the evaluation of the expression
    */
    public static Double evaluate(String string){
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        if(ExpressionEvaluator.isValid(string)) {
            String[] s = string.split(" ");
            for (String i : s) {
                if (i.equals(" ")) continue;
                if (i.equals("(")) ;
                else if (i.equals("+")) ops.push(i);
                else if (i.equals("-")) ops.push(i);
                else if (i.equals("*")) ops.push(i);
                else if (i.equals("/")) ops.push(i);
                else if (i.equals("sqrt")) ops.push(i);
                else if (i.equals(")")) {
                    if (ops.isEmpty()) break;
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) v = vals.pop() + v;
                    else if (op.equals("-")) v = vals.pop() - v;
                    else if (op.equals("*")) v = vals.pop() * v;
                    else if (op.equals("/")) {
                        if(v == 0) throw new RuntimeException("!!!Izraz aritmeticki nije validan!!!");
                        v = vals.pop() / v;
                    }
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                } else vals.push(Double.parseDouble(i));
            }
            return vals.pop();
        }
        else {
            throw new RuntimeException("!!!Izraz aritmeticki nije validan!!!");
        }
    }
}
