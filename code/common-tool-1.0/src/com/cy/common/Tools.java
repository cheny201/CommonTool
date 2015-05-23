package com.cy.common;

import java.util.Collection;

/**
 * 公共工具类
 * @author ChenY201
 * @version 1.0
 * @created 2015-5-23 下午7:53:45
 */
public class Tools {
	
	/**
	 * 向集合中连续添加指定对象n次
	 * 
	 * @param c
	 *            待添加对象的集合
	 * @param num
	 *            添加次数
	 * @param obj
	 *            添加的对象
	 */
	public static <T> void fillList(Collection<T> c, int num, T obj) {
		if (c == null)
			return;
		for (int x = 0; x < num; x++)
			c.add(obj);
	}

	/**
	 * 向集合中连续添加指定类型的对象n次
	 * 
	 * @param c
	 *            待添加对象的集合
	 * @param num
	 *            添加次数
	 * @param clazz
	 *            对象类型
	 */
	public static <T> void fillList(Collection<T> c, int num, Class<T> clazz) {
		if (c == null)
			return;
		for (int x = 0; x < num; x++) {
			try {
				c.add(clazz.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
				c.add(null);
			}
		}
	}

	/**
	 * 给指定字符串补长度
	 * @param value 指定字符
	 * @param len 需要补足的长度
	 * @param str 填充字符串
	 * @param position 0-在前面填充；其他-在后面填充
	 * @return
	 */
	public static String makeLength(String value, int len, String str,
			int position) {
		int needLen = len - value.trim().length();
		int bLen = str.length();
		if(needLen > 0 && bLen > 0){
			StringBuffer returnStr = new StringBuffer();
			while (needLen>0) {
				returnStr.append(str);
				needLen -= bLen;
			}
			returnStr.delete(len - value.trim().length(), returnStr.length());
			switch (position) {
				case 0:
					returnStr.append(value.trim());
					break;
				default:
					returnStr.insert(0, value.trim());
					break;
				}
			return returnStr.toString();
		}else{
			return value;
		}
		
	}
}
