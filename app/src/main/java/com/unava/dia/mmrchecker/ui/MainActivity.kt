package com.unava.dia.mmrchecker.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.unava.dia.mmrchecker.R
import com.unava.dia.mmrchecker.utils.GlideUtil
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        this.bindViewModel()

        buttonSearchPlayer.setOnClickListener {
            viewModel.fetchAccInfo(etPlayerId.text.toString())
        }
    }

    private fun bindViewModel() {
        this.viewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
        this.observeViewModel()
    }

    private fun observeViewModel() {
        this.viewModel.requestError.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
        this.viewModel.accInfo.observe(this, Observer {
            GlideUtil.setPlayerIcon(playerIcon, it?.profile?.avatarfull.toString())
            textViewEstimatedMmr.text = it?.mmr_estimate?.estimate.toString()
            textViewSoloMmr.text = it?.solo_competitive_rank
            textViewPartyMmr.text = it?.competitive_rank
        })
    }
}
