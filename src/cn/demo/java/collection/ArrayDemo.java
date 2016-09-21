package cn.demo.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
	
	public static void main(String[] args) {
		int datas[] = new int[10];
		for(int i=0;i<10;i++){
			datas[i]=(int) (Math.random()*10);
			System.out.print(datas[i]+" ");
		}
		System.out.println();
		System.out.println(sum(datas));
		int length = 10;
		List<Integer> dataList = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			dataList.add(Integer.valueOf((int) (Math.random()*10)));
		}
		
		System.out.println(dataList);
		System.out.println(sum(dataList));
		
		//一个班级最多容纳60个学生
	        Integer [] stuNums= new Integer[60];
	        //stuNums初始化......
	        //偶尔一个班级可以容纳80人，数组加长
	        stuNums=expandCapacity(stuNums,80);
	        /* 重新初始化超过限额的20人...... */
	        System.out.println(stuNums.length);

	}
	
	public static int sum(int datas[]){
		int sum = 0;
		for(int i=0;i<datas.length;i++){
			sum+=datas[i];
		}
		return sum;
		
	}
	
	// 对列表求和计算
    public static int sum(List<Integer> datas) {
        int sum = 0;
        for (int i = 0; i < datas.size(); i++) {
            sum += datas.get(i);
        }
        return sum;
    }
    
    public static <T> T[] expandCapacity(T[] datas, int newLen) {
        // 不能是负值
        newLen = newLen < 0 ? 0 : newLen;
        // 生成一个新数组,并拷贝原值
        return Arrays.copyOf(datas, newLen);
    }

}
