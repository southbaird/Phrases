package com.lt.phrases.contract.home;

import com.lt.library.base.BasePresenter;
import com.lt.library.base.IBaseFragment;
import com.lt.library.base.IBaseModel;

/**
 * Created by nq on 2018/2/10.
 * email : 1172921726@qq.com
 * 主页Contract
 */

public interface HomeMainContract {
    //主页接口
    abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel, IHomeMainView> {
        public abstract void getTabList();
    }

    interface IHomeMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IHomeMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }
}
