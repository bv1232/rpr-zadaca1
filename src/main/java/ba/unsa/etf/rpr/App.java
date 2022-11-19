package ba.unsa.etf.rpr;
/*
*Type App.
*/
public class App 
{
    /*
    * Main method.
    * @param args reads input arguments from the terminal.
    */
    public static void main( String[] args )
    {
        if(args.length != 0){
            String s ="";
            for(String i: args) s = s + i + " ";
            try {
                System.out.println(ExpressionEvaluator.evaluate(s));
            }catch (RuntimeException e){
                System.out.println(e);
            }
        }
        else {
            String s ="( 1 + sqrt ( 0 ) ) ";
            try {
                System.out.println(ExpressionEvaluator.evaluate(s));
            }catch (RuntimeException e){
                System.out.println(e);
            }
        }
    }
}
