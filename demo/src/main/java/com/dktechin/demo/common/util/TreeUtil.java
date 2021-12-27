package com.dktechin.demo.common.util;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.dktechin.demo.sample.model.SampleDataBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class TreeUtil {
	
	public static boolean[] visited;
	public static List<SampleDataBean> sortList;
	
    public static List<SampleDataBean> getDataList(){
    	
        List<SampleDataBean> list = new ArrayList<>();
        Gson gson = new Gson(); 
        
        //TODO 문제2번
        //JSON 파일을 읽고 상대경로로 읽어 List에 담는 로직을 구현하십시오.
        try {
        	//resource 경로에 있는 파일 불러오기
        	File file = ResourceUtils.getFile("classpath:json/treeSample.json");         
        	
        	JsonReader rd = new JsonReader(new FileReader(file));
        	JsonArray jarr = gson.fromJson(rd, JsonArray.class);
			
        	//gson을 사용해 list로 json데이터 변환
        	list = gson.fromJson(jarr, new TypeToken<List<SampleDataBean>>(){}.getType());

            list.forEach(data -> System.out.println(data.toString()));
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        //TODO 문제3번
        //문제2번을 풀고 계층구조로 화면에 보일수 있도록 정렬한다.
        sortList = new ArrayList<>();
        visited = new boolean[list.size()];
        
        for(int i=0;i<list.size(); i++) {
        	SampleDataBean vo = list.get(i);
        	String id = vo.getId();
        	String parentId = vo.getParentId();
        
        	//root 설정
        	if(parentId.isEmpty()) {
        		vo.setDepth(Integer.parseInt(id));
        		continue;
        	}
        	
        	for(int j=0; j<list.size(); j++) {
        		SampleDataBean _vo = list.get(j);
            	String _id = _vo.getId();
            	int _depth = _vo.getDepth();
            	
            	//부모 아이디와 일치하는 id가 있다면
            	if(_id.equals(parentId)) {
            		vo.setDepth(++_depth);
            		break;
            	}
        	}
        	
        	list.set(i, vo);
        }
        
        // id순으로 정렬
        Collections.sort(list, new Comparator<SampleDataBean>() {
            public int compare(SampleDataBean one, SampleDataBean other) {
            	int oneId = Integer.parseInt(one.getId());
            	int otherId = Integer.parseInt(other.getId());
                return oneId - otherId;
            }
        });
        
        // 재귀함수 호출
        dfs(0,list);
        
        sortList.forEach(data -> System.out.println(data.toString())); 
    
        return sortList;
    }
    
    public static void dfs(int x, List<SampleDataBean> list){
        
        int id = Integer.parseInt(list.get(x).getId());
       
        sortList.add(list.get(x));
        
        // 현재 노드를 방문 처리
        visited[x] = true;
        
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 1; i < list.size(); i++) {
        	int _id = Integer.parseInt(list.get(i).getId());
        	int parentId = Integer.parseInt(list.get(i).getParentId());
        	if(id == parentId) {
        		if(!visited[_id]){
                    dfs(_id, list);
                }
        	}
        }
    }

}
