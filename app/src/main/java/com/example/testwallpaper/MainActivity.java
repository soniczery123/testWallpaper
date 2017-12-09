package com.example.testwallpaper;

import android.app.WallpaperManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.testwallpaper.DbHelper.COL_PICTURE;

public class MainActivity extends AppCompatActivity {
    int count = 0 ;
    ArrayList<PictureItem> mPictureItemList;
    private DbHelper mHelper;
    private SQLiteDatabase mDb;
    private picListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new DbHelper(this);
        mDb = mHelper.getReadableDatabase();

        mPictureItemList = new ArrayList<>();
        Cursor cursor = mDb.query(mHelper.TABLE_NAME,null,null,null,null,null, null);

        while (cursor.moveToNext()) {
         //   int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            int pic = cursor.getInt(cursor.getColumnIndex(COL_PICTURE));
            PictureItem item = new PictureItem(pic);
            mPictureItemList.add(item);

        }
        mAdapter = new picListAdapter(this,R.layout.activity_item, mPictureItemList);
        ListView iv = (ListView)findViewById(R.id.list_item);
        iv.setAdapter(mAdapter);
        iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PictureItem item = mPictureItemList.get(i);
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setResource(item.picture);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
