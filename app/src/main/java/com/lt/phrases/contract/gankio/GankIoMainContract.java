package com.lt.phrases.contract.gankio;

import com.lt.library.base.BasePresenter;
import com.lt.library.base.IBaseFragment;
import com.lt.library.base.IBaseModel;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public interface GankIoMainContract {
    //主页接口
    abstract class GankIoMainPresenter extends BasePresenter<IGankIoMainModel, IGankIoMainView> {
        public abstract void getTabList();
    }

    interface IGankIoMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IGankIoMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }

}
