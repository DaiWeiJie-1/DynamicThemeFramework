package dynamictheme.dwj.com.dynamicthemeframework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwj.annotation.DynamicTheme;
import com.dwj.framework.DynamicThemeActivity;

/**
 * Created by Administrator on 2016/8/14.
 */
public class AActivity extends DynamicThemeActivity{

    @DynamicTheme(resouceId = R.string.app_name)
    private TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv = (TextView) findViewById(R.id.tv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                notifyThemeUpdate();

            }
        });
    }
}
