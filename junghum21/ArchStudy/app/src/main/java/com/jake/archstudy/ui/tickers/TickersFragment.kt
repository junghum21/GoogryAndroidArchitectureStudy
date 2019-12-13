package com.jake.archstudy.ui.tickers

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jake.archstudy.R
import com.jake.archstudy.base.BaseFragment
import com.jake.archstudy.data.source.UpbitRepository
import com.jake.archstudy.databinding.FragmentTickersBinding
import com.jake.archstudy.util.ResourceProvider
import javax.inject.Inject

class TickersFragment :
    BaseFragment<FragmentTickersBinding, TickersViewModel>(R.layout.fragment_tickers) {

    @Inject
    lateinit var upbitRepository: UpbitRepository

    @Inject
    lateinit var resourceProvider: ResourceProvider

    override val viewModel by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TickersViewModel(
                    upbitRepository,
                    marketName,
                    resourceProvider
                ) as T
            }
        }).get(TickersViewModel::class.java)
    }

    private val marketName by lazy { arguments?.getString(ARGS_MARKET_NAME) ?: "" }

    companion object {

        const val ARGS_MARKET_NAME = "ARGS_MARKET_NAME"

        fun newInstance(marketName: String): TickersFragment {
            return TickersFragment().apply {
                arguments = bundleOf(ARGS_MARKET_NAME to marketName)
            }
        }
    }
}