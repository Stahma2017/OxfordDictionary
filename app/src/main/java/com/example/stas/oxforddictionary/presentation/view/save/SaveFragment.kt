package com.example.stas.oxforddictionary.presentation.view.save


import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.stas.oxforddictionary.App
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.data.database.AppDatabase
import javax.inject.Inject

class SaveFragment : Fragment(), SaveContract.View {

    @Inject
    lateinit var presenter : SaveContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_save, container, false)
        (activity!!.application as App).createSaveComponent().injectSaveFragment(this)
        presenter.attachView(this)

       presenter.fetchSavedWords()




        return view
    }


    override fun showError(errorMessage: String) {
       Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}
