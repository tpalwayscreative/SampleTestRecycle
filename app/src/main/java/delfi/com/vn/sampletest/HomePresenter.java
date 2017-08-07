package delfi.com.vn.sampletest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import common.presenter.Presenter;

/**
 * Created by PC on 8/7/2017.
 */

public class HomePresenter extends Presenter<HomeView>{
    private Activity activity ;

    public List<CProduct> getList() {
        return list;
    }

    public void setList(List<CProduct> list) {
        this.list = list;
    }

    private List<CProduct>list ;
    public HomePresenter(Activity activity){
        this.activity = activity ;
        list = new ArrayList<>();
    }

    public void setData(){
        HomeView viewRemote = view();
        list.add(new CProduct("\"'A' - You're Adorable\" (Sid Lippman, Buddy Kaye and Fred Wise)"));
        list.add(new CProduct("\"A Hard Rain's a-Gonna Fall\" (Bob Dylan)"));
        list.add(new CProduct("\"A Little Priest\" (Stephen Sondheim and Hugh Wheeler From Sweeney Todd: The Demon Barber of Fleet Street)"));
        list.add(new CProduct("\"A Little Something Refreshing\" (Eric Stefani), performed by No Doubt"));
        list.add(new CProduct("list.add(new CProduct(\"\"Area Codes\" (Ludacris)));\n"));
        list.add(new CProduct("\"Around the World\" (Red Hot Chili Peppers)"));
        list.add(new CProduct("\"A Well-Dressed Hobbit\" (Rie Sheridan Rose, Marc Gunn)"));
        list.add(new CProduct("\"All My Ex's Live in Texas\" (George Strait and Whitey Shafer)"));
        viewRemote.onShowData(list);
    }

}
