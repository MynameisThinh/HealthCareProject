package org.androidtutorial.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Tên bác sĩ : Trần Minh Tuấn", "Địa chỉ bệnh viện : 183 Lý Thường Kiệt","exp : 5 năm","Số điện thoại : 0318929491","600"},
                    {"Tên bác sĩ : Nguyễn Văn Hoàng", "Địa chỉ bệnh viện : 23 Đinh Tiên Hoàng","exp : 3 năm","Số điện thoại : 0914881831","900"},
                    {"Tên bác sĩ : Võ Thị Thu Thủy", "Địa chỉ bệnh viện : 24 Cách Mạng Tháng Tám","exp : 4 năm","Số điện thoại : 0964818331","300"},
                    {"Tên bác sĩ : Lê Minh Tuyền", "Địa chỉ bệnh viện : 98 Võ Văn Kiệt","exp : 3 năm","Số điện thoại : 0917381233","500"},
                    {"Tên bác sĩ : Ngô Quang Đức", "Địa chỉ bệnh viện : 27 Cộng Hòa","exp : 8 năm","Số điện thoại : 0918282134","800"}
            };

    private String[][] doctor_details2 =
            {
                    {"Tên bác sĩ : Trần Minh Tuấn", "Địa chỉ bệnh viện : 183 Lý Thường Kiệt","exp : 5 năm","Số điện thoại : 0318929491","600"},
                    {"Tên bác sĩ : Nguyễn Văn Hoàng", "Địa chỉ bệnh viện : 23 Đinh Tiên Hoàng","exp : 3 năm","Số điện thoại : 0914881831","900"},
                    {"Tên bác sĩ : Võ Thị Thu Thủy", "Địa chỉ bệnh viện : 24 Cách Mạng Tháng Tám","exp : 4 năm","Số điện thoại : 0964818331","300"},
                    {"Tên bác sĩ : Lê Minh Tuyền", "Địa chỉ bệnh viện : 98 Võ Văn Kiệt","exp : 3 năm","Số điện thoại : 0917381233","500"},
                    {"Tên bác sĩ : Ngô Quang Đức", "Địa chỉ bệnh viện : 27 Cộng Hòa","exp : 8 năm","Số điện thoại : 0918282134","800"}
            };

    private String[][] doctor_details3 =
            {
                    {"Tên bác sĩ : Trần Minh Tuấn", "Địa chỉ bệnh viện : 183 Lý Thường Kiệt","exp : 5 năm","Số điện thoại : 0318929491","600"},
                    {"Tên bác sĩ : Nguyễn Văn Hoàng", "Địa chỉ bệnh viện : 23 Đinh Tiên Hoàng","exp : 3 năm","Số điện thoại : 0914881831","900"},
                    {"Tên bác sĩ : Võ Thị Thu Thủy", "Địa chỉ bệnh viện : 24 Cách Mạng Tháng Tám","exp : 4 năm","Số điện thoại : 0964818331","300"},
                    {"Tên bác sĩ : Lê Minh Tuyền", "Địa chỉ bệnh viện : 98 Võ Văn Kiệt","exp : 3 năm","Số điện thoại : 0917381233","500"},
                    {"Tên bác sĩ : Ngô Quang Đức", "Địa chỉ bệnh viện : 27 Cộng Hòa","exp : 8 năm","Số điện thoại : 0918282134","800"}
            };

    private String[][] doctor_details4 =
            {
                    {"Tên bác sĩ : Trần Minh Tuấn", "Địa chỉ bệnh viện : 183 Lý Thường Kiệt","exp : 5 năm","Số điện thoại : 0318929491","600"},
                    {"Tên bác sĩ : Nguyễn Văn Hoàng", "Địa chỉ bệnh viện : 23 Đinh Tiên Hoàng","exp : 3 năm","Số điện thoại : 0914881831","900"},
                    {"Tên bác sĩ : Võ Thị Thu Thủy", "Địa chỉ bệnh viện : 24 Cách Mạng Tháng Tám","exp : 4 năm","Số điện thoại : 0964818331","300"},
                    {"Tên bác sĩ : Lê Minh Tuyền", "Địa chỉ bệnh viện : 98 Võ Văn Kiệt","exp : 3 năm","Số điện thoại : 0917381233","500"},
                    {"Tên bác sĩ : Ngô Quang Đức", "Địa chỉ bệnh viện : 27 Cộng Hòa","exp : 8 năm","Số điện thoại : 0918282134","800"}
            };

    private String[][] doctor_details5 =
            {
                    {"Tên bác sĩ : Trần Minh Tuấn", "Địa chỉ bệnh viện : 183 Lý Thường Kiệt","exp : 5 năm","Số điện thoại : 0318929491","600"},
                    {"Tên bác sĩ : Nguyễn Văn Hoàng", "Địa chỉ bệnh viện : 23 Đinh Tiên Hoàng","exp : 3 năm","Số điện thoại : 0914881831","900"},
                    {"Tên bác sĩ : Võ Thị Thu Thủy", "Địa chỉ bệnh viện : 24 Cách Mạng Tháng Tám","exp : 4 năm","Số điện thoại : 0964818331","300"},
                    {"Tên bác sĩ : Lê Minh Tuyền", "Địa chỉ bệnh viện : 98 Võ Văn Kiệt","exp: 3 năm","Số điện thoại : 0917381233","500"},
                    {"Tên bác sĩ : Ngô Quang Đức", "Địa chỉ bệnh viện : 27 Cộng Hòa","exp : 8 năm","Số điện thoại : 0918282134","800"}
            };
    TextView tv;
    Button btn;

    String [][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textView_logo4);
        btn = findViewById(R.id.buttonHADBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0){
            doctor_details = doctor_details1;
        }else
        if(title.compareTo("Dietician") == 0){
            doctor_details = doctor_details2;
        }else
        if(title.compareTo("Dentist") == 0){
            doctor_details = doctor_details3;
        }else
        if(title.compareTo("Surgeon") == 0){
            doctor_details = doctor_details4;
        }else
            doctor_details = doctor_details5;

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

            list = new ArrayList<>();
            for(int i = 0;i < doctor_details.length;i++){
                item  = new HashMap<String,String>();
                item.put("line1",doctor_details[i][0]);
                item.put("line2",doctor_details[i][1]);
                item.put("line3",doctor_details[i][2]);
                item.put("line4",doctor_details[i][3]);
                item.put("line5","Cons Fees : " + doctor_details[i][4] + "/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this,list,R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});

        ListView lst = findViewById(R.id.ListViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}