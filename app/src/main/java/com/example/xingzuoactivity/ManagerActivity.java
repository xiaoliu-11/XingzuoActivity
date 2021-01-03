package com.example.xingzuoactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.xingzuoactivity.sqliteutil.dbHelper;
import com.example.xingzuoactivity.toastutil.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagerActivity extends AppCompatActivity {


     private ImageView iv1,iv2;
     private EditText et1 ,et2,et3;
    private static String DB_NAME = "mydb";
    private ArrayList<Map<String, Object>> data;
    private com.example.xingzuoactivity.sqliteutil.dbHelper dbHelper;
    private Cursor cursor;
    private SQLiteDatabase db;
    private Map<String, Object> item;
    private String selId;
    private SimpleAdapter listAdapter;
    private ListView listview;
    private Button btn_1, addBtn, delBtn, updateBtn, selectBtn;
    private EditText  et_name;
    private EditText et_age;
    private String condition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);


        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        iv1 = findViewById(R.id.back_111);
        iv2 = findViewById(R.id.search);
        et1 = findViewById(R.id.ed_search);
        et2 = findViewById(R.id.username_1);
        //文本
        et3 = findViewById(R.id.age_et);

        addBtn = (Button) findViewById(R.id.bt_add);
        delBtn = (Button)findViewById(R.id.bt_del);
        updateBtn = (Button) findViewById(R.id.bt_modify);
        selectBtn = (Button) findViewById(R.id.bt_query);
        listview = findViewById(R.id.listView);
        this.registerForContextMenu(listview);
        iv2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dbFindAll();
                ToastUtil.ShowMsg(ManagerActivity.this,"请输入信息!");
            }
        });

        addBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dbAdd();
                dbFindAll();
            }
        });
        delBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dbDel();
                dbFindAll();
            }
        });

        updateBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dbUpdate();
                dbFindAll();
            }
        });

       iv2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbFindbyKey();
            }
        });



// 点击加号图标添加用户

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder  builder4 = new AlertDialog.Builder(ManagerActivity.this);
                View view = LayoutInflater.from(ManagerActivity.this).inflate(R.layout.layout_tianjia,null);
                builder4.setTitle("添加用户:").setView(view).show();
                Button  btn = view.findViewById(R.id.btn_login_1);
                btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ToastUtil.ShowMsg(ManagerActivity.this,"添加用户成功");
                    }
                });
            }
        });





        dbHelper = new dbHelper(this, DB_NAME, null, 1);
        db = dbHelper.getWritableDatabase();// 打开数据库
        data = new ArrayList<Map<String, Object>>();
        dbFindAll();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // TODO Auto-generated method stub
                Map<String, Object> listItem = (Map<String, Object>) listview.getItemAtPosition(position);
                et_name.setText((String) listItem.get("name"));
                et_age.setText((String) listItem.get("age"));
                selId = (String) listItem.get("_id");
                Log.i("mydbDemo", "id=" + selId);


            }
        });


    }

    private void showList() {
        // TODO Auto-generated method stub
        listAdapter = new SimpleAdapter(this, data,
                R.layout.sql_listview, new String[]{"_id", "name", "age"}, new int[]{R.id.tvID, R.id.tvName, R.id.tvAge});
        listview.setAdapter(listAdapter);
    }


    //动态监听文本框中的数据
    public void ser_TextChanged(){

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dbFindbyKey();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


//根据文本框查询
protected void dbFindbyKey() {
    // TODO Auto-generated method stub
    data.clear();
    condition =et1.getText().toString() ;
    String sql = "select * from test where name like '%"+ condition+"%' or age like '%"+ condition+"%'";
    data.clear();
    cursor = db.rawQuery(sql,null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
        String id = cursor.getString(0);
        String name = cursor.getString(1);
        String age = cursor.getString(2);
        item = new HashMap<String, Object>();
        item.put("_id", id);
        item.put("name", name);
        item.put("age", age);
        data.add(item);
        cursor.moveToNext();
    }
    {
        item = new HashMap<String, Object>();
        item.put("name", "无结果");
        data.add(item);


    }

    showList();
}




    //更新
    // 列表中的数据
    protected void dbUpdate() {
        // TODO Auto-generated method stub
        ContentValues values = new ContentValues();
        values.put("name", et_name.getText().toString().trim());
        values.put("age", et_age.getText().toString().trim());
        String where = "_id=" + selId;
        int i = db.update(dbHelper.TB_NAME, values, where, null);
        if (i > 0) {
            Log.i("myDbDemo", "数据更新成功！");
            ToastUtil.ShowMsg(ManagerActivity.this,"修改用户成功");
        }
        else
            Log.i("myDbDemo", "数据未更新");
    }


//删除数据
protected void dbDel() {
    // TODO Auto-generated method stub
    String where = "_id=" + selId;
    int i = db.delete(dbHelper.TB_NAME, where, null);
    if (i > 0) {
        ToastUtil.ShowMsg(ManagerActivity.this, "删除用户成功");
        Log.i("myDbDemo", "数据删除成功!");
    }
    else
        Log.i("myDbDemo", "数据未删除!");
}



    //插入数据
    protected void dbAdd() {
        // TODO Auto-generated method stub
        ContentValues values = new ContentValues();
        if (et_age.getText().equals("") && et_name.getText().equals("")) {
            ToastUtil.ShowMsg(ManagerActivity.this, "信息不能为空!");
        }
        else {
            values.put("name", et_name.getText().toString().trim());
            values.put("age", et_age.getText().toString().trim());
            long rowid = db.insert(dbHelper.TB_NAME, null, values);
            if (rowid == -1)
                ToastUtil.ShowMsg(ManagerActivity.this, "插入失败!");
            else
                ToastUtil.ShowMsg(ManagerActivity.this, "添加用户成功");
            Log.i("myDbDemo", "数据插入成功!" + rowid);
        }

    }


    protected void dbadd1(){
        ContentValues values = new ContentValues();
        values.put("name", et2.getText().toString().trim());
        values.put("age", et3.getText().toString().trim());
        long rowid = db.insert(dbHelper.TB_NAME, null, values);
        if (rowid == -1)
            ToastUtil.ShowMsg(ManagerActivity.this, "插入失败!");
        else
            ToastUtil.ShowMsg(ManagerActivity.this, "添加用户成功");
        Log.i("myDbDemo", "数据插入成功!" + rowid);

    }




    //查询数据
    protected void dbFindAll() {
        // TODO Auto-generated method stub
        data.clear();
        cursor = db.query(dbHelper.TB_NAME, null, null, null, null, null, "_id ASC");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            item = new HashMap<String, Object>();
            item.put("_id", id);
            item.put("name", name);
            item.put("age", age);
            data.add(item);
            cursor.moveToNext();
        }
        showList();
    }



    //上下文菜单

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("选项");
        menu.add(0,0, Menu.NONE,"修改");
        menu.add(0,1,Menu.NONE,"删除");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 0 :

                //btn3.setText(item.getTitle().toString());
                ToastUtil.ShowMsg(this,"修改成功");
                break;
            case 1:
                dbDel();
                // btn3.setText(item.getTitle().toString());
                ToastUtil.ShowMsg(this,"删除成功");
                break;

        }
        return  true;
    }




}
