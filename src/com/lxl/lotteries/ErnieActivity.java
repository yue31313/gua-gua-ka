package com.lxl.lotteries;

import com.lxl.lotteries.show.ErinieShow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ErnieActivity extends Activity{
	Button erniebtn;
	RelativeLayout container;
	ErinieShow erinieShow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		erniebtn=(Button) findViewById(R.id.erniebtn);
		container=(RelativeLayout) findViewById(R.id.container);
		
		erniebtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showErnie();
			}
		});
		
		
	}

	
	private void showErnie(){
//		container
		container.removeAllViews();
		
		int level = getLevel();
		erinieShow=new ErinieShow(this, level);
		
		container.addView(erinieShow,new LayoutParams(-2,-2));
	}
	
	/**
	 * 获取奖励等级
	 * @return
	 */
	public int getLevel(){
		//随机，看看几等奖
		double d=Math.random()*100;
		if(d<50){
			return 0;
		}
		if(d<80){
			return 3;
		}
		if(d<95){
			return 2;
		}
		return 1;
				
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
