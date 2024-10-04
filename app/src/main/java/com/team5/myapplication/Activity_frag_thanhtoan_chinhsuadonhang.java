package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_frag_thanhtoan_chinhsuadonhang extends AppCompatActivity {

    ImageView imvBack, imvBackPayment, btnSuaTT;
    CheckBox chkThongTin;
    EditText edtTen, edtHo, edtDiaChi;
    TextView txtQuayLaiGioHang;
    Button btnHinhThucVanChuyen;
    SwitchCompat btn_swt_on_off;

    String selectedTinh, selectedHuyen, selectedXa;
    Spinner tinhSpinner, huyenSpinner, xaSpinner;
    ArrayAdapter<CharSequence> tinhAdapter, huyenAdapter, xaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_thanhtoan_chinhsuadonhang);

        linkViews();
        loadData();
        addEvent();
    }

    private void linkViews() {
        imvBack = findViewById(R.id.imvBack);
        imvBackPayment = findViewById(R.id.imvBackPayment);

        btnSuaTT = findViewById(R.id.btnSuaTT);
        btnHinhThucVanChuyen = findViewById(R.id.btnHinhThucVanChuyen);

        chkThongTin = findViewById(R.id.chkThongTin);

        edtTen = findViewById(R.id.edtTen);
        edtHo = findViewById(R.id.edtHo);
        edtDiaChi = findViewById(R.id.edtDiaChi);

        txtQuayLaiGioHang = findViewById(R.id.txtQuayLaiGioHang);

        btn_swt_on_off = findViewById(R.id.btn_swt_on_off);

        tinhSpinner = findViewById(R.id.spTinh);
        huyenSpinner = findViewById(R.id.spHuyen);
        xaSpinner = findViewById(R.id.spXa);

    }

    private void loadData() {
        tinhAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_tinh, R.layout.fragment_spinner_layout);
        tinhAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tinhSpinner.setAdapter(tinhAdapter);
        tinhSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*tìm thành phố, huyện */
                huyenSpinner = findViewById(R.id.spHuyen);
                selectedTinh = tinhSpinner.getSelectedItem().toString();

                int parentID = parent.getId();
                if (parentID == R.id.spTinh) {
                    switch (selectedTinh) {
                        case "Thành phố/ Tỉnh thành (*)":
                            huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.arrray_default_huyen, R.layout.fragment_spinner_layout);
                            break;
                        case "Đắk Lắk":
                            huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_daklak_huyen, R.layout.fragment_spinner_layout);
                            break;
                        case "Hà Nam":
                            huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_hanam_huyen, R.layout.fragment_spinner_layout);
                            break;
                        case "An Giang":
                            huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_angiang_huyen, R.layout.fragment_spinner_layout);
                            break;
                        default:
                            break;
                    }

                    //selected huyen --> xa
                    huyenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    huyenSpinner.setAdapter(huyenAdapter);
                    huyenSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            //tìm xã
                            xaSpinner = findViewById(R.id.spXa);
                            selectedHuyen = huyenSpinner.getSelectedItem().toString();

                            int parentID = parent.getId();
                            if (parentID == R.id.spHuyen) {
                                switch (selectedHuyen) {
                                    case "Quận/ Huyện (*)":
                                        xaAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.arrray_default_xa, R.layout.fragment_spinner_layout);
                                        break;
                                    case "Thành phố Long Xuyên":
                                        xaAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.array_angiang_thanhpholongxuyen_xa, R.layout.fragment_spinner_layout);
                                        break;
                                    default:
                                        break;
                                }

                                xaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                xaSpinner.setAdapter(xaAdapter);

                                xaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedXa = xaSpinner.getSelectedItem().toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_frag_thanhtoan_chinhsuadonhang.this, Activity_ThanhToan_TTDC.class));
            }
        });

        btnSuaTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_frag_thanhtoan_chinhsuadonhang.this, Activity_TaiKhoanCuaToi.class));
            }
        });

        imvBackPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_frag_thanhtoan_chinhsuadonhang.this, Activity_GioHang.class));
            }
        });

//        //kiểm tra đã chọn Tỉnh hay chưa
//        tinhSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                return;
//            }
//        });

        btnHinhThucVanChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kiểm tra điều kiện cho Tên:
                String ten = edtTen.getText() + "";
                ten = ten.trim();
                if (ten.length() < 3) {
                    edtTen.requestFocus(); //để kiểm tra Tên đủ điều kiện hay chưa
                    edtTen.selectAll();
                    Toast.makeText(Activity_frag_thanhtoan_chinhsuadonhang.this, "Tên phải chứa từ 3 ký tự trở lên", Toast.LENGTH_SHORT).show();
                    return;
                }

                //kiểm tra điều kiện cho họ
                String ho = edtHo.getText() + "";
                ho = ho.trim();
                if (ho.length() < 2) {
                    edtHo.requestFocus(); //để kiểm tra Họ đủ điều kiện hay chưa trước khi kiểm tra Họ
                    edtHo.selectAll();
                    Toast.makeText(Activity_frag_thanhtoan_chinhsuadonhang.this, "Họ phải chứa từ 2 ký tự trở lên", Toast.LENGTH_SHORT).show();
                    return;
                }

                //kiểm tra Địa chỉ phải có giá trị
                if (edtDiaChi.getText().toString().length() == 0) {
                    edtDiaChi.setError("Bạn chưa nhập địa chỉ");
                    Toast.makeText(Activity_frag_thanhtoan_chinhsuadonhang.this, "Bạn chưa nhập địa chỉ!", Toast.LENGTH_SHORT).show();
                    return;
                }

                startActivity(new Intent(Activity_frag_thanhtoan_chinhsuadonhang.this, Activity_VanChuyen.class));
            }
        });
    }
}


//        btn_swt_on_off.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCheckedChanged();
//            }
//        });

//        edtTen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String ten = edtTen.getText() + "";
//                ten = ten.trim();
//                if (ten.length() < 3){
////                    edtTen.requestFocus(); //để kiểm tra Tên đủ điều kiện hay chưa
////                    edtTen.selectAll();
//                    Toast.makeText(Activity_frag_thanhtoan_chinhsuadonhang.this, "Tên phải chứa từ 3 ký tự trở lên", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//        });
//
//        edtHo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String ho = edtHo.getText() + "";
//                ho = ho.trim();
//                if (ho.length() < 2){
//                    edtHo.requestFocus(); //để kiểm tra Họ đủ điều kiện hay chưa
//                    edtHo.selectAll();
//                    Toast.makeText(Activity_frag_thanhtoan_chinhsuadonhang.this, "Họ phải chứa từ 2 ký tự trở lên", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//        });
//    }

//    private void onCheckedChanged() {
//
//    }
//}