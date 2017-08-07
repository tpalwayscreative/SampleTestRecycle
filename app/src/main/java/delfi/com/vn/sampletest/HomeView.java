package delfi.com.vn.sampletest;

import java.util.List;

import dk.delfi.core.common.presenter.BaseView;

/**
 * Created by PC on 8/7/2017.
 */

public interface  HomeView extends BaseView{
    void onShowLocalData(List<CProduct>list);
}
