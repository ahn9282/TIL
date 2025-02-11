package study.exception;

public class RetryExceptionHandling {
    private static final int MAX_TRY=6;
    public static void main(String[] args) {

        int tryMax = MAX_TRY;
        while(tryMax -- > 0){
            try{

                return;
            }catch(Exception e){

            }finally {

            }
        }
        throw new RetryException();
    }
}
