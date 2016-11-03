package com.igpsport.testpolylineencoderdecoder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.igpsport.gmap.LatLng;
import com.igpsport.gmap.PolylineDecoder;
import com.igpsport.gmap.PolylineEncoder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editSrc, editOutput;
    private Button btnEnc, btnDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editOutput = (EditText) findViewById(R.id.edtOutput);
        editSrc = (EditText) findViewById(R.id.edtPoints);
        btnDec = (Button) findViewById(R.id.btnDecode);
        btnEnc = (Button) findViewById(R.id.btnEncode);

        btnEnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editOutput.setText("");
                List<LatLng> latLngs = new ArrayList<>();
                String pts = editSrc.getText().toString();
                String[] seqs = pts.split(";");
                for (String seq : seqs) {
                    String[] ptar = seq.split(",");
                    if (ptar.length != 2) continue;
                    LatLng latLng = new LatLng(Double.parseDouble(ptar[0]), Double.parseDouble(ptar[1]));
                    latLngs.add(latLng);
                }
                String result = PolylineEncoder.encode(latLngs);
                editOutput.setText(result);
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSrc.setText("");
                List<LatLng> lss = PolylineDecoder.decode(editOutput.getText().toString());
                for (LatLng ll : lss) {
                    editSrc.append(ll.toString() + ";");
                }
            }
        });

    }
}
