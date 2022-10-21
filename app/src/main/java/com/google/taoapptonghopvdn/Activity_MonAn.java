package com.google.taoapptonghopvdn;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class Activity_MonAn extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private CircleIndicator3 mCircleIndicator3;
    private List<PhotoMoAn> mListPhoto;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mViewPager2.getCurrentItem();
            if(currentPosition == mListPhoto.size()-1){
                mViewPager2.setCurrentItem(0);
            }else {
                mViewPager2.setCurrentItem(currentPosition + 1);
            }
        }
    };
    ListView listView;
    AdapterMonAn adapter;
    ArrayList<MonAn> arrayList;
    Boolean kt=false;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisviewmonan);


        mViewPager2=findViewById(R.id.view_pager_2);
        mCircleIndicator3=findViewById(R.id.cricleIndicator3);

        //SETTING viewpager2
        mViewPager2.setOffscreenPageLimit(3);
        mViewPager2.setClipToPadding(false);
        mViewPager2.setClipChildren(false);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        //compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            //@Override
            //public void transformPage(@NonNull View page, float position) {
                //float  r = 1 - Math.abs(position);
                //page.setScaleY(0.85f + r = 0.15f);
            //}
        //});
        mViewPager2.setPageTransformer(compositePageTransformer);

        mListPhoto=getListPhoto();
        PhotoMonAnAdapter photoAdapter = new PhotoMonAnAdapter(mListPhoto);

        mViewPager2.setAdapter(photoAdapter);
        mCircleIndicator3.setViewPager(mViewPager2);
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 2000);
            }
        });

        LinearLayout backlistview = (LinearLayout) findViewById(R.id.backlistview);
        listView = findViewById(R.id.listviewmonan);
        arrayList = new ArrayList<>();
        arrayList.add(new MonAn("Bánh Mì SanWich","Đơn Gíá: 20.000 VNĐ","Bánh mì kẹp hoặc bánh mì lát (tiếng Anh: sandwich) là một món ăn thường bao gồm rau, pho mát hoặc thịt cắt lát được đặt bên trên hoặc giữa các lát bánh mì hoặc nói chung là bất kỳ món ăn nào trong đó bánh mì dùng để chứa hoặc bao bọc cho một loại thực phẩm khác.", R.drawable.banminhsanwich));
        arrayList.add(new MonAn("Bún Đậu Mắm Tôm","Đơn Gíá: 60.000 VNĐ","Bún đậu mắm tôm là món ăn đơn giản, dân dã trong ẩm thực miền Bắc Việt Nam. Đây là món thường được dùng như bữa ăn nhẹ, ăn chơi. Thành phần chính gồm có bún tươi, đậu hũ chiên vàng, chả cốm, nem chua,dồi chó, mắm tôm pha chanh, ớt và ăn kèm với các loại rau thơm như tía tô, kinh giới, rau húng, xà lách, cà pháo", R.drawable.bundaumamtom));
        arrayList.add(new MonAn("Bánh Mì Que","Đơn Gíá: 10.000 VNĐ", "Bánh mì que còn được gọi là bánh mì cay, lấy từ vị loại tương ớt đặc biệt không thể thiếu khi ăn kèm nhân bánh nhưng cũng bởi hình dạng đặc biệt, to chỉ nhỉnh hơn đốt ngón tay, dài chừng hơn một gang tay mà người ta cũng quen miệng gọi chiếc bánh là bánh mì que",R.drawable.banhmique));
        arrayList.add(new MonAn("Lẩu Bò","Đơn Gíá: 110.000 VNĐ","Lẩu Bò Ăn Liền là sản phẩm lẩu đã chế biến và đóng tô độc đáo, có mùi vị rất thơm ngon, hấp dẫn.", R.drawable.laubo));
        arrayList.add(new MonAn("Phô Mai Que","Đơn Gíá: 60.000 VNĐ","Phô mai que là một món được làm chủ yếu từ phô mai cắt thành dạng thanh dài, tẩm bột và chiên xù. Ở Hoa Kỳ món này được gọi là Mozzarella stick, do nó được làm từ một loại phô mai Mozzarella của Ý, và được phục vụ như là món khai vị tại các nhà hàng, ở Bắc Mỹ thì nó chủ yếu được bán trong các \"quán nhậu\" (pub).", R.drawable.phomaique));
        arrayList.add(new MonAn("Ram Cuốn Cải","Đơn Gíá: 50.000 VNĐ","Ram cuốn cải là một món ăn dân dã tại Đà Nẵng, thường được bán nhiều trong chợ hay những quán vỉa hè. Mỗi chiếc ram chỉ dài khoảng chừng một ngón tay với lớp vỏ thơm, giòn sẽ được chiên ngay tại chỗ khi ăn. Nhân ram có ít miến trộn với thịt và nấm mèo, sau đó sẽ cuộn tròn với lớp ram mỏng.", R.drawable.ramcuonrai));
        arrayList.add(new MonAn("Bánh Kẹp","Đơn Gíá: 5.000 VNĐ","Phân loại: Vị phô mai thơm béo.\n" +
                "\n" +
                "Thích bánh kẹp ngon thì bà con chẳng thể bỏ qua loại bánh kẹp kem vị phô mai này. Thơm ngon, giòn rụm lại béo béo mặn mặn hấp dẫn khỏi chê.", R.drawable.banhkep));

        adapter = new AdapterMonAn(Activity_MonAn.this,R.layout.activity_viewmonan,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Activity_MonAn.this, MoTa.class);
                intent.putExtra("key1",arrayList.get(i).getHinh());
                intent.putExtra("key2",arrayList.get(i).getTenmon());
                intent.putExtra("key3",arrayList.get(i).getGiatien());
                intent.putExtra("key4",arrayList.get(i).getMota());
                if (kt!=true)
                    startActivity(intent);
                kt=false;;

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
        backlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Activity_MonAn.this,menu.class);
                startActivity(intent);
            }
        });
    }
    public List<PhotoMoAn> getListPhoto(){
        List<PhotoMoAn> list = new ArrayList<>();
        list.add(new PhotoMoAn(R.drawable.banhmique));
        list.add(new PhotoMoAn(R.drawable.banminhsanwich));
        list.add(new PhotoMoAn(R.drawable.banhkep));
        list.add(new PhotoMoAn(R.drawable.bundaumamtom));
        list.add(new PhotoMoAn(R.drawable.phomaique));
        list.add(new PhotoMoAn(R.drawable.laubo));

        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable, 2000);
    }

    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(Activity_MonAn.this);
        alertDiaLog.setTitle("Thong bao");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Ban co muon xoa");
        alertDiaLog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}

