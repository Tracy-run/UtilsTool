package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

	public static void main1(String[] args) {
		int a = 5;
		System.out.println(a <<= 1);

		Map map = new HashMap();
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
		}
	}
	
	public static void main(String[] args) {
		String str = "1.2018年1月2日周会行动:岭澳二期DCS机柜房间温度高和主控室温度低问题，上TEF汇报。 "
				+ "2.12月19日月会行动:岭澳二期SEC/RRI泵切换触发换热器压差低信号问题，编写MEMO反馈升版DPO程序。 推动TEU015BA备件的采购"
				+ "4. 3.针对早会L4SEC盘根喷水的异常事件，请分析盘根每次盘根喷水的原因，反馈该现象为何反复发生，并制定改进行动。 ";
		System.out.println(str.toCharArray());
	}
	
}
