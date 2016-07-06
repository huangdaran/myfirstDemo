package huang.com.huangdaran;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import huang.com.huangdaran.view.MyViewGroup;

/**
 * Created by Administrator on 2016/5/27.
 */
public class FirstActivity extends BaseActivity {
    private MyViewGroup viewGroup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = (Button)findViewById(R.id.close_btn);
        button.setText("跳转");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this,SecondActivity.class));
            }
        });
        viewGroup = (MyViewGroup)findViewById(R.id.myviewgroup);
        for(int i = 0;i < 10; i++){
            TextView textView = new TextView(FirstActivity.this);
            textView.setText("宝贝"+i);
            textView.setMinWidth(40);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(30, 30, 30, 30);
            viewGroup.addView(textView,params);

        }
    }
}
