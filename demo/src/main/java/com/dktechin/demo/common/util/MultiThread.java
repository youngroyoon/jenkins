package com.dktechin.demo.common.util;

import java.util.Random;

public class MultiThread extends Thread{
	
	//랜덤 난수를 생성해주는 코드
	Random random = new Random();
	
	int lotto[] = new int [10];
	
	public MultiThread(int[] n){
		this.lotto = n;
	}
	
	@Override
	public void run(){
        try{
        	
        	for(int i=0; i<10; i++) {
        		int number = random.nextInt(44)+1;
        		lotto[i] = number;
        		
        		// 중복 번호 제거
    			for(int j=0; j<i; j++) {
    				if(lotto[i] == lotto[j]) {
    					i--;
    					break;
    				}
    			}
        	}
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	public int[] getLotto() {
		return lotto;
	}
	
}
