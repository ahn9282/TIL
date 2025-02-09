package study.template_3.dataObject;

import study.template_3.BufferedReaderCallback;
import study.template_3.LineCallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public String concatenate(String filePath) throws IOException {
        LineCallback<String> concatenateCallback = new LineCallback<String>() {
            @Override
            public String doSomethingWithLine(String line, String value) {
                return value + line;
            }
        };
        return lineReadTemplate(filePath, concatenateCallback, "");
    }

    public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filepath));
            T res = initVal;
            String line = null;
            while((line = br.readLine()) != null){
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        }catch(Exception e){
            throw e;
        }finally{
            assert br != null;
            br.close();
        }
    }

    public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));

            int ref = callback.doSomeThingWithReader(br);
            return ref;
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            br.close();
        }

    }

    public Integer calcSumWithGenerateInterface(String filePath) throws IOException {
        BufferedReaderCallback callback = new BufferedReaderCallback() {
            @Override
            public Integer doSomeThingWithReader(BufferedReader br) throws IOException {
                String line = null;
                Integer sum = 0;
                while ((line = br.readLine()) != null) {
                    sum += Integer.valueOf(line);
                }
                return sum;
            }
        };
        BufferedReader br = null;
        Integer sum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));

            int ref = callback.doSomeThingWithReader(br);
            return ref;
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            br.close();
        }

    }
    public Integer calcMultipleWithGenerateInterface(String filePath) throws IOException {
        BufferedReaderCallback callback = new BufferedReaderCallback() {
            @Override
            public Integer doSomeThingWithReader(BufferedReader br) throws IOException {
                String line = null;
                Integer sum = 1;
                while ((line = br.readLine()) != null) {
                    sum *= Integer.valueOf(line);
                }
                return sum;
            }
        };
        BufferedReader br = null;
        Integer sum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));

            int ref = callback.doSomeThingWithReader(br);
            return ref;
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            br.close();
        }

    }



    public Integer calcSumTryCatchFinally(String filePath) throws IOException {
        BufferedReader br = null;
        Integer sum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));

            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.valueOf(line);
            }
            return sum;
        } catch (Exception e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            br.close();
        }

    }

    public Integer calcSum(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Integer sum = 0;
        String line = null;
        while ((line = br.readLine()) != null) {
            sum += Integer.valueOf(line);
        }
        br.close();
        return sum;
    }
}
