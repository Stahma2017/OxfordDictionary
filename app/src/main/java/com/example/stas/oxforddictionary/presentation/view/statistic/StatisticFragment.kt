package com.example.stas.oxforddictionary.presentation.view.statistic


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import kotlinx.android.synthetic.main.fragment_statistic.*
import javax.inject.Inject

class StatisticFragment : Fragment(), StatisticContract.View {

    @Inject
    lateinit var presenter: StatisticContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_statistic, container, false)
        (activity!!.application as App).createStatisticComponent().injectStatisticFragment(this)
        presenter.attachView(this)
        presenter.fetchStatistic()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.fetchStatistic()
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showStatistic(list: List<WeekStatisticModel>) {
        val statList = arrayOf(
                DataPoint(1.0, 0.0),
                DataPoint(2.0, 0.0),
                DataPoint(3.0, 0.0),
                DataPoint(4.0, 0.0),
                DataPoint(5.0, 0.0),
                DataPoint(6.0, 0.0),
                DataPoint(7.0, 0.0))

        list.forEach {
            statList[it.id!!.toInt()] = DataPoint(it.id.toDouble(), it.count.toDouble())
        }

        val staticLabelsFormatter = StaticLabelsFormatter(graphView)
        staticLabelsFormatter.setHorizontalLabels(arrayOf("Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Cб"))
        graphView.gridLabelRenderer.labelFormatter = staticLabelsFormatter

        val series = BarGraphSeries(statList)
        graphView.title = "количество угаданных слов за неделю"
        graphView.titleTextSize = 55f
        graphView.addSeries(series)
        graphView.onDataChanged(true, false)
    }
}
