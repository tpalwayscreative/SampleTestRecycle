package delfi.com.vn.sampletest;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import dk.delfi.core.common.activity.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeView,HomeAdapter.ListenerHome{

    private HomePresenter presenter ;
    @BindView(R.id.rcHome)
    RecyclerView recyclerView;
    LinearLayoutManager llm ;
    private HomeAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        presenter = new HomePresenter(this);
        presenter.bindView(this);
        setupRecyclerView();
        presenter.setData();
    }

    public void setupRecyclerView() {
        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        adapter = new HomeAdapter(getLayoutInflater(),this,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemHome(int position) {
        presenter.getList().get(position).name = "This is changed at "+ position;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onShowData(List<CProduct> list) {
        adapter.setDataSource(list);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void onHideLoading() {

    }
}
