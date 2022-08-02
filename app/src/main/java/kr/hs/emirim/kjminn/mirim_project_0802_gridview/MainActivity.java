package kr.hs.emirim.kjminn.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId = {R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04, R.drawable.poster05,
            R.drawable.poster06, R.drawable.poster07, R.drawable.poster08, R.drawable.poster09, R.drawable.poster10,
            R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04, R.drawable.poster05,
            R.drawable.poster06, R.drawable.poster07, R.drawable.poster08, R.drawable.poster09, R.drawable.poster10,
            R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04, R.drawable.poster05,
            R.drawable.poster06, R.drawable.poster07, R.drawable.poster08, R.drawable.poster09, R.drawable.poster10 };
    String[] posterTitle = {"범죄도시2","쥬라기월드(도미니언)", "브로커","닥터스트레인지(대혼돈의 멀티버스)","카시오페아",
                            "로스트시티", "스파이더맨(노웨이홈)", "DUNE", "앵커", "마녀 Part2",
                            "범죄도시2","쥬라기월드(도미니언)", "브로커","닥터스트레인지(대혼돈의 멀티버스)","카시오페아",
                            "로스트시티", "스파이더맨(노웨이홈)", "DUNE", "앵커", "마녀 Part2",
                            "범죄도시2","쥬라기월드(도미니언)", "브로커","닥터스트레인지(대혼돈의 멀티버스)","카시오페아",
                            "로스트시티", "스파이더맨(노웨이홈)", "DUNE", "앵커", "마녀 Part2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신영화포스터(네이버시리즈온)");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);

    }

    public class PosterAdapter extends BaseAdapter{
        Context context;
        public PosterAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            GridView.LayoutParams params = new GridView.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });

            return imgv;
        }
    }
}