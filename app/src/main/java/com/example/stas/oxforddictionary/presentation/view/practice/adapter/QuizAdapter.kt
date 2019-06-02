package com.example.stas.oxforddictionary.presentation.view.practice.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stas.oxforddictionary.presentation.view.practice.QuizCard
import kotlinx.android.synthetic.main.layout_quiz_card.view.*

class QuizAdapter(private var context: Context?) : PagerAdapter() {


    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 === p1
    }

    override fun getCount(): Int {
        return QuizCard.values().size
    }



    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val resources = QuizCard.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(resources.layoutResourceId, container, false)
        layout.tag = "quiz$position"
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ViewGroup)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val customPagerEnum = QuizCard.values()[position]
        return context?.getString(customPagerEnum.titleResourceId)
    }

}