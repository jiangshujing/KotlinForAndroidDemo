package com.jsj.kotlindemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment implements IFragmentVisible {

    /**
     * 类名，统计用名
     */
    public final String TAG = this.getClass().getSimpleName();

    protected Context mContext = null;

    /**
     * 是否可见
     */
    protected boolean isVisible = false;

    /**
     * {@link Fragment#onActivityCreated(Bundle)} 是否已经调用。
     */
    protected boolean isCreated;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        LogUtil.d("onAttach");
        this.mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mContext = null;
    }

    private Bundle mBundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mContext != null)
            mBundle = getArguments();
    }

    @Override
    public void onResume() {
        super.onResume();
//        LogUtil.d("onResume");
    }

    protected View setRootView(int layoutResID, ViewGroup container) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(layoutResID, container, false);
//        AbViewUtil.scaleContentView((ViewGroup) view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        LogUtil.d("onDestroy");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.isCreated = true;
    }

    /**
     * 此方法目前仅适用于标示ViewPager中的Fragment是否真实可见<br>
     * For 友盟统计的页面线性不交叉统计需求
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isCreated) {
            if (isVisibleToUser) {
                onVisible();
            } else {
                onInvisible();
            }
        }
    }

    /**
     * Fragment 可见时触发
     */
    @Override
    public void onVisible() {
        if (isVisible) {
            return;
        }
//        LogUtil.d(TAG);
//        MobclickAgent.onPageStart(TAG);
//        MobclickAgent.onResume(mContext);
        isVisible = true;
    }

    @Override
    public void onInvisible() {
        if (!isVisible) {
            return;
        }
//        LogUtil.d(TAG);
//        MobclickAgent.onPageEnd(TAG);
//        MobclickAgent.onPause(mContext);
        isVisible = false;
    }
}

