import java.util.Arrays;

public class handleData {
    /**
     * 归一化数据，把数据归一化到(0,1)之间
     * @param source     读入数据
     * @param normal     归一化后数据
     */

    public void normalize(double[] source, double[] normal) {
        double min = Arrays.stream(source).min().getAsDouble();
        double max = Arrays.stream(source).max().getAsDouble();
        double d_value = max - min;
        for (int i = 0; i < source.length; i++) {
            normal[i] = (source[i] - min) / d_value;
        }
    }

    /**
     * 平滑数据，每n个点取平均值
     * @param source 读入数据
     * @param smooth 平滑后数据
     * @param n      平滑系数
     */

    public void smooth(double[] source, double[] smooth, int n) {
        double[] tmp = new double[n];
        for (int i = 0; i < source.length; i++) {
            tmp[i % n] = source[i];
            if (i % n == n - 1) {
                double average = Arrays.stream(tmp).sum() / n;
                smooth[((i + 1) / n) - 1] = average;
            }
        }

    }
}
