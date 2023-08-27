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

public class BuyMedicineActivity extends AppCompatActivity {

    String [][] packages = {
            {"Uprise-03 1000IU Capsule","","","","50"},
            {"HealthVit Chronium Picolinate 200mcg Capsule","","","","305"},
            {"VitaminB Complex Capsule","","","","448"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
            {"Dolo 650 Tablet ","","","","30"},
            {"Crocin 650 Advance Tablet","","","","50"},
            {"Strepsils Medicated Lozenges for Sore Throat","","","","40"},
            {"Tata 1mg Calcium + Vitamin D3","","","","30"},
            {"Feronia - XT Tablet","","","","130"},
    };

    private String [] package_details = {
            "Bảo vệ và giữ gìn cho xương và răng chắc khỏe\n" +
                    "Reduceing Fatigue/stress and  muscular pain\n" +
                    "Tăng cường khả năng miễn dịch và tăng sức đề kháng chống lại nhiễm trùng",
            "Chronium là một khoáng chất vi lượng thiết yếu có vai trò quan trọng trong việc hỗ trợ insulin",
            "Cung cấp cứu trợ từ sự thiếu hụt vitamin B\n" +
                    "Giúp hình thành các tế bào hồng cầu\n" +
                    "Duy trì sức khỏe hệ thần kinh",
            "Thúc đẩy sức khỏe cũng như lợi ích cho làn da.\n" +
                    "Giúp làm giảm vết thâm và sắc tố da\n" +
                    "Nó hoạt động như bảo vệ da khỏi tia nắng mặt trời UVA và UVB khắc nghiệt.",
            " Dolo Tablet 650 giúp giảm đau và hạ sốt bằng cách ngăn chặn sự giải phóng một số hóa chất",
            "Giúp hạ sốt và hạ nhiệt độ cao\n" +
                    "Thích hợp cho người bị bệnh tim hoặc huyết áp cao",
            "Làm giảm các triệu chứng của nhiễm trùng cổ họng và làm dịu quá trình phục hồi\n" +
                    "Mang lại cảm giác ấm áp và dễ chịu khi bị đau họng",

    };

    HashMap<String,String > item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.ListViewHA);
        btnBack = findViewById(R.id.buttonHADBack);
        btnGoToCart = findViewById(R.id.buttonBMDAddToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i = 0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Tổng cộng " + packages[i][4]+ "-/");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[] {R.id.line_a, R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}