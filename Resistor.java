package com.eka.Resist;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;



public class Resistor extends Activity implements View.OnClickListener
 {

    public Double band1, band2, band3, band4, band5,tole, OHM;
    public TextView textOhm ,textOhmTole, textValue , textTole, textNu;
    public Button Hesapla;
    public ImageButton  Band1,Band2,Band3,Band4;
    public Spinner spinner1,spinner2;
    public ImageView ResLeft,ResBand1,ResBand2,ResBand3,ResBand4,ResTole,Resright;
    public  String sBand,sRenk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resistor);

       Tanimlar();
       Spinner1();
       Spinner2();
  //     Renkleri_Yerlestir();



        Hesapla= (Button) findViewById(R.id.BtnHesap);
        Hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Hesap();
                Birimi_Belirle();
                Yazdir();

            }
        });

    }
    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.imgresband1:  textNu.setText("1");  sBand="1"; break;
            case R.id.imgresband2:  textNu.setText("2");  sBand="2"; break;
            case R.id.imgresband3:  textNu.setText("3");  sBand="3"; break;
            case R.id.imgrestole:   textNu.setText("4");  sBand="4"; break;
        }
    }
    public void Tanimlar() {

        OHM=1.0;  band1=1.0; band2=1.0; band3= 1.0;  band4=0.05; band5=1.0; tole=1.0;

        textOhm  =(TextView) findViewById(R.id.textOhm);
      textOhmTole=(TextView) findViewById(R.id.textOhmTole);
        textValue=(TextView) findViewById(R.id.textValue);
        textTole =(TextView) findViewById(R.id.textTole);
        textNu   =(TextView) findViewById(R.id.textNu);

   //     ResLeft  =(ImageView)findViewById(R.id.imgresleft);
        ResBand1 =(ImageView)findViewById(R.id.imgresband1);
        ResBand2 =(ImageView)findViewById(R.id.imgresband2);
        ResBand3 =(ImageView)findViewById(R.id.imgresband3);
        ResTole =(ImageView)findViewById(R.id.imgrestole);
   //     Resright =(ImageView)findViewById(R.id.imgresright);

   /// Renkli şerit Butonlar

        Band1 = (ImageButton) findViewById(R.id.imgresband1);
        Band2 = (ImageButton) findViewById(R.id.imgresband2);
        Band3 = (ImageButton) findViewById(R.id.imgresband3);
        Band4 = (ImageButton) findViewById(R.id.imgrestole);

        Band1.setOnClickListener(this);
        Band2.setOnClickListener(this);
        Band3.setOnClickListener(this);
        Band4.setOnClickListener(this);


      /* */
    }
    public void Spinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinnerBand);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.Band1,android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView <?> arg0, View arg1, int arg2, long arg3) {

               sBand = spinner1.getItemAtPosition(arg2).toString();
               textNu.setText(sBand);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


    }
    public void Spinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinnerRenk);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Renkler,android.R.layout.simple_list_item_1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView <?> arg0, View arg1, int renk, long arg3) {

                // Seçtiğin rengi REsim olarak görmek için uygun kodları buraya yaz. int değerini yani arg2 yi kullan
                sRenk = spinner2.getItemAtPosition(renk).toString();

                //Spinnerda neyi seçmişiz en son

                //       textTole.setText(sRenk);
                // Spinner deki Rengi Resme aktarmak
                Renkleri_Yerlestir();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
/**/
    }
    public void Renkleri_Yerlestir() {
        // Spinner deki Rengi Resme aktarmak

        if (sBand.equals("1")) {

                 if (sRenk.equals("Siyah")||sRenk.equals("Black"))   {ResBand1.setImageResource(R.drawable.band_k1); band1=0.0;}
            else if (sRenk.equals("Kahve")||sRenk.equals("Brown"))   {ResBand1.setImageResource(R.drawable.band_n1); band1=1.0;}
            else if (sRenk.equals("Kırmızı")||sRenk.equals("Red")) {ResBand1.setImageResource(R.drawable.band_r1); band1=2.0;}
            else if (sRenk.equals("Turuncu")||sRenk.equals("Orange")) {ResBand1.setImageResource(R.drawable.band_o1); band1=3.0;}
            else if (sRenk.equals("Sarı")||sRenk.equals("Yellow"))    {ResBand1.setImageResource(R.drawable.band_y1); band1=4.0;}
            else if (sRenk.equals("Yeşil")||sRenk.equals("Green"))   {ResBand1.setImageResource(R.drawable.band_g1); band1=5.0;}
            else if (sRenk.equals("Mavi")||sRenk.equals("Blue"))    {ResBand1.setImageResource(R.drawable.band_b1); band1=6.0;}
            else if (sRenk.equals("Mor")||sRenk.equals("Purple"))     {ResBand1.setImageResource(R.drawable.band_v1); band1=7.0;}
            else if (sRenk.equals("Gri")||sRenk.equals("Grey"))     {ResBand1.setImageResource(R.drawable.band_a1); band1=8.0;}
            else if (sRenk.equals("Beyaz")||sRenk.equals("White"))   {ResBand1.setImageResource(R.drawable.band_w1); band1=9.0;}

        }else if (sBand.equals("2")) {

                 if (sRenk.equals("Siyah")||sRenk.equals("Black"))   {ResBand2.setImageResource(R.drawable.band_k2); band2=0.0;}
            else if (sRenk.equals("Kahve")||sRenk.equals("Brown"))   {ResBand2.setImageResource(R.drawable.band_n2); band2=1.0;}
            else if (sRenk.equals("Kırmızı")||sRenk.equals("Red")) {ResBand2.setImageResource(R.drawable.band_r2); band2=2.0;}
            else if (sRenk.equals("Turuncu")||sRenk.equals("Orange")) {ResBand2.setImageResource(R.drawable.band_o2); band2=3.0;}
            else if (sRenk.equals("Sarı")||sRenk.equals("Yellow"))    {ResBand2.setImageResource(R.drawable.band_y2); band2=4.0;}
            else if (sRenk.equals("Yeşil")||sRenk.equals("Green"))   {ResBand2.setImageResource(R.drawable.band_g2); band2=5.0;}
            else if (sRenk.equals("Mavi")||sRenk.equals("Blue"))    {ResBand2.setImageResource(R.drawable.band_b2); band2=6.0;}
            else if (sRenk.equals("Mor")||sRenk.equals("Purple"))     {ResBand2.setImageResource(R.drawable.band_v2); band2=7.0;}
            else if (sRenk.equals("Gri")||sRenk.equals("Grey"))     {ResBand2.setImageResource(R.drawable.band_a2); band2=8.0;}
            else if (sRenk.equals("Beyaz")||sRenk.equals("White"))   {ResBand2.setImageResource(R.drawable.band_w2); band2=9.0;}

        }else if (sBand.equals("3")) {

                 if (sRenk.equals("Siyah")||sRenk.equals("Black"))   {ResBand3.setImageResource(R.drawable.band_k3); band3=0.0;}
            else if (sRenk.equals("Kahve")||sRenk.equals("Brown"))   {ResBand3.setImageResource(R.drawable.band_n3); band3=1.0;}
            else if (sRenk.equals("Kırmızı")||sRenk.equals("Red")) {ResBand3.setImageResource(R.drawable.band_r3); band3=2.0;}
            else if (sRenk.equals("Turuncu")||sRenk.equals("Orange")) {ResBand3.setImageResource(R.drawable.band_o3); band3=3.0;}
            else if (sRenk.equals("Sarı")||sRenk.equals("Yellow"))    {ResBand3.setImageResource(R.drawable.band_y3); band3=4.0;}
            else if (sRenk.equals("Yeşil")||sRenk.equals("Green"))   {ResBand3.setImageResource(R.drawable.band_g3); band3=5.0;}
            else if (sRenk.equals("Mavi")||sRenk.equals("Blue"))    {ResBand3.setImageResource(R.drawable.band_b3); band3=6.0;}
            else if (sRenk.equals("Mor")||sRenk.equals("Purple"))     {ResBand3.setImageResource(R.drawable.band_v3); band3=7.0;}
            else if (sRenk.equals("Gri")||sRenk.equals("Grey"))     {ResBand3.setImageResource(R.drawable.band_a3); band3=8.0;}
            else if (sRenk.equals("Beyaz")||sRenk.equals("White"))   {ResBand3.setImageResource(R.drawable.band_w3); band3=9.0;}
            else if (sRenk.equals("Altın")||sRenk.equals("Gold"))   {ResBand3.setImageResource(R.drawable.band_d3); band3=0.1;}
            else if (sRenk.equals("Gümüş")||sRenk.equals("Silver"))   {ResBand3.setImageResource(R.drawable.band_s3); band3=0.01;}

        }else if (sBand.equals("4")) {


                 if (sRenk.equals("Kahve")||sRenk.equals("Brown"))   {ResTole.setImageResource(R.drawable.band_n3); band4=0.01;}
            else if (sRenk.equals("Kırmızı")||sRenk.equals("Red")) {ResTole.setImageResource(R.drawable.band_r3); band4=0.02;}
            else if (sRenk.equals("Yeşil")||sRenk.equals("Green"))   {ResTole.setImageResource(R.drawable.band_g3); band4=0.005;}
            else if (sRenk.equals("Mavi")||sRenk.equals("Blue"))    {ResTole.setImageResource(R.drawable.band_b3); band4=0.0025;}
            else if (sRenk.equals("Mor")||sRenk.equals("Purple"))     {ResTole.setImageResource(R.drawable.band_v3); band4=0.001;}
            else if (sRenk.equals("Gri")||sRenk.equals("Grey"))     {ResTole.setImageResource(R.drawable.band_a3); band4=0.0005;}
            else if (sRenk.equals("Altın")||sRenk.equals("Gold"))   {ResTole.setImageResource(R.drawable.band_mult_g); band4=0.05;}
            else if (sRenk.equals("Gümüş")||sRenk.equals("Silver"))   {ResTole.setImageResource(R.drawable.band_mult_s); band4=0.1;}
            else if (sRenk.equals("Renksiz")||sRenk.equals("None")) {ResTole.setImageResource(R.drawable.band_mult_n); band4=0.2;}
        }
    }
    public void Hesap() {

       OHM=((band1*10)+band2)*(Math.pow(10,band3));
       tole= OHM*band4;
    }
    public void Birimi_Belirle() {
//   TextOhm u düzenle birimi belirt
              if (OHM>=1000000){ textOhm.setText("mΩ");    OHM =OHM/1000000 ;
        }else if (OHM>=1000){    textOhm.setText("kΩ");    OHM =OHM/1000 ;
        } else {                textOhm.setText("Ω");                        }


//   TextOhmTole toleransın birimini düzenle  belirt
              if (tole>=1000000){ textOhmTole.setText("mΩ");   tole =tole/1000000 ;
        }else if (tole>=1000){    textOhmTole.setText("kΩ");   tole =tole/1000 ;
        } else {                 textOhmTole.setText("Ω");                        }

    }
    public void Yazdir() {
     //  textNu.setText(sBand);
        textValue.setText(String.valueOf(OHM));
        textTole.setText(String.valueOf(tole));

    }



}
