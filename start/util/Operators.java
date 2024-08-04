package start.util;

public enum Operators {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLE("*");

    private String operator;

    Operators(String operator) {
        this.operator = operator;
    }
    
    public String getOperator(){
        return operator;
    }
}
