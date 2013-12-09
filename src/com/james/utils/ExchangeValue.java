package com.james.utils;

public class ExchangeValue {
		public int i=0;
		   public static void main(String args[])
		   {
			   ExchangeValue t1=new ExchangeValue();
			   ExchangeValue t2=t1;
		     t1.i=1;
		     System.out.println(t2.i);
		String a="abc";
		String b=a;
		a="123";
		System.out.println(b);
		}
		}
