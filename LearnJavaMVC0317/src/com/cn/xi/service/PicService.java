package com.cn.xi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cn.xi.domain.Picture;

public class PicService {
	//模拟数据库
		static List<Picture> pictDB = new ArrayList<>();;

		
	public void addPic(String picName, String newFileName) {
		pictDB.add(new Picture(new Random().nextInt(99999), picName, newFileName));
	}


	public List<Picture> getAllPicts() {
		return pictDB;
	}

}
