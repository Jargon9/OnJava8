package java_base.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class readFileExp {
    public void test1111()  throws Exception {
        File file = new File("/Users/jinxingguang/tools/test.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }
}
