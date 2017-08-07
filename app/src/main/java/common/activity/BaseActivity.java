package common.activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import delfi.com.vn.sampletest.R;
import dk.delfi.core.common.ui.TypefaceSpan;


public class BaseActivity extends AppCompatActivity {
    Unbinder unbinder;
    protected Typeface mTfRegular;
    protected Typeface mTfLight;
    protected ActionBar actionBar ;
    int onStartCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTfRegular = Typeface.createFromAsset(getAssets(), "fonts/Brandon_reg.otf");
        mTfLight = Typeface.createFromAsset(getAssets(), "fonts/Brandon_light.otf");
        actionBar = getSupportActionBar();
        onStartCount = 1;
        if (savedInstanceState == null) // 1st time
        {
            this.overridePendingTransition(R.animator.anim_slide_in_left,
                    R.animator.anim_slide_out_left);
        } else // already created so reverse animation
        {
            onStartCount = 2;
        }
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null)
            unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    protected void setChangeFontTitle(String title){
        SpannableString s = new SpannableString(title);
        s.setSpan(new TypefaceSpan(this,"Brandon_reg.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }

    protected void setDisplayHomeAsUpEnabled(boolean check){
        actionBar.setDisplayHomeAsUpEnabled(check);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        if (onStartCount > 1) {
            this.overridePendingTransition(R.animator.anim_slide_in_right,
                    R.animator.anim_slide_out_right);

        } else if (onStartCount == 1) {
            onStartCount++;
        }

    }
}
