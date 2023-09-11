package com.ecommerce;

import java.util.Comparator;

public class IDComparator implements Comparator<Products>
{
	public int compare(Products p1, Products p2)
	{
		if(p1.getProductId() == p2.getProductId())
			return 0;
		else if(p1.getProductId() > p2.getProductId())
			return 1;
		else
			return -1;
		
	}
	
	

}
