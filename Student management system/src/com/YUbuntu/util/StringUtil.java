package com.YUbuntu.util;

/**
 * @Project Student management system
 * @Package com.YUbuntu.util
 * @Description The tool
 * @Author #YUbuntu
 * @Date Dec 27, 2018-11:40:28 AM
 * @version 1.0
 */
public class StringUtil
{
	public static boolean IsEmpty(String string)
	{
		if("".equals(string)||string==null)	//Be careful not to write: : string.equals("")
			return true;
		return false;
	}
}
