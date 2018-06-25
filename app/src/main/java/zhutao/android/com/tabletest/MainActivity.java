package zhutao.android.com.tabletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.define
        chart = (LineChart) findViewById(R.id.chart);
        initLine();

        List<Entry> entries = new ArrayList<Entry>();
        for (int i = 0; i < 10; i++) {
            entries.add(new Entry(i, i));//2.set data
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // description
        //样式
        dataSet.setColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setValueTextColor(getResources().getColor(R.color.colorAccent));
        //设置数据
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh

    }

    private void initLine() {
        //x轴设置
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的位置
        xAxis.setAxisLineColor(getResources().getColor(R.color.colorPrimary));//x轴颜色
//        xAxis.setGridColor(getResources().getColor(R.color.colorPrimary));//x轴网格颜色(垂直线)
//        xAxis.setAxisMaximum(15);
//        xAxis.setDrawAxisLine(false);
//

        // 获得左侧侧坐标轴
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisLineColor(getResources().getColor(R.color.colorPrimary));//y轴颜色
        //添加限制线（特定值的线）
        // 设置y轴的LimitLine
        LimitLine yLimitLine = new LimitLine(5, "yLimit 测试");
        yLimitLine.setLineColor(getResources().getColor(R.color.colorAccent));
        yLimitLine.setTextColor(getResources().getColor(R.color.colorAccent));
        leftAxis.addLimitLine(yLimitLine);
//        leftAxis.setAxisMaximum(15);
//        YAxis rightAxis = chart.getAxisRight();
//        leftAxis.setDrawAxisLine(false);
//        rightAxis.setDrawAxisLine(false);
    }

}
