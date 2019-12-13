package com.jake.archstudy.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jake.archstudy.R
import com.jake.archstudy.base.BaseActivity
import com.jake.archstudy.data.model.Market
import com.jake.archstudy.data.source.UpbitRepository
import com.jake.archstudy.databinding.ActivityMainBinding
import com.jake.archstudy.ui.tickers.TickersFragment
import com.jake.archstudy.util.ResourceProvider
import javax.inject.Inject

class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    @Inject
    lateinit var upbitRepository: UpbitRepository

    @Inject
    lateinit var resourceProvider: ResourceProvider

    private val viewModelFactory by lazy {
        MainViewModelFactory(upbitRepository, resourceProvider)
    }

    override val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTabLayout()
        observeMarkets()
    }

    private fun observeMarkets() {
        viewModel.markets.observe(
            this,
            Observer { setViewPager(it) }
        )
    }

    private fun setViewPager(markets: List<Market>) {
        binding.vpContent.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int) =
                TickersFragment.newInstance(markets[position].markets)

            override fun getCount() = markets.size

            override fun getPageTitle(position: Int) = markets[position].title
        }
    }

    private fun initTabLayout() {
        binding.tlMarket.setupWithViewPager(binding.vpContent)
    }
}