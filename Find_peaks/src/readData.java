import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class readData {

    /**
     * 从本地读取.txt文档，文档中每一行是一个数据
     * @param data     从文档中读出数据，放入data数组中
     * @param path     存放文档的路径
     * @throws Exception
     */
    public void readTxt(double[] data,String path) throws Exception {

        Scanner sc = new Scanner(new BufferedReader(new FileReader(path)));
        ArrayList<String> result = new ArrayList<>();
        while (sc.hasNext()){
            result.add(sc.next());
        }
        sc.close();

        for (int i = 0;i<data.length;i++){
            data[i] = Double.parseDouble(result.get(i));
        }

    }


}
