package com.yuyoyo.fragmentact;



import org.kymjs.aframe.ui.BindView;
import org.kymjs.aframe.ui.ViewInject;
import org.kymjs.aframe.ui.activity.HKFragmentActivity;

import com.yuyoyo.R;
import com.yuyoyo.fragment.CommunicateFrg;
import com.yuyoyo.fragment.HomeFrg;
import com.yuyoyo.fragment.MyFrg;
import com.yuyoyo.fragment.ShopCartFrg;



import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/*
 * 首页导航页
 */
public class NavigationFragAct extends HKFragmentActivity{
	private HomeFrg homeFrg;
	private ShopCartFrg shopCartFrg;
	private CommunicateFrg communicateFrg;
	private MyFrg myFrg;
	private FragmentManager fragmentManager;
	
	@BindView(id=R.id.home,click=true)
	private RadioButton home;
	@BindView(id=R.id.shopcart,click=true)
	private RadioButton shopcart;
	@BindView(id=R.id.communicate,click=true)
	private RadioButton communicate;
	@BindView(id=R.id.my,click=true)
	private RadioButton my;
	@BindView(id = R.id.navigation)
	private RadioGroup navigation;
	
	
	int type = 0;
	private int selectIcon = 1;
	public static NavigationFragAct navigationFragAct;   //单例模式

	public static NavigationFragAct getInstance(){
		if (null == navigationFragAct) {
			synchronized (NavigationFragAct.class) {
				if (null == navigationFragAct) {
					navigationFragAct = new NavigationFragAct();
				}
			}
		}
		return navigationFragAct;
	}
	
	@Override
	public void setRootView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.navigation);
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		if(type != 0){
			switch (type) {
			case 1:
				setTabSelection(R.id.home);
				break;

			case 2:
				setTabSelection(R.id.shopcart);
				break;
				
			case 3:
				setTabSelection(R.id.communicate);
				break;
				
			case 4:
				setTabSelection(R.id.my);
				break;
			}
		}
		super.onNewIntent(intent);
	}
	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		fragmentManager = getFragmentManager();
		if(homeFrg==null)homeFrg=new HomeFrg();
		if(shopCartFrg==null)shopCartFrg=new ShopCartFrg();
		if(communicateFrg==null)communicateFrg=new CommunicateFrg();
		if(myFrg==null)myFrg=new MyFrg();
		
		setTabSelection(R.id.home);

	}
	
	@Override
	public void widgetClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.home:
			setTabSelection(R.id.home);
			selectIcon = 1;
			break;
		case R.id.shopcart:
			setTabSelection(R.id.shopcart);
			selectIcon = 2;
		    break;
		case R.id.communicate:
			if(selectIcon==3) return;			
			setTabSelection(R.id.communicate);
			selectIcon = 3;
			break;
		case R.id.my:
			if(selectIcon==4)return;
			setTabSelection(R.id.my);
			selectIcon = 4;
			break;
		}
	}
	
	public void setTabSelection(int index) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case R.id.home:
			home.setTextColor(getResources().getColor(R.color.pink));
			home.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
					.getDrawable(R.drawable.nav_home_select), null, null);
			if (homeFrg == null) {
				homeFrg = new HomeFrg();
				transaction.add(R.id.content, homeFrg);
			} else {
				transaction.show(homeFrg);
			}
			break;
		case R.id.shopcart:
			shopcart.setTextColor(getResources().getColor(R.color.pink));
			shopcart.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.nav_shopcart_select),
					null, null);
			if (shopCartFrg == null) {
				shopCartFrg  = new ShopCartFrg();
				transaction.add(R.id.content, shopCartFrg);
			} else {
				transaction.show(shopCartFrg);
			}
			break;
		case R.id.communicate:
			communicate.setTextColor(getResources().getColor(R.color.pink));
			communicate.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.nav_communicate_select),
					null, null);
			if (communicateFrg == null) {
				communicateFrg  = new CommunicateFrg ();
				transaction.add(R.id.content, communicateFrg);
			} else {
				transaction.show(communicateFrg);
			}
			break;
		case R.id.my:
			my.setTextColor(getResources().getColor(R.color.pink));
			my.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
					.getDrawable(R.drawable.nav_my_select), null, null);
			if (myFrg == null) {
				myFrg = new MyFrg();
				transaction.add(R.id.content, myFrg);
			} else {
				transaction.show(myFrg);
			}
			break;
		}
		transaction.commit();
	}
	
	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		clearSelection();
		if (homeFrg != null) {
			transaction.hide(homeFrg);
		}
		if (shopCartFrg != null) {
			transaction.hide(shopCartFrg);
		}
		if (communicate != null) {
			transaction.hide(communicateFrg);
		}
		if (myFrg != null) {
			transaction.hide(myFrg);
		}
	}
	
	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		home.setTextColor(getResources().getColor(R.color.black));
		home.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
				.getDrawable(R.drawable.nav_home), null, null);
		shopcart.setTextColor(getResources().getColor(R.color.black));
		shopcart.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
				.getDrawable(R.drawable.nav_shopcart), null, null);
		communicate.setTextColor(getResources().getColor(R.color.black));
		communicate.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
				.getDrawable(R.drawable.nav_communicate), null, null);
		my.setTextColor(getResources().getColor(R.color.black));
		my.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
				.getDrawable(R.drawable.nav_my), null, null);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		ViewInject.create().getExitDialog(this);
	}
	
}
