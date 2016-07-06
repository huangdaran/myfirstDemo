package huang.com.huangdaran;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity implements ListenerManager.CloseListener{
    String TAG = "MainActivity";
    private View btnBack;
    private View btnShare;		//标题分享
    private View toolbar;
    private View lineNavBar;

    private PullPushLayout mLayout;
    private Drawable bgBackDrawable;
    private Drawable bgShareDrawable;
    private Drawable bgNavBarDrawable;
    private Drawable bglineNavBarDrawable;

    private int alphaMax = 180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Fresco.initialize(this);//facebook 提供的开源图片加载库
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this,ScrollActivity.class));
        Fresco.initialize(this);
       /* ListenerManager.getInstance().registListener(this);
        initView();*/
        /*String p = "huangdaran";
        String p1 =  DesUtil.toHexString(DesUtil.encrypt(p));
        String p2 =  DesUtil.decrypt(p1);
        Log.i(TAG, "p="+p+"---p1="+p1+"--p2="+p2);*/
    }

    private void initView() {
        mLayout = (PullPushLayout) this.findViewById(R.id.layout);
        mLayout.setOnTouchEventMoveListenre(new PullPushLayout.OnTouchEventMoveListenre() {

            @Override
            public void onSlideUp(int mOriginalHeaderHeight, int mHeaderHeight) {

            }

            @Override
            public void onSlideDwon(int mOriginalHeaderHeight, int mHeaderHeight) {

            }

            @Override
            public void onSlide(int alpha) {
                int alphaReverse = alphaMax - alpha;
                if (alphaReverse < 0) {
                    alphaReverse = 0;
                }
                bgBackDrawable.setAlpha(alphaReverse);
                bgShareDrawable.setAlpha(alphaReverse);
                bgNavBarDrawable.setAlpha(alpha);
                bglineNavBarDrawable.setAlpha(alpha);

            }
        });
        toolbar = this.findViewById(R.id.nav_bar);
        lineNavBar = this.findViewById(R.id.line_nav_bar);
        btnBack = this.findViewById(R.id.iv_back);
        btnShare = this.findViewById(R.id.iv_share);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
            }
        });

        bgBackDrawable = btnBack.getBackground();
        bgBackDrawable.setAlpha(alphaMax);
        bgShareDrawable = btnShare.getBackground();
        bgShareDrawable.setAlpha(alphaMax);
        bgNavBarDrawable = toolbar.getBackground();
        bglineNavBarDrawable = lineNavBar.getBackground();
        bgNavBarDrawable.setAlpha(0);
        bglineNavBarDrawable.setAlpha(0);

    }

    @Override
    public void onClose(int i) {
        Toast.makeText(MainActivity.this,"哈哈哈哈",Toast.LENGTH_SHORT).show();
//        C:\Program Files\Java\jdk1.8.0_91\bin\java.exe
    }
}
