package com.example.admin.nav1.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.admin.nav1.R;

public class ScrollViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.scrollview_fragment, container,false);
    TextView textView = view.findViewById(R.id.textView4);
    textView.setText(" Google уже санкционировала выпуск «умных» колонок и дисплеев со своим ассистентом, но теперь, видимо, компания предпочла заняться решением сама. Новый отчет от Nikkei утверждает, что Google планирует запустить собственный дисплей с голосовым ассистентом. Впрочем, особого энтузиазма тут испытывать не стоит — речь идет всего лишь об «умной» колонке, которая комплектуется экраном.Умные колонки с дисплеями (или «умные дисплеи») предлагают ряд очевидных преимуществ. Экран позволяет легко менять настройки, искать информацию, изучать рецепты или смотреть видео. Но несмотря на эти преимущества, конкурировать с планшетами и ноутбуками новый тип устройств пока не может (разве что на кухне у хозяйки «умного» дома).Google даже разработала для них специальную платформу, и JBL, Lenovo, LG и Sony уже готовят свои «умные» дисплеи, а первый из них — от Lenovo — уже вышел на рынок. Впрочем, пока это все довольно нишевые устройства и «бума» на рынке не делают. Будем надеяться, что устройство от Google сможет это изменить.");

    return view;

    }
}
