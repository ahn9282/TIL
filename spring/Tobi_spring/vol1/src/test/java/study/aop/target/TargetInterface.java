package study.aop.target;

public interface TargetInterface {
    void hello() ;

    void hello(String a);

    int minus(int a , int b) throws RuntimeException;

    int plus(int a, int b);
}
