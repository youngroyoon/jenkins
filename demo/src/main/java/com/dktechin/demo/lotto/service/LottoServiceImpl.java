package com.dktechin.demo.lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.dktechin.demo.common.util.MultiThread;

@Service("lottoService")
public class LottoServiceImpl implements LottoService{
	
	private static final Random random = new Random();
	
	@Override
	public List<ArrayList<String>> getLottoService() {
		
		List<ArrayList<String>> lottoList = new ArrayList<>();
		int allLotto[] = new int [50];
		MultiThread[] mt = new MultiThread[5];
		int offset = 0;
		
		// 5개의 쓰레드 실행
        for(int i = 0 ; i < 5 ; i ++){
        	int lotto[] = new int [10];
            mt[i] = new MultiThread(lotto);
            mt[i].start();
        }
        
        for(int i = 0 ; i<5 ; i++){
        	while(true){
        		Thread.State state = mt[i].getState();
        		
        		// 쓰레드가 종료되었다면
        		if(state == Thread.State.TERMINATED){
        			//10개의 정수를 가진 5개의 로또배열 합침
        			System.arraycopy(mt[i].getLotto(), 0, allLotto, offset, mt[i].getLotto().length);
    	            offset += mt[i].getLotto().length;
        			break;
                }
        	}
        }
        
    	for(int i=0; i<4; i++) {
    		ArrayList<String> arr = new ArrayList<>();
    		int lotto[] = new int [6];
    		Arrays.fill(lotto, 100);
    		
    		// 로또 번호 중복검사
			for(int j=0; j<lotto.length; j++) {
				boolean flag = false;
				int number = random.nextInt(49)+1;
				lotto[j] = allLotto[number]; 
				for (int k=0; k<j; k++) { 
					if(lotto[j] == lotto[k]) {
						j--; 
						flag = true;
						break; 
					} 
				}
				// 보너스 번호 나오기전에 번호 오름차순 정렬 
				if(!flag && j == 4) Arrays.sort(lotto); 
			}
			
    		for(int j=0; j<lotto.length; j++) {
    			if(j==5) {
    				arr.add(j, "보너스(" + lotto[j] + ")");
    			}else {
    				arr.add(j, lotto[j] + "");
    			}
    		}
    		
    		lottoList.add(arr);
    	}
		return lottoList;
	}
	
	// 소나큐브에 있는 Rule CWE-798강제로 버그내기
	public boolean VerifyAdmin(String password) {
		if (password.equals("68af404b513073584c4b6f22b6c63e6b")) {
			System.out.println("Entering Diagnostic Mode...");
			return true;
		}
		
		System.out.println("Incorrect Password!");
		return false;
	}
}
