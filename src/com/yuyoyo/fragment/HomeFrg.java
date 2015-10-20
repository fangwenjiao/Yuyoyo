package com.yuyoyo.fragment;

import org.kymjs.aframe.ui.fragment.BaseFragment;

import com.yuyoyo.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFrg extends BaseFragment{

	@Override
	protected View inflaterView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.home, null);
	}
	
	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		super.initData();
	}
	
	@Override
	protected void initWidget(View parentView) {
		// TODO Auto-generated method stub
		super.initWidget(parentView);
	}

}
