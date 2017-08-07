package delfi.com.vn.sampletest;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import dk.delfi.core.common.activity.BaseActivity;
import dk.delfi.core.ui.recycleview.DPRecyclerView;
import dk.delfi.core.ui.recycleview.RecyclerViewAdapter;

public class HomeActivity extends BaseActivity implements HomeView,HomeAdapter.ListenerHome,DPRecyclerView.ListenerRecycleView{

    private HomePresenter presenter ;
    @BindView(R.id.rcHome)
    RecyclerView recyclerView;
    LinearLayoutManager llm ;
    private RecyclerViewAdapter adapter ;
    private ViewHolder viewHolder ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        presenter = new HomePresenter(this);
        presenter.bindView(this);
        adapter = DPRecyclerView.instance(this,recyclerView,R.layout.cell_home,this).adapterRecycleView();
        adapter.setDataSource(new ArrayList<>());
        presenter.setData();
    }

    @Override
    public void onShowData(Object o, int i) {
        CProduct product = (CProduct)o;
        viewHolder.textView.setText(product.name);
    }

    @Override
    public void onShowPosition(int i) {

    }

    @Override
    public void onShowLocalData(List<CProduct> list) {
        adapter.setDataSource(new ArrayList(list));
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onItemHome(int position) {

    }

    @Override
    public void onSetView(View view) {
        viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        Log.d(TAG,"show view");
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void onHideLoading() {

    }

    protected class ViewHolder {
        @BindView(R.id.tvCellHome)
        TextView textView ;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
