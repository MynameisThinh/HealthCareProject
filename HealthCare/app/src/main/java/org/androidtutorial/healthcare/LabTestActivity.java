package org.androidtutorial.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String [][] packages = {
        {"Package 1 :Kiểm tra toàn thân","","","","999"},
        {"Package 2: Xét nghiệm lượng đường trong máu" ,"","","","299"},
            {"Package 3: Xét nghiệm COVID-19 - IgG" ,"","","","899"},
            {"Package 4: Kiểm tra tuyến giáp" ,"","","","499"},
            {"Package 5: Kiểm tra hệ miễn dịch" ,"","","","699"},

    };

    private String[] package_details = {
            "Xét nghiệm lượng đường trong máu\n" +
                    "Huyết đồ hoàn chỉnh\n" +
                    "HbA1c\n" +
                    "Rối loạn chuyển hóa sắt\n" +
                    "Kiểm tra chức năng thận\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Hồ sơ lipid\n" +
                    "Kiểm tra chức năng gan",
            "Xét nghiệm lượng đường trong máu",
            "Xét nghiệm COVID-19 - IgG",
            "Kiểm tra tuyến giáp tổng thể (T3, T4 & TSH Ultra sensitive)",
            "Huyết đồ hoàn chỉnh\n" +
                    "CRP ( C Reactive Protein) Quantative, Serum\n" +
                    "Rối loạn chuyển hóa sắt\n" +
                    "Kiểm tra chức năng thận\n" +
                    "Vitamid D Total 25 Hydroxy\n" +
                    "Hồ sơ lipid\n" +
                    "Kiểm tra chức năng gan"
    };

    HashMap<String ,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBMDAddToCart);
        btnBack = findViewById(R.id.buttonHADBack);
        listView = findViewById(R.id.ListViewHA);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0 ;i < packages.length;i++){
            item = new HashMap<String ,String >();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Tổng cộng :"  +packages[i][4]+ "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5",},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});

        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}