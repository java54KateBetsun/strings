package telran.strings;

public class RegularExpresions {
public static String javaVariable() {
	String regex = "[A-Za-z$][A-Za-z0-9_$]*|_[A-Za-z0-9_$]+";
//	String regex = "[A-Za-z$][\\w$]*|_[\\w$]+";
	return regex;
}
public static String zero_300() {
	//string contains number from 0 - 300; leading zeros are disallowed
	String regex = "[1-9]\\d?|[1-2]\\d\\d|300|0"; // [02468]
	return regex;
}
public static String ipOctet() {
	//string contains 1 - 3 symbols presenting number from 0 - 255;
	// leading zeros are allowed
	return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
}
public static String mobileIsraelPhone() {
	//string contains possible Israel mobile phone number
	//+972-<prefix two digits beginning from 5>-<7 digits of number>
	//<prefix three digits: first - 0, second 5, third - any>-<7 digits>
		//+972-54-7333358
		//054-733-33-58
	return "(\\+972-?|0)5\\d-?(\\d{3}-\\d{2}-|\\d{2}-?\\d{3}-?)\\d{2}";
}
public static String ipV4Address() {
	String ipOctetExpr = ipOctet();
//	return String.format("%s(\\.%s){3}", ipOctetExpr, ipOctetExpr);
	return String.format("%1$s(\\.%1$s){3}", ipOctetExpr); // serial number ipOctetExpr is 1
}
public static String SimpleArithmeticExpression() {
	//operations only binary +,-,*,/
	//operands only integer numbers
	//no brackets
	String operation = operationExp();
	String operand = integerNumberExp();
	return String.format("%1s(%2$s%1$s)*", operand, operation);
}
private static String operationExp() {
	return "[-+*/]";
}
private static String integerNumberExp() {
	return "(\\s*\\d+\\s*)";
}
public static String NumberExp() {
	return "(\\s*(\\d+|[0-9]+.\\d+)\\s*)";
}
public static String arithmeticExpression() {
   String operation = operationExp();
	String operandNum = NumberExp();
    String operandVar = javaVariable();
    String operand = String.format("%s|%s", operandNum, operandVar);
    return String.format("\\(?%1$s(%2$s%1$s\\)*)*\\)*", operand, operation);
//	return "\\(?\\s*((\\d+|[0-9]+.\\d+)|[A-Za-z$][\\w$]*|_[\\w$]+)+\\s*([+\\-*/]\\s*((\\d+|[0-9]+.\\d+)|[A-Za-z$][\\w$]*|_[\\w$]+)+)*\\)*";
}
}

