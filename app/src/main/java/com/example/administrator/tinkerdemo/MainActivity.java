package com.example.administrator.tinkerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.tinkerdemo.tinker.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apk";
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建文件路径
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        //创建文件夹
        File file = new File(mPatchDir);
        //判断文件夹是否存在
        if (file == null || !file.exists()) {
            //不存在就创建
            file.mkdir();
        }

    }


    public void loadPatch(View view) {
        TinkerManager.loadPatch(getPathName());
    }

    public void showToast(View view) {
        Toast.makeText(this,"添加功能成功",Toast.LENGTH_SHORT).show();
    }

    //构造patch文件名
    public String getPathName() {
        return mPatchDir.concat("tpatch").concat(FILE_END);
    }
}
