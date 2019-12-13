package com.jake.archstudy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.jake.archstudy.ext.toast
import dagger.android.support.DaggerFragment

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes
    private val layoutId: Int
) : DaggerFragment() {

    protected lateinit var binding: B

    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.toast.observe(viewLifecycleOwner, Observer { toast(it) })
    }
}