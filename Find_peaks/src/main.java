import java.util.ArrayList;

public class main {

    public static void main(String args[]) throws Exception {

        final int num = 1440;                                   //数据规模
        int n = num / 60;                                       //平滑数据的系数
        int accuracy = 2;                                       //判别精度(值越大，精度越小)
        double[] data = new double[num];                        //接收原始数据
        double[] norm = new double[num];                        //接收归一化后数据
        double[] smo = new double[num / n];                     //接收平滑数据
        int[] trend = new int[num / n];                         //接收数据的趋势
        ArrayList<Integer> coordinate = new ArrayList<>();      //接收伪突变点坐标(平滑过后的)
        ArrayList<Integer> output = new ArrayList<>();          //接收真突变点坐标
        String Path = "data.txt";                              //数据存放路径

        readData read = new readData();                         //从本地读取txt
        handleData handle = new handleData();                   //处理数据
        findPeaks find = new findPeaks();                       //找突变点

        read.readTxt(data, Path);

        handle.normalize(data, norm);
        handle.smooth(norm, smo, n);

        find.trend(smo, trend);
        find.find(trend, coordinate, accuracy);
        find.restore(coordinate, output, n);

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }

    }
}
