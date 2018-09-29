public class main {

    public static void main(String args[]) throws Exception {

        int n = 24;                                 //平滑数据
        double[] data = new double[1440];           //接收原始数据
        double[] norm = new double[1440];           //接收归一化后数据
        double[] smo = new double[1440 / n];
        String Path = "data.txt";                   //数据存放路径

        readData read = new readData();
        handleData handle = new handleData();

        read.readTxt(data, Path);
        handle.normalize(data, norm);
        handle.smooth(norm, smo, n);

        for (int i = 0; i < smo.length; i++) {
            System.out.println(smo[i]);
        }

    }
}
