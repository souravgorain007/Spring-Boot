package com.sa.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("info")
public class ItemInfo {
	
	@Value("${price.idly}")
	public Float idlyPrice;
	@Value("${price.dosa}")
	public Float dosaPrice;
	@Value("${price.poha}")
	public Float pohaPrice;
	
	@Override
	public String toString() {
		return "ItemInfo [idlyPrice=" + idlyPrice + ", dosaPrice=" + dosaPrice + ", pohaPrice=" + pohaPrice + "]";
	}
	
	

}
