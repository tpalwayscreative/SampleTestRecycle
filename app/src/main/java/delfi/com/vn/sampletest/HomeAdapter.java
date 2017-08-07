package delfi.com.vn.sampletest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import common.adapter.BaseAdapter;
import common.adapter.BaseHolder;

/**
 * Created by PC on 8/7/2017.
 */

public class HomeAdapter extends BaseAdapter<CProduct,BaseHolder> {

    private Activity activity ;
    private ListenerHome listenerHome ;

    public HomeAdapter(LayoutInflater inflater, Activity activity, ListenerHome listenerHome){
        super(inflater);
        this.activity = activity ;
        this.listenerHome = listenerHome ;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeHolder(inflater.inflate(R.layout.cell_home, parent, false));
    }

    public class  HomeHolder extends BaseHolder<CProduct>{


        @BindView(R.id.tvCellHome)
        TextView tvCellHome ;
        private int position ;

        public HomeHolder(View view){
            super(view);
        }

        @Override
        public void bind(CProduct data, int position) {
            super.bind(data, position);
            this.position = position ;
            tvCellHome.setText(data.name);
        }

        @OnClick(R.id.llHome)
        public void onClickHome(){
            listenerHome.onItemHome(position);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public interface ListenerHome{
        void onItemHome(int position);
    }

}
