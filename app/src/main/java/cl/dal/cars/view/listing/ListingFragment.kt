package cl.dal.cars.view.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import cl.dal.cars.MyViewModel
import cl.dal.cars.databinding.FragmentListingBinding
import timber.log.Timber

class ListingFragment: Fragment() {

    private lateinit var binding: FragmentListingBinding

    private val viewModel by viewModels<MyViewModel>()

    private lateinit var adapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(inflater)

        initViews()

        registerObservers()

        return binding.root
    }

    private fun initViews() {
        adapter = CarAdapter()
        binding.rvCarList.adapter = adapter
        binding.rvCarList.layoutManager = GridLayoutManager(context, 1)
    }

    private fun registerObservers() {
        viewModel.getCars()

        viewModel.carList.observe(viewLifecycleOwner) {
            it?.let {
                adapter.update(it)
            }
        }
    }
}