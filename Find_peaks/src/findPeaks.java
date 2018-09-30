import java.util.ArrayList;

public class findPeaks {

    /**
     * 用数组记录数据的趋势走向
     * @param source 平滑后数据
     * @param tre    趋势走向数组
     */
    public void trend(double[] source, int[] tre) {

        tre[0] = -1;
        for (int i = 0; i < source.length - 1; i++) {
            if (source[i + 1] >= source[i]) {
                tre[i + 1] = 1;
            } else {
                tre[i + 1] = -1;
            }
        }
    }

    /**
     * 找出突变点
     * @param source 趋势走向数组
     * @param loc    伪突变点坐标
     * @param acc    精度
     */
    public void find(int[] source, ArrayList<Integer> loc, int acc) {

        int flag_down = 0, flag_up = 0;

        for (int i = 0; i < source.length; i++) {
            if (source[i] == -1) {
                if (flag_up >= acc) {
                    loc.add(i);
                    flag_up = 0;
                }
                flag_down++;
            } else {
                if (flag_down >= acc) {
                    loc.add(i);
                    flag_down = 0;
                }
                flag_up++;
            }
        }
    }

    /**
     * 根据伪突变坐标，还原出真实的突变坐标
     * @param soucer 伪突变坐标数组
     * @param out    真突变坐标数组
     * @param n      平滑系数
     */
    public void restore(ArrayList<Integer> soucer, ArrayList<Integer> out, int n) {

        for (int i = 0; i < soucer.size(); i++) {
            out.add(soucer.get(i) * n);
        }
    }
}
