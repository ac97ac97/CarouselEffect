package smsdemo.sdbi.com.carouseleffect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import smsdemo.sdbi.com.carouseleffect.view.ImageBarnnertViewGroup;
import smsdemo.sdbi.com.carouseleffect.view.ImageBarnnerFramLayout;

public class MainActivity extends AppCompatActivity implements ImageBarnnerFramLayout.FramLayoutLisenner{
    private ImageBarnnerFramLayout mGroup;
    private int[] ids = new int[]{
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //我们需要计算出我们当前手机的宽度
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        C.WITTH=dm.widthPixels;
        mGroup = (ImageBarnnerFramLayout) findViewById(R.id.image_group);
        mGroup.setLisenner(this);
        List<Bitmap> list=new ArrayList<>();
        for (int i=0;i<ids.length;i++){
            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),ids[i]);
            list.add(bitmap);

        }
        mGroup.addBitmaps(list);
//        for (int i = 0; i < ids.length; i++) {
//            ImageView iv = new ImageView(this);
//            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            iv.setLayoutParams(new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));
//            iv.setImageResource(ids[i]);
//            mGroup.addView(iv);
//        }
//        mGroup.setListener(this);

    }

    @Override
    public void clickImageIndex(int pos) {
        if (pos == 0){
            Intent intent=new Intent();
            intent.setData(Uri.parse("https://crown100.taobao.com/shop/view_shop.htm?user_number_id=16147210&ali_trackid=2%3Amm_118240449_17252262_62920298%3A1517634241_315_1716325806"));
            startActivity(intent);
        }else if (pos==1){
           Intent intent=new Intent();
            intent.setData(Uri.parse("http://www.51souli.com/news/1654.htm"));
            startActivity(intent);
        }else if (pos==2){
            Intent intent = new Intent();
            intent.setData(Uri.parse("https://detail.ju.taobao.com/home.htm?spm=608.brandpage.zebra-ju-minisite-item-2979_1517117309961_17.1.3d322e8a1SXmxx&id=10000070611140&item_id=538809400352"));
            startActivity(intent);
        }
        //Toast.makeText(this,"pos="+pos,Toast.LENGTH_SHORT).show();
    }
}
