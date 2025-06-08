package study.lang.string;

public final class String_demo {

    private final char[] valueBefore;//Java 9 before
    private final byte[] value;//Java 9 after

    public String_demo(char[] valueBefore, byte[] value) {
        this.valueBefore = valueBefore;
        this.value = value;
    }
    public java.lang.String concat(String str){
        return this.concat(str);
    }

    public int length(){
        return this.value.length;
    }
    //.....
}
