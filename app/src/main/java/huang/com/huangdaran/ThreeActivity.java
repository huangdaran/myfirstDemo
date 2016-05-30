package huang.com.huangdaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/5/27.
 */
public class ThreeActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = (Button)findViewById(R.id.close_btn);
        button.setText("关闭");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListenerManager.getInstance().close(3);
            }
        });
    }
}
