package cn.demo.java.collection;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ShallowCopy {

	public static void main(String[] args) {
        // 气球数量
        int ballonNum = 7;
        // 第一个箱子
        Balloon[] box1 = new Balloon[ballonNum];
        // 初始化第一个箱子中的气球
        for (int i = 0; i < ballonNum; i++) {
            box1[i] = new Balloon(Color.values()[i], i);
        }
        // 第二个箱子的气球是拷贝第一个箱子里的
        Balloon[] box2 = Arrays.copyOf(box1, box1.length);
        // 修改最后一个气球颜色
        box2[6].setColor(Color.Blue);
        // 打印出第一个箱子中的气球颜色
        for (Balloon b : box1) {
            System.out.println(b);
        }

    }

	
}

//气球颜色
enum Color {
    Red, Orange, Yellow, Green, Indigo, Blue, Violet
}

//气球
class Balloon {
    // 编号
    private int id;
    // 颜色
    private Color color;

    public Balloon(Color _color, int _id) {
        color = _color;
        id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        //apache-common-lang包下的ToStringBuilder重写toString方法
        return new ToStringBuilder(this).append("编号", id).append("颜色", color).toString();
    }

}


